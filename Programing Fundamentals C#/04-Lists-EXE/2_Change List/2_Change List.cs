using System;
using System.Collections.Generic;
using System.Linq;

namespace _2_Change_List
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> numbers = Console.ReadLine().Split(' ').Select(int.Parse).ToList();

            List<string> command = Console.ReadLine().ToLower().Split(' ').ToList();

            while (true)
            {
                if (command[0] == "odd" || command[0] == "even")
                {
                    break;
                }
                if (command[0] == "delete")
                {
                    int number = int.Parse(command[1]);
                    numbers.RemoveAll(item => item == number);
                }
                else if (command[0] == "insert")
                {
                    int position = int.Parse(command[2]);
                    int numberToInsert = int.Parse(command[1]);
                    numbers.Insert(position, numberToInsert);
                }

                command = Console.ReadLine().ToLower().Split(' ').ToList();
            }

            if (command[0] == "odd")
            {
                numbers.RemoveAll(num => num % 2 == 0);
                
                Console.WriteLine(string.Join(" ", numbers));
            }
            else
            {
                numbers.RemoveAll(num => num % 2 != 0);
                Console.WriteLine(string.Join(" ", numbers));

            }
        }
    }
}
