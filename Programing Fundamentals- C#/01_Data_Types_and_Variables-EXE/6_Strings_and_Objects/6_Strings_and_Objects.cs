using System;

namespace _6_Strings_and_Objects
{
    class Program
    {
        static void Main(string[] args)
        {
            string firstLine = "Hello";
            string secondLine = "World";

            object result = firstLine + " " + secondLine;

            string thirdLine = (string)result;

            Console.WriteLine(thirdLine);
        }
    }
}
