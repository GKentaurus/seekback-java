package tech.seekback.models.interfaces;

import tech.seekback.models.templates.Timestamps;

import java.io.Serializable;

public interface EntityTimestamp extends Serializable {
  Timestamps getTimestamps();

  void setTimestamps(Timestamps timestamps);
}
