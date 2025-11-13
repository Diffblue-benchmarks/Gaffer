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

package uk.gov.gchq.gaffer.sparkaccumulo.operation.handler.scalardd;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.sparkaccumulo.operation.handler.scalardd.GetRDDOfAllElementsHandler.EntryToElement;
import uk.gov.gchq.gaffer.sparkaccumulo.operation.handler.scalardd.GetRDDOfAllElementsHandler.FilterOutNull;

class GetRDDOfAllElementsHandlerDiffblueTest {
  /**
   * Test EntryToElement {@link EntryToElement#EntryToElement(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and minus one.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntryToElement#EntryToElement(byte[])}
   */
  @Test
  @DisplayName("Test EntryToElement new EntryToElement(byte[]); when array of byte with 'A' and minus one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntryToElement.<init>(byte[])"})
  void testEntryToElementNewEntryToElement_whenArrayOfByteWithAAndMinusOne() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new EntryToElement(new byte[]{'A', -1, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test EntryToElement {@link EntryToElement#EntryToElement(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntryToElement#EntryToElement(byte[])}
   */
  @Test
  @DisplayName("Test EntryToElement new EntryToElement(byte[]); when array of byte with 'A' and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntryToElement.<init>(byte[])"})
  void testEntryToElementNewEntryToElement_whenArrayOfByteWithAAndZero() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new EntryToElement(new byte[]{'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test EntryToElement {@link EntryToElement#EntryToElement(byte[])}.
   * <ul>
   *   <li>When array of {@code byte} with {@link Byte#MIN_VALUE} and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntryToElement#EntryToElement(byte[])}
   */
  @Test
  @DisplayName("Test EntryToElement new EntryToElement(byte[]); when array of byte with MIN_VALUE and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntryToElement.<init>(byte[])"})
  void testEntryToElementNewEntryToElement_whenArrayOfByteWithMin_valueAndX() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> new EntryToElement(new byte[]{Byte.MIN_VALUE, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test EntryToElement {@link EntryToElement#EntryToElement(byte[])}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntryToElement#EntryToElement(byte[])}
   */
  @Test
  @DisplayName("Test EntryToElement new EntryToElement(byte[]); when 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntryToElement.<init>(byte[])"})
  void testEntryToElementNewEntryToElement_whenAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new EntryToElement("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test FilterOutNull {@link FilterOutNull#apply(Element)} with {@code Element}.
   * <ul>
   *   <li>When {@link Edge#Edge(String)} with {@code Group}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterOutNull#apply(Element)}
   */
  @Test
  @DisplayName("Test FilterOutNull apply(Element) with 'Element'; when Edge(String) with 'Group'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Object FilterOutNull.apply(Element)"})
  void testFilterOutNullApplyWithElement_whenEdgeWithGroup_thenReturnTrue() {
    // Arrange
    FilterOutNull filterOutNull = new FilterOutNull();

    // Act and Assert
    assertTrue((Boolean) filterOutNull.apply(new Edge("Group")));
  }

  /**
   * Test FilterOutNull {@link FilterOutNull#apply(Element)} with {@code Element}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FilterOutNull#apply(Element)}
   */
  @Test
  @DisplayName("Test FilterOutNull apply(Element) with 'Element'; when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Object FilterOutNull.apply(Element)"})
  void testFilterOutNullApplyWithElement_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((Boolean) (new FilterOutNull()).apply(null));
  }

  /**
   * Test FilterOutNull new {@link FilterOutNull} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link FilterOutNull}
   */
  @Test
  @DisplayName("Test FilterOutNull new FilterOutNull (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FilterOutNull.<init>()"})
  void testFilterOutNullNewFilterOutNull() {
    // Arrange, Act and Assert
    assertFalse((Boolean) (new FilterOutNull()).apply(null));
  }
}
