import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {
	
	Machine machine;
	Product cola;
	Product chips;
	Product candy;

	@Before
	public void setUp(){
		machine = new Machine();
		cola = new Product(1.00, "cola", 5);
		chips = new Product(.50, "chips", 0);
		candy = new Product(.65, "candy", 1);
	}
	////Accept Coins Tests
	
	//returns coin value
	@Test
	public void testAcceptCoinsForCoinValue(){
		assertEquals(.05, machine.acceptCoins("nickel"), 0);
		assertEquals(.10, machine.acceptCoins("dime"), 0);
		assertEquals(.25, machine.acceptCoins("quarter"), 0);
	}
	
	//increments customers total coin value
	@Test
	public void incrementCoinTotalReturnsUpdatedCoinTotal(){
		assertEquals(.05, machine.incrementCoinTotal(machine.acceptCoins("nickel")), 0);
		assertEquals(.15, machine.incrementCoinTotal(machine.acceptCoins("dime")), 0);
		assertEquals(.40, machine.incrementCoinTotal(machine.acceptCoins("quarter")), 0);
		//display is updated when coin is inserted
		assertEquals("$0.40", machine.getDisplay());
	}
	
	//create new product
	@Test
	public void getAllFieldsOfNewProduct(){
		assertEquals(1.00, cola.getPrice(), 0);
		assertEquals("cola", cola.getName());
		assertEquals(5, cola.getQuantity());
	}

	////Select Product Tests
}
