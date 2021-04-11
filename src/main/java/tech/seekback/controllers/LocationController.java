package tech.seekback.controllers;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Named
@SessionScoped
public class LocationController implements Serializable {

  private Locale locale;
  private String localefront;
  private List<Locale> availableLocales;

  @PostConstruct
  public void init() {
    this.locale = new Locale("es");
    this.availableLocales = new ArrayList<>();

    this.availableLocales.add(new Locale("es"));
    this.availableLocales.add(new Locale("en"));
  }

  public String getLocalefront() {
    return localefront;
  }

  public void setLocalefront(String localefront) {
    this.localefront = localefront;
  }

  public Locale getLocale() {
    return locale;
  }

  public void setLocale() {
    this.locale = new Locale(this.localefront);
  }

  public List<Locale> getAvailableLocales() {
    return availableLocales;
  }
}
