import java.util.ArrayList;

public class Machine {
	
	private double coinTotal = 0;
	private String display = "Insert Coin";
	private int[] machineFunds = new int[3];

	///////////for testing only
	public double setCoinTotal(double amount){
		coinTotal = amount;
		return coinTotal;
	}
	
	//accepts only valid coins
	public double acceptCoins(String coinName){
		switch(coinName){
				case "nickel" : 
					machineFunds[0]++;
					return .05;
				case "dime" : 
					machineFunds[1]++;
					return .10;
				case "quarter" : 
					machineFunds[2]++;
					return .25;
		}
		
		return 0;
	}

	//increments cointTotal
	public double incrementCoinTotal(double coinValue){
		coinTotal += coinValue;
		//limit to two digits
		coinTotal = Math.round(coinTotal * 100);
		coinTotal = coinTotal/100;
		//change display
		display = String.format("%.2f", coinTotal);
		display = "$" + display;
		
		return coinTotal;
	}
	
	//return display
	public String getDisplay(){
		return display;
	}
	
	public double selectProduct(Product product){
		if(product.getQuantity() > 0){
			if(coinTotal > product.getPrice()){
				product.sellProduct();
				display = "Thank You";
				coinTotal = 0;
				makeChange(product.getPrice());
				return coinTotal;
			}
			else{
				if(coinTotal > 0){
					display = String.format("%.2f",  product.getPrice());
					display = "PRICE $" + display;
				}else{
					display = "Insert Coin";
				}
				return coinTotal;
			}
		}else{
			display = "Sold Out";
			return coinTotal;
		}
	}
	
	public double makeChange(double cost){
		return coinTotal - cost;
	}
	
	public double returnChange(){
		double returnAmount = coinTotal;
		coinTotal = 0;
		display = "Insert Coin";
		return returnAmount;
	}
	
	public String checkMachineFunds(){
		// 2 dimes, and a nickel to make change for up to 25 cents
		if(machineFunds[0] < 1 && machineFunds[1] < 2)	
			display = "Exact Change Only";
		else{
			display = "Insert Coin";
		}
		return display;
	}
	
	
}
