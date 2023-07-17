package com.app;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class CSVPanel extends VBox {
	
	//private ToolBar toolBar;
	private Label lblCSV;
	
	private Label csvFile;
	
	private Button btnOpen;
	private Button btnSave;
	private Button btnExit;
	private ContentDisplay CONTENT_DISPLAY = ContentDisplay.GRAPHIC_ONLY;
	

	
	
	
	public CSVPanel() {
		buildMySQLUI();
	}
	
	
	private void buildMySQLUI() {
		
		lblCSV = new Label("Choose CSV File:");
		csvFile = new Label("File: ");
		
		btnOpen = createButton("Open", "open.png");
		btnOpen.setContentDisplay(CONTENT_DISPLAY);
		btnSave = createButton("Save", "save.png");
		btnSave.setContentDisplay(CONTENT_DISPLAY);
		btnExit = createButton("Exit", "exit.png");
		btnExit.setContentDisplay(CONTENT_DISPLAY);

		//toolBar = new ToolBar(lblCSV, btnOpen, btnSave, btnExit);
		//getChildren().add(this.toolBar);
		getChildren().addAll(lblCSV, csvFile, btnOpen, btnSave, btnExit);
		//HBox.setHgrow(this.toolBar, Priority.ALWAYS);
		
		setSpacing(10);
	    setPadding(new Insets(5));
	    setAlignment(Pos.CENTER_LEFT);
	}
	
	
	public Button createButton(String text, String file) {
		String path = "/com/app/images/";
		Image imge = new Image(path + file);
		ImageView iview = new ImageView(imge);
		iview.setFitHeight(32);
		iview.setFitWidth(32);
		Button button = new Button(text, iview);
		return button;
	}

}
