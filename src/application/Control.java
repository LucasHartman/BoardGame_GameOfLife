package application;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import data.newGameSheet;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.shape.Circle;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import packages.audioFX;
import packages.gameLoop;
import packages.modifyScoreBoard;
import packages.modifyXml;
import packages.readXml;
import packages.movePon;
import packages.setMultiPath;





public class Control {


    
	// Start application input =============================================
	// 
	// Initialize data at application startup

	// 0. get elements:		get elements from FXML file
	// 0.1 get image:		get image data from local folder

    // 1. pon texture:		add texture to pons
    // 2. get visiblitiy:	get visblity value from xml file
    // 3. set visblity:		set pon visblity, base on input

    // 4. open menu:		Open menu window at startup and keep other windows closed
	// =====================================================================

	// 0. get pons
	@FXML Circle pon1;
	@FXML Circle pon2;
	@FXML Circle pon3;
	@FXML Circle pon4;

	// 0. get window
	@FXML StackPane menuWindow;
	@FXML StackPane gambleWindow;
	@FXML StackPane winnerWindow;
	@FXML StackPane prisonWindow;
	@FXML StackPane deathWindow;
	
	
	@FXML Label nameTag1;
	@FXML Label nameTag2;
	@FXML Label nameTag3;
	@FXML Label nameTag4;

	
	// 0.1 get pon image file
    Image map1 = new Image("image/pon1_L.png");
    ImagePattern img1 = new ImagePattern(map1, 35, 35, 70, 70, false);

    Image map2 = new Image("image/pon2_L.png");
    ImagePattern img2 = new ImagePattern(map2, 35, 35, 70, 70, false);

    Image map3 = new Image("image/pon3_L.png");
    ImagePattern img3 = new ImagePattern(map3, 35, 35, 70, 70, false);

    Image map4 = new Image("image/pon4_L.png");
    ImagePattern img4 = new ImagePattern(map4, 35, 35, 70, 70, false);

	
	    
	@FXML public void initialize() throws SAXException, IOException, ParserConfigurationException {

		// print text
		System.out.println("initialize");
		
		// 1. pon texture
		pon1.setFill(img1); 
		pon2.setFill(img2); 
		pon3.setFill(img3); 
		pon4.setFill(img4); 

		// 2. get pon visiblity
		String[] playerStateList = readXml.getPlayerPlay();
		
		// 3. set on visiblity
		pon1.setVisible(Boolean.parseBoolean(playerStateList[0]));
		pon2.setVisible(Boolean.parseBoolean(playerStateList[1]));
		pon3.setVisible(Boolean.parseBoolean(playerStateList[2]));
		pon4.setVisible(Boolean.parseBoolean(playerStateList[3]));

		
		// 4. Windows Visiblity
		menuWindow.setVisible(true);
		gambleWindow.setVisible(false);
		winnerWindow.setVisible(false);
		prisonWindow.setVisible(false);
		deathWindow.setVisible(false);		
	}



	// Menu Window ========================================================
	// On button click the menu window appears centure stage
	// 
	// 0. get element:		get menu button from FXML file
	
	// 1. set ActionEvent:	set Button action
	// 
	// 2. set visible:		on button click, set menu window to visible
	// =====================================================================
	
	// 0. get menuButton
	@FXML Button menuButton;
	
	// 1. set ActionEvent
	@FXML private void handleMenuAction(ActionEvent event) throws Exception {
		
		audioFX.clickAudio();
		
		// set visible
		menuWindow.setVisible(true);
		
		System.out.println("open Menu");
	}



	// resume button ========================================================
	// In the menu you find the resume button. When pressed the menu closes
	// and the game continues.
	// 
	// 0. get element:		get resume button from FXML file
	
	// 1. set ActionEvent:	set Button action
	
	// 2. set visible:		on button click, set menu window to unvisible
	
	// 3. play audio
	// =====================================================================
	
	// 0. get resumeButton
	@FXML Button resumeButton;
	
	// 1. set ActionEvent
	@FXML private void handleResumeAction(ActionEvent event) throws Exception {
			
		// 2. set visible
		menuWindow.setVisible(false);

		System.out.println("close Menu");
		
		// 3. play audio
		audioFX.clickAudio();
	}



	// setup new game =======================================================
	// Within the menu we set player name and player count. When the new button
	// is pressed. A XML-file is genrated with all players, ready for a new game
	
	// 0. get elements:		get newButton, textFields, Checkboxes from FXML file
	
	// 1. set ActionEvent:	set Button action

	
	// 2. get checkbox:		get boolean data from checkboxes
	
	// 3. get player num:	input checkbox booleans into a list
	// 3.1 start value:		variable for counting active players
	// 3.2 loop list:		loop throught the list, if value is true add 1 to count
	
	// 4. set pon Vis.:		based on the player count the system can decide how many pons are visible
	
	// 5. reset pon pos:	reset pons to start location
	
	// 6. convert dataype:	convert number of player (int count) to a string value
	
