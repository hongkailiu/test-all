

lazy val commonSettings = Seq(
  version := "1.0",
  scalaVersion := "2.11.0"
)


lazy val testScala = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    name := "test-scala",
    libraryDependencies ++= Dependencies.testScalaDeps
  )
