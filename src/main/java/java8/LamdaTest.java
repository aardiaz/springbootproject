package java8;

interface Test {
	void print();
}

class TestImpl implements Test {

	@Override
	public void print() {
		System.out.println("form impl class");
	}

}

public class LamdaTest {

	public static void main(String[] args) {

		Test t1 = new TestImpl();
		t1.print();

//		Test t2 = new Test() {
//
//			@Override
//			public void print() {
//				 
//				System.out.println("from anynomous class");
//			}
//		};
//		
//		t2.print();

		Test t3 = () -> {
			System.out.println("from lamda ex..");
		};

		t3.print();
	}
}
