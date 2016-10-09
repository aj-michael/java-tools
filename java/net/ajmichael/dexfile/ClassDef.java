package net.ajmichael.dexfile;

import com.google.auto.value.AutoValue;

import java.nio.ByteBuffer;

@AutoValue
public abstract class ClassDef {
  public static ClassDef parse(ByteBuffer byteBuffer) {
    return builder()
        .setClassIndex(byteBuffer.getInt())
        .setAccessFlags(byteBuffer.getInt())
        .setSuperclassIndex(byteBuffer.getInt())
        .setInterfacesOffset(byteBuffer.getInt())
        .setSourceFileIndex(byteBuffer.getInt())
        .setAnnotationsOffset(byteBuffer.getInt())
        .setClassDataOffset(byteBuffer.getInt())
        .setStaticValuesOffset(byteBuffer.getInt())
        .build();
  }

  public static Builder builder() {
    return new AutoValue_ClassDef.Builder();
  }

  public abstract int classIndex();

  public abstract int accessFlags();

  public abstract int superclassIndex();

  public abstract int interfacesOffset();

  public abstract int sourceFileIndex();

  public abstract int annotationsOffset();

  public abstract int classDataOffset();

  public abstract int staticValuesOffset();

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract ClassDef build();

    public abstract Builder setClassIndex(int value);

    public abstract Builder setAccessFlags(int value);

    public abstract Builder setSuperclassIndex(int value);

    public abstract Builder setInterfacesOffset(int value);

    public abstract Builder setSourceFileIndex(int value);

    public abstract Builder setAnnotationsOffset(int value);

    public abstract Builder setClassDataOffset(int value);

    public abstract Builder setStaticValuesOffset(int value);
  }
}
