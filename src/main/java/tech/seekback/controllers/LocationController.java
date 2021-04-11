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
  private List<Locale> availableLocales;

  @PostConstruct
  public void init() {
    this.locale = new Locale("es");
    this.availableLocales = new ArrayList<>();

    this.availableLocales.add(new Locale("es"));
    this.availableLocales.add(new Locale("en"));
  }

  public Locale getLocale() {
    return locale;
  }
  public void setLocale(Locale locale) {
    this.locale = locale;
  }

  public List<Locale> getAvailableLocales() {
    return availableLocales;
  }
}
