import java.util.*;

public class locationCollection {
	
	private ArrayList<location> locations = new ArrayList<>();
    private int capacity;
    private boolean results;

    public locationCollection() {

        this.capacity = 20;
    }

    public locationCollection(int capacity) {
        this.capacity = capacity;
    }

    public List<location> getLocation() {
        return locations;
    }

    public void addLocation(location location) {
    	if(locations.size() != capacity) {
    		locations.add(location);
    	}
    }
    


    public String findLocationByName(location Location) {

    	String locationName = Location.shopName;
    	results = locations.contains(locationName);
		return locationName;
    	
    }
    
    public void editLocation(location Location) {
    	Location.shopName = "The animal shop";
    }
    
    public void deleteLocation(location Location) {
    	locations.remove(Location);
    }

}


