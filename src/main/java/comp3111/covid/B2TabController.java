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
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.util.StringConverter;
/**
 * 
 * @author choiivan
 *
 */
public class B2TabController {
	/**
	 * The main controller that is responsible for the dataset and the bottomScrollPane.
	 */
    private Controller controller;
	
    /**
     * The user desired start date of interest.
     */
    private LocalDate startDateOfInterest;
    
    /**
     * The user desired end date of interest.
     */
    private LocalDate endDateOfInterest;
    
    /**
     * A list of countries that can be selected by the user.
     */
    private ArrayList<String> countriesList;
    
    /**
     * The list of countries that the user selected.
     */
    private ArrayList<String> selectedCountriesList = new ArrayList<String>();
    
    /**
     * The list of menu items that will be placed inside the menu for selecting countries.
     */
    private ArrayList<CustomMenuItem> menuItemList;
    
    /**
     * The line chart that stores the result of generating chart.
     */
    LineChart<Number, Number> B2lineChart;
    
    /**
     * The line chart that is stashed.
     */
    LineChart<Number, Number> B2lineChartStash;
    
    /**
     * This function is to inject the general controller into B2TabController, allowing access of dataset version and the console.
     */
    public void injectController(Controller controller) {
    	this.controller = controller;
    }
    
    /**
     * This function is disabling the user editing the datepicker.
     */
    @FXML
    public void initialize() {
    	B2DatePickerEnd.getEditor().setDisable(true);
    	B2DatePickerStart.getEditor().setDisable(true);
    }
    
    /**
     * This function is to initialize the chart component.
     */
    public void initializeChart() {
    	NumberAxis yAxis = new NumberAxis();
    	yAxis.setAutoRanging(true);
    	yAxis.setLabel("Confirmed Deaths per 1M");
    	NumberAxis xAxis = new NumberAxis();
    	xAxis.setLabel("Date");
    	xAxis.setTickLabelFormatter(new StringConverter<Number>() {
    		@Override
            public String toString(Number object) {
                return LocalDate.ofEpochDay(object.longValue()).toString();
            }

            @Override
            public Number fromString(String string) {
                return 0;
            }
    	});
    	B2lineChart = new LineChart<Number, Number>(xAxis, yAxis);
    	B2lineChart.setTitle("Cumulative Confirmed COVID-19 Deaths (per 1M)");
    	B2lineChart.setCreateSymbols(false);
    }

    @FXML
    private Button B2ButtonConsoleView;

    @FXML
    private Button B2ButtonChartView;

    @FXML
    private DatePicker B2DatePickerEnd;

    @FXML
    private DatePicker B2DatePickerStart;

    @FXML
    private Button B2GenerateButton;

    @FXML
    private MenuButton B2MenuButton;
    
    @FXML
    private Button B2StashChart;
    
    @FXML
    private Button B2RetrieveStash;
    
    @FXML
    private Label B2StashIndicator;

    /**
     * This function is generating a chart, triggered by clicking the B2GenerateButton.
     * It will check all the input (i.e. startDate, endDate, countries of interest) are filled probably.
     * @param event
     */
    @FXML
    void doGenerateChart(ActionEvent event) {
    	initializeChart();
    	if (this.startDateOfInterest == null) {
    		controller.textAreaConsole.appendText("Please Enter The START Date of Interest. \n");
    		return;
    	}
    	if (this.endDateOfInterest == null) {
    		controller.textAreaConsole.appendText("Please Enter The END Date of Interest. \n");
    		return;
    	}
    	if (!validateInputDate(this.startDateOfInterest, this.endDateOfInterest)) {
    		controller.textAreaConsole.appendText("Please make sure the Start day is before End day. \n");
    		return;
    	}
    	if (selectedCountriesList.size() == 0) {
    		controller.textAreaConsole.appendText("Please Select Countries of Interest. \n");
    		return;
    	}
    	controller.textAreaConsole.appendText("Querying Data for the following countries: ");
    	for(String a : selectedCountriesList){
    		controller.textAreaConsole.appendText(a + " ");
    	}
    	
    	controller.textAreaConsole.appendText("within: " + startDateOfInterest + ", " + endDateOfInterest + "." +"\n");
    	NumberAxis xAxis =(NumberAxis) B2lineChart.getXAxis();
    	xAxis.setAutoRanging(false);
    	xAxis.setLowerBound(startDateOfInterest.toEpochDay());
    	xAxis.setUpperBound(endDateOfInterest.toEpochDay());
    	for(String location: selectedCountriesList) {
    		XYChart.Series<Number, Number> seriesLocation = generateSeries(location, startDateOfInterest, endDateOfInterest);
    		seriesLocation.setName(location);
    		B2lineChart.getData().add(seriesLocation);
    	}
    	controller.scrollPaneBottom.setContent(this.B2lineChart);
    	controller.scrollPaneBottom.setFitToHeight(true);
        controller.scrollPaneBottom.setFitToWidth(true);
    }

    /**
     * This function is triggered by picking a date in the B2DatePickerEnd.
     * It will check whether the current combination of startDate and EndDate is valid, then creating a list of countries for the user to choose from.
     * @param event
     */
    @FXML
    void doPickEndDate(ActionEvent event) {
    	this.endDateOfInterest = B2DatePickerEnd.getValue();
    	if(this.startDateOfInterest != null && validateInputDate(this.startDateOfInterest, B2DatePickerEnd.getValue())) {
    		initializeList();
    		controller.textAreaConsole.appendText(
    				"You picked the Date from: " + startDateOfInterest + ", to: " + endDateOfInterest + ". " +
    				"Please pick the targeted countries from the list.  \n");
    	}
    	else {
    		controller.textAreaConsole.appendText("Please choose a Ending Date that is after the Starting Date \n");
    	}
    }
    
