using System;
using System.Linq;

namespace _6_Max_Sequence_of_Equal_Elements
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();

            
            int len = 1;
            int start = 0;
            int maxLen = 0;


            for (int pos = 0; pos < arr.Length - 1; pos++)
            {
                if (arr[pos] == arr[pos + 1])
                {
                    len++;
                    
                }
                else
                {

                    if (len > maxLen)
                    {
                        maxLen = len;
                        start = arr[pos];
                    }
                    len = 1;
                }

                if (pos + 1 == arr.Length- 1)
                {
                    if (len > maxLen)
                    {
                        maxLen = len;
                        start = arr[pos];
                    }
                    len = 1;
                }
                
            }

            for (int i = 0; i < maxLen; i++)
            {
                Console.Write($"{start} ");
            }
        }
    }
}
