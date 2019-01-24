using System;
using System.Collections.Generic;
using System.Linq;

namespace _4_Fix_Emails
{
    class Program
    {
        static void Main(string[] args)
        {
            string command = Console.ReadLine();

            var emails = new Dictionary<string, string>();

            while (command != "stop")
            {
                string name = command;
                string email = Console.ReadLine();


                if (emails.ContainsKey(name) == false)
                {
                    emails.Add(name, email);
                }

                command = Console.ReadLine();
            }
            foreach (var item in emails.Where(x => !x.Value.EndsWith("us") || !x.Value.EndsWith("uk")))
            {
                Console.WriteLine($"{item.Key} -> {item.Value}");
            }
        }
    }
}
