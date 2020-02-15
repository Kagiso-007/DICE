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
            //cal fraction of each probability
            //store in an array of probabilities(indexes matching)
            ArrayList<Double> probabilitiesInFraction = new ArrayList<>();
            ArrayList<Double> sortedProbs = new ArrayList<>();
            for (int a=0;a<probabilities.length;a++){
                if(probabilitiesInFraction.contains(((double)probabilities[a])/sumOfProbability)){
                    probabilitiesInFraction.add(((double)probabilities[a])/sumOfProbability+probabilitiesInFraction.get(a-1));
                    sortedProbs.add(((double)probabilities[a])/sumOfProbability+probabilitiesInFraction.get(a-1));
                }else {
                    probabilitiesInFraction.add(((double)probabilities[a])/sumOfProbability);
                    sortedProbs.add(((double)probabilities[a])/sumOfProbability);
                }
            }
            ArrayList<Integer> values = new ArrayList<>();
            for(int a=1;a<=sides;a++){
                values.add(a);
            }
            double random = Math.random()+0.1;
            for(double v:sortedProbs){
                if(random<v){
                    value =
                }

            }
//            Collections.sort(sortedProbs);
//            System.out.println(probabilitiesInFraction);
//            System.out.println(sortedProbs);




//            for(){
//
//            }
            //values[1,2]
            //probability[0.33,0.66]
            //create a random value (Math.random)
            //for each value within probability, if random value is less than that value, then value is equal to values at
            // that values index in probability, break
            value =1;
        }
        return value;
    }
}