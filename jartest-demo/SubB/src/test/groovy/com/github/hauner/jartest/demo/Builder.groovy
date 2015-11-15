package com.github.hauner.jartest.demo


class Builder {
    static Transitive build (String name) {
        new Transitive(name: name)
    }
}
