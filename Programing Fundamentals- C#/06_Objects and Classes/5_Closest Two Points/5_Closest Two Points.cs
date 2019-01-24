using System;
using System.Linq;

namespace _5_Closest_Two_Points
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            Point[] points = new Point[n];

            for (int i = 0; i < n; i++)
            {
                points[i] = PointReader(Console.ReadLine());
            }

            FindClosestPoints(points);

        }

        static void FindClosestPoints(Point[] points)
        {
            double min = double.MaxValue;
            string firstPoint = "";
            string secondPoint = "";
            for (int i = 0; i < points.Length; i++)
            {
                for (int j = i + 1; j < points.Length; j++)
                {
                    if (CalcPointDistance(points[i], points[j]) < min)
                    {
                        min = CalcPointDistance(points[i], points[j]);
                        firstPoint = string.Join(", ", points[i].X, points[i].Y);
                        secondPoint = string.Join(", ", points[j].X, points[j].Y);
                    }
                }
            }
            Console.WriteLine($"{min:f3}");
            Console.WriteLine($"({firstPoint})");
            Console.WriteLine($"({secondPoint})");

        }

        static Point PointReader(string input)
        {
            int[] coordinates = input.Split(' ').Select(int.Parse).ToArray();
            return new Point() { X = coordinates[0], Y = coordinates[1] };
        }

        static double CalcPointDistance(Point point1, Point point2)
        {
            int deltaX = point1.X - point2.X;
            int deltaY = point1.Y - point2.Y;

            return Math.Sqrt(deltaX * deltaX + deltaY * deltaY);
        }
    }
    class Point
    {
        public int X { get; set; }
        public int Y { get; set; }
    }
}
