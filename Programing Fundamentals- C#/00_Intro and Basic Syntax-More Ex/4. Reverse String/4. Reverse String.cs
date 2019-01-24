using System;

namespace _4._Reverse_String
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();

            char[] output = input.ToCharArray();
            Array.Reverse(output);
            Console.WriteLine(output);
        }
    }
}
