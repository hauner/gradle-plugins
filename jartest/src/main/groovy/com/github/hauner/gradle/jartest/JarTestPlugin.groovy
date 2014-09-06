package com.github.hauner.gradle.jartest

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.bundling.Jar


class JarTestPlugin implements Plugin<Project> {

    void apply(Project project) {
        project.configurations {
            testArchives.extendsFrom (testCompile)
        }

        project.task ('jarTest', type:Jar, dependsOn: project.testClasses, description: 'create jar from test source set') {
            from project.sourceSets.test.output
            classifier = 'test'
        }

        project.artifacts {
            testArchives project.jarTest
        }
    }
}
