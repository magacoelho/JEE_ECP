package es.votaciones.views.beans;

import java.io.IOException;

import javax.naming.ldap.ControlFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.votaciones.controllers.ControllerFactory;
import es.votaciones.controllers.ejb.ControllerEjbFactory;
import es.votaciones.persistence.models.entities.Tema;
import es.votaciones.persistence.models.entities.Voto;
import es.votaciones.persistence.models.utils.NivelEstudio;


@WebServlet("/jsp/*")
public class Dispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String PATH_ROOT_VIEW = "/ViewsJsp/";   
	private ControllerFactory controllerFactory;
   
	@Override
	public void init() throws ServletException {
		 controllerFactory = new ControllerEjbFactory();
		
	}


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo().substring(1);
		request.setCharacterEncoding("UTF-8");
		String view;
		switch(action){
		
			case "votar":       VotarViewBean votarView = new VotarViewBean();
			                    votarView.setControllerFactory(controllerFactory);
						        request.setAttribute(action,votarView);
						        view=action;
								break;
			
			case "agregar":     AgregarViewBean agregarView = new AgregarViewBean();
						        agregarView.setTema(new Tema());
						        agregarView.setControllerFactory(controllerFactory);
						        request.setAttribute(action,agregarView);
								view=action;
								break;
						
			case "verVotaciones":VerVotacionesViewBean verVotacionesView = new  VerVotacionesViewBean();
						        verVotacionesView.setControllerFactory(controllerFactory);
						        request.setAttribute(action,verVotacionesView);
								view=action;
								break;
								
			case "preeliminar": PreEliminarViewBean preEliminarViewBean = new PreEliminarViewBean();
			                    preEliminarViewBean.setControllerFactory(controllerFactory);
	                            preEliminarViewBean.setClaveBorrado(new Integer(0));
	                     		request.setAttribute(action,preEliminarViewBean );
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
						        votarView.setControllerFactory(controllerFactory);
						        request.setAttribute(action,votarView);
						        view=votarView.process();
								break;
			
			case "agregar":     tema = new Tema();
			                    tema.setDescripcion(request.getParameter("descripcion"));
			                    tema.setPregunta(request.getParameter("pregunta"));
				                AgregarViewBean agregarViewBean = new AgregarViewBean();
						        agregarViewBean.setTema(tema);
						        agregarViewBean.setControllerFactory(controllerFactory);
						        request.setAttribute(action,agregarViewBean);
								view=  agregarViewBean.process();
								break;
						
			case "verVotaciones":VerVotacionesViewBean verVotacionesView = new  VerVotacionesViewBean();
								verVotacionesView.setControllerFactory(controllerFactory);
						        request.setAttribute(action,verVotacionesView);
								view=action;
								break;
			case "preeliminar": PreEliminarViewBean preEliminarViewBean = new PreEliminarViewBean();
							    preEliminarViewBean.setClaveBorrado(Integer.parseInt(request.getParameter("claveBorrado")));
							    preEliminarViewBean.setControllerFactory(controllerFactory);
							    request.setAttribute(action,preEliminarViewBean);
				                view=preEliminarViewBean.process();
				                EliminarViewBean eliminarViewBean1 = new EliminarViewBean();
				                eliminarViewBean1.setControllerFactory(controllerFactory);
				                request.setAttribute("eliminar",eliminarViewBean1);
							    break;	
			case "eliminar":    EliminarViewBean eliminarViewBean = new EliminarViewBean();
			                    eliminarViewBean.setIdTema(Integer.parseInt(request.getParameter("tema")));
			                    eliminarViewBean.setControllerFactory(controllerFactory);
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
