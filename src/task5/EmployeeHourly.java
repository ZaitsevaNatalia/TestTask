package task5;

public class EmployeeHourly extends Employee
{
    private double hourlyRate;

    public EmployeeHourly(String name, int id)
    {
        super(name, id);
    }

    public double getAvSalary() {return hourlyRate;}

    @Override
    public double calculateAvSalary(double hourlyRate)
    {
        return this.hourlyRate = 20.8 * 8 * hourlyRate;
    }

}
