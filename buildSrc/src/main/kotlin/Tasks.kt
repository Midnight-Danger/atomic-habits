@file:Suppress("Unused")
object Tasks {
    const val PRE_BUILD_APP = ":app:preBuild"
    val FULL_PERMISSION = "0777".toInt(radix = 8)

    object InstallGitHooks {
        const val NAME = "installGitHooks"
        const val GROUP = "git hooks"
        const val DESC = "Copy pre-commit git hook from the scripts to the .git/hooks folder."
        const val SOURCE_DIR = ".git-hooks/pre-commit"
        const val TARGET_DIR = ".git/hooks"
        const val LOG_SUCCESS = "Git hooks installed successfully."
    }
}