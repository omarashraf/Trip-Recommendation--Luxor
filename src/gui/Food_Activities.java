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
 * Servlet implementation class Food_Activities
 */
@WebServlet("/Food_Activities")
public class Food_Activities extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Luxor l = new Luxor();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Food_Activities() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter outGet = response.getWriter();
		if (request.getParameter("q20") != null) {
			ArrayList<FoodActivities> food_act = l.q20();
			outGet.println("<table>");
			for (int i = 0; i < food_act.size(); i++) {
				String[] food_act_comp = food_act.get(i).getName().split("#");
				outGet.println("<tr>");
				outGet.println("<td>" + food_act_comp[1] + "</td>");
				food_act_comp = food_act.get(i).getCuisine().split("#");
				outGet.println("<td>" + food_act_comp[1] + "</td>");
				outGet.println("</tr>");
			}
			outGet.println("</table>");
		}
		
		if (request.getParameter("q23") != null) {
			ArrayList<FoodActivities> food_act = l.q23();
			outGet.println("<table>");
			for (int i = 0; i < food_act.size(); i++) {
				String[] food_act_comp = food_act.get(i).getName().split("#");
				outGet.println("<tr>");
				outGet.println("<td>" + food_act_comp[1] + "</td>");
				outGet.println("<td>" + food_act.get(i).getRating() + "</td>");
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
		if (request.getParameter("cuisine") != null) {
			String cuisine = request.getParameter("cuisine");
			ArrayList<FoodActivities> food_act = l.q21(cuisine);
			for (int i = 0; i < food_act.size(); i++) {
				String[] food_act_comp = food_act.get(i).getName().split("#");
				outPost.println("<h6>" + food_act_comp[1] + "</h6>");
			}
		}
		
		if (request.getParameter("cuisine_cheap") != null) {
			String cuisine = request.getParameter("cuisine_cheap");
			ArrayList<FoodActivities> food_act = l.q22(cuisine);
			outPost.println("<table>");
			for (int i = 0; i < food_act.size(); i++) {
				String[] food_act_comp = food_act.get(i).getName().split("#");
				outPost.println("<tr>");
				outPost.println("<td>" + food_act_comp[1] + "</td>");
				outPost.println("<td>" + food_act.get(i).getPrice() + "</td>");
				outPost.println("</tr>");
			}
			outPost.println("</table>");
		}
		
		if (request.getParameter("cuisine_rating") != null) {
			String cuisine = request.getParameter("cuisine_rating");
			ArrayList<FoodActivities> food_act = l.q24(cuisine);
			outPost.println("<table>");
			for (int i = 0; i < food_act.size(); i++) {
				String[] food_act_comp = food_act.get(i).getName().split("#");
				outPost.println("<tr>");
				outPost.println("<td>" + food_act_comp[1] + "</td>");
				outPost.println("<td>" + food_act.get(i).getRating() + "</td>");
				outPost.println("</tr>");
			}
			outPost.println("</table>");
		}
	}

}
