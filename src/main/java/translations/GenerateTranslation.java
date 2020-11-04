package translations;

import java.io.*;
import java.util.ArrayList;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.Properties;

@Named
@RequestScoped
public class GenerateTranslation {

  public static void main(String[] args){
    ArrayList<String[]> index = new ArrayList<>();
    index.add(addList("hola1", "mundo"));
    index.add(addList("hola2", "carlos"));
    index.add(addList("hola3", "veronica"));
    
    generateFile(index, "test");
  }

  public static void generateFile(ArrayList<String[]> params, String fileName) {
    try (OutputStream output = new FileOutputStream("src\\main\\java\\translations\\" + fileName + ".properties")) {
      Properties prop = new Properties();

      for (String[] param : params) {
        System.out.println("hola");
        prop.setProperty(param[0], param[1]);
      }
      
      prop.store(output, null);
    } catch (IOException io) {
      io.printStackTrace();
    }
  }
  
  public static String[] addList(String key, String value) {
    String[] prop =  {key, value};
    return prop;

  }
}
