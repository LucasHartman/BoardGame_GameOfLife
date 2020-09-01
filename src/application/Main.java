package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;


public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception { 		
    	
		System.out.println("java version: " 	+System.getProperty("java.version")); 
		System.out.println("javafx.version: "	+System.getProperty("javafx.version"));
		

        Parent root = FXMLLoader.load(getClass().getResource("Board.fxml"));      
          
		  
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.TRANSPARENT);
	    stage.setScene(scene);
        stage.show();
            
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}