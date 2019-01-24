using System;

namespace _5_Temperature_Conversion
{
    class Program
    {
        static void Main(string[] args)
        {
            double n = double.Parse(Console.ReadLine());
            double celsius = ToCeusius(n);
            Console.WriteLine($"{celsius:f2}");
        }

        static double ToCeusius(double n)
        {
            double celsius = (n - 32) * 5 / 9;
            return celsius;
        }
    }
}
