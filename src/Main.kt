fun main() {
    val inventory = Inventory()

    println("Welcome to Pocket Pantry!")
    while (true) {
        println("\nChoose an action:")
        println("1. Add Product")
        println("2. Add Stock")
        println("3. Reduce Stock")
        println("4. View Inventory")
        println("5. View Out-of-Stock Products")
        println("6. Exit")

        when (readLine()?.toIntOrNull()) {
            1 -> {
                println("Enter product name:")
                val name = readLine() ?: ""
                println("Choose category (1: Protein, 2: Dairy, 3: Vegetables, 4: Grains, 5: Fruits, 6: Others):")
                val categoryChoice = readLine()?.toIntOrNull()
                val category = when (categoryChoice) {
                    1 -> Category.PROTEIN
                    2 -> Category.DAIRY
                    3 -> Category.VEGETABLES
                    4 -> Category.GRAINS
                    5 -> Category.FRUITS
                    else -> Category.OTHERS
                }
                val product = inventory.addProduct(name, category)
                println("Product added: $product")
            }

            2 -> {
                println("Enter product ID to add stock:")
                val productId = readLine()?.toIntOrNull() ?: -1
                println("Enter quantity:")
                val quantity = readLine()?.toIntOrNull() ?: 0

                inventory.addStock(productId, quantity)
                println("Added $quantity units of stock for product ID $productId.")
            }

            3 -> {
                println("Enter product ID to reduce stock:")
                val productId = readLine()?.toIntOrNull() ?: -1
                println("Enter quantity:")
                val quantity = readLine()?.toIntOrNull() ?: 0

                val success = inventory.reduceStock(productId, quantity)
                if (success) {
                    println("Reduced $quantity units of stock for product ID $productId.")
                } else {
                    println("Failed to reduce stock. Not enough stock.")
                }
            }

            4 -> {
                val inventoryList = inventory.getInventory()

                println("\nCurrent Inventory:")
                inventoryList.forEach { (product, stocks) ->
                    println("Product: ${product.name} (${product.category})")
                    stocks.forEach {
                        println("  Quantity: ${it.quantity}")
                    }
                }
            }

            5 -> {
                val outOfStockProducts = inventory.getOutOfStockProducts()
                if (outOfStockProducts.isEmpty()) {
                    println("No out-of-stock products!")
                } else {
                    println("\nOut-of-Stock Products:")
                    outOfStockProducts.forEach { println("${it.name} (${it.category})") }
                }
            }

            6 -> {
                println("Goodbye!")
                break
            }

            else -> {
                println("Invalid choice. Please try again.")
            }
        }
    }
}
