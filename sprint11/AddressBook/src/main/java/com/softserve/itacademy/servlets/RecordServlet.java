package com.softserve.itacademy.servlets;

import com.softserve.itacademy.model.ErrorObj;
import com.softserve.itacademy.model.RightObj;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class RecordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/home2.jsp");
        rd.forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");

        AddressBook ad = AddressBook.getInstance();
        ErrorObj eo = new ErrorObj();
        RightObj ro = new RightObj();

        if (firstName != null) {
            if (firstName.isEmpty() || lastName.isEmpty() || address.isEmpty()) {
                eo.setError(true);
                eo.setInputError();
            } else {
                if (ad.create(firstName, lastName, address)) {
                    eo.setError(false);
                    ro.setMessage();
                } else {
                    eo.setError(true);
                    eo.setErrorAlreadyExist();

                }

            }
        }

        if (eo.isError()) {
            request.setAttribute("errorObj", eo);
            doGet(request, response);
        } else {
            request.setAttribute("rightObj", ro);
            doGet(request, response);
        }

    }

}
