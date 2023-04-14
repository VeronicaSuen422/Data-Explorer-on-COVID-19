package comp3111.covid;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.CustomMenuItem;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
/**
 * 
 * @author choiivan
 *
 */
public class B1TabController {
	/**
	 * The main controller that is responsible for the dataset and the bottomScrollPane.
	 */
    private Controller controller;
	
    /**
     * The variable storing user's desired date of interest.
     */
    private LocalDate dateOfInterest = null;
    
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
    
    @FXML
    private Button B1GenerateButton;
    
    @FXML
    private Button B1ApplyCSVButton;
    
    @FXML
    private Button B1ButtonConsoleView;
    
    @FXML
    private Button B1ButtonTableView;
    
    @FXML
    private MenuButton B1MenuButton;
    
    @FXML
    private DatePicker B1DatePicker;
    
    @FXML
    private Button B1ShowTop3;
    
    @FXML
    private Button B1ShowTop3_1M;
    
    
    private TableView<B1Record> B1TableView = new TableView<B1Record>();

    /**
     * This is a function to generate Table, it will do input validation check for input date and selected countries.
     * @param event
     */
    @FXML
    void doGenerateTable(ActionEvent event) {
    	B1TableView.getItems().clear();
    	if (this.dateOfInterest == null) {
    		controller.textAreaConsole.appendText("Please Enter Date of Interest. \n");
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
    	
    	controller.textAreaConsole.appendText("\n");
    	
    	
        for (String location: selectedCountriesList) {
        	B1Record record = generateB1Record(controller.textfieldDataset.getText(), location, this.dateOfInterest);
        	if(record.getFully() >= 0 || record.getFully1M() >= 0) {
        		B1TableView.getItems().add(record);
        	}
        }
        
        controller.scrollPaneBottom.setContent(B1TableView);
        controller.scrollPaneBottom.setFitToHeight(true);
        controller.scrollPaneBottom.setFitToWidth(true);
    }
    
    /**
     * This function is to initialize the table elements.
     */
    @FXML
    public void initialize() {
    	TableColumn<B1Record, String> countryColumn = new TableColumn<>("Country");
    	countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
    	TableColumn<B1Record, String> totalDeathColumn = new TableColumn<>("Total Deaths");
    	totalDeathColumn.setCellValueFactory(new PropertyValueFactory<>("fully"));
    	TableColumn<B1Record, String> totalDeathPer1MColumn = new TableColumn<>("Total Deaths (per 1M)");
    	totalDeathPer1MColumn.setCellValueFactory(new PropertyValueFactory<>("fully1M"));
    	TableColumn title = new TableColumn("Country");
    	title.getColumns().addAll(countryColumn, totalDeathColumn, totalDeathPer1MColumn);
    	B1TableView.getColumns().clear();
    	B1TableView.getColumns().add(title);
    	B1TableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    	B1DatePicker.getEditor().setDisable(true);
    }
    
    /**
     * This function is to switch the bottom scroll bar into console.
     * @param event
     */
    @FXML
    void doSwitchToConsole(ActionEvent event) {
    	controller.scrollPaneBottom.setContent(controller.textAreaConsole);
    }
    
    /**
     * This is function is to switch the bottom scroll bar into table
     * @param event
     */
    @FXML
    void doSwitchToTable(ActionEvent event) {
    	controller.scrollPaneBottom.setContent(this.B1TableView);
    }
    
    /**
     * This function is to pick the date of interest and create a list of countries option for the user to select.
     * @param event
     */
    @FXML
    void doPickDate(ActionEvent event) {
    	this.dateOfInterest = B1DatePicker.getValue();
    	this.B1TableView.getColumns().get(0).setText("Number of confirmed COVID-19 Deaths as of " + this.dateOfInterest);
    	updateList(this.dateOfInterest);
    	if (countriesList.size() == 0) {
    		controller.textAreaConsole.appendText("No Record on such date, please pick another date. \n");
    	}
    	else {
    		controller.textAreaConsole.appendText("Please pick the targeted countries from the list, or click \"Show Top 3 Entries\" button \n");
    	}
    }
    
    /**
     * This funciton is to generate a Table with top 3 entries in total death on particular date.
     * @param event
     */
    @FXML
    void doShowTop3(ActionEvent event) {
    	B1TableView.getItems().clear();
    	if (this.dateOfInterest == null) {
    		controller.textAreaConsole.appendText("Please Enter Date of Interest. \n");
    		return;
    	}
    	controller.textAreaConsole.appendText("Finding the top3 entries with Total Deaths on: " + this.dateOfInterest + ".\n");
    	ArrayList<B1Record> list = generateB1RecordWithTop3(this.controller.textfieldDataset.getText(), this.dateOfInterest);
    	for (B1Record rec: list) {
        	B1TableView.getItems().add(rec);
        }
        
        controller.scrollPaneBottom.setContent(B1TableView);
        controller.scrollPaneBottom.setFitToHeight(true);
        controller.scrollPaneBottom.setFitToWidth(true);
    }
    
    /**
     * This funciton is to generate a Table with top 3 entries in total death per 1M on particular date.
     * @param event
     */
    @FXML
    void doShowTop3_1M(ActionEvent event) {
    	B1TableView.getItems().clear();
    	if (this.dateOfInterest == null) {
    		controller.textAreaConsole.appendText("Please Enter Date of Interest. \n");
    		return;
    	}
    	controller.textAreaConsole.appendText("Finding the top3 entries with Total Deaths Per 1 Million on: " + this.dateOfInterest + ".\n");
    	ArrayList<B1Record> list = generateB1RecordWithTop3_1M(this.controller.textfieldDataset.getText(), this.dateOfInterest);
    	for (B1Record rec: list) {
        	B1TableView.getItems().add(rec);
        }
        
        controller.scrollPaneBottom.setContent(B1TableView);
        controller.scrollPaneBottom.setFitToHeight(true);
        controller.scrollPaneBottom.setFitToWidth(true);
    }
    
    /**
     * This function is to update the list of menu items (the checkboxes for selecting countries) according to the input dateOfInterest.
     * @param dateOfInterest
     */
    private void updateList(LocalDate dateOfInterest) {
    	selectedCountriesList.clear();
    	B1MenuButton.getItems().clear();
    	this.countriesList = DataAnalysis.getListOfLocationsGivenDate(controller.textfieldDataset.getText(), dateOfInterest);
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
    	B1MenuButton.getItems().addAll(this.menuItemList.toArray(new CustomMenuItem[0]));
    }
    
    public void injectController(Controller controller) {
    	this.controller = controller;
    }
    
    /**
     * This function is to generate a record in a table with a desired location, date, and dataset.
     * @param dataset
     * @param location
     * @param dateOfInterest
     * @return a B1Record which consists of Country name, Total Death, Total Death per 1M on the date of interest.
     */
    public B1Record generateB1Record(String dataset, String location, LocalDate dateOfInterest) {	
		long confirmedDeaths = -1;
		float confirmedDeaths1M = -1;
		
		for (CSVRecord rec : DataAnalysis.getFileParser(dataset)) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
			LocalDate dateOfRec = LocalDate.parse(rec.get("date"), formatter);
			if (dateOfRec.equals(dateOfInterest)) {
				if (rec.get("location").equals(location)) {
					
					String s = rec.get("total_deaths");
					if (!s.equals("")) {
						System.out.println("In s" + Long.parseLong(s));
						confirmedDeaths = Long.parseLong(s);
					}
					else {
						controller.textAreaConsole.appendText
						("Missing the total_deaths counts of " + location + " in the data file. \n");
					}
					String p = rec.get("total_deaths_per_million");
					if (!p.equals("")) {
						confirmedDeaths1M = Float.parseFloat(p);
					}
					else {
						controller.textAreaConsole.appendText
						("Missing the total_deaths counts per million of " + location + " in the data file. \n");
					}
				}
			}
		}
		return new B1Record(location, confirmedDeaths, confirmedDeaths1M);
    }
    
