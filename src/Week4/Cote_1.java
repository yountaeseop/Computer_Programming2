package Week4;

import java.util.Scanner;
import java.util.Stack;

// 문제
// 동일한 괄호 깊이의 문자 출력
// 알파벳을 괄호 "("과 ")" 사이에 나열한 문자열이 있다.
// 이 문자열에서 주어진 괄호의 깊이에 해당하는 문자를 출력하는 프로그램을 완성하시오.
public class Cote_1 {
	public static void main(String[] args) {

		Stack stack = new Stack();
		Scanner sc = new Scanner(System.in);
		int step = sc.nextInt();
		String bracket = sc.nextLine().trim();
		int depth = Integer.parseInt(bracket);
		String input = sc.nextLine();

		switch (step) {
		case 1:
			System.out.println("Input:" + input);
			break;
		case 2:
			String Lowerinput = input.toLowerCase(); // 소문자로 변환해주는 함수
			System.out.println("Input:" + Lowerinput);
			break;
		case 3:
			System.out.println("Input:" + input);
			
			for (int i = 0; i < input.length(); ++i) {
				char c = input.charAt(i); // charAt() -> String 변수의 특정 자리수에
											// 담겨있는 글자를 char형으로 뽑아내는 함수
				if (c == '(') {
					stack.push(c);
				} else if (c == ')') {
					stack.pop();
				} else if (stack.size() == depth && Character.isLowerCase(c)) {
					// "("가 stack으로 한개씩들어갈때마다 size가 하나씩 커지고
					// ")"가 stack에서 한개씩 나올 때마다 size가 하나씩 줄어든다.
					System.out.print(c);
				}
			}
			break;
		case 4:
			System.out.println("Input:" + input);
			
			for (int i = 0; i < input.length(); i++) {
				char c = input.charAt(i); // charAt() -> String 변수의 특정 자리수에
				// 담겨있는 글자를 char형으로 뽑아내는 함수
				
				try {
					if (c == '(') {
						stack.push(c);
					} else if (c == ')') {
						stack.pop();
					} else if (stack.size() == depth && Character.isLowerCase(c)) {
						// "("가 stack으로 한개씩들어갈때마다 size가 하나씩 커지고
						// ")"가 stack에서 한개씩 나올 때마다 size가 하나씩 줄어든다.
						System.out.print(c);
					}
				} catch (Exception e) { // stack에서 괄호를 빼는데, 없을 경우 예외처리
					System.out.println("\nMismatch");
					return;
					// stack에서 pop을 할때 pop을할 데이터가 없으면 EmptyStackException이
					// 발생한다. 그런 상황을 대비해서 try catch로 예외처리를 해준다.
				}
			}
			
			System.out.println();
			
			if (stack.size() > 0) { // stack에서 괄호를 덜 뺀 경우 -> 괄호가 남아있음 즉, 
				                    // 짝이 맞지 않는 괄호가 존재한다는 뜻
				System.out.println("Mismatch");
			}
			
			break;
		default:
			break;
		}
	}
}

// 입력예제
//3 2
//(a(bc))
//
//[출력3]
//Input:(a(bc))
//bc
//
//4 1
//(a(bc)
//
//[출력4]
//Input:(a(bc)
//a
//Mismatch
//
//4 2
//(a(bc)))
//
//[출력5]
//bc
//Mismatch