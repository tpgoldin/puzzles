ThisBuild / organization := "Puzzles"

ThisBuild / version := "1.0.0"

ThisBuild / scalaVersion := "2.12.10"

resolvers ++= List("Sonatype Releases Repository" at "https://oss/sonatype.org/content/repositories/Releases",
    "Artima Maven Repository" at "https://repo.artima.com/releases")

lazy val scalatest = "org.scalatest" %% "scalatest" % "3.3.0-SNAP2"

lazy val scalactic = "org.scalactic" %% "scalactic" % "3.2.0"

lazy val puzzles = project in file("puzzles/src/scala/main")

lazy val puzzlesTests = project in file("puzzles/src/scala/test")

lazy val root = (project in file("."))
  .settings(
    // set the name of the project
    name := "",

    Compile / scalaSource := baseDirectory.value / "src/scala/main",

    Test / scalaSource := baseDirectory.value / "src/scala/test",

    // add a test dependency on ScalaCheck
    libraryDependencies ++= List(scalatest % Test, scalactic),

    javacOptions ++= Seq("-source", "1.8", "-target", "1.8"),

    watchSources += baseDirectory.value / "input",

    fork := true,

    Test / fork := true,

    javaOptions += "-Xmx2G" 
  )

