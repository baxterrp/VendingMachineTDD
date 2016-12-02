import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {
	
	Machine machine;

	@Before
	public void setUp(){
		machine = new Machine();
	}
	////Accept Coins Tests
	
	//returns coin value
	@Test
	public void testAcceptCoinsForCoinValue(){
		assertEquals(.05, machine.acceptCoins("nickel"), 0);
	}
	
	//increments customers total coin value
	
	//display is updated when coin is inserted

	////Select Product Tests
}
