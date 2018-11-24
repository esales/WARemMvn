package utils;

import dao.CampusDAO;
import entidade.Campus;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("campusConverter")
public class CampusConverter implements Converter {
    
    private CampusDAO campusDAO = new CampusDAO();
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Campus campus;
        campus = null;
        try{
            Long idCampus = Long.parseLong(string);
            campus = this.campusDAO.retornarPorId(idCampus);
            
        }
        catch(Exception e){
            System.out.println(e.getClass() + "   " +e.getMessage());
                
        }
        return campus;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Campus campus = (Campus) o;
        return campus.getId()+ "";
    }
}
