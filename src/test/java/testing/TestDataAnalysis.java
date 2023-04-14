package testing;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.*;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import comp3111.covid.DataAnalysis;
import javafx.scene.chart.XYChart;
import comp3111.covid.Country;

public class TestDataAnalysis {
	
	@Test
	public void testGetListOfLocations() {
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("Afghanistan");
		expected.add("Africa");
		expected.add("Albania");
		ArrayList<String> listOfCountries = DataAnalysis.getListOfLocations("TaskBHelperTest.csv");
		assertEquals(expected, listOfCountries);
	}
	
	@Test
	public void testGetListOfLocationsGivenDate() {
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("Afghanistan");
		expected.add("Africa");
		expected.add("Albania");
		String date = "2020-02-24";
		LocalDate dateOfInterest = LocalDate.parse(date);
		ArrayList<String> listOfCountries = DataAnalysis.getListOfLocationsGivenDate("TaskBHelperTest.csv", dateOfInterest);
		assertEquals(expected, listOfCountries);
	}
	
	@Test
	public void testgetVaccinationAvailableCountry() {
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("Afghanistan");
		expected.add("Africa");
		expected.add("Albania");
		String date = "2020-02-24";
		LocalDate dateOfInterest = LocalDate.parse(date);
		ArrayList<String> listOfCountries = DataAnalysis.getVaccinationAvailableCountry("TaskCHelperTest.csv", dateOfInterest);
		assertEquals(expected, listOfCountries);
	}
	
	@Test
	public void testgetVaccinationDateBeforeDate() {
		Map<String, Country> expected = new TreeMap<>();
		Country testAfghanistan = new Country("Afghanistan", 10000, 123);
		Country testAfrica = new Country("Africa", 10000, 124);
		Country testAlbania = new Country("Albania", 10000, 126);
		expected.put("Afghanistan", testAfghanistan);
		expected.put("Africa", testAfrica);
		expected.put("Albania", testAlbania);
		String date = "2020-02-24";
		LocalDate dateOfInterest = LocalDate.parse(date);
		Map<String, Country> listOfCountries = DataAnalysis.getVaccinationDataBeforeDate("TaskCHelperTest.csv", dateOfInterest);
		assertEquals(expected.containsKey("Afghanistan"), DataAnalysis.getVaccinationDataBeforeDate("TaskCHelperTest.csv", dateOfInterest).containsKey("Afghanistan"));
		assertEquals(expected.containsKey("Africa"), DataAnalysis.getVaccinationDataBeforeDate("TaskCHelperTest.csv", dateOfInterest).containsKey("Africa"));
		assertEquals(expected.containsKey("Albania"), DataAnalysis.getVaccinationDataBeforeDate("TaskCHelperTest.csv", dateOfInterest).containsKey("Albania"));
		}
	
	@Test
	public void testtoDate() {
		LocalDate testDate = LocalDate.of(2020, 02, 24);
		Date expected = DataAnalysis.toDate(testDate);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(expected);
		assertEquals(2020, calendar.get(Calendar.YEAR));
	}
	
	@Test
	public void testgetVaccinationDataBetweenDate() {
		LocalDate testDate = LocalDate.of(2020, 02, 24);
		Map<String, Country> expectedCountry = new TreeMap<>();
		Map<String, List<XYChart.Data<Long, Float>>> expectedCountrySeries = new TreeMap<>();
		List<XYChart.Data<Long, Float>> expectedlist = new ArrayList<>();
		Country testAfghanistan = new Country("Afghanistan", 10000, 123);
		expectedlist.add(new XYChart.Data<>(DataAnalysis.toDate(testDate).getTime(), testAfghanistan.getRate()));
		expectedCountrySeries.put("Afghanistan", expectedlist);
		Country testAfrica = new Country("Africa", 10000, 124);
		expectedlist.add(new XYChart.Data<>(DataAnalysis.toDate(testDate).getTime(), testAfrica.getRate()));
		expectedCountrySeries.put("Africa", expectedlist);
		Country testAlbania = new Country("Albania", 10000, 126);
		expectedlist.add(new XYChart.Data<>(DataAnalysis.toDate(testDate).getTime(), testAlbania.getRate()));
		expectedCountrySeries.put("Albania", expectedlist);
		assertEquals(expectedCountrySeries.containsKey("Afghanistan"), DataAnalysis.getVaccinationDataBetweenDate("TaskCHelperTest.csv", testDate, testDate).containsKey("Afghanistan"));
		assertEquals(expectedCountrySeries.containsKey("Africa"), DataAnalysis.getVaccinationDataBetweenDate("TaskCHelperTest.csv", testDate, testDate).containsKey("Africa"));
		assertEquals(expectedCountrySeries.containsKey("Albania"), DataAnalysis.getVaccinationDataBetweenDate("TaskCHelperTest.csv", testDate, testDate).containsKey("Albania"));
	}
}
