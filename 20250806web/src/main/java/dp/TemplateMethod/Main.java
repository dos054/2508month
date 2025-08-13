package dp.TemplateMethod;

public class Main {

	public static void main(String[] args) {
		AbstractDisplay d1 = new CharDisplay('가');
		d1.display();
		
		d1= new StringDisplay("Hello");
		d1.display();
		
		d1= new StringDisplay("안녕");
		d1.display();
	}

}
