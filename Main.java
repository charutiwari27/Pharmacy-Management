import java.util.Scanner ;

class Medicine 
{  
	
	String expDate; 

	String name; 
	
	String disease; 
	
	Double price,pri; 
	
	String type; 
	
	String code; 
	
	int qnty,q; 
	
	String alternate; 
	
	Medicine next; 
	
	Medicine rear, front, rc, lc; 
	

 

 
     //constructor
	Medicine(String name_, String disease_, Double price_, String type_, int qnty_, String expDate_, String code_, String alternate_)
	{ 

		name = name_; 
		
		disease = disease_; 
		
		price = price_; 
		
		qnty = qnty_; 
		
		expDate = expDate_; 
		
		code = code_; 
		
		alternate = alternate_; 
		
		type = type_; 
		
		rc = lc = null; 

	} //constructor finished

 

    Medicine(String name_, int q_,double pri_) //parameterized constructor

    { 

		name=name_; 
		
		q=q_; 
		
		pri=pri_; 

    } 

 

} //class Medicine finished

 

 

class Medicine_List 
{ 

	Scanner sc = new Scanner(System.in); 
	
	String cust_name;
	
	int age;
	
	int pay=0;
	
	long mob_number;
	
	String doc; 
	
	Medicine root; 
	
	Medicine root2; 
	
	double total_cost = 0.0; 

 

	Medicine_List()  //constructor
	
	{ 
	
		root = null; 
	
	} 

 

	void create(Medicine m) //passing medicine in the method
	{ 

		Medicine ptr; 

		if (root == null) // if tree is empty
		{ 

			root = m; 
		
		} 
		else 
		{ 
		
			ptr = root; // passing root value in ptr
		
			while (ptr != null)
			{ 
			
				if (m.name.compareTo(ptr.name) < 0)  //comparing medicine name to ptr name
				{ 
			
					if (ptr.lc == null) //connecting node to left child
					{ 
			
						ptr.lc = m; 
						
						break; 
			
					} 
					else
						
						ptr = ptr.lc; //traversal to next node
					
				} 
			
				if (m.name.compareTo(ptr.name) > 0) //comparing medicine name to ptr name
				{ 
			
					if (ptr.rc == null)   //connecting node to right child
					{ 
					
					ptr.rc = m; 
					
					break; 
					
					} 
					else 
					
					ptr = ptr.rc; //traversal to next node
					
				} 
			
			} 
		
		} 

	} //void create(Medicine m) finished
	
	
	

	void create_2(Medicine m) 
	{ 
	
		Medicine ptr;

	
		if (root2 == null) 
		{ 
		
			root2 = m; 
		
		} 
		else
		{ 
		
			ptr = root2; 
		
			while (ptr != null) 
			{ 
			
				if (m.name.compareTo(ptr.name) < 0) 
				{ 
				
				if (ptr.lc == null) 
				{ 
				
					ptr.lc = m; 
					
					break; 
				
				} 
				else 
			
					ptr = ptr.lc; 
		
				} 
	
				if (m.name.compareTo(ptr.name) > 0) 
				{ 
					
					if (ptr.rc == null) 
					{ 
				
					ptr.rc = m; 
					
					break; 
				
					} 
					else 
				
						ptr = ptr.rc; 
		
				} 
		
			} 
	
		} 
	
	} //void create_2(Medicine m)  finished

 

	
	
	void bill(Medicine r)
	{ 

		if (r == null) 
		{ 
			return; 
		} 
		else 
		{ 
		
			bill(r.lc); 
			
			System.out.printf("| %-10s\t| %-10s\t| %-8s \t|%n",r.name,r.q,r.pri); 
			
			System.out.printf("----------------------------------------------------%n"); 
			
			bill(r.rc); 
			
		} 
	
	
	} //void bill(Medicine r) finished
	
	
	

	 void bill_() //printing bill
	 {
		 	 System.out.println("*****  BILL  *****");
			 System.out.println();
			 System.out.println("-----------PHARMACY-----------");
			 System.out.println("     Address : Karvenagar   ");
			 System.out.println("NAME : "+cust_name);
			 System.out.println("AGE : "+age);
			 System.out.println("MOBILE NUMBER :"+mob_number);
			 
			 //to decide method of payment
			 if(pay==1) 
			 {
				 System.out.println("MODE OF PAYMENT : Online");
			 }
			 else
			 {
				 
				 System.out.println("MODE OF PAYMENT : Cash");
	
				 System.out.println("******************"); 
		
				 System.out.printf( "| %-10s\t| %-10s\t| %-8s \t|%n" ,"NAME","QUANTITY","AMOUNT" ); 
		
				 System.out.println("******************");
			 }
	 } //void bill_()  finished

	 
	 
