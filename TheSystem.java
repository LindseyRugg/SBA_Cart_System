import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class TheSystem {
	
	private HashMap<String,Item> itemCollection;

	/**
	 * Constructor
	 * If an instance of the class AppSystem is the one invoking the constructor, then the itemCollection should 
	 * be filled with the items contained in the sample.txt file. Otherwise, itemCollection 
	 * should be initialized and just be empty.
	 */
	public TheSystem() {
		try {
		if(getClass().getSimpleName().equals("AppSystem")){
			itemCollection = new HashMap<String,Item>();
			String line = "";

			FileReader reader = new FileReader(new File("sample.txt"));
			Scanner scan = new Scanner(reader);
			
			while(scan.hasNextLine()) {
				line = scan.nextLine();
				String[] lines = line.split("\\s ");
				
				Item item = new Item();
				
				item.setItemName(lines[0]);
				item.setItemDesc(lines[1]);
				item.setItemPrice(Double.parseDouble(lines[2]));
				item.setAvailableQuantity(Integer.parseInt(lines[3]));
			
				String key = item.getItemName();
				
				itemCollection.put(key, item);
				}//end of while loop
				scan.close();
			}//end of method
		else 
			itemCollection = new HashMap<String,Item>();	
		} catch(Exception e) {
			System.out.println("This shouldnt be here");
			e.getMessage();
	}
}
	
	/**
	 * This method should create a new HashMap<String, Item>, then add every key and item in 
	 * the original itemCollection to a new HashMap<String, Item>. 
	 * Finally, it should return the new HashMap<String, Item>
	 */
	public HashMap<String, Item> getItemCollection() throws IOException{
		
		HashMap<String,Item> newItemCollection = new HashMap<String,Item>();
		newItemCollection.putAll(itemCollection);
		return newItemCollection;
		}//end of method
	
	/**
	 *  this method should take a HashMap as a parameter and assigns it to the original itemCollection
	 * @param newItemCollection
	 */
	public void setItemCollection(HashMap<String,Item> newItemCollection) {
		//empties out itemCollection so it can be set to the hashmap being passed in
		itemCollection.clear();
		itemCollection.putAll(newItemCollection);
		
	}
	
	/**
	 * This method checks if there is enough available quantity of an item to fill the order that the user wants to add to their cart
	 * if false it prints out that it cannot fill the order of the item, but also prints out how many items it can fill.
	 * if it can fill the order it returns true.  
	 * @param item
	 * @param current
	 * @return
	 */
	public boolean checkAvailability(Item item, int current) {
		
		boolean check = false;
		if((item.getQuantity()+current) > item.getAvailableQuantity()) {
			System.out.println(" System is unable to add "+ item.getQuantity()+ " " + current + " " + item);
			System.out.println("System can only add " + item.getQuantity() + " " + item.getItemName());
		}
		else {
			check = true;
		}
		return check;
	}
	
	
	/**
	 * This methods adds entries to the hashmap
	 * If it is already in the collection, it checks if the item is available, If it is available, increases the quantity by one 
	 * Otherwise, don't add the item. If the item is not already in the collection, adds it to the collection.
	 * @param item
	 * @return
	 */
	public boolean add(Item item) {
		if(itemCollection.containsKey(item.getItemName())) {
			int oldQuantity = item.getQuantity();
			item.setQuantity((oldQuantity+1));
		}
		else {
			String newKey = item.getItemName();
			itemCollection.put(newKey, item);
		}
		return true;
	}
	
	/**
	 * This method takes as a parameter the name of the item to be removed. First check if the item is in the collection, 
	 * if it is, then removes it and return the Item object being removed. If is not in the collection then return null
	 * @param itemName
	 * @return
	 */
	public Item remove(String itemName) {
	
		Item item = new Item();
		if(itemCollection.containsKey(itemName)) {
			System.out.println(itemName+ " has been removed");
			itemCollection.remove(itemName);
			item.setItemName(itemName);
		}
		else {
			item = null;
		}
		return item;
	}
}
