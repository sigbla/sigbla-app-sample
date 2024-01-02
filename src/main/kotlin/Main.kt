import sigbla.app.*
import sigbla.charts.*

fun main() {
    TableView[Port] = 8080

    val dataTable = Table["data"]

    dataTable["Title", 0] = "Chart title"

    dataTable["X Labels", 0] = "X1"
    dataTable["X Labels", 1] = "X2"
    dataTable["X Labels", 2] = "X3"

    dataTable["Series 1", 0] = 1.2
    dataTable["Series 1", 1] = 2.3
    dataTable["Series 1", 2] = 1.9

    dataTable["Series 2", 0] = 1.5
    dataTable["Series 2", 1] = 2.1
    dataTable["Series 2", 2] = 2.2

    dataTable["Series 3", 0] = 2.3
    dataTable["Series 3", 1] = 2.7
    dataTable["Series 3", 2] = 0.8

    val chartTable = Table["chart"]
    val tableView = TableView[chartTable]

    // Define the line chart using data from cells
    tableView["Chart", 0] = line(
        dataTable["Title", 0],
        dataTable["X Labels", 0]..dataTable["X Labels", 2],
        "Series 1" to dataTable["Series 1", 0]..dataTable["Series 1", 2],
        "Series 2" to dataTable["Series 2", 0]..dataTable["Series 2", 2],
        "Series 3" to dataTable["Series 3", 0]..dataTable["Series 3", 2],
    )

    tableView[0][CellHeight] = 250
    tableView["Chart"][CellWidth] = 550

    val url = show(tableView)
    println("Table URL: $url")
}
