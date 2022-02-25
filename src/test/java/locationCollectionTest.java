import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class locationCollectionTest {
	
	private locationCollection lc;
	private location l1;
	private location l2;
	private location l3;
	
	private String shopName;
	
	private final int LOCATION_COLLECTION_SIZE = 3;

	@BeforeEach
	void setUp() throws Exception {
		//Arrange
		lc = new locationCollection();
		l1 = new location("Pet shop1", "dogs.jpg", "dogs city", "we sell dogs and dog food");
		l2 = new location("Pet shop2", "cats.jpg", "cats town", "we sell cats and cat toys");
		l3 = new location("Pet shop3", "lizards.jpg", "lizrd sewer", "we sell lizard traps and poison");
		lc.addLocation(l1);
		lc.addLocation(l2);
		lc.addLocation(l3);

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetLocation() {
		List<location> testLc = lc.getLocation();
		//Assert that Location Collection is equals to location collection size
		assertEquals(testLc.size(), LOCATION_COLLECTION_SIZE);
	}

	@Test
	void testAddLocation() {
		List<location> testLc = lc.getLocation();
		//Assert that Location Collection is equals to location collection size
		assertEquals(testLc.size(), LOCATION_COLLECTION_SIZE);
		//Act
		lc.addLocation(l1);
		//Asset that location collection is equals to location collection size 3 + 1
		assertEquals(lc.getLocation().size(), LOCATION_COLLECTION_SIZE+1);
	}

	@Test
	void testFindLocationByName() {

		List<location> testLc = lc.getLocation();
		shopName = lc.findLocationByName(l1);
		assertEquals(shopName, "Pet shop1");
	}
	
	@Test
	void testEditLocation() {
		List<location> testLc = lc.getLocation();
		lc.editLocation(l1);
		assertEquals(l1.shopName, "The animal shop");		
	}
	
	@Test
	void testDeleteLocation() {
		List<location> testLc = lc.getLocation();
		assertEquals(testLc.size(), LOCATION_COLLECTION_SIZE);
		lc.deleteLocation(l1);
		assertEquals(lc.getLocation().size(), LOCATION_COLLECTION_SIZE - 1);
	}

}
