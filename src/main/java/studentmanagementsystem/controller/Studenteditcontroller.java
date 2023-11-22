package studentmanagementsystem.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentmanagementsystem.dao.Studentdao;
import studentmanagementsystem.dto.Student;

@WebServlet("/edit")
public class Studenteditcontroller extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String address=req.getParameter("address");
		String password=req.getParameter("password");
		long phone=Long.parseLong(req.getParameter("phone"));
		
		Student student=new Student();
		student.setId(id);
		student.setName(name);
		student.setAddress(address);
		student.setEmail(email);
		student.setPassword(password);
		student.setPhone(phone);
		
		Studentdao studentdao=new Studentdao();
		Student student2=studentdao.updateStudent(student);
		
		if(student2!=null) {
			List<Student> list=studentdao.getallStudents();
			req.setAttribute("list", list);
			RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
			dispatcher.forward(req, resp);
		}else {
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);
		}
		
				
				
				
				
	}
}
