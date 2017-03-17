package util.collections;

import java.util.Set;

import org.junit.Test;

import static util.collections.Collections.all;

public class CollectionsAllTest {
  @Test
  public void a() {
    Set<Integer> numbers = all();
    assert !numbers.isEmpty();
    assert numbers.contains(176);
    numbers.remove(176);
    assert !numbers.contains(176);
    numbers.add(176);
    assert numbers.contains(176);
    assert numbers.containsAll(all());
    numbers.remove(176);
    assert !numbers.containsAll(all());
    numbers.clear();
    assert numbers.isEmpty();
    assert !numbers.contains(176);
    assert !numbers.contains(42);
    numbers.add(42);
    assert numbers.contains(42);
  }
}
