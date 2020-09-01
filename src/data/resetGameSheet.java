package data;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

		/* Generate Game Sheet ===============================================
		 * 							
		 * The Class generate a XML file, with attribute values which are import for the game
		 * Most is player data, like @Name, @Score etc.
		 * Lasty there is a @gameLoop, which can decites player turn.
		 * 
		 * NOTE: The class is not used for the game it self.
		 * the one that is used for the game setup is a xml file modifyer.
		 * This Class is mostly uses for production/testing 
		 ====================================================================*/


public class resetGameSheet {

	// Test Data ==========================================================
	// 
	// A bunch of values and strings to input to the xml generator,
	// for testing purposes
	// =====================================================================

	// Input test data
	static String[] playerNames = {"The_Rock", "BooB_JoB", "Moon_Man", "Lazzy_Mos"};
	static String[] playerStates = {"true", "true", "true", "true"};
	static String[] playerScores = {"00", "00", "00", "00"};
	static String[] CelllistX = {"0", "0", "0", "0"};
	static String[] CelllistY = {"0", "0", "0", "0"};
	static String[] nextLocationX = {"0", "0", "0", "0"};
	static String[] nextLocationY = {"0", "0", "0", "0"};
	//static String[] latitudeListX = {"35.0", "90.0", "90.0", "35.0"};
	//static String[] longitudeListY = {"965.0", "965.0", "915.0", "915.0"};
	static String[] latitudeListX = {"0", "0", "0", "0"};
	static String[] longitudeListY = {"0", "0", "0", "0"};
	
	static String[] prisonTimeList = {"0", "0", "0", "0"};
	
	static String currentCycle = "4";
	static String currentPlayer = "0";
	static String playerNum = "4"; // 3 = 4 players
	
