ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.6.4"

lazy val root = (project in file("."))
  .settings(
    name := "cats",
    idePackagePrefix := Some("com.zibaldone.cats")
  )

libraryDependencies += "org.typelevel" %% "cats-core" % "2.12.0"
