package util;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import util.collections.Seen;
import util.fluent.collections.FluentMap;

import static util.Initializable.*;

public class Lazy {
  public static <T> Supplier<T> lazy(Supplier<T> supplier) {
    return new Supplier<T>() {
      Initializable<T> value = initializable();

      public T get() {
        return value.suggest(supplier);
      }
    };
  }

  public static <T> Consumer<T> lazy(Consumer<T> consumer) {
    return new Consumer<T>() {
      Seen<T> seen = new Seen<>();

      @Override
      public void accept(T t) {
        seen.ifNotSeen(t, _t -> consumer.accept(_t));
      }
    };
  }

  public static <T, R> Function<T, R> lazy(Function<T, R> function) {
    return new Function<T, R>() {
      FluentMap<T, R> results = new FluentMap<>();

      @Override
      public R apply(T t) {
        return results.ifNotContainsKey(t).put(t, function.apply(t)).get(t);
      }
    };
  }
}
