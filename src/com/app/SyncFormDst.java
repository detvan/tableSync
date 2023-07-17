package com.app;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SyncFormDst extends VBox {

	private HBox hboxUp;
	private HBox hboxBottom;
	private Button btnSave;
	private Button btnSync;
	private Image destinationIcon;
	private Label lblDestination;
	
	private ComboBox<String> destinationType;
	
	private TabPane destinationTabPane; 
	
	private PostgresPanel postgresPanel;
	private MySQLPanel mysqlPanel;
	private CSVPanel csvPanel;
	

	public SyncFormDst() {
		hboxUp = new HBox();
		hboxUp.setAlignment(Pos.BASELINE_LEFT);
		
		destinationIcon = new Image("/com/app/images/destination.png"); 
	    ImageView destinationView = new ImageView(destinationIcon);
	    destinationView.setFitHeight(40);
	    destinationView.setPreserveRatio(true);
	    

		lblDestination = new Label("Destination: ");
		lblDestination.setGraphic(destinationView);
		
		
		destinationType = new ComboBox<String>();
		destinationType.getItems().add("PostgreSQL");
		destinationType.getItems().add("MySQL");
		destinationType.getItems().add("CSV");
		//destinationType.getSelectionModel().selectFirst();
		
		
		destinationTabPane = new TabPane();
		destinationTabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		
		Tab tabPostgres = new Tab("PostgreSQL");
        Tab tabMysql = new Tab("MySQL");
        Tab tabCsv = new Tab("CSV");
		
		postgresPanel = new PostgresPanel();
		mysqlPanel = new MySQLPanel();
		csvPanel = new CSVPanel();
		
		tabPostgres.setContent(postgresPanel);
		tabMysql.setContent(mysqlPanel);
		tabCsv.setContent(csvPanel);
		
		destinationType.setOnAction((event) -> {
		    int selectedIndex = destinationType.getSelectionModel().getSelectedIndex();
		    Object selectedItem = destinationType.getSelectionModel().getSelectedItem();

		    System.out.println("Selection made: [" + selectedIndex + "] " + selectedItem);
		    System.out.println("   ComboBox.getValue(): " + destinationType.getValue());
		    
		    
		    if (selectedIndex == 0)
		    {
		    	destinationTabPane.getTabs().add(tabPostgres);
		    	destinationTabPane.getTabs().remove(tabMysql);
		    	destinationTabPane.getTabs().remove(tabCsv);
		    }
		    
		    if (selectedIndex == 1)
		    {
		    	destinationTabPane.getTabs().remove(tabPostgres);
		    	destinationTabPane.getTabs().add(tabMysql);
		    	destinationTabPane.getTabs().remove(tabCsv);
		    }

		    if (selectedIndex == 2)
		    {
		    	destinationTabPane.getTabs().remove(tabPostgres);
		    	destinationTabPane.getTabs().remove(tabMysql);
		    	destinationTabPane.getTabs().add(tabCsv);
		    }
		    
		});
		
		hboxUp.getChildren().addAll(lblDestination, destinationType);
		
		
		
		
		
		hboxBottom = new HBox(5);
		hboxBottom.setAlignment(Pos.BASELINE_RIGHT);
		
		
		

		getChildren().addAll(hboxUp, destinationTabPane, hboxBottom);

		
	}
}
