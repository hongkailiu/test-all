name := "test-scala"

version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.3.9",
  "com.typesafe.akka" %% "akka-cluster" % "2.3.9",
  "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test",
  "org.mockito" % "mockito-all" % "1.10.19" % "test"
    )

testOptions in Test := Seq(Tests.Filter(s => s.endsWith("Test")))


