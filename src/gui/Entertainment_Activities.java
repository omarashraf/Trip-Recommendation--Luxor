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
 * Servlet implementation class Entertainment_Activities
 */
@WebServlet("/Entertainment_Activities")
public class Entertainment_Activities extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Luxor l = new Luxor();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Entertainment_Activities() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter outGet = response.getWriter(); 
		if (request.getParameter("q15") != null) {
			ArrayList<EntActivities> ent_acts = l.q15();
			for (int i = 0; i < ent_acts.size(); i++) {
				String[] ent_act_comp = ent_acts.get(i).getName().split("#");
				outGet.println("<h6>" + ent_act_comp[1] + "</h6>");
			}
		}
		
		if (request.getParameter("q17") != null) {
			ArrayList<EntActivities> ent_acts = l.q17();
			for (int i = 0; i < ent_acts.size(); i++) {
				String[] ent_act_comp = ent_acts.get(i).getName().split("#");
				outGet.println("<h6>" + ent_act_comp[1] + "</h6>");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter outPost = response.getWriter();
		if (request.getParameter("price") != null) {
			ArrayList<EntActivities> ent_acts = l.q18(request.getParameter("price"));
			outPost.println("<table>");
			for (int i = 0; i < ent_acts.size(); i++) {
				String[] ent_act_split = ent_acts.get(i).getName().split("#");
				outPost.println("<tr>");
				outPost.println("<td>");
				outPost.println(ent_act_split[1]);
				outPost.println("</td>");
				outPost.println("<td>");
				outPost.println(ent_acts.get(i).getPrice());
				outPost.println("</td>");
				outPost.println("</tr>");
			}
			outPost.println("</table>");
		}
		
		if (request.getParameter("duration") != null) {
			ArrayList<EntActivities> ent_acts = l.q19(request.getParameter("duration"));
			outPost.println("<table>");
			for (int i = 0; i < ent_acts.size(); i++) {
				String[] ent_act_split = ent_acts.get(i).getName().split("#");
				outPost.println("<tr>");
				outPost.println("<td>");
				outPost.println(ent_act_split[1]);
				outPost.println("</td>");
				outPost.println("<td>");
				outPost.println(ent_acts.get(i).getDuration());
				outPost.println("</td>");
			}
			outPost.println("</table>");
		}
	}

}
