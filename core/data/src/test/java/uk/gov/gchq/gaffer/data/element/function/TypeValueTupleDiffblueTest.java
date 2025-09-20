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

class TypeValueTupleDiffblueTest {
  /**
   * Test {@link TypeValueTuple#TypeValueTuple()}.
   *
   * <p>Method under test: {@link TypeValueTuple#TypeValueTuple()}
   */
  @Test
  @DisplayName("Test new TypeValueTuple()")
  @Tag("MaintainedByDiffblue")
  void testNewTypeValueTuple() {
    // Arrange and Act
    TypeValueTuple actualTypeValueTuple = new TypeValueTuple();

    // Assert
    Iterable<Object> valuesResult = actualTypeValueTuple.values();
    assertTrue(valuesResult instanceof List);
    Iterator<Object> iteratorResult = actualTypeValueTuple.iterator();
    assertNull(iteratorResult.next());
    assertNull(iteratorResult.next());
    assertEquals(2, ((List<Object>) valuesResult).size());
    assertNull(((List<Object>) valuesResult).get(0));
    assertNull(((List<Object>) valuesResult).get(1));
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link TypeValueTuple#TypeValueTuple(TypeValue)}.
   *
   * <ul>
   *   <li>Then return iterator next is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TypeValueTuple#TypeValueTuple(TypeValue)}
   */
  @Test
  @DisplayName("Test new TypeValueTuple(TypeValue); then return iterator next is '42'")
  @Tag("MaintainedByDiffblue")
  void testNewTypeValueTuple_thenReturnIteratorNextIs42() {
    // Arrange and Act
    TypeValueTuple actualTypeValueTuple = new TypeValueTuple(new TypeValue("Type", "42"));

    // Assert
    Iterator<Object> iteratorResult = actualTypeValueTuple.iterator();
    Object nextResult = iteratorResult.next();
    Object nextResult2 = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    Iterable<Object> valuesResult = actualTypeValueTuple.values();
    assertTrue(valuesResult instanceof List);
    assertEquals("42", nextResult2);
    assertEquals(2, ((List<Object>) valuesResult).size());
    assertEquals("42", ((List<Object>) valuesResult).get(1));
    assertEquals("Type", nextResult);
    assertEquals("Type", ((List<Object>) valuesResult).get(0));
    assertFalse(actualHasNextResult);
  }

  /**
   * Test {@link TypeValueTuple#TypeValueTuple(TypeValue)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return iterator next is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TypeValueTuple#TypeValueTuple(TypeValue)}
   */
  @Test
  @DisplayName(
      "Test new TypeValueTuple(TypeValue); when 'null'; then return iterator next is 'null'")
  @Tag("MaintainedByDiffblue")
  void testNewTypeValueTuple_whenNull_thenReturnIteratorNextIsNull() {
    // Arrange and Act
    TypeValueTuple actualTypeValueTuple = new TypeValueTuple(null);

    // Assert
    Iterable<Object> valuesResult = actualTypeValueTuple.values();
    assertTrue(valuesResult instanceof List);
    Iterator<Object> iteratorResult = actualTypeValueTuple.iterator();
    assertNull(iteratorResult.next());
    assertNull(iteratorResult.next());
    assertEquals(2, ((List<Object>) valuesResult).size());
    assertNull(((List<Object>) valuesResult).get(0));
    assertNull(((List<Object>) valuesResult).get(1));
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link TypeValueTuple#get(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link TypeValueTuple#get(String)}
   */
  @Test
  @DisplayName("Test get(String) with 'String'; when 'Key'")
  @Tag("MaintainedByDiffblue")
  void testGetWithString_whenKey() {
    // Arrange, Act and Assert
    assertNull(new TypeValueTuple().get("Key"));
  }

  /**
   * Test {@link TypeValueTuple#get(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@link TypeSubTypeValueTuple#TYPE}.
   * </ul>
   *
   * <p>Method under test: {@link TypeValueTuple#get(String)}
   */
  @Test
  @DisplayName("Test get(String) with 'String'; when TYPE")
  @Tag("MaintainedByDiffblue")
  void testGetWithString_whenType() {
    // Arrange, Act and Assert
    assertNull(new TypeValueTuple().get(TypeSubTypeValueTuple.TYPE));
  }

  /**
   * Test {@link TypeValueTuple#get(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@link TypeSubTypeValueTuple#VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link TypeValueTuple#get(String)}
   */
  @Test
  @DisplayName("Test get(String) with 'String'; when VALUE")
  @Tag("MaintainedByDiffblue")
  void testGetWithString_whenValue() {
    // Arrange, Act and Assert
    assertNull(new TypeValueTuple().get(TypeSubTypeValueTuple.VALUE));
  }

  /**
   * Test {@link TypeValueTuple#values()}.
   *
   * <p>Method under test: {@link TypeValueTuple#values()}
   */
  @Test
  @DisplayName("Test values()")
  @Tag("MaintainedByDiffblue")
  void testValues() {
    // Arrange and Act
    Iterable<Object> actualValuesResult = new TypeValueTuple().values();
    Iterator<Object> actualIteratorResult = actualValuesResult.iterator();

    // Assert
    assertTrue(actualValuesResult instanceof List);
    assertNull(actualIteratorResult.next());
    assertNull(actualIteratorResult.next());
    assertEquals(2, ((List<Object>) actualValuesResult).size());
    assertNull(((List<Object>) actualValuesResult).get(0));
    assertNull(((List<Object>) actualValuesResult).get(1));
    assertFalse(actualIteratorResult.hasNext());
  }
}
