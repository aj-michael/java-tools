package net.ajmichael.classfile;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class MethodHandleInfo implements ConstantPoolInfo {
  public static Builder builder() {
    return new AutoValue_MethodHandleInfo.Builder();
  }

  public Byte tag() {
    return 15;
  }

  public abstract Byte referenceKind();

  public abstract Short referenceIndex();

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract MethodHandleInfo build();

    public abstract Builder setReferenceKind(Byte value);

    public abstract Builder setReferenceIndex(Short value);
  }
}
