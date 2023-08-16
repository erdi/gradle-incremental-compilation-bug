plugins {
    java
}

repositories {
    mavenCentral()
}

dependencies {
    annotationProcessor("com.google.auto.service:auto-service:1.1.1")

    implementation("org.apache.commons:commons-lang3:3.12.0")
    implementation("com.google.auto.service:auto-service-annotations:1.1.1")
}

tasks.register("checkServiceDescriptorForProcessorExists") {
    inputs.files(tasks.named("compileJava"))

    doLast {
        inputs.files.asFileTree
            .filter { it.absolutePath.endsWith("META-INF/services/javax.annotation.processing.Processor") }
            .singleFile
    }
}