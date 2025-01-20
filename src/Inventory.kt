class Inventory {
    private val stockList = mutableListOf<Item>()

    // add a new item
    fun addNewItem(item: Item) {
        stockList.add(item)
    }

    // change stock of existing item
    fun changeStock(id: Int, quantity: Int): Boolean {
        val itemExists = stockList.find { it.id == id }
        if (itemExists != null && getItemQuantity(id) + quantity >= 0) {
            itemExists.quantity += quantity
            return true
        } else {
            println("Error in stock change. Either item not found or stock change resulted in a negative number.")
            return false
        }
    }

    // change price of item by id
    fun changePrice(id: Int, price: Double): Boolean {
        val itemExists = stockList.find { it.id == id }
        if (itemExists != null) {
            itemExists.price = price
            return true
        } else {
            println("Item with id $id not found.")
            return false
        }
    }

    // get price by id
    fun getItemPrice(id: Int): Double {
        return stockList.find { it.id == id }!!.price
    }

    fun getItemQuantity(id: Int): Int {
        return stockList.find { it.id == id }?.quantity ?: 0
    }

    fun getSize(): Int {
        return stockList.size
    }

    fun displayInventory() {
        for (item in stockList) {
            println(item)
        }
    }

    fun displayInventoryByCategory(category: Category) {
        val filteredList = stockList.filter { it.category == category }
        for (item in filteredList) {
            println(item)
        }
    }
}
