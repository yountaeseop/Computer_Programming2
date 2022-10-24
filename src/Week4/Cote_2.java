package Week4;

import java.util.ArrayList;
import java.util.Scanner;

// 문제
// 정수값의 가격(price)와 문자열의 제품명(name)을 가진 제품 정보를 ArrayList에 입력하고, 
// 최소 가격의 제품을 찾는 프로그램과 전체 제품을 가격순 (오름차순)으로 정렬하는 프로그램을 완성하시오.

public class Cote_2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int productCount = sc.nextInt();
		int step = sc.nextInt();
		sc.nextLine();

		ArrayList<Product> products = new ArrayList<Product>(productCount);

		for (int i = 0; i < productCount; i++) {
			int price = sc.nextInt();
			String name = sc.nextLine().trim();
			
			Product p = new Product(price, name);
			
			products.add(p);
		}
		
		switch (step) {
		case 1:
			System.out.println(products);
			
			break;
		case 2:
			Product minProduct = findMinProduct(products);
			System.out.println(minProduct);
			
			break;
		case 3:
			minSortProduct(products);
			
			break;
		}
	}
	
	private static void minSortProduct(ArrayList<Product> products) {
		// 작은 것 부터 순서대로 정렬시키기
		for (int i = 0; i < products.size() - 1; ++i) {
			for (int j = i + 1; j < products.size(); ++j) {
				if(products.get(j).compareTo(products.get(i)) < 0) {
					swap(products, i, j);
				}
			}
		}
		System.out.println(products);
	}

	private static void swap(ArrayList<Product> products, int i, int j) {
		Product p = products.get(j);
		products.set(j, products.get(i));
		products.set(i, p);
	}

	private static Product findMinProduct(ArrayList<Product> products) {
		int min = 0;
		int minIndex = 0;
		
		for (int i = 0; i < products.size(); i++) {
			if (i == 0) {
				min = products.get(0).price;
			} else {
				if (min > products.get(i).price ) {
					min = products.get(i).price;
					minIndex = i;
				}
			}
		}
		
		return products.get(minIndex);
	}
}

interface Comparable<T> {
	public int compareTo(Product o);
	// Comparable 인터페이스를 쓰려면 compareTo메소드를 구현해야한다.
	// 왜 쓰는 것인가? -> "객체 자체를 비교할 수 있도록 만든다." 이거 하나만 생각하자!!!
	// 본질적으로 객체는 사용자가 기준을 정해주지 않는 이상 어떤 객체가 더 높은 우선순위를 갖는지 판단 할 수가 없다.
	// 이걸 해결하기 위해서 Comparable 또는 Comparator가 쓰이는 것임
	// Comparable은 "자기 자신과 매개변수 객체를 비교"하는 것이고, 
	// Comparator는 "두 매개변수 객체를 비교"하는 것
}

class Product implements Comparable<Product> {
	int price; // 제품가격
	String name; // 제품이름

	public Product(int price, String name) {
		this.price = price;
		this.name = name;
	}

	public int compareTo(Product o) {
		return (this.price < o.price ? -1 :(this.price == o.price ? 0 : 1));
		//return this.price - o.price; -> 이렇게 해도 가능!!!
		// 위의 식을 풀어서 보면 compareTo메소드 자체적으로 밑의 식 처럼 반환한다.
		// 단, 빼기와 더하기를 하면서 Overflow 혹은 Underflow가 발생할 여지가 있기 때문에
		// 예외를 확인하기 어렵다면 <,>,==으로 대소비교를 해주는 것이 안전하고 일반적으로 권장되는 방식이다.
	}

	@Override
	public String toString() {
		return String.format("[%d,\"%s\"]", price, name);
	}
	// -> ArrayList는 전체출력을 할때 기본적으로 전체 []가 감싸져서 나온다
	// 출력요소가 하나일때는 []가 없이 toString에만 적용돼서 출력된다.
	// toString에는 문제 x
}