package com.app;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class SyncForm extends VBox {

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

	public SyncForm() {
		//grid = new GridPane();

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
		rootItem = new TreeItem<String>("Tutorials");
		webItem = new TreeItem<String>("Web Tutorials");
		javaItem = new TreeItem<String>("Java Tutorials");
		

		
		

		

        //TreeItem rootItem = new TreeItem("Tutorials");

        //TreeItem webItem = new TreeItem("Web Tutorials");
        webItem.getChildren().add(new TreeItem<String>("HTML  Tutorial"));
        webItem.getChildren().add(new TreeItem<String>("HTML5 Tutorial"));
        webItem.getChildren().add(new TreeItem<String>("CSS Tutorial"));
        webItem.getChildren().add(new TreeItem<String>("SVG Tutorial"));
        //rootItem.getChildren().add(webItem);

        //TreeItem javaItem = new TreeItem("Java Tutorials");
        javaItem.getChildren().add(new TreeItem<String>("Java Language"));
        javaItem.getChildren().add(new TreeItem<String>("Java Collections"));
        javaItem.getChildren().add(new TreeItem<String>("Java Concurrency"));
        //rootItem.getChildren().add(javaItem);
        
        rootItem.getChildren().addAll(webItem, javaItem);

        //TreeView profilesTree = new TreeView();
        profilesTree.setRoot(rootItem);

        profilesTree.setShowRoot(false);
		
		
		
		
		
		
		
        

     
        

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
        getChildren().add(profilesTree);
		//setPadding(new Insets(0));
		//VBox.setVgrow(grid, Priority.ALWAYS);
       //treeContainer.setVgrow(profilesTree, Priority.ALWAYS);
       //treeContainer.autosize();
        //setPadding(new Insets(10));
		VBox.setVgrow(profilesTree, Priority.ALWAYS);
	}
}
