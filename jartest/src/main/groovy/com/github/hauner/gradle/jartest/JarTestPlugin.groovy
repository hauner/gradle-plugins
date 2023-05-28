/*
 * Copyright 2014 https://github.com/hauner/gradle-plugins
 * PDX-License-Identifier: Apache-2.0
 */

package com.github.hauner.gradle.jartest

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.bundling.Jar


class JarTestPlugin implements Plugin<Project> {

    void apply(Project project) {
        project.configurations {
            testArchives.extendsFrom (testImplementation)
        }

        project.tasks.register('jarTest', Jar) {
            description = 'create a jar from the test source set'
            group = 'build'

            dependsOn project.testClasses
            from project.sourceSets.test.output
            archiveClassifier = 'test'
        }

        project.artifacts {
            testArchives project.jarTest
        }
    }
}
