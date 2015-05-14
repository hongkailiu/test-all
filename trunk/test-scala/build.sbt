name := "test-scala"

version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))

val akkaVersion = "2.3.9"
//val akkaVersion = "2.4-SNAPSHOT"

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-remote" % akkaVersion,
  "com.typesafe.akka" %% "akka-cluster" % akkaVersion,
  //"com.typesafe.akka" %% "akka-cluster-metrics" % akkaVersion,
  "com.typesafe.akka" %% "akka-contrib" % akkaVersion,
  "com.typesafe.akka" %% "akka-multi-node-testkit" % akkaVersion,
  //"org.fusesource" %% "sigar" % "1.6.4",
  "io.kamon" % "sigar-loader" % "1.6.5-rev001",
  "org.scaldi" %% "scaldi" % "0.5.5",
  "org.scalatest" %% "scalatest" % "2.2.1" % "test",
  "org.mockito" % "mockito-all" % "1.10.19" % "test"
    )

testOptions in Test := Seq(Tests.Filter(s => s.endsWith("Test")))

// fix scala version
//ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) }
