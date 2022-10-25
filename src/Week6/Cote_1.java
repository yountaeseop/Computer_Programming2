package Week6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

// 문제
// 정수의 가격(price)와 문자열의 제품명(name)을 가진 제품이 있다.
// 그리고 제품 정보를 정렬하기 위한 프로그램의 일부 소스 코드가 있다.
// 제품 정보에 대해 가격과 제품명을 기준으로 각각 정렬하기 위해 소스 코드의 빈 부분을 채워 프로그램을 완성하시오.
public class Cote_1 {
	public static void main(String[] args) {
		List<Product> products = new ArrayList<Product>();
		
		products.add(new Product(200, "Product C"));
		products.add(new Product(100, "Product B"));
		products.add(new Product(300, "Product A"));
		
		Iterator i;
		
		Collections.sort(products); 
		// Comparable 인터페이스를 구현해야 사용이 가능하다.
		// 즉, compareTo메서드를 오버라이딩해야 List<Product>를 정렬할 수 있다.
		System.out.println("Sort by Price");
		i = products.iterator(); // Iterator 객체에 Products를 담고
		while (i.hasNext() == true) { // false가 나올때까지 반복 
			System.out.println(i.next()); // 요소 반환
		}
		
		Collections.sort(products, new ProdName());
		System.out.println("Sort by Name");
		i = products.iterator();
		while (i.hasNext() == true) { 
			System.out.println(i.next());
		}
	}
}

class Product implements Comparable<Product> {
	int price;
	String name;
	
	public Product(int price, String name) {
		this.price = price;
		this.name = name;
	}
	@Override
	public int compareTo(Product o) {
		return this.price - o.price;
	}
	public String toString() {
		return String.format("[%d,\"%s\"]", price, name);
	}
}

class ProdName implements Comparator<Product> {
	public int compare(Product prod1, Product prod2) {
		return prod1.name.compareTo(prod2.name);
		// 문자열을 비교할 때는 아스키코드의 차이값으로 반환한다.
	}
}


