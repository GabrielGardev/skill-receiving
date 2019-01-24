using System;

namespace _9_Longer_Line
{
    class Program
    {
        static void Main(string[] args)
        {
            double X1 = double.Parse(Console.ReadLine());
            double Y1 = double.Parse(Console.ReadLine());

            double X2 = double.Parse(Console.ReadLine());
            double Y2 = double.Parse(Console.ReadLine());

            double X3 = double.Parse(Console.ReadLine());
            double Y3 = double.Parse(Console.ReadLine());

            double X4 = double.Parse(Console.ReadLine());
            double Y4 = double.Parse(Console.ReadLine());



            double firstLine = Math.Abs(X1) + Math.Abs(X2) + Math.Abs(Y1) + Math.Abs(Y2);

      
            double secondLine = Math.Abs(X3) + Math.Abs(X4) + Math.Abs(Y3) + Math.Abs(Y4);

            if (firstLine >= secondLine)
            {
                if (GetClosePoint(X1, Y1) <= GetClosePoint(X2, Y2))
                {
                    Console.WriteLine($"({X1}, {Y1})({X2}, {Y2})");
                }
                else
                {
                    Console.WriteLine($"({X2}, {Y2})({X1}, {Y1})");
                }
            }
            else
            {
                if (GetClosePoint(X3, Y3) <= GetClosePoint(X4, Y4))
                {
                    Console.WriteLine($"({X3}, {Y3})({X4}, {Y4})");
                }
                else
                {
                    Console.WriteLine($"({X4}, {Y4})({X3}, {Y3})");
                }
            }




        }
        static double GetClosePoint(double X1, double Y1)
        {
            double d = Math.Sqrt(Math.Pow(X1, 2) + Math.Pow(Y1, 2));

            return d;
        }
    }
}
