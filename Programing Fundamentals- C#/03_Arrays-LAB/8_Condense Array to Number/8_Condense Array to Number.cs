using System;
using System.Linq;

namespace _8_Condense_Array_to_Number
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] nums = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();

            

            while (nums.Length > 1)
            {
                int[] condensed = new int[nums.Length - 1];

                for (int j = 0; j < condensed.Length ; j++)
                {
                    condensed[j] = nums[j] + nums[j + 1];
                }

                nums = condensed;
                
            }
            Console.WriteLine(string.Join(" ",nums));
        }
    }
}
