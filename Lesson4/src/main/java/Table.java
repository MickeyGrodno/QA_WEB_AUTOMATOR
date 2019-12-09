import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class Table {

    private List<List<WebElement>> tableInArray;
    private List<WebElement> columnsName;

    Table(WebElement currentTable) {

        tableInArray = new ArrayList<List<WebElement>>();
        List<WebElement> allLines = currentTable.findElements(By.tagName("tr"));
        columnsName = allLines.get(0).findElements(By.tagName("th"));

        for (int i = 1; i < allLines.size(); i++) {
            tableInArray.add(allLines.get(i).findElements(By.tagName("td")));
        }
    }

    void printAllTitles() {
        System.out.print("The table has the following headings: ");
        for (WebElement element : columnsName) {
            System.out.print(element.getText()+" ");
        }
        System.out.println();
    }

    void printNumberOfLines() {
        System.out.println("Number of lines: "+tableInArray.size());
    }

    void printCurrentCell(int line, int column) {
        System.out.println("cell value : " +tableInArray.get(line-1).get(column-1).getText());
    }

    private int getColumnNumber(String column) {
        for (int i = 0; i < columnsName.size(); i++) {
            if(columnsName.get(i).getText().equals(column)){
                return i+1;
            }
        }
        throw new NotFoundException("Element with name "+column+" not found.");
    }

    void printCurrentCell(int line, String column) {
        int columnNumber = getColumnNumber(column);
        printCurrentCell(line, columnNumber);
    }
}