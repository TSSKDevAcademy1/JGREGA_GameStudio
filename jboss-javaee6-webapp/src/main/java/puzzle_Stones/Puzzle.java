package puzzle_Stones;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/puzz")
public class Puzzle extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		final String ROW_COUNT = "row";
		final String COLUMN_COUNT = "column";
		final String CLICK_COUNT = "click";
		String newGame = "";
		int clicks = 0;
		int rowss = 3;
		int columnss = 3;

		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();
		Console console = (Console) session.getAttribute("console");

		try {
			clicks = Integer.parseInt(request.getParameter(CLICK_COUNT));
			clicks++;

			if (clicks % 2 == 0) {
				console.setRow1(Integer.parseInt(request.getParameter(ROW_COUNT)));
				console.setColumn1(Integer.parseInt(request.getParameter(COLUMN_COUNT)));
			} else {
				console.setRow2(Integer.parseInt(request.getParameter(ROW_COUNT)));
				console.setColumn2(Integer.parseInt(request.getParameter(COLUMN_COUNT)));
			}
		} catch (Exception e) {

		}

		try {
			if ("true".equals(request.getParameter("new"))) {
				newGame = "true";
				request.setAttribute("new", "false");
			} else {

			}
		} catch (Exception e) {

		}

		try {
			if (console == null || "true".equals(newGame)) {
				console = new Console(rowss, columnss);
				session.setAttribute("console", console);
				newGame = "false";
				clicks++;
				ImageSplit.Chunk(rowss, columnss, "gameStone");

			} else if (clicks % 2 != 0) {
				console.change();
			}
		} catch (Exception e) {

		}

		response.setContentType("text/html");
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel=\"stylesheet\" href=\"resources/css/style.css\">");
		out.println("<title>Hello world</title>");
		out.println("</head>");
		out.println("<body>");

		out.println("<div class=\"section group\">");//
		out.println("<div class=\"col span_3_of_12\"></div>");//
		out.println("<div class=\"col span_6_of_12\" style=\"border-radius:0px; border:5px solid #ffaa22;\">"); 

		for (int rows = 0; rows < console.getRows(); rows++) {
			for (int columns = 0; columns < console.getColumns(); columns++) {
				if (!console.Solved()) {
					out.print("<a href=\"?row=" + rows + "&column=" + columns + "&click=" + (clicks)
							+ "\"><img src=\"resources/images/img" + console.getValue(rows, columns) + ".jpg\"><a>");
				} else {
					out.print("<img  src=\"resources/images/img" + console.getValue(rows, columns) + ".jpg\">"); 
				}
			}
			out.print("</br>");
		}
		// out.print("</br>");
		out.print("</div>");
		out.println("<div class=\"col span_3_of_12\"></div>");
		out.println("</div>");
		out.print("<div id=\"button\">");
		out.printf("<a href=\"?new=true\" class=\"myButton\">New Game</a>"); // ?new=true
		out.print("</div>");
		if (console.Solved()) {
			out.print("</br><h1>You are WINNERRR</h1></a>");
		}
		out.println("</body>");
		out.println("</html>");

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
