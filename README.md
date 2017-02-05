## Table of content

1. [About](#about)
2. [Prerequisites](#prerequisites)
3. [Getting Started](#getting-started)
4. [Screenshots](Screenshots)
4. [Releases](#releases)
5. [FAQ](faq)
6. [License](license)
7. [Contributors](contributors)

## About
In this assignment, we are asked to implement an android app which helps entering data for a residence registration form ("Meldezettel").

The application consists of different screens which make it easy to input the data.
Each screen contains means to input data in the most comfortable way, that is the user should not have to type information which could already be prefilled.
For example, there is a widget for entering the date of birth.

We are using the official <a href="http://www.graz.at/cms/dokumente/10024916/e05a999a/Meldezettel.pdf">"Meldezettel"</a> as the definition of the app.




## Prerequisites
This application uses Scala and the gradle build system in order to make it as easy as possible for Android developers to use their workflow and also profit from the possibilities scala has to offer.

At the time of implementation it was necessary to patch the scala gradle plugin in order to get the unit tests to work, see the patched <a href="https://github.com/rladstaetter/gradle-android-scala-plugin">Gradle Android Scala Plugin</a>

## Getting Started

The first step was to think about the idea to create an App which makes it possible for users to inscribe it's personal data in the easiest way and to store it in a database.
Primarily we established a concept which includes contents like design, functionality, task distribution, and other technical details or project management questions.
Afterwards we talked about the most imprtant tasks (preparing the Views, implementing the database etc.) and the time management. Furthermore we decided to use the communication platform "Slack", which
makes it easier for us to interact with each other. nfhtirkeutjfdklka

## Screenshots

## Releases
The project was published on February 6th, 2017.
## FAQ
Warum?
Wieso?
Weshalb?
## License
Read <a href="license.md">license.md</a> for more information.
## Contributors
This project was created by
* <a href="https://github.com/SuperCari">Cölestin Carina</a>
* <a href="https://github.com/HribernigNikolaus">Hribernig Nikolaus</a>
* <a href="https://github.com/Jashanic14">Jashanica Labinot</a>
* <a href="https://github.com/x-qlusive">Plank Patrick</a>

```
rofl
```



1. [Quick start](#quick-start)
  1. [SBT plugin](#sbt-plugin)
  2. [Command-line](#command-line)
  3. [API](#api)
2. [Why](#why)
3. [Usage](#usage)
  1. [SBT plugin](#sbt-plugin-1)
  2. [Command-line](#command-line-1)
  3. [API](#api-1)
  4. [Scala JS demo](#scala-js-demo)
4. [Extra features](#extra-features)
  1. [Printing trees](#printing-trees)
  2. [Generating bootstrap launchers](#generating-bootstrap-launchers)
  3. [Credentials](#credentials)
  4. [Extra protocols](#extra-protocols)
5. [Limitations](#limitations)
6. [FAQ](#faq)
7. [Roadmap](#roadmap)
8. [Development tips](#development-tips)
9. [Contributors](#contributors)
10. [Projects using coursier](#projects-using-coursier)

