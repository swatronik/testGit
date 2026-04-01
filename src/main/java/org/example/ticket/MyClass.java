package org.example.ticket;

import io.qameta.allure.Step;

public class MyClass {

    @Step("Получение цены для пользователя")
    public static Integer getCostTicket(Person person) throws InterruptedException {
        Thread.sleep(50);
        Integer commonPrice = 300;
        if (person.getAge() < 0) {
            throw new RuntimeException("Возраст не можнт быть меньше 0");
        }
        if (person.getBeneficiary()) {
            return 0;
        }
        if (person.getAge() < 6) {
            return 0;
        }
        if (person.getAge() < 18) {
            return commonPrice / 2;
        }
        if (person.getAge() < 60) {
            return commonPrice;
        }
        return commonPrice / 2;
    }
}
