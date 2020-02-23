import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class DieTest {
    //testing one sided die
    Die oneSidedDie = new Die(1);
    @Test
    void dieSides(){
        assertThrows(Exception.class, ()-> oneSidedDie.roll());
    }

    //testing a die with non-integer types in probabilities
    Die nonIntProbDie = new Die(4,1,2.5,1.3,1);
    @Test
    void probabilitiesType(){
        assertThrows(Exception.class, ()-> nonIntProbDie.roll());
    }

    //testing a die with probabilities sum less than one
    Die belowOneProbsDie = new Die(4,0,0,0,0);
    @Test
    void probabilitiesSum(){
        assertThrows(Exception.class, ()-> belowOneProbsDie.roll());
    }

    //testing a die with negative probabilities
    Die negativeProbDie = new Die(4,1,1,-1,-1);
    @Test
    void negativeProbabilities() {
        assertThrows(Exception.class, ()-> negativeProbDie.roll());
    }

}