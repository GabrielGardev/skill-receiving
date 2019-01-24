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
            var phonebook = new SortedDictionary<string, string>();

            while (command[0] != "END")
            {
                if (command[0] == "A")
                {
                    string name = command[1];
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
                    string name = command[1];
                    if (phonebook.ContainsKey(name))
                    {
                        Console.WriteLine($"{name} -> {phonebook[name]}");
                    }
                    else
                    {
                        Console.WriteLine($"Contact {name} does not exist.");
                    }
                }
                else if (command[0] == "ListAll")
                {
                    foreach (var human in phonebook)
                    {
                        Console.WriteLine($"{human.Key} -> {human.Value}");
                    }
                }
                command = Console.ReadLine().Split().ToList();
            }
        }
    }
}