	boolean search(Medicine r, String med) 
	
	{	
		if (r == null) 
		
		{ 
		
			System.out.println("Sorry! Medicine not available."); 
			
			return false; 
		
		} 
		
		if (r.name.equalsIgnoreCase(med)) 
		{ 
		
			if (med.equalsIgnoreCase("Restrol") || med.equalsIgnoreCase("Arteether") || med.equalsIgnoreCase("Xalatan")|| med.equalsIgnoreCase("Bleph") || med.equalsIgnoreCase("Griseofulvin"))
			{ //printing medicine details
				System.out.println("Enter Doctor's Name"); 
					
				doc = sc.next(); 
					
				System.out.println("Diagnosed for : " + r.disease); 
		
		    } 
			
		
			System.out.println("Medicine found\nName:" + r.name + "(" + r.type + ")" + "\t\tPrice:" + r.price); 
			
			System.out.println("Enter quantity:"); 
			
			r.q = sc.nextInt(); 
			//for quantity details
			if (r.qnty != 0 && r.qnty < r.q)  
			
			{ 
			
				System.out.println("Only " + r.qnty + " available"); 
				
				System.out.println(r.qnty + " added to bill"); 
				
				System.out.println("Sending " + r.name + " for restocking"); 
				
				Double pri = r.qnty * r.price; 
				
				total_cost += pri; 
				
				r.qnty = 0; 
				
			} 
			else if (r.qnty == 0) 
			{ 
			
				System.out.println("Medicine out of stock "); 
			
			} 
			
			else  
			{ 
			
				r.qnty = r.qnty - r.q; 
				
				Double pri = r.q * r.price; 
				
				Medicine m=new Medicine(r.name,r.q,(r.q*r.price)); 
				
				create_2(m); 
				
				
				System.out.println("Medicine added."); 
				
				display(m); 
				
				total_cost += pri; 
			
			} 
			
			 
			return true; 
		
		} 
		
		else if (r.name.compareTo(med) > 0) 
			
			return search(r.lc, med); 
		
		else 
		
			return search(r.rc, med); 
		
	} //boolean search(Medicine r, String med)  finished
	
	 

	boolean search2(Medicine r,String med) 
	
	{	 
	
		if(r==null) 
		
			return false;  
		
		if(r.name.equalsIgnoreCase(med)) 
		{ 
		
			create_2( r); 
			
			return true; 
		
		} 
		
		else if(r.name.compareTo(med)>0) 
		
			return search2(r.lc,med); 
		
		else 
		
			return  search2(r.rc,med); 
		
		 
	
	} //boolean search2(Medicine r,String med) finished
	
	

	 void create_customer() //input customer details
	 {
		 
		 System.out.println("Enter name of the customer :");
		 
		 cust_name = sc.next();
		 
		 System.out.println("Enter age of the customer :");
		 
		 age = sc.nextInt();
		 
		 System.out.println("Enter mobile number :");
		 
		 mob_number = sc.nextLong();
		 
		 System.out.println("Enter mode of Payment"); 
	
		 System.out.println("\n1. Online\n2. Cash"); 
	
		 pay = sc.nextInt(); 
	 }//void create_customer() finished
	 
	 

 //display after every med
	void display(Medicine m) 
	
	{	 
	
		System.out.println("Name : "+m.name); 
		System.out.println("Quantity:"+m.q); 
		System.out.println("Amount:"+m.pri); 
		
	 
	
	} //void display(Medicine m) finished

 
	
	

    void disp()  

    {  

	    System.out.printf("********************************%n" );  
	
	    System.out.printf("| %-10s\t| %-10s\t| %-8s | %-4s  | %-10s\t| %-10s | %-10s |%n","   NAME     ", "  DIAGNOSIS", "  PRICE", "QNTY", "  TYPE", "CODE", "EXPIRY DATE");  
	
	    System.out.printf( "********************************%n" );  
	
	    display_(root);  

    } // void disp()  finished

   

	void display_(Medicine r) 
	{ 
	    root = r; 
	    
	    if (r == null) 
	    { 
	    	return;
	    } 
	
	    display_(r.lc); 
	    
	  System.out.printf("| %-10s\t| %-10s\t| %-8s | %4s  | %-10s\t| %-10s | %-10s  |%n",r.name, r.disease, r.price, r.qnty, r.type, r.code, r.expDate); 
	
	  System.out.printf( "--------------------------------------------------------------------------------------------%n" ); 
	  display_(r.rc); 
	} //void display_(Medicine r)  finished
	
	

