package net.ajmichael.classfile;

import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;

import java.nio.ByteBuffer;

import static net.ajmichael.util.Helpers.applyN;

@AutoValue
public abstract class AttributeInfo {
  public static AttributeInfo parse(ByteBuffer classFile) {
    AttributeInfo.Builder builder = AttributeInfo.builder()
        .setAttributeNameIndex(classFile.getShort());
    int attributeLength = classFile.getInt();
    return builder.setAttributeLength(attributeLength)
        .setInfo(applyN(attributeLength, ByteBuffer::get, classFile))
        .build();
  }

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
