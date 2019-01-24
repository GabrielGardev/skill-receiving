using System;

namespace _08_Strings_and_Regular_Expressions___More_EXE
{
    class Program
    {
        static void Main(string[] args)
        {
            string censorWord = Console.ReadLine();
            string sentence = Console.ReadLine();

            string result = sentence.Replace(censorWord, new string('*', censorWord.Length));

            Console.WriteLine(result);
        }
    }
}
