package task3;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));                    // 3. Пользователь вводит строку с числами. Напишите программу которая выведет все числа, присутствующие в строке, а также выведет максимальное и минимальное число. Числом является любая последовательность цифр. Если между двумя числами находится знак математической операции – результатом будет результат вычисления математической операции.

        System.out.println("Enter string with numbers!");

        String s = reader.readLine();

        String regex = "(\\d+[\\+]\\d+|\\d+[\\-]\\d+|\\d+[\\*]\\d+|\\d+[\\/]\\d+|\\d+[\\%]\\d+|\\d+)";
        Pattern p2 = Pattern. compile (regex);
        Matcher m = p2.matcher(s);

        ArrayList<Integer> list = new ArrayList<>();

        while (m.find())
        {
            String w = m.group();

            if (w.contains("+")|w.contains("-")|w.contains("*")|w.contains("/")|w.contains("%"))
            {
                String[] arrayMy = w.split("\\D");

                String number1 = arrayMy[0];
                String number2 = arrayMy[1];

                int a = Integer.parseInt(number1);
                int b = Integer.parseInt(number2);

                int c;

                if (w.contains("+"))
                {
                    c = a + b;
                    list.add(c);
                }
                else if (w.contains("-"))
                {
                    c = a - b;
                    list.add(c);
                }
                else if (w.contains("*"))
                {
                    c = a * b;
                    list.add(c);
                }
                else if (w.contains("/"))
                {
                    c = a / b;
                    list.add(c);
                }
                else if (w.contains("%"))
                {
                    c = a % b;
                    list.add(c);
                }
            }
            else
            {
                list.add(Integer.parseInt(w));
            }
        }

        for (int i = 0; i < list.size(); i ++)
        {
            System.out.println(list.get(i));
        }

        int min = list.get(0);
        int max = list.get(0);
        int array1[] = new int[list.size()];
        for(int j = 0; j < list.size(); j ++)
        {
            array1[j] = list.get(j);
            if (array1[j] > max)
                max = array1[j];
            if (array1[j] < min )
                min = array1[j];
        }
        System.out.println("max: " + max);
        System.out.println("min: " + min);
    }
}

