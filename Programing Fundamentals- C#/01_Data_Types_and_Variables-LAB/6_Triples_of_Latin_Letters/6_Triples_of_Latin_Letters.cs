using System;

namespace _6_Triples_of_Latin_Letters
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            for (char i = 'a'; i < 'a' + n; i++)
            {
                for (char k = 'a'; k < 'a' + n; k++)
                {
                    for (char j = 'a'; j < 'a' + n; j++)
                    {
                        Console.WriteLine($"{i}{k}{j}");
                    }
                }
            }
        }
    }
}
