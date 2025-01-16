data class Item(
    val id: Int,
    val name: String,
    val category: Category = Category.UNCATEGORIZED,
    var quantity: Int = 0,
    var notes: String = "",
)
