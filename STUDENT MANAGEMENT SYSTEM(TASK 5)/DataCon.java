import java.sql.*;
public class DataCon
{
   private  Connection con=null;
   private    Statement smt=null;
   private    ResultSet rs=null;
   private   PreparedStatement psmt=null;
   public DataCon() throws SQLException,ClassNotFoundException
   {
    
      Class.forName("com.mysql.cj.jdbc.Driver");
      con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nikita","root","root@123");
      System.out.println("Connection Done");
   } //end of DataCon Cons
   public void addRecord(Student s1)
   {
       try{
         psmt=con.prepareStatement("insert into student values (?,?,?,?,?)");
         psmt.setInt(1,s1.getRollNo());
         psmt.setString(2,s1.getName());

         psmt.setString(3,s1.getFatherName());

         psmt.setString(4,s1.getGrade());
         psmt.setString(5,s1.getPhoneNo());
         psmt.executeUpdate();
      }catch(Exception e){System.out.println(e.toString());} 
    }// end of add record
    public void removeStudent(int rollno)
     {
          try{
                psmt=con.prepareStatement("delete from student where roll_no= ?");
                psmt.setInt(1,rollno);
                int rowcount = psmt.executeUpdate();
                if(rowcount==0)
                 {
                      System.out.println("data not found");
                 }
                else
                   {
                     System.out.println("Recored Deleted Successesfully");
                  }
           
             
}          catch(Exception e){System.out.println(e.toString());}

} // end of delete method




public void searchStudent(int rollno){
try {String sql = "select * from student where roll_no=?";
 psmt= con.prepareStatement(sql);
 psmt.setInt(1,rollno);
 rs = psmt.executeQuery();
 System.out.println("RollNo\t\tName\t\tFatherName\t\tGrade\t\tPhoneNo");
      if (rs.next()) {
                System.out.println(rs.getInt("Roll_No")+ "\t\t" + rs.getString("Name")+ "\t\t" + rs.getString("FatherName")+ "\t\t"+ rs.getString("Grade")+ "\t\t"  + rs.getString("PhoneNo"));}
}catch (SQLException e) {System.out.println(e);}
}
     public void displayStudent(){
       try{ smt=con.createStatement();
        rs=smt.executeQuery("select * from student");
        while(rs.next())
        {
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+rs.getString(5));
         }
}catch(Exception e){System.out.println(e.toString());}
        
}

}