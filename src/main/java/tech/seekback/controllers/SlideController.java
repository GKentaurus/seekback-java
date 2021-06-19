
package tech.seekback.controllers;

import tech.seekback.exceptions.ConnectionExcep;
import tech.seekback.models.Slide;
import tech.seekback.services.SlideService;
import tech.seekback.tools.UploadFileService;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * @author danny
 */
@Named
@ViewScoped
public class SlideController extends CustomController implements Serializable {

  @EJB
  private SlideService slideService;

  @EJB
  private UploadFileService uploadFileService;

  private Slide slide;
  private List<Slide> slides;

  public SlideService getSlideService() {
    return slideService;
  }

  public void setSlideService(SlideService slideService) {
    this.slideService = slideService;
  }

  public Slide getSlide() {
    return slide;
  }

  public void setSlide(Slide slide) {
    this.slide = slide;
  }

  public List<Slide> getSlides() {
    return slides;
  }

  public void setSlides(List<Slide> slides) {
    this.slides = slides;
  }

  public void create() throws ConnectionExcep {
    this.slideService.create(slide);
  }

  public void findOne(Integer id) throws ConnectionExcep {
    this.slide = this.slideService.getOne(id);
  }

  public void findAll() throws ConnectionExcep {
    this.slides = this.slideService.getAll();
  }

  public void update() throws ConnectionExcep {
    this.slideService.update(slide);
  }

  public void delete() throws ConnectionExcep {
    this.slideService.delete(slide);
  }

}
