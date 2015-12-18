package com.dw.aristata.test1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.microsoft.schemas.sharepoint.soap.ListsStub;

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ListsStub listsStub;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        try{
        	listsStub = new ListsStub();
        } catch(Exception e) {
        	throw new RuntimeException("Failed to create ListsStub");
        }
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String list = request.getParameter("list");
		if("get-list-and-view".equals(action)) {
			ListsStub.GetListAndView getListAndView = new ListsStub.GetListAndView();
			getListAndView.setListName(list);
			listsStub.getListAndView(getListAndView);
		} else if("get-list-items".equals(action)) {
			ListsStub.GetListItems getListItems = new ListsStub.GetListItems();
			getListItems.setListName(list);
			listsStub.getListCollection(new ListsStub.GetListCollection());
		} else if("get-list-collection".equals(action)) {
		  listsStub.getListCollection(new ListsStub.GetListCollection());
		} else {
			response.getWriter().append("Invalid action");
		}
		response.getWriter().append("OK");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
