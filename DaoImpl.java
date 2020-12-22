package com.ecable.daoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import com.ecable.bean.DistrictTO;
import com.ecable.daoI.DistrictDaoI;
import com.ecable.dao.AbstractDataAccessObject;
public class DistrickDaoImpl implements DistrictDaoI {
    Connection con;
PreparedStatement pstmt;
Statement stmt;
ResultSet rs;
ResultSet rs1;
public DistrickDaoImpl(){
con=new AbstractDataAccessObject().getConnection();
}
public boolean insertDistrict(DistrictTO dt)
{
boolean flag=true;
try{
pstmt=con.prepareStatement("insert into district values((select
nvl(max(did),100)+1 from district),?,?)");
int sid=dt.getStateid();
System.out.println("in DAo stateid is.........."+sid);
String dname=dt.getDname();
System.out.println("in dao Dname is.........."+dname);
pstmt.setInt(1, sid);
pstmt.setString(2, dname);
int insert=pstmt.executeUpdate();
 if(insert>0)
 {

 con.commit();
 }
else
 {
 flag=false;
 con.rollback();
 }
 }

 catch (Exception e)
 {
 e.printStackTrace();
 flag=false;
 try
 {
 con.rollback();
 }
 catch (SQLException se)
 {
 se.printStackTrace();
 }
 }

 finally
{
try{
if(con!=null)
con.close();
}
catch(Exception e){}
}
return flag;
}
 public Vector<DistrictTO> viewDist()
{
Vector<DistrictTO> vsb=null;
String sname="";
try{
con=new AbstractDataAccessObject().getConnection();
pstmt=con.prepareStatement("select *from district");
rs=pstmt.executeQuery();
vsb=new Vector<DistrictTO>();
while(rs.next())
{
    int did=rs.getInt(1);
int sid=rs.getInt(2);
String dname=rs.getString(3);
DistrictTO sf=new DistrictTO();
stmt=con.createStatement();
rs1=stmt.executeQuery("select statename from state where
stateid="+sid);
if(rs1.next())
{
sname=rs1.getString(1);
}
sf.setDid(did);
sf.setDname(dname);
sf.setStateid(sid);
sf.setSname(sname);
vsb.add(sf);
}
}
catch (Exception e) {
e.printStackTrace();
}
return vsb;
}
public DistrictTO viewDistAt( int did1)
{
DistrictTO sf=null;
String sname="";
try{
pstmt=con.prepareStatement("select * from district where did=?");
pstmt.setInt(1, did1);
rs=pstmt.executeQuery();
while(rs.next())
{
int did=rs.getInt(1);
int sid=rs.getInt(2);
String dname=rs.getString(3);
sf=new DistrictTO();
stmt=con.createStatement();
rs1=stmt.executeQuery("select statename from state where
stateid="+sid);
if(rs1.next())
sname=rs1.getString(1);
sf.setDid(did);
sf.setDname(dname);
sf.setStateid(sid);
sf.setSname(sname);
}
}
catch (Exception e) {
e.printStackTrace();
}
return sf;
}
public boolean deleteDist(int did)
{
boolean flag=true;
try{
pstmt=con.prepareStatement("delete from district where did=?");
pstmt.setInt(1, did);
int delete=pstmt.executeUpdate();
if(delete>0)
 {
 con.commit();
 }
 else
 {
 flag=false;
 con.rollback();
 }
 }

 catch (Exception e)
 {
 e.printStackTrace();
 flag=false;
 try
 {
 con.rollback();
 }
 catch (SQLException se)
 {
 se.printStackTrace();
 }
 }

 finally
{
try{
if(con!=null)
con.close();
}
catch(Exception e){}
}
return flag;
}
public boolean updateDist(DistrictTO sf)
{
boolean flag=true;
try{
pstmt=con.prepareStatement("update district set dname=? where did=?
");
int did=sf.getDid();
System.out.println("in DAo District id is.........."+did);
String dname=sf.getDname();
pstmt.setString(1, dname);
pstmt.setInt(2, did);
 int update=pstmt.executeUpdate();
if(update>0)
 {

 con.commit();
 }
 else
 {
 flag=false;
 con.rollback();
 }
 }

 catch (Exception e)
 {
 e.printStackTrace();
 flag=false;
 try
 {
 con.rollback();
 }
 catch (SQLException se)
 {
 se.printStackTrace();
 }
 }

 Finally
{
try{
if(con!=null)
con.close();
}
catch(Exception e){}
}
return flag;
}
public Vector<DistrictTO> getDistName(String sname)
{
Vector<DistrictTO> vsb=null;
try{
pstmt=con.prepareStatement("select dname,did from district where
stateid in(select stateid from state where statename=?)");
pstmt.setString(1, sname);
System.out.println(sname);
rs=pstmt.executeQuery();
vsb=new Vector<DistrictTO>();
while(rs.next())
{
String dname=rs.getString(1);
int did=rs.getInt(2);
DistrictTO sf=new DistrictTO();
sf.setDname(dname);
sf.setDid(did);
vsb.add(sf);
}
}
catch (Exception e) {
e.printStackTrace();
}
return vsb;
}
}