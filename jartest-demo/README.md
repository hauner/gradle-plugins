jarTest Plugin Demo
===================

This a simple demo project for the **jarTest** plugin.

It contains 3 projects. **SubA** which has only a dependency on test code of **SubB**. **SubB**
itself has a normal dependency on **SubC**.

The plugin can be used to create a second jar with the test code as build output of a project
(see `build.gradle` of **SubB**). It can then be referenced as a dependency from another
project (see `build.gradle` of **SubA**). This will automatically include its transitive
dependencies (**SubC**).

See the `build.gradle` files of the sub projects.

Tested with

* Gradle 2.5
* Gradle 2.4
* Gradle 2.3
* Gradle 2.2
