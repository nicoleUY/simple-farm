package prot.one;

public class HarvestReport {
	
	private int yield = 0;
	private double earnings = 0;
	private String witherReason;
	private double expGain = 0;

	public HarvestReport(int yield, double earnings, double expGain, String witherReason) {
		this.yield = yield;
		this.earnings = earnings;
		this.expGain = expGain;
		this.witherReason = witherReason;
	}

	public int getYield() {
		return yield;
	}

	public double getEarnings() {
		return earnings;
	}

	public String getWitherReason() {
		return witherReason;
	}

	/**
	 * Checks if the harvest was successful
	 * 
	 * @return
	 */
	public boolean isSuccess() {
		if (witherReason == null){
			witherReason = "Harvested Successfully!";
			return true;
		}
		else 
			return false;
	}

  @Override
	public String toString() { 
		return "[*HarvestReport*] " + "\n|> success?: " + isSuccess() + "\n|> Notes: " + witherReason + "\n|> Yield: " + yield + "\n|> Earnings: " + earnings + "\n|> Experience Gained: " + expGain;
  }

}

