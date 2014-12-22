addSbtPlugin("org.scala-lang.modules.scalajs" % "scalajs-sbt-plugin" % "0.5.5")

addSbtPlugin("com.lihaoyi" % "utest-js-plugin" % "0.2.4")

/* uTest uses itself to test itself. At the library level, this is not a
 * problem. But the runner must be available to the build project. So we
 * simply add the sources of the runners to the build project.
 */
unmanagedSources in Compile ++= {
  val root = baseDirectory.value.getParentFile
  (root / "scalatexSbtPlugin" ** "*.scala").get
}
