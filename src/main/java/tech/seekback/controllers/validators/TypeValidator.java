
package tech.seekback.controllers.validators;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

/**
 * @author gkentaurus
 */
@ManagedBean
@Named
public class TypeValidator {

  /**
   * Validación de la información recibida en el formulario, de los campos asociados Requiere definir la longitud mínima
   * y máxima de la cadena de caracteres ingresada.
   *
   * @param context
   * @param component
   * @param value
   * @throws ValidatorException
   */
  public void inputType(FacesContext context, UIComponent component, Object value) throws ValidatorException {
    long minValue = (long) component.getAttributes().get("minValue");
    long maxValue = (long) component.getAttributes().get("maxValue");
    String dataType = (String) component.getAttributes().get("dataType");

    if (minValue > 0 && value == null) {
      throw new ValidatorException(new FacesMessage("Campo no puede estar vacío."));
    }

    switch (dataType) {
      case "text":
        if (minValue > 0) {
          if (((String) value).length() < minValue) {
            String message = "El valor ingresado debe tener al menos " + minValue + " caracteres.";
            throw new ValidatorException(new FacesMessage(message));
          }
        }
        if (maxValue > 0 && maxValue > minValue) {
          if (((String) value).length() > maxValue) {
            String message = "El valor ingresado debe tener menos de " + maxValue + " caracteres.";
            throw new ValidatorException(new FacesMessage(message));
          }
        }
        break;
      case "numeric":
        if (minValue > 0) {
          if ((Integer) value < minValue) {
            String message = "El numero ingresado debe ser mayor a " + minValue + ".";
            throw new ValidatorException(new FacesMessage(message));
          }
        }

        if (maxValue > 0 && maxValue > minValue) {
          if ((Integer) value > maxValue) {
            String message = "El numero ingresado debe ser menor a " + maxValue + ".";
            throw new ValidatorException(new FacesMessage(message));
          }
        }
        break;
      case "date":
        break;
      default:
        throw new ValidatorException(new FacesMessage("Error en el tipo de dato requerido."));
    }
  }
}
