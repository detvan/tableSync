package com.app;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MySQLPanel extends VBox {
	
	private Label lblHost;
	private TextField txtHost;
	
	private Label lblPort;
	private TextField txtPort;
	
	private Label lblDatabase;
	private TextField txtDatabase;
	
	private Label lblTable;
	private TextField txtTable;
	
	private Label lblUsername;
	private TextField txtUsername;
	
	private Label lblPassword;
	private PasswordField txtPassword;
	
	private HBox hboxButtons;
	private Button btnTest;
	private Button btnSave;
	
	
	public MySQLPanel() {
		
		lblHost = new Label("Host:");
		txtHost  = new TextField();
		txtHost.setPromptText("Enter hostname or IP address.");
		
		lblPort = new Label("Port:");
		txtPort  = new TextField("3306") {
		    @Override public void replaceText(int start, int end, String text) {
		        // If the replaced text would end up being invalid, then simply
		        // ignore this call!
		        if (!text.matches("\\D")) {
		            super.replaceText(start, end, text);
		        }
		    }
		 
		    @Override public void replaceSelection(String text) {
		        if (!text.matches("[0-9]")) {
		            super.replaceSelection(text);
		        }
		    }
		};
							
		txtPort.setPromptText("Enter port number.");
		
		lblDatabase = new Label("Database:");
		txtDatabase  = new TextField();
		txtDatabase.setPromptText("Enter database name.");
		
		lblTable = new Label("Table:");
		txtTable  = new TextField();
		txtTable.setPromptText("Enter schema.table name.");
		
		lblUsername = new Label("Username:");
		txtUsername  = new TextField();
		txtUsername.setPromptText("Enter user name.");
		
		lblPassword = new Label("Password:");
		txtPassword  = new PasswordField();
		txtPassword.setPromptText("Enter password.");
		
		btnTest = new Button("Test connection");
		btnSave = new Button("Apply changes");
		
		hboxButtons = new HBox(5);
		hboxButtons.setAlignment(Pos.BASELINE_RIGHT);
		hboxButtons.getChildren().addAll(btnTest, btnSave);
		
		//toolBar = new ToolBar(lblPostgres, txtHost, btnOpen, btnSave, btnExit);
		getChildren().addAll(	lblHost,
								txtHost,
								lblPort,
								txtPort,
								lblDatabase,
								txtDatabase,
								lblTable,
								txtTable,
								lblUsername,
								txtUsername,
								lblPassword,
								txtPassword,
								hboxButtons);
	}

}
