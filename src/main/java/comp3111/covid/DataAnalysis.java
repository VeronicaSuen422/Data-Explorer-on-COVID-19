package comp3111.covid;

import javafx.scene.chart.XYChart;
import org.apache.commons.csv.*;
import edu.duke.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.*;

/**
 * 
 * Data Explorer on COVID-19
 * @author <a href=mailto:namkiu@ust.hk>Namkiu Chan</a>
 * @version	1.1
 * 
 */
public class DataAnalysis {
	
	/**
	 * This function parses the CSV file of the dataset.
	 * @param dataset
	 * @return
	 */
	public static CSVParser getFileParser(String dataset) {
	     FileResource fr = new FileResource("dataset/" + dataset);
	     return fr.getCSVParser(true);
		}
	

	 
	/**This is a helper function that can extract all locations from the csv file.
	 * 
	 * @param dataset
	 * @return
	 */
	 public static ArrayList<String> getListOfLocations(String dataset) {
		 ArrayList<String> countryList = new ArrayList<String>();
		 for (CSVRecord rec : getFileParser(dataset)) {
			 String location = rec.get("location");
			 if (!countryList.contains(location) && !location.equals("")){
				 countryList.add(location);
			 }
		 }
		 return countryList;
	 }
	 
	 /**This is a helper function that can extract all locations of the particular date from the csv file.
	  * 
	  * @param dataset
	  * @param dateOfInterest
	  * @return
	  */
	 public static ArrayList<String> getListOfLocationsGivenDate(String dataset, LocalDate dateOfInterest) {
		 ArrayList<String> countryList = new ArrayList<String>();
		 for (CSVRecord rec : getFileParser(dataset)) {
			 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
			 String date = rec.get("date");
			 LocalDate dateOfRec;
			 if(!date.equals("")) {
				 dateOfRec = LocalDate.parse(rec.get("date"), formatter);
			 }
			 else {
				 continue;
			 }
			 if (dateOfRec.equals(dateOfInterest)) {
				 String location = rec.get("location");
				 if (!countryList.contains(location) && !location.equals("")){
					 countryList.add(location);
				 }
			 }
		 }
		 return countryList;
	 }
	 
	 /**
	  * For Task C, get the countries that are available for the vaccination information on the selected date
	  */
	 public static ArrayList<String> getVaccinationAvailableCountry(String dataset, LocalDate iDate){
		String pattern = "M/d/yyyy";
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);
		ArrayList<String> country = new ArrayList<>();
		for (CSVRecord rec : getFileParser(dataset)) {
			 LocalDate date = LocalDate.parse(rec.get("date"), dateFormatter);
			 String vaccinatedStr = rec.get("people_fully_vaccinated");
			 if (vaccinatedStr.equals(""))
				 continue;
			 long fullyVaccinated = Long.parseLong(rec.get("people_fully_vaccinated"));
			 if((date.isBefore(iDate)||date.isEqual(iDate)) && fullyVaccinated > 0 ){
				 if(!country.contains(rec.get("location"))){
					 country.add(rec.get("location"));
				 }
			 }
		}
		return country;
	 }
	 
	 /**
	  * For Task C, get the vaccination data before a given date
	  */
	 public static Map<String, Country> getVaccinationDataBeforeDate(String dataset, LocalDate iDate){
		 String pattern = "M/d/yyyy";
		 DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);
		 Map<String, Country> countries = new TreeMap<>();

		 for(CSVRecord rec : getFileParser(dataset)){
			 LocalDate date = LocalDate.parse(rec.get("date"), dateFormatter);
			 if (date.isEqual(iDate) || date.isBefore(iDate)) {
				 String s1 = rec.get("people_fully_vaccinated");
				 String s2 = rec.get("population");
				 if (!s1.equals("") && !s2.equals("")) {
					 String countryName = rec.get("location");
					 long fullyVaccinated = Long.parseLong(s1);
					 long population = Long.parseLong(s2);
					 if (!countries.containsKey(countryName))
						 countries.put(countryName, new Country(countryName, population, fullyVaccinated));
					 else {
						 Country country = countries.get(countryName);
						 country.updatePopulation(population);
						 country.updateVaccinatedNum(fullyVaccinated);
					 }
				 }
			 }
		 }
		 return countries;
	 }
	 
	 /**
	  * For Task C
	  */
	 public static Date toDate(LocalDate d) {
		return new GregorianCalendar(d.getYear(), d.getMonthValue(), d.getDayOfMonth()).getTime();
	 }

	 /**
	  * For Task C, get the vaccination data between two given dates
	  */
	public static Map<String, List<XYChart.Data<Long, Float>>> getVaccinationDataBetweenDate(String dataset, LocalDate iDateFrom, LocalDate iDateTo){
		String pattern = "M/d/yyyy";
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);
		Map<String, Country> countries = new TreeMap<>();
		Map<String, List<XYChart.Data<Long, Float>>> countrySeries = new TreeMap<>();

		for(CSVRecord rec : getFileParser(dataset)){
			LocalDate date = LocalDate.parse(rec.get("date"), dateFormatter);
			if (date.isEqual(iDateTo) || date.isBefore(iDateTo) && (date.equals(iDateFrom) || date.isAfter(iDateFrom))) {
				String s1 = rec.get("people_fully_vaccinated");
				String s2 = rec.get("population");
				if (!s1.equals("") && !s2.equals("")) {
					String countryName = rec.get("location");
					long fullyVaccinated = Long.parseLong(s1);
					long population = Long.parseLong(s2);
					if (!countries.containsKey(countryName)) {
						Country newCountry = new Country(countryName, population, fullyVaccinated);
						countries.put(countryName, newCountry);
						List<XYChart.Data<Long, Float>> list = new ArrayList<>();

						list.add(new XYChart.Data<>(toDate(date).getTime(), newCountry.getRate()));
						countrySeries.put(countryName, list);
					}
					else {
						Country country = countries.get(countryName);
						country.updatePopulation(population);
						country.updateVaccinatedNum(fullyVaccinated);
						countrySeries.get(countryName).add(new XYChart.Data<>(toDate(date).getTime(), country.getRate()));
					}
				}
			}
		}
		return countrySeries;
	}
	 
}