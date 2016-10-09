package net.ajmichael.dexfile;

import net.ajmichael.util.Helpers;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Paths;
import java.util.Arrays;

public final class Dedexer {
  private Dedexer() {};

  public static void main(String[] args) throws IOException {
    DexFile dexFile = Arrays.stream(args)
        .map(Paths::get)
        .map(Helpers::unsafeReadAllBytes)
        .map(ByteBuffer::wrap)
        .map(DexFile::parse)
        .findAny()
        .get();
    /*System.out.println(dexFile.header().magic());
    System.out.println(Long.toHexString(dexFile.header().magic()));
    System.out.println(Long.toHexString(dexFile.header().endianTag()));*/
    System.out.println(dexFile);
  }
}
