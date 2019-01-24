using System;
using System.Collections.Generic;
using System.Text;

namespace _4_Morse_Code_Upgraded
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split('|');
            StringBuilder word = new StringBuilder();
            for (int i = 0; i < input.Length; i++)
            {
                word.Append(GetLeter(input[i]));
            }
            Console.WriteLine(word.ToString());
        }

        static char GetLeter(string morseCode)
        {
            List<int> numbers = new List<int>();
            int sum = 0;
            int count = 1;
            
            for (int i = 0; i < morseCode.Length; i++)
            {
                if (morseCode[i] == '1')
                {
                    sum += 5;          
                }
                else
                {
                    sum += 3;
                }
                numbers.Add(int.Parse(morseCode[i].ToString()));
            }
            numbers.Add(2);
            for (int i = 0; i < numbers.Count - 1; i++)
            {
                if (numbers[i] == numbers[i + 1])
                {
                    count++;
                }
                else if(count > 1)
                {
                    sum += count;
                    count = 1;
                }
            }
            char letter = (char)sum;
            return letter;
        }
    }
}
