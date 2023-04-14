package comp3111.covid;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.apache.commons.csv.CSVRecord;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.StringConverter;

public class TaskA2 {
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
	 * The Start Date of Interest to retrieve data from.
	 */
	private LocalDate startDate;
	/**
	 * The End Date of Interest to retrieve data from.
	 */
	private LocalDate endDate;
	/**
	 * The list of available countries.
	 */
	private ArrayList<String> countries = new ArrayList<String>();
	/**
	 * The countries selected by the user.
	 */
	private ArrayList<String> selectedCountries = new ArrayList<String>();
	/**
	 * The dropdown list to select countries.
	 */
	private ArrayList<CustomMenuItem> menuItems;
	/**
	 * The line chart to be generated for Task A2.
	 */
	private LineChart lineChart;
	/**
	 * The date picker to pick the Start Date of Interest.
	 */
	@FXML
	private DatePicker startDatePicker = new DatePicker();
	/**
	 * The date picker to pick the End Date of Interest.
	 */
	@FXML
	private DatePicker endDatePicker = new DatePicker();
	/**
	 * The "Create Chart" button.
	 */
	@FXML
	private Button generateBtn2;
	/**
	 * The dropdown menu to select countries.
	 */
	@FXML
	private MenuButton menuBtn2;
	/**
	 * Number of months from Start Date to calculate End Date, for extra feature.
	 */
	@FXML
	private TextField monthsTextField;
	/**
	 * Number of days from Start Date to calculate End Date, for extra feature.
	 */
	@FXML
	private TextField daysTextField;
	/**
	 * The "Calculate" button, for extra feature.
	 */
	@FXML
	private Button calculateBtn;
	
	
	/**
	 * This method sets the Start Date of Interest with the date picker.
	 * @param event This is the event triggered by using the date picker.
	 */
	@FXML
	void setStartDate(ActionEvent event) {
    	startDate = startDatePicker.getValue();
    	if((endDate != null) && ((startDate.isAfter(endDate))||(startDate.equals(endDate)))) {
    		Alert invalidPeriodAlert = new Alert(Alert.AlertType.ERROR, "The selected period of interest is invalid. Please select an earlier start date and/or a later end date.");
			invalidPeriodAlert.showAndWait();
			return;
    	}
    	createCountriesMenu();
	}
	
	/**
	 * This method sets the End Date of Interest with the date picker.
	 * @param event This is the event triggered by using the date picker.
	 */
	@FXML
	void setEndDate(ActionEvent event) {
    	endDate = endDatePicker.getValue();
    	if((startDate != null) && ((startDate.isAfter(endDate))||(startDate.equals(endDate)))) {
    		Alert invalidPeriodAlert = new Alert(Alert.AlertType.ERROR, "The selected period of interest is invalid. Please select an earlier start date and/or a later end date.");
			invalidPeriodAlert.showAndWait();
			return;
    	}
	}
	
