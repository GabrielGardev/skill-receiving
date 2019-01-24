using System;
using System.Linq;

namespace _3_Sum__Min__Max__Average
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            int[] numbers = new int[n];

            for (int i = 0; i < n; i++)
            {
                int num = int.Parse(Console.ReadLine());
                numbers[i] = num;
            }
            int sum = numbers.Sum();
            int min = numbers.Min();


            Console.WriteLine($"Sum = {sum}\r\nMin = {min}\r\nMax = {numbers.Max()}\r\nAverage = {numbers.Average()}");
        }
    }
}