	// 7. generate XML		input data into this method for create a XML-file, 
	//						which will be updated throught the game
	
	// 8. set visible:		on button click, set menu window to unvisible
	
	// 9. show name			show the names on the side of the board
	// ======================================================================
	
	// 0. get element
	@FXML Button newButton;
	
	@FXML TextField playerField1;
	@FXML TextField playerField2;
	@FXML TextField playerField3;
	@FXML TextField playerField4;

	@FXML CheckBox playerCheck1;
	@FXML CheckBox playerCheck2;
	@FXML CheckBox playerCheck3;
	@FXML CheckBox playerCheck4;


	// 1. set ActionEvent
	@FXML
    private void handleNewAction(ActionEvent event) throws Exception {


		// 2. Checkbox state: 1
		boolean BplayerBool1 = 	playerCheck1.isSelected();
			if(BplayerBool1) { 	playerCheck1.setSelected(false);	} 
			else {				playerCheck1.setSelected(true);		}

		// 3. Checkbox state: 2
		boolean BplayerBool2 = 	playerCheck2.isSelected();
			if(BplayerBool2) { 	playerCheck2.setSelected(false);	} 
			else {				playerCheck2.setSelected(true);		}
		
		// 3. Checkbox state: 3
		boolean BplayerBool3 = 	playerCheck3.isSelected();
			if(BplayerBool3) { 	playerCheck3.setSelected(false);	} 
			else {				playerCheck3.setSelected(true);		}
		
		// 3. Checkbox state: 4
		boolean BplayerBool4 = 	playerCheck4.isSelected();
			if(BplayerBool4) { 	playerCheck4.setSelected(false);	} 
			else {				playerCheck4.setSelected(true);		}


		// 3. get number of players
		Boolean[] playerState = { BplayerBool1, BplayerBool2, BplayerBool3, BplayerBool4 };
		
	
		// 3.1 start value
		int Count = 0;


		// 3.2 loop list
		for (int i = 0; i <= 3; i++) {
			if (playerState[i] == true) {
				Count = Count +1;
			}
		} 


		// 4. set pon Visibility
		switch (Count) {
		  case 0:
				pon1.setVisible(false);
				pon2.setVisible(false);
				pon3.setVisible(false);
				pon4.setVisible(false);
		    break;
		  case 1:
				pon1.setVisible(true);
				pon2.setVisible(false);
				pon3.setVisible(false);
				pon4.setVisible(false);
		    break;
		  case 2:
				pon1.setVisible(true);
				pon2.setVisible(true);
				pon3.setVisible(false);
				pon4.setVisible(false);
		    break;
		  case 3:
				pon1.setVisible(true);
				pon2.setVisible(true);
				pon3.setVisible(true);
				pon4.setVisible(false);

		    break;
		  case 4:
				pon1.setVisible(true);
				pon2.setVisible(true);
				pon3.setVisible(true);
				pon4.setVisible(true);
		    break;
		}


		// 5. reset pon position
		pon1.setTranslateX(0);
		pon1.setTranslateY(0);
		
		pon2.setTranslateX(0);
		pon2.setTranslateY(0);
		
		pon3.setTranslateX(0);
		pon3.setTranslateY(0);
		
		pon4.setTranslateX(0);
		pon4.setTranslateY(0);


		// 6. convert to String
		String playerCount = String.valueOf(Count);


		// 7. generate XML-file
		newGameSheet.createPsheet(playerField1.getText(), playerField2.getText(), playerField3.getText(), playerField4.getText(), playerCount, "0", "0", "0", "0");

		
		// 8. set visible
		menuWindow.setVisible(false);
		
		System.out.println("close Menu");
		
				
		// 9. Show Name
		nameTag1.setText(playerField1.getText());
		nameTag2.setText(playerField2.getText());
		nameTag3.setText(playerField3.getText());
		nameTag4.setText(playerField4.getText());
		
		// play audio
		audioFX.startAudio();
	}



	// quit button =========================================================
	// In the menu you find the quit button. When pressed the application closes
	// 
	// 0. get element:		get quit button from FXML file
	
	// 1. set ActionEvent:	set Button action
	
	// 2. close app:		on button click, close app, inc. background procceses
	// =====================================================================

	// 0. get quitButton
	@FXML Button quitButton;
	
	// 1. set ActionEvent
	@FXML private void handleQuitAction(ActionEvent event) throws Exception {
		
		// 2. close app
	    Platform.exit();
	    
		System.out.println("close application");
		
		// play audio
		audioFX.clickAudio();
	}



	// Gamble Window ======================================================
	// 0. get element:		get gamble button from FXML file

	// 1. set ActionEvent:	set Button action
	
	// 2. gameLoop Method:	set new gamecycle and player turn (see gameLoop Class)
	
