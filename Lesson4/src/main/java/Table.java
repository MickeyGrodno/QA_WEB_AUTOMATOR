import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class Table {

    private ArrayList<ArrayList<WebElement>> tableInArray;

    public Table(WebElement currentTable) {

        tableInArray = new ArrayList<ArrayList<WebElement>>();
        ArrayList<WebElement> allLines = (ArrayList<WebElement>) currentTable.findElements(By.tagName("tr"));

        tableInArray.add((ArrayList<WebElement>) allLines.get(0).findElements(By.tagName("th")));

        for (int i = 1; i < allLines.size(); i++) {
            tableInArray.add((ArrayList<WebElement>) allLines.get(i).findElements(By.tagName("td")));
        }
    }

    public void getAllTitles() {
        System.out.print("The table has the following headings: ");
        for (WebElement element : tableInArray.get(0)) {

            System.out.print(element.getText()+" ");
        }
        System.out.println();
    }

    public void getNumberOfLines() {
        System.out.println("Number of lines: "+tableInArray.size());
    }

    public void getCurrentCell(int line, int column) {
        System.out.println("cell value : " +tableInArray.get(line).get(column-1).getText());
    }

    public void getCurrentCell(int line, String column) {
        int columnNumber = 0;
        for (int i = 0; i < tableInArray.get(0).size(); i++) {
            if (tableInArray.get(0).get(i).getText().equals(column)) {
                columnNumber = i+1;
            }
        }
        getCurrentCell(line, columnNumber);
    }
}