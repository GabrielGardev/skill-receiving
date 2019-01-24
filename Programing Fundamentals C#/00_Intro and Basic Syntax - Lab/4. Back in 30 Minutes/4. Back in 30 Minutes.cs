using System;

namespace _4._Back_in_30_Minutes
{
    class Program
    {
        static void Main(string[] args)
        {
            int hours = int.Parse(Console.ReadLine());
            int minutes = int.Parse(Console.ReadLine());

            DateTime dt = new DateTime(2007, 7, 14, hours, minutes, 0);
            dt = dt.AddMinutes(30);
            Console.WriteLine($"{dt.Hour}:{dt.Minute:d2}");
        }
    }
}
