package net.ajmichael.classfile;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class MethodTypeInfo implements ConstantPoolInfo {
  public static Builder builder() {
    return new AutoValue_MethodTypeInfo.Builder();
  }

  public Byte tag() {
    return 16;
  }

  public abstract Short descriptorIndex();

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract MethodTypeInfo build();

    public abstract Builder setDescriptorIndex(Short value);
  }
}
