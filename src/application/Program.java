package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.Orderitem;
import entities.Product;
import entities.enums.Ordertatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date nowdata = new Date();

		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		String date = sc.nextLine();

		Client client = new Client(name, email, sdf.parse(date));

		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String sstatus = sc.nextLine();

		Order order = new Order(nowdata, Ordertatus.valueOf(sstatus), client);

		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			sc.nextLine();
			System.out.println("Enter #" + (i + 1) + " item data:");
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int productquantity = sc.nextInt();
			Product product = new Product(productName, productPrice);
			Orderitem item = new Orderitem(productquantity, productPrice, product);
			order.addItem(item);
		}
		System.out.println();
		System.out.println("ORDER SUMARRY:");
		System.out.println(order);
		
		sc.close();
	}

}
