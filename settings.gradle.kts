pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Hamba"
include(":app")
include(":core")
include(":home")
include(":compass")
include(":hadith")
include(":quran")
include(":doa")
include(":adzan")
