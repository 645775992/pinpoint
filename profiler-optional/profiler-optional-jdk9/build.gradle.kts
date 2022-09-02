plugins {
    id("com.navercorp.pinpoint.java8-library")
}

dependencies {
    compileOnly(project(":pinpoint-commons"))
    compileOnly(project(":pinpoint-profiler"))
    testCompileOnly(project(":pinpoint-profiler"))
    implementation(libs.log4j.api.jdk7)
    implementation(libs.bundles.asm)
    testImplementation(project(":pinpoint-test"))
    testImplementation(libs.spring.test)
    testImplementation(libs.spring.context)
    testImplementation(libs.commons.io)
    testImplementation(libs.log4j.slf4j.impl.jdk7)
    testImplementation(libs.log4j.core.jdk7)
}

description = "pinpoint-profiler-optional-jdk9"

sourceSets {
    main {
        java {
            srcDir("src/main/java9")
            srcDir("src/main/java11")
        }
    }
}