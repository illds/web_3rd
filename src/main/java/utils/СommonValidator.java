package utils;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class СommonValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        FacesMessage message = new FacesMessage();
        if(o.toString().length() == 0){
            message.setSummary("You haven’t entered anything");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }

        else if(!Utils.isNumeric(o.toString())){
            message.setSummary("Enter a number");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
        else if(!validateRange(Float.parseFloat(o.toString()))){
            message.setSummary("Range must be in (-5..5)");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }

    public boolean validateRange(float value) {
        return (value > -5 && value < 5);
    }

}
