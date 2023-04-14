package testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import comp3111.covid.B1Record;

public class TestB1Record {
	@Test
	public void testGetCountry() {
		B1Record b1 = new B1Record("TestCountry",3l,5.0f);
		assertEquals("TestCountry", b1.getCountry());
	}
	
	@Test
	public void testSetCountry() {
		B1Record b1 = new B1Record("TestCountry",3l,5.0f);
		b1.setCountry("AnotherCountry");
		assertEquals("AnotherCountry", b1.getCountry());
	}
	
	@Test
	public void testGetFully() {
		B1Record b1 = new B1Record("TestCountry",3l,5.0f);
		assertEquals(3l, b1.getFully());
	}
	
	@Test
	public void testSetFully() {
		B1Record b1 = new B1Record("TestCountry",3l,5.0f);
		b1.setFully(100l);
		assertEquals(100l, b1.getFully());
	}
	
	@Test
	public void testGetFully1M() {
		B1Record b1 = new B1Record("TestCountry",3l,5.0f);
		assertEquals(5.0f, b1.getFully1M(), 0.0f);
	}
	
	@Test
	public void testSetFully1M() {
		B1Record b1 = new B1Record("TestCountry",3l,5.0f);
		b1.setFully1M(1000f);;
		assertEquals(1000f, b1.getFully1M(), 0.0f);
	}
}
