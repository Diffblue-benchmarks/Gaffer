package uk.gov.gchq.gaffer.accumulostore.key.core.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.apache.accumulo.core.data.Key;
import org.apache.accumulo.core.data.Value;
import org.apache.accumulo.core.iterators.OptionDescriber;
import org.apache.accumulo.core.iterators.OptionDescriber.IteratorOptions;
import org.apache.accumulo.tserver.MemKey;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.key.exception.BloomFilterIteratorException;

class CoreKeyBloomFilterIteratorDiffblueTest {
  /**
   * Test {@link CoreKeyBloomFilterIterator#accept(Key, Value)}.
   *
   * <p>Method under test: {@link CoreKeyBloomFilterIterator#accept(Key, Value)}
   */
  @Test
  @DisplayName("Test accept(Key, Value)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CoreKeyBloomFilterIterator.accept(Key, Value)"})
  void testAccept() {
    // Arrange
    CoreKeyBloomFilterIterator coreKeyBloomFilterIterator = new CoreKeyBloomFilterIterator();
    MemKey key =
        new MemKey(
            new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1},
            new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1},
            new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1},
            new byte[] {'A', -1, 'A', -1, 'A', -1, 'A', -1},
            -1L,
            true,
            true,
            -1);

    // Act and Assert
    assertTrue(coreKeyBloomFilterIterator.accept(key, new Value()));
  }

  /**
   * Test {@link CoreKeyBloomFilterIterator#accept(Key, Value)}.
   *
   * <ul>
   *   <li>When {@link Key#Key()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CoreKeyBloomFilterIterator#accept(Key, Value)}
   */
  @Test
  @DisplayName("Test accept(Key, Value); when Key(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CoreKeyBloomFilterIterator.accept(Key, Value)"})
  void testAccept_whenKey_thenReturnTrue() {
    // Arrange
    CoreKeyBloomFilterIterator coreKeyBloomFilterIterator = new CoreKeyBloomFilterIterator();
    Key key = new Key();

    // Act and Assert
    assertTrue(coreKeyBloomFilterIterator.accept(key, new Value()));
  }

  /**
   * Test {@link CoreKeyBloomFilterIterator#validateOptions(Map)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link HashMap#HashMap()} {@code negate} is {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link CoreKeyBloomFilterIterator#validateOptions(Map)}
   */
  @Test
  @DisplayName(
      "Test validateOptions(Map); given 'null'; when HashMap() 'negate' is 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CoreKeyBloomFilterIterator.validateOptions(Map)"})
  void testValidateOptions_givenNull_whenHashMapNegateIsNull_thenReturnTrue() {
    // Arrange
    CoreKeyBloomFilterIterator coreKeyBloomFilterIterator = new CoreKeyBloomFilterIterator();

    HashMap<String, String> options = new HashMap<>();
    options.put("negate", null);
    options.put("Bloom_Filter", "Options");

    // Act and Assert
    assertTrue(coreKeyBloomFilterIterator.validateOptions(options));
  }

  /**
   * Test {@link CoreKeyBloomFilterIterator#validateOptions(Map)}.
   *
   * <ul>
   *   <li>Given {@link Boolean#TRUE} toString.
   *   <li>When {@link HashMap#HashMap()} {@code negate} is {@link Boolean#TRUE} toString.
   * </ul>
   *
   * <p>Method under test: {@link CoreKeyBloomFilterIterator#validateOptions(Map)}
   */
  @Test
  @DisplayName(
      "Test validateOptions(Map); given TRUE toString; when HashMap() 'negate' is TRUE toString")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CoreKeyBloomFilterIterator.validateOptions(Map)"})
  void testValidateOptions_givenTrueToString_whenHashMapNegateIsTrueToString() {
    // Arrange
    CoreKeyBloomFilterIterator coreKeyBloomFilterIterator = new CoreKeyBloomFilterIterator();

    HashMap<String, String> options = new HashMap<>();
    options.put("negate", Boolean.TRUE.toString());
    options.put("Bloom_Filter", "Options");

    // Act and Assert
    assertTrue(coreKeyBloomFilterIterator.validateOptions(options));
  }

  /**
   * Test {@link CoreKeyBloomFilterIterator#validateOptions(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then throw {@link BloomFilterIteratorException}.
   * </ul>
   *
   * <p>Method under test: {@link CoreKeyBloomFilterIterator#validateOptions(Map)}
   */
  @Test
  @DisplayName("Test validateOptions(Map); when HashMap(); then throw BloomFilterIteratorException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean CoreKeyBloomFilterIterator.validateOptions(Map)"})
  void testValidateOptions_whenHashMap_thenThrowBloomFilterIteratorException() {
    // Arrange
    CoreKeyBloomFilterIterator coreKeyBloomFilterIterator = new CoreKeyBloomFilterIterator();

    // Act and Assert
    assertThrows(
        BloomFilterIteratorException.class,
        () -> coreKeyBloomFilterIterator.validateOptions(new HashMap<>()));
  }

  /**
   * Test {@link CoreKeyBloomFilterIterator#describeOptions()}.
   *
   * <p>Method under test: {@link CoreKeyBloomFilterIterator#describeOptions()}
   */
  @Test
  @DisplayName("Test describeOptions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"IteratorOptions CoreKeyBloomFilterIterator.describeOptions()"})
  void testDescribeOptions() {
    // Arrange and Act
    IteratorOptions actualDescribeOptionsResult =
        new CoreKeyBloomFilterIterator().describeOptions();

    // Assert
    assertEquals("Bloom Filter", actualDescribeOptionsResult.getDescription());
    assertEquals("Bloom_Filter", actualDescribeOptionsResult.getName());
    Map<String, String> namedOptions = actualDescribeOptionsResult.getNamedOptions();
    assertEquals(1, namedOptions.size());
    assertEquals(
        "Required: The serialised form of the bloom filter that keys will be tested against",
        namedOptions.get("Bloom_Filter"));
    assertNull(actualDescribeOptionsResult.getUnnamedOptionDescriptions());
  }

  /**
   * Test new {@link CoreKeyBloomFilterIterator} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * CoreKeyBloomFilterIterator}
   */
  @Test
  @DisplayName("Test new CoreKeyBloomFilterIterator (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CoreKeyBloomFilterIterator.<init>()"})
  void testNewCoreKeyBloomFilterIterator() {
    // Arrange, Act and Assert
    assertNull(new CoreKeyBloomFilterIterator().filter);
  }
}
