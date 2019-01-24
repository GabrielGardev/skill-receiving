using System;
using System.Collections.Generic;
using System.Linq;

namespace _05_Dictionaries__Lambda_and_LINQ_EXE
{
    class Program
    {
        static void Main(string[] args)
        {
            List<string> command = Console.ReadLine().Split().ToList();
            var phonebook = new Dictionary<string, string>();

            while (command[0] != "END")
            {
                string name = command[1];

                if (command[0] == "A")
                {
                    string number = command[2];
                    if (phonebook.ContainsKey(name))
                    {
                        phonebook[name] = number;
                    }
                    else
                    {
                        phonebook.Add(name, number);
                    }

                }
                else if (command[0] == "S")
                {
                    if (phonebook.ContainsKey(name))
                    {
                        Console.WriteLine($"{name} -> {phonebook[name]}");
                    }
                    else
                    {
                        Console.WriteLine($"Contact {name} does not exist.");
                    }
                }
                command = Console.ReadLine().Split().ToList();
            }
        }
    }
}
