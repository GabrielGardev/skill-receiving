using System;

namespace _8_Center_Point
{
    class Program
    {
        static void Main(string[] args)
        {
            double X1 = double.Parse(Console.ReadLine());
            double Y1 = double.Parse(Console.ReadLine());
            double X2 = double.Parse(Console.ReadLine());
            double Y2 = double.Parse(Console.ReadLine());

            if (GetClosePoint(X1,Y1) <= GetClosePoint(X2,Y2))
            {
                Console.WriteLine($"({X1}, {Y1})");
            }
            else
            {
                Console.WriteLine($"({X2}, {Y2})");
            }


        }
        static double GetClosePoint(double X1, double Y1)
        {
            double d = Math.Sqrt(Math.Pow(X1, 2) + Math.Pow(Y1, 2));

            return d;
        }
    }
}
