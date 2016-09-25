package net.ajmichael.classfile;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class DoubleInfo implements ConstantPoolInfo {
  public static Builder builder() {
    return new AutoValue_DoubleInfo.Builder();
  }

  public Byte tag() {
    return 6;
  }

  public abstract Integer highBytes();

  public abstract Integer lowBytes();

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract DoubleInfo build();

    public abstract Builder setHighBytes(Integer value);

    public abstract Builder setLowBytes(Integer value);
  }
}
