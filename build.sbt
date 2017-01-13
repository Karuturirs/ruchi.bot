name := "Ruchi.Bot"

val commonSettings = Seq(
  organization := "com.ruchibot",
  version := "0.1",
  scalaVersion := "2.12.0",
  scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")
)

lazy val testDependencies = Seq (
  "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)

lazy val cassandraDependencies = Seq (
  "com.datastax.cassandra" % "cassandra-driver-core" % "2.1.2"
)
lazy val configTypeSafeDependencies = Seq(
  "com.typesafe" % "config" % "1.2.1"
)

lazy val coreApp = project.in(file("coreApp"))
  .settings(commonSettings:_*)
  .settings(libraryDependencies ++= (testDependencies ++ cassandraDependencies ++ configTypeSafeDependencies))

lazy val webApp = project.in(file("webApp"))
  .settings(commonSettings:_*)

lazy val main = project.in(file("."))
  .aggregate(coreApp, webApp)