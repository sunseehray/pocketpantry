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

    /* TEST 1:
        Add one item to the inventory
     */
    println("Test 1: Add one item to inventory")
    // get size before adding item
    val initSize = inventory.getSize() // 0

    // add one item
    var itemId = inventory.getSize() + 1
    val apple = Item(itemId, "Apple", 2.50, Category.FRUITS, 4)
    inventory.addNewItem(apple)

    // check new inventory size
    val newSize = inventory.getSize() // 1

    var testResult = newSize - initSize == 1
    displayTestResult(testResult)

    /* TEST 2:
        Increase stock of existing item
     */
    println("Test 2a: Increase stock of existing item.")
    // add 3 apples
    itemId = 1
    if (inventory.changeStock(itemId, 3)) {
        val newAppleStock = inventory.getItemQuantity(itemId)
        testResult = newAppleStock == 7
        displayTestResult(testResult)
    } else {
        println("Failed to increase stock for product $itemId.")
        displayTestResult(false)
    }

    // increase stock of non-existing item
    println("Test 2b: Increase stock of non-existing item.")
    itemId = 5
    var changeStockResult = inventory.changeStock(itemId, 2) // should return FALSE to pass
    if (!changeStockResult) displayTestResult(true)

    /* Test 3:
        Decrease stock
     */
    // decrease apples by 3
    println("Test 3a: Decrease stock of existing item.")
    itemId = 1
    changeStockResult = inventory.changeStock(itemId, -3)
    if (changeStockResult) {
        testResult = inventory.getItemQuantity(1) == 4
        displayTestResult(testResult)
    } else {
        println("Error decreasing stock for product $itemId.")
        displayTestResult(false)
    }
    println("Test 3b: Decrease stock to negative.")
    itemId = 1
    changeStockResult = inventory.changeStock(itemId, -10)
    if (!changeStockResult) {
        testResult = inventory.getItemQuantity(1) == 4 // stayed the same at 4
        displayTestResult(testResult)
    } else {
        println("Error not allowing stock below zero.")
        displayTestResult(false)
    }

    /* Test 4:
    Change item price
     */
    println("Test 4: Change price of existing item.")
    itemId = 1
    val changePriceResult = inventory.changePrice(itemId, 1.23)
    if (changePriceResult) {
        testResult = inventory.getItemPrice(itemId) == 1.23
        displayTestResult(testResult)
    } else {
        println("Error changing price for product $itemId.")
        displayTestResult(false)
    }

    /* DISPLAYING INVENTORY */
    println("\n--DISPLAYING INVENTORY--")

    // Add more items
    val milk = Item(inventory.getSize() + 1, "Milk", 2.50, Category.DAIRY, 4)
    inventory.addNewItem(milk)
    val cheese = Item(inventory.getSize() + 1, "Cheese", 3.50, Category.DAIRY, 1)
    inventory.addNewItem(cheese)
    val tuna = Item(inventory.getSize() + 1, "Tuna", 6.00, Category.PROTEIN, 6)
    inventory.addNewItem(tuna)

    println("DAIRY LIST")
    inventory.displayInventoryByCategory(Category.DAIRY)

    println("\nCOMPLETE LIST")
    inventory.displayInventory()



}
