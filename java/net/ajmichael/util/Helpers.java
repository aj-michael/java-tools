package net.ajmichael.util;

import com.google.common.collect.ImmutableList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Helpers {
  private Helpers() {}

  public static <A, B> ImmutableList<B> applyN(int count, Function<A, B> function, A arg) {
    return IntStream.range(0, count)
        .mapToObj(x -> function.apply(arg))
        .collect(Collectors.collectingAndThen(Collectors.toList(), ImmutableList::copyOf));
  }

  public static byte[] unsafeReadAllBytes(Path path) {
    try {
      return Files.readAllBytes(path);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
