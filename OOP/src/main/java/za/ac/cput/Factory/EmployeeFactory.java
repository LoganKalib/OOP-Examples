package za.ac.cput.Factory;

import za.ac.cput.Model.Employee;
import za.ac.cput.Utils.Helper;

public class EmployeeFactory {

    public static Employee buildEmployee(String id, String name, String surname){
        if(Helper.isNullOrEmpty(id) || Helper.isNullOrEmpty(name) || Helper.isNullOrEmpty(surname)){
            return null;
        }
        return new Employee.Builder().setId(id).setSurname(name).setSurname(surname).build();
    }
    public static Employee buildEmployee(String name, String surname){
        if(Helper.isNullOrEmpty(name) || Helper.isNullOrEmpty(surname)){
            return null;
        }
        return new Employee.Builder().setId(Helper.generateId()).setName(name).setSurname(surname).build();
    }
}
