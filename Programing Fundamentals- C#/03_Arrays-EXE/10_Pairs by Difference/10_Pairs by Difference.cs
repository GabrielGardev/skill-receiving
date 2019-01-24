using System;
using System.Linq;

namespace _10_Pairs_by_Difference
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
            int difference = int.Parse(Console.ReadLine());

            int count = 0;

            for (int i = 0; i < arr.Length; i++)
            {
                int diffrentNum = arr[i] + difference;

                for (int j = 0; j < arr.Length; j++)
                {
                    if (diffrentNum == arr[j])
                    {
                        count++;
                    }
                }
            }
            Console.WriteLine(count);
        }
    }
}
