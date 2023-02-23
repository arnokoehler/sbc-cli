# sbc-cli
spring boot crud cli for generating dev.akif:spring-boot-crud projects



## TODO Brew installer

To package your Kotlin application as a Homebrew formula, you can follow these general steps:

1. Build your Kotlin application into an executable JAR file. You can use a build tool like Gradle or Maven to do this.

2. Create a Homebrew formula file. This is a Ruby file that tells Homebrew how to install your application.

3. Add the URL of your JAR file to the formula file. This tells Homebrew where to download the JAR file from.

4. Define the dependencies of your application in the formula file. This tells Homebrew which packages your application requires to run.

5. Use the bin.install method to copy your JAR file to the Homebrew bin directory, and create a wrapper script that runs the JAR file with the appropriate dependencies.

6. Test the formula by running brew install <formula> on a test machine.

Here's an example of what the Homebrew formula file might look like for a simple Kotlin application:

```ruby
class MyKotlinApp < Formula
desc "My Kotlin application"
homepage "https://example.com/my-kotlin-app"
url "https://example.com/my-kotlin-app/my-kotlin-app.jar"
sha256 "abc123def456"

depends_on "openjdk"

def install
libexec.install "my-kotlin-app.jar"
bin.write_jar_script libexec/"my-kotlin-app.jar", "my-kotlin-app"
end

test do
system "#{bin}/my-kotlin-app", "--version"
end
end

```
This formula downloads the JAR file from https://example.com/my-kotlin-app/my-kotlin-app.jar, installs OpenJDK as a dependency, and creates a wrapper script that runs the JAR file with the correct classpath. The test method is a simple test that runs the application and checks that it prints its version number.

Once you've created the formula file, you can add it to a tap or submit it to the main Homebrew repository by following the instructions on the Homebrew website.

see: https://docs.brew.sh/Formula-Cookbook


# Man Page

1. Write a man page in man format, using a text editor. The man page should describe the usage and functionality of your program.

2. Convert the man page to a compressed format using the gzip command. For example, if your man page is in a file called mycommand.1, you can run the following command to compress it:

```bash
gzip mycommand.1
```
This will create a compressed file called mycommand.1.gz.

3. Copy the compressed man page to the appropriate location on the target Linux system. The location may vary depending on the Linux distribution and the version of the man program, but a common location is /usr/share/man/man1/. You can copy the man page using the cp command, like this:

```bash
cp mycommand.1.gz /usr/share/man/man1/
```

4. Update the man page index to include your new man page. You can do this by running the mandb command with appropriate privileges (e.g., using sudo). The mandb command will update the man page database and include your new man page in the index. For example:

```bash
sudo mandb
```

This may take some time to run, especially if there are many man pages on the system.

Once you've completed these steps, users can view your man page by running the man command with the appropriate section and name of your command. For example, if your program is called mycommand and you've added a man page in section 1, users can run:

```bash
man 1 mycommand
```

This will display your man page in the terminal. Users can use the usual man page navigation commands (e.g., j and k to move up and down, q to quit) to view the contents of the man page.


# Creating a Spring Boot skeleton via this cli 

If you want to call another command-line program from your own CLI program, you can use the ProcessBuilder class in Java or Kotlin.

Here's an example of how you can call the ls command from your CLI program in Kotlin:

```kotlin
import java.lang.ProcessBuilder

fun main(args: Array<String>) {
    val processBuilder = ProcessBuilder("ls", "-l")
    val process = processBuilder.start()

    // Read the output from the child process
    val input = process.inputStream.bufferedReader()
    val output = input.readText()

    // Wait for the child process to complete
    val exitCode = process.waitFor()

    // Print the output and exit code
    println("Output: $output")
    println("Exit code: $exitCode")
}
```

In this example, we create a new ProcessBuilder instance and pass the command and its arguments as a list of strings. We then call the start() method on the ProcessBuilder instance to start the child process.

We then read the output from the child process using the inputStream property of the Process instance, and wait for the child process to complete using the waitFor() method.

Finally, we print the output and exit code of the child process.

You can modify this code to call any command-line program that you want from your own CLI program, simply by changing the command and its arguments in the ProcessBuilder constructor.

Note that calling another CLI program from your own CLI program may have security implications, especially if the command and its arguments are passed directly from user input. Be sure to sanitize and validate any user input before passing it to the ProcessBuilder constructor to prevent potential security vulnerabilities.

### TODO add the dependecy to the ruby script:

See if we can include the spring boot cli https://docs.spring.io/spring-boot/docs/current/reference/html/cli.html#cli-installation
as a dependency in the brew formula

```ruby
depends_on "<spring-boot-cli>"
```