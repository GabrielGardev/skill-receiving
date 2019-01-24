using System;

namespace _9._Padawan_Equipment
{
    class Program
    {
        static void Main(string[] args)
        {
            double money = double.Parse(Console.ReadLine());
            int students = int.Parse(Console.ReadLine());
            double lightsaberPrice = double.Parse(Console.ReadLine());
            double robePrice = double.Parse(Console.ReadLine());
            double beltPrice = double.Parse(Console.ReadLine());

            int freeBelts = 0;
            if (students >= 6)
            {
                freeBelts = students / 6;
            }

            double costs = lightsaberPrice * (students + Math.Ceiling(students * 0.1)) +
                robePrice * students + beltPrice * (students - freeBelts);

            if (costs <= money)
            {
                Console.WriteLine($"The money is enough - it would cost {costs:f2}lv.");
            }
            else
            {
                Console.WriteLine($"Ivan Cho will need {costs - money:f2}lv more.");
            }

        }
    }
}
