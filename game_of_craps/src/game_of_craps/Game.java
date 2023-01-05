package game_of_craps;

import java.util.Random;

public class Game {
	
	private enum Status {WON,LOST,CONTINUE};
	
	 private Random randomNum = new Random();
	 
	 final static int SneakEyes = 2;
	 final static int AceDeuce = 3;
	 final static int Seven = 7;
	 final static int Yo = 11;
	 final static int Midnight = 12;
	 
	 public void play() {
		 
		 Status gameStatus;
		 
		 int point = 0;
		 int Sum_of_Dice = rollDice();
		 
		 switch (Sum_of_Dice) {
		 
		 case Seven:
		 case Yo:
			 gameStatus = Status.WON;
			 break;
			 
		 case SneakEyes:
		 case AceDeuce:
		 case Midnight:
			 gameStatus = Status.LOST;
			 break;
			 
			 default:
				 gameStatus = Status.CONTINUE;
				 point = Sum_of_Dice;
				 System.out.println("You must contiune the game.\n"
				 + "your point is " + point);
				 break;
		 }
				 
			while (gameStatus == Status.CONTINUE ) {
				 Sum_of_Dice = rollDice();
				 
				 if (Sum_of_Dice == 7) {
					 
					 gameStatus = Status.LOST;
				 }
				 
                if (Sum_of_Dice == point) {
					 
					 gameStatus = Status.WON;
				 }
				 
				
			}
			 
		 
			if(gameStatus == Status.WON) {
				System.out.println("You win the game!");
			}
			
			else {
				System.out.println("You lose the game!");
			}
			
		 }//end of play
		 
		 public int rollDice() {
				
				int die1 = 1+randomNum.nextInt(6) ;
				int die2 = 1+randomNum.nextInt(6) ;
				
				int sum = die1 + die2 ;
				
				System.out.println("Player rolled  " + die1 + " + " + die2 
						+ " = " + sum);
				
				
					return sum;
			 }
			
	}


