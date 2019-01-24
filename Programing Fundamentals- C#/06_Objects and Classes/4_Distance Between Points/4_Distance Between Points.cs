using System;
using System.Linq;

namespace _4_Distance_Between_Points
{
    class Program
    {
        static void Main(string[] args)
        {
            Points point1 = PointReader(Console.ReadLine());
            Points point2 = PointReader(Console.ReadLine());

            Console.WriteLine("{0:F3}", CalcPointDistance(point1, point2));

        }
        static Points PointReader(string input)
        {
            int[] coordinates = input.Split(' ').Select(int.Parse).ToArray();
            return new Points() { X = coordinates[0], Y = coordinates[1] };
        }
        static double CalcPointDistance(Points point1, Points point2)
        {
            int deltaX = point1.X - point2.X;
            int deltaY = point1.Y - point2.Y;

            return Math.Sqrt(deltaX * deltaX + deltaY * deltaY);
        }
    }
    class Points
    {
        public int X { get; set; }
        public int Y { get; set; }   
    }
}
