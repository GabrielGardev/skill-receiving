using System;

namespace _7._Theatre_Promotions
{
    class Program
    {
        static void Main(string[] args)
        {
            string typeOfDay = Console.ReadLine();
            int age = int.Parse(Console.ReadLine());
            int price = 0;

            if (age < 0 || age > 122)
            {
                Console.WriteLine("Error!");
                return;
            }

            if (typeOfDay == "Weekend")
            {
                if (0 <= age && age <= 18)
                {
                    price = 15;
                }
                else if (age <= 64)
                {
                    price = 20;
                }
                else if (age <= 122)
                {
                    price = 15;
                }
            }
            else if (typeOfDay == "Weekday")
            {
                if (0 <= age && age <= 18)
                {
                    price = 12;
                }
                else if (age <= 64)
                {
                    price = 18;
                }
                else if (age <= 122)
                {
                    price = 12;
                }
            }
            else if (typeOfDay == "Holiday")
            {
                if (0 <= age && age <= 18)
                {
                    price = 5;
                }
                else if (age <= 64)
                {
                    price = 12;
                }
                else if (age <= 122)
                {
                    price = 10;
                }  
            }
            Console.WriteLine($"{price}$");
        }
    }
}
