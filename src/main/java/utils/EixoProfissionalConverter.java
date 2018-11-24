package utils;

import dao.EixoProfissionalDAO;
import entidade.EixoProfissional;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("eixoProfissionalConverter")
public class EixoProfissionalConverter implements Converter {
    
    private EixoProfissionalDAO eixoProfissionalDAO = new EixoProfissionalDAO();
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        EixoProfissional eixoProfissional;
        eixoProfissional = null;
        try{
            Long idEixo = Long.parseLong(string);
            eixoProfissional = this.eixoProfissionalDAO.retornarPorId(idEixo);
            
        }
        catch(Exception e){
            System.out.println(e.getClass() + "   " +e.getMessage());
                
        }
        return eixoProfissional;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        EixoProfissional eixoProfissional = (EixoProfissional) o;
        return eixoProfissional.getId()+ "";
    }
}
