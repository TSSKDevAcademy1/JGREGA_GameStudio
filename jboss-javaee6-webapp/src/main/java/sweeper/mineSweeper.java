package sweeper;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.validator.internal.util.privilegedactions.GetAnnotationParameter;

import gameStudio.Score;
import gameStudio.ScoreService;

@WebServlet("/sweeper")
public class mineSweeper extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		final String ROW_COUNT = "row";
		final String COLUMN_COUNT = "column";
		int row;
		int column;
		String game = "";	
		long startTime;
		long endTime;

		HttpSession session = request.getSession();
		Field field = (Field) session.getAttribute("field");		
		
		String marker = request.getParameter("Marker");
		if(marker == null){
			marker = "false";
		}		
		
		// Skusam ci nieje pozadovana nova hra
				try {
					game = request.getParameter("gameN").trim();

				} catch (NullPointerException e) {

				}
				
				// Ak je nova hra
				try{
				if (field == null || "novaHra".equals(game)) {
					startTime=System.currentTimeMillis();
					field = new Field(10, 10, 5,startTime);
					session.setAttribute("field", field);					
				} else if("false".equals(marker.trim())){
					row = Integer.parseInt(request.getParameter(ROW_COUNT));
					column = Integer.parseInt(request.getParameter(COLUMN_COUNT));
					field.openTile(row, column);	
				}else if("true".equals(marker.trim())){
					row = Integer.parseInt(request.getParameter(ROW_COUNT));
					column = Integer.parseInt(request.getParameter(COLUMN_COUNT));
					field.markTile(row, column);
				}
				}catch(Exception e){
					
				}
		
		response.setContentType("text/html");		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello world</title>");
		out.println("<link rel=\"stylesheet\" href=\"resources/css/style.css\" />");
		out.println("</head>");
		out.println("<body>");			

		out.print("<a href=\"?gameN=novaHra\" class=\"myButton\">Nova Hra</a>");
				
		if("true".equals(marker)){
			out.printf("<a href=\"?Marker=false\" name=\"Marker\" class=\"myButton\"> Mark </a>");
		}else if("false".equals(marker)){
			out.printf("<a href=\"?Marker=true\" name=\"Marker\" class=\"myButton\"> Open </a>");			
		}	
		System.out.println(marker);	

		out.println("</br>");			

		for (int rows = 0; rows < field.getRowCount(); rows++) {
			for (int columns = 0; columns < field.getColumnCount(); columns++) {

				Tile tile = field.getTiles(rows, columns);
				String value = tile.toString();

				// Ak je policko zavrete
				if (field.getTiles(rows, columns).getState() == Tile.State.CLOSED
						&& field.getState() != GameState.SOLVED && field.getState() != GameState.FAILED) {
					if("true".equals(marker)){
						out.print("<a href=\"?Marker=true&row=" + rows + "&column=" + columns
								+ "\"><img src=\"resources/gfx/closed.png\"></a>");
					}else{
						out.print("<a href=\"?Marker=false&row=" + rows + "&column=" + columns
								+ "\"><img src=\"resources/gfx/closed.png\"></a>");
					}
				} else if (field.getTiles(rows, columns).getState() == Tile.State.CLOSED) {
					if (tile instanceof Mine) {
						out.print("<img src=\"resources/gfx/mineClosed.png\">");
					} else {
						Clue clue = (Clue) tile;
						int values = clue.getValue();
						out.print("<img src=\"resources/gfx/open" + values + ".png\">");
					}
				}

				// Ak je policko otvorene
				if (field.getTiles(rows, columns).getState() == Tile.State.OPEN) {
					if (tile instanceof Mine) {
						out.print("<a href=\"?row=" + rows + "&column=" + columns
								+ "\"><img src=\"resources/gfx/mine.png\"></a>");
					} else {
						out.print("<a href=\"?row=" + rows + "&column=" + columns + "\"><img src=\"resources/gfx/open"
								+ value + ".png\"></a>");
					}
				} else if (field.getTiles(rows, columns).getState() == Tile.State.MARKED) {
					out.print("<a href=\"?Marker=true&row=" + rows + "&column=" + columns
							+ "\"><img src=\"resources/gfx/marked.png\"></a>");
				}
			}
			out.print("</br>");
		}		

		// Ak je hra vyriesiena alebo ak uzivatel prehral
		if (field.getState() == GameState.SOLVED) {
			endTime = System.currentTimeMillis();			
			field.finishTime(endTime,"Sweeper");			
			out.print("<h1> You are the WINNER!!!</h1>");
		} else if (field.getState() == GameState.FAILED) {
			out.print("<h1>Game OverO!!</h1>");
		}
		out.println("</body>");
		out.println("</html>");
	}

	// vola sa ked je zavolana zo strany klienta na server
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
