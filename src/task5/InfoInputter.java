package task5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class InfoInputter
{
    BufferedReader reader;
    private ArrayList<Employee> myList;

    public InfoInputter()
    {
        reader = new BufferedReader(new InputStreamReader(System.in));
        myList = new ArrayList<Employee>();
    }
    public ArrayList<Employee> InputEmpFP(String kind, String kindOfPayment) throws Exception
    {
        System.out.println("Enter the number of employees with " + kind + " payment:");
        String number = reader.readLine();
        int n = Integer.parseInt(number);

        int[] idFP = new int[n];
        System.out.println("Enter the id of employees with " + kind + " payment:");
        for (int i = 0; i < n; i ++)
        {
            String id = reader.readLine();
            int idOfEmp = Integer.parseInt(id);
            idFP[i] = idOfEmp;
        }

        String[] names = new String[n];
        System.out.println("Enter the name of employees with " + kind + " payment:");
        for (int i = 0; i < n; i ++)
        {
            String name = reader.readLine();
            names[i] = name;
        }

        double[] salary = new double[n];
        System.out.println("Enter the " + kindOfPayment + " of employees with " + kind + " payment:");
        for (int i = 0; i < n; i ++)
        {
            String salaryOfEmp = reader.readLine();
            double salaryOfEmpFix = Double.parseDouble(salaryOfEmp);
            salary[i] = salaryOfEmpFix;
        }

        for (int i = 0; i < n; i ++)
        {
            if (kind == "fixed")
            {
                Employee employee1 = new Employee(names[i], idFP[i]);
                employee1.calculateAvSalary(salary[i]);
                myList.add(employee1);
            }
            else if (kind == "hourly")
            {
                EmployeeHourly employee2 = new EmployeeHourly(names[i], idFP[i]);
                employee2.calculateAvSalary(salary[i]);
                myList.add(employee2);
            }
        }
        return myList;
    }
}
