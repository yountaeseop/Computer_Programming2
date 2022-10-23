package Week2;

import java.util.Scanner;

// 1주차 실습 1번문제: 제품들중 최소가격, 최대가격 출력하기
public class Cote_1 {
    public static void main(String[] args) {
        Test test = new Test(12, "test");
        System.out.println(test); // 출력 결과 -> Week2.Product@7ef20235 | 클래스이름@16진수로 표시된 해시코드
        System.out.println(test.toString()); // 출력 결과 -> Week2.Product@7ef20235 | 클래스이름@16진수로 표시된 해시코드
        // -> 따라서 toString()함수를 항상 재정의 해줘야한다.

        Product product = new Product(12, "test");
        System.out.println(product.toString()); // override한 toString 적용

        // -> 실습문제 시작
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int n = Integer.parseInt(input); //제품 수

        Product[] p = new Product[n]; // 제품을 배열에 저장

        int min = 0;
        int max = 0;
        int maxIndex = 0;
        int minIndex = 0;

        for(int i = 0; i < n; i++){
            int price = sc.nextInt();
            String name = sc.nextLine().trim(); // trim으로 String 앞 뒤 공백제거
            p[i] = new Product(price, name);
            
            if (i == 0) { // 맨 처음 값을 비교기준으로 정한다.
                min = max = price; 
            } else {
            	if (price > max) { // 현재까지의 최댓값 max와 다음값 price와 비교
            		max = price;
            		maxIndex = i;
             	}   
            	if (price < min) { // 현재까지의 최솟값 min와 다음값 price와 비교
            		min = price;
            		minIndex = i;
            	}
            }
        }
        // 순우리말과 한자어가 결합한 합성어에서 뒷말의 첫소리가 된소리가 되면, 사이시옷을 쓴다.
        
        System.out.println("Min:" + p[minIndex]);
        System.out.println("Max:" + p[maxIndex]);
    }
}


class Test {
    int price;
    String name;

    public Test(int price, String name) {
        this.price = price;
        this.name = name;
    }
}

class Product {
    int price; // 가격
    String name; // 제품명

    public Product(int price, String name) { // 생성자
        this.price = price;
        this.name = name;
    }

    @Override
    public String toString() { // 간결하면서 사람이 읽기 쉬운 형태로 반환
        return String.format("[%d,\"%s\"]", price, name);
       // return ("[" + price + ",\"" + name + "\"]");
    }
}
