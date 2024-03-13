package za.ac.cput.Repository;

import za.ac.cput.Model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository{
    private static IEmployeeRepository repository = null;
    private final List<Employee> empList;

    private EmployeeRepository(){
        empList = new ArrayList<Employee>();
    }
    public static IEmployeeRepository getRepository(){
        if(repository== null){
            repository = new EmployeeRepository();
        }
        return repository;
    }
    @Override
    public List<Employee> getAll() {
        return empList;
    }

    @Override
    public Employee create(Employee obj) {
        boolean success = empList.add(obj);
        if(success)
            return obj;

        return null;
    }

    @Override
    public Employee read(String s) {
        for(Employee e : empList){
            if(e.getId().equals(s)){
                return e;
            }
        }
        return null;
    }

    @Override
    public Employee update(Employee obj) {
        String id = obj.getId();
        Employee empOld = read(id);
        if(empOld == null)
            return null;
        boolean success = delete(id);
        if(success){
            if(empList.add(obj)) {
                return obj;
            }
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        Employee employeeToDelete = read(s);
        if(employeeToDelete == null)
            return false;

        return empList.remove(employeeToDelete);
    }
}
