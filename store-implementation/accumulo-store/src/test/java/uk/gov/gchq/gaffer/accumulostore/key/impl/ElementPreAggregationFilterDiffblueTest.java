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

class ElementPreAggregationFilterDiffblueTest {
  /**
   * Test new {@link ElementPreAggregationFilter} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * ElementPreAggregationFilter}
   */
  @Test
  @DisplayName("Test new ElementPreAggregationFilter (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElementPreAggregationFilter.<init>()"})
  void testNewElementPreAggregationFilter() {
    // Arrange, Act and Assert
    IteratorOptions describeOptionsResult = new ElementPreAggregationFilter().describeOptions();
    assertEquals("Element_Pre_Aggregation_Filter", describeOptionsResult.getName());
    assertEquals(
        "Only returns elements that pass pre aggregation validation against the given view",
        describeOptionsResult.getDescription());
    Map<String, String> namedOptions = describeOptionsResult.getNamedOptions();
    assertEquals(4, namedOptions.size());
    assertEquals(
        "Required: The element converter class to be used for key/value conversion",
        namedOptions.get("accumulostore.key.element_converter"));
    assertEquals("Required: The json serialised form of a view", namedOptions.get("View"));
    assertEquals("Required: The json serialised form of the schema", namedOptions.get("Schema"));
    assertEquals(
        "default false keeps k/v that pass accept method, true rejects k/v that pass accept method",
        namedOptions.get("negate"));
    assertNull(describeOptionsResult.getUnnamedOptionDescriptions());
  }

  /**
   * Test {@link ElementPreAggregationFilter#describeOptions()}.
   *
   * <p>Method under test: {@link ElementPreAggregationFilter#describeOptions()}
   */
  @Test
  @DisplayName("Test describeOptions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OptionDescriber.IteratorOptions ElementPreAggregationFilter.describeOptions()"
  })
  void testDescribeOptions() {
    // Arrange and Act
    IteratorOptions actualDescribeOptionsResult =
        new ElementPreAggregationFilter().describeOptions();

    // Assert
    assertEquals("Element_Pre_Aggregation_Filter", actualDescribeOptionsResult.getName());
    assertEquals(
        "Only returns elements that pass pre aggregation validation against the given view",
        actualDescribeOptionsResult.getDescription());
    Map<String, String> namedOptions = actualDescribeOptionsResult.getNamedOptions();
    assertEquals(4, namedOptions.size());
    assertEquals(
        "Required: The element converter class to be used for key/value conversion",
        namedOptions.get("accumulostore.key.element_converter"));
    assertEquals("Required: The json serialised form of a view", namedOptions.get("View"));
    assertEquals("Required: The json serialised form of the schema", namedOptions.get("Schema"));
    assertEquals(
        "default false keeps k/v that pass accept method, true rejects k/v that pass accept method",
        namedOptions.get("negate"));
    assertNull(actualDescribeOptionsResult.getUnnamedOptionDescriptions());
  }
}
