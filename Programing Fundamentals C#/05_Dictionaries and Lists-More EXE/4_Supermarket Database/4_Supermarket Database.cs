using System;
using System.Collections.Generic;
using System.Linq;

namespace _4_Supermarket_Database
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split().ToArray();
            var dataBase = new Dictionary<string, decimal[]>();
            string product = "";
            decimal price = 0;
            decimal quantity = 0;

            decimal[] temp = new decimal[2];

            while (input[0] != "stocked")
            {
                product = input[0];
                price = decimal.Parse(input[1]);
                quantity = decimal.Parse(input[2]);
                temp = new decimal[2] { price, quantity };

                if (dataBase.ContainsKey(product) == false)
                {                 
                    dataBase.Add(product, temp);
                }
                else
                {
                    dataBase[product][0] = temp[0];
                    dataBase[product][1] += temp[1];

                }
                input = Console.ReadLine().Split().ToArray();
            }
            var grandTotal = 0M;
            foreach (var name in dataBase)
            {
                var totalPrice = name.Value[0] * name.Value[1];
                grandTotal += totalPrice;
                Console.WriteLine($"{name.Key}: ${name.Value[0]} * {name.Value[1]} = ${totalPrice}");
            }
            Console.WriteLine("------------------------------");
            Console.WriteLine($"Grand Total: ${grandTotal}");
        }
    }
}
