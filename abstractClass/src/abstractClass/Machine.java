package abstractClass;

public abstract class Machine {
private int id;
	
	public void setID(int id) {
		this.id=id;
	}
	
	public int getID() {
		return this.id;
	}
	
	
	public abstract void start();
	public abstract void shutdown();
	
	public void run() {
		start();
		shutdown();
	}

}
