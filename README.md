# TDD based on Job DSL and Gradle

TDD example based on [Job DSL](https://github.com/jenkinsci/job-dsl-plugin) project that uses Gradle for building and testing.

## File structure

    .
    ├── infra                   # Local Jenkins instance
    ├── jobs                    # DSL script files
    ├── resources               # resources for DSL scripts
    ├── src
    │   ├── main
    │   │   ├── groovy          # support classes
    │   │   └── resources
    │   │       └── idea.gdsl   # IDE support for IDEA
    │   └── test
    │       └── groovy          # specs
    └── build.gradle            # build file

## Testing locally

* `./gradlew test` runs the specs.

[JobScriptsSpec](src/test/groovy/com/v1v/jobdsl/example/JobScriptsSpec.groovy)
will loop through all DSL files and make sure they don't throw any exceptions when processed.

## Seed Job

You can create the example seed job manually create a job with the same structure:

* Invoke Gradle script → Use Gradle Wrapper: `true`
* Invoke Gradle script → Tasks: `clean test`
* Process Job DSLs → DSL Scripts: `jobs/**/*Jobs.groovy`
* Process Job DSLs → Additional classpath: `src/main/groovy`
* Publish JUnit test result report → Test report XMLs: `build/test-results/**/*.xml`

Or automatically using the local docker [container](infra/README.md)

## Authors

Victor Martinez

## Further references

- [job-dsl-gradle-example](https://github.com/sheehan/job-dsl-gradle-example)
- [Spock](https://code.google.com/p/spock/wiki/SpockBasics)
- [video](https://www.youtube.com/watch?v=SSK_JaBacE0)

## License

    The MIT License

    Copyright (c) 2015, Victor Martinez

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in
    all copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
    THE SOFTWARE.
