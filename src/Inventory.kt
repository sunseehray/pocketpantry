import java.time.LocalDate

class Inventory {
    private val products = mutableListOf<Product>()
    private val stockList = mutableListOf<Stock>()

    // Add a product
    fun addProduct(name: String, category: Category): Product {
        val product = Product(id = products.size + 1, name = name, category = category)
        products.add(product)
        return product
    }

    // Add a stock
    fun addStock(productId: Int, quantity: Int, expiryDate: LocalDate) {
        repeat(quantity) {
            stockList.add(Stock(productId = productId, quantity = 1, expiryDate = expiryDate))
        }
    }

    // remove stock
    fun reduceStock(productId: Int, expiryDate: LocalDate, quantity: Int): Boolean {
        val stock = stockList.find { it.productId == productId && it.expiryDate == expiryDate }
        return if (stock != null && stock.quantity >= quantity) {
            stock.quantity -= quantity
            if (stock.quantity == 0) stockList.remove(stock)
            true
        } else {
            false // not enough stock or stock not found
        }
    }

    // Get inventory list
    fun getInventory(sortByExpiry: Boolean = false): List<Pair<Product, List<Stock>>> {
        val inventory = products.map { product ->
            product to stockList.filter { it.productId == product.id }
        }
        return if (sortByExpiry) {
            inventory.map { it.first to it.second.sortedBy { stock -> stock.expiryDate }}
        } else inventory
    }

    // Filter out-of-stock products
    fun getOutOfStockProducts(): List<Product> {
        return products.filter { product ->
            stockList.none { it.productId == product.id }
        }
    }

    // Bulk addition
    fun addBulkStock(productId: Int, quantity: Int, expiryDate: LocalDate) {
        stockList.add(Stock(productId = productId, quantity = quantity, expiryDate = expiryDate))
    }

    // manage expiry dates by group
    fun getStocksGroupedByExpiry(): Map<LocalDate, List<Stock>> {
        return stockList.groupBy { it.expiryDate }
    }
}