	// 3.1 get XML data:	get prison time from XML-file
	// 3.2 convert datatype:convet String getPrisionTime to Integer
	// 3.3 check condition:	if player is in prison or not
	//						set prison time to 0 (prison time is over) and move to next player turn 
	// 3.4 else condition:	Player can gamble for his next move on the board (see setMultiPath Class)
	// 3.5 calculate moves:	Based on the gambled value posible pon moves are calculated
	// 3.6 update XML-file:	posible moves are update to the XML-file
	// =====================================================================

	// 0. get element
	@FXML Button gambleButton;
	@FXML Label gambleValue;
	@FXML Label playerName;
	@FXML Label instruction;

	
	// 1. set ActionEvent
	@FXML private void handleLoopAction(ActionEvent event) {

		// 2. gameLoop Method
		gameLoop.gameLoopMethod();			  
		

		// 3.1 get XML data
		String[] getPrisonTime = readXml.readPlayerDataMethod();
		
		
		// 3.2 String => Integer
		int prisoner = Integer.valueOf(getPrisonTime[7]);


		// 3.3 check conditions
		if (prisoner == 1) {    		
			modifyXml.modifyPrisonTime("0"); 
		 	System.out.println("Prison time is 0");

		// 3.4 set next pon move
		} else if (prisoner > 1) {
			
		 	System.out.println("tihs player is dead");
	
		}	else { 
	
			
			// get player Name
			  String[] getName = readXml.readPlayerDataMethod();
			  String playerNameQ = getName[0];
	        
	        
	        // get Random value
	        int randomNum = ThreadLocalRandom.current().nextInt(1, 6+1);


			// set Text Visuals
			playerName.setText(playerNameQ);
			gambleValue.setText(String.valueOf(randomNum));
			
		        switch (randomNum) {
		          case 1:
		  			instruction.setText("up or down");
		            break;
		          case 2:
		  			instruction.setText("left or right");
		            break;
		          case 3:
		  			instruction.setText("Diagonally in either Direction");
		            break;
		          case 4:
		  			instruction.setText("one or two squares up or down");
		            break;
		          case 5:
		  			instruction.setText("one or two squares right or left");
		            break;
		          case 6:
		  			instruction.setText("one or two squares Diagonally");
		            break;
		        }

		        
		    // play audio
		    audioFX.diceAudio();
			
		    
		    
		    // set visible
			gambleWindow.setVisible(true);
			
			System.out.println("open Menu");
								// 3.5 gamble/calculte possible move
			int[] Multipath = 	setMultiPath.getMultipathMethod(randomNum);
								// 3.6 update XML-file
								setMultiPath.setMultipathMethod(Multipath); }
	
	}
	
	
	// continue button ========================================================
	// In each window you find the resume/continue button. When pressed the wondow closes
	// and the game continues.
	// 
	// 0. get element:		get resume button from FXML file
	
	// 1. set ActionEvent:	set Button action
	
	// 2. set visible:		on button click, set menu window to unvisible
	// =====================================================================
	
	// 0. get resumeButton
	@FXML Button continueButton;
	
	// 1. set ActionEvent
	@FXML private void handlecontinueAction(ActionEvent event) throws Exception {
			
		// 2. set visible
		gambleWindow.setVisible(false);

		System.out.println("close Menu");
		
		// play audio
		audioFX.clickAudio();
	}
	
	
	// 0. get resumeButton
	@FXML Button closePrisWindow;
	
	// 1. set ActionEvent
	@FXML private void handleclosePrisWindowAction(ActionEvent event) throws Exception {
			
		// 2. set visible
		prisonWindow.setVisible(false);

		System.out.println("close prison Window");
		
		// play audio
		audioFX.clickAudio();
	}
	
	
	// 0. get resumeButton
	@FXML Button deathButton;
	
	// 1. set ActionEvent
	@FXML private void handledeathWindowAction(ActionEvent event) throws Exception {
			
		// 2. set visible
		deathWindow.setVisible(false);

		System.out.println("close prison Window");
		
		// play audio
		audioFX.clickAudio();
	}


	// Cell Buttons ========================================================
	// Now that the system knows which move the player can make, the stage can be set
	// below are all the cells on the board, each with there own method of action
	// - Most don't do anything special, like all the cell with a pattern symbol
	// - some add a points to the players score
	// - others refer the pon to another location
	// - The prision cell makes the player lose a turn
	// - And suicide banneds the player from the game
	// A cell can only be actived when, these condition are met:
	// - cell Button is pressed
	// - the cell boolean value in the XML-file is true
	// - the player is not in prison
	// - the player is not banned from the game
	// When all condition are mat, the pon will automaticlh move to that position
	// =====================================================================
	
	
	@FXML Label score1;
	@FXML Label score2;
	@FXML Label score3;
	@FXML Label score4;
	
	@FXML Label winnersName;

	// Row 0 ====================================================================================================================================


	// Cell 00 ============================================================
	
	// Cell Buttons ========================================================
	// 0. ActionEvent:			on Button click iterate block of code
	
