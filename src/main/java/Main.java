public class Main {
    public static void main(String[] args) {
        Die die6 = new Die(4,1,6,2,1);
        System.out.println(die6.roll());
        Die die20 = new Die(20);
        System.out.println(die20.roll());
    }
}