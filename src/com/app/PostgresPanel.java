package com.app;


import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import com.app.DbRowProperty;

public class PostgresPanel extends VBox {
	
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
	
	private TableView<DbRowProperty> dbTableView;
	
	public PostgresPanel() {
	
		lblHost = new Label("Host:");
		txtHost  = new TextField();
		txtHost.setPromptText("Enter hostname or IP address.");
		
		lblPort = new Label("Port:");
		txtPort  = new TextField("5432") {
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
		
//		dbTableView = new TableView();
//		TableColumn<Person, String> column1 = new TableColumn<>("First Name");
//		column1.setCellValueFactory(new PropertyValueFactory<>("firstName"));
//		
//		TableColumn<Person, String> column2 = new TableColumn<>("Last Name");
//		column2.setCellValueFactory(new PropertyValueFactory<>("lastName"));
//		
//		TableColumn<Person, String> column3 = new TableColumn<>("Middle Name");
//		column2.setCellValueFactory(new PropertyValueFactory<>("middleName"));
		
		
		dbTableView = new TableView<DbRowProperty>();
		TableColumn<DbRowProperty, Boolean> column1 = new TableColumn<>("Selected");
		column1.setCellValueFactory(new PropertyValueFactory<>("isRowSelected"));
		
		TableColumn<DbRowProperty, String> column2 = new TableColumn<>("Column Name");
		column2.setCellValueFactory(new PropertyValueFactory<>("columnName"));
		
		TableColumn<DbRowProperty, String> column3 = new TableColumn<>("Column Type");
		column3.setCellValueFactory(new PropertyValueFactory<>("columnType"));
		
		dbTableView.getColumns().add(column1);
		dbTableView.getColumns().add(column2);
		dbTableView.getColumns().add(column3);
		
		
		
		dbTableView.getItems().add(new DbRowProperty(false, "cnJohn", "ctDoe"));
		dbTableView.getItems().add(new DbRowProperty(true, "cnJane", "ctDeer"));
		dbTableView.getItems().add(new DbRowProperty(true, "cnJane", "ctDeer"));
		dbTableView.getItems().add(new DbRowProperty(true, "cnJane", "ctDeer"));
		dbTableView.getItems().add(new DbRowProperty(true, "cnJane", "ctDeer"));
		dbTableView.getItems().add(new DbRowProperty(true, "cnJane", "ctDeer"));
		
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
								hboxButtons,
								dbTableView);
	}
	

}