	// 1. check if Active:		get boolean value from XML-file to check the state of this button 
	// 
	// 2. if conditoin			if boolean is true, iterate coming methods...
	// 2.1 modifyBooleans		set all active cell Booleans to false (to the player can press another cell)
	// 2.2 movePon				animate pon to new location (see movePon Class)
	// 2.3 modifyScore			it depents on the cell the score of the playr get points (see modifyXML Class)
	// 2.4 modifyScoreBaord		the visual score board next to the board is update with the new score (see modifyScoreBaord Class)
	
	// =====================================================================
	
	// 0. ActionEvent
    @FXML protected void handleCell00 (ActionEvent t) {	    
    	
    	// 1. check if Active
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	// 2. if condition
    	if (readCellBool[0] == true) {
    		System.out.println("--------------------------------- ACTION: cell00");
    		
    		// 2.1 modifyBooleans
    		modifyXml.modifyBooleans();
    		
    		// 2.2 movePon
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 0, 0);
    		
    		// 2.3 modifyScore
    		modifyXml.modifyScore(00);
    		
    		// 2.4 modifyScoreBaord	
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
	
    				
    	} else {
    		System.out.println("cell00 is not active");
    	}	
    }
 
    
   // Close App
	@FXML private void handleCloseWinnerAction(ActionEvent event) throws Exception {
			
			// 2. close app
		    Platform.exit();
		    
			System.out.println("close application");
		}
	
	// Cell 01 ============================================================

    @FXML protected void handleCell01 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[1] == true) {
    		System.out.println("--------------------------------- ACTION: cell01");

    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 0, 1);
    		modifyXml.modifyScore(01);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);
    		}

    	} else {
    		System.out.println("cell01 is not active");
    	}	
    }
    
    
	// Cell 02 ============================================================

    @FXML protected void handleCell02 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[2] == true) {
    		System.out.println("--------------------------------- ACTION: cell02\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 0, 2);
    		modifyXml.modifyScore(02);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}

    	} else {
    		System.out.println("cell02 is not active");
    	}	
    }
    
    

	// Cell 03 ============================================================

    @FXML protected void handleCell03 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[3] == true) {
    		System.out.println("--------------------------------- ACTION: cell03");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 0, 3);
    		modifyXml.modifyScore(03);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}

    	} else {
    		System.out.println("cell03 is not active");
    	}	
    }
    
    
    
	// Cell 04 ============================================================

    @FXML protected void handleCell04 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[4] == true) {
    		System.out.println("--------------------------------- ACTION: cell04");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 0, 4);
    		modifyXml.modifyScore(04);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}

    	} else {
    		System.out.println("cell04 is not active");
    	}	
    }    
  
    
    
	// Cell 05 ============================================================

    @FXML protected void handleCell05 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[5] == true) {
    		System.out.println("--------------------------------- ACTION: cell05");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 0, 5);
    		modifyXml.modifyScore(05);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}

    	} else {
    		System.out.println("cell05 is not active");
    	}	
    }  
    
    
    
    
	// Cell 06 ============================================================

    @FXML protected void handleCell06 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[6] == true) {
    		System.out.println("--------------------------------- ACTION: cell06\n");
    		
    		
    		// get prison time <..................................................................................
    		modifyXml.modifyPrisonTime("1");
			 System.out.println("Prison time is 1");

    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 0, 6);
    		modifyXml.modifyScore(06);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}

    	} else {
    		System.out.println("cell06 is not active");
    	}	
    }
    
    
    
	// Cell 07 ============================================================

    @FXML protected void handleCell07 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[7] == true) {
    		System.out.println("--------------------------------- ACTION: cell07\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 0, 7);
    		modifyXml.modifyScore(07);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}

    	} else {
    		System.out.println("cell07 is not active");
    	}	
    }
    
    
	// Row 01 ====================================================================================================================================

    
	// Cell 10 ============================================================

    @FXML protected void handleCell10 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[8] == true) {
    		System.out.println("--------------------------------- ACTION: cell10\n");
    		
    		// get prison time <..................................................................................
    		modifyXml.modifyPrisonTime("1");
			 System.out.println("Prison time is 1");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 1, 0);
    		modifyXml.modifyScore(10);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);	
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}


    	} else {
    		System.out.println("cell10 is not active");
    	}	
    }
    
    
    
	// Cell 11 ============================================================

    @FXML protected void handleCell11 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[9] == true) {
    		System.out.println("--------------------------------- ACTION: cell11\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 1, 1);
    		modifyXml.modifyScore(11);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);
    		}
    		

    	} else {
    		System.out.println("cell11 is not active");
    	}	
    }
    
    
    
	// Cell 12 ============================================================

    @FXML protected void handleCell12 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[10] == true) {
    		System.out.println("--------------------------------- ACTION: cell12\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 1, 2);
    		modifyXml.modifyScore(12);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}


    	} else {
    		System.out.println("cell12 is not active");
    	}	
    }
    
    
	// Cell 13 ============================================================

    @FXML protected void handleCell13 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[11] == true) {
    		System.out.println("--------------------------------- ACTION: cell11\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 1, 3);
    		modifyXml.modifyScore(13);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}


    	} else {
    		System.out.println("cell11 is not active");
    	}	
    }
    
    
    
	// Cell 14 ============================================================

    @FXML protected void handleCell14 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[12] == true) {
    		System.out.println("--------------------------------- ACTION: cell14\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 1, 4);
    		modifyXml.modifyScore(14);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}


    	} else {
    		System.out.println("cell14 is not active");
    	}	
    }
    
    
    
	// Cell 15 ============================================================

    @FXML protected void handleCell15 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[13] == true) {
    		System.out.println("--------------------------------- ACTION: cell15\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 1, 5);
    		modifyXml.modifyScore(15);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}


    	} else {
    		System.out.println("cell15 is not active");
    	}	
    }
    
    
    
	// Cell 16 ============================================================

    @FXML protected void handleCell16 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[14] == true) {
    		System.out.println("--------------------------------- ACTION: cell16\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 1, 6);
    		modifyXml.modifyScore(16);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}

    	} else {
    		System.out.println("cell16 is not active");
    	}	
    }
    
    
    
	// Cell 17 ============================================================

    @FXML protected void handleCell17 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[15] == true) {
    		System.out.println("--------------------------------- ACTION: cell17\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 1, 7);
    		modifyXml.modifyScore(17);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}


    	} else {
    		System.out.println("cell17 is not active");
    	}	
    }
    
    
	// Row 02 ====================================================================================================================================

	// Cell 20 ============================================================

    @FXML protected void handleCell20 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[16] == true) {
    		System.out.println("--------------------------------- ACTION: cell20\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 2, 0);
    		modifyXml.modifyScore(20);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}

    		
    	} else {
    		System.out.println("cell20 is not active");
    	}	
    }
    
    
    
	// Cell 21 ============================================================
    
    @FXML protected void handleCell21 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[17] == true) {
    		System.out.println("--------------------------------- ACTION: cell21\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 2, 1);
    		modifyXml.modifyScore(21);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}


    	} else {
    		System.out.println("cell21 is not active");
    	}	
    }
    
    
    
	// Cell 22 ============================================================

    @FXML protected void handleCell22 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[18] == true ) {
    		System.out.println("--------------------------------- ACTION: cell22\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 2, 2);
    		modifyXml.modifyScore(22);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}


    	} else {
    		System.out.println("cell22 is not active");
    	}	
    }	
    
  
    
	// Cell 23 ============================================================

    @FXML protected void handleCell23 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[19] == true ) {
    		System.out.println("--------------------------------- ACTION: cell23\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 2, 3);
    		modifyXml.modifyScore(23);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}
    		
    		
    	} else {
    		System.out.println("cell23 is not active");
    	}	
    }
    
    
    
	// Cell 24 ============================================================

    @FXML protected void handleCell24 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[20] == true ) {
    		System.out.println("--------------------------------- ACTION: cell24\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 2, 4);
    		modifyXml.modifyScore(24);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}


    	} else {
    		System.out.println("cell24 is not active");
    	}	
    }
    
    
    
	// Cell 25 ============================================================

    @FXML protected void handleCell25 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[21] == true ) {
    		System.out.println("--------------------------------- ACTION: cell25\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 2, 5);
    		modifyXml.modifyScore(25);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}

    		
    	} else {
    		System.out.println("cell25 is not active");
    	}	
    }
    
    
    
	// Cell 26 ============================================================

    
    @FXML Label deadPlayer;

    @FXML protected void handleCell26 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[22] == true ) {
    		System.out.println("--------------------------------- ACTION: cell26\n");
    		
    		// move pon
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 2, 6);
    		modifyXml.modifyScore(26);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		// turn visible off
			String[] playerTurn = readXml.readGlobalsMethod();
			int player = Integer.valueOf(playerTurn[2]);
			switch (player) {
			  case 0:
					pon1.setVisible(false);
			    break;
			  case 1:
					pon2.setVisible(false);
			    break;
			  case 2:
					pon3.setVisible(false);
			    break;
			  case 3:
					pon4.setVisible(false);
			    break;
			}
			
			
			// get player Name
			String[] getDeadManName = readXml.readPlayerDataMethod();
			String DeadMan = getDeadManName[0];
			  	
			 // set Text Visuals
			deadPlayer.setText(DeadMan); 
    		
			// show prisonWindow
			deathWindow.setVisible(true);
			
    		// modify XML attribute
    		modifyXml.modifyPrisonTime("999");
			System.out.println("player is dead");


    	} else {
    		System.out.println("cell26 is not active");
    	}	
    }
    
    
    
	// Cell 27 ============================================================

    @FXML protected void handleCell27 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[23] == true ) {
    		System.out.println("--------------------------------- ACTION: cell27\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 2, 7);
    		modifyXml.modifyScore(27);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}

    		
    	} else {
    		System.out.println("cell27 is not active");
    	}	
    }
    
    
    
	// Row 03 ====================================================================================================================================

 // Cell 30 ============================================================

    @FXML protected void handleCell30 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[24] == true) {
    		System.out.println("--------------------------------- ACTION: cell30\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 3, 0);
    		modifyXml.modifyScore(30);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}
    		

    	} else {
    		System.out.println("cell30 is not active");
    	}	
    }
    
    
    
	// Cell 31 ============================================================
    
    @FXML protected void handleCell31 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[25] == true) {
    		System.out.println("--------------------------------- ACTION: cell31\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 3, 1);
    		modifyXml.modifyScore(31);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}


    	} else {
    		System.out.println("cell31 is not active");
    	}	
    }
    
    
    
	// Cell 32 ============================================================

    @FXML protected void handleCell32 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[26] == true ) {
    		System.out.println("--------------------------------- ACTION: cell32\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 3, 2);
    		modifyXml.modifyScore(32);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}


    	} else {
    		System.out.println("cell32 is not active");
    	}	
    }	
    
  
    
	// Cell 33 ============================================================

    @FXML protected void handleCell33 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[27] == true ) {
    		System.out.println("--------------------------------- ACTION: cell33\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 3, 3);
    		modifyXml.modifyScore(33);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}


    	} else {
    		System.out.println("cell33 is not active");
    	}	
    }
    
    
    
	// Cell 34 ============================================================

    @FXML protected void handleCell34 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[28] == true ) {
    		System.out.println("--------------------------------- ACTION: cell34\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 3, 4);
    		modifyXml.modifyScore(34);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}

    	} else {
    		System.out.println("cell34 is not active");
    	}	
    }
    
    
    
	// Cell 35 ============================================================

    @FXML protected void handleCell35 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[29] == true ) {
    		System.out.println("--------------------------------- ACTION: cell35\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 3, 5);
    		modifyXml.modifyScore(35);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}


    	} else {
    		System.out.println("cell35 is not active");
    	}	
    }
    
    
    
	// Cell 36 ============================================================

    @FXML protected void handleCell36 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[30] == true ) {
    		System.out.println("--------------------------------- ACTION: cell36\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 3, 6);
    		modifyXml.modifyScore(36);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}


    	} else {
    		System.out.println("cell36 is not active");
    	}	
    }
    
    
    
	// Cell 37 ============================================================

    @FXML protected void handleCell37 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[31] == true ) {
    		System.out.println("--------------------------------- ACTION: cell37\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 3, 7);
    		modifyXml.modifyScore(37);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}

    	} else {
    		System.out.println("cell37 is not active");
    	}	
    }
    
    
	// Row 04 ====================================================================================================================================
    
    
    
    // Cell 40 ============================================================

    @FXML protected void handleCell40 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[32] == true) {
    		System.out.println("--------------------------------- ACTION: cell40\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 4, 0);
    		modifyXml.modifyScore(40);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}


    	} else {
    		System.out.println("cell40 is not active");
    	}	
    }
    
    
    
	// Cell 41 ============================================================
    
    @FXML protected void handleCell41 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[33] == true) {
    		System.out.println("--------------------------------- ACTION: cell41\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 4, 1);
    		modifyXml.modifyScore(41);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}


    	} else {
    		System.out.println("cell41 is not active");
    	}	
    }
    
    
    
	// Cell 42 ============================================================

    @FXML protected void handleCell42 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[34] == true ) {
    		System.out.println("--------------------------------- ACTION: cell42\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 4, 2);
    		modifyXml.modifyScore(42);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}


    	} else {
    		System.out.println("cell42 is not active");
    	}	
    }	
    
  
    
	// Cell 43 ============================================================

    @FXML protected void handleCell43 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[35] == true ) {
    		System.out.println("--------------------------------- ACTION: cell43\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 4, 3);
    		modifyXml.modifyScore(43);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}

 
    	} else {
    		System.out.println("cell43 is not active");
    	}	
    }
    
    
    
	// Cell 44 ============================================================

    @FXML protected void handleCell44 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[36] == true ) {
    		System.out.println("--------------------------------- ACTION: cell44\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 4, 4);
    		modifyXml.modifyScore(44);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}
    		

    	} else {
    		System.out.println("cell44 is not active");
    	}	
    }
    
    
    
	// Cell 45 ============================================================

    @FXML protected void handleCell45 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[37] == true ) {
    		System.out.println("--------------------------------- ACTION: cell45\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 4, 5);
    		modifyXml.modifyScore(45);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}


    	} else {
    		System.out.println("cell45 is not active");
    	}	
    }
    
    
    
	// Cell 46 ============================================================

    @FXML protected void handleCell46 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[38] == true ) {
    		System.out.println("--------------------------------- ACTION: cell46\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 4, 6);
    		modifyXml.modifyScore(46);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}

    	} else {
    		System.out.println("cell46 is not active");
    	}	
    }
    
    
    
	// Cell 47 ============================================================

    @FXML protected void handleCell47 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[39] == true ) {
    		System.out.println("--------------------------------- ACTION: cell47\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 4, 7);
    		modifyXml.modifyScore(47);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}
    		

    	} else {
    		System.out.println("cell47 is not active");
    	}	
    }

    
	// Row 05 ====================================================================================================================================
    
    
    
    // Cell 50 ============================================================

    @FXML protected void handleCell50 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[40] == true) {
    		System.out.println("--------------------------------- ACTION: cell50\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 5, 0);
    		modifyXml.modifyScore(50);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}


    	} else {
    		System.out.println("cell50 is not active");
    	}	
    }
    
    
    @FXML Label prisonerName;
    
	// Cell 51 ============================================================
    
    @FXML protected void handleCell51 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[41] == true) {
    		System.out.println("--------------------------------- ACTION: cell51\n");
    		
    		// modify XML attribute
    		modifyXml.modifyPrisonTime("1");
			System.out.println("Prison time is 1");
			
			// show prisonWindow
			prisonWindow.setVisible(true);
			
			// get player Name
			String[] getPrisonerName = readXml.readPlayerDataMethod();
			String PrisonerName = getPrisonerName[0];
			  	
			 // set Text Visuals
			 prisonerName.setText(PrisonerName);  
			 
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 5, 1);
    		modifyXml.modifyScore(51);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}

    	} else {
    		System.out.println("cell51 is not active");
    	}	
    }
    
    
    
	// Cell 52 ============================================================

    @FXML protected void handleCell52 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[42] == true ) {
    		System.out.println("--------------------------------- ACTION: cell52\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 5, 2);
    		modifyXml.modifyScore(52);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}
    		

    	} else {
    		System.out.println("cell52 is not active");
    	}	
    }	
    
  
    
	// Cell 53 ============================================================

    @FXML protected void handleCell53 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[43] == true ) {
    		System.out.println("--------------------------------- ACTION: cell53\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 5, 3);
    		modifyXml.modifyScore(53);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}
    		

    	} else {
    		System.out.println("cell53 is not active");
    	}	
    }
    
    
    
	// Cell 54 ============================================================

    @FXML protected void handleCell54 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[44] == true ) {
    		System.out.println("--------------------------------- ACTION: cell54\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 5, 4);
    		modifyXml.modifyScore(54);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}
    		

    	} else {
    		System.out.println("cell54 is not active");
    	}	
    }
    
    
    
	// Cell 55 ============================================================

    @FXML protected void handleCell55 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[45] == true ) {
    		System.out.println("--------------------------------- ACTION: cell55\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 5, 5);
    		modifyXml.modifyScore(55);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}
    		

    	} else {
    		System.out.println("cell55 is not active");
    	}	
    }
    
    
    
	// Cell 56 ============================================================

    @FXML protected void handleCell56 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[46] == true ) {
    		System.out.println("\n||||||||||||||||||||||||||||||||| ACTION: cell56\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 5, 6);
    		modifyXml.modifyScore(56);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}
    		

    	} else {
    		System.out.println("cell56 is not active");
    	}	
    }
    
    
    
	// Cell 57 ============================================================

    @FXML protected void handleCell57 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[47] == true ) {
    		System.out.println("\n||||||||||||||||||||||||||||||||| ACTION: cell57\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 5, 7);
    		modifyXml.modifyScore(57);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}
    		
    		
    	} else {
    		System.out.println("cell57 is not active");
    	}	
    }
    
    
    
	// Row 61 ====================================================================================================================================

    
	// Cell 60 ============================================================

    @FXML protected void handleCell60 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[48] == true) {
    		System.out.println("\n||||||||||||||||||||||||||||||||| ACTION: cell60\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 6, 0);
    		modifyXml.modifyScore(60);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}

	
    	} else {
    		System.out.println("cell60 is not active");
    	}	
    }
    
    
    
	// Cell 61 ============================================================

    @FXML protected void handleCell61 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[49] == true) {
    		System.out.println("\n||||||||||||||||||||||||||||||||| ACTION: cell61\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 6, 1);
    		modifyXml.modifyScore(61);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}
    		

	    		
    	} else {
    		System.out.println("cell61 is not active");
    	}	
    }
    
    
    
	// Cell 62 ============================================================

    @FXML protected void handleCell62 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[50] == true) {
    		System.out.println("\n||||||||||||||||||||||||||||||||| ACTION: cell62\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 6, 2);
    		modifyXml.modifyScore(62);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}
    		
    		
    	} else {
    		System.out.println("cell62 is not active");
    	}	
    }
    
    
	// Cell 63 ============================================================

    @FXML protected void handleCell63 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[51] == true) {
    		System.out.println("\n||||||||||||||||||||||||||||||||| ACTION: cell63\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 6, 3);
    		modifyXml.modifyScore(63);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}

    	} else {
    		System.out.println("cell63 is not active");
    	}	
    }
    
    
    
	// Cell 64 ============================================================

    @FXML protected void handleCell64 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[52] == true) {
    		System.out.println("\n||||||||||||||||||||||||||||||||| ACTION: cell64\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 6, 4);
    		modifyXml.modifyScore(64);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}

    	} else {
    		System.out.println("cell64 is not active");
    	}	
    }
    
    
    
	// Cell 65 ============================================================

    @FXML protected void handleCell65 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[53] == true) {
    		System.out.println("\n||||||||||||||||||||||||||||||||| ACTION: cell65\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 6, 5);
    		modifyXml.modifyScore(65);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}

    		
    	} else {
    		System.out.println("cell65 is not active");
    	}	
    }
    
    
    
	// Cell 66 ============================================================

    @FXML protected void handleCell66 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[54] == true) {
    		System.out.println("\n||||||||||||||||||||||||||||||||| ACTION: cell66\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 6, 6);
    		modifyXml.modifyScore(66);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}

    		
    	} else {
    		System.out.println("cell66 is not active");
    	}	
    }
    
    
    
	// Cell 67 ============================================================

    @FXML protected void handleCell67 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[55] == true) {
    		System.out.println("\n||||||||||||||||||||||||||||||||| ACTION: cell67\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 6, 7);
    		modifyXml.modifyScore(67);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}

    		
    	} else {
    		System.out.println("cell67 is not active");
    	}	
    }
    
    
	// Row 07 ====================================================================================================================================

    
	// Cell 70 ============================================================

    @FXML protected void handleCell70 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[56] == true) {
    		System.out.println("\n||||||||||||||||||||||||||||||||| ACTION: cell70\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 7, 0);
    		modifyXml.modifyScore(70);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}

	
    	} else {
    		System.out.println("cell70 is not active");
    	}	
    }
    
    
    
	// Cell 71 ============================================================

    @FXML protected void handleCell71 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[57] == true) {
    		System.out.println("\n||||||||||||||||||||||||||||||||| ACTION: cell71\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 7, 1);
    		modifyXml.modifyScore(71);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}

	    		
    	} else {
    		System.out.println("cell71 is not active");
    	}	
    }
    
    
    
	// Cell 72 ============================================================

    @FXML protected void handleCell72 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[58] == true) {
    		System.out.println("\n||||||||||||||||||||||||||||||||| ACTION: cell72\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 7, 2);
    		modifyXml.modifyScore(72);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}

    		
    	} else {
    		System.out.println("cell72 is not active");
    	}	
    }
    
    
	// Cell 73 ============================================================

    @FXML protected void handleCell73 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[59] == true) {
    		System.out.println("\n||||||||||||||||||||||||||||||||| ACTION: cell73\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 7, 3);
    		modifyXml.modifyScore(73);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}
    		
    	} else {
    		System.out.println("cell73 is not active");
    	}	
    }
    
    
    
	// Cell 74 ============================================================

    @FXML protected void handleCell74 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[60] == true) {
    		System.out.println("\n||||||||||||||||||||||||||||||||| ACTION: cell74\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 7, 4);
    		modifyXml.modifyScore(74);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}
    		
    	} else {
    		System.out.println("cell74 is not active");
    	}	
    }
    
    
    
	// Cell 75 ============================================================

    @FXML protected void handleCell75 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[61] == true) {
    		System.out.println("\n||||||||||||||||||||||||||||||||| ACTION: cell75\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 7, 5);
    		modifyXml.modifyScore(75);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}
    		
    	} else {
    		System.out.println("cell75 is not active");
    	}	
    }
    
    
    
	// Cell 76 ============================================================

    @FXML protected void handleCell76 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[62] == true) {
    		System.out.println("\n||||||||||||||||||||||||||||||||| ACTION: cell76\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 7, 6);
    		modifyXml.modifyScore(76);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}
    		
    	} else {
    		System.out.println("cell76 is not active");
    	}	
    }
    
    
    
	// Cell 77 ============================================================

    @FXML protected void handleCell77 (ActionEvent t) {	    	
    	Boolean[] readCellBool = readXml.readCellBooleanMethod();

    	if (readCellBool[63] == true) {
    		System.out.println("\n||||||||||||||||||||||||||||||||| ACTION: cell77\n");
    		
    		modifyXml.modifyBooleans();
    		movePon.ponTranslate(pon1, pon2, pon3, pon4, 7, 7);
    		modifyXml.modifyScore(77);
    		modifyScoreBoard.modifyScore(score1,score2,score3,score4);
    		
    		String[] readScore = readXml.readPlayerDataMethod();
    		int score = Integer.valueOf(readScore[2]);
    		if (score == 100) {
    			// show winnerWindow
    			winnerWindow.setVisible(true);
    			
    			// get player Name
  			  	String[] getName = readXml.readPlayerDataMethod();
  			  	String playerNameZ = getName[0];
  			  	
  			  	// set Text Visuals
  			  	winnersName.setText(playerNameZ);    		}

    		
    	} else {
    		System.out.println("cell77 is not active");
    	}	
    }
    
}