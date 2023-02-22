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