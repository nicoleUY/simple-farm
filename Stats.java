package prot.one;

public class Stats { 

private int timesPlanted = 0; 
private int timesPlowed = 0; 
private int timesWatered = 0; 
private int timesFertilized = 0; 
private int timesHarvested = 0; 
private int timesHarvestedSuccessfully = 0; 
private int daysPassed = 1;

/**
* Method to reset values to its initial state
*/

public void reset() {
	this.timesPlanted = 0; 
	this.timesPlowed = 0; 
	this.timesWatered = 0; 
	this.timesFertilized = 0; 
	this.timesHarvested = 0; 
	this.timesHarvestedSuccessfully = 0; 
	this.daysPassed = 1;
}

/* Convenience methods for value++ */

public int addTimesPlowed() { 
	return ++timesPlowed; 
}
public int addTimesWatered() { 
	return ++timesWatered; 
}
public int addTimesFertilized() { 
	return ++timesFertilized; 
}
public int addTimesPlanted() { 
	return ++timesPlanted; 
}
public int addTimesHarvested() { 
	return ++timesHarvested; 
}
public int addTimesHarvestedSuccessfully() { 
	return ++timesHarvestedSuccessfully; 
}

public int addDaysPassed() { 
	return ++daysPassed; 
}


// getters and setters

public int getTimesPlowed() { 
	return timesPlowed; 
}
public void setTimesPlowed(int timesPlowed) { 
	this.timesPlowed = timesPlowed; 
}

public int getTimesWatered() { 
	return timesWatered; 
}
public void setTimesWatered(int timesWatered) { 
	this.timesWatered = timesWatered; 
}

public int getTimesFertilized() { 
	return timesFertilized; 
}
public void setTimesFertilized(int timesFertilized) { 
	this.timesFertilized = timesFertilized; 
}

public int getTimesPlanted() { 
	return timesPlanted; 
}
public void setTimesPlanted(int timesPlanted) { 
	this.timesPlanted = timesPlanted; 
}

public int getTimesHarvested() { 
	return timesHarvested; 
}
public void setTimesHarvested(int timesHarvested) { 
	this.timesHarvested = timesHarvested; 
}

public int getTimesHarvestedSuccessfully() { 
	return timesHarvestedSuccessfully; 
}
public void setTimesHarvestedSuccessfully(int timesHarvestedSuccessfully) { 
	this.timesHarvestedSuccessfully = timesHarvestedSuccessfully; 
}

public void setDaysPassed(int daysPassed) { 
	this.daysPassed = daysPassed;
}

public int getDaysPassed() { 
	return daysPassed; 
}

@Override
public String toString() { 
	return "\n|> Times Planted: " + timesPlanted + "\n|> Times Plowed: " + timesPlowed + "\n|> Times Watered: " + timesWatered
			+ "\n|> Times Fertilized: " + timesFertilized + "\n|> Times Harvested: " + timesHarvested
			+ "\n|> Times Harvested Successfully: " + timesHarvestedSuccessfully; 
}
}
