package task5;

import java.io.Serializable;

public class Employee implements Serializable
{
    private String name;
    private int id;
    private double avSalary;

    public Employee(String name, int id) {
        this.name=name;
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    public String getName() { return name;}

    public double getAvSalary(){return avSalary;}

    public double calculateAvSalary(double salary)
    {

        this.avSalary=salary;
        return avSalary;
    }
}