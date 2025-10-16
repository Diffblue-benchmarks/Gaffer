package uk.gov.gchq.gaffer.accumulostore.key.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.apache.accumulo.core.iterators.OptionDescriber;
import org.apache.accumulo.core.iterators.OptionDescriber.IteratorOptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ValidatorFilterDiffblueTest {
  /**
   * Test new {@link ValidatorFilter} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link ValidatorFilter}
   */
  @Test
  @DisplayName("Test new ValidatorFilter (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ValidatorFilter.<init>()"})
  void testNewValidatorFilter() {
    // Arrange, Act and Assert
    IteratorOptions describeOptionsResult = new ValidatorFilter().describeOptions();
    Map<String, String> namedOptions = describeOptionsResult.getNamedOptions();
    assertEquals(1, namedOptions.size());
    assertEquals("A serialised schema", namedOptions.get("Schema"));
    assertEquals(
        "Only returns elements that are valid against the schema",
        describeOptionsResult.getDescription());
    assertEquals("Schema", describeOptionsResult.getName());
    assertNull(describeOptionsResult.getUnnamedOptionDescriptions());
  }

  /**
   * Test {@link ValidatorFilter#describeOptions()}.
   *
   * <p>Method under test: {@link ValidatorFilter#describeOptions()}
   */
  @Test
  @DisplayName("Test describeOptions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"OptionDescriber.IteratorOptions ValidatorFilter.describeOptions()"})
  void testDescribeOptions() {
    // Arrange and Act
    IteratorOptions actualDescribeOptionsResult = new ValidatorFilter().describeOptions();

    // Assert
    Map<String, String> namedOptions = actualDescribeOptionsResult.getNamedOptions();
    assertEquals(1, namedOptions.size());
    assertEquals("A serialised schema", namedOptions.get("Schema"));
    assertEquals(
        "Only returns elements that are valid against the schema",
        actualDescribeOptionsResult.getDescription());
    assertEquals("Schema", actualDescribeOptionsResult.getName());
    assertNull(actualDescribeOptionsResult.getUnnamedOptionDescriptions());
  }
}
