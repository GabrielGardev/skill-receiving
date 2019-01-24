using System;

namespace _7_Exchange_Variable_Values
{
    class Program
    {
        static void Main(string[] args)
        {
            int a = 5;
            int b = 10;
            Console.WriteLine("Before:");
            Console.WriteLine($"a = {a}\r\nb = {b}");

            Console.WriteLine("After:");
            int temp = a;
            a = b;
            b = temp;
            Console.WriteLine($"a = {a}\r\nb = {b}");
        }
    }
}
