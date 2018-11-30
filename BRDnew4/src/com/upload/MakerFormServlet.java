package com.upload;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MakerFormServlet")
public class MakerFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int CustomerID = 0;
		String CustomerCode = request.getParameter("CustomerCode");
		String CustomerName = request.getParameter("CustomerName");
		String CustomerAddress1 = request.getParameter("CustomerAddress1");
		String CustomerAddress2 = request.getParameter("CustomerAddress2");
		String CustomerPincode = request.getParameter("CustomerPincode");
		String Email = request.getParameter("E-mail");
		String ContactNumber = request.getParameter("ContactNumber");
		String PrimaryContactPerson = request.getParameter("PrimaryContactPerson");
		String RecordStatus = request.getParameter("RecordStatus");
		String ActiveInactiveFlag = request.getParameter("ActiveInactiveFlag");
		String CreateDate = request.getParameter("CreateDate");
		String CreateBy = request.getParameter("CreateBy");
		String ModifiedDate = request.getParameter("ModifiedDate");
		String ModifiedBy = request.getParameter("ModifiedBy");
		String AuthorizedDate = request.getParameter("AuthorizedDate");
		String AuthorizedBy = request.getParameter("AuthorizedBy");
		DataBaseDao.makerForm(CustomerID += 1, CustomerCode, CustomerName, CustomerAddress1, CustomerAddress2,
				CustomerPincode, Email, ContactNumber, PrimaryContactPerson, RecordStatus, ActiveInactiveFlag,
				CreateDate, CreateBy, ModifiedDate, ModifiedBy, AuthorizedDate, AuthorizedBy);
	}

}