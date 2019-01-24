using System;
using System.Linq;

namespace _5._Login
{
    class Program
    {
        static void Main(string[] args)
        {
            string userName = Console.ReadLine();
            string password = Reverse(userName);
            string inputPassword = Console.ReadLine();
            int counter = 1;

            while (inputPassword != password)
            {     
                if (counter == 4)
                {
                    Console.WriteLine($"User {userName} blocked!");
                    return;
                }
                Console.WriteLine("Incorrect password. Try again.");
                counter++;
                inputPassword = Console.ReadLine();
            }
            Console.WriteLine($"User {userName} logged in.");
        }
        public static string Reverse(string s)
        {
            char[] charArray = s.ToCharArray();
            Array.Reverse(charArray);
            return new string(charArray);
        }
    }
}
