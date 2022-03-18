package pl.devcezz.mapstruct.decorator;

import java.math.BigDecimal;

public class Employee {

    private final String firstname;
    private final String surname;
    private final BigDecimal salary;

    public Employee(String firstname, String surname, BigDecimal salary) {
        this.firstname = firstname;
        this.surname = surname;
        this.salary = salary;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public BigDecimal getSalary() {
        return salary;
    }
}
