using System;
using System.Linq;

namespace _2_Manipulate_Array
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] arr = Console.ReadLine().Split(' ').ToArray();
            long n = long.Parse(Console.ReadLine());
            

            for (int i = 0; i < n; i++)
            {
                var command = Console.ReadLine().Split(' ');

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
                    arr[int.Parse(command[1])] = command[2];   
                }
            }
            Console.WriteLine(string.Join(", ",arr));
        }
    }
}
