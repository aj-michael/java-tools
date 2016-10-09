package net.ajmichael.classfile;

import com.google.auto.value.AutoValue;

import java.nio.ByteBuffer;

@AutoValue
public abstract class InvokeDynamicInfo implements ConstantPoolInfo {
  public static InvokeDynamicInfo parse(ByteBuffer classFile) {
    return InvokeDynamicInfo.builder()
        .setBootstrapMethodAttrIndex(classFile.getShort())
        .setNameAndTypeIndex(classFile.getShort())
        .build();
  }

  public static Builder builder() {
    return new AutoValue_InvokeDynamicInfo.Builder();
  }

  public Byte tag() {
    return 18;
  }

  public abstract Short bootstrapMethodAttrIndex();

  public abstract Short nameAndTypeIndex();

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract InvokeDynamicInfo build();

    public abstract Builder setBootstrapMethodAttrIndex(Short value);

    public abstract Builder setNameAndTypeIndex(Short value);
  }
}
