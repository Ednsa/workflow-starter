package conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


import model.Skill;
import model.dao.SkillDAO;

@FacesConverter(value="skill-converter", forClass=Skill.class)
public class SkillConverter implements Converter {

	@Override
	//PROCURAR ENTENDER MELHOR ESTE TRECHO
	public Object getAsObject(FacesContext context, UIComponent component, String value) {


		System.out.println("SkillConverter.getAsObject()");
		
		Skill skill = null;
		Integer id;
		
		try {
			id = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			id = null;
		}
		
		SkillDAO skillDAO = new SkillDAO();
		if (id != null)
			 skill = skillDAO.loadById(id);
		
		return skill;

	}
	
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		System.out.println("SkillConverter.getAsString()");
		
		if (value instanceof Skill)
		{
			Skill skill = (Skill) value;
			return skill.getId().toString();
		}
		return null;
			
	}



}
