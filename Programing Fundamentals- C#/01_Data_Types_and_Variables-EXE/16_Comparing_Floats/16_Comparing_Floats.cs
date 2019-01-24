using System;

namespace _16_Comparing_Floats
{
    class Program
    {
        static void Main(string[] args)
        {
            double numberA = double.Parse(Console.ReadLine());
            double numberB = double.Parse(Console.ReadLine());
            double dif = Math.Abs(numberA - numberB);

            double eps = 0.000001;

            bool isEqual = false;

            if (dif < eps)
            {
                isEqual = true;     
            }

            Console.WriteLine(isEqual);
        }
    }
}
