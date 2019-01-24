using System;

class PriceChangeAlert
{
    static void Main()
    {
        int n = int.Parse(Console.ReadLine());
        double border = double.Parse(Console.ReadLine());


        double lastPRice = double.Parse(Console.ReadLine());

        for (int i = 0; i < n - 1; i++)
        {
            double prices = double.Parse(Console.ReadLine());

            double diffrence = ChangeOfPrice(lastPRice, prices);
            bool isSignificantDifference = DiffrenceOrNot(diffrence, border);


            string message = Get(prices, lastPRice, diffrence, isSignificantDifference);
            Console.WriteLine(message);

            lastPRice = prices;
        }
    }

     static string Get(double price, double last, double diffrence, bool etherTrueOrFalse)
    {
        string newPrice = "";
        if (diffrence == 0)
        {
            newPrice = string.Format($"NO CHANGE: {price}");
        }
        else if (!etherTrueOrFalse)
        {
            newPrice = string.Format("MINOR CHANGE: {0} to {1} ({2:F2}%)", last, price, diffrence * 100);
        }
        else if (etherTrueOrFalse && (diffrence > 0))
        {
            newPrice = string.Format("PRICE UP: {0} to {1} ({2:F2}%)", last, price, diffrence * 100);
        }
        else if (etherTrueOrFalse && (diffrence < 0))
            newPrice = string.Format("PRICE DOWN: {0} to {1} ({2:F2}%)", last, price, diffrence * 100);
        return newPrice;
    }

     static bool DiffrenceOrNot(double border, double isDiff)
    {
        if (Math.Abs(border) >= isDiff)
        {
            return true;
        }
        return false;
    }

     static double ChangeOfPrice(double lastPrice, double price)
    {
        double result = (price - lastPrice) / lastPrice;
        return result;
    }
}
