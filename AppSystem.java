import java.io.IOException;
import java.util.HashMap;


public class AppSystem extends TheSystem {
	
	//TheSystem sys = new TheSystem();

	/**
	 * This method takes no parameter and it should display every item in the App system.
	 * @throws IOException
	 */
	public void display() throws IOException {

		int i = 1;
		System.out.println(" ");
		System.out.print("Item Name\t");
		System.out.print("Item Description\t");
		System.out.print("Item Price\t");
		System.out.println("Available Quantity");
		for(Item item : getItemCollection().values()){
			System.out.print(i+"  ");
			System.out.print(item.getItemName()+" ");
			System.out.print(item.getItemDesc()+" ");
			System.out.print(item.getItemPrice()+" ");
			System.out.println(item.getAvailableQuantity()+" ");
			i++;
			
		}
	}
	
	/**
	 * This method takes an Item Object as a parameter. It checks if the item is already in the system. 
	 * If it is, then display a message. and return false. If is not then adds it and return true
	 */
	public boolean add(Item newItem)  {
		
		boolean temp = false;
		try {
			if(getItemCollection().containsKey(newItem.getItemName())) {
				System.out.println(newItem.getItemName() + " is already in " + (getClass().getSimpleName()));
				temp = false;
			}
			else {
				
				String newKey = newItem.getItemName();
				HashMap<String,Item> newItemCollection = new HashMap<String,Item>();
				newItemCollection.putAll(getItemCollection());
				newItemCollection.put(newKey, newItem);
				setItemCollection(newItemCollection);
				temp = true;
			}
		} catch (IOException e) {
			System.out.println("This shouldnt happen");
			e.printStackTrace();
		}
		return temp;
	}
}


