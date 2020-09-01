package packages;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



public class modifyXml {

	

	// Abstract ============================================================
	// A number of constructors for updating diffent items within XML-file
	// =====================================================================



	// modify Score =========================================================	
	// 0. construct method:		construct method to progress the game to the next player turn
	
	// 1. get XML data:			get data (game Cycle, player Number, player Turn from XML
	// 1.1 get XML location		find path to the XML-file
	
	// 2.	modify score		based on the pon on which cell location, the player score gets modied
	// =====================================================================
	
	// constructor
	public static void modifyScore(int cellID) {
	
					// 1. get XML data
					String[] Globals = readXml.readGlobalsMethod();
					int Turn = Integer.valueOf(Globals[2]); // get player turn
					String[] Plyr = readXml.readPlayerDataMethod();
					int currentScore = Integer.valueOf(Plyr[5]); // get score
					String currentName = Plyr[0]; // get name

					// get XML location
					   try {
							String filepath = "src/data/gamesheet.xml";
							DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
							DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
							Document doc = docBuilder.parse(filepath);

							// Get current player item
							Node player = doc.getElementsByTagName("player").item(Turn);
							NodeList list = player.getChildNodes();	

				   // modify score
				   switch (cellID) {
				   
				   // ROW 0
				   case 00:
					     System.out.println("no point for 00");
				     break;
				   case 01:
					   System.out.println("no point for 01");
				     break;
				   case 02:
				     System.out.println("no point for 02");
				     break;
				   case 03:
				     System.out.println("no point for 03");
				     break;
				   case 04:
				     System.out.println("no point for 04");
				     break;
				   case 05:
				     System.out.println("no point for 05");
				     break;
				   case 06:
				     System.out.println("no point for 06");
				     break;
				   case 07:
				     System.out.println("no point for 07");
				     break;
			     
				   // ROW 1
				   case 10:
					   System.out.println("no point for 10");
				     break;  
				   case 11: // School
					   
					     System.out.println("Moves to Collage");

						 // modify score
						 int newScore11 = currentScore +5;
					     // update score
						 Node score11 = list.item(5); // attribute 
						 score11.setTextContent(String. valueOf(newScore11)); // attribute value
					     // print score
						 System.out.println("COLLAGE: 5 PONTS");
					     System.out.println(currentName +" new score: " +newScore11);
					     
				     break;
				   case 12:
				     System.out.println("no point for 12");
				     break;
				   case 13: // INFLUENCE
					     System.out.println("Moves to Fat Office");

						 // modify score
						 int newScore = currentScore +5;
					     // update score
						 Node score = list.item(5); // attribute 
						 score.setTextContent(String. valueOf(newScore)); // attribute value
					     // print score
						 System.out.println("FAT OFFICE: 5 PONTS");
					     System.out.println(currentName +" new score: " +newScore);
					     
				     break;
				   case 14:
				     System.out.println("no point for 14");
				     break;
				   case 15:
				     System.out.println("no point for 15");
				     break;
				   case 16:
				     System.out.println("no point for 16");
				     break;
				   case 17:
					   
					 // modify score
					 int newScore17 = currentScore +5;
				     // update score
					 Node score17 = list.item(5); // attribute 
					 score17.setTextContent(String. valueOf(newScore17)); // attribute value
				     // print score
					 System.out.println("FAT OFFICE: 5 PONTS");
				     System.out.println(currentName +" new score: " +newScore17);

				     break;
				     
				   // ROW 2
				   case 21:
				     System.out.println("no point for 21");
				     break;
				   case 22: // AMBITION
				     System.out.println("No point for 22");
				     System.out.println("Moves to Fame");

				     break;
				   case 23:
				     System.out.println("no point for 23");
				     break;
				   case 24:
				     
					 // modify score
					 int newScore24 = currentScore +5;
				     // update score
					 Node score24 = list.item(5); // attribute 
					 score24.setTextContent(String. valueOf(newScore24)); // attribute value
				     // print score
					 System.out.println("COLLAGE: 5 PONTS");
				     System.out.println(currentName +" new score: " +newScore24);
				     
				     break;
				     
				   case 25:
				     System.out.println("no point for 25");
				     break;
				   case 26:
				     System.out.println("no point for 26");
				     break;
				   case 27:
				     System.out.println("no point for 27");
				     break;	  
				     
				   // ROW 3
				   case 30:
					     System.out.println("no point for 30");
				     break;
				   case 31: // Honesty
					   
					     System.out.println("Moves to Happiness");
					     
						 // modify score
						 int newScore31 = currentScore +5;
					     // update score
						 Node score31 = list.item(5); // attribute 
						 score31.setTextContent(String. valueOf(newScore31)); // attribute value
					     // print score
						 System.out.println("HAPPINESS: 5 PONTS");
					     System.out.println(currentName +" new score: " +newScore31);
					     
				     break;
				   case 32:
				     System.out.println("no point for 32");
				     break;
				   case 33: // Industry 
					     System.out.println("Moves to Wealth");
					     
					     
						 // modify score
						 int newScore33 = currentScore +10;
					     // update score
						 Node score33 = list.item(5); // attribute 
						 score33.setTextContent(String. valueOf(newScore33)); // attribute value
					     // print score
						 System.out.println("WEALTH: 10 PONTS");
					     System.out.println(currentName +" new score: " +newScore33);
					        
				     break;
				     
				   case 34:
				     System.out.println("no point for 34");
				     break;
				   case 35: // Bravery
					   
					     System.out.println("Moves to Honor");
					     
						 // modify score
						 int newScore35 = currentScore +5;
					     // update score
						 Node score35 = list.item(5); // attribute 
						 score35.setTextContent(String. valueOf(newScore35)); // attribute value
					     // print score
						 System.out.println("HONOR: 5 PONTS");
					     System.out.println(currentName +" new score: " +newScore35);
					     
  
				     System.out.println("no point for 35");
				     break;
				   case 36:
				     System.out.println("no point for 36");
				     break;
				   case 37:
				     System.out.println("no point for 37");
				     break;
				     
				   // ROW 4
				   case 40:
					     
					 // modify score
					 int newScore40 = currentScore +5;
				     // update score
					 Node score40 = list.item(5); // attribute 
					 score40.setTextContent(String. valueOf(newScore40)); // attribute value
				     // print score
					 System.out.println("CONGRESS: 5 PONTS");
				     System.out.println(currentName +" new score: " +newScore40);
					     
					     break;
					     
				   case 41:
				     //System.out.println("no point for 41");
				     break;
				   case 42:
				     
					 // modify score
					 int newScore42 = currentScore +5;
				     // update score
					 Node score42 = list.item(5); // attribute 
					 score42.setTextContent(String. valueOf(newScore42)); // attribute value
				     // print score
					 System.out.println("HONOR: 5 PONTS");
				     System.out.println(currentName +" new score: " +newScore42);
					     
				     break;
				     
				   case 43:
				     System.out.println("no point for 43");
				     break;
				   case 44: // CUPID
					   
					     System.out.println("Moves to Matrimony");
					     System.out.println("no point for 44");
					     
				     break;
				   case 45:
				     System.out.println("no point for 45");
				     break;
				   case 46: // Goverment Contract
					   
					     System.out.println("Moves to Wealth");
				     
					 // modify score
					 int newScore46 = currentScore +10;
				     // update score
					 Node score46 = list.item(5); // attribute 
					 score46.setTextContent(String. valueOf(newScore46)); // attribute value
				     // print score
					 System.out.println("WEALTH: 10 PONTS");
				     System.out.println(currentName +" new score: " +newScore46);
				     
				     
				     break;
				   case 47:
				     System.out.println("no point for 47");
				     break;
				     
				   // ROW 5
				   case 50:
					     //System.out.println("no point for 50");
				     break;
				   case 51:
				     
					   System.out.println("Moves to Prison");

					   System.out.println("no point for 51");

				     break;
				   case 52:
				     System.out.println("no point for 52");
				     break;
				   case 53:
				     System.out.println("no point for 53");
				     
					 // modify score
					 int newScore53 = currentScore +5;
				     // update score
					 Node score53 = list.item(5); // attribute 
					 score53.setTextContent(String. valueOf(newScore53)); // attribute value
				     // print score
					 System.out.println("HAPPINESS: 5 PONTS");
				     System.out.println(currentName +" new score: " +newScore53);
					     
				     
				     break;
				   case 54:
					   
				     System.out.println("no point for 54");
				     
				     break;
				   
				   case 55: // Idleness
					   
					 System.out.println("Moves to Disgrace");
				     System.out.println("no point for 55");
				     
				     break;
				   
				   case 56:
				     System.out.println("no point for 56");
				     break;
				   case 57:
				    System.out.println("no point for 57");
				     
					 // modify score
					 int newScore57 = currentScore +5;
				     // update score
					 Node score57 = list.item(5); // attribute 
					 score57.setTextContent(String. valueOf(newScore57)); // attribute value
				     // print score
					 System.out.println("SUCCES: 5 PONTS");
				     System.out.println(currentName +" new score: " +newScore57);
					     
				     break;
				     
				   // ROW 6
				   case 60: // Perseverance
					   
					     System.out.println("Moves to Succes");
					     
						 // modify score
						 int newScore60 = currentScore +5;
					     // update score
						 Node score60 = list.item(5); // attribute 
						 score60.setTextContent(String. valueOf(newScore60)); // attribute value
					     // print score
						 System.out.println("SUCCES: 5 PONTS");
					     System.out.println(currentName +" new score: " +newScore60);
				     
					     break;
				   case 61:
				     System.out.println("no point for 61");
				     break;
				   case 62:
				     System.out.println("no point for 62");
				     break;
				   case 63:
				     System.out.println("no point for 63");
				     break;
				   case 64: // Politics
					   
					System.out.println("Moves to Congress");
				     
					 // modify score
					 int newScore64 = currentScore +5;
				     // update score
					 Node score64 = list.item(5); // attribute 
					 score64.setTextContent(String. valueOf(newScore64)); // attribute value
				     // print score
					 System.out.println("CONGRESS: 5 PONTS");
				     System.out.println(currentName +" new score: " +newScore64);
					     
				     break;
				   case 65:
				     System.out.println("no point for 65");
				     break;
				   case 66: // Intemperance
					   
				     System.out.println("no point for 66");
				     
				     break;
				   case 67:
				     System.out.println("no point for 67");
				     break;
				     
				   // ROW 7
				   case 70:
				   System.out.println("no point for 70");
				     break;
				   case 71: // Wealth
				     
					 // modify score
					 int newScore71 = currentScore +10;
				     // update score
					 Node score71 = list.item(5); // attribute 
					 score71.setTextContent(String. valueOf(newScore71)); // attribute value
				     // print score
					 System.out.println("WEALTH: 10 PONTS");
				     System.out.println(currentName +" new score: " +newScore71);
				     
				     break;
				     
				   case 72:
				     System.out.println("no point for 72");
				     break;
				   case 73:
				     System.out.println("no point for 73");
				     break;
				   case 74:
				     System.out.println("no point for 74");
				     break;
				   case 75: // Gambeling
				     System.out.println("no point for 75");
				     break;
				   case 76:
				     System.out.println("no point for 76");
				     break;
				   case 77: // Happy Old Age
				     
					 // modify score
					 int newScore77 = currentScore +50;
				     // update score
					 Node score77 = list.item(5); // attribute 
					 score77.setTextContent(String. valueOf(newScore77)); // attribute value
				     // print score
					 System.out.println("HAPPY OLD AGE: 50 PONTS");
				     System.out.println(currentName +" new score: " +newScore77);
				     
				     break;
			   
				 }


		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(filepath));
		transformer.transform(source, result);

	   } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	   } catch (TransformerException tfe) {
		tfe.printStackTrace();
	   } catch (IOException ioe) {
		ioe.printStackTrace();
	   } catch (SAXException sae) {
		sae.printStackTrace();
	   } 

	}
	

	// modify prison Time  =================================================
	// If a players pon gets on the priosn cell, s/he loses the next turn
	// =====================================================================
	
	public static void modifyPrisonTime(String prisontime) {
		
		String[] Globals = readXml.readGlobalsMethod();
		int Turn = Integer.valueOf(Globals[2]); // get player turn
		
		   try {
			   
				String filepath = "src/data/gamesheet.xml";
				DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
				Document doc = docBuilder.parse(filepath);

				// Get the staff element by tag name directly
				Node player = doc.getElementsByTagName("player").item(Turn); // player number
				
				NodeList list = player.getChildNodes();	


			     // update score
				 Node prisonTime = list.item(15); // attribute 
				 prisonTime.setTextContent(String. valueOf(prisontime)); // attribute value


	
				// write the content into xml file
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(new File(filepath));
				transformer.transform(source, result);
			
			} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
			} catch (TransformerException tfe) {
			tfe.printStackTrace();
			} catch (IOException ioe) {
			ioe.printStackTrace();
			} catch (SAXException sae) {
			sae.printStackTrace();
			} 
}	



	// modify Cell location=================================================
	// When the current player moves to a new cell this data get updated
	// =====================================================================
	
	public static void modifyCellXY( int cellY, int cellX) {
		
		String[] Globals = readXml.readGlobalsMethod();
		int Turn = Integer.valueOf(Globals[2]);
		
		   try {
			   
			String filepath = "src/data/gamesheet.xml";
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(filepath);

			// Get the staff element by tag name directly
			Node player = doc.getElementsByTagName("player").item(Turn); // player number
			
			NodeList list = player.getChildNodes();

					// cellY
					Node newcellY = list.item(9); // attribute 
					newcellY.setTextContent(String.valueOf(cellY)); // attribute value
					
					// cellX
					Node newcellX = list.item(7); // attribute 
					newcellX.setTextContent(String.valueOf(cellX)); // attribute value
					
					System.out.println("MODIFY CELL LOCATION");
					System.out.println("------------------------------------");
					System.out.println("cell Y: " +cellY);
					System.out.println("cell X: " +cellX);

					
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(filepath));
		transformer.transform(source, result);

	   } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	   } catch (TransformerException tfe) {
		tfe.printStackTrace();
	   } catch (IOException ioe) {
		ioe.printStackTrace();
	   } catch (SAXException sae) {
		sae.printStackTrace();
	   } 

	}


	
	// modify pon Location =================================================
	// modify the pon cell location on the board. This method is used for
	// pon animation, moving from position A to B (see class PonMove)
	// =====================================================================

	public static void modifyCoor(int cellID, int newLongitudeY, int newLatitudeX) {
		
		String[] Globals = readXml.readGlobalsMethod();
		int Turn = Integer.valueOf(Globals[2]);
		
		   try {
			   
			String filepath = "src/data/gamesheet.xml";
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(filepath);

			// Get the staff element by tag name directly
			Node player = doc.getElementsByTagName("player").item(Turn); // player number
			
			NodeList list = player.getChildNodes();

					// latitudeX
					Node latitudeX = list.item(11); // attribute 
					latitudeX.setTextContent(String.valueOf(newLatitudeX)); // attribute value

					// longitudeY
					Node longitudeY = list.item(13); // attribute 
					longitudeY.setTextContent(String.valueOf(newLongitudeY)); // attribute value

					
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(filepath));
		transformer.transform(source, result);

	   } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	   } catch (TransformerException tfe) {
		tfe.printStackTrace();
	   } catch (IOException ioe) {
		ioe.printStackTrace();
	   } catch (SAXException sae) {
		sae.printStackTrace();
	   } 

	}
		

	
	// modify Cell activty =================================================
	// This list will tell which cell are active for the current player to
	// move his/her pon to
	// =====================================================================

	public static void modifyBooleans() {
	
		
		// Cell Boolean value, for being active or not
		String[] cellBool = {			
				"false", "false", "false", "false", "false", "false", "false", "false", 
				"false", "false", "false", "false", "false", "false", "false", "false",
				"false", "false", "false", "false", "false", "false", "false", "false",
				"false", "false", "false", "false", "false", "false", "false", "false",
				"false", "false", "false", "false", "false", "false", "false", "false",
				"false", "false", "false", "false", "false", "false", "false", "false",
				"false", "false", "false", "false", "false", "false", "false", "false",
				"false", "false", "false", "false", "false", "false", "false", "false"};


	   try {
			String filepath = "src/data/gamesheet.xml";
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(filepath);

		
		// Get the staff element by tag name directly
		Node globals = doc.getElementsByTagName("globals").item(0);

		//get Elements
		NodeList list = globals.getChildNodes();			
		Node cell00 = list.item(7);
		Node cell01 = list.item(9);
		Node cell02 = list.item(11);
		Node cell03 = list.item(13);
		Node cell04 = list.item(15);
		Node cell05 = list.item(17);
		Node cell06 = list.item(19);
		Node cell07 = list.item(21);
		
		Node cell10 = list.item(23);
		Node cell11 = list.item(25);
		Node cell12 = list.item(27);
		Node cell13 = list.item(29);
		Node cell14 = list.item(31);
		Node cell15 = list.item(33);
		Node cell16 = list.item(35);
		Node cell17 = list.item(37);
		
		Node cell20 = list.item(39);
		Node cell21 = list.item(41);
		Node cell22 = list.item(43);
		Node cell23 = list.item(45);
		Node cell24 = list.item(47);
		Node cell25 = list.item(49);
		Node cell26 = list.item(51);
		Node cell27 = list.item(53);
		
		Node cell30 = list.item(55);
		Node cell31 = list.item(57);
		Node cell32 = list.item(59);
		Node cell33 = list.item(61);
		Node cell34 = list.item(63);
		Node cell35 = list.item(65);
		Node cell36 = list.item(67);
		Node cell37 = list.item(69);
		
		Node cell40 = list.item(71);
		Node cell41 = list.item(73);
		Node cell42 = list.item(75);
		Node cell43 = list.item(77);
		Node cell44 = list.item(79);
		Node cell45 = list.item(81);
		Node cell46 = list.item(83);
		Node cell47 = list.item(85);
		
		Node cell50 = list.item(87);
		Node cell51 = list.item(89);
		Node cell52 = list.item(91);
		Node cell53 = list.item(93);
		Node cell54 = list.item(95);
		Node cell55 = list.item(97);
		Node cell56 = list.item(99);
		Node cell57 = list.item(101);
		
		
		Node cell60 = list.item(103);
		Node cell61 = list.item(105);
		Node cell62 = list.item(107);
		Node cell63 = list.item(109);
		Node cell64 = list.item(111);
		Node cell65 = list.item(113);
		Node cell66 = list.item(115);
		Node cell67 = list.item(117);
		
		
		Node cell70 = list.item(119);
		Node cell71 = list.item(121);
		Node cell72 = list.item(123);
		Node cell73 = list.item(125);
		Node cell74 = list.item(127);
		Node cell75 = list.item(129);
		Node cell76 = list.item(131);
		Node cell77 = list.item(133);
		
		// update Elements
		cell00.setTextContent(cellBool[0]);
		cell01.setTextContent(cellBool[1]);
		cell02.setTextContent(cellBool[2]);
		cell03.setTextContent(cellBool[3]);
		cell04.setTextContent(cellBool[4]);
		cell05.setTextContent(cellBool[5]);
		cell06.setTextContent(cellBool[6]);
		cell07.setTextContent(cellBool[7]);
		
		cell10.setTextContent(cellBool[8]);
		cell11.setTextContent(cellBool[9]);
		cell12.setTextContent(cellBool[10]);
		cell13.setTextContent(cellBool[11]);
		cell14.setTextContent(cellBool[12]);
		cell15.setTextContent(cellBool[13]);
		cell16.setTextContent(cellBool[14]);
		cell17.setTextContent(cellBool[15]);
		
		cell20.setTextContent(cellBool[16]);
		cell21.setTextContent(cellBool[17]);
		cell22.setTextContent(cellBool[18]);
		cell23.setTextContent(cellBool[19]);
		cell24.setTextContent(cellBool[20]);
		cell25.setTextContent(cellBool[21]);
		cell26.setTextContent(cellBool[22]);
		cell27.setTextContent(cellBool[23]);
		
		cell30.setTextContent(cellBool[24]);
		cell31.setTextContent(cellBool[25]);
		cell32.setTextContent(cellBool[26]);
		cell33.setTextContent(cellBool[27]);
		cell34.setTextContent(cellBool[28]);
		cell35.setTextContent(cellBool[29]);
		cell36.setTextContent(cellBool[30]);
		cell37.setTextContent(cellBool[31]);
		
		cell40.setTextContent(cellBool[32]);
		cell41.setTextContent(cellBool[33]);
		cell42.setTextContent(cellBool[34]);
		cell43.setTextContent(cellBool[35]);
		cell44.setTextContent(cellBool[36]);
		cell45.setTextContent(cellBool[37]);
		cell46.setTextContent(cellBool[38]);
		cell47.setTextContent(cellBool[39]);
		
		cell50.setTextContent(cellBool[40]);
		cell51.setTextContent(cellBool[41]);
		cell52.setTextContent(cellBool[42]);
		cell53.setTextContent(cellBool[43]);
		cell54.setTextContent(cellBool[44]);
		cell55.setTextContent(cellBool[45]);
		cell56.setTextContent(cellBool[46]);
		cell57.setTextContent(cellBool[47]);
		
		cell60.setTextContent(cellBool[48]);
		cell61.setTextContent(cellBool[49]);
		cell62.setTextContent(cellBool[50]);
		cell63.setTextContent(cellBool[51]);
		cell64.setTextContent(cellBool[52]);
		cell65.setTextContent(cellBool[53]);
		cell66.setTextContent(cellBool[54]);
		cell67.setTextContent(cellBool[55]);
		
		cell70.setTextContent(cellBool[56]);
		cell71.setTextContent(cellBool[57]);
		cell72.setTextContent(cellBool[58]);
		cell73.setTextContent(cellBool[59]);
		cell74.setTextContent(cellBool[60]);
		cell75.setTextContent(cellBool[61]);
		cell76.setTextContent(cellBool[62]);
		cell77.setTextContent(cellBool[63]);


		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File(filepath));
		transformer.transform(source, result);
		
	   } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	   } catch (TransformerException tfe) {
		tfe.printStackTrace();
	   } catch (IOException ioe) {
		ioe.printStackTrace();
	   } catch (SAXException sae) {
		sae.printStackTrace();
	   }
		
	}
	
}