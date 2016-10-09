package net.ajmichael.classfile;

import com.google.auto.value.AutoValue;

import java.nio.ByteBuffer;

@AutoValue
public abstract class NameAndTypeInfo implements ConstantPoolInfo {
  public static NameAndTypeInfo parse(ByteBuffer classFile) {
    return NameAndTypeInfo.builder()
        .setNameIndex(classFile.getShort())
        .setDescriptorIndex(classFile.getShort())
        .build();
  }

  public static Builder builder() {
    return new AutoValue_NameAndTypeInfo.Builder();
  }

  public Byte tag() {
    return 12;
  }

  public abstract Short nameIndex();

  public abstract Short descriptorIndex();

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract NameAndTypeInfo build();

    public abstract Builder setNameIndex(Short value);

    public abstract Builder setDescriptorIndex(Short value);
  }
}
