package net.ajmichael.classfile;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class LongInfo implements ConstantPoolInfo {
  public static Builder builder() {
    return new AutoValue_LongInfo.Builder();
  }

  public Byte tag() {
    return 5;
  }

  public abstract Integer highBytes();

  public abstract Integer lowBytes();

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract LongInfo build();

    public abstract Builder setHighBytes(Integer value);

    public abstract Builder setLowBytes(Integer value);
  }
}
