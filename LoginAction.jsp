package com.ecable.action;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.ecable.daoImpl.SecurityDAO;
import com.ecable.bean.ProfileTO;
public class LoginAction extends HttpServlet {
/**
* The doPost method of the servlet. <br>
*
* This method is called when a form has its tag value method equals to
* post.
*
* @param request
* the request send by the client to the server
* @param response
* the response send by the server to the client
* @throws ServletException
* if an error occurred
* @throws IOException
* if an error occurred
*/
public void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
String target = "LoginForm.jsp?status=Invalid username and password";
try {
Vector<ProfileTO> vprof =new Vector<ProfileTO>();
HttpSession session = request.getSession();
ProfileTO rb = new ProfileTO();
String username = request.getParameter("username");
rb.setLoginID(username);
String pass = request.getParameter("password");
rb.setPassword(pass);
System.out.println(username);
System.out.println(pass);
vprof = new SecurityDAO().loginCheck(rb);
Iterator it = vprof.listIterator();
String role="";
String state="";
String district="";
String city="";
int userid=0;
if(it.hasNext()) {
rb = (ProfileTO) it.next();
userid=rb.getUserid();
role=rb.getLogintype();
state=rb.getState();
district=rb.getDistrict();
city=rb.getCity();}
System.out.println(userid);System.out.println(role);System.out.println(state);System.
out.println(district);System.out.println(city);
if (role.equals("Admin")) {
target = "adminhome.jsp?status=Welcome " + username;
session.setAttribute("user", username);
session.setAttribute("role", role);
session.setAttribute("pass", pass);
session.setAttribute("userid", userid);
session.setAttribute("state", state);
session.setAttribute("district", district);
session.setAttribute("city", city);
} else if (role.equals("Operator")) {
target = "Operatorhome.jsp?status=Welcome " + username;
session.setAttribute("user", username);
session.setAttribute("role", role);
session.setAttribute("pass", pass);
session.setAttribute("userid", userid);
session.setAttribute("state", state);
session.setAttribute("district", district);
session.setAttribute("city", city);
} else if (role.equals("Customer")) {
    target = "Customerhome.jsp?status=Welcome " + username;
    session.setAttribute("user", username);
    session.setAttribute("role", role);
    session.setAttribute("pass", pass);
    session.setAttribute("userid", userid);
    session.setAttribute("state", state);
    session.setAttribute("district", district);
    session.setAttribute("city", city);
    } else
    target = "LoginForm.jsp?status=Invalid username and
    password";
    } catch (Exception e) {
    e.printStackTrace();
    }
    RequestDispatcher rd = request.getRequestDispatcher(target);
    rd.forward(request, response);
    }
    }
    