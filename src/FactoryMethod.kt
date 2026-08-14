interface BookDataSource {
    fun fetchBooks(): List<String>
}

class LocalBookDataSource : BookDataSource {
    override fun fetchBooks(): List<String> = listOf("Local: Kotlin in Action", "Local: Clean Architecture")
}

class RemoteBookDataSource : BookDataSource {
    override fun fetchBooks(): List<String> = listOf("Remote: Effective Kotlin", "Remote: Android Internals")
}

abstract class BookLoader {

    abstract fun createDataSource(): BookDataSource

    fun loadBooks(): List<String> {
        val dataSource = createDataSource()
        return dataSource.fetchBooks().map { "[Loaded] $it" }
    }
}

class LocalBookLoader : BookLoader() {
    override fun createDataSource(): BookDataSource = LocalBookDataSource()
}

class RemoteBookLoader : BookLoader() {
    override fun createDataSource(): BookDataSource = RemoteBookDataSource()
}