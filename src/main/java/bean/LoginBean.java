package bean;

import dao.UsuarioDAO;
import entidade.Funcionalidade;
import entidade.Usuario;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;

@ManagedBean
@SessionScoped
public class LoginBean {

    private String perfil = "";
    private DefaultMenuModel menuModel;
    private UsuarioDAO usuarioDAO;
    private Usuario usuario;
    private List<Usuario> usuarios;

    public LoginBean() {
        this.usuarioDAO = new UsuarioDAO();
        this.usuarios = this.usuarioDAO.retornaTodos();
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public DefaultMenuModel getMenuModel() {
        return menuModel;
    }

    public void setMenuModel(DefaultMenuModel menuModel) {
        this.menuModel = menuModel;
    }
    
    public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public String logar() {
        FacesContext context = FacesContext.getCurrentInstance();
        
        context.getExternalContext().getSessionMap().put("perfil", this.perfil);
        this.usuario = this.usuarioDAO.retornarPorId(1L);
        this.menuModel = this.retornaMenu(usuario);
        
        return "index";
    }

    public String deslogar() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login";
    }
    
    public DefaultMenuModel retornaMenu(Usuario usuarioTemp) {
        DefaultMenuModel menuTemp = new DefaultMenuModel();
        
        for(Funcionalidade funcionalidade:usuarioTemp.getPerfil().getFuncionalidades()){
            DefaultMenuItem item = new DefaultMenuItem();
            item.setUrl(funcionalidade.getUrl());
            item.setValue(funcionalidade.getRotulo());
            menuTemp.addElement(item);
        }
        
        menuTemp.generateUniqueIds();
        
        return menuTemp;
    }
}
