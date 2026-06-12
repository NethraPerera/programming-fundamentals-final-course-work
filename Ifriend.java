import java.util.*;
class Ifriend{
	public static Scanner input=new Scanner(System.in);
	public static Random ran=new Random();
	
	//public static int currentContactID=0;	// to genenate a contact id(in createContactID() function)
	public static int currentContactID=0;
	// creating global arrays
	
	public static String [] contactIDs=new String [0];
	public static String [] names=new String [0];
	public static String [] phoneNumbers=new String [0];
	public static String [] companyNames=new String [0];
	public static int[][]birthDays=new int[0][];
	public static int [] salaries=new int [0];
	
	// creating temporarily using globle arrays for the 'List Contant' option
	public static String [] tempContactIDs=new String [0];
	public static String [] tempNames=new String [0];
	public static String [] tempPhoneNumbers=new String [0];
	public static String [] tempCompanyNames=new String [0];
	public static int [][] tempBirthDays=new int[0][0];
	public static int [] tempSalaries=new int [0];
	/*
	public static String [] contactIDs={"C0001","C0002","C0003","C0004"};
	public static String [] names={"Nethra","Shithila","Esanda","Perera"};
	public static String [] phoneNumbers={"0123456798","0987654312","0123456789","0987654321"};
	public static String [] companyNames={"fff","ddd","sss","aaa"};
	public static int[][]birthDays={{2020,10,18},{1999,1,31},{2000,2,13},{2004,9,23}};
	//public static int[][]birthDays=new int[0][0];
	public static int[] salaries={21000,56000,43000,78000};
	*/
	
	// increment String arrays
	public static String[] increment(String [] ar,String temp1){
		String[]temp =new String[ar.length+1];
		
		for (int i = 0; i < ar.length; i++){
			temp[i]=ar[i];
		}
		temp[temp.length-1]=temp1;
		return temp;
	}
	// increment Integer arrays
	public static int[] increment(int [] ar,int temp1){
		int[]temp =new int[ar.length+1];
		for (int i = 0; i < ar.length; i++){
			temp[i]=ar[i];
		}
		temp[temp.length-1]=temp1;
		return temp;
	}
	// increment 2D Integer arrays
	public static int[][] increment(int [][]ar,int []temp1){
		int[][]temp =new int[ar.length+1][];
		
		for (int i = 0; i < ar.length; i++){
			temp[i]=ar[i];
		}
		temp[temp.length-1]=temp1;
		return temp;
	}
	//----------------- clear The Last  Few Lines-----------------
	public static void clearTheLastFewLines(int numOfLines) {

        // Move the cursor up +(numOfLines)+ lines
        System.out.print("\033[" + numOfLines + "A");
        // Clear the lines
        System.out.print("\033[0J");
    }
	
