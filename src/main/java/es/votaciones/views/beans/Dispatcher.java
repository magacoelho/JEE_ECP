package es.votaciones.views.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Dispatcher
 */
@WebServlet("/Votaciones/*")
public class Dispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String PATH_ROOT_VIEW = "/Votaciones/";   
    
    public Dispatcher() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo().substring(1);
		String view;
		switch(action){
		
		case "votar":
			        VotarView votarView = new VotarView();
			        
			        request.setAttribute(action,votarView);
			        view="action";
					break;
		
		case "agregar":
			        AgregarView agregarView = new AgregarView();
			        
			        request.setAttribute(action,agregarView);
					view="action";
					break;
					
		case "verVotaciones":
							view="action";
							break;
							
		case "eliminar":
						view="action";
						break;
						
		default:
			    view="home";
			    break;
			}
		this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW+ view +".jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
