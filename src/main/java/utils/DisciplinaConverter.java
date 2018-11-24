package utils;

import dao.DisciplinaDAO;
import entidade.Disciplina;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("disciplinaConverter")
public class DisciplinaConverter implements Converter {
    
    private DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Disciplina disciplina;
        disciplina = null;
        try{
            Long idDisciplina = Long.parseLong(string);
            disciplina = this.disciplinaDAO.retornarPorId(idDisciplina);
            
        }
        catch(Exception e){
            System.out.println(e.getClass() + "   " +e.getMessage());
                
        }
        return disciplina;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Disciplina disciplina = (Disciplina) o;
        return disciplina.getId()+ "";
    }
}
