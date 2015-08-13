package poppin.values;

public enum ShippingNames {
	THREE_TO_FIVE_BUSINESS_DAYS("1"),
	NEXT_BUSINESS_DAY("2"),
	TWO_BUSINESS_DAYS("3");
	

	private final String ddPosition;
	private ShippingNames(String ddPosition) {
		this.ddPosition = ddPosition;
	}
	public String getValue() {
		return ddPosition;
	}
	
}