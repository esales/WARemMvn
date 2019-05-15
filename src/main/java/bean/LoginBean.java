package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class LoginBean {
    private String perfil = "";

    public LoginBean() {
    }
    
    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
    public String logar(){
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getSessionMap().put("perfil", this.perfil);
        return "index";
    }
    
    public String deslogar(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login";
    }
}