name := """test-play"""

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  "org.webjars" %% "webjars-play" % "2.3-M1",
  "org.webjars" % "bootstrap" % "2.3.1",
  "org.webjars" % "requirejs" % "2.1.11-1",
  "org.scalatest" %% "scalatest" % "2.2.4" % Test
)

lazy val root = (project in file(".")).addPlugins(PlayScala)
