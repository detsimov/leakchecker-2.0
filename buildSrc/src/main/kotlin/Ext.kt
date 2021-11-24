import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.impl(depName: Any) {
    add("implementation", depName)
}

fun DependencyHandler.debugImpl(depName: Any) {
    add("debugImplementation", depName)
}