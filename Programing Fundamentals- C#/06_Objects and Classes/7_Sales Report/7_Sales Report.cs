using System;
using System.Collections.Generic;
using System.Linq;

namespace _7_Sales_Report
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            Seals[] seal = new Seals[n];
            var register = new SortedDictionary<string, decimal>();
            for (int i = 0; i < n; i++)
            {
                seal[i] = ReadSeal();

                if (register.ContainsKey(seal[i].town) == false)
                {
                    register.Add(seal[i].town, 0);
                }

                register[seal[i].town] += seal[i].price * seal[i].quantity;
            }
            

            foreach (var currentTown in register)
            {
                Console.WriteLine($"{currentTown.Key} -> {currentTown.Value:f2}");
            }

        }

         static Seals ReadSeal()
        {
            string[] sale = Console.ReadLine().Split().ToArray();
            Seals singleSale = new Seals() { town = sale[0],product = sale[1], price = decimal.Parse(sale[2]), quantity = decimal.Parse(sale[3]) };

            return singleSale;
        }
    }
    class Seals
    {
        public string town { get; set; }
        public string product { get; set; }
        public decimal price { get; set; }
        public decimal quantity { get; set; }
    }
}
