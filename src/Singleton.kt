class AppLogger private constructor() {

    private val logBuffer: ArrayDeque<String> = ArrayDeque()
    private val maxLogs = 50

    fun log(tag: String, message: String) {
        logBuffer.addLast("[$tag] $message")
        if (logBuffer.size > maxLogs) {
            logBuffer.removeFirst()
        }
    }

    fun getLogs(): List<String> = logBuffer.toList()

    companion object {
        @Volatile
        private var instance: AppLogger? = null

        fun getInstance(): AppLogger =
            instance ?: synchronized(this) {
                instance ?: AppLogger().also { instance = it }
            }
    }
}