package pl.devcezz.mapstruct.decorator;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "default")
@DecoratedWith(DefaultEmployeeDecoratorMapper.class)
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDto map(Employee employee);

    Employee map(EmployeeDto dto);
}
