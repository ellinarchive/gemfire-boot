This is a sample spring boot application,  it utilizes the spring data gemfire starter to configure
the dependencies.

Initial Project created from http://start.spring.io

This version actually uses the spring - boot starter which points to gemfire 7 

This version uses a local cache ( the gemfire instance is embedded in the same jvm)

To run

Use, use your ide to run the main class (Application.class)

You can also run using the maven plugin

mvn package which will create a fat/uber jar which can be run from the command line

java -jar target/gemfire-starter-0.0.1-SNAPSHOT.jartarget/gemfire-starter-0.1.1-SNAPSHOT.jar

