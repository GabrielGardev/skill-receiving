using System;
using System.Collections.Generic;

namespace _3_A_Miner_Task
{
    class Program
    {
        static void Main(string[] args)
        {
            string command = Console.ReadLine();

            var safe = new Dictionary<string, int>();
            string metal = "";
            int quantity = 0;

            while (!command.Equals("stop"))
            {
                metal = command;
                quantity = int.Parse(Console.ReadLine());

                if (safe.ContainsKey(metal) == false)
                {
                    safe[metal] = 0;
                }
                safe[metal] += quantity;

                command = Console.ReadLine();
            }
            foreach (var item in safe)
            {
                Console.WriteLine($"{item.Key} -> {item.Value}");
            }
        }
    }
}
