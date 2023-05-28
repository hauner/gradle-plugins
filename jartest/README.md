## jarTest Plugin
 
In case you have a multi-project gradle build you may have test dependencies between sub-projects
(which probably is a hint that your projects are not well structured).

For example assume a project where the sub-project **Project B** depends on **Project A** and **B**
does not only have a *compile* dependency on **A** but also a *test* dependency. To compile and run
the tests of **B** we need some test helper classes from **A**. 

By default gradle does not create a jar *artifact* from the test build output of a project. 

This plugin adds a *testArchives* configuration (based on *testCompile*) and a *jarTest* task to
create a jar from the test *source set* (with the classifier `test` added to name of the jar). We
can then depend in **B** on the *testArchives* configuration of **A** (which will also include the
transitive dependencies of **A**).

In **A** we would add the plugin to `build.gradle`:

    plugins {
      id("com.github.hauner.jarTest") version "1.1.0"
    }

In **B** we reference the *testArchives* configuration like this:

    dependencies {
        ...
        testCompile project (path: ':ProjectA', configuration: 'testArchives')
    }


The plugin is available from [plugins.gradle.org](https://plugins.gradle.org/plugin/com.github.hauner.jarTest)
