package com.kh.run;
/*
import com.kh.operator.LogicalNegation;
import com.kh.operator.InDecrease;
*/
import com.kh.operator.*; // * : 모든 것을 의미!
/*
 * 연산자 : 프로그램이 실행될 떄 연산을 도와주는 것들
 * - 우선순위, 연산방향 중요!
 * 1) 직접 접근 연산자 : . [] () {}
 * 2) 단항 연산자 : 부호 연산자(+, -) !(부정) 증감 연산자(++ --) (자료형) => 형변환
 * 3) 산술 연산자 : + - * / %
 * 4) 쉬프트 연산자 : >> << >>>
 * 5) 비교 연산자 : > < >= <= == !=
 * 6) 논리 연산자 : && || & ^ |
 * 7) 삼항 연산자 : (조건식) ? (조건이 참인 경우 사용할 값) : (조건이 거짓일 때 사용할 값)
 * 8) 대입 연산자 : = += -= *= /= %= <<= >>= >>>= &= ^= !=
 * 9) 나열 연산자 : , (a, b, c)
 */
public class OperatorRun {
	public static void main(String[] args) {
		LogicalNegation ln = new LogicalNegation();
//		ln.method();
		
		InDecrease id = new InDecrease();
//		id.method1();
//		id.method2();
//		id.method3();
		
		Arithmetic arith = new Arithmetic();
//		arith.method1();
//		arith.method2();
		
		Comparison com = new Comparison();
//		com.method();
		
		Logical logical = new Logical();
//		logical.method1();
//		logical.method2();
//		logical.method3();
		
		Triple triple = new Triple();
//		triple.method1();
		triple.method2();
	}
}








