using System;
using System.Globalization;

namespace _5._Month_Printer
{
    class Program
    {
        static void Main(string[] args)
        {
            int month = int.Parse(Console.ReadLine());
            if (month > 12 || month < 1)
            {
                Console.WriteLine("Error!");
                return;
            }

            DateTime dt = new DateTime(2018, month, 5);
            Console.WriteLine(dt.ToString("MMMM", CultureInfo.CurrentUICulture));
        }
    }
}
