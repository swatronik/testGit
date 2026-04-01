package org.example.ticket;

public class Person {

    private String fio;
    private Integer age;
    private Boolean isBeneficiary;

    public Person(String fio, Integer age, Boolean isBeneficiary) {
        this.fio = fio;
        this.age = age;
        this.isBeneficiary = isBeneficiary;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBeneficiary() {
        return isBeneficiary;
    }

    public void setBeneficiary(Boolean beneficiary) {
        isBeneficiary = beneficiary;
    }

    @Override
    public String toString() {
        return "ticket.Person{" +
                "fio='" + fio + '\'' +
                ", age=" + age +
                ", isBeneficiary=" + isBeneficiary +
                '}';
    }
}
