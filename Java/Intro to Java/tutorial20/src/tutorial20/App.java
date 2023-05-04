package tutorial20;

public class App {
	
	public static void main(String[] args) {
		Plant plant1= new Plant();
		Tree tree1= new Tree();
		plant1.grow();
		tree1.grow();
//		type of super class and refere to sub-class can access over-rided mthods but not original methods in sub-class
		Plant plant2= new Tree();
		plant2.grow();
		tree1.shedLeaves();
//		we can't make and object of type sub-class and refere to super class
//		Tree tree2= new Plant();
		doGrow(tree1);
		doGrow(plant1);
		doGrow(plant2);

		
	}
	
	public static void doGrow(Plant plant) {
		plant.grow();
	}
     

}
