enum class Team {
    REAL_MADRID, ARSENAL, BARCELONA, LIVERPOOL
}

interface NewsObserver {
    fun notify(team: Team, message: String)
}

data class Fan(private val name: String) : NewsObserver {
    override fun notify(team: Team, message: String) {
        println("Hello $name, please check the following news about $team:\n$message\n")
    }
}

class NewsPublisher(private val team: Team) {
    private val observers = mutableListOf<NewsObserver>()

    fun subscribe(observer: NewsObserver) {
        observers.add(observer)
    }

    fun unsubscribe(observer: NewsObserver) {
        observers.remove(observer)
    }

    fun notify(message: String) {
        observers.toList().forEach { observer ->
            observer.notify(team, message)
        }
    }
}