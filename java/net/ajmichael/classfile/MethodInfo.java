package net.ajmichael.classfile;

import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;

@AutoValue
public abstract class MethodInfo {
  public static Builder builder() {
    return new AutoValue_MethodInfo.Builder();
  }

  public abstract Short accessFlags();

  public abstract Short nameIndex();

  public abstract Short descriptorIndex();

  public abstract Short attributesCount();

  public abstract ImmutableList<AttributeInfo> attributes();

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract MethodInfo build();

    public abstract Builder setAccessFlags(Short value);

    public abstract Builder setNameIndex(Short value);

    public abstract Builder setDescriptorIndex(Short value);

    public abstract Builder setAttributesCount(Short value);

    public abstract Builder setAttributes(ImmutableList<AttributeInfo> value);
  }
}
