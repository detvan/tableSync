package com.app;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainView {

	private Stage stage;
	private BorderPane root;
	private Scene scene;
	
	private FXMenu fxMenu;
	private FXToolBar fxToolBar;
	private FXStatusBar fxStatusBar;
	
	private MainSplit fxSplit;

	public MainView(Stage stage) {
		this.stage = stage;
		buildUI();
	}

	private void buildUI() {

		root = new BorderPane();
		root.addEventFilter(PersonEvent.ANY, this::handlePersonEvent);

		fxMenu = new FXMenu();
		fxToolBar = new FXToolBar();

		VBox top = new VBox(fxMenu, fxToolBar);
		root.setTop(top);
		
		fxSplit = new MainSplit();
		root.setCenter(fxSplit);
		
		fxStatusBar = new FXStatusBar();
		root.setBottom(fxStatusBar);
		
		scene = new Scene(root, 1024, 768);
		scene.getStylesheets().add("/com/app/stylesheet.css");
		stage.setTitle("tableSync 2023.06");
		stage.setScene(scene);
		stage.show();
	}
	
	public void handlePersonEvent(PersonEvent event) {
		System.out.println(event.getPerson().getFirstName()+ " " + event.getPerson().getLastName());
	}
}
