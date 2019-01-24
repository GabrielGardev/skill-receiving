using System;
using System.Linq;

namespace _03_Arrays_EXE
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] firstArr = Console.ReadLine().Split(' ').ToArray();
            string[] secondArr = Console.ReadLine().Split(' ').ToArray();

            long min = Math.Min(firstArr.Length, secondArr.Length);

            long count = 0;
            if (firstArr[0] == secondArr[0])
            {
                for (long i = 0; i < min; i++)
                {
                    if (firstArr[i] == secondArr[i])
                    {
                        count++;
                    }
                }
            }
            else
            {
                string[] firstArrCopy = firstArr.Reverse().ToArray();
                string[] secondArrCopy = secondArr.Reverse().ToArray();
                for (long i = 0; i < min; i++)
                {
                    if (firstArrCopy[i] == secondArrCopy[i])
                    {
                        count++;
                    }
                }

            }
            Console.WriteLine(count);
            
        }
    }
}
