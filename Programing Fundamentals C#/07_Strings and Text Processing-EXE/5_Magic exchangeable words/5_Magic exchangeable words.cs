using System;
using System.Collections.Generic;

namespace _5_Magic_exchangeable_words
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split();
            string word1 = input[0];
            string word2 = input[1];

            if (Exchangeable(word1, word2))
            {
                Console.WriteLine("true");
            }
            else
            {
                Console.WriteLine("false");
            }
        }

        static bool Exchangeable(string word1, string word2)
        {
           
            Dictionary<char, char> chars = new Dictionary<char, char>();
            for (int i = 0; i < Math.Min(word1.Length, word2.Length); i++)
            {
                if (chars.ContainsKey(word1[i]) == false)
                {
                    if (chars.ContainsValue(word2[i]) == false)
                    {
                        chars.Add(word1[i], word2[i]);
                    }
                    else
                    {
                        return false;
                    }

                }
                else
                {
                    if (word2[i] != chars[word1[i]])
                    {

                        return false;
                    }

                }
            }

            if (word1.Length > word2.Length)
            {
                for (int i = word2.Length; i < word1.Length; i++)
                {
                    if (chars.ContainsKey(word1[i]) == false)
                    {
                        return false;
                    }
                }
            }
            else
            {
                for (int i = word1.Length; i < word2.Length; i++)
                {
                    if (chars.ContainsValue(word2[i]) == false)
                    {
                        return false;
                    }
                }
            }
            
            return true;
        }
    }
}
