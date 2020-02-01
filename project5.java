import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
/**
 *The project5 class implements the other classes with the tree object.  first the 
 *class inputs the Countries4.csv and splits the data by the comma and the splits the data into 
 *separate fields and finds the GDP per Capita. It then traverses the tree inorder. 
 *Then it deletes Australia, Norway, and Tunisia. The traverses the tree with preorder
 *Next it searches for Sri Lanka, North Cyprus and, Tunisia. Then we delete 
 *Malawi, Somalia, Ireland, Greece and, Singapore. Then we traverse the tree in postOrder
 *and print the bottom 10 and top 10 countries by GDP per Capita.
 * 
 * @author <Chase Goodband>
 * @version<12/6/2019>
 * 
 *
 */
public class project5 {
	static HashTable h = new HashTable(311);

	public static void main(String[] args) throws NumberFormatException, IOException {
		FileInputStream fstream = new FileInputStream("Countries5.csv");
		 BufferedReader reader = new BufferedReader(new InputStreamReader(fstream));

		 String strLine = reader.readLine(); //Title line
		 
		 while ((strLine = reader.readLine()) != null)   {
			 String[] parts = strLine.split(Pattern.quote(","));
			 
			    String  name = parts[0];
			   String code = parts[1]; 
		       String capital = parts[2];
			   long population = Long.parseLong(parts[3]); 
		     double  gdp = Double.valueOf(parts[4]).doubleValue(); 
			    int hapRank = Integer.parseInt(parts[5]);
			    
			   
			    
			    
			    double gdpPerCapita = (gdp / population);
			    
			  // System.out.println(parts[0]);
			    
		h.insert(name, gdpPerCapita);	    

	}
		 
		 
		// h.displayTable();
		 //char ch = 'a';
		   // int i = ch;
		    //System.out.print(i);
		 
		//System.out.println(h.hashFunc("Belize"));
		//System.out.println(h.hashFunc("Democratic Republic of the Congo"));
		
		h.displayTable();
		System.out.println("");
		
		h.delete("Australia");
		h.delete("Tunisia");
		h.delete("Norway");
		System.out.println("");
		
		
		h.find("Sri Lanka");
		h.find("North Cyprus");
		h.find("Tunisia");
		System.out.println("");
		
		h.delete("Malawi");
		h.delete("Germany");
		h.delete("Ireland");
		h.delete("Greece");
		h.delete("Bolivia");
		System.out.println("");
		
		
		h.displayTable();
		System.out.println("");
		
		h.printFreeAndCollisions();
		
		    
		  

}

	
	
	
	
	
	
}
