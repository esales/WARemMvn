package bean;

import dao.CampusDAO;
import entidade.Campus;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class CampusBean {
    private Campus campus = new Campus();
    private CampusDAO campusDAO;
    private List<Campus> campi;

    public CampusBean() {
        this.campusDAO = new CampusDAO();
        this.campi = this.retornaTodos();
    }
    
    public String cadastrar(){
        this.campusDAO.cadastrar(this.campus);
        this.campi = this.retornaTodos();
        
        return "";
    }
    
    public String atualizar(){
        this.campusDAO.alterar(this.campus);
        this.campi = this.retornaTodos();
        
        return "";
    }

    public String remover(){
        this.campusDAO.excluir(this.campus);
        this.campi = this.retornaTodos();
        
        return "";
    }
    
    public List<Campus> retornaTodos(){
        return this.campusDAO.retornaTodos();
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public List<Campus> getCampi() {
        return campi;
    }

    public void setCampi(List<Campus> campi) {
        this.campi = campi;
    }

    
}
