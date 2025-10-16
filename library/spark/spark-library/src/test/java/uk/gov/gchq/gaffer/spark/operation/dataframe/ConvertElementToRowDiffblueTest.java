package uk.gov.gchq.gaffer.spark.operation.dataframe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.catalyst.expressions.GenericRow;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;

class ConvertElementToRowDiffblueTest {
  /**
   * Test {@link ConvertElementToRow#ConvertElementToRow(LinkedHashSet, Map, Map)}.
   *
   * <ul>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()}.
   *   <li>Then apply {@code null} return {@link GenericRow}.
   * </ul>
   *
   * <p>Method under test: {@link ConvertElementToRow#ConvertElementToRow(LinkedHashSet, Map, Map)}
   */
  @Test
  @DisplayName(
      "Test new ConvertElementToRow(LinkedHashSet, Map, Map); when LinkedHashSet(); then apply 'null' return GenericRow")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConvertElementToRow.<init>(LinkedHashSet, Map, Map)"})
  void testNewConvertElementToRow_whenLinkedHashSet_thenApplyNullReturnGenericRow() {
    // Arrange
    LinkedHashSet<String> properties = new LinkedHashSet<>();
    HashMap<String, Boolean> propertyNeedsConversion = new HashMap<>();

    // Act
    ConvertElementToRow actualConvertElementToRow =
        new ConvertElementToRow(properties, propertyNeedsConversion, new HashMap<>());

    // Assert
    Row applyResult = actualConvertElementToRow.apply(null);
    assertTrue(applyResult instanceof GenericRow);
    assertNull(applyResult.schema());
    assertEquals(0, applyResult.length());
    assertEquals(0, applyResult.size());
    assertEquals(0, ((GenericRow) applyResult).values().length);
  }

  /**
   * Test {@link ConvertElementToRow#apply(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@code directed}.
   *   <li>Then return not first element.
   * </ul>
   *
   * <p>Method under test: {@link ConvertElementToRow#apply(Element)}
   */
  @Test
  @DisplayName(
      "Test apply(Element) with 'Element'; given LinkedHashSet() add 'directed'; then return not first element")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Row ConvertElementToRow.apply(Element)"})
  void testApplyWithElement_givenLinkedHashSetAddDirected_thenReturnNotFirstElement() {
    // Arrange
    LinkedHashSet<String> properties = new LinkedHashSet<>();
    properties.add("directed");
    HashMap<String, Boolean> propertyNeedsConversion = new HashMap<>();

    ConvertElementToRow convertElementToRow =
        new ConvertElementToRow(properties, propertyNeedsConversion, new HashMap<>());

    // Act
    Row actualApplyResult = convertElementToRow.apply(new Edge("Group"));

    // Assert
    assertTrue(actualApplyResult instanceof GenericRow);
    assertEquals(1, actualApplyResult.length());
    assertEquals(1, actualApplyResult.size());
    Object[] valuesResult = ((GenericRow) actualApplyResult).values();
    assertEquals(1, valuesResult.length);
    assertFalse((Boolean) valuesResult[0]);
  }

