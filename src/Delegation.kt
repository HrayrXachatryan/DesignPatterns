import kotlin.reflect.KProperty

// Class Delegation
interface Cache {
    fun get(key: String): String?
    fun put(key: String, value: String)
}

class InMemoryCache : Cache {
    private val map = mutableMapOf<String, String>()
    override fun get(key: String): String? = map[key]
    override fun put(key: String, value: String) {
        map[key] = value
    }
}

class LoggingCache(private val wrapped: Cache) : Cache by wrapped {
    override fun put(key: String, value: String) {
        println("PUT: $key = $value")
        wrapped.put(key, value)
    }
}

// Delegated Properties
class RangeValidatedDelegate(
    private val min: Int,
    private val max: Int,
    initial: Int
) {
    private var value: Int = initial

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return value
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, newValue: Int) {
        require(newValue in min..max) {
            "${property.name} must be between $min and $max, got $newValue"
        }
        value = newValue
    }
}

class GameCharacter {
    var health: Int by RangeValidatedDelegate(min = 0, max = 100, initial = 100)
}