using System;

namespace _3._Vacation
{
    class Program
    {
        static void Main(string[] args)
        {
            int capacity = int.Parse(Console.ReadLine());
            string typeOfGroup = Console.ReadLine();
            string day = Console.ReadLine();

            double pricePerPerson = 0;

            if (day == "Friday")
            {
                if (typeOfGroup == "Students")
                {
                    pricePerPerson = 8.45;
                }
                else if (typeOfGroup == "Business")
                {
                    pricePerPerson = 10.90;
                }
                else if (typeOfGroup == "Regular")
                {
                    pricePerPerson = 15;
                }
            }
            else if (day == "Saturday")
            {
                if (typeOfGroup == "Students")
                {
                    pricePerPerson = 9.80;
                }
                else if (typeOfGroup == "Business")
                {
                    pricePerPerson = 15.60;
                }
                else if (typeOfGroup == "Regular")
                {
                    pricePerPerson = 20;
                }
            }
            else if (day == "Sunday")
            {
                if (typeOfGroup == "Students")
                {
                    pricePerPerson = 10.46;
                }
                else if (typeOfGroup == "Business")
                {
                    pricePerPerson = 16;
                }
                else if (typeOfGroup == "Regular")
                {
                    pricePerPerson = 22.50;
                }
            }

            double totalPrice = capacity * pricePerPerson;

            if (typeOfGroup == "Students" && capacity >= 30)
            {
                totalPrice = totalPrice - (totalPrice * 0.15);
            }
            else if (typeOfGroup == "Business" && capacity >= 100)
            {
                totalPrice = (capacity - 10) * pricePerPerson;
            }
            else if (typeOfGroup == "Regular" && capacity >= 10 && capacity <= 20)
            {
                totalPrice = totalPrice - (totalPrice * 0.05);
            }

            Console.WriteLine($"Total price: {totalPrice:f2}");
        }
    }
}