	void disp2()  
  	{  
        System.out.printf( "********************************%n" );  
	
	  	System.out. printf("| %-10s\t| %-10s\t| %-8s | %-4s  | %-10s\t| %-10s | %-10s |%n", "   NAME     ", "  DIAGNOSIS", "  PRICE", "QNTY", "  TYPE", "CODE","EXPIRY DATE");  
	
	  	System.out.printf("********************************%n" );  
	
	  	display2_(root2);  

  	} //void disp2()  finished

   

    void display2_(Medicine r)   //disp before ordering 1
    { 
	  
	  root2 = r; 
	  if (r == null) 
	  {
		  return; 
	  } 
	
	  display_(r.lc);
	  System.out. printf("| %-10s\t| %-10s\t| %-8s | %4s  | %-10s\t| %-10s | %-10s  |%n", r.name, r.disease, r.price, r.qnty, r.type, r.code, r.expDate); 
	
	  System.out.printf( "--------------------------------------------------------------------------------------------%n" );
	  display_(r.rc); 

   

     } //void display2_(Medicine r)  finished
    
    
  
    void disp2_show()  

	{  

		System.out.printf( "********************************%n" );  
		
		System.out.printf("| %-10s\t| %-10s\t| %-8s | %-4s  | %-10s\t| %-10s | %-10s |%n", "   NAME     ", "  DIAGNOSIS", "  PRICE", "QNTY", "  TYPE", "CODE", "EXPIRY DATE");  
		
		System.out.printf( "********************************%n" );  
		
		display2_show(root);  

	} //void disp2_show()  finished
    
    
    

	//display  before ordering 2
	void display2_show(Medicine r)
	{ 
		
		root = r; 
		
		if (r == null) 
		{
			return;
		} 
		
		display2_show(r.lc);
		
		System.out. printf("| %-10s\t| %-10s\t| %-8s | %4s  | %-10s\t| %-10s | %-10s  |%n", r.name, r.disease, r.price, r.qnty, r.type, r.code, r.expDate); 
		
		System.out.printf( "--------------------------------------------------------------------------------------------%n" );
		display2_show(r.rc); 
	
	} //void display2_show(Medicine r) finished
	
	
	

	void restock(Medicine root)
	{
		if(root==null)
		{
			return;
		}
		else
		{
			restock(root.lc);
			root.qnty=50;
			restock(root.rc);
		}
		
	}//void restock(Medicine root) finished
  
  
  
	void displayo(Medicine r) 
	{
	 
		  if (r == null) 
		  {
			  return;
		  }
		  else 
		  {
			  displayo(r.lc);
			  System.out.println("Name:" + r.name);
			  System.out.println("Diagonsed for:" + r.disease);
			  System.out.println("Individual price:" + r.price);
			  System.out.println("Mode of usuage:" + r.type);
			  System.out.println("Quantity:" + r.qnty);
			  System.out.println("Code:" + r.code);
			  System.out.println("Alternate:" + r.alternate);
			  System.out.println("********");
			  displayo(r.rc);
		  }
		  
	} //void displayo(Medicine r)  finished

	
	
	boolean search_med(Medicine r,String medi)
    {
		  if(r==null)
		  {	  
			  System.out.println("Sorry! Medicine not available");
			  return false;
		  }
		  else
		  {
			  if (r.name.equalsIgnoreCase(medi))
			  {	 
				  System.out.println("Medicine "+medi+ " is available");
				  System.out.println("Name:"+r.name);
				  System.out.println("Diagnosis:"+r.disease);
				  System.out.println("Mode of usage:"+r.type);
				  System.out.println("Price:"+r.price);
					  
			  
			  return true;
			  }
	
			   else if (r.name.compareTo(medi) > 0) 
		
				   return search_med(r.lc, medi); 
	
			   else 
		
				  return search_med(r.rc, medi); 
		  }
    }//boolean search_med(Medicine r,String medi)
  

	
} //class Medicine_List 

 

public class Pharmacy //main class
{ 

	Scanner sc1 = new Scanner(System.in); 
	
	public String cust_name; 
	
	public int age; 
	
	public long number; 
	
