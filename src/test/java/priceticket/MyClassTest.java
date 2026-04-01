package priceticket;

import io.qameta.allure.*;
import org.example.ticket.ConnectionDB;
import org.example.ticket.MyClass;
import org.example.ticket.Person;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.ReadProperty;

import java.util.Properties;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

@Epic("Функционал билетов")
@Feature("Цена за билет")
public class MyClassTest {

    ConnectionDB connectionDB = new ConnectionDB();
    Properties properties;

    @BeforeSuite
    public void initProperty() {
        properties = ReadProperty.readProperties();
    }

    @BeforeMethod
    public void init() {
        System.out.println("!!!");
    }

    @Story("Цана билета по возрасту")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "Основной тест цены", groups = "smoke")
    public void myFirstTest() throws InterruptedException {
        String userName = properties.getProperty("userName");
        String password = properties.getProperty("password");
        String versions = properties.getProperty("versions");
        String icon = properties.getProperty("icon");
        Integer expectValue = 150;
        Person person = new Person("John Doe", 17, false);
        Integer costTicket = MyClass.getCostTicket(person);

        assertNotNull(costTicket, "Сервис не прислал цену, возможно этот сервис лежит");
        assertEquals(costTicket, expectValue, "Проблема в подсчете суммы по возрасту от 6 до 18");
    }

    @Story("Цана билета по возрасту")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Основной тест цены с софт ассертами", groups = "smoke")
    public void myFirstSoftTest() throws InterruptedException {
        Integer expectValue = 150;
        Person person = new Person("John Doe", 17, false);
        Integer costTicket = MyClass.getCostTicket(person);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(costTicket);
        softAssert.assertEquals(costTicket, expectValue);
        softAssert.assertAll();
    }

    @Story("Цана билета получение ошибки")
    @Severity(SeverityLevel.MINOR)
    @Test(description = "Тест цены на отрицательный возраст", expectedExceptions = RuntimeException.class)
    public void myFallenTest() throws InterruptedException {
        Person person = new Person("John Doe", -1, false);
        Integer costTicket = MyClass.getCostTicket(person);
    }

    @Story("Цана билета получение ошибки")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Тест цены на скорость (быстрее 2 секунд)", timeOut = 2000, groups = {"smoke", "slow"})
    public void myTimeoutTest() throws InterruptedException {
        Person person = new Person("John Doe", 17, false);
        Integer costTicket = MyClass.getCostTicket(person);
    }

    @DataProvider(name = "dataParameterPrice")
    public static Object[][] dataParameterPrice() {
        return new Object[][] {
                {new Person("John Doe", 17, false), 150},
                {new Person("John Doe", 5, false), 0},
                //{new Person("John Doe", 25, false), 300},
                {new Person("John Doe", 80, false), 150},
                {new Person("John Doe", 34, true), 0},
                {new Person("John Doe", 2, true), 0}
        };
    }

    @Story("Цана билета по возрасту")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Всевозможные зены за возраст", dataProvider = "dataParameterPrice")
    public void myParameterizedTest(Person person, Integer expectValue) throws InterruptedException {
        Integer costTicket = MyClass.getCostTicket(person);

        assertNotNull(costTicket);
        assertEquals(costTicket, expectValue);
    }
}
