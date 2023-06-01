package prot.one;

import java.util.Random;
public class Tile {

	private Crop plantedCrop = null;
	private boolean successGen = true;
	private String reason = null;
	private boolean isPlowed = false;
	public boolean isHarvested = false;
	
	private static final Random RNG = new Random();

	/**
	 * Attempts to plant a seed on the tile
	 * 
	 * @param seed: the element to be planted
	 * @return report of the attempt
	 */
	public Report plantSeed(Crop seed) {
		
		// Checks if seed is null 
		if(seed == null) {
			successGen = false;
			reason = "No Crop to Plant";
		}
		
		// Checks if tile is unplowed
		else if(isPlowed == false){
			successGen = false;
			reason = "Unplowed Soil";
			
		}
		
		// If successful, seed is planted to the tile
		else {
			plantedCrop = seed;
			successGen = true;
			reason = "Seed Planted Successfully";
		}
		
		var message = reason;
		var success = successGen;
		return new Report(success, message);
	}

	/**
	 * Attempts to plow the tile
	 * 
	 * @return report of the attempt
	 */
	public Report plow() {
		
		// Check if tile is already plowed
		if(isPlowed == true){
			successGen = false;
			reason = "Land is Plowed";
		}
		
		// Check if there is already a planted crop
		else if (plantedCrop != null){
			successGen = false;
			reason = "Crop Already Planted";
		}
		
		else
			successGen = true;
		
		// For success, set isPlowed to true
		if (successGen == true) {
			isPlowed = true;
			reason = "Tile Plowed Successfully!";
		}
		
		var message = reason;
		var success = successGen;
		return new Report(success, message);
	}

	/**
	 * Attempts to water the crop
	 * 
	 * @return report on the attempt
	 */
	public Report water() {
		
		//Checks if the planted crop is missing
		if (plantedCrop == null) {
			successGen = false;
			reason = "No Crop to Water";
		}
		
		//For success, update crop stats
		else {
			successGen = true;
			plantedCrop.setWater(plantedCrop.getWater()+1);
			reason = "Water Added Successfully";
		}
		
		var message = reason;
		var success = successGen;
		return new Report(success, message);
	}
	
	/**
	 * Attempts to fertilize the Crop
	 * 
	 * @return report on the attempt
	 */
	public Report fertilize() {
		
		//Checks if the planted crop is missing
		if (plantedCrop == null) {
			successGen = false;
			reason = "No Crop to Fertilize";
		}
		
		//For success, update crop stats
		else {
			successGen = true;
			plantedCrop.setFertilizer(plantedCrop.getFertilizer() + 1);
			reason = "Fertilizer Added Successfully";
		}
		
		var message = reason;
		var success = successGen;
		return new Report(success, message);
	}
	
	
	/**
	 * Attempts the harvest the planted crop
	 * 
	 * @return a Harvest Report of the attempt
	 */
	public HarvestReport harvest() {
		
		// Checks if sufficient water was given to the crop
		if (getPlantedCrop().getWater() < getPlantedCrop().getWaterNeeded()) {
			isHarvested = false;
			var message = "The Crop is Dehydrated";
			plantedCrop = null;
			return new HarvestReport(0, 0, 0, message);
		}
		
		// Checks if sufficient fertilizer was given to the crop
		else if (getPlantedCrop().getFertilizer() < getPlantedCrop().getFertilizerNeeded()) {
			isHarvested = false;
			var message = "The Crop is Infertile";
			plantedCrop = null;
			return new HarvestReport(0, 0, 0, message);
		}
		
		//For success, calculate the yield, earnings, and experience gained from the harvest
		
		else {
		
		//Puts a cap on Water and Fertilizer based on the Bonus Limits
		if(plantedCrop.getWater() > plantedCrop.getWaterLimit())
			plantedCrop.setWater(plantedCrop.getWaterLimit());
		
		if(plantedCrop.getFertilizer() > plantedCrop.getFertilizerLimit())
			plantedCrop.setFertilizer(plantedCrop.getFertilizerLimit());
		
		//calculating yield and earnings
		var yield = RNG.nextInt(plantedCrop.getYieldMin(), plantedCrop.getYieldMax() + 1);
		var harvestPrice = yield * plantedCrop.getSellPrice();
		var waterBonus = yield * 0.2 * (plantedCrop.getWater() - 1);
		var fertilizerBonus = yield * 0.5 * (plantedCrop.getFertilizer() - 1);
		var earnings = harvestPrice + waterBonus + fertilizerBonus;
		var expGain = plantedCrop.getExpYield();
		
		plantedCrop.setEarnings(earnings);
		reason = null;
		isHarvested = true;
		
		return new HarvestReport(yield, earnings, expGain, reason);
		
		}
		
	}
	
	//getters and setters
	
	public void setPlantedCrop(Crop plantedCrop) {
		this.plantedCrop = plantedCrop;
	}

	public Crop getPlantedCrop() { 
		return plantedCrop; 
	}
	
	public void setPlowed(boolean isPlowed) {
		this.isPlowed = isPlowed;
	}
	
	public boolean getIsPlowed() {
		return isPlowed;
	}

	public boolean getIsHarvested() {
		return isHarvested;
	}
	
	@Override
	public String toString() { 
		return "\n|> Plowed?: " + isPlowed + "\n|> Planted Crop: " + plantedCrop; 
	}
	
}
