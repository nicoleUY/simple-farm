package prot.one;

class Farmer {
	
	private double coin = 100;
	private double exp = 0;
	private int level = 0;
	
	/**
	* Method to reset values to its initial state
	*/
	public void reset() {
		this.coin = 100;
		this.exp = 0;
		this.level = 0;
	}

	  //level assessment
	  public void getLevel() {
		  level = (int)(exp/100);
	  }
	  
	  //Getters and Setters
	  public void setCoin(double coin){
	    this.coin = coin;
	  }
	  
	  public double getCoin(){
	    return coin;
	  }

	  public void setExp(double exp){
	    this.exp = exp;
	  }
	  
	  public double getExp(){
	    return exp;
	  }

	@Override
	public String toString() { 
			return "\n|> ObjectCoins: " + coin + "\n|> Experience: " + exp + "\n|> Level: " + level;
	  }

	}


