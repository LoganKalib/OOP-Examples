package za.ac.cput.Repository;

import za.ac.cput.Model.Employee;

import java.util.List;

public interface IEmployeeRepository extends IRepository<Employee,String> {
    List<Employee> getAll();
}
