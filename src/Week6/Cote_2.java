package Week6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Cote_2 {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int pCount = sc.nextInt();
			int step = sc.nextInt();
			sc.nextLine();

			ProdBox<Product2> prodBox = new ProdBox<Product2>();

			for (int i = 0; i < pCount; i++) {
				int price = sc.nextInt();
				String name = sc.nextLine().trim();
				prodBox.add(new Product2(price, name));
			}
			System.out.println("INPUT:" + prodBox);

			if (step == 1) { return; }

			Collections.sort(prodBox, new ProdPrice()); // 가격으로 오름차순
			System.out.println("SORT By Price:" + prodBox);

			if (step == 2) { return; }

			Collections.sort(prodBox, new ProdName2()); // 이름으로 오름차순
			System.out.println("SORT By Name(A):" + prodBox);

			if (step == 3) { return; }

			Collections.reverse(prodBox); // 이름으로 내림차순
			System.out.println("SORT By Name(D):" + prodBox);

			if (step == 4) { return; }
		}
	}
}

class Product2 {
	int price;
	String name;

	Product2(int price, String name) {
		this.price = price;
		this.name = name;
	}

	public String toString() {
		return String.format("[%d,\"%s\"]", price, name);
		// return ("[" + price + ",\"" + name + "\"]");
	}
}

class ProdBox<T extends Product2> extends ArrayList<T> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String toString() {
		String s = "";
		for (int i = 0; i < size(); i++) {
			s += this.get(i);
		}
		return s;
	}
}

class ProdName2 implements Comparator<Product2> {
	@Override
	public int compare(Product2 o1, Product2 o2) {
		return o1.name.compareTo(o2.name);
	}
}

class ProdPrice implements Comparator<Product2> {
	@Override
	public int compare(Product2 o1, Product2 o2) {
		return o1.price - o2.price;
	}
}
