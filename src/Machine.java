
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
		if(coinTotal > product.getPrice()){
			product.sellProduct();
			display = "Thank You";
			coinTotal = 0;
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
	}
	
	
}
