name in ThisBuild := "simple"

val logging = project
  .enablePlugins(BuildInfoPlugin)

val engine = project.enablePlay
  .enablePlugins(DockerPlugin, AshScriptPlugin)
  .settings(
    pipelineStages := Seq(digest, gzip)
  )
  .dependsOn(logging)

val performance = project.enableIntegrationTests
  .enablePlugins(DockerPlugin, AshScriptPlugin)
  .settings(
    libraryDependencies ++= deps.Gatling
  )
