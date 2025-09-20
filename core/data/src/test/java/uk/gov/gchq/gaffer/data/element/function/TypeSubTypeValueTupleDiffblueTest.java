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
import uk.gov.gchq.gaffer.types.TypeSubTypeValue;

class TypeSubTypeValueTupleDiffblueTest {
  /**
   * Test {@link TypeSubTypeValueTuple#TypeSubTypeValueTuple()}.
   *
   * <p>Method under test: {@link TypeSubTypeValueTuple#TypeSubTypeValueTuple()}
   */
  @Test
  @DisplayName("Test new TypeSubTypeValueTuple()")
  @Tag("MaintainedByDiffblue")
  void testNewTypeSubTypeValueTuple() {
    // Arrange and Act
    TypeSubTypeValueTuple actualTypeSubTypeValueTuple = new TypeSubTypeValueTuple();

    // Assert
    Iterable<Object> valuesResult = actualTypeSubTypeValueTuple.values();
    assertTrue(valuesResult instanceof List);
    Iterator<Object> iteratorResult = actualTypeSubTypeValueTuple.iterator();
    assertNull(iteratorResult.next());
    assertNull(iteratorResult.next());
    assertNull(iteratorResult.next());
    assertEquals(3, ((List<Object>) valuesResult).size());
    assertNull(((List<Object>) valuesResult).get(0));
    assertNull(((List<Object>) valuesResult).get(1));
    assertNull(((List<Object>) valuesResult).get(2));
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link TypeSubTypeValueTuple#TypeSubTypeValueTuple(TypeSubTypeValue)}.
   *
   * <ul>
   *   <li>Then return iterator next is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TypeSubTypeValueTuple#TypeSubTypeValueTuple(TypeSubTypeValue)}
   */
  @Test
  @DisplayName(
      "Test new TypeSubTypeValueTuple(TypeSubTypeValue); then return iterator next is '42'")
  @Tag("MaintainedByDiffblue")
  void testNewTypeSubTypeValueTuple_thenReturnIteratorNextIs42() {
    // Arrange
    TypeSubTypeValue tsv = new TypeSubTypeValue("Type", "Sub Type", "42");

    // Act
    TypeSubTypeValueTuple actualTypeSubTypeValueTuple = new TypeSubTypeValueTuple(tsv);

    // Assert
    Iterator<Object> iteratorResult = actualTypeSubTypeValueTuple.iterator();
    Object nextResult = iteratorResult.next();
    Object nextResult2 = iteratorResult.next();
    Object nextResult3 = iteratorResult.next();
    boolean actualHasNextResult = iteratorResult.hasNext();
    Iterable<Object> valuesResult = actualTypeSubTypeValueTuple.values();
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
   * Test {@link TypeSubTypeValueTuple#TypeSubTypeValueTuple(TypeSubTypeValue)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return iterator next is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TypeSubTypeValueTuple#TypeSubTypeValueTuple(TypeSubTypeValue)}
   */
  @Test
  @DisplayName(
      "Test new TypeSubTypeValueTuple(TypeSubTypeValue); when 'null'; then return iterator next is 'null'")
  @Tag("MaintainedByDiffblue")
  void testNewTypeSubTypeValueTuple_whenNull_thenReturnIteratorNextIsNull() {
    // Arrange and Act
    TypeSubTypeValueTuple actualTypeSubTypeValueTuple = new TypeSubTypeValueTuple(null);

    // Assert
    Iterable<Object> valuesResult = actualTypeSubTypeValueTuple.values();
    assertTrue(valuesResult instanceof List);
    Iterator<Object> iteratorResult = actualTypeSubTypeValueTuple.iterator();
    assertNull(iteratorResult.next());
    assertNull(iteratorResult.next());
    assertNull(iteratorResult.next());
    assertEquals(3, ((List<Object>) valuesResult).size());
    assertNull(((List<Object>) valuesResult).get(0));
    assertNull(((List<Object>) valuesResult).get(1));
    assertNull(((List<Object>) valuesResult).get(2));
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link TypeSubTypeValueTuple#get(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link TypeSubTypeValueTuple#get(String)}
   */
  @Test
  @DisplayName("Test get(String) with 'String'; when 'Key'")
  @Tag("MaintainedByDiffblue")
  void testGetWithString_whenKey() {
    // Arrange, Act and Assert
    assertNull(new TypeSubTypeValueTuple().get("Key"));
  }

  /**
   * Test {@link TypeSubTypeValueTuple#get(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@link TypeSubTypeValueTuple#SUBTYPE}.
   * </ul>
   *
   * <p>Method under test: {@link TypeSubTypeValueTuple#get(String)}
   */
  @Test
  @DisplayName("Test get(String) with 'String'; when SUBTYPE")
  @Tag("MaintainedByDiffblue")
  void testGetWithString_whenSubtype() {
    // Arrange, Act and Assert
    assertNull(new TypeSubTypeValueTuple().get(TypeSubTypeValueTuple.SUBTYPE));
  }

  /**
   * Test {@link TypeSubTypeValueTuple#get(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@link TypeSubTypeValueTuple#TYPE}.
   * </ul>
   *
   * <p>Method under test: {@link TypeSubTypeValueTuple#get(String)}
   */
  @Test
  @DisplayName("Test get(String) with 'String'; when TYPE")
  @Tag("MaintainedByDiffblue")
  void testGetWithString_whenType() {
    // Arrange, Act and Assert
    assertNull(new TypeSubTypeValueTuple().get(TypeSubTypeValueTuple.TYPE));
  }

  /**
   * Test {@link TypeSubTypeValueTuple#get(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@link TypeSubTypeValueTuple#VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link TypeSubTypeValueTuple#get(String)}
   */
  @Test
  @DisplayName("Test get(String) with 'String'; when VALUE")
  @Tag("MaintainedByDiffblue")
  void testGetWithString_whenValue() {
    // Arrange, Act and Assert
    assertNull(new TypeSubTypeValueTuple().get(TypeSubTypeValueTuple.VALUE));
  }

  /**
   * Test {@link TypeSubTypeValueTuple#values()}.
   *
   * <p>Method under test: {@link TypeSubTypeValueTuple#values()}
   */
  @Test
  @DisplayName("Test values()")
  @Tag("MaintainedByDiffblue")
  void testValues() {
    // Arrange and Act
    Iterable<Object> actualValuesResult = new TypeSubTypeValueTuple().values();
    Iterator<Object> actualIteratorResult = actualValuesResult.iterator();

    // Assert
    assertTrue(actualValuesResult instanceof List);
    assertNull(actualIteratorResult.next());
    assertNull(actualIteratorResult.next());
    assertNull(actualIteratorResult.next());
    assertEquals(3, ((List<Object>) actualValuesResult).size());
    assertNull(((List<Object>) actualValuesResult).get(0));
    assertNull(((List<Object>) actualValuesResult).get(1));
    assertNull(((List<Object>) actualValuesResult).get(2));
    assertFalse(actualIteratorResult.hasNext());
  }
}
