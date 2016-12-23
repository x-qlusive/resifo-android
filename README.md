In this assignment, we are asked to implement an android app which helps entering data for a residence registration form ("Meldezettel").

The application consists of different screens which make it easy to input the data.
Each screen contains means to input data in the most comfortable way, that is the user should not have to type information which could already be prefilled.
For example, there is a widget for entering the date of birth.

We are using the official Meldezettel as the definition of the app.


This application uses Scala and the gradle build system in order to make it as easy as possible for Android Developers to use their workflow and also profit from the possibilities scala has to offer.

At the time of implementation it was necessary to patch the scala gradle plugin in order to get the unit tests to work, see the patched <a href="https://github.com/rladstaetter/gradle-android-scala-plugin">Gradle Android Scala Plugin</a>