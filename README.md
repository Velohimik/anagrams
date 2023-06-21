# Task 3 (Maven and other useful tools)

## Basik task
Convert your previous project to a maven project.

Add Sonar lint plugin support to your IDE.

Add Editorconfig support to your project.

In the future, all java projects should be created as maven projects. Every time before you a create merge request you should check your code with Sonar Lint. It won’t show all the problems but it can check a lot.

## Advanced task:
  mvnw [REPETITIVE]
    Add maven wrapper.
  ci [REPETITIVE]
    Configure pipeline. Read about SDLC.
  gradle [REPETITIVE]
    Convert the project to Gradle.

# Task 2 (Unit tests)

## Basic task
Write JUnit tests for the previous application.

JUnit 5 should be used.

In the future, all tasks are done with the Unit tests

## Advanced task

**E2E**
  Write anagrams-e2e application that tests Anagrams.
  It runs anagrams.jar with predefined test arguments and verifies its output (google: "java run external program and capture output").
  It returns 0 on success and 1 if one or more tests failed.
  Implement a few tests, you don't have to cover the application functionality thoroughly.

# Task 1 (java syntax, Git, IDE)
  
## Basic task
**Task 1 - Anagrams**

  Write an application that reverses all the words of input text:
  
    "abcd efgh" => "dcba hgfe"

  All non-letter symbols should stay on the same places:

    "a1bcd efg!h" => "d1cba hgf!e"

  Use Latin alphabet for test only.

## Advanced task
**Shell Scripts**

  Provide `make` for compiling and building jar distributive and `anagrams` for running the program jar. The program will be run from a terminal / command prompt as e.g. `anagrams hel1o w0rlD` or `anagrams "hel  1o w0rlD   "` We need to support Windows 10+, Ubuntu 20.04+, Mac OS machines, so we need the scripts in 2 formats: batch and bash. Use tutorials. Put the launch scripts together with the JAR into `dist/` directory (it's our distribution directory that will be given to the end users), of course the jar must not be under VCS, but should be generated with `make` scripts which is in the project root. So when the project is cloned the dist contains launch scripts, after that and before the actual distribution the make script must be executed.

## Screenshots
![Screenshot #1](./docs/Screenshot4.jpg)

![Screenshot #2](./docs/Screenshot5.jpg)

![Screenshot #3](./docs/Screenshot6.jpg)

![Test code coverage report](./docs/Test_code_coverage_report.jpg)

![e2e test](./docs/e2e_test.jpg)


## Java version

**18.0.2.1**

## JDK download
Windows x64: [here](https://www.oracle.com/java/technologies/downloads/#jdk18-windows)

Linux x64 (Compressed Archive): [here](https://www.oracle.com/java/technologies/downloads/#jdk18-linux)

MacOS: [here](https://www.oracle.com/java/technologies/downloads/#jdk18-mac)

## How to run

**Compiling:**

*Windows*
```bash
$\anagrams> .\make.bat
```

*Linux or MacOS*
```bash
$\anagrams> ./make.sh
```


**Running:**

*Windows*
```bash
$\anagrams> \dist\anagrams.bat "a1bcd efg!h" awe
```

*Linux or MacOS*
```bash
$\anagrams> /dist/anagrams.sh "a1bcd efg!h" awe
```