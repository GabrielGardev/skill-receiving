using System;
using System.Linq;

namespace _03_Arrays_and_Methods_More_EXE
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();

            int min = int.MaxValue;
            int max = int.MinValue;
            int sum = arr.Sum();
            double average = 1.0 * sum / arr.Length;

            for (int i = 0; i < arr.Length; i++)
            {
                if (arr[i] > max)
                {
                    max = arr[i];
                }
            }
            for (int i = 0; i < arr.Length; i++)
            {
                if (arr[i] < min)
                {
                    min = arr[i];
                }
            }

            Console.WriteLine($"Min = {min}\r\n" +
                $"Max = {max}\r\n" +
                $"Sum = {sum}\r\n" +
                $"Average = {average}");
        }
    }
}
