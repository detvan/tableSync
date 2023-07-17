package com.app;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MainSplit extends HBox {


	private SplitPane splitPane1;
	
	private SplitPane synchroSplitPanel;
	
	private ProfilesTree profilesTree;
	
	//private SyncForm syncForm;
	private SyncFormSrc syncFormSrc;
	private SyncFormDst syncFormDst;
	//private SyncFormDst fxSyncFormDst;
	
	private final double absolutePosition = 0.5;


	public MainSplit() {
		
		splitPane1 = new SplitPane(); 
		profilesTree = new ProfilesTree();
		syncFormSrc = new SyncFormSrc();
		syncFormDst = new SyncFormDst();
		//fxSyncFormDst = new SyncFormDst();
		
		synchroSplitPanel = new SplitPane();
		synchroSplitPanel.getItems().addAll(syncFormSrc, syncFormDst);
		synchroSplitPanel.getDividers().get(0).positionProperty().addListener((observable,oldValue,newValue) -> {
			synchroSplitPanel.setDividerPosition(0, absolutePosition);
		});
		
		splitPane1.setDividerPositions(0.33f, 0.33f);
		splitPane1.getItems().addAll(profilesTree, synchroSplitPanel);
		
		getChildren().add(splitPane1);
		
		setHgrow(splitPane1, Priority.ALWAYS);

	}
}
