package net.ajmichael.classfile;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class FieldRefInfo implements ConstantPoolInfo {
  public static Builder builder() {
    return new AutoValue_FieldRefInfo.Builder();
  }

  public Byte tag() {
    return 9;
  }

  public abstract Short classIndex();

  public abstract Short nameAndTypeIndex();

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract FieldRefInfo build();

    public abstract Builder setClassIndex(Short value);

    public abstract Builder setNameAndTypeIndex(Short value);
  }
}
