/**
 * 
 * @author <Chase Goodband>
 * @version<12/6/2019>
 * 
 *
*/

public class HashTable {
/*
 * this class creates the node 
 */
	private class Node {  
		String name;
		double gdpPerCapita; 
		Node nextNode; 
/*
 * 		this is the node constructor. it creates the node
 * @param name this is the name for the country 
		 * @param gdpPerCapita this is the GDP per Capita for the country
 */
    public Node(String name, double gdpPerCapita) { 
    	this.name = name;
    	this.gdpPerCapita = gdpPerCapita;  
    	} 
 /*
  * this method prints the node
  */
    public void printNode() {  
    	System.out.printf("\t%-25s%,-20.2f\n", name, gdpPerCapita);  
    	}
    }
	
	
	int fcounter;
	int cCounter;
	
	 private linkList[] hashArray;
	 private int arraysize;
	/*
	 * this constructor creates the hash table and linked list
	 */
	public HashTable(int size)
	{
	arraysize = size;
	hashArray = new linkList[arraysize];
	for(int j = 0; j < arraysize; j++)
	{
		hashArray[j] = new linkList();
	}
	
	
	}
/*
 * this method creates the index with unicode from the country name
 * @param name this is the name for the country 
	
 */
	public int hashFunc(String name)
	{
		int sum = 0;
		int index = 0;
 
			 char [] chars = name.toCharArray();
			 for (int i = 0; i < name.length(); i++)
			 {
				 char ch = chars[i];
				 int u = ch;
				 
				 sum = sum + u;
				 
				 
			 }
			 index = sum % 311;
			 return index; 
			 
	}
	/*
	 * this method inserts the node into the hash tree
	 * @param name this is the name for the country 
		 * @param gdpPerCapita this is the GDP per Capita for the country
	 */
	public void insert(String name, double gdpPerCapita)
	{
		Node newNode = new Node(name, gdpPerCapita);
		int hashVal = hashFunc(name);
		hashArray[hashVal].insertEnd(newNode);	
	}
	/*
	 * this method finds the node into the hash tree
	 * @param name this is the name for the country 
	 */
	public double find(String name)
	{
		int hashVal = hashFunc(name);
		Node n = hashArray[hashVal].find(name);
		if(n == null)
		{
			System.out.println(name + " was not found ");
			return -1;
		}
		double thegdp = n.gdpPerCapita;
		System.out.println(name + " is found with a GDP per Capita of " + thegdp);
		return thegdp;
	}
	/*
	 * this method Deletes the node into the hash tree
	 * @param name this is the name for the country 
	 */
	public void delete(String name)
	{
		int hashVal = hashFunc(name);
	    hashArray[hashVal].delete(name);
		System.out.println(name + " has been deleted from the hash table!");
	}
	/*
	 * this method finds the empty spaces and collions in the hash tree
	 */
	public void printFreeAndCollisions()
	{
		for(int j=0; j < 311; j++)
		{
		  if(hashArray[j].isEmpty() == true) {
			  fcounter++;
		  }
		  if(hashArray[j].isEmpty() != true)
		  {
			  Node temp = hashArray[j].first;
			  while(temp.nextNode != null)
			  {
				  cCounter++;
				  temp = temp.nextNode;
			  }
		  }
		}
		System.out.println("Hash Table has " + fcounter + " empty spaces and " + cCounter + " Colisions");
	}
		
		
		//System.out.println(cCounter);
		
	/*
	 * this method prints the nodes in the hash tree
	 */
	public void displayTable()
	{
		
	
		System.out.println("Hash Table Content: ");
		for(int j=0; j < 311; j++)
		{
			System.out.print(j + ". ");
			hashArray[j].displaylist();
		}
			
	}
	
	
	
	
	

	 class linkList {
	
		private Node first;
		private Node last;
		
		public linkList() {
			first = null;
			last = null;
			
		}
		public boolean isEmpty()
		{
			return first == null;
		}
		/*
		 * this method inserts the node into the front of the linked list
		 */
		public void insertFront(Node d)       //insert at front of list 
		{
			    
			//d.next = first;                     //newLink -> old first 
			//first = d;             //first --> newLink
			
			
			if( isEmpty() )                    //if empty list
			{
				last = d;              //first --> newLink
			}
			else
			{
					d.nextNode = first;                //old last --> newLink
					
					first = d;
			}
			
			                      // newLin <-- last 
		}
		/**
		 * Inserts a country object at the end of the queue 
		 * @param d this is a country object 
		 */
		public void insertEnd(Node d)          //insert at end of list
		{
			
			if( isEmpty() )                    //if empty list
			{
				first = d;
				
			}
			else
			{
					last.nextNode = d;                   //old last --> newLink
					last = d;
					                     // newLin <-- last 
			}	
			last = d;  
		}
		
		
		/*
		 * this method prints the node in the hash tree
		 */		
		public void displaylist()
		{
			
			Node current = first;
			if(current == null)
			{
				System.out.println("\tEmpty");
			}
			
			while(current != null)
			{
				current.printNode();
				current = current.nextNode;
			}
			System.out.println("");
		}
		/*
		 * this method finds the node in the hash tree
		 * @param name this is the name for the country 
		 */		
		public Node find(String name)
		{
			Node current = first;
			
			while( current != null)
			{
				if(current.name.compareTo(name) == 0)
				{
					return current;
				}
				current = current.nextNode;
			}
			return null;
		}
		/*
		 * this method Deletes the node in the hash tree
		 * @param name this is the name for the country 
		 */
		public void delete(String name)
		{
			Node previous = null;
			Node current = first;
			
			while(current != null && current.name.compareTo(name) != 0)
			{
				
				previous = current;
				current = current.nextNode;
			}
			if(previous == null)
			{
				first = first.nextNode;
			}
			else
			{
				previous.nextNode = current.nextNode;
			}
			
		}
	
	
}
}

