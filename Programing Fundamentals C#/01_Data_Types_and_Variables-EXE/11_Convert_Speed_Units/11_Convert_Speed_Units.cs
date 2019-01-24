using System;

namespace _11_Convert_Speed_Units
{
    class Program
    {
        static void Main(string[] args)
        {
            int distanceInM = int.Parse(Console.ReadLine());
            byte hours = byte.Parse(Console.ReadLine());
            byte minutes = byte.Parse(Console.ReadLine());
            byte seconds = byte.Parse(Console.ReadLine());
            int time = seconds + minutes * 60 + hours * 3600;

            float mPerS = (float)distanceInM / time;
            float kmPerH = ((float)distanceInM / 1000) / ((float)time / 3600);
            float miliPerH = ((float)distanceInM / 1609) / ((float)time / 3600);

            Console.WriteLine($"{mPerS:0.######}");
            Console.WriteLine($"{kmPerH:0.######}");
            Console.WriteLine($"{miliPerH:0.######}");


        }
    }
}
