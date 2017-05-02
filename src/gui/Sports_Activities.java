package gui;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Sports_Activities
 */
@WebServlet("/Sports_Activities")
public class Sports_Activities extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Luxor l = new Luxor();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sports_Activities() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter outGet = response.getWriter();
		if (request.getParameter("q11") != null) {
			ArrayList<SportsActivities> sp_acts = l.q11();
			outGet.println("<table>");
			for (int i = 0; i < sp_acts.size(); i++) {
				String[] his_act_comp = sp_acts.get(i).getName().split("#");
				outGet.println("<tr>");
				outGet.println("<td>" + his_act_comp[1] + "</td>");
				outGet.println("<td>" + sp_acts.get(i).getPrice() + "</td>");
				outGet.println("</tr>");
			}
			outGet.println("</table>");
		}
		
		if (request.getParameter("q12") != null) {
			ArrayList<SportsActivities> sp_acts = l.q12();
			for (int i = 0; i < sp_acts.size(); i++) {
				String[] his_act_comp = sp_acts.get(i).getName().split("#");
				outGet.println("<h6>" + his_act_comp[1] + "</h6>");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter outPost = response.getWriter();
		if (request.getParameter("city") != null) {
			ArrayList<SportsActivities> sp_acts = l.q10(request.getParameter("city"));
			for (int i = 0; i < sp_acts.size(); i++) {
				String[] sp_act_split = sp_acts.get(i).getName().split("#");
				outPost.println("<h6>");
				outPost.println(sp_act_split[1]);
				outPost.println("</h6>");
			}
		}
		
		if (request.getParameter("price") != null) {
			ArrayList<SportsActivities> sp_acts = l.q13(request.getParameter("price"));
			outPost.println("<table>");
			for (int i = 0; i < sp_acts.size(); i++) {
				String[] sp_act_split = sp_acts.get(i).getName().split("#");
				outPost.println("<tr>");
				outPost.println("<td>" + sp_act_split[1] + "</td>");
				outPost.println("<td>" + sp_acts.get(i).getPrice() + "</td>");
				outPost.println("</tr>");
			}
			outPost.println("</table>");
		}
		
	}

}
