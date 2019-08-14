package project_constants;

public enum InvestmentProfileEnum {
	PHYSICAL_PERSON("paraVoce"), LEGAL_ENTITY("paraEmpresa");
	
	private String value;

	InvestmentProfileEnum(final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
