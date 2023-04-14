package testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import comp3111.covid.RecordA;

public class TestRecordA {
	@Test
	public void testGetCountry() {
		var record = new RecordA("CountryName",3500l,0.01f);
		assertEquals("CountryName", record.getCountry());
	}
	
	@Test
	public void testGetCasesTotal() {
		var record = new RecordA("CountryName",3500l,0.01f);
		assertEquals(3500, record.getCasesTotal());
	}
	
	@Test
	public void testGetCasesPerM() {
		var record = new RecordA("CountryName",3500l,0.01f);
		assertEquals(0.01f,record.getCasesPerM(),0.0f);
	}
	
	@Test
	public void testSetCountry() {
		var record = new RecordA("CountryName",3500l,0.01f);
		record.setCountry("NewCountryName");
		assertEquals("NewCountryName", record.getCountry());
	}
	
	@Test
	public void testSetCasesTotal() {
		var record = new RecordA("CountryName",3500l,0.01f);
		record.setCasesTotal(2130l);
		assertEquals(2130l, record.getCasesTotal());
	}
	
	@Test
	public void testSetCasesPerM() {
		var record = new RecordA("CountryName",3500l,0.01f);
		record.setCasesPerM(0.52f);
		assertEquals(0.52f, record.getCasesPerM(),0.0f);
	}
}