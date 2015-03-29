package es.votaciones.views.beans;

import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class I18n {

    private Locale locale;

  
    public I18n() {
       
   }
    @PostConstruct
    public void inciializa(){
        this.locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
    }
    public Locale getLocale() {
        return this.locale;
    }
   public void setLocale(Locale locale) {
	this.locale = locale;
}
   
    public String change(String language) {
        this.locale = new Locale(language);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
        return null;
    }

    public String msg(String key) {
        return ResourceBundle.getBundle("i18n.messages", this.locale).getString(key);
    }

}
