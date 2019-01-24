using System;
using System.Linq;

namespace _6_Reverse_Array_of_Strings
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split(' ').Reverse().ToArray();

            Console.Write(string.Join(" ", input));
            
        }
    }
}