	public String gender; 

 
    //constructor
	Pharmacy(String cust_name, int age, long number, String gender) 
	{ 
	
		this.cust_name = cust_name; 
		
		this.age = age; 
		
		this.number = number; 
		
		this.gender = gender; 
	
	} 

 
    //creating object of child class
	Pharmacy ph1 = new Pharmacy(cust_name, age, number, gender); 

 

		public static void main(String args[]) 
		{ 

			Scanner sc1 = new Scanner(System.in); 
			
			Scanner sc2 = new Scanner(System.in); 
			
			Medicine_List o = new Medicine_List(); 
			
			int x; 
			int y;
			String med; 
			
			 
			//medicine details
			Medicine m1 = new Medicine("Solvin", "Cough", 62.46, "Capsule", 50, "23/09/2025", "e9k9vrwh", "Cheston Cold"); 
			
			Medicine m2 = new Medicine("Disnee", "Cold", 44.81, "Drops", 35, "12/07/2024", "o0z4rt3d", "Cocorex"); 
			
			Medicine m3 = new Medicine("Advil", "Fever", 65.0, "Tablet", 35, "17/09/2024", "ff1lu9vs", "Mortin"); 
			
			Medicine m4 = new Medicine("Asprin", "Headache", 89.97, "Tablet", 55, "16/11/2025", "w33avzz5", "Paracetamol"); 
			
			Medicine m5 = new Medicine("Liquiprin", "Stomach ache", 79.56, "Syrup", 30, "03/04/2023", "1cqwzone", "Panadol"); 
			
			Medicine m6 = new Medicine("Bleph", "Conjuctivitis", 75.98, "Eye Drops", 35, "15/12/2023", "281g0cq7", "Moxeza"); 
			
			Medicine m7 = new Medicine("Arteether", "Malaria", 36.72, "Injection", 38, "28/02/2022", "d444vb3", "Amther Inj"); 
			
			Medicine m8 = new Medicine("Xalatan", "Glaucoma", 130.42, "Eye Drops", 30, "09/05/2025", "myc3cs4x", "Travatan Z"); 
			
			Medicine m9 = new Medicine("Griseofulvin", "Ringworm", 85.90, "Cream", 35, "11/11/2023", "m8bpflzc", "Flucaonazole"); 
			
			Medicine m10 = new Medicine("Restrol", "Insonomia", 44.81, "Drops", 35, "06/01/2026", "o0z4rt3d", "Halcoin"); 
			
			 
			o.create(m1); 
			
			o.create(m2); 
			
			o.create(m3); 
			
			o.create(m4); 
			
			o.create(m5); 
			
			o.create(m6); 
			
			o.create(m7); 
			
			o.create(m8); 
			
			o.create(m9); 
			
			o.create(m10); 
			
			
			int ch; 
			do
			{
				System.out.println("-----MENU-----");
				System.out.println("0.Exit");
				System.out.println("1.Display Stock");
				System.out.println("2.Place an order for Customer ");
				System.out.println("3.Remaining stock of medicines");
				System.out.println("4.Search a medicine");
				System.out.println("5.Restock");
				System.out.println();
				
				
				System.out.println("Enter your choice :");
				ch = sc1.nextInt();
				
				//switch case
				switch(ch)
				{
				
					case 1:
						o.displayo(o.root);
						break;
						
					case 2:
						System.out.println();
						System.out.println("** CUSTOMER DETAILS ** ");
						o.create_customer();
						System.out.println("** MEDICINE **");
						
						do
						{ 
							 System.out.println("Enter the name of the medicine"); 
							  med = sc1.next(); 
						
							 o.search(o.root,med); 
							 System.out.println("\nEnter 1 to see final bill and amount or 0 to continue adding medicines"); 
							 x = sc2.nextInt(); 
					
						 }
						while(x==0); 
					
						System.out.println("Total Amount to be paid " + o.total_cost); 
					
					
						System.out.println("Payment Successful"); 
						o.bill_();
						o.bill(o.root2); 
					
						System.out.println("\t\t\t\t TOTAL:"+o.total_cost); 
					
						System.out.printf("----------------------------------------------------%n");
						
						break;
						
						
					case 3:
						System.out.println("** REMAINING STOCK **");
						o.displayo(o.root);
						break;
					
						
					case 4:
						System.out.println("Enter med to search");
					    String medi=sc1.next();
						o.search_med(o.root,medi);
						break;
						
						
					case 5:
						System.out.println("** RESTOCK **");
						o.restock(o.root);
						break;
						
										
					default :
						if(ch!=0)
						    System.out.println("Enter Invalid choice ");
				}
			}
			while(ch != 0);
			System.out.println("Program Terminated");
		} 
}

