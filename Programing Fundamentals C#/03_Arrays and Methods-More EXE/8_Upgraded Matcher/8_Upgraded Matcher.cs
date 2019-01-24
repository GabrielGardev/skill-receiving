using System;
using System.Linq;

namespace _8_Upgraded_Matcher
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] nameProduct = Console.ReadLine().Split(' ').ToArray();
            long[] quantity = Console.ReadLine().Split(' ').Select(long.Parse).ToArray();
            decimal[] price = Console.ReadLine().Split(' ').Select(decimal.Parse).ToArray();

            string[] command = Console.ReadLine().Split(' ').ToArray();

            while (command[0] != "done")
            {
                var position = Array.IndexOf(nameProduct, command[0]);
                long wantedQuantity = long.Parse(command[1]);
                try
                {
                    if (wantedQuantity <= quantity[position])
                    {
                        Console.WriteLine($"{nameProduct[position]} x {wantedQuantity} costs {wantedQuantity * price[position]:f2}");
                        quantity[position] -= wantedQuantity;
                    }
                    else
                    {
                        Console.WriteLine($"We do not have enough {command[0]}");
                    }
                }
                catch (Exception)
                {
                    Console.WriteLine($"We do not have enough {command[0]}");
                }

                command = Console.ReadLine().Split(' ').ToArray();
            }
        }
    }
}
