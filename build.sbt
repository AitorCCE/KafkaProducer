
// Settings
// ============================================================================
scalaVersion := "2.11.8"
name := "kafka-spark"
organization := "ch.epfl.scala"
version := "1.0"

// libraryDependencies:
// ============================================================================
libraryDependencies += "org.typelevel" %% "cats-core" % "1.4.0"
libraryDependencies += "org.json" % "json" % "20180813"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"
libraryDependencies += "org.json4s" %% "json4s-native" % "3.6.0-M3"
libraryDependencies += "org.apache.kafka" %% "kafka" % "0.8.2.1"

