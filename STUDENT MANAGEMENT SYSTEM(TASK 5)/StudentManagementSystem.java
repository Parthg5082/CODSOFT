import java.util.Scanner;

public class StudentManagementSystem{

public static void menu()
{
  System.out.println("1. Add a Student");
System.out.println("2. Remove a Student");
System.out.println("3. Search for a Student");
System.out.println("4. Display all Students");
System.out.println("5. Save and Exit");


}
public static void main(String args[]){
System.out.println("\n Student Management System");
try
{
DataCon dc=new DataCon();
Scanner sc= new Scanner(System.in);  
do{
menu();
System.out.println("Enter Your Choice:");
int choice= Integer.parseInt(sc.nextLine());
switch(choice){
case 1: 
       System.out.println("Enter Roll Numnber:");
       int roll=Integer.parseInt(sc.nextLine());
       System.out.println("Enter Name:");
       String name=sc.nextLine();

       System.out.println("Enter Father\'s Name:");
       String fname=sc.nextLine();

       System.out.println("Enter Grade:");
       String grd=sc.nextLine();

       System.out.println("Enter Phone Number:");
       String pno=sc.nextLine();

       Student s1=new Student(roll,name,fname,grd,pno);
       dc.addRecord(s1);
       System.out.println("Data Inserted");

       break;

case 2:  System.out.println("\nEnter Student Roll Number");
         roll= Integer.parseInt(sc.nextLine());
         dc.removeStudent(roll);
         break;
case 3:  System.out.println("\nEnter Student Roll Number you want to search ");
         roll= Integer.parseInt(sc.nextLine());
         dc.searchStudent(roll);
         break;
case 4: System.out.println("\nDisplay all Students");
        dc.displayStudent();
        break;
case 5: System.exit(0);

}//end of switch




}//end of do
while(true);
}
catch(Exception e){System.out.println(e.toString());
System.out.println("System error occur . Please contact with Database Administrator");}

}}
