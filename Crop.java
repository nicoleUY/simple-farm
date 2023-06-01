package prot.one;


public class Crop { 
	
	private String name; 

	private int harvestTime;
	private int age = 0;

	private boolean isWithered = false;

	private int water;  
	private int waterNeeded; 
	private int waterLimit;
	
	private int fertilizer; 
	private int fertilizerNeeded; 
	private int fertilizerLimit;

	private int yieldMin;
	private int yieldMax;
	
	private int seedCost;
	private int sellPrice;

	private double expYield;
	private double earnings;
	
	//constructor

	public Crop(String name, int harvestTime, int waterNeeded, int waterLimit, int fertilizerNeeded, int fertilizerLimit, 
				int yieldMin, int yieldMax, int seedCost, int sellPrice, double expYield) { 
	this.name = name; 
    this.harvestTime = harvestTime;
	this.water = 0; 
	this.waterNeeded = waterNeeded; 
    this.waterLimit = waterLimit;
	this.fertilizer = 0; 
	this.fertilizerNeeded = fertilizerNeeded; 
    this.fertilizerLimit = fertilizerLimit;
    this.yieldMin = yieldMin;
    this.yieldMax = yieldMax;
    this.seedCost = seedCost;
    this.sellPrice = sellPrice;
    this.expYield = expYield;
	}
	
	
   /**
	* Method to reset values to its initial state
	*/
	public void reset() {
		this.water = 0;
		this.fertilizer = 0;
		this.age = 0;
		this.isWithered = false;
	}
	
	//getters and setters 
	
	public String getName() { 
		return name; 
	}
	public void setName(String name) { 
		this.name = name; 
	}

	public int getHarvestTime() { 
		return harvestTime; 
	}
	public void setHarvestTime(int harvestTime) { 
		this.harvestTime = harvestTime; 
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public boolean getIsWithered() {
		return isWithered;
	}

	public void setIsWithered(boolean isWithered) {
		this.isWithered = isWithered;
	}

	public int getWater() { 
		return water; 
	}
	public void setWater(int water) { 
		this.water = water; 
	}

	public int getWaterNeeded() { 
		return waterNeeded; 
	}
	public void setWaterNeeded(int waterNeeded) { 
		this.waterNeeded = waterNeeded; 
	}

	public int getWaterLimit() { 
		return waterLimit; 
	}
	public void setWaterLimit(int waterLimit) { 
		this.waterLimit = waterLimit; 
	}

	public int getFertilizer() { 
		return fertilizer; 
	}
	public void setFertilizer(int fertilizer) { 
		this.fertilizer = fertilizer; 
	}

	public int getFertilizerNeeded() { 
		return fertilizerNeeded; 
	}
	public void setFertilizerNeeded(int fertilizerNeeded) { 
		this.fertilizerNeeded = fertilizerNeeded; 
	}

	public int getFertilizerLimit() { 
		return fertilizerLimit; 
	}
	public void setFertilizerLimit(int fertilizerLimit) { 
		this.fertilizerLimit = fertilizerLimit; 
	}
  
	public int getYieldMin() { 
		return yieldMin; 
	}
	public void setYieldMin(int yieldMin) { 
		this.yieldMin = yieldMin; 
	}

	public int getYieldMax() { 
		return yieldMax; 
	}
	public void setYieldMax(int yieldMax) { 
		this.yieldMax = yieldMax; 
	}

	public int getSeedCost() { 
		return seedCost; 
	}
	public void setSeedCost(int seedCost) { 
		this.seedCost = seedCost; 
	}

	public int getSellPrice() { 
		return sellPrice; 
	}
	public void setSellPrice(int sellPrice) { 
		this.sellPrice = sellPrice; 
	}

	public double getExpYield() { 
		return expYield; 
	}
	
	public void setExpYield(double expYield) { 
		this.expYield = expYield; 
	}
	
	public double getEarnings() {
		return earnings;
	}

	public void setEarnings(double earnings) {
		this.earnings = earnings;
	}
  
	@Override
	public String toString() { 
		return "(Name: " + name + ", Age: " + age + ", Water: " + water + ", Water Needed: " + waterNeeded + ", Fertilizer: " + fertilizer
				+ ", Fertilizer Needed: " + fertilizerNeeded + ", Cost: " + seedCost + ", Harvest Time: " + harvestTime + ")"; 
	}
}
