name := """test-scala"""

version := "1.0"

scalaVersion := "2.11.0"


libraryDependencies ++= Seq(
  "com.github.nscala-time" %% "nscala-time" % "2.0.0",
//json
  "io.spray" %%  "spray-json" % "1.3.2",
//logging
  "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0",
//  "org.slf4j" % "log4j-over-slf4j" % "1.7.1",  // for any java classes looking for this
  "ch.qos.logback" % "logback-classic" % "1.0.3",
  "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"
)
