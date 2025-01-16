class Inventory () {
    private val stockList = mutableListOf<Item>()

    // add a new item
    fun addNewItem(item: Item) {
        stockList.add(item)
    }

    // add items from list under one category
    fun addBulk(list: List<String>, category: Category) {
        for (item in list) {
            val itemToAdd = Item(id = this.getSize() + 1, name = item, category = category)
            stockList.add(itemToAdd)
        }
    }

    // increase stock of existing item
    fun addStock(id: Int, quantity: Int) {
        val itemExists = stockList.find { it.id == id }
        if (itemExists != null) {
            itemExists.quantity += quantity
        } else {
            println("Item with id $id not found.")
        }
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

    fun countByCategory(category: Category): Int {
        var numByCategory = stockList.count { it.category == category }
        return numByCategory
    }

}
