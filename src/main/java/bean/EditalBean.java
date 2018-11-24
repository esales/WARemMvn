package bean;

import dao.EditalDAO;
import entidade.Edital;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class EditalBean {
    private Edital edital = new Edital();
    private EditalDAO editalDAO;
    private List<Edital> editais;

    public EditalBean() {
        this.editalDAO = new EditalDAO();
        this.editais = this.retornaTodos();
    }
    
    public String cadastrar(){
        this.editalDAO.cadastrar(this.edital);
        this.editais = this.retornaTodos();
        
        return "";
    }
    
    public String atualizar(){
        this.editalDAO.alterar(this.edital);
        this.editais = this.retornaTodos();
        
        return "";
    }

    public String remover(){
        this.editalDAO.excluir(this.edital);
        this.editais = this.retornaTodos();
        
        return "";
    }
    
    public List<Edital> retornaTodos(){
        return this.editalDAO.retornaTodos();
    }

    public Edital getEdital() {
        return edital;
    }

    public void setEdital(Edital edital) {
        this.edital = edital;
    }

    public List<Edital> getEditais() {
        return editais;
    }

    public void setEditais(List<Edital> editais) {
        this.editais = editais;
    }

    
}
