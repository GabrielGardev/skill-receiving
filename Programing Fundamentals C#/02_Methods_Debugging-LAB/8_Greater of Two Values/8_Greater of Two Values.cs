using System;

namespace _8_Greater_of_Two_Values
{
    class Program
    {
        static void Main(string[] args)
        {
            string type = Console.ReadLine();

            if (type.Equals("int"))
            {
                int first = int.Parse(Console.ReadLine());
                int second = int.Parse(Console.ReadLine());

                int max = GetMax(first,second);
                Console.WriteLine(max);
            }
            else if (type.Equals("char"))
            {
                char first = char.Parse(Console.ReadLine());
                char second = char.Parse(Console.ReadLine());

                char max = GetMax(first, second);
                Console.WriteLine(max);
            }
            else if (type.Equals("string"))
            {
                string first = Console.ReadLine();
                string second = Console.ReadLine();

                string max = GetMax(first, second);
                Console.WriteLine(max);
            }





        }
        static int GetMax(int first, int second)
        {
            int temp = 0;
            if (first >= second)
            {
                temp = first;
            }
            else if (second >= first)
            {
                temp = second;
            }

            return temp;
        }
        static char GetMax(char first, char second)
        {
            char temp = '0';

            if (first >= second)
            {
                temp = first;
            }
            else if (second >= first)
            {
                temp = second;
            }

            return temp;
        }
        static string GetMax(string first, string second)
        {
            string temp = "";
            if (first.CompareTo(second) >= 0)
            {
                temp = first;
            }
            else
            {
                temp = second;
            }

            return temp;
            
        }
    }
}
