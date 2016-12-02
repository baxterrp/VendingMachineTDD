
public class Machine {
	
	private double coinTotal = 0;
	private String display = "Insert Coin";
	
	//accepts only valid coins
	public double acceptCoins(String coinName){
		switch(coinName){
				case "nickel" : return .05;
				case "dime" : return .10;
				case "quarter" : return .25;
		}
		
		return 0;
	}

	//increments cointTotal
	public double incrementCoinTotal(double coinValue){
		coinTotal += coinValue;
		
		return coinTotal;
	}
	
}
