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
    val classicGame = GameScreen(themeFactory = ClassicThemeFactory())
    classicGame.draw() // ⬜ 🟩 🍎

    val neonGame = GameScreen(themeFactory = NeonThemeFactory())
    neonGame.draw() // ⬛ 💚 💎

    // Factory Method
    val localLoader: BookLoader = LocalBookLoader()
    println(localLoader.loadBooks())

    val remoteLoader: BookLoader = RemoteBookLoader()
    println(remoteLoader.loadBooks())

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

    character.health = 150
    println(character.health)
}