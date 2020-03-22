package pl.luckit.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.regex.Pattern;

public class EmailValidator implements Validator {

    Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
            String input = (String) value;

            if (!pattern.matcher(input).matches()){
                throw new ValidatorException(new FacesMessage("Podany adres e-mail nie jest w poprawnym formacie!"));
            }
    }
}
