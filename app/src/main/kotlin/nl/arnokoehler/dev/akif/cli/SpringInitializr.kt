package nl.arnokoehler.dev.akif.cli

import org.apache.commons.io.IOUtils
import org.apache.commons.lang3.StringUtils
import org.apache.commons.lang3.exception.ExceptionUtils
import java.io.*
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream

class SpringInitializr() {

    fun handleInput(rawInput: RawInput): ApplicationParameters {
        val targetDir = rawInput.targetDir ?: throw IllegalArgumentException("Target directory cannot be empty")
        var languageVariant: LanguageVariant? = null
        var packageName: String? = null
        var mainPath: String? = null

        try {
            ZipInputStream(
                FileInputStream(
                    rawInput.initializrZip
                        ?: throw IllegalStateException("Only invoke SpringInitializr input handler when `initializrZip` is set")
                )
            )
                .use { zis ->
                    var ze: ZipEntry?
                    while (zis.nextEntry.also { ze = it } != null) {
                        val filePath = StringUtils.substringAfter(ze!!.name, "/")
                        val fileName = StringUtils.substringAfterLast(StringUtils.stripEnd(filePath, "/"), "/")
                        val file = File(targetDir, filePath)
                        val dir = if (ze!!.isDirectory) file else file.parentFile

                        println("Processing $ze fileName: $fileName filePath: $filePath file: $file")

                        if (!dir.isDirectory && !dir.mkdirs())
                            throw FileNotFoundException("Invalid path: " + dir.absolutePath)
                        if (file.isDirectory) {
                            if (file.parentFile.endsWith("main")) {
                                try {
                                    languageVariant = LanguageConverter().convert(fileName)
                                    mainPath = filePath;
                                    println("Detected language: $languageVariant")
                                } catch (_: IllegalArgumentException) {
                                }
                            }
                        } else {
                            if (mainPath != null && filePath.startsWith(mainPath!!) && packageName == null) {
                                println("Detecting package from $filePath")
                                packageName = StringUtils.replaceChars(
                                    StringUtils.substringBeforeLast(
                                        StringUtils.substringAfter(filePath, mainPath),
                                        "/"
                                    ),
                                    "/", "."
                                )
                                println("Detected package: $packageName")
                            }
                            FileOutputStream(file).use {
                                IOUtils.copy(zis, it)
                            }
                        }
                    }
                }
        } catch (e: IOException) {
            println(String.format("Unable to read from %s: %s", rawInput.initializrZip, ExceptionUtils.getRootCause(e)))
        }

        return ApplicationParameters(
            languageVariant = languageVariant!!,
            resourceName = ResourceNameInputHandler().handleInput(rawInput.resourceName),
            packageName = SubPackageNameInputHandler(packageName ?: throw java.lang.IllegalStateException("Could not extract base package from zip")).handleInput(rawInput.packageName),
            variantStyle = VariantStyleInputHandler().handleInput(rawInput.variantStyle),
            targetDir = rawInput.targetDir ?: throw IllegalArgumentException("Target directory cannot be empty")
        )
    }

}

class SubPackageNameInputHandler(val defaultValue: String) : InputHandler<String>() {

    override fun handleInput(input: String?): String {
        println("Please provide a subpackage name (after $defaultValue)")
        val packageName = readlnOrNull() ?: ""
        println("Full package name set to: $defaultValue.$packageName")
        return "$defaultValue.$packageName"
    }
}