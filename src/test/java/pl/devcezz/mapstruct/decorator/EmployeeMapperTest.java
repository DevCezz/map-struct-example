package pl.devcezz.mapstruct.decorator;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class EmployeeMapperTest {

    @Test
    void should_map_employee_to_employee_dto() {
        Employee employee = new Employee(
                "Jan",
                "Kowalski",
                BigDecimal.valueOf(2800.00)
        );

        EmployeeDto result = EmployeeMapper.INSTANCE.map(employee);

        assertThat(result.getFirstname()).isEqualTo("Jan");
        assertThat(result.getSurname()).isEqualTo("Kowalski");
        assertThat(result.getSalaryWithEuro()).isEqualTo("2800.00€");
    }

    @Test
    void should_map_employee_dto_to_employee() {
        EmployeeDto dto = new EmployeeDto(
                "Albert",
                "Poniatowski",
                "9020€"
        );

        Employee result = EmployeeMapper.INSTANCE.map(dto);

        assertThat(result.getFirstname()).isEqualTo("Albert");
        assertThat(result.getSurname()).isEqualTo("Poniatowski");
        assertThat(result.getSalary()).isEqualTo(BigDecimal.valueOf(9020.00));
    }
}
