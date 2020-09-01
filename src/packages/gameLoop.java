package packages;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;

import java.io.File;
import java.io.IOException;


		// Abstact =============================================================
		// 
		// 0. construct method:		construct method to progress the game to the next player turn

		// 1. get XML data:			get data (game Cycle, player Number, player Turn from XML

		// 2. convert datatype:		String "gameCycle" to integer & String "playerNumber" to integer
		// 2.1 calculate gameCycle:	value gameCycle +1
		// 2.2 calculate playerTurn: gameCycle - playerTurn - playerTurn - playerTurn... = remainder = playerTurn value
		// 2.3 convert datatype:	integer gameCycle to String gameCycle & integer playerTurn to String

		// 3. modify XML-file:		update data in the XML-file
		// 3.1 get file:			get XML from local drive
		// 3.2 get element:			get element globals where all global data (gameCycle,PlayerTurn ect.) is stored
		// 3.2 get attributes:		get attributes from global list
		// 3.2 set new:				set attributes to new value
		// 3.3 modify XML-file:		update attributes into XML-file

		// 4  return values			export data out of this method
		// =====================================================================


public class gameLoop {

  // 0. construct Method
  public static String[] gameLoopMethod() {

		
		System.out.println("--------------------------------- START: gameLoop");


		// 1. get XML data
		String[] Eglobals = readXml.readGlobalsMethod();		
		String gameCycle = Eglobals[0];
		String playerNumber = Eglobals[1];
		String playerTurn = Eglobals[2];
		
		// print message
		System.out.println("READ DATA:");
		System.out.println("---------------------------------");
		System.out.println("gameCycle:    " +gameCycle);
		System.out.println("playerNumber: " +playerNumber); 
		System.out.println("playerTurn:   " +playerTurn); 


	    // 2. String => Int
	    int gameCycleInt = Integer.valueOf(gameCycle);
	    int playerNumberInt = Integer.valueOf(playerNumber);	


	    // 2.1 calculate gameCycle
	    gameCycleInt = gameCycleInt+1;


	    // 2.2 get Remainder
	    int playerTurnInt = gameCycleInt % playerNumberInt;


	    // 2.3 Int => String
	    gameCycle = String.valueOf(gameCycleInt);
	    playerTurn = String.valueOf(playerTurnInt);


	    // 3. update XML-file
		  try {
			// 3.1 get file
			String filepath = "src/data/gamesheet.xml";
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(filepath);

			
			// 3.1 get element
			Node globals = doc.getElementsByTagName("globals").item(0);

			// 3.2 get attriutes
			NodeList list = globals.getChildNodes();
			Node GCnode = list.item(3);
			Node PTnode = list.item(5);

			// 3.3 input new data
			GCnode.setTextContent(gameCycle);
			PTnode.setTextContent(playerTurn);

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


		    // print message
			System.out.println("\nUPDATED DATA:");
			System.out.println("---------------------------------");
			System.out.println("gameCycle:    " +gameCycle); 
			System.out.println("playerNumber: " +playerNumber); 
			System.out.println("playerTurn:   " +playerTurn); 

			System.out.println("--------------------------------- END: gameLoop");

	    // 4. return new values
	    return new String[] { gameCycle, playerNumber, playerTurn };
	  }
}