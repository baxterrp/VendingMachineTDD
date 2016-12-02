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
	////Select Product Tests
	
	//create new product
	@Test
	public void getAllFieldsOfNewProduct(){
		assertEquals(1.00, cola.getPrice(), 0);
		assertEquals("cola", cola.getName());
		assertEquals(5, cola.getQuantity());
	}

	@Test
	public void checkCostAgainstCustomerMoneyWithSufficientFunds(){
		//fill machine
		assertEquals(5.00, machine.setCoinTotal(5.00), 0);
		//transaction
		assertEquals(0, machine.selectProduct(cola), 0);
		//sold 1 item
		assertEquals(4, cola.getQuantity());
		//changed display
		assertEquals("Thank You", machine.getDisplay());
	}
	
	@Test
	public void checkCostAgainstCustomerMoneyWithInsufficientFunds(){
		assertEquals(.25, machine.incrementCoinTotal(machine.acceptCoins("quarter")), 0);
		//transaction
		assertEquals(.25, machine.selectProduct(cola), 0);
		//no item sold
		assertEquals(5, cola.getQuantity());
		//changed display
		assertEquals("PRICE $1.00", machine.getDisplay());
	}
	
	@Test
	public void checkCostAgainstCustomerMoneyWithZero(){
		assertEquals(0, machine.selectProduct(cola), 0);
		assertEquals("Insert Coin", machine.getDisplay());
	}
	
	@Test
	public void makeChangeReturnsCorrectChange(){
		//fill machine
		assertEquals(5.00, machine.setCoinTotal(5.00), 0);
		//make change
		assertEquals(4.00, machine.makeChange(1.00), 0);
	}
}
