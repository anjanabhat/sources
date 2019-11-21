import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CartChangeListener implements PropertyChangeListener {

	@Override
	public void propertyChange(PropertyChangeEvent event) 
	{
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		System.out.println(event.getPropertyName() + " at " + formatter.format(date));
	}
}
