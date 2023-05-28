package com.github.hauner.jartest.demo

import spock.lang.Specification

class TestDependencySpec extends Specification {

    def "using a test class from sub project B which has a dependency on sub project C" () {
        expect:
        // Builder is a class from SubB that returns a class from SubC
        'Foo' == Builder.build ('Foo').name
    }
}