    /**
     * This function is to generate a list of records that having the top 3 total death on the date of interest.
     * If one of the data is missing, it will not be considered as a valid record even if it is the top 3.
     * @param dataset
     * @param dateOfInterest
     * @return a list of B1Records
     */
    public ArrayList<B1Record> generateB1RecordWithTop3(String dataset, LocalDate dateOfInterest) {	
		List<B1Record> list = new ArrayList<B1Record>();
		long confirmedDeaths = -1;
		float confirmedDeaths1M = -1;
		for (CSVRecord rec : DataAnalysis.getFileParser(dataset)) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
			LocalDate dateOfRec = LocalDate.parse(rec.get("date"), formatter);
			if (dateOfRec.equals(dateOfInterest)) {
				String location = rec.get("location");
				if (!location.equals("")) {
					String s = rec.get("total_deaths");
					if (!s.equals("")) {
						confirmedDeaths = Long.parseLong(s);
					}
					else {
						controller.textAreaConsole.appendText
						("Missing the total_deaths counts of " + location + " in the data file. \n");
						continue;
					}
					String p = rec.get("total_deaths_per_million");
					if (!p.equals("")) {
						confirmedDeaths1M = Float.parseFloat(p);
					}
					else {
						controller.textAreaConsole.appendText
						("Missing the total_deaths counts per million of " + location + " in the data file. \n");
						continue;
					}
				}
				list.add(new B1Record(location, confirmedDeaths, confirmedDeaths1M));
			}
		}
		Collections.sort(list, new Comparator<B1Record>() {
	        @Override
	        public int compare(B1Record h1, B1Record h2) {
	        	if(h1.getFully() > h2.getFully()) {
	                return 1;
	             } else if(h1.getFully() < h2.getFully()) {
	                return -1;
	             } else {
	                return 0;
	             }
	        }
	    });
		int n = 3;
		if(list.size() < n) {
			n = list.size();
		}
		return new ArrayList<B1Record>(list.subList(list.size()-n, list.size()));
    }
    
    /**
     * This function is to generate a list of records that having the top 3 total death per 1M on the date of interest.
     * If one of the data is missing, it will not be considered as a valid record even if it is the top 3.
     * @param dataset
     * @param dateOfInterest
     * @return
     */
    public ArrayList<B1Record> generateB1RecordWithTop3_1M(String dataset, LocalDate dateOfInterest) {	
		List<B1Record> list = new ArrayList<B1Record>();
		long confirmedDeaths = -1;
		float confirmedDeaths1M = -1;
		for (CSVRecord rec : DataAnalysis.getFileParser(dataset)) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
			LocalDate dateOfRec = LocalDate.parse(rec.get("date"), formatter);
			if (dateOfRec.equals(dateOfInterest)) {
				String location = rec.get("location");
				if (!location.equals("")) {
					String s = rec.get("total_deaths");
					if (!s.equals("")) {
						confirmedDeaths = Long.parseLong(s);
					}
					else {
						controller.textAreaConsole.appendText
						("Missing the total_deaths counts of " + location + " in the data file. \n");
						continue;
					}
					String p = rec.get("total_deaths_per_million");
					if (!p.equals("")) {
						confirmedDeaths1M = Float.parseFloat(p);
					}
					else {
						controller.textAreaConsole.appendText
						("Missing the total_deaths counts per million of " + location + " in the data file. \n");
						continue;
					}
				}
				list.add(new B1Record(location, confirmedDeaths, confirmedDeaths1M));
			}
		}
		Collections.sort(list, new Comparator<B1Record>() {
	        @Override
	        public int compare(B1Record h1, B1Record h2) {
	        	if(h1.getFully1M() > h2.getFully1M()) {
	                return 1;
	             } else if(h1.getFully1M() < h2.getFully1M()) {
	                return -1;
	             } else {
	                return 0;
	             }
	        }
	    });
		int n = 3;
		if(list.size() < n) {
			n = list.size();
		}
		return new ArrayList<B1Record>(list.subList(list.size()-n, list.size()));
    }
}
