package tutorial10;

public class application {

	public static void main(String[] args) {
		int[] values;
		values=new int[3];
		values[0]=6;
		values[1]=66;
		values[2]=666;
		
		for(int i=0; i <values.length;i++) {
			System.out.println("number is "+ values[i]);
		}
		
		int[] numbers= {5,6,7,8,9};
		for (int i =0; i <numbers.length;i++) {
			System.out.println("number is "+ numbers[i]);
		}
		
		String[] fruits= {"apple", "banana", "organge"};
		
		for (String fruit: fruits) {
			System.out.println(fruit);
		}
		
        String[] texts=new String[3];
        System.out.println(texts[1]);
        
        
        int [][] grid= {
        		{5,6,7},
        		{2,3,4},
        		{8,9,10}
        };
        
        System.out.println(grid[1][1]);
        System.out.println(grid[2][1]);
        
        String[][] words=new String[2][3];
        words[0][1]="Hello";
        System.out.println(words[0][1]);
        
        for (int row=0; row<grid.length;row++) {
        	for(int col=0;col<grid[row].length;col++) {
        		System.out.print(grid[row][col]+"\t");
        	}
        	System.out.println();
        }
        
//        not defining col for the array, then we select a row and define individual col
        String [][] quotes=new String[2][];
        quotes[0]=new String[3];
        quotes[0][2]="hiiz";
        System.out.println(quotes[0][2]);
        

	}

}
