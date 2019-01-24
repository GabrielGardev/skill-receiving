using System;

namespace _7_Math_Power
{
    class Program
    {
        static void Main(string[] args)
        {
            double n = double.Parse(Console.ReadLine());
            int poworedBy = int.Parse(Console.ReadLine());

            double result = RaiseToPower(n, poworedBy);
            Console.WriteLine(result);
        }
        static double RaiseToPower(double number, int power)
        {
            double result = 1;
            for (int i = 0; i < power; i++)
            {
                result *= number;
            }
            return result;
        }
    }
}
