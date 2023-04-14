package comp3111.covid;

public class B1Record {

    private String country = null;
    private long fully = 0;
    private float fully1M = 0;

    public B1Record(String country, long fully, float fully1M) {
        this.country = country;
        this.setFully(fully);
        this.setFully1M(fully1M);
    }

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public long getFully() {
		return fully;
	}

	public void setFully(long fully) {
		this.fully = fully;
	}

	public float getFully1M() {
		return fully1M;
	}

	public void setFully1M(float fully1m) {
		fully1M = fully1m;
	}
}
