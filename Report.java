package prot.one;

public class Report { 

	private boolean success; 
	private String message; 
	
	//getters and setters
	
	public Report(boolean success, String message) {
		this.success = success; 
		this.message = message; 
	}

	public boolean isSuccess() { 
		return success; 
	}
	public void setSuccess(boolean success) { 
		this.success = success; 
	}

	public String getMessage() { 
		return message; 
	}
	public void setMessage(String message) { 
		this.message = message; 
	}

	@Override
	public String toString() { 
		return "\nPossible?: " + success + " || " + message; 
	}
}

