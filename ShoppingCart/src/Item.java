
public class Item {

	private long id;
	private String manufacturer;
	private String desc;
	private int size;
	private String displayName;
	private double price;
	

	public Item(long id, String manufacturer, String desc, int size, String displayName, double price) {
		
		this.id = id;
		this.manufacturer = manufacturer;
		this.desc = desc;
		this.size = size;
		this.displayName = displayName;
		this.price = price;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (displayName == null) {
			if (other.displayName != null)
				return false;
		} else if (!displayName.equals(other.displayName))
			return false;
		if (id != other.id)
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (price != other.price)
			return false;
		if (size != other.size)
			return false;
		return true;
	}

	
	public String toString() {
		return "Item [id=" + id + ", manufacturer=" + manufacturer + ", desc=" + desc + ", size=" + size
				+ ", displayName=" + displayName + ", price=" + price + "]";
	}

	
}
