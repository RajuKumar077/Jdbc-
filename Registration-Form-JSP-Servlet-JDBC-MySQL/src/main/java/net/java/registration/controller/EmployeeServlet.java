package net.java.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.java.registration.dao.EmployeeDao;
import net.java.registration.model.Employee;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/register")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDao employeeDao = new EmployeeDao();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	  
		 RequestDispatcher  dispatcher = request.getRequestDispatcher("/WEB-INF/views/employeeregister.jsp");
		 dispatcher.forward(request, response);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	String id =request.getParameter("id");
    String First_Name =request.getParameter("First_Name");
    String Second_Name =request.getParameter("Second_Name");
    String username =request.getParameter("username");
    String password =request.getParameter("password");
    String contact =request.getParameter("contact");
   
    
    Employee employee = new Employee();
    employee.setFirstName(First_Name);
    employee.setSecondName(Second_Name);
    employee.setUsername(username);
    employee.setPassword(password);
    employee.setContact(contact);
    employee.setId(id);
    
    try {
        employeeDao.registerEmployee(employee);
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    RequestDispatcher  dispatcher = request.getRequestDispatcher("/WEB-INF/views/employeedetails.jsp");
	 dispatcher.forward(request, response);

}

}