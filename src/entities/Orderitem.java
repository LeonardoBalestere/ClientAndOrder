package entities;

public class Orderitem {
	private Integer quantity;
	private Double price;
	private Product product;
	
	public Orderitem() {
	}

	public Orderitem(Integer quatity, Double price, Product product) {
		this.quantity = quatity;
		this.price = price;
		this.product = product;
	}

	public Integer getQuatity() {
		return quantity;
	}

	public void setQuatity(Integer quatity) {
		this.quantity = quatity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Double subtotal() {
		return price * quantity;
	}

	@Override
	public String toString() {
		return product.getName()
			 + ", $"
			 + String.format("%.2f", price)
			 + ", Quantity: "
			 + quantity
			 + ", Subtotal:"
			 + String.format("%.2f", subtotal());
	}

}
