package net.ajmichael.classfile;

import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;

@AutoValue
public abstract class AttributeInfo {
  public static Builder builder() {
    return new AutoValue_AttributeInfo.Builder();
  }

  public abstract Short attributeNameIndex();

  public abstract Integer attributeLength();

  public abstract ImmutableList<Byte> info();

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract AttributeInfo build();

    public abstract Builder setAttributeNameIndex(Short value);

    public abstract Builder setAttributeLength(Integer value);

    public abstract Builder setInfo(ImmutableList<Byte> value);
  }
}
