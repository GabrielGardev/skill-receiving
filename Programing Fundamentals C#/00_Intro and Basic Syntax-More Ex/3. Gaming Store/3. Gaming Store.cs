using System;

namespace _3._Gaming_Store
{
    class Program
    {
        static void Main(string[] args)
        {
            decimal balance = decimal.Parse(Console.ReadLine());
            decimal totalSpent = 0;

            while (true)
            {
                string command = Console.ReadLine();
                if (balance <= 0)
                {
                    Console.WriteLine($"Out of money!");
                    return;
                }

                if (command == "Game Time")
                {
                    Console.WriteLine($"Total spent: ${totalSpent}. Remaining: ${balance}");
                    break;
                }

                decimal price = 0;

                switch (command)
                {
                    case "OutFall 4": price = 39.99m; break;
                    case "CS: OG": price = 15.99m; break;
                    case "Zplinter Zell": price = 19.99m; break;
                    case "Honored 2": price = 59.99m; break;
                    case "RoverWatch": price = 29.99m; break;
                    case "RoverWatch Origins Edition": price = 39.99m; break;
                    default:
                        Console.WriteLine("Not Found");
                        continue;
                }

                if (balance - price < 0)
                {
                    Console.WriteLine("Too Expensive");
                    continue;
                }
                else
                {
                    balance -= price;
                    totalSpent += price;
                    Console.WriteLine($"Bought {command}");
                }

            }
        }
    }
}
