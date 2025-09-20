package uk.gov.gchq.gaffer.data.element.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.types.TypeValue;

class TypeValueToTupleDiffblueTest {
  /**
   * Test {@link TypeValueToTuple#apply(TypeValue)} with {@code TypeValue}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TypeValueToTuple#apply(TypeValue)}
   */
  @Test
  @DisplayName("Test apply(TypeValue) with 'TypeValue'; when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testApplyWithTypeValue_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new TypeValueToTuple().apply(null));
  }

  /**
   * Test {@link TypeValueToTuple#apply(TypeValue)} with {@code TypeValue}.
   *
   * <ul>
   *   <li>When {@link TypeValue#TypeValue(String, String)} with {@code Type} and value is {@code
   *       42}.
   *   <li>Then values return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link TypeValueToTuple#apply(TypeValue)}
   */
  @Test
  @DisplayName(
      "Test apply(TypeValue) with 'TypeValue'; when TypeValue(String, String) with 'Type' and value is '42'; then values return List")
  @Tag("MaintainedByDiffblue")
  void testApplyWithTypeValue_whenTypeValueWithTypeAndValueIs42_thenValuesReturnList() {
    // Arrange
    TypeValue input = new TypeValue("Type", "42");

    // Act
    TypeValueTuple actualApplyResult = new TypeValueToTuple().apply(input);

    // Assert
    Iterator<Object> iteratorResult = actualApplyResult.iterator();
    Object nextResult = iteratorResult.next();
    Object nextResult2 = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    Iterable<Object> valuesResult = actualApplyResult.values();
    assertTrue(valuesResult instanceof List);
    assertEquals("42", nextResult2);
    assertEquals(2, ((List<Object>) valuesResult).size());
    assertEquals("42", ((List<Object>) valuesResult).get(1));
    assertEquals("Type", nextResult);
    assertEquals("Type", ((List<Object>) valuesResult).get(0));
    assertFalse(actualHasNextResult);
  }
}
