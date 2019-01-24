using System;

namespace _11_Geometry_Calculator
{
    class Program
    {
        static void Main(string[] args)
        {
            string type = Console.ReadLine();

            PrintAreaOfTheFigure(type);
        }
        
        static void PrintAreaOfTheFigure(string type)
        {
            if (type.Equals("triangle"))
            {
                double side = double.Parse(Console.ReadLine()); 
                double height = double.Parse(Console.ReadLine());

                double areaOfTriangle = side * height / 2;
                Console.WriteLine($"{areaOfTriangle:f2}");
            }
            else if (type.Equals("square"))
            {
                double sideOfSquare = double.Parse(Console.ReadLine());

                double areaOfSquere = Math.Pow(sideOfSquare, 2);
                Console.WriteLine($"{areaOfSquere:f2}");
            }
            else if (type.Equals("rectangle"))
            {
                double width = double.Parse(Console.ReadLine());
                double height = double.Parse(Console.ReadLine());

                double area = width * height;
                Console.WriteLine($"{area:f2}");
            }
            else if (type.Equals("circle"))
            {
                double radius = double.Parse(Console.ReadLine());

                double area = Math.PI * Math.Pow(radius, 2);
                Console.WriteLine($"{area:f2}");
            }
          
        }
    }
}
