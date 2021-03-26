
package tech.seekback.controllers.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author gkentaurus
 */
@FacesConverter(value = "DocumentNumberConverter")
public class DocumentNumberConverter implements Converter {

  public String pattern;

  public DocumentNumberConverter() {
    setPattern("###,###,###");
  }

  @Override
  public Object getAsObject(FacesContext context, UIComponent component, String value) {
    if (value != null && value.length() > getPattern().length()) {
      throw new ConverterException("Formato no válido.");
    }

    return Integer.parseInt(value);
  }

  @Override
  public String getAsString(FacesContext context, UIComponent component, Object value) {
    if (value != null) {
      String original = String.valueOf(value);
      String toReturn = "";
      for (int index = original.length(); index > 0; index--) {
        String splited = original.substring(index - 1, index);
        toReturn = splited + toReturn;
        if ((index + 1) % 3 == 0 && index != original.length()) {
          toReturn = "." + toReturn;
        }
      }
      return toReturn;
    }
    return "No hay registro.";
  }

  public String getPattern() {
    return pattern;
  }

  public void setPattern(String pattern) {
    this.pattern = pattern;
  }
}
