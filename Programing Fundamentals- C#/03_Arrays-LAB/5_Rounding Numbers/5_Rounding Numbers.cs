using System;
using System.Linq;



    class Program
    {
    static void Main(string[] args)
    {

        double[] realNumbers = Console.ReadLine().Split(' ').Select(double.Parse).ToArray();



        foreach (var item in realNumbers)
        {
            double result = Math.Round(item, 0, MidpointRounding.AwayFromZero);
            Console.WriteLine($"{item} => {result}");
        }
        
           
        
    }
}

