using System;

namespace _10_Centuries_to_Nanoseconds
{
    class Program
    {
        static void Main(string[] args)
        {
            byte centuries = byte.Parse(Console.ReadLine());

            ushort years = (ushort)(centuries * 100);
            uint days = (uint)(years * 365.2422);
            uint hours = days * 24;
            uint minutes = hours * 60;
            ulong seconds = (ulong)minutes * (ulong)60;
            ulong miliseconds = seconds * 1000;
            ulong microseconds = miliseconds * 1000;
            decimal nanoseconds = (decimal)microseconds * (decimal)1000;

            Console.WriteLine($"{centuries} centuries = {years} years = {days} days = {hours} hours = {minutes} minutes = {seconds} seconds = {miliseconds} milliseconds = {microseconds} microseconds = {nanoseconds:f0} nanoseconds");
        }
    }
}
