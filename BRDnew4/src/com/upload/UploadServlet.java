package com.upload;
import fileHandling.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Paths;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import fileHandling.*;

@WebServlet("/UploadServlet")
@MultipartConfig
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String description = request.getParameter("description");
		Part filePart = request.getPart("file");
		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
		InputStream fileContent = filePart.getInputStream();
		String dropdown = request.getParameter("dropdown");
		PrintWriter out = response.getWriter();
		if (dropdown.equals("r")) {
			
			RecordValidation.RecordLevelValidayion(fileContent, fileName);
			out.println("File uploaded to database");
			out.println("Record level Rejection in done!!!");
		}
		else {
			FilelevelValidation.FileLevelValidation(fileContent, fileName);
			out.println("File uploaded to database");
			out.println("File level Rejection in done!!!");
		}

		

	}

}
