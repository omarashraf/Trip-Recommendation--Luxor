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
 * Servlet implementation class HelloWorld
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Luxor l = new Luxor();
		if (request.getParameter("season") != null) {
			String season = request.getParameter("season");
			ArrayList<String> cities = l.q1(season);
			for (int i = 0; i < cities.size(); i++) {
				String[] city_comp = cities.get(i).split("#");
				out.println("<h6>" + city_comp[1] + "</h6>");
			}
		}
		if (request.getParameter("category") != null) {
			String category = request.getParameter("category");
			ArrayList<String> cities = l.q2(category);
			for (int i = 0; i < cities.size(); i++) {
				String[] city_comp = cities.get(i).split("#");
				out.println("<h6>" + city_comp[1] + "</h6>");
			}
		}
	}

}
