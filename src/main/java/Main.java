public class Main {
    public static void main(String[] args) {
        Die die6 = new Die(6,1,1,1,1,1,2);
        try {
            die6.roll();
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Initial die value: " + die6.value);
        //changing probabilities of die6, this should favour number 4
        die6.setProbabilities(1,1,1,5,1,1);
        try {
            die6.roll();
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Die value after modified probabilities: " + die6.value);

        //creating a die using a dice factory class
        Die Die20 = DiceFactory.makeDie(20);
        try {
            Die20.roll();
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Factory die value: " + Die20.value);
    }
}