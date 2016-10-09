package net.ajmichael.dexfile;

import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static net.ajmichael.util.Helpers.applyN;

@AutoValue
public abstract class DexFile {
  public static DexFile parse(ByteBuffer byteBuffer) {
    if (byteBuffer.get(8 + 4 + 20 + 4 + 4) == 0x78) {
      byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }
    Header header = Header.parse(byteBuffer);
    return builder()
        .setHeader(header)
        .setStringIds(applyN(header.stringIdsSize(), ByteBuffer::getInt, byteBuffer))
        .setTypeIds(applyN(header.typeIdsSize(), ByteBuffer::getInt, byteBuffer))
        .setProtoIds(applyN(header.protoIdsSize(), ProtoId::parse, byteBuffer))
        .setFieldIds(applyN(header.fieldIdsSize(), FieldId::parse, byteBuffer))
        .setMethodIds(applyN(header.methodIdsSize(), MethodId::parse, byteBuffer))
        .setClassDefs(applyN(header.classDefsSize(), ClassDef::parse, byteBuffer))
        .setData(applyN(header.dataSize(), ByteBuffer::get, byteBuffer))
        .setLinkData(applyN(header.linkSize(), ByteBuffer::get, byteBuffer))
        .build();
  }

  public static Builder builder() {
    return new AutoValue_DexFile.Builder();
  }

  public abstract Header header();

  public abstract ImmutableList<Integer> stringIds();

  public abstract ImmutableList<Integer> typeIds();

  public abstract ImmutableList<ProtoId> protoIds();

  public abstract ImmutableList<FieldId> fieldIds();

  public abstract ImmutableList<MethodId> methodIds();

  public abstract ImmutableList<ClassDef> classDefs();

  public abstract ImmutableList<Byte> data();

  public abstract ImmutableList<Byte> linkData();

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract DexFile build();

    public abstract Builder setHeader(Header value);

    public abstract Builder setStringIds(ImmutableList<Integer> value);

    public abstract Builder setTypeIds(ImmutableList<Integer> value);

    public abstract Builder setProtoIds(ImmutableList<ProtoId> value);

    public abstract Builder setFieldIds(ImmutableList<FieldId> value);

    public abstract Builder setMethodIds(ImmutableList<MethodId> value);

    public abstract Builder setClassDefs(ImmutableList<ClassDef> value);

    public abstract Builder setData(ImmutableList<Byte> value);

    public abstract Builder setLinkData(ImmutableList<Byte> value);
  }
}
