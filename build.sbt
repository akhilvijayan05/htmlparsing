name := "htmldataparsing"

version := "0.1"

scalaVersion := "2.12.8"

lazy val root = (project in file("."))
  .settings(
    name := "root",
    libraryDependencies ++= Seq(
      "net.sourceforge.htmlcleaner" % "htmlcleaner" % "2.22",
      "com.typesafe.play" %% "play-json" % "2.6.7"
    )
  )