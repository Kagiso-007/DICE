import java.util.ArrayList;
import java.util.Arrays;
public class Die {
    int sides;
    int value;
    int[] probabilities;
    Die(int dieSides, int... dieProbabilities){
        this.sides=dieSides;
        this.probabilities=dieProbabilities;
    }
    public void roll() throws Exception{
        if(!Arrays.toString(probabilities).equals("[]")&&sides==probabilities.length) {
            int sumOfProbability = 0;
            for (int number : probabilities) {
                sumOfProbability += number;
            }
            ArrayList<Double> probabilitiesInFraction = new ArrayList<>();
            for (int a=0;a<probabilities.length;a++){
                if(probabilities[a]<0){
                    throw new Exception("negative probabilities not allowed");
                }
                if(a>0){
                    probabilitiesInFraction.add(((double)probabilities[a])/sumOfProbability+probabilitiesInFraction.get(a-1));
                }else {
                    probabilitiesInFraction.add(((double)probabilities[a])/sumOfProbability);
                }
            }
            double random = Math.random();
            ArrayList<Integer> values = new ArrayList<>();
            for(int a=1;a<=sides;a++){
                values.add(a);
            }
            for(int a =0;a<probabilitiesInFraction.size();a++){
                if(random<probabilitiesInFraction.get(a)){
                    value = values.get(a);
                    break;
                }
            }
        }else {
            value = (int) (Math.random()*sides+1);
        }
    }
    public void setProbabilities(int... newProbability){
         probabilities = newProbability;
    }
}