    /**
     * This function is triggered by picking a date in the B2DatePickerStart.
     * It will check whether the current combination of startDate and EndDate is valid, then creating a list of countries for the user to choose from.
     * @param event
     */
    @FXML
    void doPickStartDate(ActionEvent event) {
    	this.startDateOfInterest = B2DatePickerStart.getValue();
    	if(this.endDateOfInterest != null) {
    		if(validateInputDate(B2DatePickerStart.getValue(),this.endDateOfInterest)){
    			initializeList();
        		controller.textAreaConsole.appendText(
        				"You picked the Date from: " + startDateOfInterest + ", to: " + endDateOfInterest + ". " +
        				"Please pick the targeted countries from the list.  \n");
    		}
    		else {
        		controller.textAreaConsole.appendText("Please choose a Starting Date that is before the Ending Date \n");
        	}
    	}
    	else {
    		controller.textAreaConsole.appendText("Please choose an Ending Date  \n");
    	}
    }

    /**
     * This is triggered by clicking the B2ButtonConsoleView.
     * It will switch to the lower scroll pane into Console View.
     * @param event
     */
    @FXML
    void doSwitchToConsole(ActionEvent event) {
    	controller.scrollPaneBottom.setContent(controller.textAreaConsole);
    }
    
    /**
     * This is triggered by clicking the B2ButtonChartView.
     * It will switch to the lower scroll pane into Chart View.
     * @param event
     */
    @FXML
    void doSwitchToChart(ActionEvent event) {
    	controller.scrollPaneBottom.setContent(this.B2lineChart);
    }
    
    @FXML
    void doStashChart(ActionEvent event) {
    	controller.textAreaConsole.appendText("Stashing the current chart. \n");
    	this.B2lineChartStash = this.B2lineChart;
    	initializeChart();
    	this.controller.scrollPaneBottom.setContent(B2lineChart);
    	B2StashIndicator.setText("Stashed: True");
    }
    
    @FXML
    void doRetrieveStash(ActionEvent event) {
    	B2lineChart = B2lineChartStash;
    	this.controller.scrollPaneBottom.setContent(B2lineChartStash);
    	B2StashIndicator.setText("Stashed: False");
    }
    
    /**
     * This is a function that initialize the menu for choosing countries.
     */
    private void initializeList() {
    	B2MenuButton.getItems().clear();
    	this.countriesList = DataAnalysis.getListOfLocations(controller.textfieldDataset.getText());
    	this.menuItemList = new ArrayList<CustomMenuItem>();
    	for (String country: this.countriesList) {
    		CheckBox checkBox = new CheckBox(country);
    		CustomMenuItem menuItem = new CustomMenuItem(checkBox);
    		menuItem.setHideOnClick(false);
    		menuItem.setOnAction(new EventHandler<ActionEvent>() {
    		    public void handle(ActionEvent t) {
    		    	if (checkBox.isSelected()) {
    		    		checkBox.setSelected(false);
    		    		selectedCountriesList.remove(country);
    		    		selectedCountriesList.remove(country);
    		    	}
    		    	else {
    		    		checkBox.setSelected(true);
    		    		selectedCountriesList.add(country);
    		    	}
    		    }
    		});
    		this.menuItemList.add(menuItem);
    	}
    	B2MenuButton.getItems().addAll(this.menuItemList.toArray(new CustomMenuItem[0]));
    	selectedCountriesList.clear();
    }
    
    /**
     * This is a function that check whether the startDate is before endDate.
     * @return boolean indicating whether the input dates are valid.
     */
    public boolean validateInputDate(LocalDate start, LocalDate end){
    	return start.isBefore(end);
    }
    
    /**
     * This function is used to create a series object for a particular location within the period of interest that will be put into the chart.
     * @param location This is the parameter for the country name.
     * @param startDate This is the parameter for the starting date.
     * @param endDate This is the parameter for the ending date.
     */
    public XYChart.Series<Number, Number> generateSeries(String location, LocalDate startDate, LocalDate endDate){
    	XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();
    	float confirmedDeaths1M = 0;
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
    	for (CSVRecord rec : DataAnalysis.getFileParser(controller.textfieldDataset.getText())) {
    		String date = rec.get("date");
    		LocalDate dateOfRec = null;
			if (!date.equals("")) {
				dateOfRec = LocalDate.parse(date, formatter);
			}
			else {
				controller.textAreaConsole.appendText("Missing some date entry in the data file within this date range. \n");
				continue;
			}
			if ((!dateOfRec.isAfter(endDate)) && (!dateOfRec.isBefore(startDate))) {
				if (rec.get("location").equals(location)) {
					String p = rec.get("new_deaths_per_million");
					if (!p.equals("")) {
						confirmedDeaths1M += Float.parseFloat(p);
						series.getData().add(new XYChart.Data<Number, Number>(dateOfRec.toEpochDay(), confirmedDeaths1M));
					}
					else {
						controller.textAreaConsole.appendText("Missing the new death counts per million of " + location + " in the data file on Date: " + dateOfRec + ". \n");
					}
				}
			}
		}
    	return series;
    }
}
