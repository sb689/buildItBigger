## Project Overview

This android application contains multiple flavors that uses
multiple libraries and Google Cloud Endpoints. The finished app will consist
of four modules. A Java library that provides jokes, a Google Cloud Endpoints
(GCE) project that serves those jokes, an Android Library containing an
activity for displaying jokes, and an Android app that fetches jokes from the
GCE module and passes them to the Android Library for display.

## Why this Project

As Android projects grow in complexity, it becomes necessary to customize the
behavior of the Gradle build tool, allowing automation of repetitive tasks.
Particularly, factoring functionality into libraries and creating product
flavors allow for much bigger projects with minimal added complexity.

## Requirements

* Project contains a Java library for supplying jokes
* Project contains an Android library with an activity that displays jokes passed to it as intent extras.
* Project contains a Google Cloud Endpoints module that supplies jokes from the Java library. Project loads jokes from GCE module via an async task.
* Project contains connected tests to verify that the async task is indeed loading jokes.
* Project contains paid/free flavors. The paid flavor has no ads, and no unnecessary dependencies.

#### Optional Requirements

* Write a Gradle task that starts the GCE dev server, runs all the Android tests, and shuts down the dev server.
* The free app variant displays interstitial ads between the main activity and the joke-displaying activity.
* The app displays a loading indicator while the joke is being fetched from the server.

## Learning objectives

* Role of Gradle in building Android Apps and manage app of increasing complexity
* Add free and paid flavors to an app, and set up build to share code between them
* Factor reusable functionality into a Java library
* Factor reusable Android functionality into an Android library
* Configure a multi project build to compile your libraries and app
* Use the Gradle App Engine plugin to deploy a backend 
* Configure an integration test suite that runs against the local App Engine development server

### Note

This application uses local App Engine development server for the backend. Please update build.gradle (Module:backend), point to local cloud SDK home 

appengine {  // App Engine tasks configuration
    tools.cloudSdkHome="/Users/Documents/google-cloud-sdk"
}   

