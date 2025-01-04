scalaVersion := "3.5.2"
version := "0.1.0"

name := "lsp-zoomba"

// name of the fat jar
assembly / assemblyJarName := "lsp-zoomba.jar"

val circeVersion = "0.14.10"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)

// libraryDependencies += "org.eclipse.lsp4j" % "org.eclipse.lsp4j" % "0.23.1"
