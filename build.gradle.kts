plugins {
	java
	id("org.springframework.boot") version "2.7.14"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"


java {
	sourceCompatibility = JavaVersion.VERSION_1_8
}

repositories {
	mavenCentral()
}

dependencies {

	//compileOnly 'org.projectlombok:lombok'
	implementation("org.projectlombok:lombok")
	//compile('org.projectlombok:lombok')
	//implementation('org.projectlombok:lombok')
	annotationProcessor("org.projectlombok:lombok")
	//compileOnly 'org.projectlombok:lombok'
	//annotationProcessor 'org.projectlombok:lombok'
	//compileOnly 'org.projectlombok:lombok:1.18.20'
	//annotationProcessor 'org.projectlombok:lombok:1.18.20'

	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-mustache")
	implementation("org.springframework.boot:spring-boot-starter-web")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("com.h2database:h2")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

}

tasks.withType<Test> {
	useJUnitPlatform()
}
