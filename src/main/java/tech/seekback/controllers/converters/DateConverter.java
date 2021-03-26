
package tech.seekback.controllers.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author gkentaurus
 */
@FacesConverter(value = "DateConverter")
public class DateConverter implements Converter {

  public String pattern;

  public DateConverter() {
    setPattern("dd/MM/yyyy");
  }

  @Override
  public Object getAsObject(FacesContext context, UIComponent component, String value) {
    if (value == null) {
      throw new ConverterException(new FacesMessage("Ingrese la fecha de nacimiento."));
    }

    if (value.length() < getPattern().length() - 2) {
      throw new ConverterException(new FacesMessage("Formato no válido."));
    }

    Date date;
    try {
      date = new SimpleDateFormat(getPattern()).parse(value);
    } catch (ParseException ex) {
      throw new ConverterException();
    }
    return date;
  }

  @Override
  public String getAsString(FacesContext context, UIComponent component, Object value) {
    if (value != null) {
      DateFormat dateFormat = new SimpleDateFormat(getPattern());
      return dateFormat.format((Date) value);
    }
    return "No hay fecha registrada";
  }

  public String getPattern() {
    return pattern;
  }

  public void setPattern(String pattern) {
    this.pattern = pattern;
  }

}
