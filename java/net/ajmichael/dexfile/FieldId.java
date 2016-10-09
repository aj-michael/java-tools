package net.ajmichael.dexfile;

import com.google.auto.value.AutoValue;

import java.nio.ByteBuffer;

@AutoValue
public abstract class FieldId {
  public static FieldId parse(ByteBuffer byteBuffer) {
    return builder()
        .setClassIndex(byteBuffer.getShort())
        .setTypeIndex(byteBuffer.getShort())
        .setNameIndex(byteBuffer.getInt())
        .build();
  }

  public static Builder builder() {
    return new AutoValue_FieldId.Builder();
  }

  public abstract short classIndex();

  public abstract short typeIndex();

  public abstract int nameIndex();

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract FieldId build();

    public abstract Builder setClassIndex(short value);

    public abstract Builder setTypeIndex(short value);

    public abstract Builder setNameIndex(int value);
  }
}
