package com.softserve.itacademy.servlets;

import com.softserve.itacademy.model.Record;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DeleteRecordServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRecordServlet() {
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

    }

    private void proccessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Record record = new Record();
        AddressBook ad = AddressBook.getInstance();
        String sortOperation = request.getParameter("sort");
        String firstNameDelete = request.getParameter("first-name");
        String lastNameDelete = request.getParameter("last-name");


        if (ad != null) {
            if (firstNameDelete != null && lastNameDelete != null) {
                if (ad.delete(firstNameDelete, lastNameDelete)) {
                    List<Record> recordList = new ArrayList<>();
                    Integer id = 0;
                    for (Object elem : ad) {
                        Record r = new Record();
                        String s = new String((String) elem);
                        id++;
                        r.setFirstName(s.split(",")[0].split(":")[1].trim());
                        r.setLastName(s.split(",")[1].split(":")[1].trim());
                        r.setAddress(s.split(",")[2].split(":")[1].trim());
                        r.setId(id);
                        recordList.add(r);
                    }
                    record.setRecordList(recordList);
                    request.setAttribute("recordList", record);
                }


            }
        }


        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/home3.jsp");
        rd.forward(request, response);


    }
}
