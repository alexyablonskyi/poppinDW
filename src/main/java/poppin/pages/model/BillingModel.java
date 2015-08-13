package poppin.pages.model;

public class BillingModel {

	private String actFname = null;
	private String actLname = null;
	private String actEmail = null;
	private String actPhone = null;
	private String actAdd1 = null;
	private String actAdd2 = null;
	private String actState = null;
	private String actCity = null;
	private String actZipCode = null;
	
	public BillingModel(String actFname, String actLname, String actEmail,
			String actPhone, String actAdd1, String actAdd2,
			String actState, String actCity, String actZipCode) {
		this.actFname = actFname;
		this.actLname = actLname;
		this.actEmail = actEmail;
		this.actPhone = actPhone;
		this.actAdd1 = actAdd1;
		this.actAdd2 = actAdd2;
		this.actState = actState;
		this.actCity = actCity;
		this.actZipCode = actZipCode;
	}
	
	public String getActFname() {
		return this.actFname;
	}
	
	public String getActLname() {
		return actLname;
	}
		
	public String getActEmail() {
		return actEmail;
	}
		
	public String getActPhone() {
		return actPhone;
	}
		
	public String getActAdd1() {
		return actAdd1;
	}
		
	public String getActAdd2() {
		return actAdd2;
	}
		
	public String getActState() {
		return actState;
	}
		
	public String getActCity() {
		return actCity;
	}
	
	public String getActZipCode() {
		return actZipCode;
	}
}
