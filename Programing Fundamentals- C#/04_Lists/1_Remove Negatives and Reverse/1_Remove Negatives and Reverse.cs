using System;
using System.Collections.Generic;
using System.Linq;

namespace _04_Lists
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> input = Console.ReadLine().Split(' ').Select(n => int.Parse(n)).ToList();
            List<int> result = new List<int>();
            foreach (var num in input)
            {
                if (num >= 0)
                {
                    result.Add(num);
                }
            }
            if (result.Count >= 0)
            {
                result.Reverse();
                Console.Write(string.Join(" ", result));
                Console.WriteLine();
            }
            else
            {
                Console.WriteLine("empty");
            }
            
        }
    }
}
