package packages;


import javafx.scene.control.Label;

// Abstact =============================================================
// modify the visual scoreboard on the left of the game board, 
// so players can see how is winnning
// =====================================================================


public class modifyScoreBoard {
	
	public static void modifyScore(Label score1, Label score2, Label score3, Label score4) {
	
		String[] readScore = readXml.readPlayerDataMethod();	
		String[] playerTurn = readXml.readGlobalsMethod();
		int turn = Integer.valueOf(playerTurn[2]);
		
		
		switch (turn) {
		  case 0:
			  score1.setText(readScore[2]);

			  break;
		  case 1:
			  score2.setText(readScore[2]);

			  break;
		  case 2:
			  score3.setText(readScore[2]);

			  break;
		  case 3:
			  score4.setText(readScore[2]);

			  break;
		    
		}
		
	}
	
}