	//----------------- clear Command Line Interface-----------------
    public static void clearCommandLineInterface() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace(); // Handle any exceptions.
        }
    }
	
	//============= main method =====================
	public static void main(String args[]){
		
		commandLineInterface();
	}
	public static void commandLineInterface(){
		L1:do{
			System.out.println("\t\t\t+-------------------------------------------------------+");
			System.out.println("\t\t\t|================\tIFRIEND\t\t================|");
			System.out.println("\t\t\t+-------------------------------------------------------+\n\n\n");
			System.out.println("\t\t------->>\tContacts Organizer\t<<-------\n\n");
			
			System.out.println("[01] ADD Contacts");
			System.out.println("[02] UPDATE Contacts");
			System.out.println("[03] DELETE Contacts");
			System.out.println("[04] SEARCH Contacts");
			System.out.println("[05] LIST Contacts");
			System.out.println("[06] Exit");
			
			System.out.print("\n\nEnter an option to continue ->\t");
			int option=input.nextInt();
			
			switch (option){
				case 1:
					clearCommandLineInterface();
					addContacts();
					break;
				
				case 2:
					clearCommandLineInterface();
					updateContacts();
					break;
				case 3:
					clearCommandLineInterface();
					deleteContacts();
					break;
				case 4:
					clearCommandLineInterface();
					searchContacts();
					break;
				case 5:
					clearCommandLineInterface();
					listContacts();
					break;
				case 6:
					clearCommandLineInterface();
					System.exit(0);
				default:
					clearCommandLineInterface();
					continue L1;
					
			}
		}while(true);
		
	}
	//****************************************************************************************
	//=============== [1]Add Contacts =================
	public static void addContacts(){
		L1:do{	
			System.out.println("+----------------------------------+");
			System.out.println("|\tAdd contacts to the list   |");
			System.out.println("+----------------------------------+");
			
			// create contactID
			String contactID=createContactID(currentContactID);
			System.out.println("\t\t"+contactID);
			System.out.println("\t\t=====");
			
			// insert name
			System.out.print("Name \t\t:\t");
			String name=input.next();
			
			// insert phonenumber
			String phoneNumber="";
			L2:do{
				System.out.print("Phone Number \t:\t");
				phoneNumber=input.next();
				boolean isValid=isValidPhoneNumber(phoneNumber);
				
				L5:if(!isValid){
					System.out.println("Invalid phone number.....");
					System.out.print("Do you want to add phone numbaer again?(Y/N ):");
					String yn=input.next();
					if(yn.equalsIgnoreCase("Y")){
						clearTheLastFewLines(3);
						continue L2;
					}else if (yn.equalsIgnoreCase("N")){
						clearCommandLineInterface();
						commandLineInterface();
					}
					clearTheLastFewLines(3);
					continue L2;
				}
				break;
			}while(true);
			
			// insert company name
			System.out.print("Company Name \t:\t");
			String companyName=input.next();
			
			// insert salary
			int salary=0;
			L3:do{
				System.out.print("Salary\t\t:\t");
				salary=input.nextInt();
				boolean isValid=isPositive(salary);
				if (isValid){
					clearTheLastFewLines(1);
					continue L3;
				}
				break;
			}while(true);
			
			// insert birthday
			int[] birthDay=new int[3];
			L4:do{	
				System.out.println("B'Day(YYYY-MM-DD):\t");
				System.out.print("Year:\t");
				birthDay[0]=input.nextInt();
				System.out.print("Month:\t");
				birthDay[1]=input.nextInt();
				System.out.print("Date:\t");
				birthDay[2]=input.nextInt();
				boolean isValid=isValidBirthday(birthDay);
				if (!isValid){
					clearTheLastFewLines(4);
					continue L4;
				}
				break;
				
			}while(true);
			
			//*******************add contacts to arrays***************************************
			/*
			contactIDs=increment(contactIDs,contactID);
			names=increment(names,name);
			phoneNumbers=increment(phoneNumbers,phoneNumber);
			companyNames=increment(companyNames,companyName);
			salaries=increment(salaries,salary);
			birthDays=increment(birthDays,birthDay);
			*/
			
			contactIDs=increment(contactIDs,contactID);
			names=increment(names,name);
			phoneNumbers=increment(phoneNumbers,phoneNumber);
			companyNames=increment(companyNames,companyName);
			salaries=increment(salaries,salary);
			birthDays=increment(birthDays,birthDay);
			
			System.out.println("\n\n\n\t\tContact has added sucessfully\n\n");
			L6:do{
					System.out.print("Do you want to add another contact?(Y/N ):");
					String yn=input.next();
					if(yn.equalsIgnoreCase("Y")){
						clearCommandLineInterface();
						currentContactID++;
						continue L1;
					}else if (yn.equalsIgnoreCase("N")){
						
						clearCommandLineInterface();
						commandLineInterface();
					}
					clearTheLastFewLines(3);
					continue L6;
				
			} while (true);
			
			
		}while(true);	
	}
	// -------------- [1.1] Create contactID	--------------
	public static String createContactID(int currentContactID){
		currentContactID+=1;
		return String.format("C%04d",currentContactID);
	}
	// -------------- [1.2] check valid phonenumbers	--------------
	public static boolean isValidPhoneNumber(String phoneNumber){
		if(phoneNumber.length() !=10 ){
			return false;
		} 
		if (phoneNumber.charAt(0)!='0'){ // check whether the first number is 0 or not
			return false;
		}
		for (int i = 1; i < phoneNumber.length(); i++){// make sure only numbers contain in the phone number
			if( !Character.isDigit(phoneNumber.charAt(i)) ){
				return false;
			}
		}
		return true;
	}	
	// -------------- [1.3] check positive numbers	--------------
	public static boolean isPositive(int salary){
		return salary <0;
	}
	// -------------- [1.4] check valid birthday	--------------
	public static boolean isValidBirthday(int[] birthDay){
		
		if (birthDay[0]<1900 || birthDay[0]>2026){
			return false;
		}
		if (birthDay[1]<1 || birthDay[1]>12){
			return false;
		}
		int days=0;
		switch (birthDay[1]){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				days=31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				days=30;
				break;
			default:
				days=28;
		}
		if (birthDay[2]>days||birthDay[2]<1){
			return false;
		}
		return true;
		
	}
		
	//****************************************************************************************
	//=============== [2]Update Contacts =================
	public static void updateContacts(){
		
		L1:do{	
			System.out.println("+-------------------------------+");
			System.out.println("|\tUpdate contacts\t\t|");
			System.out.println("+-------------------------------+");
		
			// calling 'searchIndexOfContact()'method and find the index of the contact
			int indexOfContact=searchIndexOfContact();
			
			// if the name or phone number is invalid
			if (indexOfContact<0){
				L2:do{	
					System.out.println("Invalid name or phone number.....");
					System.out.print("Do you want to add phone numbaer again?(Y/N ):");
					String yn=input.next();
					if(yn.equalsIgnoreCase("Y")){
						clearCommandLineInterface();
						continue L1;
					}else if (yn.equalsIgnoreCase("N")){
						clearCommandLineInterface();
						commandLineInterface();
					}
					clearTheLastFewLines(3);
					continue L2;
					
				}while(true);
			}
			//show contact details
			showContactDetails(indexOfContact);
			
			
			System.out.println("\n\nWhat do you want to update.....");
					
			System.out.println("[01] Name");
			System.out.println("[02] Phone Number");
			System.out.println("[03] Company Name");
			System.out.println("[04] Salary");
			
			System.out.print("\n\nEnter an ooption to update ->\t");
			int option=input.nextInt();

			// update the contact
			switch (option){
				case 1:
					clearTheLastFewLines(9);
					System.out.println("\tUpdate Name");
					System.out.println("\t===========\n\n");
					System.out.print("Enter new name\t:\t");
					String name=input.next();
						
					names[indexOfContact]=name;
						
					System.out.println("\tContact has been updated......");
					break;
				case 2:
					clearTheLastFewLines(9);
					System.out.println("\tUpdate Phone Number");
					System.out.println("\t===================\n\n");
					System.out.print("Enter new Phone Number\t:\t");
					String phoneNumber=input.next();
						
					phoneNumbers[indexOfContact]=phoneNumber;
						
					System.out.println("\tContact has been updated......");
					break;
				case 3:
					clearTheLastFewLines(9);
					System.out.println("\tUpdate Company Name");
					System.out.println("\t===================\n\n");
					System.out.print("Enter new Company Name\t:\t");
					String companyName=input.next();
						
					companyNames[indexOfContact]=companyName;
						
					System.out.println("\tContact has been updated......");
					break;
				case 4:
					clearTheLastFewLines(9);
					System.out.println("\tUpdate Salary");
					System.out.println("\t=============\n\n");
					System.out.print("Enter new Salary\t:\t");
					int salary=input.nextInt();
						
					salaries[indexOfContact]=salary;
						
					System.out.println("\tContact has been updated......");
					break;
				default:
					System.out.println("invalid option........");
						break;	
			}
				
			L3:do{	
				System.out.print("Do you want to update another contact?(Y/N ):");
				String yn=input.next();
				if(yn.equalsIgnoreCase("Y")){
					clearCommandLineInterface();
					continue L1;
				}else if (yn.equalsIgnoreCase("N")){
					clearCommandLineInterface();
					commandLineInterface();
				}
				clearTheLastFewLines(1);
				continue L3;					
			}while(true);
			
		}while(true);
	}	
	
	//------[2.1]search Index Of Contact by searching name and phone number-----------
	public static int searchIndexOfContact(){
		
		System.out.print("\nSearch contact by Name or Phone Number \t:\t");
		String nameOrPhoneNumber=input.next();
		
		int indexOfContact=-1;
		
		//search the contact phone numbers and find the index of the contact
		boolean isValid=false;
		if (indexOfContact<0){
			isValid=isValidPhoneNumber(nameOrPhoneNumber);
		}
		if (isValid){
			for (int i = 0; i < phoneNumbers.length; i++){
				if (nameOrPhoneNumber.equalsIgnoreCase(phoneNumbers[i])){
					indexOfContact=i;
				}
			}
		}
		//search the contact names and find the index of the contact
		for (int i = 0; i < names.length; i++){
			if (nameOrPhoneNumber.equalsIgnoreCase(names[i])){					
				indexOfContact=i;
			}
		}
		if (indexOfContact<0){
			System.out.println("\nno contact found for "+nameOrPhoneNumber);
		}
		return indexOfContact;
	}	
	
	//------[2.2] show Contact Details-----------
	public static void showContactDetails(int indexOfContact){
		System.out.println("\n\nContact ID\t:"+contactIDs[indexOfContact]);
		System.out.println("Name\t\t:"+names[indexOfContact]);
		System.out.println("Phone Number\t:"+phoneNumbers[indexOfContact]);
		System.out.println("Company Name\t:"+companyNames[indexOfContact]);
		System.out.println("Salary\t\t:"+salaries[indexOfContact]);
		System.out.println("B'day\t\t:"+birthDays[indexOfContact][0]+"-"+birthDays[indexOfContact][1]+"-"+birthDays[indexOfContact][2]);
			
	}
	
	//****************************************************************************************
	//=============== [3]Delete Contacts =================
	public static void deleteContacts(){
		
		L1:do{
			System.out.println("+-------------------------------+");
			System.out.println("|\tDelete contacts\t\t|");
			System.out.println("+-------------------------------+");
			
			// calling 'searchIndexOfContact()'method and find the index of the contact
			int indexOfContact=searchIndexOfContact();
				
			//if that is an invalid contact
			if (indexOfContact<0){
				L2:do{	
					System.out.println("Invalid name or phone number.....");
					System.out.print("Do you want to add phone numbaer again?(Y/N ):");
					String yn=input.next();
					if(yn.equalsIgnoreCase("Y")){
						clearCommandLineInterface();
						continue L1;
					}else if (yn.equalsIgnoreCase("N")){
						clearCommandLineInterface();
						commandLineInterface();
					}
					clearTheLastFewLines(3);
					continue L2;
					
				}while(true);
			}
				
			//show contact details
			showContactDetails(indexOfContact);
			
			L3:do{	
				System.out.print("\n\nDo you want to Delete this contact?(Y/N ):");
				String yn=input.next();
				if(yn.equalsIgnoreCase("Y")){
					
					//delete the contact
					removeContacts(indexOfContact);
					
					System.out.println("The contact has been deleted sucessfuly......");
					break;
				}else if (yn.equalsIgnoreCase("N")){
					clearCommandLineInterface();
					commandLineInterface();
				}
				clearTheLastFewLines(2);
				continue L3;
					
			}while(true);
			
			L4:do{	
				System.out.print("\n\nDo you want to Delete this contact?(Y/N ):");
				String yn=input.next();
				if(yn.equalsIgnoreCase("Y")){
					clearCommandLineInterface();
					continue L1;
				}else if (yn.equalsIgnoreCase("N")){
					clearCommandLineInterface();
					commandLineInterface();
				}
				clearTheLastFewLines(2);
				continue L4;
					
			}while(true);		
		}while(true);
	}
	
	//-----------------[3.1] Deleting Contacts ------------------------
	public static void removeContacts(int indexOfContact){
		String [] tempContactIDs=new String [contactIDs.length-1];
		String [] tempNames=new String [names.length-1];
		String [] tempPhoneNumbers=new String [phoneNumbers.length-1];
		String [] tempCompanyNames=new String [companyNames.length-1];
		int[][]tempBirthDays=new int [birthDays.length-1][];
		int [] tempSalaries=new int [salaries.length-1];
		
		for (int i = 0; i < indexOfContact; i++){
			tempContactIDs[i]=contactIDs[i];
			tempNames[i]=names[i];
			tempPhoneNumbers[i]=phoneNumbers[i];
			tempCompanyNames[i]=companyNames[i];
			tempBirthDays[i]=birthDays[i];
			tempSalaries[i]=salaries[i];
		}
		if (indexOfContact != contactIDs.length-1){
			for (int i = indexOfContact+1; i < contactIDs.length; i++){
				tempContactIDs[i-1]=contactIDs[i];
				tempNames[i-1]=names[i];
				tempPhoneNumbers[i-1]=phoneNumbers[i];
				tempCompanyNames[i-1]=companyNames[i];
				tempBirthDays[i-1]=birthDays[i];
				tempSalaries[i-1]=salaries[i];
			}
		}
		contactIDs=tempContactIDs;
		names=tempNames;
		phoneNumbers=tempPhoneNumbers;
		companyNames=tempCompanyNames;
		birthDays=tempBirthDays;
		salaries=tempSalaries;
		
	}
	
	//****************************************************************************************
	//=============== [4]Search Contacts =================
	public static void searchContacts(){
		L1:do{
			System.out.println("+-------------------------------+");
			System.out.println("|\tSearch contacts\t\t|");
			System.out.println("+-------------------------------+");
			
			// calling 'searchIndexOfContact()'method and find the index of the contact
			int indexOfContact=searchIndexOfContact();
				
			//if that is an invalid contact
			if (indexOfContact<0){
				L2:do{	
					System.out.println("\nInvalid name or phone number.....");
					System.out.print("\n\t\tDo you want to add Search another contact?(Y/N ):");
					String yn=input.next();
					if(yn.equalsIgnoreCase("Y")){
						clearCommandLineInterface();
						continue L1;
					}else if (yn.equalsIgnoreCase("N")){
						clearCommandLineInterface();
						commandLineInterface();
					}
					clearTheLastFewLines(3);
					continue L2;
					
				}while(true);
			}
				
			//show contact details
			showContactDetails(indexOfContact);
			
			L2:do{	
				System.out.print("\n\n\t\tDo you want to search another contact?(Y/N ):");
				String yn=input.next();
				if(yn.equalsIgnoreCase("Y")){
					clearCommandLineInterface();
					continue L1;
				}else if (yn.equalsIgnoreCase("N")){
					clearCommandLineInterface();
					commandLineInterface();
				}
				clearTheLastFewLines(2);
				continue L2;
					
			}while(true);
		}while(true);
	}
		
	//****************************************************************************************
	//=============== [5]List Contacts =================
	public static void listContacts(){
		L1:do{	
			System.out.println("+-----------------------------+");
			System.out.println("|\tList contacts\t\t|");
			System.out.println("+-----------------------------+");
		
			System.out.println("\n\n\t\t[01] List by Name");
			System.out.println("\t\t[02] List by Salary");
			System.out.println("\t\t[03] List by Birth day");
			
			System.out.print("\n\nEnter an ooption to continue ->\t");
			int option=input.nextInt();
	
			switch (option){
				case 1:
					listByName();
					break;
				case 2:
					listBySalary();
					break;
				case 3:
					listByBirthday();
					break;
				default:
					clearCommandLineInterface();
					continue L1;
			}
			
		}while(true);
	}
	//-----------------[5.1] Sort By Name ------------------------
	public static void listByName(){
		
		L1:do{
			clearCommandLineInterface();
			System.out.println("\t\t\t+-----------------------------+");
			System.out.println("\t\t\t|\tList By Name\t\t|");
			System.out.println("\t\t\t+-----------------------------+");
		
			//create temporary variables
			String tempContactID1="";
			String tempName1="";
			String tempPhoneNumber1="";
			String tempCompanyName1="";
			int []tempBirthDay1=new int[3];
			int tempSalary1=0;
			long tempAsciiNames=0;
			
			//Replicate the temporarily globle arrays 
			replicateArrays();
			
			// create array that stores ascii values of the names
			long [] asciiNames=new long[tempNames.length];
			
			// get the ascii values of the names
			for (int i = 0; i < tempNames.length; i++){
				for (int f = 0; f <tempNames[i].length() ; f++){
					asciiNames[i]=(asciiNames[i]*100)+(long)tempNames[i].toLowerCase().charAt(f);
				}
			}
			
			//sorting the temporarily globle arrays 
			for (int f = 1; f < tempContactIDs.length; f++){
				
				for (int i = 0; i <tempContactIDs.length-f ; i++){
					if (asciiNames[i]>asciiNames[i+1]){
						tempAsciiNames=asciiNames[i+1];
						tempContactID1=tempContactIDs[i+1];
						tempName1=tempNames[i+1];
						tempPhoneNumber1=tempPhoneNumbers[i+1];
						tempCompanyName1=tempCompanyNames[i+1];
						tempBirthDay1=tempBirthDays[i+1];
						tempSalary1=tempSalaries[i+1];
						
						asciiNames[i+1]=asciiNames[i];
						tempContactIDs[i+1]=tempContactIDs[i];
						tempNames[i+1]=tempNames[i];
						tempPhoneNumbers[i+1]=tempPhoneNumbers[i];
						tempCompanyNames[i+1]=tempCompanyNames[i];
						tempBirthDays[i+1]=tempBirthDays[i];
						tempSalaries[i+1]=tempSalaries[i];
						
						asciiNames[i]=tempAsciiNames;
						tempContactIDs[i]=tempContactID1;
						tempNames[i]=tempName1;
						tempPhoneNumbers[i]=tempPhoneNumber1;
						tempCompanyNames[i]=tempCompanyName1;
						tempBirthDays[i]=tempBirthDay1;
						tempSalaries[i]=tempSalary1;
					}
				}	
			}
			System.out.println("\t+------------+----------+---------------+----------+--------+------------+");
			System.out.printf("\t|%-12s|%-10s|%-15s|%-10s|%-8s|%-12s|\n"," contact ID","   Name","  Phone Number","   Company"," Salary"," Birthday");
			System.out.println("\t+------------+----------+---------------+----------+--------+------------+");
			for (int i = 0; i < tempContactIDs.length; i++){
				System.out.printf("\t|%-12s|%-10s|%-15s|%-10s|%-8d|%6d-%02d-%02d|\n",
					tempContactIDs[i],tempNames[i],tempPhoneNumbers[i],tempCompanyNames[i],tempSalaries[i],tempBirthDays[i][0],tempBirthDays[i][1],tempBirthDays[i][2]);
			
			}
			System.out.println("\t+------------+----------+---------------+----------+--------+------------+");
				
			L2:do{	
				System.out.print("\n\nDo you want to go to home page?(Y/N ):");
				String yn=input.next();
				if(yn.equalsIgnoreCase("Y")){
					clearCommandLineInterface();
					commandLineInterface();
				}else if (yn.equalsIgnoreCase("N")){
					clearCommandLineInterface();
					continue L1;
				}
				clearTheLastFewLines(2);
				continue L2;
						
			}while(true);
		}while(true);
		
	}
	//-----------------[5.2] Sort By Salary ------------------------
	public static void listBySalary(){
		
		L1:do{
			clearCommandLineInterface();
			System.out.println("\t\t\t+-------------------------------+");
			System.out.println("\t\t\t|\tList By Salary\t\t|");
			System.out.println("\t\t\t+-------------------------------+");
		
			//Replicate the temporarily globle arrays 
			replicateArrays();
			
			//create temporary variables
			String tempContactID1="";
			String tempName1="";
			String tempPhoneNumber1="";
			String tempCompanyName1="";
			int []tempBirthDay1=new int[3];
			int tempSalary1=0;
			
			//sorting the temporarily globle arrays 
			for (int f = 1; f < tempContactIDs.length; f++){
				
				for (int i = 0; i <tempContactIDs.length-f ; i++){
					if (tempSalaries[i]>tempSalaries[i+1]){
						tempContactID1=tempContactIDs[i+1];
						tempName1=tempNames[i+1];
						tempPhoneNumber1=tempPhoneNumbers[i+1];
						tempCompanyName1=tempCompanyNames[i+1];
						tempBirthDay1=tempBirthDays[i+1];
						tempSalary1=tempSalaries[i+1];
						
						tempContactIDs[i+1]=tempContactIDs[i];
						tempNames[i+1]=tempNames[i];
						tempPhoneNumbers[i+1]=tempPhoneNumbers[i];
						tempCompanyNames[i+1]=tempCompanyNames[i];
						tempBirthDays[i+1]=tempBirthDays[i];
						tempSalaries[i+1]=tempSalaries[i];
						
						tempContactIDs[i]=tempContactID1;
						tempNames[i]=tempName1;
						tempPhoneNumbers[i]=tempPhoneNumber1;
						tempCompanyNames[i]=tempCompanyName1;
						tempBirthDays[i]=tempBirthDay1;
						tempSalaries[i]=tempSalary1;
					}
				}	
			}
			System.out.println("\t+------------+----------+---------------+----------+--------+------------+");
			System.out.printf("\t|%-12s|%-10s|%-15s|%-10s|%-8s|%-12s|\n"," contact ID","   Name","  Phone Number","   Company"," Salary"," Birthday");
			System.out.println("\t+------------+----------+---------------+----------+--------+------------+");
			for (int i = 0; i < tempContactIDs.length; i++){
				System.out.printf("\t|%-12s|%-10s|%-15s|%-10s|%-8d|%6d-%02d-%02d|\n",
					tempContactIDs[i],tempNames[i],tempPhoneNumbers[i],tempCompanyNames[i],tempSalaries[i],tempBirthDays[i][0],tempBirthDays[i][1],tempBirthDays[i][2]);
			
			}
			System.out.println("\t+------------+----------+---------------+----------+--------+------------+");
				
			L2:do{	
				System.out.print("\n\nDo you want to go to home page?(Y/N ):");
				String yn=input.next();
				if(yn.equalsIgnoreCase("Y")){
					clearCommandLineInterface();
					commandLineInterface();
				}else if (yn.equalsIgnoreCase("N")){
					clearCommandLineInterface();
					continue L1;
				}
				clearTheLastFewLines(2);
				continue L2;
						
			}while(true);
		}while(true);
		
	}
	//-----------------[5.3] Sort By Birthday ------------------------
	public static void listByBirthday(){
		
		L1:do{	
			clearCommandLineInterface();
			System.out.println("\t\t\t+-----------------------------+");
			System.out.println("\t\t\t|\tList By Birthday\t\t|");
			System.out.println("\t\t\t+-----------------------------+");
		
			//Replicate the temporarily globle arrays 
			replicateArrays();
			
			//create temporary variables
			String tempContactID1="";
			String tempName1="";
			String tempPhoneNumber1="";
			String tempCompanyName1="";
			int []tempBirthDay1=new int[3];
			int tempSalary1=0;
			
			//convert birthdays as a value
			long[] birthDayValues=new long [birthDays.length];
			for (int i = 0; i < birthDays.length; i++){
				for (int f = 0; f < 3; f++){
					birthDayValues[i]=(birthDayValues[i]*100)+tempBirthDays[i][f];
				}
			}
			long tempBirthDayValues=0;
			
			//sorting the temporarily globle arrays 
			for (int f = 1; f < tempContactIDs.length; f++){
				
				for (int i = 0; i <tempContactIDs.length-f ; i++){
					if (birthDayValues[i]>birthDayValues[i+1]){
						tempContactID1=tempContactIDs[i+1];
						tempName1=tempNames[i+1];
						tempPhoneNumber1=tempPhoneNumbers[i+1];
						tempCompanyName1=tempCompanyNames[i+1];
						tempBirthDay1=tempBirthDays[i+1];
						tempSalary1=tempSalaries[i+1];
						tempBirthDayValues=birthDayValues[i+1];
						
						tempContactIDs[i+1]=tempContactIDs[i];
						tempNames[i+1]=tempNames[i];
						tempPhoneNumbers[i+1]=tempPhoneNumbers[i];
						tempCompanyNames[i+1]=tempCompanyNames[i];
						tempBirthDays[i+1]=tempBirthDays[i];
						tempSalaries[i+1]=tempSalaries[i];
						birthDayValues[i+1]=birthDayValues[i];
						
						tempContactIDs[i]=tempContactID1;
						tempNames[i]=tempName1;
						tempPhoneNumbers[i]=tempPhoneNumber1;
						tempCompanyNames[i]=tempCompanyName1;
						tempBirthDays[i]=tempBirthDay1;
						tempSalaries[i]=tempSalary1;
						birthDayValues[i]=tempBirthDayValues;
					}
				}	
			}
			System.out.println("\t+------------+----------+---------------+----------+--------+------------+");
			System.out.printf("\t|%-12s|%-10s|%-15s|%-10s|%-8s|%-12s|\n"," contact ID","   Name","  Phone Number","   Company"," Salary"," Birthday");
			System.out.println("\t+------------+----------+---------------+----------+--------+------------+");
			for (int i = 0; i < tempContactIDs.length; i++){
				System.out.printf("\t|%-12s|%-10s|%-15s|%-10s|%-8d|%6d-%02d-%02d|\n",
					tempContactIDs[i],tempNames[i],tempPhoneNumbers[i],tempCompanyNames[i],tempSalaries[i],tempBirthDays[i][0],tempBirthDays[i][1],tempBirthDays[i][2]);
			
			}
			System.out.println("\t+------------+----------+---------------+----------+--------+------------+");
				
			L2:do{	
				System.out.print("\n\nDo you want to go to home page?(Y/N ):");
				String yn=input.next();
				if(yn.equalsIgnoreCase("Y")){
					clearCommandLineInterface();
					commandLineInterface();
				}else if (yn.equalsIgnoreCase("N")){
					clearCommandLineInterface();
					continue L1;
				}
				clearTheLastFewLines(2);
				continue L2;
						
			}while(true);
		}while(true);
		
	}
	//-----------------[5.1.1] Replicate the temporariyl globle arrays ------------------------
	public static void replicateArrays(){
		tempContactIDs=new String [contactIDs.length];
		tempNames=new String [contactIDs.length];
		tempPhoneNumbers=new String [contactIDs.length];
		tempCompanyNames=new String [contactIDs.length];
		tempBirthDays=new int [contactIDs.length][0];
		tempSalaries=new int [contactIDs.length];
		
		for (int i = 0; i < contactIDs.length; i++){
			tempContactIDs[i]=contactIDs[i];
			tempNames[i]=names[i];
			tempPhoneNumbers[i]=phoneNumbers[i];
			tempCompanyNames[i]=companyNames[i];
			tempBirthDays[i]=birthDays[i];
			tempSalaries[i]=salaries[i];
		}
		

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
