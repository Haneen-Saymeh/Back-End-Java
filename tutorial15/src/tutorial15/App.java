package tutorial15;
class Thing{
	public static final int luckyNo=666;
	public static int count;
	public String name;
	public static String desc;
	public int id;
	
	public Thing() {
		id=count;
		count++;
	}
	
	public void showName() {
		System.out.println(name + ":" + desc);
	}
	
	public static void showInfo() {
		System.out.println("This is our information!"+":"+ desc);
	}
	
}

public class App {

	public static void main(String[] args) {
		System.out.println("number of objects before: "+ Thing.count);
		Thing thing1=new Thing();
		Thing thing2= new Thing();
		Thing thing3= new Thing();
		thing1.name="something";
		Thing.desc="this is a thing";
		Thing.showInfo();
		thing1.showName();
		System.out.println(thing1.luckyNo);
		System.out.println("number of objects after: "+ Thing.count);
		System.out.println(thing1.id);


	}

}
