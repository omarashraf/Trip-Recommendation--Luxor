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
 * Servlet implementation class Historical_Activities
 */
@WebServlet("/Historical_Activities")
public class Historical_Activities extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Luxor l = new Luxor();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Historical_Activities() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter outGet = response.getWriter();
		if (request.getParameter("q4") != null) {
			ArrayList<HistActivities> his_act = l.q4();
			outGet.println("<table>");
			for (int i = 0; i < his_act.size(); i++) {
				String[] his_act_comp = his_act.get(i).getName().split("#");
				outGet.println("<tr>");
				outGet.println("<td>" + his_act_comp[1] + "</td>");
				outGet.println("<td>" + his_act.get(i).getRanking() + "</td>");
				outGet.println("</tr>");
			}
			outGet.println("</table>");
		}
		
		if (request.getParameter("q6") != null) {
			ArrayList<HistActivities> his_act = l.q6();
			for (int i = 0; i < his_act.size(); i++) {
				String[] his_act_comp = his_act.get(i).getName().split("#");
				outGet.println("<h6>" + his_act_comp[1] + "</h6>");
			}
		}
		
		if (request.getParameter("q7") != null) {
			ArrayList<HistActivities> his_act = l.q7();
			for (int i = 0; i < his_act.size(); i++) {
				String[] his_act_comp = his_act.get(i).getName().split("#");
				outGet.println("<h6>" + his_act_comp[1] + "</h6>");
			}
		}
		
		if (request.getParameter("q8") != null) {
			ArrayList<HistActivities> his_act = l.q8();
			outGet.println("<table>");
			for (int i = 0; i < his_act.size(); i++) {
				String[] his_act_comp = his_act.get(i).getName().split("#");
				outGet.println("<tr>");
				outGet.println("<td>" + his_act_comp[1] + "</td>");
				outGet.println("<td>" + his_act.get(i).getPrice() + "</td>");
				outGet.println("</tr>");
			}
			outGet.println("</table>");
		}
		
		if (request.getParameter("q9") != null) {
			ArrayList<HistActivities> his_act = l.q9();
			outGet.println("<table>");
			for (int i = 0; i < his_act.size(); i++) {
				String[] his_act_comp = his_act.get(i).getName().split("#");
				outGet.println("<tr>");
				outGet.println("<td>" + his_act_comp[1] + "</td>");
				outGet.println("<td>" + his_act.get(i).getPrice() + "</td>");
				outGet.println("</tr>");
			}
			outGet.println("</table>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter outPost = response.getWriter();
		if (request.getParameter("city") != null) {
			String city = request.getParameter("city");
			ArrayList<String> his_act = l.q3(city);
			for (int i = 0; i < his_act.size(); i++) {
				String[] his_act_comp = his_act.get(i).split("#");
				outPost.println("<h6>" + his_act_comp[1] + "</h6>");
			}
		}
		if (request.getParameter("ranking") != null) {
			String ranking = request.getParameter("ranking");
			ArrayList<HistActivities> his_act = l.q5(ranking);
			outPost.println("<table>");
			for (int i = 0; i < his_act.size(); i++) {
				String[] his_act_comp = his_act.get(i).getName().split("#");
				outPost.println("<tr>");
				outPost.println("<td>" + his_act_comp[1] + "</td>");
				outPost.println("<td>" + his_act.get(i).getRanking() + "</td>");
				outPost.println("</tr>");
			}
			outPost.println("</table>");
		}
	}

}
