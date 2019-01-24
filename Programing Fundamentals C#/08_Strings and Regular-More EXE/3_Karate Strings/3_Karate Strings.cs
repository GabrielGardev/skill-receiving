using System;
using System.Collections.Generic;

namespace _3_Karate_Strings
{
    class Program
    {
        static void Main(string[] args)
        {
            string input = Console.ReadLine();
            int power = 0;
            int newPower = 0;
            int savePower = 0;

            for (int i = 0; i < input.Length; i++)
            {
                if (input[i] == '>')
                {
                    power = int.Parse(input[i + 1].ToString());

                    for (int j = 0; j < power + savePower; j++)
                    {
                        if (i + 1 + newPower < input.Length && input[i + 1 + j] != '>')
                        {
                            newPower++;
                        }
                        else
                        {
                            break;
                        }
                    }

                    savePower += power - newPower;

                    input = input.Remove(i + 1, newPower);
                    newPower = 0;
                }

            }
            Console.WriteLine(input);
        }
    }
}
