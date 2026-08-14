class NetworkRequest private constructor(
    val url: String,
    val method: String,
    val headers: Map<String, String>,
    val body: String?,
    val timeoutSeconds: Int
) {
    class Builder(private val url: String) {
        private var method: String = "GET"
        private val headers: MutableMap<String, String> = mutableMapOf()
        private var body: String? = null
        private var timeoutSeconds: Int = 30

        fun method(method: String) = apply { this.method = method }
        fun addHeader(key: String, value: String) = apply { headers[key] = value }
        fun body(body: String) = apply { this.body = body }
        fun timeout(seconds: Int) = apply { timeoutSeconds = seconds }

        fun build(): NetworkRequest {
            require(url.isNotBlank()) { "URL must not be blank" }
            require(!(method == "GET" && body != null)) { "GET request must not have a body" }
            require(timeoutSeconds > 0) { "Timeout must be positive" }

            return NetworkRequest(
                url = url,
                method = method,
                headers = headers.toMap(),
                body = body,
                timeoutSeconds = timeoutSeconds
            )
        }
    }
}