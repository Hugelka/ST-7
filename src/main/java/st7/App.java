package st7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {

    static final String WEB_URL = "http://www.papercdcase.com/index.php";
    static final String CHROME_DRIVER_PATH = "C:\\chromedriver-win64\\chromedriver.exe";

    static final String[] ELEMENT_XPATHS = {
            "/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[1]/td[2]/input",
            "/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[2]/td[2]/input",
            "/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[3]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/input",
            "/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[3]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/input",
            "/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[3]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/input",
            "/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[3]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[4]/td[2]/input",
            "/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[3]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[5]/td[2]/input",
            "/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[3]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[6]/td[2]/input",
            "/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[3]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[7]/td[2]/input",
            "/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[3]/td[2]/table/tbody/tr/td[1]/table/tbody/tr[8]/td[2]/input",
            "/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[3]/td[2]/table/tbody/tr/td[2]/table/tbody/tr[1]/td[2]/input",
            "/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[3]/td[2]/table/tbody/tr/td[2]/table/tbody/tr[2]/td[2]/input",
            "/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[3]/td[2]/table/tbody/tr/td[2]/table/tbody/tr[3]/td[2]/input",
            "/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[3]/td[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td[2]/input",
            "/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[3]/td[2]/table/tbody/tr/td[2]/table/tbody/tr[5]/td[2]/input",
            "/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[3]/td[2]/table/tbody/tr/td[2]/table/tbody/tr[6]/td[2]/input",
            "/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[3]/td[2]/table/tbody/tr/td[2]/table/tbody/tr[7]/td[2]/input",
            "/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[3]/td[2]/table/tbody/tr/td[2]/table/tbody/tr[8]/td[2]/input",
            "/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[4]/td[2]/input[2]",
            "/html/body/table[2]/tbody/tr/td[1]/div/form/table/tbody/tr[5]/td[2]/input[2]",
            "/html/body/table[2]/tbody/tr/td[1]/div/form/p/input"
    };

    // Массив значений для заполнения форм
    static final String[] VALUES = {
            "David Bowie",  // Artist
            "Hunky Dory",   // Title
            "Changes",      // Track1
            "Oh! You Pretty Things", // Track2
            "Eight Line Poem", // Track3
            "Life on Mars?", // Track4
            "Kooks",        // Track5
            "Quicksand",    // Track6
            "",             // Track7
            "",             // Track8
            "Fill Your Heart", // Track9
            "Andy Warhol",  // Track10
            "Song for Bob Dylan", // Track11
            "Queen Bitch",  // Track12
            "The Bewlay Brothers", // Track13
            "",             // Track14
            "",             // Track15
            "",             // Track16
    };

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        WebDriver webDriver = new ChromeDriver();
        try {
            webDriver.get(WEB_URL);
            fillTextFields(webDriver);
            clickButtons(webDriver);
        } catch (Exception e) {
            handleError(e);
        }
    }

    private static void fillTextFields(WebDriver webDriver) {
        int[] textFieldIndexes = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

        for (int index : textFieldIndexes) {
            String xPath = ELEMENT_XPATHS[index];
            String value = VALUES[index];
            webDriver.findElement(By.xpath(xPath)).sendKeys(value);
            sleep();
        }
    }

    private static void clickButtons(WebDriver webDriver) {
        try {
            clickElement(webDriver, 18); // Type
            clickElement(webDriver, 19); // Paper
            clickElement(webDriver, 20); // CreateBtn
        } catch (Exception e) {
            handleError(e);
        }
    }

    private static void clickElement(WebDriver webDriver, int index) {
        String xPath = ELEMENT_XPATHS[index];
        webDriver.findElement(By.xpath(xPath)).click();
    }

    private static void sleep() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void handleError(Exception e) {
        System.err.println("Error: " + e.getMessage());
        e.printStackTrace();
    }
}