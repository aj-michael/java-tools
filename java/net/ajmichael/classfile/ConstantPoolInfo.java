package net.ajmichael.classfile;

import com.google.common.collect.ImmutableMap;

import java.nio.ByteBuffer;
import java.util.function.Function;

public interface ConstantPoolInfo {
  Byte tag();

  ImmutableMap<Byte, Function<ByteBuffer, ConstantPoolInfo>> CONSTANT_POOL_PARSERS =
      new ImmutableMap.Builder<Byte, Function<ByteBuffer, ConstantPoolInfo>>()
          .put((byte) 7, ClassInfo::parse)
          .put((byte) 9, FieldRefInfo::parse)
          .put((byte) 10, MethodRefInfo::parse)
          .put((byte) 11, InterfaceMethodRefInfo::parse)
          .put((byte) 8, StringInfo::parse)
          .put((byte) 3, IntegerInfo::parse)
          .put((byte) 4, FloatInfo::parse)
          .put((byte) 5, LongInfo::parse)
          .put((byte) 6, DoubleInfo::parse)
          .put((byte) 12, NameAndTypeInfo::parse)
          .put((byte) 1, Utf8Info::parse)
          .put((byte) 15, MethodHandleInfo::parse)
          .put((byte) 16, MethodTypeInfo::parse)
          .put((byte) 18, InvokeDynamicInfo::parse)
          .build();

  static ConstantPoolInfo parse(ByteBuffer classFile) {
    return CONSTANT_POOL_PARSERS.get(classFile.get()).apply(classFile);
  }
}
