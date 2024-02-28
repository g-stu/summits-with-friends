plugins {
    id("java")
    id("io.freefair.lombok") version "8.6"
}

group = "org.summits"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.jsoup:jsoup:1.11.1")
}

tasks.test {
    useJUnitPlatform()
}