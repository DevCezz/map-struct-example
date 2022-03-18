package pl.devcezz.mapstruct.decorator;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @Mappings(
            @Mapping(source = "salary", target = "salaryWithEuro")
    )
    EmployeeDto map(Employee employee);

    @Mappings(
            @Mapping(source = "salaryWithEuro", target = "salary")
    )
    Employee map(EmployeeDto dto);
}
