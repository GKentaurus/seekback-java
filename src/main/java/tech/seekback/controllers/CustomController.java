/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tech.seekback.controllers;


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
public class CustomController {
  /**
   * Validación de la información recibida en el formulario, de los campos asociados
   * Requiere definir la longitud mínima y máxima de la cadena de caracteres ingresada.
   *
   * @param context
   * @param component
   * @param value
   * @throws ValidatorException
   */
  public void validateString(FacesContext context, UIComponent component, Object value) throws ValidatorException {
    int minLength = 3;
    if (((String) value).length() < minLength) {
      String message = "El valor ingresado debe tener al menos "
        + minLength
        + " caracteres";
      throw new ValidatorException(new FacesMessage(message));
    }
  }

  /**
   * Validación de la información recibida en el formulario, de los campos asociados
   * Requiere definir el valor mínimo y máximo del número ingresado..
   *
   * @param context
   * @param component
   * @param value
   * @throws ValidatorException
   */
  public void validateNumeric(FacesContext context, UIComponent component, Object value) throws ValidatorException {
    long minValue = 0;
    if ((long) value < minValue) {
      String message = "El número ingresado debe ser mayor a '" + minValue + "'.";
      throw new ValidatorException(new FacesMessage(message));
    }
  }
}
