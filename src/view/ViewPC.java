package view;

import java.util.ArrayList;

import controller.PcController;
import database.ConnectDB;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.PC;

public class ViewPC{
	Stage stage;
	Scene scene;
	FlowPane fpane;
	BorderPane bpane;
	
	Label TitlePage, lb_pcdesc, lb_pcid;
	VBox vbox;
	HBox h_box;
	TextField PCid_field, pcDesc_field;
	GridPane gp;
	Button delbtn, updbtn, addbtn;
	ConnectDB connect;
	
	public static ArrayList<PC> listPcs = new ArrayList<PC>();
	
	@SuppressWarnings("unchecked")
	public void inititialize() {
		// TODO Auto-generated method stub
		gp = new GridPane();
		bpane = new BorderPane();
		vbox = new VBox();
		h_box = new HBox();
		
		ObservableList<PC> pcList;
		
		TableView<PC> TablePC = new TableView<>();
		
		TitlePage = new Label("View PC Detail");
		
		lb_pcid = new Label("ID PC: ");
		PCid_field = new TextField();
		
		lb_pcdesc= new Label("Condition PC: ");
		pcDesc_field = new TextField();
		
		addbtn = new Button("Add PC");
		delbtn = new Button("Delete PC");
		updbtn = new Button("Update PC");
		
		//for table view 
		TableColumn<PC, String> PCidCol = new TableColumn<>("ID PC");
			
		PCidCol.setMinWidth(bpane.getWidth() / 2);
			
		TableColumn<PC, String> PCcondiCol = new TableColumn<>("PC Condition");
		
		PCidCol.setCellValueFactory(new PropertyValueFactory<>("pcID"));
		PCcondiCol.setCellValueFactory(new PropertyValueFactory<>("pcCond"));
		
		pcList = PC.displayAllPC();
		TablePC.setItems(pcList);
		
		PCidCol.setMinWidth(bpane.getWidth() / 2);
		TablePC.getColumns().addAll(PCidCol, PCcondiCol);
		
		//positioning title
		gp.add(vbox, 0, 0);
		vbox.getChildren().add(TitlePage);
		vbox.setAlignment(Pos.BASELINE_LEFT);
		
		//positioning PC ID
		gp.add(lb_pcid, 0, 1);
		gp.add(PCid_field, 1, 1);
		//positioning PC Description
		gp.add(lb_pcdesc, 0, 2);
		gp.add(pcDesc_field, 1, 2);
		
		//button
		gp.add(addbtn, 0, 3);
		gp.add(updbtn, 1, 3);
		gp.add(delbtn, 2, 3);
		//gp.add(child, columnIndex, rowIndex);
		
		bpane.setBottom(TablePC);
		bpane.setCenter(gp);
		gp.setAlignment(Pos.BASELINE_LEFT);
		gp.setVgap(10);
		scene = new Scene(bpane, 900, 500);
	}
	
	//styling view
	private void setStyle() {
		TitlePage.setStyle("-fx-font-weight: bold;" + "-fx-font-family: Serif;" + "-fx-font-size: 20px;");
		delbtn.setStyle("-fx-background-color: red;" + "-fx-text-fill: white;" + "-fx-width: 350px;" + "-fx-font-weight: bold;");
		updbtn.setStyle("-fx-border-color: blue;" + "-fx-text-fill: blue;" + "-fx-width: 350px;" + "-fx-font-weight: bold;");
		PCid_field.setMaxWidth(250);
		addbtn.setStyle("-fx-background-color: blue;" + "-fx-text-fill: white;" + "-fx-width: 350px;" + "-fx-font-weight: bold;");
		gp.setPadding(new Insets(15));
	}
	
	public void setAction() {
		Alert a = new Alert(AlertType.NONE);
		//logic add button
		addbtn.setOnMouseClicked(e->{
			String message = PcController.AddNewPC(pcDesc_field.getText());
			if(message.equals("Success")){
				a.setAlertType(AlertType.INFORMATION);
				a.setContentText("Successfully added PC");
				a.show();
				new ViewPC(stage);
			}
			else {
				a.setAlertType(AlertType.ERROR);
				a.setContentText(message);
				a.show();
			}
		});	
		
		//logic del button
		delbtn.setOnMouseClicked(e->{
			String message = PcController.removePC(Integer.parseInt(PCid_field.getText()));
			if(message.equals("Success")){
				a.setAlertType(AlertType.INFORMATION);
				a.setContentText("Successfully deleted PC");
				a.show();
				new ViewPC(stage);
			}
			else {
				a.setAlertType(AlertType.ERROR);
				a.setContentText(message);
				a.show();
			}
		});
		
		//logic update button
		updbtn.setOnMouseClicked(e->{
			String message = PcController.updatePC(Integer.parseInt(PCid_field.getText()), pcDesc_field.getText());
			if(message.equals("Success")){
				a.setAlertType(AlertType.INFORMATION);
				a.setContentText("Successfully updated PC");
				a.show();
				new ViewPC(stage);
			}
			else {
				a.setAlertType(AlertType.ERROR);
				a.setContentText(message);
				a.show();
			}
		});		
	}
	
	public ViewPC(Stage stage) {
		inititialize();
		setStyle();
		setAction();
		this.stage = stage;
		this.stage.setResizable(false);
		this.stage.setScene(scene);
		this.stage.show();
	}
}
