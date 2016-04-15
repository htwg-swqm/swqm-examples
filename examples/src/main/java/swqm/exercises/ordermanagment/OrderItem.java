package swqm.exercises.ordermanagment;

public class OrderItem {
	private int itemId;
	private int number;
	private int salesPrice;
	
	public OrderItem(int itemId, int number, int salesPrice) {
		super();
		this.itemId = itemId;
		this.number = number;
		this.salesPrice = salesPrice;
	}

	public int getItemId() {
		return itemId;
	}

	public int getNumber() {
		return number;
	}

	public int getSalesPrice() {
		return salesPrice;
	}
	
	
}
