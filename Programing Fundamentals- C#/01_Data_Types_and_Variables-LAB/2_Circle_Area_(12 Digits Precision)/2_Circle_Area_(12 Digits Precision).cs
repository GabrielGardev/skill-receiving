using System;

namespace _02_Circle_Area__12_Digits_Precision_
{
    class Program
    {
        static void Main(string[] args)
        {
            double r = double.Parse(Console.ReadLine());

            double area = Math.PI * Math.Pow(r, 2);

            Console.WriteLine($"{area:f12}");
        }
    }
}
