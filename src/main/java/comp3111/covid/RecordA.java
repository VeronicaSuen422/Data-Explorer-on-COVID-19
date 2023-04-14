package comp3111.covid;

public class RecordA {
	private String country;
	private long casesTotal;
	private float casesPerM;
	
	public RecordA(String str, long total, float per) {
		country = str;
		casesTotal = total;
		casesPerM = per;
	}
	
	public void setCountry(String str) {
		country = str;
	}
	
	public void setCasesTotal(long total) {
		casesTotal = total;
	}
	
	public void setCasesPerM(float per) {
		casesPerM = per;
	}
	
	public String getCountry() {
		return country;
	}
	
	public long getCasesTotal() {
		return casesTotal;
	}
	
	public float getCasesPerM() {
		return casesPerM;
	}
}