package packages;

import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.shape.Circle;
import javafx.util.Duration;


public class movePon {
	
	// Abstact =============================================================
	// In this class the app makes it posible to move to pon from location
	// =====================================================================
	
	
	// pon Animation =============================================================
	// 0. Construct method:		A number of input to findout the right pon to move to the right location
	
	// 1. get XML data			get a number of items from the XML file
	
	// 2. get travel disttance	based on current location to next check pon, calculate distance and direction
	// 2.1 get (second) travel  when a pon comes on a certain cell, to pon get automaticly move to another location	
	// =====================================================================
	
	
	// 0. Construct method
	public static void ponTranslate(Circle pon1, Circle pon2, Circle pon3, Circle pon4, int newCellY, int newCellX) {
		
		
		System.out.println("\n--------------------------------- START: pon Translate");


					// 1. readXML
					String[] getName = readXml.readPlayerDataMethod();
					String[] getTurn = readXml.readGlobalsMethod();

					String[] playerData = readXml.readPlayerDataMethod();

					// get Name / player Turn
					String playerName = getName[0];
					int playerTurn = Integer.valueOf(getTurn[2]);

					// Cell Location
					int cellY = Integer.valueOf(playerData[4]);
					int cellX = Integer.valueOf(playerData[3]);


					// Coordinates
					int longitudeY = Integer.valueOf(playerData[6]);
					int latitudeX = Integer.valueOf(playerData[5]);

					// pon List
					Circle[] ponList = { pon1,pon2,pon3,pon4 };
					Circle currentPon = ponList[playerTurn];


	
					System.out.println("READ " +playerName +" data:");
					System.out.println("---------------------------------");
					System.out.println("cellY: " +cellY); 
					System.out.println("cellX: " +cellX);
					
					System.out.println("\nnew CellY:    " +newCellY); 
					System.out.println("new CellX:    " +newCellX);		

					System.out.println("\nlongitude Y: " +longitudeY); 
					System.out.println("latitude X: " +latitudeX);


					// 2. get travel disttance
					
					// -------------------------------------------------------------------- Calculate cellStepY
					int cellStepsY = 0;
					
					if (cellY < newCellY) { // start Down / ends Up
						
								cellStepsY = newCellY-cellY; // exmaple 1-0= 1_steps || 3-1= 2_steps 
								
								// calculate travel distance "upwards"
								int travelYup = 0;
								for (int i = 0; i < cellStepsY; i++) {	travelYup = travelYup + 125;	}
								
								// calculate new longitudeY
								longitudeY = longitudeY - travelYup;
						

					} else if ( cellY > newCellY) { // start right / ends left
						
								cellStepsY = cellY-newCellY; // exmaple 3-2= 1_step
								
								// calculate travel distance "downwards"
								int travelYdown = 0;
								for (int i = 0; i < cellStepsY; i++) {	travelYdown = travelYdown + 125;	}
								
								// calculate new longitudeY
								longitudeY = longitudeY + travelYdown;

					} else { cellStepsY = 0;				}
					
					

					// -------------------------------------------------------------------- Calculate cellStepX
					int cellStepsX = 0;
					
					if (cellX < newCellX) { // start left / ends right
						
								cellStepsX = newCellX-cellX; // exmaple 1-0= 1_steps || 3-1= 2_steps 
								
								// calculate travel distance "upwards"
								int travelXright = 0;
								for (int i = 0; i < cellStepsX; i++) {	travelXright = travelXright + 125;	}
								
								// calculate new latitudeX
								latitudeX = latitudeX + travelXright;
						
					} else if ( cellX > newCellX) { // start right / ends left
						
								cellStepsX = cellX-newCellX; // exmaple 3-2= 1_step
								
								// calculate travel distance "upwards"
								int travelXleft = 0;
								for (int i = 0; i < cellStepsX; i++) {	travelXleft = travelXleft + 125;	}
								
								// calculate new latitudeX
								latitudeX = latitudeX - travelXleft;

					} else { cellStepsX = 0;   				}
					
								System.out.println("\ncellStepsY:    " +cellStepsY); 
								System.out.println("cellStepsX:    	 " +cellStepsX);				
			
								System.out.println("\nnext longitudeY:  " +longitudeY);
								System.out.println("next latitudeX:    	" +latitudeX);
								
	
								modifyXml.modifyCoor(playerTurn,0 ,0);


								String ScellID = String.valueOf(newCellY) +String.valueOf(newCellX);
								int cellid = Integer.valueOf(ScellID);
								
								
			// 2.1 get (second) travel disttance	

			switch (cellid) {
			  
			  case 11:
				  SequentialPon(currentPon, longitudeY, latitudeX,-125 ,375 ,500); 		// School => Collage
				  modifyXml.modifyCellXY(2, 4); // Collage
				  break;
				  
			  case 13:
				  SequentialPon(currentPon, longitudeY, latitudeX,  0, 500 ,500 ); 		// Influance => Fat OFFICE FIXED
				  modifyXml.modifyCellXY(1, 7); // Fat Office
				  break;
			  case 22:
				  SequentialPon(currentPon, longitudeY, latitudeX,  125, 375 ,0 ); 		// Ambition => Fame
				  modifyXml.modifyCellXY(1, 5); // Fame
				  break;
			  case 31:
				  SequentialPon(currentPon, longitudeY, latitudeX, -250, 250 ,500); 	// Honesty => Happiness FIXED
				  modifyXml.modifyCellXY(5, 3); // Happiness

				  break;
			  case 33:
				  SequentialPon(currentPon, longitudeY, latitudeX, -500,-250  ,500); 	// Industrie => WEALTH    *FIXED?
				  modifyXml.modifyCellXY(7, 1); // Wealth

				  break;
			  case 35:
				  SequentialPon(currentPon, longitudeY, latitudeX, -125, -375  ,500); 	// Bravairy  => Honor	*FIXED
				  modifyXml.modifyCellXY(4, 2); // Honor

				  break;
			  case 44:
				  SequentialPon(currentPon, longitudeY, latitudeX, -375,-125, 500); 	// Cupido => Matrimony	*FIXED
				  modifyXml.modifyCellXY(7, 3); // Matrimony
				  break;
			  case 51:
				  SequentialPon(currentPon, longitudeY, latitudeX, 625, 625 ,500); 	// Crime => Prison FIXED
				  modifyXml.modifyCellXY(0, 6); // Prison
				  break;
			  case 55:
				  SequentialPon(currentPon, longitudeY, latitudeX, -625,-375   ,500); 	// Idleness => Disgrace FIXED
				  modifyXml.modifyCellXY(0, 2); // Disgrace
				  break;
			  case 60:
				  SequentialPon(currentPon, longitudeY, latitudeX, 125,875 ,500);	// Perseverance => Succes FIXED
				  modifyXml.modifyCellXY(5, 7); // Succes
				  break;  
			  case 64:
				  SequentialPon(currentPon, longitudeY, latitudeX, 250, -500 ,500);	// Politics => Congress  FIXED
				  modifyXml.modifyCellXY(4, 0); // Congress
				  break;
			  case 66:
				  SequentialPon(currentPon, longitudeY, latitudeX, 500,-750,500);	// Intemperance => Poverty  *FIXED
				  modifyXml.modifyCellXY(2, 0); // Poverty
				  break;
			  case 75:
				  SequentialPon(currentPon, longitudeY, latitudeX, 625,250 ,500);	// Gambeling => Ruin *FIXED
				  modifyXml.modifyCellXY(3, 7); // Ruin
				  break;
			  default:
				  stepPon(currentPon, longitudeY, latitudeX ,2000);
				  modifyXml.modifyCellXY(newCellY, newCellX); // Ruin
				  break;
				  
			  }

		System.out.println("--------------------------------- END: ponTranslate");
	}



