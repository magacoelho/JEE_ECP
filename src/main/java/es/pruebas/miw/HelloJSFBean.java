package es.pruebas.miw;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class HelloJSFBean {
    private String name="Hola, desde Bean. OK!!!";

    public String getName() {
        return name;
    }
}
