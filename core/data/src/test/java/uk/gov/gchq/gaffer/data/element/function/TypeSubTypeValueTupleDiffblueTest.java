/*
 * Copyright 2026 Crown Copyright
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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

class TypeSubTypeValueTupleDiffblueTest {
  /**
   * Test {@link TypeSubTypeValueTuple#TypeSubTypeValueTuple()}.
   *
   * <p>Method under test: {@link TypeSubTypeValueTuple#TypeSubTypeValueTuple()}
   */
  @Test
  @DisplayName("Test new TypeSubTypeValueTuple()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TypeSubTypeValueTuple.<init>()"})
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
    assertEquals(-1L, actualTypeSubTypeValueTuple.spliterator().getExactSizeIfKnown());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link TypeSubTypeValueTuple#TypeSubTypeValueTuple(TypeSubTypeValue)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TypeSubTypeValueTuple#TypeSubTypeValueTuple(TypeSubTypeValue)}
   */
  @Test
  @DisplayName("Test new TypeSubTypeValueTuple(TypeSubTypeValue); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TypeSubTypeValueTuple.<init>(TypeSubTypeValue)"})
  void testNewTypeSubTypeValueTuple_whenNull() {
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
    assertEquals(-1L, actualTypeSubTypeValueTuple.spliterator().getExactSizeIfKnown());
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link TypeSubTypeValueTuple#TypeSubTypeValueTuple(TypeSubTypeValue)}.
   *
   * <ul>
   *   <li>When {@link TypeSubTypeValue#TypeSubTypeValue()}.
   * </ul>
   *
   * <p>Method under test: {@link TypeSubTypeValueTuple#TypeSubTypeValueTuple(TypeSubTypeValue)}
   */
  @Test
  @DisplayName("Test new TypeSubTypeValueTuple(TypeSubTypeValue); when TypeSubTypeValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TypeSubTypeValueTuple.<init>(TypeSubTypeValue)"})
  void testNewTypeSubTypeValueTuple_whenTypeSubTypeValue() {
    // Arrange and Act
    TypeSubTypeValueTuple actualTypeSubTypeValueTuple =
        new TypeSubTypeValueTuple(new TypeSubTypeValue());

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
    assertEquals(-1L, actualTypeSubTypeValueTuple.spliterator().getExactSizeIfKnown());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TypeSubTypeValueTuple.get(String)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TypeSubTypeValueTuple.get(String)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TypeSubTypeValueTuple.get(String)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TypeSubTypeValueTuple.get(String)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Iterable TypeSubTypeValueTuple.values()"})
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
