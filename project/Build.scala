import sbt._
import sbt.Keys._

object MainBuild extends Build {

  lazy val main = Project(
    id = "main",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "Main",
      organization := "com.livestream.perf",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.9.2"
      // add other settings here
    )
  )
}
