package question2;

import java.util.Scanner;
import question1.*;

public class HumanPlayer extends BasicPlayer {

    Scanner scan = new Scanner(System.in);

    public void decideBet() {
        makeBet();
    }

    public void gameDraw() {
        
        if(hit()){
            takeCard(c);
        }
    }
}