  /**
   * Test {@link ConvertElementToRow#apply(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@code dst}.
   *   <li>Then return first element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConvertElementToRow#apply(Element)}
   */
  @Test
  @DisplayName(
      "Test apply(Element) with 'Element'; given LinkedHashSet() add 'dst'; then return first element is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Row ConvertElementToRow.apply(Element)"})
  void testApplyWithElement_givenLinkedHashSetAddDst_thenReturnFirstElementIsNull() {
    // Arrange
    LinkedHashSet<String> properties = new LinkedHashSet<>();
    properties.add("dst");
    HashMap<String, Boolean> propertyNeedsConversion = new HashMap<>();

    ConvertElementToRow convertElementToRow =
        new ConvertElementToRow(properties, propertyNeedsConversion, new HashMap<>());

    // Act
    Row actualApplyResult = convertElementToRow.apply(new Edge("Group"));

    // Assert
    assertTrue(actualApplyResult instanceof GenericRow);
    Object[] valuesResult = ((GenericRow) actualApplyResult).values();
    assertNull(valuesResult[0]);
    assertEquals(1, actualApplyResult.length());
    assertEquals(1, actualApplyResult.size());
    assertEquals(1, valuesResult.length);
  }

  /**
   * Test {@link ConvertElementToRow#apply(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@code foo}.
   *   <li>Then return first element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConvertElementToRow#apply(Element)}
   */
  @Test
  @DisplayName(
      "Test apply(Element) with 'Element'; given LinkedHashSet() add 'foo'; then return first element is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Row ConvertElementToRow.apply(Element)"})
  void testApplyWithElement_givenLinkedHashSetAddFoo_thenReturnFirstElementIsNull() {
    // Arrange
    LinkedHashSet<String> properties = new LinkedHashSet<>();
    properties.add("foo");
    HashMap<String, Boolean> propertyNeedsConversion = new HashMap<>();

    ConvertElementToRow convertElementToRow =
        new ConvertElementToRow(properties, propertyNeedsConversion, new HashMap<>());

    // Act
    Row actualApplyResult = convertElementToRow.apply(new Edge("Group"));

    // Assert
    assertTrue(actualApplyResult instanceof GenericRow);
    Object[] valuesResult = ((GenericRow) actualApplyResult).values();
    assertNull(valuesResult[0]);
    assertEquals(1, actualApplyResult.length());
    assertEquals(1, actualApplyResult.size());
    assertEquals(1, valuesResult.length);
  }

  /**
   * Test {@link ConvertElementToRow#apply(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@code group}.
   *   <li>Then return first element is {@code Group}.
   * </ul>
   *
   * <p>Method under test: {@link ConvertElementToRow#apply(Element)}
   */
  @Test
  @DisplayName(
      "Test apply(Element) with 'Element'; given LinkedHashSet() add 'group'; then return first element is 'Group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Row ConvertElementToRow.apply(Element)"})
  void testApplyWithElement_givenLinkedHashSetAddGroup_thenReturnFirstElementIsGroup() {
    // Arrange
    LinkedHashSet<String> properties = new LinkedHashSet<>();
    properties.add("group");
    HashMap<String, Boolean> propertyNeedsConversion = new HashMap<>();

    ConvertElementToRow convertElementToRow =
        new ConvertElementToRow(properties, propertyNeedsConversion, new HashMap<>());

    // Act
    Row actualApplyResult = convertElementToRow.apply(new Edge("Group"));

    // Assert
    assertTrue(actualApplyResult instanceof GenericRow);
    Object[] valuesResult = ((GenericRow) actualApplyResult).values();
    assertEquals("Group", valuesResult[0]);
    assertEquals(1, actualApplyResult.length());
    assertEquals(1, actualApplyResult.size());
    assertEquals(1, valuesResult.length);
  }

  /**
   * Test {@link ConvertElementToRow#apply(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@code matchedVertex}.
   * </ul>
   *
   * <p>Method under test: {@link ConvertElementToRow#apply(Element)}
   */
  @Test
  @DisplayName("Test apply(Element) with 'Element'; given LinkedHashSet() add 'matchedVertex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Row ConvertElementToRow.apply(Element)"})
  void testApplyWithElement_givenLinkedHashSetAddMatchedVertex() {
    // Arrange
    LinkedHashSet<String> properties = new LinkedHashSet<>();
    properties.add("matchedVertex");
    HashMap<String, Boolean> propertyNeedsConversion = new HashMap<>();

    ConvertElementToRow convertElementToRow =
        new ConvertElementToRow(properties, propertyNeedsConversion, new HashMap<>());

    // Act
    Row actualApplyResult = convertElementToRow.apply(new Edge("Group"));

    // Assert
    assertTrue(actualApplyResult instanceof GenericRow);
    Object[] valuesResult = ((GenericRow) actualApplyResult).values();
    assertNull(valuesResult[0]);
    assertEquals(1, actualApplyResult.length());
    assertEquals(1, actualApplyResult.size());
    assertEquals(1, valuesResult.length);
  }

  /**
   * Test {@link ConvertElementToRow#apply(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@code src}.
   *   <li>Then return first element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConvertElementToRow#apply(Element)}
   */
  @Test
  @DisplayName(
      "Test apply(Element) with 'Element'; given LinkedHashSet() add 'src'; then return first element is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Row ConvertElementToRow.apply(Element)"})
  void testApplyWithElement_givenLinkedHashSetAddSrc_thenReturnFirstElementIsNull() {
    // Arrange
    LinkedHashSet<String> properties = new LinkedHashSet<>();
    properties.add("src");
    HashMap<String, Boolean> propertyNeedsConversion = new HashMap<>();

    ConvertElementToRow convertElementToRow =
        new ConvertElementToRow(properties, propertyNeedsConversion, new HashMap<>());

    // Act
    Row actualApplyResult = convertElementToRow.apply(new Edge("Group"));

    // Assert
    assertTrue(actualApplyResult instanceof GenericRow);
    Object[] valuesResult = ((GenericRow) actualApplyResult).values();
    assertNull(valuesResult[0]);
    assertEquals(1, actualApplyResult.length());
    assertEquals(1, actualApplyResult.size());
    assertEquals(1, valuesResult.length);
  }

  /**
   * Test {@link ConvertElementToRow#apply(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@code vertex}.
   *   <li>Then return first element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConvertElementToRow#apply(Element)}
   */
  @Test
  @DisplayName(
      "Test apply(Element) with 'Element'; given LinkedHashSet() add 'vertex'; then return first element is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Row ConvertElementToRow.apply(Element)"})
  void testApplyWithElement_givenLinkedHashSetAddVertex_thenReturnFirstElementIsNull() {
    // Arrange
    LinkedHashSet<String> properties = new LinkedHashSet<>();
    properties.add("vertex");
    HashMap<String, Boolean> propertyNeedsConversion = new HashMap<>();

    ConvertElementToRow convertElementToRow =
        new ConvertElementToRow(properties, propertyNeedsConversion, new HashMap<>());

    // Act
    Row actualApplyResult = convertElementToRow.apply(new Edge("Group"));

    // Assert
    assertTrue(actualApplyResult instanceof GenericRow);
    Object[] valuesResult = ((GenericRow) actualApplyResult).values();
    assertNull(valuesResult[0]);
    assertEquals(1, actualApplyResult.length());
    assertEquals(1, actualApplyResult.size());
    assertEquals(1, valuesResult.length);
  }

  /**
   * Test {@link ConvertElementToRow#apply(Element)} with {@code Element}.
   *
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.
   *   <li>Then return schema is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConvertElementToRow#apply(Element)}
   */
  @Test
  @DisplayName(
      "Test apply(Element) with 'Element'; when Edge(String) with 'Group'; then return schema is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Row ConvertElementToRow.apply(Element)"})
  void testApplyWithElement_whenEdgeWithGroup_thenReturnSchemaIsNull() {
    // Arrange
    LinkedHashSet<String> properties = new LinkedHashSet<>();
    HashMap<String, Boolean> propertyNeedsConversion = new HashMap<>();

    ConvertElementToRow convertElementToRow =
        new ConvertElementToRow(properties, propertyNeedsConversion, new HashMap<>());

    // Act
    Row actualApplyResult = convertElementToRow.apply(new Edge("Group"));

    // Assert
    assertTrue(actualApplyResult instanceof GenericRow);
    assertNull(actualApplyResult.schema());
    assertEquals(0, actualApplyResult.length());
    assertEquals(0, actualApplyResult.size());
    assertEquals(0, ((GenericRow) actualApplyResult).values().length);
  }
}
