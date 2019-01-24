using System;
using System.Linq;

namespace _9_Extract_Middle_1__2_or_3_Elements
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();

            if (arr.Length == 1)
            {
                PrintElements(arr);
            }
            else if (arr.Length % 2 == 0)
            {
                PrintEvenElements(arr);
            }
            else
            {
                PrintOddElements(arr);
            }
        }

         static void PrintEvenElements(int[] arr)
        {
            int firstNum = arr.Length / 2 - 1;
            int secondNum = arr.Length / 2;

            Console.WriteLine($"{{ {string.Join(", ",arr[firstNum], arr[secondNum])} }}");

        }

        static void PrintElements(int[] n)
        {
            Console.WriteLine($"{{ {string.Join(", ",n)} }}");
        }
        static void PrintOddElements(int[] arr)
        {
            int firstNum = arr.Length / 2 - 1;
            int secondNum = arr.Length / 2;
            int thirdNum = arr.Length / 2 + 1;

            Console.WriteLine($"{{ {string.Join(", ", arr[firstNum], arr[secondNum],arr[thirdNum])} }}");

        }

    }
}
