package comp3111.covid;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.apache.commons.csv.CSVRecord;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TaskA1 {
	/**
	 * The controller to use for this Task.
	 */
	private static Controller controller;
	/**
	 * This method sets the controller of TaskA1 to the central controller.
	 * @param c
	 */
	public void setController(Controller c) {
		controller = c;
	}
	
	/**
	 * The Date of Interest to retrieve data from.
	 */
	private LocalDate dateOfInterest;
	/**
	 * The available countries with records on the selected date.
	 */
	private ArrayList<String> countries = new ArrayList<String>();
	/**
	 * The countries selected by the user.
	 */
	private ArrayList<String> selectedCountries = new ArrayList<String>();
	/**
	 * The table to be generated for Task A1.
	 */
	private TableView<RecordA> table;
	/**
	 * The dropdown list to select countries.
	 */
	private ArrayList<CustomMenuItem> menuItems;
	/**
	 * The bar chart to be generated for the extra feature.
	 */
	private StackedBarChart barChart;
	/**
	 * The date picker to pick the Date of Interest.
	 */
	@FXML
	private DatePicker datePicker = new DatePicker();	
	/**
	 * The "Create Table" button.
	 */
	@FXML
	private Button generateBtn;
	/**
	 * The dropdown menu to select countries.
	 */
	@FXML
	private MenuButton menuBtn;
	/**
	 * The "Create Bar Chart" button.
	 */
	@FXML
	private Button generateBtnBar;
	
	/**
	 * This method sets the Date of Interest with the date picker.
	 * @param event This is the event triggered by using the date picker.
	 */
	@FXML
	void setDate(ActionEvent event) {
    	dateOfInterest = datePicker.getValue();
    	createCountriesMenu();
    	if(countries.isEmpty()) {
    		Alert missingCountryDataAlert = new Alert(Alert.AlertType.WARNING, "No country data is available for the chosen date. Please pick another date.");
    		missingCountryDataAlert.showAndWait();
    	}
	}
	
	/**
	 * This method is triggered by the "Create Table" button and creates the table.
	 * @param event This is the event triggered by the "Create Table" button.
	 */
	@FXML
	void createTable(ActionEvent event) {
		table = new TableView<RecordA>();
		table.getItems().clear();
		TableColumn<RecordA, String> countryCol = new TableColumn<>("Country");
		countryCol.setCellValueFactory(new PropertyValueFactory<>("country"));
    	TableColumn<RecordA, String> casesTCol = new TableColumn<>("Total Cases");
    	casesTCol.setCellValueFactory(new PropertyValueFactory<>("casesTotal"));
    	TableColumn<RecordA, String> casesPCol = new TableColumn<>("Total Cases (per 1M)");
    	casesPCol.setCellValueFactory(new PropertyValueFactory<>("casesPerM"));
    	TableColumn title = new TableColumn<>();
    	title.getColumns().addAll(countryCol, casesTCol, casesPCol);
    	table.getColumns().add(title);
    	table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    	if(dateOfInterest == null) {
    		Alert missingDateAlert = new Alert(Alert.AlertType.ERROR, "No date selected. Please pick a date.");
    		missingDateAlert.showAndWait();
    		return;
    	}
    	if(selectedCountries.isEmpty()) {
    		Alert missingCountriesAlert = new Alert(Alert.AlertType.ERROR, "No countries selected. Please select countries to query.");
    		missingCountriesAlert.showAndWait();
    		return;
    	}
    	
        for (var country: selectedCountries) {
        	RecordA a = createRecordA(country);
        	if(a.getCasesTotal() != -1) {
        		table.getItems().add(a);
        	}
        }
        if(table.getItems().isEmpty()) {
        	Alert missingAllDataTAlert = new Alert(Alert.AlertType.ERROR, "No data is available for all the selected countries. Please select other countries to query.");
			missingAllDataTAlert.showAndWait();
			return;
        }
        DateTimeFormatter outFormatter = DateTimeFormatter.ofPattern("MMM d, yyyy");
        table.getColumns().get(0).setText("Number of Confirmed COVID-19 Cases as of "+dateOfInterest.format(outFormatter));
        controller.scrollPaneBottom.setFitToWidth(true);
        controller.scrollPaneBottom.setContent(table);
	}
	
	/**
	 * This method is triggered by the "Create Bar Chart" button and creates the bar chart for the extra feature.
	 * @param event This is the event triggered by the "Create Bar Chart" button.
	 */
	@FXML
	void createBarChartT(ActionEvent event) {
		if(dateOfInterest == null) {
    		Alert missingDateAlert = new Alert(Alert.AlertType.ERROR, "No date selected. Please pick a date.");
    		missingDateAlert.showAndWait();
    		return;
    	}
    	if(selectedCountries.isEmpty()) {
    		Alert missingCountriesAlert = new Alert(Alert.AlertType.ERROR, "No countries selected. Please select countries to query.");
    		missingCountriesAlert.showAndWait();
    		return;
    	}
		CategoryAxis xAxis = new CategoryAxis(); 
		xAxis.setLabel("Countries");
		NumberAxis yAxis = new NumberAxis(); 
		yAxis.setLabel("Number of Total Cases");
		barChart = new StackedBarChart(xAxis, yAxis);
		barChart.setLegendVisible(false);
		for (var country: selectedCountries) {
        	var series = createSeriesT(country);
        	series.setName(country);
        	if(!series.getData().isEmpty()) { 
        		barChart.getData().add(series);
        	} 
        }
		if(barChart.getData().isEmpty()) {
			Alert missingAllDataAlert = new Alert(Alert.AlertType.ERROR, "No data is available for all the selected countries. Please select other countries to query.");
			missingAllDataAlert.showAndWait();
			return;
		}
		DateTimeFormatter outFormatter = DateTimeFormatter.ofPattern("MMM d, yyyy");
        barChart.setTitle("Number of Confirmed COVID-19 Cases as of "+dateOfInterest.format(outFormatter));
		controller.scrollPaneBottom.setFitToHeight(true);
		controller.scrollPaneBottom.setFitToWidth(true);
        controller.scrollPaneBottom.setContent(barChart);
	}
	
	
	/**
	 * This method creates the list of countries to be selected from in the dropdown menu.
	 */
	 private void createCountriesMenu() {
    	menuBtn.getItems().clear();
    	countries = DataAnalysis.getListOfLocationsGivenDate(controller.textfieldDataset.getText(), dateOfInterest);
    	menuItems = new ArrayList<CustomMenuItem>();
    	for (var country: countries) {
    		var checkBox = new CheckBox(country);
    		var menuItem = new CustomMenuItem(checkBox);
    		menuItem.setHideOnClick(false);
    		menuItem.setOnAction(new EventHandler<ActionEvent>() {
    		    public void handle(ActionEvent t) {
    		    	if (checkBox.isSelected()) {
    		    		checkBox.setSelected(false);
    		    		selectedCountries.remove(country);
    		    		selectedCountries.remove(country);
    		    	}
    		    	else {
    		    		checkBox.setSelected(true);
    		    		selectedCountries.add(country);
    		    	}
    		    }
    		});
    		menuItems.add(menuItem);
    	}
    	menuBtn.getItems().addAll(menuItems.toArray(new CustomMenuItem[0]));
    }
	 
	 /**
	  * This method creates a {@link comp3111.covid.RecordA} with data for the input country, for the table.
	  * @param country The country to retrieve data for on the selected date.
	  * @return a {@link comp3111.covid.RecordA} containing the country, total number of cases, and number of cases per million.
	  */
	 public RecordA createRecordA(String country) {	
		 	long casesTotal = -1;
		 	float casesPerM = -1;
		 	
			for (CSVRecord rec : DataAnalysis.getFileParser(controller.textfieldDataset.getText())) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
				LocalDate recDate = LocalDate.parse(rec.get("date"), formatter);
				if ((recDate.equals(dateOfInterest)) && (rec.get("location").equals(country))) {
						String total = rec.get("total_cases");
						String per = rec.get("total_cases_per_million");
						if (!total.equals("") && !per.equals("")) {
							casesTotal = Long.parseLong(total);
							casesPerM = Float.parseFloat(per);
						} else {
							Alert missingCasesAlert = new Alert(Alert.AlertType.WARNING, "No data is available for the number of total cases for "+country+" on the selected date. It will be excluded from the table.");
							missingCasesAlert.showAndWait();
						} 
						
						
				}
				
			}
			return new RecordA(country, casesTotal, casesPerM);
	 }
	 
	 /**
	  * This method creates a XYChart.Series with data for the input country, for the bar chart.
	  * @param country The country to retrieve data for on the selected date.
	  * @return A XYChart.Series containing the country and total number of cases.
	  */
	 public XYChart.Series createSeriesT(String country) {
		 long casesTotal = -1;
//		 float casesPerM = -1;
		 var series = new XYChart.Series<>();
		 for (CSVRecord rec : DataAnalysis.getFileParser(controller.textfieldDataset.getText())) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
				LocalDate recDate = LocalDate.parse(rec.get("date"), formatter);
				if ((recDate.equals(dateOfInterest)) && (rec.get("location").equals(country))) {
						String total = rec.get("total_cases");
//						String per = rec.get("total_cases_per_million");
						if (!total.equals("")) {
							casesTotal = Long.parseLong(total);
							series.getData().add(new XYChart.Data(country,casesTotal));
//							casesPerM = Float.parseFloat(per);
//							series.getData().add(new XYChart.Data("Total Cases (Per 1M)", casesPerM));
						} else {
							Alert missingCasesAlert = new Alert(Alert.AlertType.WARNING, "No data is available for the number of total cases for "+country+" on the selected date. It will be excluded from the chart.");
							missingCasesAlert.showAndWait();
						} 
				}
		 }
		 return series;
	 }
	 
	 
	 
	
	
}
