using System;

namespace _9_Reverse_Characters
{
    class Program
    {
        static void Main(string[] args)
        {
            string firstLetter = Console.ReadLine();
            string secondLetter = Console.ReadLine();
            string thirdLetter = Console.ReadLine();

            Console.WriteLine($"{thirdLetter}{secondLetter}{firstLetter}");
        }
    }
}
