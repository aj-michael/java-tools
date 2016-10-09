package net.ajmichael.classfile;

import com.google.auto.value.AutoValue;

import java.nio.ByteBuffer;

@AutoValue
public abstract class FieldRefInfo implements ConstantPoolInfo {
  public static FieldRefInfo parse(ByteBuffer classFile) {
    return FieldRefInfo.builder()
        .setClassIndex(classFile.getShort())
        .setNameAndTypeIndex(classFile.getShort())
        .build();
  }

  public static Builder builder() {
    return new AutoValue_FieldRefInfo.Builder();
  }

  public Byte tag() {
    return 9;
  }

  public abstract Short classIndex();

  public abstract Short nameAndTypeIndex();

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract FieldRefInfo build();

    public abstract Builder setClassIndex(Short value);

    public abstract Builder setNameAndTypeIndex(Short value);
  }
}
