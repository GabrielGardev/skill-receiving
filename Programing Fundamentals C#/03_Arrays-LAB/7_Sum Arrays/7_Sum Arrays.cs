using System;
using System.Linq;

namespace _7_Sum_Arrays
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr1 = Console.ReadLine().Split(' ').Select(int.Parse).ToArray(); 
            int[] arr2 = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();



            for (int i = 0; i < Math.Max(arr1.Length, arr2.Length) ; i++)
            {
                int result = arr1[i%arr1.Length] + arr2[i%arr2.Length];
                Console.WriteLine(result);
            }
        }
    }
}
