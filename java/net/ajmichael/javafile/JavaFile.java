package net.ajmichael.javafile;

import com.google.auto.value.AutoValue;

import java.nio.file.Path;
import java.nio.file.Paths;

@AutoValue
public abstract class JavaFile {
  public static Builder builder() {
    return new AutoValue_JavaFile.Builder();
  }

  public Path path() {
    return Paths.get(fullName() + ".java");
  }

  public String name() {
    String[] pieces = fullName().split("/");
    return pieces[pieces.length - 1];
  }

  public abstract String fullName();

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract JavaFile build();

    public abstract Builder setFullName(String value);
  }
}
