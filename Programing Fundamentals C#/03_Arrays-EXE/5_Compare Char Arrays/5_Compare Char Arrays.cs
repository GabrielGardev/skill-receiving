using System;
using System.Linq;

namespace _5_Compare_Char_Arrays
{
    class Program
    {
        static void Main(string[] args)
        {
            char[] firstArr = Console.ReadLine().Split(' ').Select(char.Parse).ToArray();
            char[] secondArr = Console.ReadLine().Split(' ').Select(char.Parse).ToArray();

            
            bool firstArrOntop = false;
            int min = Math.Min(firstArr.Length, secondArr.Length);

            for (int i = 0; i < min; i++)
            {
                if (firstArr[i] < secondArr[i])
                {
                    firstArrOntop = true;
                    break;
                }
                else if (firstArr[i] > secondArr[i])
                {
                    firstArrOntop = false;
                    break;
                }

                if (i == min - 1)
                {
                    if (firstArr.Length < secondArr.Length)
                    {
                        firstArrOntop = true;
                    }    
                }
  
            }

            if (firstArrOntop)
            {
                Console.WriteLine(string.Join("", firstArr));
                Console.WriteLine(string.Join("", secondArr));
            }
            else
            {
                Console.WriteLine(string.Join("", secondArr));
                Console.WriteLine(string.Join("", firstArr));
            }     
        }
    }
}
