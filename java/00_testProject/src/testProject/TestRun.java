package testProject;

public class TestRun {
	
	public static <T> void test(T t) {
		System.out.println(t);
	}

	public static void main(String[] args) {
		test("string");
		test(123);
	}

}
