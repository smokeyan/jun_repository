package module;

public class Test {
	public static void main(String[] args) {
		Person person=new Person("小明");
		
		Tshirt ts=new Tshirt();
		BigTro big=new BigTro();
		
		
		ts.decorate(person);
		big.decorate(ts);
		
		big.show();
	}
}
