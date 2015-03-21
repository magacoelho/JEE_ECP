package es.votaciones.views.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.votaciones.persistence.models.entities.Tema;
import es.votaciones.persistence.models.entities.Voto;
import es.votaciones.persistence.models.utils.NivelEstudio;


@WebServlet("/jsp/*")
public class Dispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String PATH_ROOT_VIEW = "/ViewsJsp/";   
    
   
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo().substring(1);
		String view;
		switch(action){
		
			case "votar":       VotarViewBean votarView = new VotarViewBean();
						        request.setAttribute(action,votarView);
						        view=action;
								break;
			
			case "agregar":     AgregarViewBean agregarView = new AgregarViewBean();
						        agregarView.setTema(new Tema());
						        request.setAttribute(action,agregarView);
								view=action;
								break;
						
			case "verVotaciones":VerVotacionesViewBean verVotacionesView = new  VerVotacionesViewBean();
						        
						        request.setAttribute(action,verVotacionesView);
								view=action;
								break;
								
			case "eliminar":    EliminarViewBean eliminarViewBean = new EliminarViewBean();
	                            eliminarViewBean.setIdTema(new Integer(0));
	                            eliminarViewBean.setClaveBorrado(new Integer(0));
	                     		request.setAttribute(action,eliminarViewBean );
								view=action;
								break;
							
			default:
							    view="home";
							    break;
			}
		this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW+ view +"View.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo().substring(1);
		String view;
		Tema tema;
		request.setCharacterEncoding("UTF-8");
		switch(action){
		
			case "votar":       VotarViewBean votarView = new VotarViewBean();
						        Voto voto = new Voto();
						        voto.setNivelEstudio(NivelEstudio.valueOf(NivelEstudio.class, request.getParameter("nivelEstudios")));
						        String ipAddress = request.getHeader("X-FORWARDED-FOR");  
						        if (ipAddress == null) {  
						     	   ipAddress = request.getRemoteAddr();  
						        }
						        voto.setIp(ipAddress);
						        voto.setValoracion(Integer.parseInt(request.getParameter("valoracion")));
						        Tema tem = new Tema();
						        tem.setId(Integer.parseInt(request.getParameter("tema")));
						        voto.setTema(tem);
						        votarView.setVoto(voto);
						        request.setAttribute(action,votarView);
						        view=votarView.process();
								break;
			
			case "agregar":     tema = new Tema();
			                    tema.setDescripcion(request.getParameter("descripcion"));
			                    tema.setPregunta(request.getParameter("pregunta"));
				                AgregarViewBean agregarViewBean = new AgregarViewBean();
						        agregarViewBean.setTema(tema);
						        request.setAttribute(action,agregarViewBean);
								view=  agregarViewBean.process();
								break;
						
			case "verVotaciones":VerVotacionesViewBean verVotacionesView = new  VerVotacionesViewBean();
						        
						        request.setAttribute(action,verVotacionesView);
								view=action;
								break;
								
			case "eliminar":    EliminarViewBean eliminarViewBean = new EliminarViewBean();
			                   
	                            if(eliminarViewBean.isConAcceso())	
	                            	eliminarViewBean.setIdTema(Integer.parseInt(request.getParameter("tema")));
	                  
	                                	 eliminarViewBean.setClaveBorrado(Integer.parseInt(request.getParameter("claveBorrado")));    	
	                                request.setAttribute(action,eliminarViewBean);
								view=eliminarViewBean.process();
								break;
							
			default:
							    view="home";
							    break;
			}
		this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW+ view +"View.jsp").forward(request, response);
	}

}
