package net.ajmichael.dexfile;

import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static net.ajmichael.util.Helpers.applyN;

@AutoValue
public abstract class Header {
  private static final int ENDIAN_CONSTANT = 0x12345678;

  public static Header parse(ByteBuffer byteBuffer) {
    return builder()
        .setMagic(byteBuffer.getLong())
        .setCheckSum(byteBuffer.getInt())
        .setSignature(applyN(20, ByteBuffer::get, byteBuffer))
        .setFileSize(byteBuffer.getInt())
        .setHeaderSize(byteBuffer.getInt())
        .setEndianTag(byteBuffer.getInt())
        .setLinkSize(byteBuffer.getInt())
        .setLinkOffset(byteBuffer.getInt())
        .setMapOffset(byteBuffer.getInt())
        .setStringIdsSize(byteBuffer.getInt())
        .setStringIdsOffset(byteBuffer.getInt())
        .setTypeIdsSize(byteBuffer.getInt())
        .setTypeIdsOffset(byteBuffer.getInt())
        .setProtoIdsSize(byteBuffer.getInt())
        .setProtoIdsOffset(byteBuffer.getInt())
        .setFieldIdsSize(byteBuffer.getInt())
        .setFieldIdsOffset(byteBuffer.getInt())
        .setMethodIdsSize(byteBuffer.getInt())
        .setMethodIdsOffset(byteBuffer.getInt())
        .setClassDefsSize(byteBuffer.getInt())
        .setClassDefOffset(byteBuffer.getInt())
        .setDataSize(byteBuffer.getInt())
        .setDataOffset(byteBuffer.getInt())
        .build();
  }

  public static Builder builder() {
    return new AutoValue_Header.Builder();
  }

  public abstract long magic();
  
  public abstract int checkSum();

  public abstract ImmutableList<Byte> signature();

  public abstract int fileSize();

  public abstract int headerSize();

  public abstract int endianTag();

  public abstract int linkSize();

  public abstract int linkOffset();

  public abstract int mapOffset();

  public abstract int stringIdsSize();

  public abstract int stringIdsOffset();

  public abstract int typeIdsSize();

  public abstract int typeIdsOffset();

  public abstract int protoIdsSize();

  public abstract int protoIdsOffset();

  public abstract int fieldIdsSize();

  public abstract int fieldIdsOffset();

  public abstract int methodIdsSize();

  public abstract int methodIdsOffset();

  public abstract int classDefsSize();

  public abstract int classDefOffset();

  public abstract int dataSize();

  public abstract int dataOffset();

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract Header build();

    public abstract Builder setMagic(long value);

    public abstract Builder setCheckSum(int value);
    
    public abstract Builder setSignature(ImmutableList<Byte> value);
    
    public abstract Builder setFileSize(int value);
    
    public abstract Builder setHeaderSize(int value);
    
    public abstract Builder setEndianTag(int value);
    
    public abstract Builder setLinkSize(int value);
    
    public abstract Builder setLinkOffset(int value);
    
    public abstract Builder setMapOffset(int value);
    
    public abstract Builder setStringIdsSize(int value);
    
    public abstract Builder setStringIdsOffset(int value);
    
    public abstract Builder setTypeIdsSize(int value);
    
    public abstract Builder setTypeIdsOffset(int value);

    public abstract Builder setProtoIdsSize(int value);

    public abstract Builder setProtoIdsOffset(int value);

    public abstract Builder setFieldIdsSize(int value);

    public abstract Builder setFieldIdsOffset(int value);

    public abstract Builder setMethodIdsSize(int value);

    public abstract Builder setMethodIdsOffset(int value);

    public abstract Builder setClassDefsSize(int value);

    public abstract Builder setClassDefOffset(int value);
    
    public abstract Builder setDataSize(int value);

    public abstract Builder setDataOffset(int value);
  }
}
