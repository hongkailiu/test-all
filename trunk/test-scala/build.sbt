name := "test-scala"

version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.11" % "2.2.1" % "test"
    )

testOptions in Test := Seq(Tests.Filter(s => s.endsWith("Test")))


