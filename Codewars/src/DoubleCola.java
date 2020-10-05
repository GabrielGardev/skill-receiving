public class DoubleCola {
    public static void main(String[] args) {
        String[] names = new String[]{"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
        int n = 6;
        System.out.println(WhoIsNext(names, n));
    }

    public static String WhoIsNext(String[] names, int n) {
        while (n > names.length){
            n = (n - (names.length - 1)) / 2;
        }
        return names[n-1];
    }
}
