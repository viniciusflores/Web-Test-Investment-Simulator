package project_constants;

public enum TimeToInvestmentEnum {
	MONTHS("MESES"), YEARS("ANOS");
	
	private String value;

	TimeToInvestmentEnum(final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
