using System;
using System.Linq;

namespace _3_Safe_Manipulation
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] arr = Console.ReadLine().Split(' ').ToArray();
            
            var command = Console.ReadLine().Split(' ');


            while (command[0] != "END")
            {

                if (command[0] == ("Distinct"))
                {
                    arr = arr.Distinct().ToArray();
                }
                else if (command[0] == ("Reverse"))
                {
                    arr = arr.Reverse().ToArray();
                }
                else if (command[0] == ("Replace"))
                {
                    int replacedNum = int.Parse(command[1]);
                    if (replacedNum > arr.Length - 1 || replacedNum < 0)
                    {
                        Console.WriteLine("Invalid input!");
                    }
                    else
                    {
                        arr[int.Parse(command[1])] = command[2];

                    }
                }
                else
                {
                    Console.WriteLine("Invalid input!");
                }

                command = Console.ReadLine().Split(' ');
            }
            Console.WriteLine(string.Join(", ", arr));
        }
    }
}
