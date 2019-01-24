using System;
using System.Globalization;
using System.Collections.Generic;

namespace _06_Objects_and_Classes_EXE
{
    class Program
    {
        static void Main(string[] args)
        {
            DateTime startDate = DateTime.ParseExact(Console.ReadLine(), "dd-MM-yyyy", CultureInfo.InvariantCulture);
            DateTime endDate = DateTime.ParseExact(Console.ReadLine(), "dd-MM-yyyy", CultureInfo.InvariantCulture);
            int countWorkingDays = 0;
            bool isItHoliday = false;
            List<DateTime> holidays = new List<DateTime>()
            {
                  DateTime.ParseExact("01-01-1970", "dd-MM-yyyy", CultureInfo.InvariantCulture),
                  DateTime.ParseExact("03-03-1970", "dd-MM-yyyy", CultureInfo.InvariantCulture),
                  DateTime.ParseExact("01-05-1970", "dd-MM-yyyy", CultureInfo.InvariantCulture),
                  DateTime.ParseExact("06-05-1970", "dd-MM-yyyy", CultureInfo.InvariantCulture),
                  DateTime.ParseExact("24-05-1970", "dd-MM-yyyy", CultureInfo.InvariantCulture),
                  DateTime.ParseExact("06-09-1970", "dd-MM-yyyy", CultureInfo.InvariantCulture),
                  DateTime.ParseExact("22-09-1970", "dd-MM-yyyy", CultureInfo.InvariantCulture),
                  DateTime.ParseExact("01-11-1970", "dd-MM-yyyy", CultureInfo.InvariantCulture),
                  DateTime.ParseExact("24-12-1970", "dd-MM-yyyy", CultureInfo.InvariantCulture),
                  DateTime.ParseExact("25-12-1970", "dd-MM-yyyy", CultureInfo.InvariantCulture),
                  DateTime.ParseExact("26-12-1970", "dd-MM-yyyy", CultureInfo.InvariantCulture),
            };

            for (DateTime i = startDate; i <= endDate; i = i.AddDays(1))
            {
                if (i.DayOfWeek.ToString() == "Saturday" || i.DayOfWeek.ToString() == "Sunday")
                {
                    isItHoliday = true;
                }


                for (int j = 0; j < holidays.Count; j++)
                {
                    if (i.Month == holidays[j].Month && i.Day == holidays[j].Day)
                    {
                        isItHoliday = true;
                    }
                }
                if (isItHoliday == false)
                {
                    countWorkingDays++;
                }
                isItHoliday = false;
            }
            Console.WriteLine(countWorkingDays);

        }
    }
}
