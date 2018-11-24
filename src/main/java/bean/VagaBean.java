package bean;

import dao.VagaDAO;
import entidade.Campus;
import entidade.Disciplina;
import entidade.Vaga;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class VagaBean {
    private Vaga vaga = new Vaga();
    private VagaDAO vagaDAO;
    private List<Vaga> vagas;
    private List<Campus> campi;
    private List<Disciplina> disciplinas;

    public VagaBean() {
        this.vagaDAO = new VagaDAO();
        this.vagas = this.retornaTodos();
        this.campi = new CampusBean().retornaTodos();
        this.disciplinas = new DisciplinaBean().retornaTodos();
    }
    
    public String cadastrar(){
        this.vagaDAO.cadastrar(this.vaga);
        this.vagas = this.retornaTodos();
        
        return "";
    }
    
    public String atualizar(){
        this.vagaDAO.alterar(this.vaga);
        this.vagas = this.retornaTodos();
        
        return "";
    }

    public String remover(){
        this.vagaDAO.excluir(this.vaga);
        this.vagas = this.retornaTodos();
        
        return "";
    }
    
    public List<Vaga> retornaTodos(){
        return this.vagaDAO.retornaTodos();
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public List<Vaga> getVagas() {
        return vagas;
    }

    public void setVagas(List<Vaga> vagas) {
        this.vagas = vagas;
    }

    public List<Campus> getCampi() {
        return campi;
    }

    public void setCampi(List<Campus> campi) {
        this.campi = campi;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    
}
