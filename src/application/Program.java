package application;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
	
		
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = Client.sdfM.parse(sc.nextLine());
	Client client = new Client(name, email, birthDate);	
		
	System.out.println("Enter order data: ");
	System.out.print("Status: ");
	OrderStatus status = OrderStatus.valueOf(sc.nextLine());
	System.out.println("How many items to this order? ");
	int n = sc.nextInt();
	Order order = new Order(new Date(), status, client);
	
	for(int i = 0; i < n; i++) {
		sc.nextLine();
		System.out.println("Enter #"+(i+1)+" item data:");
		System.out.print("Product name: ");
		String nameProduct = sc.nextLine();
		System.out.print("Product price: ");
		double price = sc.nextDouble();
		System.out.print("Quantity: ");
		int quantity = sc.nextInt();
	OrderItem item = new OrderItem(quantity, price, new Product(nameProduct, price));
	order.addItem(item);
	}
	
	System.out.println(order);
	sc.close();
	}
}
