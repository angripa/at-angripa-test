package awantunai.test.enums;

public enum ServiceStatus {	
	
	//success
	SUCCESS("1000","General Success"),
	
	//info
	INFO("2000","General Info"),
	WITHDRAWAL_EXCEED_BALANCE("2001","Withdrawal exceed balance"),
	INVALID_FORMAT("2004","Invalid Format"),
	
	//warning
	WARNING("3000","General Warning"),
	INSUFFICIENT_BALANCE("3001","Insufficient Balance"),
	
	//failed
	NOT_FOUND("4000","Data Not Found"),
	LOGIN_FAIL("4999","Invalid Username or Password"),
	USER_EXIST("4004","Username already taken"),
	ACCOUNT_NOT_FOUND("4005","Account not found"),
	
	
	//error
	NETWORK_AUTHENTICATION_REQUIRED("9111", "Network Authentication Required"),
	UE("9999", "Unexpected Error");
	
	private final String value;
	private final String reasonPhrase;	
	private ServiceStatus(String value, String reasonPhrase) {
		this.value = value;
		this.reasonPhrase = reasonPhrase;
	}

	public String getValue() {
		return value;
	}

	public String getReasonPhrase() {
		return reasonPhrase;
	}	
		
}
