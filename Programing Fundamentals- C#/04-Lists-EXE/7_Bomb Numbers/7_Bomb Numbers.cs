using System;
using System.Collections.Generic;
using System.Linq;

namespace _7_Bomb_Numbers
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> numbers = Console.ReadLine().Split(' ').Select(int.Parse).ToList();
            List<int> specialNum = Console.ReadLine().Split(' ').Select(int.Parse).ToList();
            int sum = 0;
            int range = specialNum[1];
            
            while (numbers.Contains(specialNum[0]))
            {
                int bomb = numbers.IndexOf(specialNum[0]);
                if (bomb - range >= 0)
                {
                    bomb = bomb - range;
                }
                else
                {
                    bomb = 0;
                }

                if (bomb + (2 * range + 1) > numbers.Count)
                {
                    numbers.RemoveRange(bomb, numbers.Count - bomb);
                }
                else
                {
                    numbers.RemoveRange(bomb, 2 * range + 1);
                }    
            }
            sum = numbers.Sum();
            Console.WriteLine(sum);
        }
    }
}
