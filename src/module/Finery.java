package module;

public class Finery extends Person{

	protected  Person componcent;
	
	public void decorate(Person componcent){
		this.componcent=componcent;
	}
		
	@Override
	public void show() {
		componcent.show();
	}
}
