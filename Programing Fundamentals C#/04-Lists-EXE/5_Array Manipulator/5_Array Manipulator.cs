using System;
using System.Collections.Generic;
using System.Linq;

namespace _5_Array_Manipulator
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> numbers = Console.ReadLine().Split(' ').Select(int.Parse).ToList();

            string[] command = Console.ReadLine().Split(' ').ToArray();

            while (command[0] != "print")
            {
                switch (command[0])
                {
                    case "add":
                        int index = int.Parse(command[1]);
                        int element = int.Parse(command[2]);
                        numbers.Insert(index,element);
                        break;
                    case "addMany":
                        int index2 = int.Parse(command[1]);
                        numbers.InsertRange(index2, command.Skip(2).Select(int.Parse));
                        break;
                    case "contains":                 
                            int element2 = int.Parse(command[1]);
                            Console.WriteLine(numbers.IndexOf(element2));                   
                        break;
                    case "remove":
                        numbers.RemoveAt(int.Parse(command[1]));
                        break;
                    case "shift":
                        int numberOfPositions = int.Parse(command[1]);
                        while (numberOfPositions > 0)
                        {
                            int first = numbers[0];
                            numbers.RemoveAt(0);
                            numbers.Add(first);
                            numberOfPositions--;
                        }
                        break;
                    case "sumPairs":
                        List<int> summed = new List<int>();
                        while (numbers.Count >= 2)
                        {
                            summed.Add(numbers[0] + numbers[1]);
                            numbers.RemoveAt(0);
                            numbers.RemoveAt(0);
                        }
                        if (numbers.Count == 1)
                        {
                            summed.Add(numbers[0]);
                        }
                        numbers = summed;
                        break;
                }
                command = Console.ReadLine().Split(' ').ToArray();
            }
            Console.WriteLine($"[{string.Join(", ", numbers)}]");
        }
    }
}
