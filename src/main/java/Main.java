public class Main {
    public static void main(String[] args) throws Exception{
        Die die6 = new Die(4,1,1,1,1);
        die6.roll();
        System.out.println(die6.value);
        Die Die6 = DiceFactory.makeDie(6);
        Die6.roll();
        System.out.println(Die6.value);
    }
}