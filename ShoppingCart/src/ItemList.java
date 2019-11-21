
import java.util.ArrayList;
import java.util.List;

// this class serves as a dummy data store for maintaining item catalog.
public class ItemList {
	
	private final List<Item> itemList = new ArrayList<Item>();
	
	public ItemList()
	{
		this.initItemsForTest();
	}

	public List<Item> getItems() 
	{
		return itemList;
	}
	
	
	public void initItemsForTest()
	{
		String [] manufacturers = {"AH", "Zaanse", "Bing", "Partin", "Heinz"};
		String [] descs = {"AAA", "BBB", "CCC", "DDD", "EEE"};
		int [] sizes = {1000, 250, 300, 250, 200};
		String [] itemNames = {"Bread", "Butter", "Salad", "Cheese", "Spread"};
		double [] prices = {3.5, 2.5, 2, 4, 2.5};
		
		for (int i=0; i < itemNames.length; i++) 
		{
			this.itemList.add(new Item(i+1, manufacturers[i], descs[i], sizes[i],
					itemNames[i], prices[i]));
	    }
	}
}
