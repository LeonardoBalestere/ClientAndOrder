package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.Ordertatus;

public class Order {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment = new Date();
	private Ordertatus status;

	private Client client;
	private List<Orderitem> items = new ArrayList<>();

	public Order() {
	}

	public Order(Date moment, Ordertatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public List<Orderitem> getItems() {
		return items;
	}

	public Ordertatus getStatus() {
		return status;
	}

	public void setStatus(Ordertatus status) {
		this.status = status;
	}

	public void addItem(Orderitem item) {
		items.add(item);
	}

	public void removeItem(Orderitem item) {
		items.remove(item);
	}

	public Double total() {
		double sum = 0.0;
		for (Orderitem i : items) {
			sum += i.subtotal();
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(sdf.format(moment) + "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client + "\n");
		sb.append("Order items:\n");
		for (Orderitem i: items) {
			sb.append(i+"\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f",total()));
		
		return sb.toString();
	}
		
}
