public class Main {
    public static void main(String[] args) {
        SmartArray smartArray = new SmartArray();

        for (int i = 0; i < 4; i++) {
            smartArray.add(i);
        }

        smartArray.insert(2, 5);

        smartArray.forEach(System.out::println);
        System.out.println();
    }
}
