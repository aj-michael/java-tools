package net.ajmichael.classfile;

import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;

import java.nio.ByteBuffer;

import static net.ajmichael.util.Helpers.applyN;

/**
 * A parsed class file.
 */
@AutoValue
public abstract class ClassFile {
  public static ClassFile parse(ByteBuffer classFile) {
    if (classFile.getInt() != ClassFile.magic()) {
      throw new IllegalArgumentException("Attempting to parse an invalid class file");
    }
    ClassFile.Builder builder = ClassFile.builder()
        .setMinorVersion(classFile.getShort())
        .setMajorVersion(classFile.getShort());
    short constantPoolCount = classFile.getShort();
    builder.setConstantPoolCount(constantPoolCount)
        .setConstantPool(applyN(constantPoolCount - 1, ConstantPoolInfo::parse, classFile))
        .setAccessFlags(classFile.getShort())
        .setThisClass(classFile.getShort())
        .setSuperClass(classFile.getShort());
    short interfacesCount = classFile.getShort();
    builder.setInterfacesCount(interfacesCount)
        .setInterfaces(applyN(interfacesCount, ByteBuffer::getShort, classFile));
    short fieldsCount = classFile.getShort();
    builder.setFieldsCount(fieldsCount)
        .setFields(applyN(fieldsCount, FieldInfo::parse, classFile));
    short methodsCount = classFile.getShort();
    builder.setMethodsCount(methodsCount)
        .setMethods(applyN(methodsCount, MethodInfo::parse, classFile));
    short attributesCount = classFile.getShort();
    return builder.setAttributesCount(attributesCount)
        .setAttributes(applyN(attributesCount, AttributeInfo::parse, classFile))
        .build();
  }

  public static Builder builder() {
    return new AutoValue_ClassFile.Builder();
  }

  public static int magic() {
    return 0xCAFEBABE;
  }

  public abstract Short minorVersion();

  public abstract Short majorVersion();

  public abstract Short constantPoolCount();

  public abstract ImmutableList<ConstantPoolInfo> constantPool();

  public abstract Short accessFlags();

  public abstract Short thisClass();

  public abstract Short superClass();

  public abstract Short interfacesCount();

  public abstract ImmutableList<Short> interfaces();

  public abstract Short fieldsCount();

  public abstract ImmutableList<FieldInfo> fields();

  public abstract Short methodsCount();

  public abstract ImmutableList<MethodInfo> methods();

  public abstract Short attributesCount();

  public abstract ImmutableList<AttributeInfo> attributes();

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract ClassFile build();

    public abstract Builder setMinorVersion(Short value);

    public abstract Builder setMajorVersion(Short value);

    public abstract Builder setConstantPoolCount(Short value);

    public abstract Builder setConstantPool(ImmutableList<ConstantPoolInfo> value);

    public abstract Builder setAccessFlags(Short value);

    public abstract Builder setThisClass(Short value);

    public abstract Builder setSuperClass(Short value);

    public abstract Builder setInterfacesCount(Short value);

    public abstract Builder setInterfaces(ImmutableList<Short> value);

    public abstract Builder setFieldsCount(Short value);

    public abstract Builder setFields(ImmutableList<FieldInfo> value);

    public abstract Builder setMethodsCount(Short value);

    public abstract Builder setMethods(ImmutableList<MethodInfo> value);

    public abstract Builder setAttributesCount(Short value);

    public abstract Builder setAttributes(ImmutableList<AttributeInfo> value);
  }
}
