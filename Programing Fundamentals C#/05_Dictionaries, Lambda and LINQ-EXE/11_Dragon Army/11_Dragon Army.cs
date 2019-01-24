using System;
using System.Collections.Generic;
using System.Linq;

namespace _11_Dragon_Army
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            var nameAndStats = new Dictionary<string, Dictionary<string, int>>();
            var types = new Dictionary<string, Dictionary<string, Dictionary<string, int>>>();
            string type = "";
            string name = "";


            for (int i = 0; i < n; i++)
            {
                Dictionary<string, int> stats = new Dictionary<string, int>()
            {
                { "health" , 250 },
                {"damage", 45 },
                { "armor", 10}
            };
                string[] input = Console.ReadLine().Split().ToArray();
                type = input[0];
                name = input[1];
                int dmg = -1;
                int hp = -1;
                int armor = -1;

                if (input[2] != "null")
                {
                    dmg = int.Parse(input[2]);
                }
                if (input[3] != "null")
                {
                    hp = int.Parse(input[3]);
                }
                if (input[4] != "null")
                {
                    armor = int.Parse(input[4]);
                }

                if (nameAndStats.ContainsKey(name) == false)
                {
                    if (dmg >= 0)
                    {
                        stats["damage"] = dmg;
                    }
                    if (hp >= 0)
                    {
                        stats["health"] = hp;
                    }
                    if (armor >= 0)
                    {
                        stats["armor"] = armor;
                    }
                    nameAndStats.Add(name, stats);
                }
                else
                {
                    if (dmg >= 0)
                    {
                        stats["damage"] = dmg;
                    }
                    if (hp >= 0)
                    {
                        stats["health"] = hp;
                    }
                    if (armor >= 0)
                    {
                        stats["armor"] = armor;
                    }
                    nameAndStats[name] = stats;
                }

                if (types.ContainsKey(type) == false)
                {
                    types.Add(type, new Dictionary<string, Dictionary<string, int>>());
                }

                if (types[type].ContainsKey(name) == false)
                {
                    types[type].Add(name, stats);
                }
                else
                {
                    types[type][name] = stats;
                }

            }
            foreach (var currentType in types)
            {
                double avDamage = 1.00 * (currentType.Value.Values.Select(x => x["damage"]).Sum()) / types[currentType.Key].Count;
                double avHp = 1.00 * (currentType.Value.Values.Select(x => x["health"]).Sum()) / types[currentType.Key].Count;
                double avArmor = 1.00 * (currentType.Value.Values.Select(x => x["armor"]).Sum()) / types[currentType.Key].Count;

                Console.WriteLine($"{currentType.Key}::({avDamage:f2}/{avHp:f2}/{avArmor:f2})");
                foreach (var currentName in currentType.Value.OrderBy(x => x.Key))
                {
                    Console.WriteLine($"-{currentName.Key} -> damage: {currentName.Value["damage"]}, health: {currentName.Value["health"]}, armor: {currentName.Value["armor"]}");
                }
            }

        }
    }
}
