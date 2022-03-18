package pl.devcezz.mapstruct.decorator;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Jsr330EmployeeDecoratorMapper implements EmployeeMapper {

    private static final String SALARY_FORMAT = "%1$.2f€";
    private static final String SALARY_REGEX = "\\d+\\.\\d{2}";

    @Inject
    @Named("pl.devcezz.mapstruct.decorator.EmployeeMapperImpl_")
    private EmployeeMapper delegate;

    @Override
    public EmployeeDto map(Employee employee) {
        EmployeeDto dto = delegate.map(employee);
        return dto.toBuilder()
                .salaryWithEuro(formatSalary(employee.getSalary()))
                .build();
    }

    @Override
    public Employee map(EmployeeDto dto) {
        Employee employee = delegate.map(dto);
        return employee.toBuilder()
                .salary(extractSalary(dto.getSalaryWithEuro()))
                .build();
    }

    private String formatSalary(BigDecimal salary) {
        return String.format(Locale.US, SALARY_FORMAT, salary);
    }

    private BigDecimal extractSalary(String salary) {
        Pattern pattern = Pattern.compile(SALARY_REGEX);
        Matcher matcher = pattern.matcher(salary);
        BigDecimal result = matcher.find() ? new BigDecimal(matcher.group(0)) : BigDecimal.ZERO;
        return result.setScale(2, RoundingMode.HALF_UP);
    }
}
