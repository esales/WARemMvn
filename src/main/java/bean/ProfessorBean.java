package bean;

import dao.ProfessorDAO;
import entidade.Campus;
import entidade.Disciplina;
import entidade.Professor;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class ProfessorBean {
    private Professor professor = new Professor();
    private ProfessorDAO professorDAO;
    private List<Professor> professores;
    private List<Campus> campi;
    private List<Disciplina> disciplinas;

    public ProfessorBean() {
        this.professorDAO = new ProfessorDAO();
        this.professores = this.retornaTodos();
        this.campi = new CampusBean().retornaTodos();
        this.disciplinas = new DisciplinaBean().retornaTodos();
    }
    
    public String cadastrar(){
        this.professorDAO.cadastrar(this.professor);
        this.professores = this.retornaTodos();
        
        return "";
    }
    
    public String atualizar(){
        this.professorDAO.alterar(this.professor);
        this.professores = this.retornaTodos();
        
        return "";
    }

    public String remover(){
        this.professorDAO.excluir(this.professor);
        this.professores = this.retornaTodos();
        
        return "";
    }
    
    public List<Professor> retornaTodos(){
        return this.professorDAO.retornaTodos();
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
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
