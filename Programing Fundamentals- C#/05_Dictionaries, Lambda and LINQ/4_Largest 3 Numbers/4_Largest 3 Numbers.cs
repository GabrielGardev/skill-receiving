using System;
using System.Collections.Generic;
using System.Linq;

namespace _4_Largest_3_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> numbers = Console.ReadLine().Split().Select(int.Parse).ToList();

            numbers.OrderByDescending(x => x).Take(3);
            Console.WriteLine(string.Join(" " , numbers));
        }
    }
}
