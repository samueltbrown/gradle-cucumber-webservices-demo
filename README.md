# Demo Application: Acceptance Testing Web Services

This application is designed to be a small demonstration of some exciting tools used together to show
acceptance testing of a web service.  The following tools/frameworks are used in this application:

* [gradle](http://gradle.org/) - Build tool
* [Spring Web Services](http://www.springsource.org/spring-web-services) - Web service framework
* [JAXB](http://jaxb.java.net/) - Java to XML binding framework
* [cucumber-jvm](https://github.com/cucumber/cucumber-jvm) - Java port of the cucumber acceptance testing framework
* [groovy-wslite](https://github.com/jwagenleitner/groovy-wslite) - Lightweight groovy web service client library

# How to build

1. Install the Java SDK (if you haven't already)
2. Clone this repository
3. From the project root run:
    ><b>gradlew clean build acceptanceTests</b>

<b>Note:</b> The gradle wrapper uses Gradle v1.0.  This application has not been tested with other versions. Results
may vary.

# How it works

The included gradle script builds the application using the 'build' command.  Once built, the 'acceptanceTests' task
execution will load the application on a local tomcat server on port 8080, run the cucumber tests, and then shut down
the tomcat server.

# Recent Updates

<b>8/6/2012</b> - This plugin now uses my gradle cucumber plugin version 0.1!  You can find the source at:

[https://github.com/samueltbrown/gradle-cucumber-plugin] (https://github.com/samueltbrown/gradle-cucumber-plugin)

# Coming soon...

More comments in the code!