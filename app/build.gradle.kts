plugins {
	java
	id("application")
	id("org.springframework.boot") version "3.4.3"
	id("io.spring.dependency-management") version "1.1.7"
	id("checkstyle")
	id("org.sonarqube") version "6.0.1.5171"
}

group = "hexlet.code"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}
application {
	mainClass = "hexlet.code.AppApplication"
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

}

tasks.withType<Test> {
	useJUnitPlatform()
}
//tasks.test {
   // useJUnitPlatform()
    // https://technology.lastminute.com/junit5-kotlin-and-gradle-dsl/
    //testLogging {
       // exceptionFormat = TestExceptionFormat.FULL
       // events = mutableSetOf(TestLogEvent.FAILED, TestLogEvent.PASSED, TestLogEvent.SKIPPED)
       // showStackTraces = true
        // showCauses = true
       // showStandardStreams = true
//    }
//}
//
sonar {
	properties {
		property("sonar.projectKey", "DianaLoo_java-project-99")
		property("sonar.organization", "dianaloo")
		property("sonar.host.url", "https://sonarcloud.io")
	}
}
