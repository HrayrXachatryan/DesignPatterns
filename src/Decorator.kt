interface Notifier {
    fun send(message: String): String
    fun getHistory(): List<String>
    fun clearHistory()
    fun isEnabled(): Boolean
    fun getDeliveryStatus(id: String): String
}

class BaseNotifier : Notifier {
    private val history = mutableListOf<String>()

    override fun send(message: String): String {
        history.add(message)
        return "Sending: $message"
    }

    override fun getHistory(): List<String> = history.toList()

    override fun clearHistory() {
        history.clear()
    }

    override fun isEnabled(): Boolean = true

    override fun getDeliveryStatus(id: String): String = "Delivered: $id"
}

//  MANUAL DECORATOR IMPLEMENTATION
class EmailDecoratorManual(private val wrapped: Notifier) : Notifier {

    override fun send(message: String): String {
        val result = wrapped.send(message)
        return "$result, via Email"
    }

    override fun getHistory(): List<String> = wrapped.getHistory()
    override fun clearHistory() = wrapped.clearHistory()
    override fun isEnabled(): Boolean = wrapped.isEnabled()
    override fun getDeliveryStatus(id: String): String = wrapped.getDeliveryStatus(id)
}

class SmsDecoratorManual(private val wrapped: Notifier) : Notifier {

    override fun send(message: String): String {
        val result = wrapped.send(message)
        return "$result, via Sms"
    }

    override fun getHistory(): List<String> = wrapped.getHistory()
    override fun clearHistory() = wrapped.clearHistory()
    override fun isEnabled(): Boolean = wrapped.isEnabled()
    override fun getDeliveryStatus(id: String): String = wrapped.getDeliveryStatus(id)
}

class UrgentDecoratorManual(private val wrapped: Notifier) : Notifier {

    override fun send(message: String): String {
        val urgentMessage = "[URGENT] $message"
        return wrapped.send(urgentMessage)
    }

    override fun getHistory(): List<String> = wrapped.getHistory()
    override fun clearHistory() = wrapped.clearHistory()
    override fun isEnabled(): Boolean = wrapped.isEnabled()
    override fun getDeliveryStatus(id: String): String = wrapped.getDeliveryStatus(id)
}

//  DECORATORS USING CLASS DELEGATION (`by` Keyword)
class EmailDecoratorByDelegation(
    private val wrapped: Notifier
) : Notifier by wrapped {

    override fun send(message: String): String {
        val result = wrapped.send(message)
        return "$result, via Email"
    }
}

class SmsDecoratorByDelegation(
    private val wrapped: Notifier
) : Notifier by wrapped {

    override fun send(message: String): String {
        val result = wrapped.send(message)
        return "$result, via Sms"
    }
}

class UrgentDecoratorByDelegation(
    private val wrapped: Notifier
) : Notifier by wrapped {

    override fun send(message: String): String {
        val urgentMessage = "[URGENT] $message"
        return wrapped.send(urgentMessage)
    }
}