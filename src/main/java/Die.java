import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Die {
    int sides;
    int value;
    int[] probabilities;
    Die(int dieSides, int... dieProbabilities){
        this.sides=dieSides;
        this.probabilities=dieProbabilities;
    }
    public int roll(){

        if(!Arrays.toString(probabilities).equals("[]")&&sides==probabilities.length) {
            int sumOfProbability = 0;
            for (int number : probabilities) {
                sumOfProbability += number;
            }
            ArrayList<Double> probabilitiesInFraction = new ArrayList<>();
            ArrayList<Double> sortedProbs = new ArrayList<>();
            for (int a=0;a<probabilities.length;a++){
                if(a>0){
                    probabilitiesInFraction.add(((double)probabilities[a])/sumOfProbability+probabilitiesInFraction.get(a-1));
                    sortedProbs.add(((double)probabilities[a])/sumOfProbability+probabilitiesInFraction.get(a-1));
                }else {
                    probabilitiesInFraction.add(((double)probabilities[a])/sumOfProbability);
                    sortedProbs.add(((double)probabilities[a])/sumOfProbability);
                }
            }
            double random = Math.random()*sortedProbs.get(sortedProbs.size()-1)+0.01;
            System.out.println(random);
            System.out.println(probabilitiesInFraction);
            System.out.println(sortedProbs);
            //storing possible values of a die in an array
            ArrayList<Integer> values = new ArrayList<>();
            for(int a=1;a<=sides;a++){
                values.add(a);
            }
            System.out.println(values);
            //create a random value
            //for each value within probability, if random value is less than that value, then value is equal to values at
            // that values index in probability, break
            for(int a =0;a<sortedProbs.size();a++){
                if(random<sortedProbs.get(a)){
                    value = values.get(a);
                    break;
                }
            }
        }
        return value;
    }
}