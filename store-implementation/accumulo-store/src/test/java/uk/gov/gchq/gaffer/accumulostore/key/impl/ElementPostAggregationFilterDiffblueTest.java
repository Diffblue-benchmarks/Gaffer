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

class ElementPostAggregationFilterDiffblueTest {
  /**
   * Test new {@link ElementPostAggregationFilter} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * ElementPostAggregationFilter}
   */
  @Test
  @DisplayName("Test new ElementPostAggregationFilter (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElementPostAggregationFilter.<init>()"})
  void testNewElementPostAggregationFilter() {
    // Arrange, Act and Assert
    IteratorOptions describeOptionsResult = new ElementPostAggregationFilter().describeOptions();
    assertEquals("Element_Post_Aggregation_Filter", describeOptionsResult.getName());
    assertEquals(
        "Only returns elements that pass post aggregation validation against the given view",
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
   * Test {@link ElementPostAggregationFilter#describeOptions()}.
   *
   * <p>Method under test: {@link ElementPostAggregationFilter#describeOptions()}
   */
  @Test
  @DisplayName("Test describeOptions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OptionDescriber.IteratorOptions ElementPostAggregationFilter.describeOptions()"
  })
  void testDescribeOptions() {
    // Arrange and Act
    IteratorOptions actualDescribeOptionsResult =
        new ElementPostAggregationFilter().describeOptions();

    // Assert
    assertEquals("Element_Post_Aggregation_Filter", actualDescribeOptionsResult.getName());
    assertEquals(
        "Only returns elements that pass post aggregation validation against the given view",
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
