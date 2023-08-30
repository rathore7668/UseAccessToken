package pkg1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class PropertySearchSystem {
public static void main(String[]args) throws SQLException {
	Scanner scanner = new Scanner(System.in);
	
	int choice;
	       
	 do {
	        System.out.println("1. Add new property");
	        System.out.println("2. Update property cost");
	        System.out.println("3. Delete property");
	        System.out.println("4. Find by city");
	        System.out.println("5. View all properties");
	        System.out.println("6. Find by cost");
	        System.out.println("7. Find by no of rooms and city");
	        System.out.println("Enter your choice:");
	        System.out.println("8. Exit");
	        choice =scanner.nextInt();
	       
	        	switch (choice) {
		        case 1:
	     
	       System.out.println("enter the property id:");
	       int num=scanner.nextInt();
	       System.out.println("enter number of rooms:");
	       String str=scanner.next();
	       System.out.println("enetr area in sqft:");
	       double dbl=scanner.nextDouble();
	       System.out.println("enetr floor number:");
	       int num1=scanner.nextInt();
	       System.out.println("enter city name:");
	       String str1=scanner.next();
	       System.out.println("enter the state name:");
	       String str2=scanner.next();
	       System.out.println("enter the cost:");
	       double dbl1=scanner.nextDouble();
	       System.out.println("enetr the owner name:");
	       String str3=scanner.next();
	       System.out.println("enter the owner contact no:");
	       String str4=scanner.next();
	       
	       PropertyDAO p=new PropertyDAO();
	       Property p1=new Property(num,str,dbl,num1,str1,str2,dbl1,str3,str4);
	       System.out.println(p.addProperty(p1)+"data inserted");
	      
	      
	            break;
	        case 2:
	           System.out.println("enter property id:");
	           int num5=scanner.nextInt();
	           System.out.println("enter the new cost:");
	           double dbl5=scanner.nextDouble();
	           PropertyDAO pro=new PropertyDAO();
		       pro.updatePropertyCost(num5, dbl5);
	           
	            break;
	        case 3:
	           System.out.println("enter the property id:");
	           int num2=scanner.nextInt();
	           PropertyDAO prop=new PropertyDAO();
	         //  Property p2=new Property(num2);
	           
	           prop.deleteProperty(num2);
	           
	            
	            break;
	        case 4:
	           System.out.println("enter the city;");
	           String str6=scanner.next();
	           PropertyDAO prope=new PropertyDAO();
	           List<Property> cityresult=prope.searchByCity(str6);
	           if(cityresult.isEmpty()) {
	        	   System.out.println("Property not available");
	           }
	           else {
	        	   for(Property result:cityresult) {
	        		   System.out.println(result);
	        	   }
	           }
	           
	             
	            break;
	        case 5:
	            
	            PropertyDAO proper=new PropertyDAO();
	            List<Property>viewallproperties=proper.showAllProperties();
	           for(Property propt:viewallproperties) {
	        	   System.out.println(propt);
	           }
	           
	            break;
	        case 6:
	            System.out.println("enter the minimum cost:");
	            double dbl7=scanner.nextDouble();
	            System.out.println("enter the maximum cost:");
	            double dbl8=scanner.nextDouble();
	            PropertyDAO propert=new PropertyDAO();
	           List<Property>costresult=propert.searchByCostRange(dbl7, dbl8);
	           if(costresult.isEmpty()) {
	        	   System.out.println("Property not available");
	           }
	           else {
	        	   for(Property result:costresult) {
	        		   System.out.println(result);
	        	   }
	           }
	            
	           
	            break;
	        case 7:
	            System.out.println("enter number of rooms(1bhk/2bhk/3bhk):");
	            String str8=scanner.next();
	             System.out.println("enter the city name:");
	             String str9=scanner.next();
	             PropertyDAO property1=new PropertyDAO();
	             List<Property>roomscityresult=property1.searchByNoOfRoomsAndCity(str8,str9);
	             if(roomscityresult.isEmpty()) {
	            	 System.out.println("Property not available");
	             }else {
	            	 for(Property result:roomscityresult) {
	            		 System.out.println(result);
	            	 }
	             }
	             
	             break;
	        case 8:
	            System.out.println("Exiting...");
	            break;
	        default:
	            System.out.println("Invalid choice. Please try again.");
	    }
	        }while(choice!=8);

}
}

    

