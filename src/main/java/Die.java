import java.util.ArrayList;
public class Die {
    int sides;
    int value;
    Number[] probabilities;
    Die(int dieSides, Number... dieProbabilities){
        this.sides=dieSides;
        this.probabilities=dieProbabilities;
    }
    public void roll() throws Exception{
        if(sides==1){
            throw new Exception("sides has to be an integer greater than one");
        }
        //probabilities will apply only if each value on a die is represented
        if(sides==probabilities.length) {
            int probabilitySum = 0;
            for (Number number : probabilities) {
                if(number.doubleValue()%number.intValue()==0 || number.intValue()==0) {
                    probabilitySum += number.intValue();
                }else {
                    throw new Exception("Only integers required");
                }
            }
            if(probabilitySum==0) {
                throw new Exception("probability sum must be greater than 0");
            }
            ArrayList<Double> probabilitiesInFraction = new ArrayList<>();
            for (int index=0;index<probabilities.length;index++){
                int currentValue = probabilities[index].intValue();
                if(currentValue<0){
                    throw new Exception("negative probabilities not allowed");
                }
                if(index>0){
                    probabilitiesInFraction.add(((double)currentValue)/probabilitySum+probabilitiesInFraction.get(index-1));
                }else {
                    probabilitiesInFraction.add(((double)currentValue)/probabilitySum);
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
    public Number[] setProbabilities(Number... newProbability){
         probabilities = newProbability;
         return newProbability;
    }
}