using System;

namespace _10_Cube_Properties
{
    class Program
    {
        static void Main(string[] args)
        {
            double sideA = double.Parse(Console.ReadLine());
            string input = Console.ReadLine();
            PtintCubeProperty(sideA, input);
        }

         static void PtintCubeProperty(double sideA, string input)
        {
            switch (input)
            {
                case "area":
                double area = 6 * Math.Pow(sideA, 2);
                Console.WriteLine($"{area:f2}");
                    break;

                case "volume":            
                double volume = Math.Pow(sideA, 3);
                Console.WriteLine($"{volume:f2}");
                    break;

                case "face":
                double face = Math.Sqrt(2 * Math.Pow(sideA, 2));
                Console.WriteLine($"{face:f2}");
                    break;

                case "space":
                double space = Math.Sqrt(3 * Math.Pow(sideA, 2));
                Console.WriteLine($"{space:f2}");
                    break;
            }
        }
    }
}
