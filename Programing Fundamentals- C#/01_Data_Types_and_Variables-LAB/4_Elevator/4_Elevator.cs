using System;

namespace _4_Elevator
{
    class Program
    {
        static void Main(string[] args)
        {
            int ppl = int.Parse(Console.ReadLine());
            int capacity = int.Parse(Console.ReadLine());

            int courses = ppl / capacity;
            

            if (ppl % capacity != 0)
            {
                courses++;
            }
            

            Console.WriteLine(courses);

        }
    }
}
