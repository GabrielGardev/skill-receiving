using System;

namespace _19_Thea_the_Photographer
{
    class Program
    {
        static void Main(string[] args)
        {
            int numberOfPic = int.Parse(Console.ReadLine());
            int filterTime = int.Parse(Console.ReadLine());
            int percentGoodPics = int.Parse(Console.ReadLine());
            int timeToUpload = int.Parse(Console.ReadLine());

           
            

            double inPercent = percentGoodPics / 100.0;

            double usefulPic = Math.Ceiling(numberOfPic * inPercent);

            ulong timeForFilter = (ulong)numberOfPic * (ulong)filterTime;
            ulong timeForUpload = (ulong)usefulPic * (ulong)timeToUpload;

            ulong totalTime = timeForFilter + timeForUpload;

            TimeSpan time = TimeSpan.FromSeconds(totalTime);
            string str = time.ToString(@"d\:hh\:mm\:ss");
            Console.WriteLine(str);
        }
    }
}
