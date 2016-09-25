package net.ajmichael.classfile;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class InterfaceMethodRefInfo implements ConstantPoolInfo {
  public static Builder builder() {
    return new AutoValue_InterfaceMethodRefInfo.Builder();
  }

  public Byte tag() {
    return 11;
  }

  public abstract Short classIndex();

  public abstract Short nameAndTypeIndex();

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract InterfaceMethodRefInfo build();

    public abstract Builder setClassIndex(Short value);

    public abstract Builder setNameAndTypeIndex(Short value);
  }
}
