package net.ajmichael.classfile;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class ClassInfo implements ConstantPoolInfo {
  public static Builder builder() {
    return new AutoValue_ClassInfo.Builder();
  }

  public Byte tag() {
    return 7;
  }

  public abstract Short nameIndex();

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract ClassInfo build();

    public abstract Builder setNameIndex(Short value);
  }
}
