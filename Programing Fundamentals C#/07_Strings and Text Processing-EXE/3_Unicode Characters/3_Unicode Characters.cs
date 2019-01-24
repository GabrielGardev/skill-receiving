using System;
using System.Linq;

namespace _3_Unicode_Characters
{
    class Program
    {
        static void Main(string[] args)
        {
            char[] input = Console.ReadLine().ToCharArray();

            foreach (var symbol in input)
            {
                Console.Write($"\\u{(int)symbol:x4}");
            }
        }
    }
}
