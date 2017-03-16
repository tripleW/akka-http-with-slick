name := "akka-http-example"

organization := "io.triplew"

version := "0.0.1-SNAPSHOT"

scalaVersion := "2.11.8"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
  val akkaV       = "2.4.10"
  Seq(
    "com.typesafe.akka" %% "akka-actor"                           % akkaV,
    "com.typesafe.slick" % "slick_2.11" % "3.2.0",
    "com.zaxxer" % "HikariCP" % "2.4.5",
    "mysql" % "mysql-connector-java" % "5.1.28"
  )
}

