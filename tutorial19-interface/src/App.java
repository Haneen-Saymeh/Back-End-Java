
public class App {

	public static void main(String[] args) {
		Person person1= new Person("Thor");
		Machine machine1= new Machine("destroyer");
		person1.showInfo();
		machine1.showInfo();
		
//		can't access other original class method tho
		Info info1= new Person("Tony");
		info1.showInfo();

	}

}
