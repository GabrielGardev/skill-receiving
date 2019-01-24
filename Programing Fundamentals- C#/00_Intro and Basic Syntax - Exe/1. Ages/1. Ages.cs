using System;

namespace Intro_and_Basic_Syntax___Exe
{
    class Program
    {
        static void Main(string[] args)
        {
            int age = int.Parse(Console.ReadLine());
            string person = "";

            if (0 <= age && age <= 2)
            {
                person = "baby";
            }
            else if(age <= 13)
            {
                person = "child";
            }
            else if (age <= 19)
            {
                person = "teenager";
            }
            else if (age <= 65)
            {
                person = "adult";
            }
            else if (age >= 66)
            {
                person = "elder";
            }

            Console.WriteLine(person);
        }
    }
}
