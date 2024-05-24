
abstract class InstallGitHooks: Copy() {
    @get:InputFile
    lateinit var fromFile: File

    @get:OutputFile
    lateinit var intoFile: File

    init {
        group = Tasks.InstallGitHooks.GROUP
        description = Tasks.InstallGitHooks.DESC
    }

    @TaskAction
    fun copyGitHooks() {
        outputs.upToDateWhen { false }
        from(fromFile)
        into { intoFile }
        fileMode = Tasks.FULL_PERMISSION
        doLast {
            logger.info(Tasks.InstallGitHooks.LOG_SUCCESS)
        }
    }
}