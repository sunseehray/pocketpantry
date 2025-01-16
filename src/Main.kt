//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    // app menu
    fun DisplayMenu() {
        println("-- Menu --")
        println("1. Add stock")
        println("2. Remove stock")
        println("3. Create a new product")
        println("4. See my inventory")
        println("5. Exit")
        println("What would you like to do? Enter the number only.")
    }

    do {
        DisplayMenu()
        var choice = readLine()
        println("You selected $choice")
        when (choice) {
            "1" -> println("Add stock")
            "2" -> println("Remove stock")
            "3" -> println("Create a new product")
            "4" -> println("See my inventory")
            else -> println("Error")
        }
    } while (choice != "5")





}