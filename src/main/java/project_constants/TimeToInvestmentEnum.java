package project_constants;

/**
 * 
 * @author vinicius.flores
 *
 */
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
