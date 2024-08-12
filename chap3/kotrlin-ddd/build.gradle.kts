plugins {
	kotlin("jvm") version "1.9.22"
	kotlin("plugin.spring") version "1.9.22"
	id("org.springframework.boot") version "3.3.2"
	id("io.spring.dependency-management") version "1.1.6"

	//	added
	id("io.gitlab.arturbosch.detekt") version "1.23.5"
	id("org.jetbrains.dokka") version "1.9.10"
	id("org.springdoc.openapi-gradle-plugin") version "1.8.0"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

configurations.matching { it.name.startsWith("dokka") }.configureEach {
	resolutionStrategy.eachDependency {
		if (requested.group.startsWith("com.fasterxml.jackson")) {
			useVersion("2.15.3")
		}
	}
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	implementation("org.springframework.boot:spring-boot-starter-jdbc")
	runtimeOnly("org.postgresql:postgresql")

	//	added
	detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.21.0")
	dokkaHtmlPlugin("org.jetbrains.dokka:kotlin-as-java-plugin:1.9.20")
	implementation("io.arrow-kt:arrow-core:1.2.1")
	testImplementation("org.assertj:assertj-core:3.25.2")
	testImplementation("net.jqwik:jqwik:1.8.2")
	testImplementation("net.jqwik:jqwik-kotlin:1.8.2")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0")
}

openApi {
	apiDocsUrl.set("http://localhost:8080/v3/api-docs.yaml")
	outputDir.set(project.layout.buildDirectory.dir("springdoc"))
	outputFileName.set("openapi.yaml")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

detekt {
	// 略
	/**
	 * ./gradlew detektGenerateConfig でdetekt.ymlが生成される(バージョンが上がる度に再生成する)
	 */
	config = files(
		"$projectDir/config/detekt/detekt.yml",
		"$projectDir/config/detekt/detekt-override.yml",
	)
}

tasks.withType<Test> {
	useJUnitPlatform()
}
