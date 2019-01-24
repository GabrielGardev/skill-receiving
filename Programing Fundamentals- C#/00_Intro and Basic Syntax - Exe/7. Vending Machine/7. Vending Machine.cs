using System;

namespace _7._Vending_Machine
{
    class Program
    {
        static void Main(string[] args)
        {
            decimal money = 0;
            string input = Console.ReadLine();

            while (input != "Start")
            {
                double coin = double.Parse(input);

                if (coin == 0.1)
                {
                    money += 0.1m;
                }
                else if (coin == 0.2)
                {
                    money += 0.2m;
                }
                else if (coin == 0.5)
                {
                    money += 0.5m;
                }
                else if (coin == 1)
                {
                    money += 1;
                }
                else if (coin == 2)
                {
                    money += 2;
                }
                else
                {
                    Console.WriteLine($"Cannot accept {coin}");
                }

                input = Console.ReadLine();
            }

            

            while (true)
            {
                string command = Console.ReadLine().ToLower();
                decimal price = 0;

                if (command == "end")
                {
                    Console.WriteLine($"Change: {money:f2}");
                    break;
                }

                switch (command)
                {
                    case "nuts":
                        price = 2;
                        break;
                    case "water":
                        price = 0.7m;
                        break;
                    case "crisps":
                        price = 1.5m;
                        break;
                    case "soda":
                        price = 0.8m;
                        break;
                    case "coke":
                        price = 1;
                        break;
                    default:
                        Console.WriteLine("Invalid product");
                        continue;
                }

                if (price > money)
                {
                    Console.WriteLine("Sorry, not enough money");
                }
                else
                {
                    Console.WriteLine($"Purchased {command}");
                    money -= price;
                }
            }
        }
    }
}
