package com.softserve.itacademy.servlets;

import com.softserve.itacademy.model.ErrorObj;
import com.softserve.itacademy.model.Record;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ReadRecordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadRecordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        proccessRequest(request, response);

    }


    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        proccessRequest(request, response);
//        doGet(request, response);

    }

    private void proccessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Record record = new Record();
        ErrorObj eo = new ErrorObj();
        AddressBook ad = AddressBook.getInstance();
        String firstName = request.getParameter("first-name");
        String lastName = request.getParameter("last-name");


        if (ad != null) {
            try {
                if (firstName != null && lastName != null) {
                    if (ad.read(firstName, lastName) != null) {
                        String address = ad.read(firstName, lastName);
                        record.setFirstName(firstName);
                        record.setLastName(lastName);
                        record.setAddress(address);
                        request.setAttribute("recordOne", record);
                    } else {
                        eo.setErrorNotFoundPerson(firstName, lastName);
                        request.setAttribute("errorObj", eo);
                        throw new Exception();
                    }
                }
            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                e.printStackTrace();
            }

        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/readrecord.jsp");
        rd.forward(request, response);
    }

}





