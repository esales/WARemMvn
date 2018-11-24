package bean;

import dao.DisciplinaDAO;
import entidade.Disciplina;
import entidade.EixoProfissional;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class DisciplinaBean {

    private Disciplina disciplina = new Disciplina();
    private DisciplinaDAO disciplinaDAO;
    private List<Disciplina> disciplinas;
    private EixoProfissionalBean eixoProfissionalBean;
    private List<EixoProfissional> eixosProfissionais;
    private EixoProfissional eixoProfissional;

    public DisciplinaBean() {
        this.disciplinaDAO = new DisciplinaDAO();
        this.disciplinas = this.retornaTodos();
        this.eixoProfissionalBean = new EixoProfissionalBean();
        this.eixosProfissionais = this.retornaEixosProfissionais();
        this.eixoProfissional = new EixoProfissional();
    }
    
    public String cadastrar(){
        this.disciplinaDAO.cadastrar(this.disciplina);
        this.disciplinas = this.retornaTodos();
        
        return "";
    }
    
    public String atualizar(){
        this.disciplinaDAO.alterar(this.disciplina);
        this.disciplinas = this.retornaTodos();
        
        return "";
    }

    public String remover(){
        this.disciplinaDAO.excluir(this.disciplina);
        this.disciplinas = this.retornaTodos();
        
        return "";
    }
    
    public List<Disciplina> retornaTodos(){
        return this.disciplinaDAO.retornaTodos();
    }
    
    public List<EixoProfissional> retornaEixosProfissionais(){
        return this.eixoProfissionalBean.retornaTodos();
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public List<EixoProfissional> getEixosProfissionais() {
        return eixosProfissionais;
    }

    public void setEixosProfissionais(List<EixoProfissional> eixosProfissionais) {
        this.eixosProfissionais = eixosProfissionais;
    }
    
    
}
