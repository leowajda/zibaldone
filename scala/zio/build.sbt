ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.7"

lazy val root = (project in file("."))
  .settings(
    name             := "zio",
    idePackagePrefix := Some("com.zibaldone.zio")
  )

lazy val zioVersion = "2.1.22"

libraryDependencies ++= Seq(
  "dev.zio" %% "zio"            % zioVersion,
  "dev.zio" %% "zio-test"       % zioVersion,
  "dev.zio" %% "zio-test-sbt"   % zioVersion,
  "dev.zio" %% "zio-streams"    % zioVersion,
  "dev.zio" %% "zio-test-junit" % zioVersion
)
