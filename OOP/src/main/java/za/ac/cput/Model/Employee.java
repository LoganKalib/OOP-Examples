package za.ac.cput.Model;

import java.util.Objects;

public class Employee {
    private  final String id, name, surname;

    private Employee(Builder obj){
        this.id = obj.id;
        this.name = obj.name;
        this.surname = obj.surname;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    public static class Builder{
        private String id, name, surname;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder copy(Employee obj){
            this.id = obj.id;
            this.name = obj.name;
            this.surname = obj.surname;
            return this;
        }

        public Employee build(){
            return new Employee(this);
        }
    }
}
