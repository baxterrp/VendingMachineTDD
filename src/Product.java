
public class Product {

	private double price;
	private String name;
	private int quantity;
	
	public Product(double productPrice, String productName, int productQuantity){
		price = productPrice;
		name = productName;
		quantity = productQuantity;
		
	}
	
	public double getPrice(){
		return price;
	}
	
	public String getName(){
		return name;
	}
	
	public int getQuantity(){
		return quantity;
	}
	
	public void sellProduct(){
		quantity--;
	}

	
}