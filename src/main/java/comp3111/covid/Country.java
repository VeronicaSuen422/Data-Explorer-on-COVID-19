package comp3111.covid;

import java.util.*;


/**
 * A class called Country for storing vaccination information about a country
 */
public class Country {
	private String countryName;
	private long population;
	private long vaccinatedNum;
	public Country(String countryName, long population, long vaccinatedNum) {
		this.countryName = countryName;
		this.population = population;
		this.vaccinatedNum = vaccinatedNum;
	}

	 public String getCountryName() {
		 return countryName;
	 }

	 public void updateVaccinatedNum(long vaccinatedNum) {
		this.vaccinatedNum = Math.max(vaccinatedNum, this.vaccinatedNum);
	 }

	 public void updatePopulation(long population) {
		 this.population = Math.max(population, this.population);
	 }

	 public long getVaccinatedNum() {
		 return vaccinatedNum;
	 }
	 
	 public long getPopulation() {
		 return population;
	 }

	 public float getRate() {
		 return (float) vaccinatedNum / population * 100;
	 }

	 public Map<String, String> getPropertyMap() {
		Map<String, String> map = new HashMap<>();
		 map.put("CountryName", getCountryName());
		 map.put("VaccinatedNum", String.format("%,d", getVaccinatedNum()));
		map.put("Rate", String.format("%.2f%%", getRate()));
		return map;
	 }
}
