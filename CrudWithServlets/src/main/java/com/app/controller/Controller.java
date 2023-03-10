package com.app.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.entity.Person;
import com.app.factory.Factory;
import com.app.service.ServiceImpl;
import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

import net.bytebuddy.dynamic.scaffold.inline.RedefinitionDynamicTypeBuilder;

@WebServlet("/controller/*")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		HttpSession session = null;
		String status = null;
		Person person = null;
		ServiceImpl service = Factory.getServiceImpl();
		if (requestURI.endsWith("create")) {

			String name = request.getParameter("username");
			String dob = request.getParameter("userdob");
			String city = request.getParameter("usercity");

			Date sqlDate = Date.valueOf(dob);

			person = new Person();
			person.setName(name);
			person.setDob(sqlDate);
			person.setCity(city);

			status = service.save(person);

			session = request.getSession();
			session.setAttribute("create", status);

			response.sendRedirect("../create.jsp");

		}

		if (requestURI.endsWith("read")) {

			Integer id = Integer.parseInt(request.getParameter("searchid"));

			service = Factory.getServiceImpl();

			person = service.search(id);
			session = request.getSession();
			if (person != null) {
				session.setAttribute("person", person);
				response.sendRedirect("../display.jsp");
			} else {
				session.setAttribute("read", "failure");
				response.sendRedirect("../read.jsp");
			}
		}

		if (requestURI.endsWith("update")) {

			Integer id = Integer.parseInt(request.getParameter("updateid"));
			String name = request.getParameter("updatename");
			String dob = request.getParameter("updatedob");
			String city = request.getParameter("updatecity");
			Date sqlDob = Date.valueOf(dob);
			person = new Person();
			person.setId(id);
			person.setName(name);
			person.setDob(sqlDob);
			person.setCity(city);

			service = Factory.getServiceImpl();

			status = service.update(person);

			session = request.getSession();

			session.setAttribute("update", status);

			response.sendRedirect("../update.jsp");
		}

		if (requestURI.endsWith("delete")) {

			Integer id = Integer.parseInt(request.getParameter("deleteid"));

			service = Factory.getServiceImpl();

			status = service.delete(id);

			session = request.getSession();

			session.setAttribute("delete", status);
			response.sendRedirect("../delete.jsp");

		}
	}

}
