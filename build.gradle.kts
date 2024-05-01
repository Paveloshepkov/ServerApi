plugins {
    id("java")
    id("war")
}

group = "ru.novosoft"
version = "1.0-SNAPSHOT"

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.forkOptions.jvmArgs = listOf("-Dfile.encoding=UTF-8")
}

repositories {
    mavenCentral()
}

dependencies {
    // Spring Framework
    implementation("org.springframework:spring-context:3.2.18.RELEASE")
    implementation("org.springframework:spring-web:3.2.18.RELEASE")
    implementation("org.springframework:spring-webmvc:3.2.18.RELEASE")

    // Spring Security
    implementation("org.springframework.security:spring-security-web:3.1.3.RELEASE")
    implementation("org.springframework.security:spring-security-config:3.1.3.RELEASE")
    implementation("javax.servlet:javax.servlet-api:4.0.1")

    // Java JWT
    implementation("com.auth0:java-jwt:3.18.1")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.6.10")

    // Добавляем зависимости Jackson
    implementation("com.fasterxml.jackson.core", "jackson-databind", "2.13.0")
    implementation("com.fasterxml.jackson.core", "jackson-annotations", "2.13.0")
    implementation("com.fasterxml.jackson.core", "jackson-core", "2.13.0")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.13.1")
    implementation("com.fasterxml.jackson.module:jackson-module-parameter-names:2.13.1")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.13.1")


    implementation("org.apache.httpcomponents", "httpclient", "4.5.13")

    implementation("ch.qos.logback:logback-classic:1.2.6")
}

tasks.test {
    useJUnitPlatform()
}