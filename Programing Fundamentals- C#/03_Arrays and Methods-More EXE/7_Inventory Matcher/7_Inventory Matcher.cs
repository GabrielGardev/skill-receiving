using System;
using System.Linq;

namespace _7_Inventory_Matcher
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] nameProduct = Console.ReadLine().Split(' ').ToArray();
            long[] quantity = Console.ReadLine().Split(' ').Select(long.Parse).ToArray();
            decimal[] price = Console.ReadLine().Split(' ').Select(decimal.Parse).ToArray();

            var command = Console.ReadLine();

            while (command != "done")
            {
               var position = Array.IndexOf(nameProduct, command);
                Console.WriteLine($"{nameProduct[position]} costs: {price[position]}; Available quantity: {quantity[position]}");
                command = Console.ReadLine();
            }
        }
    }
}
