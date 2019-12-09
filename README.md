# MPJUsages
Some MPJ Express usages + a good example of Gradle using.

MPJ Express v0.44 included. Path to it should be set as MPJ_HOME system environment variable.

# Running samples
* Set environment variable MPJ_HOME with path to mpjv0.44 lib.
* Use Gradle Run task to run a sample.
* The Run task should be provided with following environment variables:
  - MAIN_CLASS - package path to class with method main.
  - PROCESSES - number of processes to perform calcualting.

For more info look gradle.build.
