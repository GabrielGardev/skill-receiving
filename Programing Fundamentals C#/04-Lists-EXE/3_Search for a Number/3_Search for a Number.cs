using System;
using System.Collections.Generic;
using System.Linq;

namespace _3_Search_for_a_Number
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> numbers = Console.ReadLine().Split(' ').Select(int.Parse).ToList();

            int[] arr = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();

            
            

            if (numbers.Take(arr[0]).Skip(arr[1]).Contains(arr[2]))
            {
                Console.WriteLine("YES!");
            }
            else
            {
                Console.WriteLine("NO!");
            }

            
        }
    }
}
