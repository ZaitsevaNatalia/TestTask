package task1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));      // 1. Пользователь вводит число n. Напишите программу которая выведет n-й ряд треугольника Паскаля.

        System.out.println("Please enter a number from 0 to 33:");

        String number = reader.readLine();
        int s = Integer.parseInt(number);
        int n = s + 1;

        if (s == 0)
            System.out.print("1");
        else if (s >= 2)
        {
            int [][] p = new int[n][];

            p[0] = new int [1];
            p[1] = new int [2];
            p[0][0] = 1;
            p[1][0] = p[1][1] = 1;

            System.out.print("1 ");

            for (int i = 2; i < n; i++)
            {
                p[i] = new int[i + 1];

                p[i][0] = 1;
                for (int j = 1; j < i; j++)
                {
                    p[i][j] = p[i - 1][j - 1] + p[i - 1][j];
                    if (i == s)
                        System.out.print((p[i][j] = p[i - 1][j - 1] + p[i - 1][j]) + " ");
                }
                p[i][i] = 1;
            }
            System.out.println("1");
        }
        else if (s == 1)
            System.out.print("1 1");
    }
}
