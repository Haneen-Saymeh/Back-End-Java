
public enum Animal {
	Cat("loki"), Dog("Fredp"), Mouse("Jerry");
	private String name;
	
	
	Animal(){
		
	}
	Animal(String name) {
		this.name=name;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "this animal name is: " + name;
	}
	
	

}
