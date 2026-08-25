interface SnakeRenderer {
    fun render(): String
}

interface FoodRenderer {
    fun render(): String
}

interface BoardRenderer {
    fun render(): String
}

interface GameThemeFactory {
    fun createSnakeRenderer(): SnakeRenderer
    fun createFoodRenderer(): FoodRenderer
    fun createBoardRenderer(): BoardRenderer
}

class ClassicSnakeRenderer : SnakeRenderer {
    override fun render(): String = "🟩"
}

class ClassicFoodRenderer : FoodRenderer {
    override fun render(): String = "🍎"
}

class ClassicBoardRenderer : BoardRenderer {
    override fun render(): String = "⬜"
}

class ClassicThemeFactory : GameThemeFactory {
    override fun createSnakeRenderer(): SnakeRenderer = ClassicSnakeRenderer()
    override fun createFoodRenderer(): FoodRenderer = ClassicFoodRenderer()
    override fun createBoardRenderer(): BoardRenderer = ClassicBoardRenderer()
}

class NeonSnakeRenderer : SnakeRenderer {
    override fun render(): String = "💚"
}

class NeonFoodRenderer : FoodRenderer {
    override fun render(): String = "💎"
}

class NeonBoardRenderer : BoardRenderer {
    override fun render(): String = "⬛"
}

class NeonThemeFactory : GameThemeFactory {
    override fun createSnakeRenderer(): SnakeRenderer = NeonSnakeRenderer()
    override fun createFoodRenderer(): FoodRenderer = NeonFoodRenderer()
    override fun createBoardRenderer(): BoardRenderer = NeonBoardRenderer()
}

enum class ThemeType {
    CLASSIC,
    NEON
}

fun gameThemeFactory(type: ThemeType): GameThemeFactory {
    return when (type) {
        ThemeType.CLASSIC -> ClassicThemeFactory()
        ThemeType.NEON -> NeonThemeFactory()
    }
}

class GameScreen(private val themeFactory: GameThemeFactory) {
    private val snakeRenderer = themeFactory.createSnakeRenderer()
    private val foodRenderer = themeFactory.createFoodRenderer()
    private val boardRenderer = themeFactory.createBoardRenderer()

    fun draw() {
        println("${boardRenderer.render()} ${snakeRenderer.render()} ${foodRenderer.render()}")
    }
}