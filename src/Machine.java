
public class Machine {
	
	private double coinTotal = 0;
	private String display = "Insert Coin";
	
	public double acceptCoins(String coinName){
		switch(coinName){
				case "nickel" : return .05;
		}
		
		return 0;
	}

}
