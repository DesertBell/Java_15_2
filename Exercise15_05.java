//Michele Bell
//April 28, 2017
//This program calculates he future value of an investment at a given interest rate for a certain number of years. 

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label; 
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise15_05 extends Application
{
		//Declare text fields
		private TextField tfInvestmentAmount = new TextField();
		private TextField tfNumberOfYears = new TextField();
		private TextField tfAnnualInterestRate = new TextField();
		private TextField tfFutureValue = new TextField();
		private Button btCalculate = new Button("Calculate");
		
	@Override	
	public void start(Stage primaryStage) throws Exception 
	{
		//Create user interface
		GridPane gPane = new GridPane();
		gPane.setHgap(5);
		gPane.setVgap(5);
		gPane.add(new Label("Investment Amount"), 0, 0);
		gPane.add(tfInvestmentAmount, 1, 0);
		gPane.add(new Label ("Number of Years"), 0, 1);
		gPane.add(tfNumberOfYears, 1, 1);
		gPane.add(new Label("Annual Interest Rate"), 0, 2);
		gPane.add(tfAnnualInterestRate, 1, 2);
		gPane.add(new Label("Future Value"), 0, 3);
		gPane.add(tfFutureValue, 1, 3);
		gPane.add(btCalculate, 1, 4);
		
		//Set properties for user interface
		gPane.setAlignment(Pos.CENTER);
		tfInvestmentAmount.setAlignment(Pos.BOTTOM_RIGHT);
		tfNumberOfYears.setAlignment(Pos.BOTTOM_RIGHT);
		tfAnnualInterestRate.setAlignment(Pos.BOTTOM_RIGHT);
		tfFutureValue.setAlignment(Pos.BOTTOM_RIGHT);
		GridPane.setHalignment(btCalculate, HPos.RIGHT);
		
		//Set action to button
		btCalculate.setOnAction(e -> calculateFutureValue());
		
		//Create a scene and place it in the stage
		Scene scene = new Scene(gPane, 400, 250);
		primaryStage.setTitle("Exercise15_05");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private void calculateFutureValue()
	{
		//Get values from text fields
		double invstAmount = Double.parseDouble(tfInvestmentAmount.getText());
		double numYears = Double.parseDouble(tfNumberOfYears.getText());
		double monthlyRate = Double.parseDouble(tfAnnualInterestRate.getText()) / 12 / 100;
		
		//Calculate Future Value
		double futureValue = invstAmount * Math.pow(1 + monthlyRate, numYears * 12); 
				tfFutureValue.setText(String.format("$%.2f", futureValue));;

	}
	
	public static void main(String[] args)
	{
		Application.launch(args);
	}

}
