package net.ajmichael.classfile;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class MethodRefInfo implements ConstantPoolInfo {
  public static Builder builder() {
    return new AutoValue_MethodRefInfo.Builder();
  }

  public Byte tag() {
    return 10;
  }

  public abstract Short classIndex();

  public abstract Short nameAndTypeIndex();

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract MethodRefInfo build();

    public abstract Builder setClassIndex(Short value);

    public abstract Builder setNameAndTypeIndex(Short value);
  }
}
