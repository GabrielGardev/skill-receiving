using System;
using System.Globalization;
using System.Linq;

namespace _06_Objects_and_Classes
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split('-').ToArray();
            int day = int.Parse(input[0]);
            int month = int.Parse(input[1]);
            int year = int.Parse(input[2]);
            DateTime result = new DateTime (year, month, day);
            Console.WriteLine(result.DayOfWeek);

          //  DateTime result = new DateTime();
          //  result = DateTime.ParseExact(input, "d-M-yyyy", CultureInfo.InvariantCulture);
          //
          //  Console.WriteLine(result.DayOfWeek);
        }
    }
}
