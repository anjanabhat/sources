import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class Cart {

		private List<ShoppingCartItem> items; 
		private int discount;
		private double cartValue;
		public PropertyChangeSupport propertyChangeSupport;
				
		public Cart() {
			items = new ArrayList<ShoppingCartItem>();
			discount = 0;
			cartValue = 0;
			propertyChangeSupport = new PropertyChangeSupport(this);
		}

		// This function is used get the Item from the Item catalog
		private Item getItemById(int id)
		{
			Item it = null;
		    List<Item> items = new ItemList().getItems();
		    for (Item i: items)
		    {
		    	if (i.getId() == id) 
		    	{
		    		it = i;
		            break;
		        }
		    }
		    return it;
		}
		
		// We assume that quantity of item is 1 when user doesn't
		// explicitly select the quantity
		public void addItemToCart(int id)
		{
			Item i = getItemById(id);
			items.add(new ShoppingCartItem(i, 1));
			propertyChangeSupport.firePropertyChange("Item with id " + id + " and quantity 1 added to Cart", 0, 1);
		}
		
		// this function adds item with id and specified quantity into cart.
		public void addItemToCart(int id, int quantity)
		{
			Item i = getItemById(id);
			items.add(new ShoppingCartItem(i, quantity));
			propertyChangeSupport.firePropertyChange("Item with id " + id + " and quantity " + quantity + " added to Cart", 0, 1);
		}
		
		// this function clears the cart
		public void emptyCart()
		{
			items.clear();
			discount = 0;
			propertyChangeSupport.firePropertyChange("Cart Emptied ", 0, 1);
		}
	
		// this function removes the item with id from the cart
		public void removeItemFromCart(int id) throws ProductNotFoundException
		{
			Item i = getItemById(id);
			for (int j = 0; j < items.size(); ++j)
			{
				ShoppingCartItem it = items.get(j);
				if (it.getItem().equals(i))
				{
					items.remove(j);
					propertyChangeSupport.firePropertyChange("Item with id " + id + " removed from Cart", 0, 1);
					return;
				}
			}		
			throw new ProductNotFoundException("Could not find item with id " + id);
		}
		
		// function to set the discount code
		public void setDiscount(int discount)
		{
			if (this.discount != 0)
			{
				System.out.println("SORRY! Can apply only one discount code");
				return;
			}		
			this.discount = discount;
		}
		
		// function to remove the discount code.
		public void removeDiscount()
		{
			discount = 0;
		}
		
		// function to update quantity of item with id.
		public void updateItemQuanity(int id, int newQuantity) throws ProductNotFoundException
		{
			Item i = getItemById(id);
			for (int j = 0; j < items.size(); ++j)
			{
				ShoppingCartItem it = items.get(j);
				if (it.getItem().equals(i))
				{
					items.get(j).setQuantity(newQuantity);
					propertyChangeSupport.firePropertyChange("Item with id " + id + " quantity updated to " + newQuantity, 0, 1);
					return;
				}
			}
			throw new ProductNotFoundException("Could not find item with id " + id);
		}

		// computes the total amount to be paid at checkout
		// we could also use the single function to calculate and return the value.
		public void calculateCartValue()
		{
			cartValue = 0;
			for (int i = 0; i < items.size(); ++i)
			{
				ShoppingCartItem it = items.get(i);
				cartValue += it.getItem().getPrice() * it.getQuantity();
			}
			if (discount > 0)
				cartValue -= (discount * cartValue / 100);
				
		}
		
		// returns the cart value
		public double getCartValue()
		{
			return cartValue;
		}
		
		// returns the cart items as list of strings.
		public List<String> returnItems()
		{
			List<String> cartList = new ArrayList<String>(); 
			for (int i = 0; i < items.size(); ++i)
			{
				String cartItem = items.get(i).getItem().toString() + " Quantity: " +
								  String.valueOf(items.get(i).getQuantity());
				cartList.add(cartItem);
			}
			return cartList;
		}
		
		// listener to capture the time whenever the cart is updated.
		public void addPropertyChangeListener(PropertyChangeListener listener)
		{
			propertyChangeSupport.addPropertyChangeListener(listener);
		}
}
