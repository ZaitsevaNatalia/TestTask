package task2;

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));      // 2. Пользователь вводит числа a, b, n. Напишите программу которая рассчитает значение полинома n-й степени.

        System.out.println("Please enter a number (degree of number) > 0:");

        String number = reader.readLine();
        int s = Integer.parseInt(number);
        int n = s + 1;

        System.out.println("Please enter two number >= 0:");
        String number2 = reader.readLine();
        int a = Integer.parseInt(number2);
        String number3 = reader.readLine();
        int b = Integer.parseInt(number3);

        int[] k = new int[n]; // cтворюємо массив коефіцієнтів;

        if (s >= 2)
        {
            int [][] p = new int[n][];

            p[0] = new int [1];
            p[1] = new int [2];
            p[0][0] = 1;
            p[1][0] = p[1][1] = 1;

            int c = 0;
            int t = s;
            double sum = 0;
            String summ = "a^" + s + "+";

            for (int i = 2; i < n; i++)
            {
                p[i] = new int[i + 1];

                p[i][0] = 1;
                k[0] = 1;

                for (int j = 1; j < i; j++)
                {
                    p[i][j] = p[i - 1][j - 1] + p[i - 1][j];
                    if (i == s)
                    {
                        k[j] = p[i - 1][j - 1] + p[i - 1][j];
                        t--;
                        c ++;
                        sum += k[j]*Math.pow(a, t)*Math.pow(b, c);
                        summ = summ + k[j] + "*a^" + t + "*b^" + c + "+";
                    }
                }

                p[i][i] = 1;
                k[s] = 1;
            }
            sum = Math.pow(b, s) + sum + Math.pow(a, s);
            summ = summ + "b^" + s;
            System.out.println(summ + "=" + sum);
        }
        else if (s == 1)
        {
            int sum = a + b;
            System.out.print("a + b = " + sum);
        }
        else if (s <= 0)
            System.out.println("You enter wrong number!");
    }
}