	static String[] cellBool = {
	"false", "false", "false", "false", "false", "false", "false", "false", 
	"false", "false", "false", "false", "false", "false", "false", "false",
	"false", "false", "false", "false", "false", "false", "false", "false",
	"false", "false", "false", "false", "false", "false", "false", "false",
	"false", "false", "false", "false", "false", "false", "false", "false",
	"false", "false", "false", "false", "false", "false", "false", "false",
	"false", "false", "false", "false", "false", "false", "false", "false",
	"false", "false", "false", "false", "false", "false", "false", "false"};
	


	
	// Constructor: write xml
	private static void createPrettyXMLUsingDOM()	{
		
		try
		{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();

			
			// Create Elements ====================================================
			// 		
			// - "player" elements has a bunch of sub element which is given to each player
			// - " globals" elements has a bunch of sub element for the game it self						
			// =====================================================================

			// create root element
			Element rootElement = doc.createElement("players");
			doc.appendChild(rootElement);

			
			// creaete elements
			for(int i=0; i<=3; i++) {

				// Create Element
				Element player = doc.createElement("player");
				
						// Create sub Elements
						Element playerName = doc.createElement("name");
						playerName.setTextContent(playerNames[i]); // input: playerArray[i], id
						
						Element playerState = doc.createElement("state");
						playerState.setTextContent(playerStates[i]);
						
						Element playerscore = doc.createElement("score");
						playerscore.setTextContent(playerScores[i]);
						
						Element playerCellX = doc.createElement("cellX");
						playerCellX.setTextContent(CelllistX[i]);
				
						Element playerCellY = doc.createElement("cellY");
						playerCellY.setTextContent(CelllistY[i]);	
						
						Element latitudeX = doc.createElement("latitudeX");
						latitudeX.setTextContent(latitudeListX[i]);
				
						Element longitudeY = doc.createElement("longitudeY");
						longitudeY.setTextContent(longitudeListY[i]);	
	
						Element prisonTime = doc.createElement("prisonTime");
						prisonTime.setTextContent(prisonTimeList[i]);
						
						
				// add elements
				player.setAttribute("id", String.valueOf(i+1));
				player.appendChild(playerName);
				player.appendChild(playerState);
				player.appendChild(playerscore);
				player.appendChild(playerCellX);
				player.appendChild(playerCellY);
				player.appendChild(latitudeX);
				player.appendChild(longitudeY);
				player.appendChild(prisonTime);
							
				rootElement.appendChild(player);

			} // end loop

			

			// globals ==============================================================
			// 								turnCycle
			// - player Number:		before game, in the lobbie will be decide how 
			// 						many player there are.
			// - gamCycle:			after each player turn the gameCycle is updated +1
			// 						using this formula: 
			// 
			// 						player turn = gameCycle^number of player = remainder
			// 				
			// 						the remainder = player turn
			// - cellBool			are Boolean values to activate the cell 
			// 						if a cell is active, the current player can click on it and
			// 						his data will be updated and the next player become active.
			// =====================================================================
				
				// Create Element
				Element globals = doc.createElement("globals");
					
					// Creaete sub Elements
					Element playerNumber = doc.createElement("playerNumber");
					playerNumber.setTextContent(playerNum);	
				
					// Creaete sub Elements
					Element gameCycle = doc.createElement("gameCycle");
					gameCycle.setTextContent(currentCycle);						
					
					// Creaete sub Elements
					Element playerTurn = doc.createElement("playerTurn");
					playerTurn.setTextContent(currentPlayer);
					
					// Creaete sub Elements
					Element cellBool00 = doc.createElement("cellBool00");
					cellBool00.setTextContent(cellBool[0]);
					
					Element cellBool01 = doc.createElement("cellBool01");
					cellBool01.setTextContent(cellBool[1]);					
					
					Element cellBool02 = doc.createElement("cellBool02");
					cellBool02.setTextContent(cellBool[2]);
					
					Element cellBool03 = doc.createElement("cellBool03");
					cellBool03.setTextContent(cellBool[3]);
					
					Element cellBool04 = doc.createElement("cellBool04");
					cellBool04.setTextContent(cellBool[4]);
					
					Element cellBool05 = doc.createElement("cellBool05");
					cellBool05.setTextContent(cellBool[5]);
					
					Element cellBool06 = doc.createElement("cellBool06");
					cellBool06.setTextContent(cellBool[6]);
					
					Element cellBool07 = doc.createElement("cellBool07");
					cellBool07.setTextContent(cellBool[7]);
					
					// ROW 1
					Element cellBool10 = doc.createElement("cellBool10");
					cellBool10.setTextContent(cellBool[8]);
					
					Element cellBool11 = doc.createElement("cellBool11");
					cellBool11.setTextContent(cellBool[9]);
					
					Element cellBool12 = doc.createElement("cellBool12");
					cellBool12.setTextContent(cellBool[10]);
					
					Element cellBool13 = doc.createElement("cellBool13");
					cellBool13.setTextContent(cellBool[11]);
					
					Element cellBool14 = doc.createElement("cellBool14");
					cellBool14.setTextContent(cellBool[12]);
					
					Element cellBool15 = doc.createElement("cellBool15");
					cellBool15.setTextContent(cellBool[13]);
					
					Element cellBool16 = doc.createElement("cellBool16");
					cellBool16.setTextContent(cellBool[14]);
					
					Element cellBool17 = doc.createElement("cellBool17");
					cellBool17.setTextContent(cellBool[15]);
					
					// ROW 2
					Element cellBool20 = doc.createElement("cellBool20");
					cellBool20.setTextContent(cellBool[16]);
					
					Element cellBool21 = doc.createElement("cellBool21");
					cellBool21.setTextContent(cellBool[17]);
					
					Element cellBool22 = doc.createElement("cellBool22");
					cellBool22.setTextContent(cellBool[18]);	
					
					Element cellBool23 = doc.createElement("cellBool23");
					cellBool23.setTextContent(cellBool[19]);
					
					Element cellBool24 = doc.createElement("cellBool24");
					cellBool24.setTextContent(cellBool[20]);
					
					Element cellBool25 = doc.createElement("cellBool25");
					cellBool25.setTextContent(cellBool[21]);
					
					Element cellBool26 = doc.createElement("cellBool26");
					cellBool26.setTextContent(cellBool[22]);
					
					Element cellBool27 = doc.createElement("cellBool27");
					cellBool27.setTextContent(cellBool[23]);
					
					// ROW 3
					Element cellBool30 = doc.createElement("cellBool30");
					cellBool30.setTextContent(cellBool[24]);						
					
					Element cellBool31 = doc.createElement("cellBool31");
					cellBool31.setTextContent(cellBool[25]);	
					
					Element cellBool32 = doc.createElement("cellBool32");
					cellBool32.setTextContent(cellBool[26]);
					
					Element cellBool33 = doc.createElement("cellBool33");
					cellBool33.setTextContent(cellBool[27]);
					
					Element cellBool34 = doc.createElement("cellBool34");
					cellBool34.setTextContent(cellBool[28]);
					
					Element cellBool35 = doc.createElement("cellBool35");
					cellBool35.setTextContent(cellBool[29]);
					
					Element cellBool36 = doc.createElement("cellBool36");
					cellBool36.setTextContent(cellBool[30]);
					
					Element cellBool37 = doc.createElement("cellBool37");
					cellBool37.setTextContent(cellBool[31]);
					
					// ROW 4
					Element cellBool40 = doc.createElement("cellBool40");
					cellBool40.setTextContent(cellBool[32]);						
					
					Element cellBool41 = doc.createElement("cellBool41");
					cellBool41.setTextContent(cellBool[33]);	
					
					Element cellBool42 = doc.createElement("cellBool42");
					cellBool42.setTextContent(cellBool[34]);
					
					Element cellBool43 = doc.createElement("cellBool43");
					cellBool43.setTextContent(cellBool[35]);
					
					Element cellBool44 = doc.createElement("cellBool44");
					cellBool44.setTextContent(cellBool[36]);
					
					Element cellBool45 = doc.createElement("cellBool45");
					cellBool45.setTextContent(cellBool[37]);
					
					Element cellBool46 = doc.createElement("cellBool46");
					cellBool46.setTextContent(cellBool[38]);
					
					Element cellBool47 = doc.createElement("cellBool47");
					cellBool47.setTextContent(cellBool[39]);
					
					// ROW 5
					Element cellBool50 = doc.createElement("cellBool50");
					cellBool50.setTextContent(cellBool[40]);						
					
					Element cellBool51 = doc.createElement("cellBool51");
					cellBool51.setTextContent(cellBool[41]);	
					
					Element cellBool52 = doc.createElement("cellBool52");
					cellBool52.setTextContent(cellBool[42]);
					
					Element cellBool53 = doc.createElement("cellBool53");
					cellBool53.setTextContent(cellBool[43]);
					
					Element cellBool54 = doc.createElement("cellBool54");
					cellBool54.setTextContent(cellBool[44]);
					
					Element cellBool55 = doc.createElement("cellBool55");
					cellBool55.setTextContent(cellBool[45]);
					
					Element cellBool56 = doc.createElement("cellBool56");
					cellBool56.setTextContent(cellBool[46]);
					
					Element cellBool57 = doc.createElement("cellBool57");
					cellBool57.setTextContent(cellBool[47]);
					
					// ROW 6
					Element cellBool60 = doc.createElement("cellBool60");
					cellBool60.setTextContent(cellBool[48]);						
					
					Element cellBool61 = doc.createElement("cellBool61");
					cellBool61.setTextContent(cellBool[49]);	
					
					Element cellBool62 = doc.createElement("cellBool62");
					cellBool62.setTextContent(cellBool[50]);
					
					Element cellBool63 = doc.createElement("cellBool63");
					cellBool63.setTextContent(cellBool[51]);
					
					Element cellBool64 = doc.createElement("cellBool64");
					cellBool64.setTextContent(cellBool[52]);
					
					Element cellBool65 = doc.createElement("cellBool65");
					cellBool65.setTextContent(cellBool[53]);
					
					Element cellBool66 = doc.createElement("cellBool66");
					cellBool66.setTextContent(cellBool[54]);
					
					Element cellBool67 = doc.createElement("cellBool67");
					cellBool67.setTextContent(cellBool[55]);
					
					// ROW 7
					Element cellBool70 = doc.createElement("cellBool70");
					cellBool70.setTextContent(cellBool[56]);						
					
					Element cellBool71 = doc.createElement("cellBool71");
					cellBool71.setTextContent(cellBool[57]);	
					
					Element cellBool72 = doc.createElement("cellBool72");
					cellBool72.setTextContent(cellBool[58]);
					
					Element cellBool73 = doc.createElement("cellBool73");
					cellBool73.setTextContent(cellBool[59]);
					
					Element cellBool74 = doc.createElement("cellBool74");
					cellBool74.setTextContent(cellBool[60]);
					
					Element cellBool75 = doc.createElement("cellBool75");
					cellBool75.setTextContent(cellBool[61]);
					
					Element cellBool76 = doc.createElement("cellBool76");
					cellBool76.setTextContent(cellBool[62]);
					
					Element cellBool77 = doc.createElement("cellBool77");
					cellBool77.setTextContent(cellBool[63]);
					
					
					globals.appendChild(playerNumber);
					globals.appendChild(gameCycle);
					globals.appendChild(playerTurn);
					
					// ROW 00
					globals.appendChild(cellBool00);
					globals.appendChild(cellBool01);
					globals.appendChild(cellBool02);
					globals.appendChild(cellBool03);
					globals.appendChild(cellBool04);
					globals.appendChild(cellBool05);
					globals.appendChild(cellBool06);
					globals.appendChild(cellBool07);
					// ROW 01
					globals.appendChild(cellBool10);
					globals.appendChild(cellBool11);
					globals.appendChild(cellBool12);
					globals.appendChild(cellBool13);
					globals.appendChild(cellBool14);
					globals.appendChild(cellBool15);
					globals.appendChild(cellBool16);
					globals.appendChild(cellBool17);
					// ROW 02
					globals.appendChild(cellBool20);
					globals.appendChild(cellBool21);
					globals.appendChild(cellBool22);
					globals.appendChild(cellBool23);
					globals.appendChild(cellBool24);
					globals.appendChild(cellBool25);
					globals.appendChild(cellBool26);
					globals.appendChild(cellBool27);
					// ROW 03
					globals.appendChild(cellBool30);
					globals.appendChild(cellBool31);
					globals.appendChild(cellBool32);
					globals.appendChild(cellBool33);
					globals.appendChild(cellBool34);
					globals.appendChild(cellBool35);
					globals.appendChild(cellBool36);
					globals.appendChild(cellBool37);
					// ROW 4
					globals.appendChild(cellBool40);
					globals.appendChild(cellBool41);
					globals.appendChild(cellBool42);
					globals.appendChild(cellBool43);
					globals.appendChild(cellBool44);
					globals.appendChild(cellBool45);
					globals.appendChild(cellBool46);
					globals.appendChild(cellBool47);
					// ROW 5
					globals.appendChild(cellBool50);
					globals.appendChild(cellBool51);
					globals.appendChild(cellBool52);
					globals.appendChild(cellBool53);
					globals.appendChild(cellBool54);
					globals.appendChild(cellBool55);
					globals.appendChild(cellBool56);
					globals.appendChild(cellBool57);
					// ROW 6
					globals.appendChild(cellBool60);
					globals.appendChild(cellBool61);
					globals.appendChild(cellBool62);
					globals.appendChild(cellBool63);
					globals.appendChild(cellBool64);
					globals.appendChild(cellBool65);
					globals.appendChild(cellBool66);
					globals.appendChild(cellBool67);
					// ROW 7
					globals.appendChild(cellBool70);
					globals.appendChild(cellBool71);
					globals.appendChild(cellBool72);
					globals.appendChild(cellBool73);
					globals.appendChild(cellBool74);
					globals.appendChild(cellBool75);
					globals.appendChild(cellBool76);
					globals.appendChild(cellBool77);
		
					
					rootElement.appendChild(globals);
			
	
			
			// Create XML file =====================================================
			//
			// =====================================================================			
			
			// Write the content into XML file
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("src/data/gamesheet.xml"));
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			// Beautify the format of the resulted XML
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			transformer.transform(source, result);
				
				}   catch(Exception ex) {
					ex.printStackTrace();
				}
			}


	
			// Execute Class Method ================================================
			//
			// =====================================================================
	
			public static void main(String[] args){
				
				// Method
				createPrettyXMLUsingDOM();
				
		        System.out.println("XML file created successfully");
			}

}