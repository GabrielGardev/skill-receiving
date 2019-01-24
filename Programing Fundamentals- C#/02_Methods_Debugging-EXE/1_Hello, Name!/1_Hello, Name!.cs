using System;

namespace _02_Methods_Debugging_EXE
{
    class Program
    {
        static void Main(string[] args)
        {
            string firstName = Console.ReadLine();

            PrintGreeting(firstName);
        }
        static void PrintGreeting(string firstName)
        {
            Console.WriteLine($"Hello, {firstName}!");
        }
    }
}
