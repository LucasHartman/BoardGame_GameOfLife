package packages;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

//Source: https://mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/

	
	// Abstact =============================================================
	// When the app is used, data is recorded to a XML document with a number of items (see class modifyXML).
	// global itmes  tells; player round , player turn and number of player
	// player item record player name, location on the board, score, etc.
	// when a method needs data, it can use one of these methods to read the XML file
	// =====================================================================


public class readXml {


	
	// Read XML/Globals Data ===============================================
  	//
	// =====================================================================

	public static String[] readGlobalsMethod() {

		// declared output variable
		String playerNumber = null;
	    String gameCycle = null;
	    String playerTurn = null;

	  try {

		File fXmlFile = new File("src/data/gamesheet.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);

		doc.getDocumentElement().normalize();    
	    
		NodeList nList = doc.getElementsByTagName("globals");  
		Node nNode = nList.item(0);
		Element eElement = (Element) nNode;

		gameCycle = eElement.getElementsByTagName("gameCycle").item(0).getTextContent();
		playerNumber = eElement.getElementsByTagName("playerNumber").item(0).getTextContent();
		playerTurn = eElement.getElementsByTagName("playerTurn").item(0).getTextContent();

		
	    } catch (Exception e) {
	    	e.printStackTrace();
	        }
	    
	    return new String[] { gameCycle, playerNumber, playerTurn };
	  }
	
  
	
	// Read XML/Globals/Cell Boolean Data ==================================
  	//
	// =====================================================================
  
  	public static Boolean[] readCellBooleanMethod() {
	  

		// declared output variable
	    Boolean cellBool00 = null;
	    Boolean cellBool01 = null;
	    Boolean cellBool02 = null;
	    Boolean cellBool03 = null;
	    Boolean cellBool04 = null;
	    Boolean cellBool05 = null;
	    Boolean cellBool06 = null;
	    Boolean cellBool07 = null;
	    // ROW 1
	    Boolean cellBool10 = null;
	    Boolean cellBool11 = null;
	    Boolean cellBool12 = null;
	    Boolean cellBool13 = null;
	    Boolean cellBool14 = null;
	    Boolean cellBool15 = null;
	    Boolean cellBool16 = null;
	    Boolean cellBool17 = null;
	    // ROW 2
	    Boolean cellBool20 = null;
	    Boolean cellBool21 = null;
	    Boolean cellBool22 = null;
	    Boolean cellBool23 = null;
	    Boolean cellBool24 = null;
	    Boolean cellBool25 = null;
	    Boolean cellBool26 = null;
	    Boolean cellBool27 = null;
	    // ROW 3
	    Boolean cellBool30 = null;
	    Boolean cellBool31 = null;
	    Boolean cellBool32 = null;
	    Boolean cellBool33 = null;
	    Boolean cellBool34 = null;
	    Boolean cellBool35 = null;
	    Boolean cellBool36 = null;
	    Boolean cellBool37 = null;
		 // ROW 4
	    Boolean cellBool40 = null;
	    Boolean cellBool41 = null;
	    Boolean cellBool42 = null;
	    Boolean cellBool43 = null;
	    Boolean cellBool44 = null;
	    Boolean cellBool45 = null;
	    Boolean cellBool46 = null;
	    Boolean cellBool47 = null;
		 // ROW 5
	    Boolean cellBool50 = null;
	    Boolean cellBool51 = null;
	    Boolean cellBool52 = null;
	    Boolean cellBool53 = null;
	    Boolean cellBool54 = null;
	    Boolean cellBool55 = null;
	    Boolean cellBool56 = null;
	    Boolean cellBool57 = null;
		 // ROW 6
	    Boolean cellBool60 = null;
	    Boolean cellBool61 = null;
	    Boolean cellBool62 = null;
	    Boolean cellBool63 = null;
	    Boolean cellBool64 = null;
	    Boolean cellBool65 = null;
	    Boolean cellBool66 = null;
	    Boolean cellBool67 = null;
		 // ROW 7
	    Boolean cellBool70 = null;
	    Boolean cellBool71 = null;
	    Boolean cellBool72 = null;
	    Boolean cellBool73 = null;
	    Boolean cellBool74 = null;
	    Boolean cellBool75 = null;
	    Boolean cellBool76 = null;
	    Boolean cellBool77 = null;

	    	    
	    try {
		File fXmlFile = new File("src/data/gamesheet.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);

		doc.getDocumentElement().normalize();    
	    
		NodeList nList = doc.getElementsByTagName("globals");  
		Node nNode = nList.item(0);
		Element eElement = (Element) nNode;

		
		// Read Cell Boolean Value from XML
		
		// ROW 00
		cellBool00 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool00").item(0).getTextContent());
		cellBool01 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool01").item(0).getTextContent());
		cellBool02 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool02").item(0).getTextContent());
		cellBool03 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool03").item(0).getTextContent());
		cellBool04 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool04").item(0).getTextContent());
		cellBool05 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool05").item(0).getTextContent());
		cellBool06 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool06").item(0).getTextContent());
		cellBool07 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool07").item(0).getTextContent());
		// ROW 01		
		cellBool10 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool10").item(0).getTextContent());
		cellBool11 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool11").item(0).getTextContent());
		cellBool12 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool12").item(0).getTextContent());
		cellBool13 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool13").item(0).getTextContent());
		cellBool14 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool14").item(0).getTextContent());
		cellBool15 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool15").item(0).getTextContent());
		cellBool16 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool16").item(0).getTextContent());
		cellBool17 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool17").item(0).getTextContent());
		// ROW 02
		cellBool20 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool20").item(0).getTextContent());
		cellBool21 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool21").item(0).getTextContent());
		cellBool22 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool22").item(0).getTextContent());
		cellBool23 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool23").item(0).getTextContent());
		cellBool24 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool24").item(0).getTextContent());
		cellBool25 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool25").item(0).getTextContent());
		cellBool26 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool26").item(0).getTextContent());
		cellBool27 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool27").item(0).getTextContent());
		// ROW 03
		cellBool30 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool30").item(0).getTextContent());
		cellBool31 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool31").item(0).getTextContent());
		cellBool32 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool32").item(0).getTextContent());
		cellBool33 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool33").item(0).getTextContent());
		cellBool34 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool34").item(0).getTextContent());
		cellBool35 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool35").item(0).getTextContent());
		cellBool36 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool36").item(0).getTextContent());
		cellBool37 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool37").item(0).getTextContent());
		// ROW 04
		cellBool40 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool40").item(0).getTextContent());
		cellBool41 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool41").item(0).getTextContent());
		cellBool42 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool42").item(0).getTextContent());
		cellBool43 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool43").item(0).getTextContent());
		cellBool44 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool44").item(0).getTextContent());
		cellBool45 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool45").item(0).getTextContent());
		cellBool46 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool46").item(0).getTextContent());
		cellBool47 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool47").item(0).getTextContent());
		// ROW 05
		cellBool50 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool50").item(0).getTextContent());
		cellBool51 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool51").item(0).getTextContent());
		cellBool52 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool52").item(0).getTextContent());
		cellBool53 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool53").item(0).getTextContent());
		cellBool54 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool54").item(0).getTextContent());
		cellBool55 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool55").item(0).getTextContent());
		cellBool56 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool56").item(0).getTextContent());
		cellBool57 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool57").item(0).getTextContent());
		// ROW 06
		cellBool60 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool60").item(0).getTextContent());
		cellBool61 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool61").item(0).getTextContent());
		cellBool62 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool62").item(0).getTextContent());
		cellBool63 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool63").item(0).getTextContent());
		cellBool64 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool64").item(0).getTextContent());
		cellBool65 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool65").item(0).getTextContent());
		cellBool66 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool66").item(0).getTextContent());
		cellBool67 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool67").item(0).getTextContent());
		// ROW 07
		cellBool70 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool70").item(0).getTextContent());
		cellBool71 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool71").item(0).getTextContent());
		cellBool72 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool72").item(0).getTextContent());
		cellBool73 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool73").item(0).getTextContent());
		cellBool74 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool74").item(0).getTextContent());
		cellBool75 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool75").item(0).getTextContent());
		cellBool76 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool76").item(0).getTextContent());
		cellBool77 = Boolean.parseBoolean(eElement.getElementsByTagName("cellBool77").item(0).getTextContent());
		
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }

	    
	    // Export Cell Boolean Values
	    return new Boolean[] {
	    		cellBool00, cellBool01, cellBool02, cellBool03, cellBool04, cellBool05, cellBool06, cellBool07,
	    		cellBool10, cellBool11, cellBool12, cellBool13, cellBool14, cellBool15, cellBool16, cellBool17, 
	    		cellBool20, cellBool21, cellBool22, cellBool23, cellBool24, cellBool25, cellBool26, cellBool27, 
	    		cellBool30, cellBool31, cellBool32, cellBool33, cellBool34, cellBool35, cellBool36, cellBool37,
	    		cellBool40, cellBool41, cellBool42, cellBool43, cellBool44, cellBool45, cellBool46, cellBool47,
	    		cellBool50, cellBool51, cellBool52, cellBool53, cellBool54, cellBool55, cellBool56, cellBool57,
	    		cellBool60, cellBool61, cellBool62, cellBool63, cellBool64, cellBool65, cellBool66, cellBool67,
	    		cellBool70, cellBool71, cellBool72, cellBool73, cellBool74, cellBool75, cellBool76, cellBool77,
	    		};

  	}



	// Read XML/Player Data ================================================
	//
	// =====================================================================

	  public static String[] readPlayerDataMethod() {
				
			
				// declared output variable
				String name = null;
				String state = null;
				String score = null;
				String cellX = null;
				String cellY = null;
				String latitudeX = null;
				String longitudeY = null;
				String prisonTime = null;
				
				String[] getGlobals = readXml.readGlobalsMethod();
				int playerTurnInt = Integer.valueOf(getGlobals[2]);
			
			
			  try {
			
				File fXmlFile = new File("src/data/gamesheet.xml");
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fXmlFile);
			
				doc.getDocumentElement().normalize();    
			  
				
				NodeList nList = doc.getElementsByTagName("player");  
				

					
				
				Node nNode = nList.item(playerTurnInt); // get current playerTurn
				
				Element eElement = (Element) nNode;
			
				
				name = eElement.getElementsByTagName("name").item(0).getTextContent();
				state = eElement.getElementsByTagName("state").item(0).getTextContent();
				score = eElement.getElementsByTagName("score").item(0).getTextContent();
				cellX = eElement.getElementsByTagName("cellX").item(0).getTextContent();
				cellY = eElement.getElementsByTagName("cellY").item(0).getTextContent();
				latitudeX = eElement.getElementsByTagName("latitudeX").item(0).getTextContent();
				longitudeY = eElement.getElementsByTagName("longitudeY").item(0).getTextContent();
				prisonTime = eElement.getElementsByTagName("prisonTime").item(0).getTextContent();

				
				
			  } catch (Exception e) {
				  	e.printStackTrace();
				  }
			  
			  return new String[] { name, state, score, cellX, cellY, latitudeX, longitudeY, prisonTime};
	  }



		// Read XML/Player Data ================================================
		// At the start of each game, read which players pon on the bvoard  is or is visible or not 
		// =====================================================================
	  
	  public static String[] getPlayerPlay() throws SAXException, IOException, ParserConfigurationException {

			// declared output variable
			String state = null;
			int playerNum = 0;
			  
			  boolean ponVisible1 = false;
			  boolean ponVisible2 = false;
			  boolean ponVisible3 = false;
			  boolean ponVisible4 = false;
			
			
		  try {
				  
				  File fXmlFile = new File("src/data/gamesheet.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();    
		  
			NodeList nList = doc.getElementsByTagName("player");  	
				
				
				for (int temp = 0; temp < nList.getLength(); temp++) {
					
										
					Node nNode = nList.item(temp); // get current playerTurn
				
				
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {					
						
				
					Element eElement = (Element) nNode;
					
					state = eElement.getElementsByTagName("state").item(0).getTextContent();

				} // end if
	
				} // end loop
				
		  } catch(IOException e) {
			    // ... handle errors ...
		  } finally {
			    // ... cleanup that will execute whether or not an error occurred ...
		  } // end loop

		  
		  
			Boolean Pstate = Boolean.parseBoolean(state);
			if (Pstate == true) {
				playerNum = playerNum+1;
			} // end try
	        
		  
		  switch (playerNum) {
		  case 1:
			  
			   ponVisible1 = false;
			   ponVisible2 = false;
			   ponVisible3 = false;
			   ponVisible4 = false;
			  break;

		  case 2:
  			   ponVisible1 = true;
			   ponVisible2 = false;
			   ponVisible3 = false;
			   ponVisible4 = false;
			  break;
		  
		  case 3:  
			   ponVisible1 = true;
			   ponVisible2 = true;
			   ponVisible3 = false;
			   ponVisible4 = false;
			  break;
		  
		  case 4:
			   ponVisible1 = true;
			   ponVisible2 = true;
			   ponVisible3 = true;
			   ponVisible4 = false;
			  break;
		  
		  case 5:
			   ponVisible1 = true;
			   ponVisible2 = true;
			   ponVisible3 = true;
			   ponVisible4 = true;			
			  break;
		  }

		  
		  String ponVis1 = Boolean.toString(ponVisible1);
		  String ponVis2 = Boolean.toString(ponVisible2);
		  String ponVis3 = Boolean.toString(ponVisible3);
		  String ponVis4 = Boolean.toString(ponVisible4);
 
		  return new String[] { ponVis1, ponVis2, ponVis3, ponVis4 };

	  
	  } // end method

	  
	    public static String fileToStylesheetString ( File stylesheetFile ) {
            try {
                return stylesheetFile.toURI().toURL().toString();
            } catch ( MalformedURLException e ) {
                return null;
            }
        }
}