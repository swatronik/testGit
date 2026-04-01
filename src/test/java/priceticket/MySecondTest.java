package priceticket;

import org.example.ticket.MyClass;
import org.example.ticket.Person;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MySecondTest {

    @Test
    public void myFirstTest() throws InterruptedException {
        Integer expectValue = 150;
        Person person = new Person("John Doe", 17, false);
        Integer costTicket = MyClass.getCostTicket(person);

        Assert.assertNotNull(costTicket, "Сервис не прислал цену, возможно этот сервис лежит");
        Assert.assertEquals(costTicket, expectValue, "Проблема в подсчете суммы по возрасту от 6 до 18");
    }
}
