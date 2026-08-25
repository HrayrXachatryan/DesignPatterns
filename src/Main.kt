//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    // Singleton
    val logger = AppLogger.getInstance()

    logger.log("Network", "API request sent")
    logger.log("Database", "Record with id=42 successfully updated")
    logger.log("UI", "User opened the main screen")

    println("--- Saved Logs ---")
    logger.getLogs().forEach { logMessage ->
        println(logMessage)
    }

    // Builder
    val request = NetworkRequest.Builder("https://api.example.com/books")
        .method("POST")
        .addHeader("Authorization", "Bearer token")
        .addHeader("Content-Type", "application/json")
        .body("""{"title": "Kotlin in Action"}""")
        .timeout(15)
        .build()

    // Abstract Factory
    val factory = gameThemeFactory(ThemeType.NEON)
    val gameScreen = GameScreen(factory)

    gameScreen.draw()

    // Factory Method
    val myBook = bookFactory(BookType.TECHNICAL, "Kotlin in Action")
    myBook.read()

    // Strategy
    val calculator = DeliveryCalculator(strategy = StandardDelivery())
    val order = Order(weightKg = 2.0, distanceKm = 10.0)

    println(calculator.calculate(order))

    calculator.setStrategy(ExpressDelivery())
    println(calculator.calculate(order))

    calculator.setStrategy(FreeDelivery())
    println(calculator.calculate(order))

    // Decorator
    fun main() {
        val notifier: Notifier = UrgentDecoratorByDelegation(
            EmailDecoratorByDelegation(
                SmsDecoratorByDelegation(
                    BaseNotifier()
                )
            )
        )

        println(notifier.send("Server is down"))
    }

    //Delegation
    val character = GameCharacter()
    println(character.health)

    character.health = 50
    println(character.health)

//    character.health = 150
//    println(character.health)

    // Observer
    val realMadridNews = NewsPublisher(Team.REAL_MADRID)
    val poxos = Fan("Poxos")
    val ani = Fan("Ani")

    realMadridNews.subscribe(poxos)
    realMadridNews.subscribe(ani)
    realMadridNews.notify("New signing announced!")
}