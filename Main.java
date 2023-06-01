package prot.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Main {
  
  public static void main(String[] args) {
   
	System.out.println("Welcome to MyFarm!");
	
	while (isRunning) {
		printState();
		var cmd = userInput();
		performCommand(cmd);
		checkConditions();
	}
    
	printFinalState();
	
	System.out.println("\nPlay Again? -> Y/N");
	var ans = input.next().charAt(0);
	
	//resets all components to its initial state
	if(ans == 'Y') {
		isRunning = true;
		if(tile.getPlantedCrop() != null)
			tile.getPlantedCrop().reset();
		tile.setPlantedCrop(null);
		tile.setPlowed(false);
		farmer.reset();
		stats.reset();
		main(null);
	}
	
	else if (ans == 'N')
		System.out.println("Thank You for Playing! Goodbye.");
	
	input.close();
  }
  
  
  /**
   * Initial choices given to the Player
   */
  public static void actionMenu1(){
    System.out.println("=".repeat(7)+"ACTION MENU"+ "=".repeat(7));
    System.out.println("P - Plow tile");
    System.out.println("Q - Quit Game");
    System.out.println("=".repeat(25));
  }
  
  /**
   * Updated choices if Plow condition is met (Tile is plowed)
   */
  public static void actionMenu2(){
    System.out.println("=".repeat(7)+"ACTION MENU"+ "=".repeat(7));
    System.out.println("B - Buy & Plant a Seed");
    System.out.println("W - Water plant");
    System.out.println("F - Fertilize plant");
    System.out.println("N - Next day");
    System.out.println("Q - Quit Game");
    System.out.println("=".repeat(25));
  }
  
  /**
   * Updated choices if Harvest condition is met (Tile is plowed)
   */
  public static void actionMenu3(){
	    System.out.println("=".repeat(7)+"ACTION MENU"+ "=".repeat(7));
	    System.out.println("B - Buy & Plant a Seed");
	    System.out.println("W - Water plant");
	    System.out.println("F - Fertilize plant");
	    System.out.println("H - Harvest crop");
	    System.out.println("N - Next day");
	    System.out.println("Q - Quit Game");
	    System.out.println("=".repeat(25));
	  }
  
    //Input
  	public static final Scanner input = new Scanner(System.in);

	// Global state
	public static boolean isRunning = true;
	public static final Stats stats = new Stats();
	public static final Tile tile = new Tile();
	public static final Farmer farmer = new Farmer();
	public static final List<Crop> seedList = new ArrayList<Crop>(Arrays.asList(
		new Crop("Turnip", 2, 1, 2, 0, 1, 1, 2, 5, 6, 5)
	));
	 
	/**
	 * Method to display current status of all components in the game
	 */
	public static void printState() {
		// Displays descriptive info about Farmer, Tile, and Stats
		System.out.println("\n[*Status of Farmer*] " + farmer);
		System.out.println("\n[*Status of Tile*] " + tile); 
		System.out.println("\n[*Current Stats:*] " + stats); 
		System.out.println("_".repeat(35));
		System.out.println(String.format("\n[DAY: %d]\n", stats.getDaysPassed()));
	}
	
	/**
	 * This method displays the action menu and stores the input command
	 * 
	 * @param seedList: A list of seeds able to be bought by the Player
	 * @return the input command
	 */
	public static String userInput() {
	
	//determines which action menu to display depending on the conditions
    if(tile.getIsPlowed() == false)
      actionMenu1();
    else if (tile.getPlantedCrop() != null && tile.getPlantedCrop().getAge() <= tile.getPlantedCrop().getHarvestTime() && 
    		 tile.getPlantedCrop().getWater() >= tile.getPlantedCrop().getWaterNeeded() &&
    		 tile.getPlantedCrop().getFertilizer() >= tile.getPlantedCrop().getFertilizerNeeded())
      actionMenu3();
    else
      actionMenu2();
    
		return input.next();
	}
	
	/**
	 * Performs the actions displayed in the previous action menu; Which include Buying/Planting a Seed, Watering and Fertilizing a Plant,
	 * Harvesting a Crop, Proceeding to the Next Day, and Quitting the game.
	 * 
	 * @param cmd: the input command
	 */
	public static void performCommand(String cmd) {
		switch(cmd) {
		case "B": // Buying and Planting a seed
			
			// Displays the crop options from seedList 
			System.out.println("Available Crops: " + seedList); 
			
			// Stores Input of Player regarding Buying the seed
			System.out.println("\nWould You like to Buy this Seed? -> Y/N"); 
			var ans = input.next().charAt(0);
			
			// If Seed is bought
			if(ans == 'Y') {
				
				//assigns bought seed to a variable, and deducts objectcoins
				var seed = seedList.get(0);
				
				if(farmer.getCoin() >= seedList.get(0).getSeedCost())
					farmer.setCoin(farmer.getCoin() - seedList.get(0).getSeedCost());
				else {
					System.out.println("Insuffecient Funds!");
					break;
				}
				
				var con = true;
				while(con) {
				// Stores Input of Player regarding Planting of the seed
				System.out.println("\nPlease Plant the Seed. -> Y");
				var plant = input.next().charAt(0);
				
				//If seed is attempted to be planted
				if(plant == 'Y') {
					
					//Response if tile is Occupied
					if(tile.getPlantedCrop() != null) {
						Report report = new Report(false, "Tile is already Occupied");
						System.out.println(report);
						con = false;
					}
					
					//Successful Planting
					else {
						System.out.println(tile.plantSeed(seed));
					    stats.addTimesPlanted();
					    con = false;
					}
						
				}
				
				else 
					System.out.println("Invalid Command");
				
				}
					
				//If tile is unplowed
				if(tile.getIsPlowed() == false) 
					stats.setTimesPlanted(stats.getTimesPlanted() - 1);
				
			}
			
			//If seed is not bought
			else if(ans == 'N') {
				break;
			}
			
			break;
			
        
		case "P":
			
			//Plows the Tile, updates stats, displays a report, and rewards corresponding experience points
			System.out.println(tile.plow());
			if (tile.getIsPlowed()!= false){
				stats.addTimesPlowed();
				farmer.setExp(farmer.getExp()+0.5);
      }
				
			break;
        
		case "W":
			
			//Waters the crop, updates stats, displays a report, and rewards corresponding experience points
			System.out.println(tile.water());
			if (tile.getPlantedCrop()!=null){
				stats.addTimesWatered();
				farmer.setExp(farmer.getExp()+0.5);
      }
				
			break;
        
		case "F":
			
			//Successfully fertilized (checks if Player has enough money)
			//Fertilizes the crop, updates stats, displays a report, deducts cost, and rewards corresponding experience points
			if (tile.getPlantedCrop()!=null && farmer.getCoin() >= 10){
				System.out.println(tile.fertilize());
				stats.addTimesFertilized();
				farmer.setExp(farmer.getExp()+4);
				farmer.setCoin(farmer.getCoin()-10);
			}
			
			//Unsuccessful (not enough money)
			else if (tile.getPlantedCrop()!=null && farmer.getCoin() < 10) {
				tile.fertilize();
				Report report = new Report(false, "Insuffecient Funds");
				tile.getPlantedCrop().setFertilizer(tile.getPlantedCrop().getFertilizer() - 1);
				System.out.println(report);
			}
			
			//No crop to fertilize
			else if((tile.getPlantedCrop()==null && farmer.getCoin() < 10) || (tile.getPlantedCrop()==null && farmer.getCoin() >= 10))
				System.out.println(tile.fertilize());
			
			break;
        
		case "H":
			
			//attempt to harvest the Plant
			System.out.println(tile.harvest());
			
			stats.addTimesHarvested();
			
			//Checks if harvest is successful
			if (tile.getIsHarvested() == true){
				stats.addTimesHarvestedSuccessfully();
				
				//rewarding objectcoin and experience
				farmer.setExp(farmer.getExp() + tile.getPlantedCrop().getExpYield());
				farmer.setCoin(farmer.getCoin() + tile.getPlantedCrop().getEarnings());
				
				//resetting crop & tile state
				tile.getPlantedCrop().reset();
				tile.setPlantedCrop(null);
			}
			
			//Even if harvest is successful or not, reset tile to unplowed state
			tile.setPlowed(false);
				
			break;
        
    case "N":
    	
    	//add next day
    	stats.addDaysPassed(); 
    	
    	//adds crop age
    	if(tile.getPlantedCrop() != null) {
    		tile.getPlantedCrop().setAge(tile.getPlantedCrop().getAge() + 1);
    	
    		//checks reason for withering
    		if(tile.getPlantedCrop().getAge() >= tile.getPlantedCrop().getHarvestTime()) {
    			
    			//Lack of water
    			if (tile.getPlantedCrop().getWater() < tile.getPlantedCrop().getWaterNeeded()){
    				tile.getPlantedCrop().setIsWithered(true); 
    				Report report = new Report(false, "Your plant has withered away. (Dehydrated)");
    				System.out.println(report);
    			}
    			
    			//Lack of fertilizer
    			if (tile.getPlantedCrop().getFertilizer() < tile.getPlantedCrop().getFertilizerNeeded()){
    				tile.getPlantedCrop().setIsWithered(true); 
    				Report report = new Report(false, "Your plant has withered away. (Infertile)");
    				System.out.println(report);
    			}
    		
    		//Unable to harvest in time
    		if (tile.getPlantedCrop().getAge() > tile.getPlantedCrop().getHarvestTime()) {
    			tile.getPlantedCrop().setIsWithered(true);
    			Report report = new Report(false, "Your plant has withered away. (Overripe)");
				System.out.println(report);
    			}
    		}
    	}
    		
        break;
        
		case "Q":
			
			//stops the game
			isRunning = false;
			System.out.println("Exiting the game");
			break;
			
		default:
			System.out.println("Unknown command: " + cmd);
		}
	}
	
	
	/**
	 * This method checks the end conditions for the game
	 * 
	 * @param seedList: A list of seeds able to be bought by the Player
	 */
	public static void checkConditions() {
		
		//checks if crop is withered
		if ((tile.getPlantedCrop()!=null && tile.getPlantedCrop().getIsWithered() == true))
			isRunning = false;
		//checks if the Player has no funds
		if(tile.getPlantedCrop() == null && (farmer.getCoin() < seedList.get(0).getSeedCost())) {
			System.out.println("\nOops! Sorry, you've run out of money & there are no active/growing crops!");
			isRunning = false;
		}
		
	}
	
	/**
	 * This method displays final status of all components in the game
	 */
	
	public static void printFinalState() {
		// Displays descriptive info about Farmer, Tile, and Stats at the endgame
		System.out.println("\nGame Over! Here are your Game End Stats");
		System.out.println("\nFarmer Status: " + farmer);
		System.out.println("\nState of your tile: " + tile);
		System.out.println("\nOverall Stats: " + stats);
		
	}
}


