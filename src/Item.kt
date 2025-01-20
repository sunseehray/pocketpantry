data class Item(
    val id: Int,
    val name: String,
    var price: Double,
    val category: Category = Category.UNCATEGORIZED,
    var quantity: Int = 0,
    var notes: String = "",
)
