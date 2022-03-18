package pl.devcezz.mapstruct.decorator;

public class EmployeeDto {

    private final String firstname;
    private final String surname;
    private final String salaryWithEuro;

    public EmployeeDto(String firstname, String surname, String salaryWithEuro) {
        this.firstname = firstname;
        this.surname = surname;
        this.salaryWithEuro = salaryWithEuro;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getSalaryWithEuro() {
        return salaryWithEuro;
    }
}
