package util.collections;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Consumer;

public class Seen<T> extends HashSet<T> {
  private static final long serialVersionUID = -1578854262738867470L;

  public boolean seen(T t) {
    if (contains(t))
      return true;
    add(t);
    return false;
  }

  public boolean seenAll(Collection<T> collection) {
    if (containsAll(collection))
      return true;
    addAll(collection);
    return false;
  }

  public void ifNotSeen(T t, Consumer<T> operation) {
    if (!seen(t))
      operation.accept(t);
  }
}
