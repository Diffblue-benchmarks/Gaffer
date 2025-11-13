/*
 * Copyright 2025 Crown Copyright
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

package uk.gov.gchq.gaffer.spark.operation.dataframe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
   * <ul>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()}.</li>
   *   <li>Then apply {@code null} return {@link GenericRow}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConvertElementToRow#ConvertElementToRow(LinkedHashSet, Map, Map)}
   */
  @Test
  @DisplayName("Test new ConvertElementToRow(LinkedHashSet, Map, Map); when LinkedHashSet(); then apply 'null' return GenericRow")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ConvertElementToRow.<init>(LinkedHashSet, Map, Map)"})
  void testNewConvertElementToRow_whenLinkedHashSet_thenApplyNullReturnGenericRow() {
    // Arrange
    LinkedHashSet<String> properties = new LinkedHashSet<>();
    HashMap<String, Boolean> propertyNeedsConversion = new HashMap<>();

    // Act and Assert
    Row applyResult = (new ConvertElementToRow(properties, propertyNeedsConversion, new HashMap<>())).apply(null);
    assertTrue(applyResult instanceof GenericRow);
    assertNull(applyResult.schema());
    assertEquals(0, applyResult.length());
    assertEquals(0, applyResult.size());
    assertEquals(0, ((GenericRow) applyResult).values().length);
  }

  /**
   * Test {@link ConvertElementToRow#apply(Element)} with {@code Element}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code 42} is {@code false}.</li>
   *   <li>Then return first element is {@code Value}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConvertElementToRow#apply(Element)}
   */
  @Test
  @DisplayName("Test apply(Element) with 'Element'; given HashMap() '42' is 'false'; then return first element is 'Value'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Row ConvertElementToRow.apply(Element)"})
  void testApplyWithElement_givenHashMap42IsFalse_thenReturnFirstElementIsValue() {
    // Arrange
    LinkedHashSet<String> properties = new LinkedHashSet<>();
    properties.add("42");
    properties.add("foo");

    HashMap<String, Boolean> propertyNeedsConversion = new HashMap<>();
    propertyNeedsConversion.put("42", false);
    ConvertElementToRow convertElementToRow = new ConvertElementToRow(properties, propertyNeedsConversion,
        new HashMap<>());

    Edge element = new Edge("Group");
    element.putProperty("42", "Value");

    // Act
    Row actualApplyResult = convertElementToRow.apply(element);

    // Assert
    assertTrue(actualApplyResult instanceof GenericRow);
    Object[] valuesResult = ((GenericRow) actualApplyResult).values();
    assertEquals("Value", valuesResult[0]);
    assertNull(valuesResult[1]);
    assertEquals(2, actualApplyResult.length());
    assertEquals(2, actualApplyResult.size());
    assertEquals(2, valuesResult.length);
  }

  /**
   * Test {@link ConvertElementToRow#apply(Element)} with {@code Element}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code 42} is {@code true}.</li>
   *   <li>Then return first element is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConvertElementToRow#apply(Element)}
   */
  @Test
  @DisplayName("Test apply(Element) with 'Element'; given HashMap() '42' is 'true'; then return first element is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Row ConvertElementToRow.apply(Element)"})
  void testApplyWithElement_givenHashMap42IsTrue_thenReturnFirstElementIsNull() {
    // Arrange
    LinkedHashSet<String> properties = new LinkedHashSet<>();
    properties.add("42");
    properties.add("foo");

    HashMap<String, Boolean> propertyNeedsConversion = new HashMap<>();
    propertyNeedsConversion.put("42", true);
    ConvertElementToRow convertElementToRow = new ConvertElementToRow(properties, propertyNeedsConversion,
        new HashMap<>());

    Edge element = new Edge("Group");
    element.putProperty("42", "Value");

    // Act
    Row actualApplyResult = convertElementToRow.apply(element);

    // Assert
    assertTrue(actualApplyResult instanceof GenericRow);
    Object[] valuesResult = ((GenericRow) actualApplyResult).values();
    assertNull(valuesResult[0]);
    assertNull(valuesResult[1]);
    assertEquals(2, actualApplyResult.length());
    assertEquals(2, actualApplyResult.size());
    assertEquals(2, valuesResult.length);
  }

  /**
   * Test {@link ConvertElementToRow#apply(Element)} with {@code Element}.
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.</li>
   *   <li>Then return length is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConvertElementToRow#apply(Element)}
   */
  @Test
  @DisplayName("Test apply(Element) with 'Element'; when Edge(String) with 'Group'; then return length is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Row ConvertElementToRow.apply(Element)"})
  void testApplyWithElement_whenEdgeWithGroup_thenReturnLengthIsOne() {
    // Arrange
    LinkedHashSet<String> properties = new LinkedHashSet<>();
    properties.add("foo");
    HashMap<String, Boolean> propertyNeedsConversion = new HashMap<>();
    ConvertElementToRow convertElementToRow = new ConvertElementToRow(properties, propertyNeedsConversion,
        new HashMap<>());

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
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.</li>
   *   <li>Then return schema is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConvertElementToRow#apply(Element)}
   */
  @Test
  @DisplayName("Test apply(Element) with 'Element'; when Edge(String) with 'Group'; then return schema is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Row ConvertElementToRow.apply(Element)"})
  void testApplyWithElement_whenEdgeWithGroup_thenReturnSchemaIsNull() {
    // Arrange
    LinkedHashSet<String> properties = new LinkedHashSet<>();
    HashMap<String, Boolean> propertyNeedsConversion = new HashMap<>();
    ConvertElementToRow convertElementToRow = new ConvertElementToRow(properties, propertyNeedsConversion,
        new HashMap<>());

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
