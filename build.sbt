name := "todo-application"

version := "0.1"

scalaVersion := "2.12.3"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http" % "10.0.10",
  "com.typesafe.slick" %% "slick" % "3.2.1",
  "com.typesafe.akka" %% "akka-http-spray-json" % "10.0.10",
  "net.codingwell" %% "scala-guice" % "4.1.0",
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.7.2",
  "org.postgresql" % "postgresql" % "42.1.4"
)