package uk.gov.gchq.gaffer.data.element.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.types.TypeSubTypeValue;

class TypeSubTypeValueToTupleDiffblueTest {
  /**
   * Test {@link TypeSubTypeValueToTuple#apply(TypeSubTypeValue)} with {@code TypeSubTypeValue}.
   *
   * <ul>
   *   <li>Then values return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link TypeSubTypeValueToTuple#apply(TypeSubTypeValue)}
   */
  @Test
  @DisplayName("Test apply(TypeSubTypeValue) with 'TypeSubTypeValue'; then values return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeSubTypeValueTuple TypeSubTypeValueToTuple.apply(TypeSubTypeValue)"})
  void testApplyWithTypeSubTypeValue_thenValuesReturnList() {
    // Arrange
    TypeSubTypeValue input = new TypeSubTypeValue("Type", "Sub Type", "42");

    // Act
    TypeSubTypeValueTuple actualApplyResult = new TypeSubTypeValueToTuple().apply(input);

    // Assert
    Iterator<Object> iteratorResult = actualApplyResult.iterator();
    Object nextResult = iteratorResult.next();
    Object nextResult2 = iteratorResult.next();
    Object nextResult3 = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    Iterable<Object> valuesResult = actualApplyResult.values();
    assertTrue(valuesResult instanceof List);
    assertEquals("42", nextResult3);
    assertEquals(3, ((List<Object>) valuesResult).size());
    assertEquals("42", ((List<Object>) valuesResult).get(2));
    assertEquals("Sub Type", nextResult2);
    assertEquals("Sub Type", ((List<Object>) valuesResult).get(1));
    assertEquals("Type", nextResult);
    assertEquals("Type", ((List<Object>) valuesResult).get(0));
    assertFalse(actualHasNextResult);
  }

  /**
   * Test {@link TypeSubTypeValueToTuple#apply(TypeSubTypeValue)} with {@code TypeSubTypeValue}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TypeSubTypeValueToTuple#apply(TypeSubTypeValue)}
   */
  @Test
  @DisplayName(
      "Test apply(TypeSubTypeValue) with 'TypeSubTypeValue'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TypeSubTypeValueTuple TypeSubTypeValueToTuple.apply(TypeSubTypeValue)"})
  void testApplyWithTypeSubTypeValue_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new TypeSubTypeValueToTuple().apply(null));
  }
}
