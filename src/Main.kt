fun main() {
    // test results
    fun displayTestResult(testResult: Boolean) {
        if (testResult) {
            println("-- PASSED :) --")
        } else {
            println("-- FAILED :( --")
        }
    }

    // initialize inventory
    val inventory = Inventory()

    // TEST 1: Add one item to the inventory
    println("Test 1: Add one item to inventory")
    // get size before adding item
    val initSize = inventory.getSize()

    // add one item
    val item = Item(id = inventory.getSize() + 1, name = "Apple", category = Category.FRUITS, quantity = 4)
    inventory.addNewItem(item)

    // check new inventory size
    val newSize = inventory.getSize()

    val test1result = newSize - initSize == 1
    displayTestResult(test1result)

    // TEST 2: Add multiple items to inventory under one category
    println("Test 2: Add multiple items to inventory under one category")
    val dairy = Category.DAIRY
    val dairyItems = listOf(
        "Milk",
        "Cheese",
        "Yogurt",
        "Butter"
    )
    inventory.addBulk(dairyItems, dairy)
    val countOfDairy = inventory.countByCategory(dairy)
    val test2result = countOfDairy == 4
    displayTestResult(test2result)

    // TEST 3: Increase stock of existing item
    // add 3 bananas
    val banana = Item(id = inventory.getSize() + 1, name = "Banana", category = Category.FRUITS, quantity = 3)
    inventory.addNewItem(banana)

    // increase banana stock by 2
    inventory.addStock(id = 6, quantity = 2)
    val newBananaStock = inventory.getItemQuantity(6)
    val test3result = newBananaStock == 5
    displayTestResult(test3result)

    inventory.displayInventory()
}
