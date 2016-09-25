package net.ajmichael.javad;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Foo {
  public static Builder builder() {
    return new AutoValue_Foo.Builder();
  }

  public abstract Integer getFoo();

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Foo builder();

    public abstract Builder setFoo(Integer value);
  }
}
