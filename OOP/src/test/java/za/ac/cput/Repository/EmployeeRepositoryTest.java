package za.ac.cput.Repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Factory.EmployeeFactory;
import za.ac.cput.Model.Employee;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeRepositoryTest {

    private static IEmployeeRepository repository = EmployeeRepository.getRepository();
    private Employee emp = EmployeeFactory.buildEmployee("Logan", "Coghill");

    @Test
    @Order(1)
    void create() {
        Employee created = repository.create(emp);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    @Order(2)
    void read() {
        Employee read = repository.read(emp.getId());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(3)
    void update() {
        Employee newEmp = new Employee.Builder().copy(emp).setName("Someone").build();
        Employee updated = repository.update(newEmp);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Order(5)
    void delete() {
        assertTrue(repository.delete(emp.getId()));
        System.out.println("Employee Deleted...");
    }

    @Test
    @Order(4)
    void getAll(){
        System.out.println(repository.getAll());
    }
}