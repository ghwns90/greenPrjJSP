package my;

// 메소드부분을 자바 클래스로 따로 뺌

public class Calc {

	public int add(int v1, int v2) {
		
		return v1+v2;
	}
	public int subtract(int v1, int v2) {
		
		return v1-v2;
	}
	public int multiply(int v1, int v2) {
		
		return v1*v2;
	}
	public int divide(int v1, int v2) {
		if ( v2 == 0 ) return 1;
		return v1/v2;
	}
	
}
