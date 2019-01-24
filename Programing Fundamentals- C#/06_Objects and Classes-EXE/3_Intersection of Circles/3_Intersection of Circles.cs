using System;
using System.Linq;

namespace _3_Intersection_of_Circles
{
    class Program
    {
        static void Main(string[] args)
        {
            double[] input = Console.ReadLine().Split().Select(double.Parse).ToArray();
            Circle circle1 = new Circle();     
            circle1.Center = new Points();
            circle1.Center.X = input[0];
            circle1.Center.Y = input[1];
            circle1.Radius = input[2];

            input = Console.ReadLine().Split().Select(double.Parse).ToArray();
            Circle circle2 = new Circle();  
            circle2.Center = new Points();
            circle2.Center.X = input[0];
            circle2.Center.Y = input[1];
            circle2.Radius = input[2];

           if(circle1.Intersect(circle2))
            {
                Console.WriteLine("Yes");
            }
            else
            {
                Console.WriteLine("No");
            }
        }
    }
    class Points
    {
        public double X { get; set; }
        public double Y { get; set; }
    }
    class Circle
    {
        public Points Center { get; set; }
        public double Radius { get; set; }

        public bool Intersect(Circle circle2)
        {
            double deltaX = Math.Abs(Center.X - circle2.Center.X);
            double deltaY = Math.Abs(Center.Y - circle2.Center.Y);

            double d = Math.Sqrt(deltaX * deltaX + deltaY * deltaY);
            if (d <= Radius + circle2.Radius)
            {
                return true;
            }
            return false;
        }
    }
}
