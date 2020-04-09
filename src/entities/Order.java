package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	public static SimpleDateFormat sdfO = new SimpleDateFormat("dd/MM/yy hh:mm:ss");
	private Date moment;
	private OrderStatus status;
	
	private Client client;
	private List<OrderItem> orderItem = new ArrayList<>();
	
	public Order() {
		
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getOrderItem() {
		return orderItem;
	}
	
	public void addItem(OrderItem item) {
		orderItem.add(item);
	}
	
	public void removeItem(OrderItem item) {
		orderItem.remove(item);
	}
	
	public Double total() {
		double total = 0.0;
		for(OrderItem item : orderItem) {
			total += item.subTotal();
		}
		return total;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nORDER SUMMARY: ");
		sb.append("\nOrder moment: ");
		sb.append(sdfO.format(moment)+"\n");
		sb.append("Order Status: ");
		sb.append(status+"\n");
		sb.append("Client: ");
		sb.append(client + "\n");
		sb.append("Order items: \n");
		for(OrderItem o : orderItem) {
			sb.append(o.getProduct().getName()+", $"
					 +o.getProduct().getPrice()+", "
					 +"Quantity: "+o.getQuantity()+", "
					 +"Sobtotal: $"+o.subTotal()+"\n");
		}
		sb.append("Total price: "+total()); 
		
		return sb.toString();
	}
}
