package Week2;

import java.util.Scanner;

interface Comparable {
    public int compareTo(Object o);
}
abstract class Product {
    abstract public String toString();

    int price; // 가격
    String name; // 제품명

    public Product(int price, String name) { // 생성자
        this.price = price;
        this.name = name;
    }
}
class TV extends Product implements Comparable{
    double taxPrice;
    TV (int price, double taxRate, String name) throws Exception {
        super(price, name); // Product 생성자 호출

        if (taxRate <= 0.0 || taxRate >= 1.0) {
            throw new Exception("Wrong Input"); // 예외 발생
        }
        this.taxPrice = price * (1. + taxRate);
    }
    public String toString(){ // c.f., 추상 클래스 Product
        return String.format("[%d,\"%s\"]", Math.round(taxPrice), name);
        // Math.round() -> 반올림하는 함수
        // return ("[" + (int)taxPrice + ",\"" + name + "\"]");
        // 실수값을 정수값으로 변환시 소수점 이하 버림
    }
    public  int compareTo(Object o){ // c.f., 인터페이스 Comparable
    	// compareTo 매서드
    	// 반환값이 -1이면 기준비교값이 비교대상값보다 작음
    	// 반환값이 0이면 기준비교값이 비교대상값과 같음
    	// 반환값이 1이면 기준비교값이 비교대상값보다 큼
        return (this.taxPrice < ((TV)o).taxPrice ? -1 :(this.taxPrice == ((TV)o).taxPrice ? 0 : 1));
        // Object o 타입캐스팅
        // 삼항 연산자
        // ex -> int a = (5 < 4) ? 50 : 40;
        //                 조건문  ?  참 : 거짓
    }
}
public class Cote_2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int n = Integer.parseInt(input); //제품 수
        int index = 0; // product 인덱스

        Product[] p = new Product[n]; // 제품을 배열에 저장

        for (int i = 0; i < n; ++i) {
            try {
                int price = sc.nextInt();
                double taxRate = sc.nextDouble();
                String name = sc.nextLine().trim();

                p[index] = new TV(price, taxRate, name);
                if (((TV)p[index]).compareTo((TV)p[0]) >= 0) // 기준비교값이 비교대상값과 같거나 클때 index를 1씩증가
                    ++index;                                 // 즉, 첫번째 제품의 세금 포함 가격보다 비싼제품을 출력
            } catch (Exception e) {
                System.out.println(e.getMessage());
                --i; // 예외 발생 입력을 무시 >>> 예외가 발생하면 예외발생한 건은 카운트하지 않음.
            }
        }
        for (int i = 0; i < index; ++i) {
            System.out.println("TV[" + i + "]:" + p[i]);
        }
    }
}

// 입출력문 예시
//[입력]
//3
//200000 0.1 TV Model 10
//200000 0.0 TV Model 20 -> 여기서 Wrong Input 발생
//200000 0.3 TV Model 20
//100000 0.2 TV Model 30
//
//[출력]
//Wrong Input
//TV[0]:[220000,"TV Model 10"]
//TV[1]:[260000,"TV Model 20"]