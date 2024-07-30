public class Student{
private int rollno;
private String name;
private String FatherName;
private String grade;
private String PhoneNo;

public Student(int rollno, String name,String FatherName,String grade,String PhoneNo){
this.rollno =rollno;
this.name= name;
this.FatherName= FatherName;
this.grade= grade;
this.PhoneNo= PhoneNo;}

public int getRollNo(){
 return rollno;}

public String getName(){
 return name;}

public String getFatherName(){
 return FatherName;}

public String getGrade(){
 return grade;}

public String getPhoneNo(){
 return PhoneNo;}

/*public int setrollno(){
 return rollno;}

public String setname(){
 return name;}

public String setFatherName(){
 return FatherName;}

public String setgrade(){
 return grade;}

public String setPhoneNo(){
 return PhoneNo;}*/

}
