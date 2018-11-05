name := """ddcw-technical-test-java""""

version := "2.6.x"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

lazy val compileDeps = Seq(
  ws,
  guice,
  "org.json"%"org.json"%"chargebee-1.0"
)

scalaVersion := "2.12.6"

crossScalaVersions := Seq("2.11.12", "2.12.6")

testOptions in Test := Seq(Tests.Argument(TestFrameworks.JUnit, "-a", "-v"))

libraryDependencies ++= compileDeps

PlayKeys.playDefaultPort := 1235