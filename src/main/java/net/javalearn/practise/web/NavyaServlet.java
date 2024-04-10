package net.javalearn.practise.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import net.javalearn.practise.dao.Navyadao;
import net.javalearn.practise.model.Navya;

/**
 * Servlet implementation class Navyaservlet
 * * @param <printStackTrace>
 */ 
@WebServlet("/")
public class NavyaServlet<printStackTrace> extends HttpServlet {
private static final long serialVersionUID = 1L;
Navyadao user;

public void init() {
user = new Navyadao();
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
int id=Integer.parseInt(request.getParameter("emp_id"));
String name=request.getParameter("emp_name");
String pass=request.getParameter("emp_password");
Navya newemployee = new Navya(id,name,pass);
try {
user.insert(newemployee);
} catch (SQLException e) {

	
e.printStackTrace();
}

PrintWriter p=response.getWriter();
p.print("Insert successfull");
}

protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String id = request.getParameter("emp_id");
try {
user.deleteemployee(Integer.parseInt(id));
} catch (SQLException e) {

e.printStackTrace();
}
PrintWriter p=response.getWriter();
p.print("delete successfull");
}

protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
String id=request.getParameter("emp_id");
String name=request.getParameter("emp_name");
String pass=request.getParameter("emp_password");
Navya employee=new Navya(Integer.parseInt(id),name,pass);
try {
user.updateemployee(employee);
} catch (SQLException e) {

e.printStackTrace();
}
PrintWriter p=response.getWriter();
p.print("update successfull");
}
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
List list=user.printdetailsemployee();
PrintWriter p=response.getWriter();
for(int i=0;i<list.size();i++) {
p.print(list.get(i));
}
}
}








