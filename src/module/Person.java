package module;

public class Person {
	
	public Person(){
		
	}
	
	private String name;
	
	public Person(String name){
		this.name=name;
	}
	
	public void show(){
		System.out.println("打扮的"+name);
	}
}
