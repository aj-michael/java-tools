package net.ajmichael.classfile;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class StringInfo implements ConstantPoolInfo {
  public static Builder builder() {
    return new AutoValue_StringInfo.Builder();
  }

  public Byte tag() {
    return 8;
  }

  public abstract Short stringIndex();

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract StringInfo build();

    public abstract Builder setStringIndex(Short value);
  }
}
