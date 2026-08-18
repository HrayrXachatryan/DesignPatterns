enum class BookType {
    FICTION,
    TECHNICAL,
    AUDIO
}

interface Book{
    val title: String
    fun read()
}

class FictionBook(override val title: String) : Book {
    override fun read() = println("Reading fiction book: $title")
}

class TechnicalBook(override val title: String) : Book {
    override fun read() = println("Studying technical book: $title")
}

class AudioBook(override val title: String) : Book {
    override fun read() = println("Listening to audiobook: $title")
}

fun bookFactory(type: BookType, title: String): Book {
    return when (type) {
        BookType.FICTION -> FictionBook(title)
        BookType.TECHNICAL -> TechnicalBook(title)
        BookType.AUDIO -> AudioBook(title)
    }
}