	// play animation ======================================================
    //
	// =====================================================================
    

	// METHOD: Pon Motion
    public static void stepPon( Circle Shape, int translateY, int translateX, int duration ) {
    	
    	
		System.out.println("\n--------------------------------- START: stepPon");
		
		
		// Convert to Double
		String tY =  Integer.toString(translateY)+".0";  
		String tX=  Integer.toString(translateX)+".0";
		Double DtY = Double.valueOf(tY);
		Double DtX = Double.valueOf(tX);
		
		
		// play audio
		audioFX.movePon();
		
		
        TranslateTransition translateTransitionA = new TranslateTransition();	// Creating Translate Transition  
        translateTransitionA.setDuration(Duration.millis(1000)); 		        // Setting the duration of the transition 
        translateTransitionA.setNode(Shape);         							// Setting the node for the transition 
        translateTransitionA.setByY(DtY);								// Setting the value of the transition along the x axis. 
        translateTransitionA.setByX(DtX);								// Setting the value of the transition along the y axis.
        translateTransitionA.setAutoReverse(false);        						// Setting auto reverse value to false 
        
        translateTransitionA.play();

        
		System.out.println("--------------------------------- END: stepPon\n");
    }



	// Secondary Translate ==================================================
    //
	// =====================================================================
    
    // METHOD: Pon Motion
    public static void SequentialPon( Circle Shape, int translateY, int translateX, int newLongitudeY, int newLatitudeX, int duration ) {
    	
  
		System.out.println("\n--------------------------------- START: SequentialPon");
		

		// Convert to Double
		String A =  Integer.toString(translateY)+".0";  
		String B=  Integer.toString(translateX)+".0";
		Double DtranslateY = Double.valueOf(A);
		Double DtranslateX = Double.valueOf(B);
		

		// Convert to Double
		String C =  Integer.toString(newLongitudeY)+".0"; 
		String D=  Integer.toString(newLatitudeX)+".0";
		Double DnewLongitudeY = Double.valueOf(C);
		Double DnewLatitudeX = Double.valueOf(D);

		
        TranslateTransition translateTransitionA = new TranslateTransition();	// Creating Translate Transition  
        translateTransitionA.setDuration(Duration.millis(1000)); 		        // Setting the duration of the transition 
        translateTransitionA.setNode(Shape);         							// Setting the node for the transition 
        translateTransitionA.setByY(DtranslateY);								// Setting the value of the transition along the x axis. 
        translateTransitionA.setByX(DtranslateX);								// Setting the value of the transition along the y axis.
        translateTransitionA.setAutoReverse(false);        						// Setting auto reverse value to false 


        TranslateTransition translateTransitionB = new TranslateTransition();	// Creating Translate Transition  
        translateTransitionB.setDelay(Duration.millis(500)); 
        translateTransitionB.setDuration(Duration.millis(1000)); 		        // Setting the duration of the transition 
        translateTransitionB.setNode(Shape);         							// Setting the node for the transition 
        translateTransitionB.setByY(DnewLongitudeY);										// Setting the value of the transition along the x axis. 
        translateTransitionB.setByX(DnewLatitudeX);										// Setting the value of the transition along the y axis.         
        translateTransitionB.setAutoReverse(false);        						// Setting auto reverse value to false 

        
        //Sequential: Bind Anim1, Anime2
        var str = new SequentialTransition();
        str.getChildren().addAll(translateTransitionA, translateTransitionB);


        str.play();
 
        
		System.out.println("new longitudeY Y:    " +newLongitudeY); 
		System.out.println("new latitudeX X:     " +newLatitudeX);
		
		
		// play audio
		audioFX.movePon();
		
		
		System.out.println("--------------------------------- END: SequentialPon");  
    }  
}