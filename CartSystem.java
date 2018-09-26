import java.io.IOException;


public class CartSystem extends TheSystem{
	
	/**
	 * This method takes no parameter and displays every item in the Cart system, along with the subtotal, tax, and total
	 * @throws IOException
	 */
	public void display() throws IOException {
		
		final double TAX = 0.05;
		int i = 1;
		double sum = 0.0;
		
		System.out.println(" ");
		System.out.print("Item Name\t");
		System.out.print("Item Description\t");
		System.out.print("Item Price\t");
		System.out.println("Available Quantity");
		for(Item item : getItemCollection().values()) {
			System.out.print(i+"  ");
			System.out.print(item.getItemName()+"\t\t");
			System.out.print(item.getItemPrice()+"\t");
			sum += item.getItemPrice();
			System.out.println(item.getQuantity()+"\t");
			i++;
		}
		System.out.println(String.format("Sub total: %.2f", sum));
		System.out.println(String.format("Tax: %.2f", TAX*sum));
		System.out.println(String.format("Total: %.2f", sum+(sum*TAX)));
	}
}
