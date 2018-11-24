package bean;

import dao.EixoProfissionalDAO;
import entidade.EixoProfissional;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class EixoProfissionalBean {
    
    private EixoProfissional eixoProfissional = new EixoProfissional();
    private EixoProfissionalDAO eixoProfissionalDAO;
    private List<EixoProfissional> eixosProfissionais;

    public EixoProfissionalBean() {
        this.eixoProfissionalDAO = new EixoProfissionalDAO();
        this.eixosProfissionais = this.retornaTodos();
    }
    
    public String cadastrar(){
        this.eixoProfissionalDAO.cadastrar(this.eixoProfissional);
        this.eixosProfissionais = this.retornaTodos();
        
        return "";
    }
    
    public String atualizar(){
        this.eixoProfissionalDAO.alterar(this.eixoProfissional);
        this.eixosProfissionais = this.retornaTodos();
        
        return "";
    }

    public String remover(){
        this.eixoProfissionalDAO.excluir(this.eixoProfissional);
        this.eixosProfissionais = this.retornaTodos();
        
        return "";
    }
    
    public List<EixoProfissional> retornaTodos(){
        return this.eixoProfissionalDAO.retornaTodos();
    }

    public EixoProfissional getEixoProfissional() {
        return eixoProfissional;
    }

    public void setEixoProfissional(EixoProfissional eixoProfissional) {
        this.eixoProfissional = eixoProfissional;
    }

    public List<EixoProfissional> getEixosProfissionais() {
        return eixosProfissionais;
    }

    public void setEixosProfissionais(List<EixoProfissional> eixosProfissionais) {
        this.eixosProfissionais = eixosProfissionais;
    }    
}