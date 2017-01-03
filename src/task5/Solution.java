package task5;

import java.io.*;
import java.util.ArrayList;


public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InfoInputter info = new InfoInputter();

        ArrayList<Employee> myList = info.InputEmpFP("fixed", "salary");
        myList = info.InputEmpFP("hourly", "hourly rate");

        Services services = new Services();
        myList = services.Sort(myList);

        services.printAllEmpInfo(myList);
        services.printFirstEmpInfo(myList);
        services.printIdLastEmp(myList);

        services.writeIntoFile(myList);
        ArrayList<Employee> myList1 = services.readFromFile();
    }
}







