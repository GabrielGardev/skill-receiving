using System;
using System.Collections.Generic;
using System.Linq;

namespace _9_Legendary_Farming
{
    class Program
    {
        static void Main(string[] args)
        {
            //123 silver 6 shards 8 shards 5 motes
            //9 fangs 75 motes 103 MOTES 8 Shards 
            // 86 Motes 7 stones 19 silver


            
            var keyMaterials = new Dictionary<string, int>() {
                { "shards", 0 },
                { "fragments", 0},
                { "motes", 0}
            };
            var junkMaterials = new Dictionary<string, int>();
            int quantity;
            string type = "";
            string legendary = "";
            bool isItDone = false;
            while (true)
            {
                string[] input = Console.ReadLine().ToLower().Split().ToArray();

                for (int i = 0; i < input.Length; i += 2)
                {
                    quantity = int.Parse(input[i]);
                    type = input[i + 1];

                    if (type == "shards" || type == "fragments" || type == "motes")
                    {
                        keyMaterials[type] += quantity;
                        if (keyMaterials[type] >= 250)
                        {
                            keyMaterials[type] -= 250;
                            isItDone = true;                           
                            break;
                        }
                    }
                    else
                    {
                        if (junkMaterials.ContainsKey(type) == false)
                        {
                            junkMaterials.Add(type, 0);
                        }
                        junkMaterials[type] += quantity;
                    }
                }
                if (isItDone == true)
                {
                    break;
                }
            }
            switch (type)
            {
                case "fragments":
                    legendary = "Valanyr";
                    break;
                case "shards":
                    legendary = "Shadowmourne";
                    break;
                case "motes":
                    legendary = "Dragonwrath";
                    break;
            }

            Console.WriteLine($"{legendary} obtained!");

            foreach (var currentKeyMaterial in keyMaterials.OrderBy(x => x.Key).OrderByDescending(x => x.Value))
            {
                Console.WriteLine($"{currentKeyMaterial.Key}: {currentKeyMaterial.Value}");
            }
            foreach (var currentJunkMaterial in junkMaterials.OrderBy(x => x.Key))
            {
                Console.WriteLine($"{currentJunkMaterial.Key}: {currentJunkMaterial.Value}");
            }

        }
    }
}
