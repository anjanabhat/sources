
import java.util.List;

public class MainClass {

	public static void main(String[] args) {
		
		Cart shoppingCart = new Cart();
		CartChangeListener changelistener = new CartChangeListener();
		List<String> cartItems;
		shoppingCart.addPropertyChangeListener(changelistener);
		
		// Case 1 : add the items and no discount
		System.out.println("CASE 1");
		shoppingCart.addItemToCart(1);
		try
		{
			shoppingCart.addItemToCart(2, 3);
		}
		catch(InvalidQuantityException iq)
		{
			System.err.println(iq);
		}
		try
		{
			shoppingCart.addItemToCart(3, 3);
		}
		catch(InvalidQuantityException iq)
		{
			System.err.println(iq);
		}
		shoppingCart.calculateCartValue();
		System.out.println("Total cart value for first case :" + shoppingCart.getCartValue());	
		cartItems = shoppingCart.returnItems();		
		if (cartItems.isEmpty())
			System.out.println("Empty Cart!");
		else
			cartItems.forEach(System.out::println);
		
		shoppingCart.emptyCart();
		
		// case 2 : add the items with discount
		System.out.println("\n CASE 2");
		shoppingCart.addItemToCart(1);
		try
		{
			shoppingCart.addItemToCart(3, 3);
		}
		catch(InvalidQuantityException iq)
		{
			System.err.println(iq);
		}
		shoppingCart.setDiscount(50);
		shoppingCart.calculateCartValue();
		System.out.println("Total cart value for second case :" + shoppingCart.getCartValue());	
		cartItems = shoppingCart.returnItems();		
		if (cartItems.isEmpty())
			System.out.println("Empty Cart!");
		else
			cartItems.forEach(System.out::println);
		
		shoppingCart.emptyCart();
		
		// case 3 : try applying 2 discounts.
		System.out.println("\n CASE 3");
		shoppingCart.addItemToCart(1);
		try
		{
			shoppingCart.addItemToCart(3, 3);
		}
		catch(InvalidQuantityException iq)
		{
			System.err.println(iq);
		}
		shoppingCart.setDiscount(50);
		shoppingCart.setDiscount(40);
		shoppingCart.emptyCart();
		
		
		// case 4 : remove discount
		System.out.println("\n CASE 4");
		shoppingCart.addItemToCart(1);
		try
		{
			shoppingCart.addItemToCart(3, 3);
		}
		catch(InvalidQuantityException iq)
		{
			System.err.println(iq);
		}
		shoppingCart.setDiscount(50);
		shoppingCart.removeDiscount();
		shoppingCart.calculateCartValue();
		System.out.println("Total cart value for fourth case :" + shoppingCart.getCartValue());	
		cartItems = shoppingCart.returnItems();		
		if (cartItems.isEmpty())
			System.out.println("Empty Cart!");
		else
			cartItems.forEach(System.out::println);
		
		shoppingCart.emptyCart();		
		
		// case 5: add the item and then remove some items.
		System.out.println("\n CASE 5");
		try
		{
			shoppingCart.addItemToCart(3, 4);
		}
		catch(InvalidQuantityException iq)
		{
			System.err.println(iq);
		}
		try
		{
			shoppingCart.addItemToCart(5, 2);
		}
		catch(InvalidQuantityException iq)
		{
			System.err.println(iq);
		}
		shoppingCart.calculateCartValue();
		System.out.println("Total cart value BEFORE discount :" + shoppingCart.getCartValue());
		shoppingCart.setDiscount(50);
		shoppingCart.calculateCartValue();
		System.out.println("Total cart value after discount :" + shoppingCart.getCartValue());	
		try
		{
			shoppingCart.removeItemFromCart(3);	
		}
		catch(ProductNotFoundException pe)
		{
			System.err.println(pe);
		}
		shoppingCart.calculateCartValue();
		System.out.println("Total cart value after removing item with id 3 :" + shoppingCart.getCartValue());	
		cartItems = shoppingCart.returnItems();		
		if (cartItems.isEmpty())
			System.out.println("Empty Cart!");
		else
			cartItems.forEach(System.out::println);
		
		shoppingCart.emptyCart();		
	
		
		
		// case 6 : add the item and then update quantity.
		
		System.out.println("\n CASE 6");
		try
		{
			shoppingCart.addItemToCart(4, 4);
		}
		catch(InvalidQuantityException iq)
		{
			System.err.println(iq);
		}
		try
		{
			shoppingCart.addItemToCart(5, 2);
		}
		catch(InvalidQuantityException iq)
		{
			System.err.println(iq);
		}
		try
		{
			shoppingCart.addItemToCart(2, 3);
		}
		catch(InvalidQuantityException iq)
		{
			System.err.println(iq);
		}
		shoppingCart.calculateCartValue();
		System.out.println("Total cart value with no discount :" + shoppingCart.getCartValue());
		try
		{
			shoppingCart.updateItemQuanity(5, 3);	
		}
		catch(ProductNotFoundException pe)
		{
			System.err.println(pe);
		}
		catch(InvalidQuantityException iq)
		{
			System.err.println(iq);
		}
		shoppingCart.calculateCartValue();
		System.out.println("Total cart value after updating item with id 5 :" + shoppingCart.getCartValue());	
		cartItems = shoppingCart.returnItems();		
		if (cartItems.isEmpty())
			System.out.println("Empty Cart!");
		else
			cartItems.forEach(System.out::println);
		
		shoppingCart.emptyCart();		
		
		// case 7 : add the item, update and remove.
		System.out.println("\n CASE 7");
		try
		{
			shoppingCart.addItemToCart(4, 4);
		}
		catch(InvalidQuantityException iq)
		{
			System.err.println(iq);
		}
		try
		{
			shoppingCart.addItemToCart(5, 2);
		}
		catch(InvalidQuantityException iq)
		{
			System.err.println(iq);
		}
		try
		{
			shoppingCart.addItemToCart(2, 3);
		}
		catch(InvalidQuantityException iq)
		{
			System.err.println(iq);
		}
		shoppingCart.calculateCartValue();
		System.out.println("Total cart value with no discount :" + shoppingCart.getCartValue());
		try
		{
			shoppingCart.updateItemQuanity(5, 3);	
		}
		catch(ProductNotFoundException pe)
		{
			System.err.println(pe);
		}
		catch(InvalidQuantityException iq)
		{
			System.err.println(iq);
		}
		shoppingCart.calculateCartValue();
		System.out.println("Total cart value after updating item with id 5 :" + shoppingCart.getCartValue());	
		try
		{
			shoppingCart.removeItemFromCart(4);	
		}
		catch(ProductNotFoundException pe)
		{
			System.err.println(pe);
		}
		shoppingCart.calculateCartValue();
		System.out.println("Total cart value after removing item with id 4:" + shoppingCart.getCartValue());		
		
		cartItems = shoppingCart.returnItems();		
		if (cartItems.isEmpty())
			System.out.println("Empty Cart!");
		else
			cartItems.forEach(System.out::println);
		
		shoppingCart.emptyCart();		
			
		
		// case 8 : add the item, update and remove and apply discount.
		
		System.out.println("\n CASE 8");
		try
		{
			shoppingCart.addItemToCart(4, 4);
		}
		catch(InvalidQuantityException iq)
		{
			System.err.println(iq);
		}
		try
		{
			shoppingCart.addItemToCart(5, 2);
		}
		catch(InvalidQuantityException iq)
		{
			System.err.println(iq);
		}
		try
		{
			shoppingCart.addItemToCart(2, 3);
		}
		catch(InvalidQuantityException iq)
		{
			System.err.println(iq);
		}
		shoppingCart.calculateCartValue();
		System.out.println("Total cart value with no discount :" + shoppingCart.getCartValue());
		
		shoppingCart.setDiscount(50);
		shoppingCart.calculateCartValue();
		
		System.out.println("Total cart value with discount of 50% :" + shoppingCart.getCartValue());
		try
		{
			shoppingCart.updateItemQuanity(5, 3);	
		}
		catch(ProductNotFoundException pe)
		{
			System.err.println(pe);
		}
		catch(InvalidQuantityException iq)
		{
			System.err.println(iq);
		}
		shoppingCart.calculateCartValue();
		System.out.println("Total cart value after updating item with id 5 :" + shoppingCart.getCartValue());	
		try
		{
			shoppingCart.removeItemFromCart(4);	
		}
		catch(ProductNotFoundException pe)
		{
			System.err.println(pe);
		}
		shoppingCart.calculateCartValue();
		System.out.println("Total cart value after removing item with id 4:" + shoppingCart.getCartValue());		
		
		cartItems = shoppingCart.returnItems();		
		if (cartItems.isEmpty())
			System.out.println("Empty Cart!");
		else
			cartItems.forEach(System.out::println);
		
		shoppingCart.emptyCart();		
		
		
		// case 9 : add item and empty cart.	
		System.out.println("\n CASE 9");
		shoppingCart.addItemToCart(1);
		try
		{
			shoppingCart.addItemToCart(3, 3);
		}
		catch(InvalidQuantityException iq)
		{
			System.err.println(iq);
		}
		shoppingCart.setDiscount(50);
		shoppingCart.removeDiscount();
		shoppingCart.emptyCart();	
		shoppingCart.calculateCartValue();
		System.out.println("Total cart value for nineth case :" + shoppingCart.getCartValue());	
		cartItems = shoppingCart.returnItems();		
		if (cartItems.isEmpty())
			System.out.println("Empty Cart!");
		else
			cartItems.forEach(System.out::println);
		
		
		// case 10 : remove or update an item not existing in cart
		System.out.println("\n CASE 10");
		try
		{
			shoppingCart.addItemToCart(3, 4);
		}
		catch(InvalidQuantityException iq)
		{
			System.err.println(iq);
		}
		try
		{
			shoppingCart.addItemToCart(5, 2);
		}
		catch(InvalidQuantityException iq)
		{
			System.err.println(iq);
		}
		try
		{
			shoppingCart.removeItemFromCart(4);	
		}
		catch(ProductNotFoundException pe)
		{
			System.err.println(pe);
		}
		
		try
		{
			shoppingCart.updateItemQuanity(1, 3);	
		}
		catch(ProductNotFoundException pe)
		{
			System.err.println(pe);
		}
		catch(InvalidQuantityException iq)
		{
			System.err.println(iq);
		}
		shoppingCart.emptyCart();	
		
		
		// case 11 : add or update with an invalid quantity
		System.out.println("\n CASE 11");
		try
		{
			shoppingCart.addItemToCart(3, 4000);
		}
		catch(InvalidQuantityException iq)
		{
			System.err.println(iq);
		}
		
		try
		{
			shoppingCart.updateItemQuanity(1, 5000);	
		}
		catch(ProductNotFoundException pe)
		{
			System.err.println(pe);
		}
		catch(InvalidQuantityException iq)
		{
			System.err.println(iq);
		}
		shoppingCart.emptyCart();	
		
	}
}
