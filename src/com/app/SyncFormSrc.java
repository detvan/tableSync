package com.app;

import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SyncFormSrc extends VBox {

	private HBox hboxUp;
	private HBox hboxBottom;
	private Image sourceIcon;
	private Label lblSource;
	
	private ComboBox<String> sourceType;
	
	private TabPane sourceTabPane; 
	
	private PostgresPanel postgresPanel;
	private MySQLPanel mysqlPanel;
	private CSVPanel csvPanel;
	
	public SyncFormSrc() {
		hboxUp = new HBox();
		hboxUp.setAlignment(Pos.BASELINE_LEFT);
		
		sourceIcon = new Image("/com/app/images/source.png"); 
	    ImageView sourceView = new ImageView(sourceIcon);
	    sourceView.setFitHeight(40);
	    sourceView.setPreserveRatio(true);
	    
		lblSource = new Label("Source: ");
		lblSource.setGraphic(sourceView);
		
		sourceType = new ComboBox<String>();
		sourceType.getItems().add("PostgreSQL");
		sourceType.getItems().add("MySQL");
		sourceType.getItems().add("CSV");
		//sourceType.getSelectionModel().selectFirst();
		
		
		sourceTabPane = new TabPane();
		sourceTabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		
        Tab tabPostgres = new Tab("PostgreSQL");
        Tab tabMysql = new Tab("MySQL");
        Tab tabCsv = new Tab("CSV");

		postgresPanel = new PostgresPanel();
		mysqlPanel = new MySQLPanel();
		csvPanel = new CSVPanel();
		

		tabPostgres.setContent(postgresPanel);
		tabMysql.setContent(mysqlPanel);
		tabCsv.setContent(csvPanel);
		
		sourceType.setOnAction((event) -> {
		    int selectedIndex = sourceType.getSelectionModel().getSelectedIndex();
		    Object selectedItem = sourceType.getSelectionModel().getSelectedItem();

		    System.out.println("Selection made: [" + selectedIndex + "] " + selectedItem);
		    System.out.println("   ComboBox.getValue(): " + sourceType.getValue());
		    
		    if (selectedIndex == 0)
		    {
		    	sourceTabPane.getTabs().add(tabPostgres);
		    	sourceTabPane.getTabs().remove(tabMysql);
		    	sourceTabPane.getTabs().remove(tabCsv);
		    }
		    
		    if (selectedIndex == 1)
		    {
		    	sourceTabPane.getTabs().remove(tabPostgres);
		    	sourceTabPane.getTabs().add(tabMysql);
		    	sourceTabPane.getTabs().remove(tabCsv);
		    }

		    if (selectedIndex == 2)
		    {
		    	sourceTabPane.getTabs().remove(tabPostgres);
		    	sourceTabPane.getTabs().remove(tabMysql);
		    	sourceTabPane.getTabs().add(tabCsv);
		    }

		    	
		});
		
		hboxUp.getChildren().addAll(lblSource, sourceType);
		
		
		hboxBottom = new HBox(5);
		hboxBottom.setAlignment(Pos.BASELINE_RIGHT);
		
        getChildren().addAll(hboxUp, sourceTabPane, hboxBottom);

	}
}
