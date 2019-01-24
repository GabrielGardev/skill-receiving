using System;

namespace _6_Calculate_Triangle_Area
{
    class Program
    {
        static void Main(string[] args)
        {
            double a = double.Parse(Console.ReadLine());
            double b = double.Parse(Console.ReadLine());

            double area = TriangleArea(a,b);
            Console.WriteLine(area);

        }
        static double TriangleArea(double width, double height)
        {
            return width * height / 2;
        }
    }
}
