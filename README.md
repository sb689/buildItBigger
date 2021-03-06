## Project Overview

This android application contains multiple flavors that use
multiple libraries and Google Cloud Endpoints. The finished app consists
of four modules. A Java library that provides jokes, a Google Cloud 
Endpoints(GCE)project that serves those jokes, an Android Library 
containing an activity for displaying jokes, and an Android app 
that fetches jokes from the GCE module and passes them to the 
Android Library for display. 

This project was developed as part of Udacity Android nanodegree 
course. A starter code was provided. 

## Requirements

* Project contains a Java library for supplying jokes
* Project contains an Android library with an activity that 
displays jokes passed to it as intent extras.
* Project contains a Google Cloud Endpoints module that supplies jokes 
from the Java library. Project loads jokes from GCE module via an async task.
* Project contains connected tests to verify that the async 
task is indeed loading jokes.
* Project contains paid/free flavors. The paid flavor has no ads 
and no unnecessary dependencies.
* A Gradle task should start the GCE dev server, runs all the Android 
tests, and shuts down the dev server.
* The free app variant displays interstitial ads between the main activity 
and the joke-displaying activity.
* The app displays a loading indicator while the joke is being 
fetched from the server.
* Configure an integration test suite that runs against the local App 
Engine development server

In summary, project functionalities should be factored into libraries 
and projects should have multiple flavors. All of these will be 
handled by Gradle build tools.

### Note

This application uses a local App Engine development server for the backend. 
Please update build.gradle (Module: backend), point to local cloud SDK home 
```
appengine {
    tools.cloudSdkHome="/Users/Documents/google-cloud-sdk"
} 
```

