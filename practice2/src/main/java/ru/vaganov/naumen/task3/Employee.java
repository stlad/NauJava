package ru.vaganov.naumen.task3;

public class Employee {
    public Employee(String fullname, Integer age, Double salary, String department){
        this.fullname = fullname;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    private String fullname;

    private Integer age;

    private Double salary;

    private String department;

    @Override
    public String toString(){
        return String.format("%s (%d лет) - %s / ЗП: %s",fullname, age, department, salary);
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
