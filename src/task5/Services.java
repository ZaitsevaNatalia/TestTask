package task5;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Services
{
    public ArrayList<Employee> Sort(ArrayList<Employee> myList)
    {
        Collections.sort(                                                  //We sorts our collection primarily for average salary (in ascending), if wages are equal we compare their names.
                myList,
                new Comparator<Employee>() {
                    public int compare(Employee e1, Employee e2) {
                        if (e1.getAvSalary() < e2.getAvSalary())
                            return -1;
                        if (e1.getAvSalary() > e2.getAvSalary())
                            return 1;
                        return e1.getName().compareTo(e2.getName())*(- 1);

                    }
                }
        );
        Collections.reverse(myList);                //Now we have collection for ascending. We do reverse to solve problem.
        return myList;
    }

    public void printAllEmpInfo(ArrayList<Employee> myList)
    {
        System.out.println("Information about all employees:");
        for (Employee employee : myList)
        {
            System.out.println ("ID: " + employee.getId() + ", Name: " + employee.getName()+ ", Average Salary: " + employee.getAvSalary());      //Print information about all employees. (Problem a))
        }
    }

    public void printFirstEmpInfo(ArrayList<Employee> myList)
    {
        System.out.println("\n" + "Information about 5 first employees:");
        for (int i = 0; i < 5; i ++)
        {
            System.out.println ("ID: " + myList.get(i).getId() + ", Name: " + myList.get(i).getName()+ ", Average Salary: " + myList.get(i).getAvSalary());  // (Problem b))
        }
    }

    public void printIdLastEmp(ArrayList<Employee> myList)
    {
        int size = myList.size();
        System.out.print("\n" + "ID about 3 last employees from collection:");
        for (int i = size - 4; i < size; i ++)
        {
            System.out.println ("ID: " + myList.get(i).getId());                                     // (Problem c))
        }
    }

    public void writeIntoFile(ArrayList<Employee> myList)
    {
        ObjectOutputStream out = null;
        try
        {
            out = new ObjectOutputStream(new BufferedOutputStream(
                    new FileOutputStream("C:\\Temp\\myFile.dat")));                        // Create code for writing collection of objects into file. (Problem d))
            out.writeObject(myList);
        }
        catch ( IOException ex )
        {
            System.out.println("A file write error");
        }
        finally
        {
            if ( out != null )
                try
                {
                    out.close();
                }
                catch ( IOException ex )
                {
                    ex.printStackTrace();
                }
        }
    }

    public ArrayList<Employee> readFromFile() throws Exception
    {
        ArrayList<Employee> myList1 = new ArrayList<Employee>();
        ObjectInputStream in = null;                                                                   //Create code for reading collection from file into new list.
        try {
            in = new ObjectInputStream(new BufferedInputStream(
                    new FileInputStream("C:\\Temp\\myFile.dat")));
            myList1 = (ArrayList)in.readObject();
        }
        catch (ObjectStreamException ex)
        {
            System.out.println("The incorrect format of incoming file.");
        }
        catch ( FileNotFoundException ex )
        {
            System.out.println("The file not find.");
        }

        finally
        {
            if ( in != null )
                try
                {
                    in.close();
                }
                catch ( IOException ex )
                {
                    ex.printStackTrace();
                }
        }
        return myList1;
    }
}