package testing;

import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


import comp3111.covid.Country;

public class TestCountry {

	@Test
	public void TestgetCountryName() {
		Country country = new Country("TestCountry", 1, 1);
		assertEquals("TestCountry", country.getCountryName());
	}
	
	@Test
	public void TestupdateVaccinatedNum() {
		long TestVaccinatedNum = 2;
		Country country = new Country("TestCountry", 1, 1);
		country.updateVaccinatedNum(TestVaccinatedNum);
		assertEquals(TestVaccinatedNum, country.getVaccinatedNum());
	}
	
	@Test
	public void TestupdatePopulation() {
		long TestPopulation = 2;
		Country country = new Country("TestCountry", 1, 1);
		country.updatePopulation(TestPopulation);
		assertEquals(TestPopulation, country.getPopulation());
	}
	
	@Test
	public void TestgetVaccinatedNum() {
		long TestVaccinatedNum = 1;
		Country country = new Country("TestCountry", 1, 1);
		assertEquals(TestVaccinatedNum, country.getVaccinatedNum());
	}
	
	@Test
	public void TestgetPopulation() {
		long TestPopulation = 1;
		Country country = new Country("TestCountry", 1, 1);
		assertEquals(TestPopulation, country.getPopulation());
	}
	
	@Test
	public void TestgetRate() {
		float TestRate = 100;
		Country country = new Country("TestCountry", 1, 1);
		assertEquals(TestRate, country.getRate(), 0);
	}
	
	@Test 
	public void TestgetPropertyMap() {
		long testvaccinatedNum = 1;
		float testrate = 100;
		Country country = new Country("TestCountry", 1, 1);
		Map<String, String> TestMap = new LinkedHashMap<>();
		TestMap.put("CountryName", "TestCountry");
		TestMap.put("VaccunatedNum",String.format("%,d", testvaccinatedNum));
		TestMap.put("Rate", String.format("%.2f%%", testrate));
		assertThat(country.getPropertyMap().size(), is(3));
	}
}
