package net.ajmichael.dexfile;

import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;

@AutoValue
public abstract class ClassData {
  public static Builder builder() {
    return new AutoValue_ClassData.Builder();
  }

  public abstract int staticFieldsSize();

  public abstract int instanceFieldsSize();

  public abstract int directMethodsSize();

  public abstract int virtualMethodsSize();

  public abstract ImmutableList<EncodedField> staticFields();

  public abstract ImmutableList<EncodedField> instanceFields();

  public abstract ImmutableList<EncodedField> directMethods();

  public abstract ImmutableList<EncodedField> virtualMethods();

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract ClassData build();

    public abstract Builder setStaticFieldsSize(int value);

    public abstract Builder setInstanceFieldsSize(int value);

    public abstract Builder setDirectMethodsSize(int value);

    public abstract Builder setVirtualMethodsSize(int value);

    public abstract Builder setStaticFields(ImmutableList<EncodedField> value);

    public abstract Builder setInstanceFields(ImmutableList<EncodedField> value);

    public abstract Builder setDirectMethods(ImmutableList<EncodedField> value);

    public abstract Builder setVirtualMethods(ImmutableList<EncodedField> value);
  }
}
