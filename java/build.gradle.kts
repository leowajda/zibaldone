import com.diffplug.gradle.spotless.SpotlessExtension
import com.diffplug.spotless.LineEnding

plugins {
    id("java")
    id("com.diffplug.spotless") version "8.11.0" apply false
}

group = "com.zibaldone"
version = "1.0-SNAPSHOT"

subprojects {
    repositories {
        mavenCentral()
    }

    plugins.withId("java") {
        apply(plugin = "com.diffplug.spotless")

        extensions.configure<SpotlessExtension> {
            java {
                targetExclude(layout.buildDirectory)
                lineEndings = LineEnding.UNIX
                eclipse("4.41").configFile(rootProject.file("eclipse-formatter.xml"))
                importOrder("#", "")
                trimTrailingWhitespace()
                endWithNewline()
            }
        }
    }
}
