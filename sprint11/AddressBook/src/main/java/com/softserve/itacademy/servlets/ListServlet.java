package com.softserve.itacademy.servlets;

import com.softserve.itacademy.model.Record;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class ListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
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

        if (ad != null) {
            if (sortOperation != null) {
                try {
                    switch (sortOperation) {
                        case "asc":
                            ad.sortedBy(SortOrder.ASC);
                            List<Record> recordList2 = new ArrayList<>();
                            Integer id2 = 0;
                            for (Object elem : ad) {
                                Record r = new Record();
                                String s = new String((String) elem);
                                id2++;
                                r.setFirstName(s.split(",")[0].split(":")[1].trim());
                                r.setLastName(s.split(",")[1].split(":")[1].trim());
                                r.setAddress(s.split(",")[2].split(":")[1].trim());
                                r.setId(id2);
                                recordList2.add(r);
                            }
                            record.setRecordList(recordList2);
                            request.setAttribute("recordList", record);

                            break;
                        case "desc":
                            ad.sortedBy(SortOrder.DESC);
                            List<Record> recordList3 = new ArrayList<>();
                            Integer id3 = 0;
                            for (Object elem : ad) {
                                Record r = new Record();
                                String s = new String((String) elem);
                                id3++;
                                r.setFirstName(s.split(",")[0].split(":")[1].trim());
                                r.setLastName(s.split(",")[1].split(":")[1].trim());
                                r.setAddress(s.split(",")[2].split(":")[1].trim());
                                r.setId(id3);
                                recordList3.add(r);
                            }
                            record.setRecordList(recordList3);
                            request.setAttribute("recordList", record);

                            break;
                        default:
                            throw new Exception();
                    }

                } catch (Exception e) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                    e.printStackTrace();
                }


            } else {
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

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/home3.jsp");
        rd.forward(request, response);

    }

}


