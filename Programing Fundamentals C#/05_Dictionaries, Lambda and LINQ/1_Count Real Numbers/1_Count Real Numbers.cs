using System;
using System.Collections.Generic;
using System.Linq;

namespace _05_Dictionaries__Lambda_and_LINQ
{
    class Program
    {
        static void Main(string[] args)
        {
            double[] numbers = Console.ReadLine().Split().Select(double.Parse).ToArray();

            var counts = new SortedDictionary<double, int>();

            foreach (var num in numbers)
            {
                if (counts.ContainsKey(num) == false)
                {
                    counts[num] = 0;
                }
                counts[num]++;
            }

            foreach (var item in counts)
            {
                Console.WriteLine($"{item.Key} -> {item.Value}");
            }
        }
    }
}
