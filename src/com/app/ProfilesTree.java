package com.app;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class ProfilesTree extends VBox {

	//private GridPane grid;
	//private VBox treeContainer;
	//private Button btnSave;
	//private Label lblFirstName;
	//private Label lblLastName;
	//private TextField txtFirstName;
	//private TextField txtLastName;
	//private ButtonBar btnBar;
	private TreeView<String> profilesTree;
	private TreeItem<String> rootItem;
	private TreeItem<String> webItem;
	private TreeItem<String> javaItem;
	
	//private ScrollBar horizontalScrollBar;
	//private ScrollBar verticalScrollBar;
	
	private ScrollPane scrollPane;
	
	private ContextMenu contextMenu;
	private MenuItem contextMenuItem1;
	private MenuItem contextMenuItem2;
	private MenuItem contextMenuItem3;
	private MenuItem contextMenuItem4;
	private SeparatorMenuItem separatorMenuItem;
	

	public ProfilesTree() {
		//grid = new GridPane();
		contextMenu = new ContextMenu();
		contextMenuItem1 = new MenuItem("Add Profile Group");
	    contextMenuItem2 = new MenuItem("Add Profile");
	    separatorMenuItem = new SeparatorMenuItem();
	    contextMenuItem3 = new MenuItem("Delete Profile Group");
	    contextMenuItem4 = new MenuItem("Delete Profile");
	    
	    contextMenuItem3.setOnAction((event) -> {
            System.out.println("Choice 3 clicked!");
        });
	    
	    contextMenu.getItems().addAll(contextMenuItem1, contextMenuItem2, separatorMenuItem, contextMenuItem3, contextMenuItem4);

		//lblFirstName = new Label("First Name");
		//lblLastName = new Label("Last Name");
		//txtFirstName = new TextField();
		//txtLastName = new TextField();
		//btnSave = new Button("Save");
		//btnSave.setOnAction(new EventHandler<ActionEvent>() {
		//	@Override
		//	public void handle(ActionEvent event) {
		//		Person person = new Person(txtFirstName.getText(), txtLastName.getText());
		//		btnSave.fireEvent(new PersonEvent(PersonEvent.PERSON_SAVE, person));
		//	}
		//});
		
		//treeContainer = new VBox();
		//treeContainer.setPadding(new Insets(0));
		//treeContainer.setSpacing(0);
		
		profilesTree = new TreeView<String>();
		rootItem = new TreeItem<String>("Profiles");
		webItem = new TreeItem<String>("Profiles group 01");
		javaItem = new TreeItem<String>("Profiles group 02");
		
		//horizontalScrollBar = new ScrollBar();
		//verticalScrollBar = new ScrollBar();
		//verticalScrollBar.setOrientation(Orientation.VERTICAL);
		
		scrollPane = new ScrollPane();
		

		
		

		

        //TreeItem rootItem = new TreeItem("Tutorials");

        //TreeItem webItem = new TreeItem("Web Tutorials");
        webItem.getChildren().add(new TreeItem<String>("Profile 01-01"));
        webItem.getChildren().add(new TreeItem<String>("Profile 01-02"));
        webItem.getChildren().add(new TreeItem<String>("Profile 01-03"));
        webItem.getChildren().add(new TreeItem<String>("Profile 01-04"));
        //rootItem.getChildren().add(webItem);

        //TreeItem javaItem = new TreeItem("Java Tutorials");
        javaItem.getChildren().add(new TreeItem<String>("Profile 02-01"));
        javaItem.getChildren().add(new TreeItem<String>("Profile 02-02"));
        javaItem.getChildren().add(new TreeItem<String>("Profile 02-03"));
        //rootItem.getChildren().add(javaItem);
        
        rootItem.getChildren().addAll(webItem, javaItem);

        //TreeView profilesTree = new TreeView();
        profilesTree.setRoot(rootItem);

        profilesTree.setShowRoot(true);
        
        
        
        
        

        profilesTree.setContextMenu(contextMenu);
        
        
        scrollPane.setContent(profilesTree);
        scrollPane.pannableProperty().set(true);
        scrollPane.fitToWidthProperty().set(true);
        scrollPane.fitToHeightProperty().set(true);
        //scrollPane.hbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.NEVER);
        //scrollPane.vbarPolicyProperty().setValue(ScrollPane.ScrollBarPolicy.NEVER);
       
        

		
		
		
		
		
		
		
        

     
        

		//btnBar = new ButtonBar();
		//btnBar.getButtons().addAll(btnSave);

		//grid.add(lblFirstName, 0, 0, 1, 1);
		//grid.add(txtFirstName, 1, 0, 1, 1);
		//grid.add(lblLastName,  0, 1, 1, 1);
		//grid.add(txtLastName,  1, 1, 1, 1);
		//grid.add(btnBar,       0, 2, 2, 1);
		//grid.add(profilesTree, 1, 5, 2, 1);

		//grid.setHgap(10);
		//grid.setVgap(5);

		//getChildren().add(grid);
        
        //vboxTree.setVgrow(profilesTree, Priority.ALWAYS);
        //treeContainer.getChildren().add(profilesTree);
        getChildren().add(scrollPane);
		//setPadding(new Insets(0));
		//VBox.setVgrow(grid, Priority.ALWAYS);
       //treeContainer.setVgrow(profilesTree, Priority.ALWAYS);
       //treeContainer.autosize();
        //setPadding(new Insets(10));
		VBox.setVgrow(scrollPane, Priority.ALWAYS);
	}
}