	/**
	 * This method is triggered by the "Create Chart" button and creates the chart.
	 * @param event This is the event triggered by the "Create Chart" button.
	 */
	@FXML
	void createChart(ActionEvent event) {
		if(startDate == null) {
			Alert missingStartAlert = new Alert(Alert.AlertType.ERROR, "No start date is selected. Please select a start date.");
			missingStartAlert.showAndWait();
			return;
		}
		else if(endDate == null) {
			Alert missingEndAlert = new Alert(Alert.AlertType.ERROR, "No end date is selected. Please select an end date.");
			missingEndAlert.showAndWait();
			return;
		}
		else if(startDate.isAfter(endDate) || startDate.equals(endDate)) {
			Alert invalidPeriodAlert = new Alert(Alert.AlertType.ERROR, "The selected period of interest is invalid. Please select an earlier start date and/or a later end date.");
			invalidPeriodAlert.showAndWait();
			return;
		}
		if(selectedCountries.isEmpty()) {
    		Alert missingCountriesAlert = new Alert(Alert.AlertType.ERROR, "No countries selected. Please select countries to query.");
    		missingCountriesAlert.showAndWait();
    		return;
    	}
		
		NumberAxis xAxis = new NumberAxis();
		xAxis.setLabel("Date");
		xAxis.setAutoRanging(false);
		xAxis.setLowerBound(startDate.toEpochDay());
		xAxis.setUpperBound(endDate.toEpochDay());
		DateTimeFormatter outFormatter = DateTimeFormatter.ofPattern("MMM d, yyyy");
		xAxis.setTickLabelFormatter(new StringConverter<Number>() {
    		@Override
            public String toString(Number object) {
    			var date = LocalDate.ofEpochDay(object.longValue());
                return date.format(outFormatter).toString();
            }
            @Override
            public Number fromString(String string) {
                return 0;
            }
    	});
		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("COVID-19 Cases (per 1M)");
		lineChart = new LineChart(xAxis, yAxis);
		lineChart.setCreateSymbols(false);
		lineChart.setTitle("Cumulative Confirmed COVID-19 Cases (per 1M) from "+startDate.format(outFormatter)+" to "+endDate.format(outFormatter));
		
		for (var country: selectedCountries) {
        	var series = createSeries(country);
        	series.setName(country);
        	if(!series.getData().isEmpty()) { 
        		lineChart.getData().add(series);
        	} else {
        		Alert missingCountryDataAlert = new Alert(Alert.AlertType.WARNING, "No data is available for "+country+" during the chosen period. It will be excluded from the chart.");
        		missingCountryDataAlert.showAndWait();
        	}
        }
		if(lineChart.getData().isEmpty()) {
			Alert missingAllDataAlert = new Alert(Alert.AlertType.ERROR, "No data is available for all the selected countries. Please select another period of interest or other countries to query.");
			missingAllDataAlert.showAndWait();
			return;
		}
        controller.scrollPaneBottom.setFitToWidth(true);
        controller.scrollPaneBottom.setFitToHeight(true);
        controller.scrollPaneBottom.setContent(lineChart);
	}
	
	/**
	 * This method creates the list of countries to be selected from in the dropdown menu.
	 */
	void createCountriesMenu() {
    	menuBtn2.getItems().clear();
    	countries = DataAnalysis.getListOfLocations(controller.textfieldDataset.getText());
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
    	menuBtn2.getItems().addAll(menuItems.toArray(new CustomMenuItem[0]));
    }
	
	/**
	  * This method creates a XYChart.Series with data for the input country for the chart.
	  * @param country The country to retrieve data for in the selected period.
	  * @return A XYChart.Series containing the country and total number of cases per million.
	  */
	public XYChart.Series createSeries(String country) {	
	 	float CasesPerM = 0;
	 	var series = new XYChart.Series<>();
		for (CSVRecord rec : DataAnalysis.getFileParser(controller.textfieldDataset.getText())) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
			LocalDate recDate = LocalDate.parse(rec.get("date"), formatter);
			if ((!recDate.isBefore(startDate)) && (!recDate.isAfter(endDate)) && (rec.get("location").equals(country))) {
					String per = rec.get("total_cases_per_million");
					if (!per.equals("")) {
						CasesPerM = Float.parseFloat(per);
						series.getData().add(new XYChart.Data(recDate.toEpochDay(), CasesPerM));
					}
			}
			
		}
		return series;
	}
	
	/**
	 * This method calculates the End Date of Interest from the Start Date of Interest from input from the Months and Days text fields.
	 * @param event This is the event triggered by pressing the "Calculate" button.
	 */
	@FXML
	void calculateEndDate(ActionEvent event) {
		if(startDate == null) {
			Alert missingStartAlert = new Alert(Alert.AlertType.ERROR, "No start date is selected. Please select a start date.");
			missingStartAlert.showAndWait();
			return;
		}
		long months = Long.parseLong(monthsTextField.getText());
		long days = Long.parseLong(daysTextField.getText());
		endDate = startDate.plusMonths(months).plusDays(days);
		endDatePicker.setValue(endDate);
		if(startDate.equals(endDate) || endDate.isBefore(startDate)) {
			Alert invalidPeriodAlert = new Alert(Alert.AlertType.ERROR, "The selected period of interest is invalid. Please select an earlier start date and/or a later end date.");
			invalidPeriodAlert.showAndWait();
			return;
		}
	}
}