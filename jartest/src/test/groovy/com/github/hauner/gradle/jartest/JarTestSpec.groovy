package com.github.hauner.gradle.jartest

import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.testfixtures.ProjectBuilder
import spock.lang.Specification


class JarTestSpec extends Specification {
    Project project

    def setup () {
        project = ProjectBuilder.builder().build()
        project.apply plugin: 'java'
        project.apply plugin: 'com.github.hauner.jarTest'
    }

    def "plugin adds 'testArchives' configuration to project" () {
        expect:
        project.configurations.testArchives
        project.configurations.testArchives.extendsFrom.find { it.name == 'testCompile' }
    }

    def "plugin adds 'jarTest' task dependency on 'testArchive' configuration" () {
        expect:
        project.configurations.testArchives.artifacts.find { it.archiveTask.name == 'jarTest' }
    }

    def "plugin adds 'jarTest' task to project" () {
        Task jarTest = project.tasks.findByName ('jarTest')

        // don't know how to check "from"
        // SourceSetOutput out = project.sourceSets.test.output
        // jarTest.inputs ??

        expect:
        jarTest
        jarTest.dependsOn.find { it instanceof Task }.name == 'testClasses'
        ! jarTest.description.empty
        jarTest.classifier == 'test'
    }
}
