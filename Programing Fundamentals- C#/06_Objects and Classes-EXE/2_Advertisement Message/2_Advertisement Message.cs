using System;

namespace ConsoleApp1
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] phrase = new string[]
            {
             "Excellent product.",
             "Such a great product.",
            "I always use that product.",
            "Best product of its category.",
            "Exceptional product.",
            "I can’t live without this product.",
            };

            string[] events = new string[]
            {
             "Now I feel good.",
             "I have succeeded with this product.",
             "Makes miracles. I am happy of the results!",
             "I cannot believe but now I feel awesome.",
             "Try it yourself, I am very satisfied.",
             "I feel great!"
              };
            string[] autors = new string[]
            {
             "Diana",
             "Petya",
             "Stela",
             "Elena",
             "Katya",
             "Iva",
             "Annie",
             "Eva"
              };
            string[] cities = new string[]
            {
             "Burgas",
             "Sofia",
             "Plovdiv",
             "Varna",
             "Ruse"            
              };

            Random random = new Random();

            Console.WriteLine($"{phrase[random.Next(0 , phrase.Length)]} {events[random.Next(0 , events.Length)]} {autors[random.Next(0 , autors.Length)]} - " +
                $"{cities[random.Next(0, cities.Length)]}");
            
            
        }
    }
}
