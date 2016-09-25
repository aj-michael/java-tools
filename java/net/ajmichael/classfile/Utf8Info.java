package net.ajmichael.classfile;

import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;

@AutoValue
public abstract class Utf8Info implements ConstantPoolInfo {
  public static Builder builder() {
    return new AutoValue_Utf8Info.Builder();
  }

  public Byte tag() {
    return 1;
  }

  public abstract Short length();

  public abstract ImmutableList<Byte> bytes();

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract Utf8Info build();

    public abstract Builder setLength(Short value);

    public abstract Builder setBytes(ImmutableList<Byte> value);
  }
}
