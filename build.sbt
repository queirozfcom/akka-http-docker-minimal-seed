lazy val root = (project in file(".")).enablePlugins(JavaAppPackaging)

name := "akka-http-docker-minimal-seed"

version := "1.0"

scalaVersion := "2.11.8"

packageName in Docker := "akka-http-docker-minimal-seed"
dockerExposedPorts := Seq(5000)

libraryDependencies ++= {
  val akkaV = "2.4.7"
  val scalaTestV = "2.2.6"
  Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaV,
    "com.typesafe.akka" %% "akka-slf4j" % akkaV,
    "com.typesafe.akka" %% "akka-stream" % akkaV,
    "com.typesafe.akka" %% "akka-http-experimental" % akkaV,
    "com.typesafe.akka" %% "akka-http-spray-json-experimental" % akkaV,
    "com.typesafe.akka" %% "akka-http-testkit" % akkaV,
    "org.scalatest" %% "scalatest" % scalaTestV % "test",
    "ch.qos.logback" % "logback-classic" % "1.1.7"
  )
}
unmanagedResourceDirectories in Compile += {
  baseDirectory.value / "src/main/resources"
}