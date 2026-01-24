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

package uk.gov.gchq.gaffer.serialisation.implementation.ordered;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OrderedDateSerialiserDiffblueTest {
  /**
   * Test {@link OrderedDateSerialiser#serialise(Date)} with {@code Date}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with backspace and {@link Byte#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedDateSerialiser#serialise(Date)}
   */
  @Test
  @DisplayName(
      "Test serialise(Date) with 'Date'; then return array of byte with backspace and MAX_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] OrderedDateSerialiser.serialise(Date)"})
  void testSerialiseWithDate_thenReturnArrayOfByteWithBackspaceAndMax_value() {
    // Arrange
    OrderedDateSerialiser orderedDateSerialiser = new OrderedDateSerialiser();

    LocalDate ofYearDayResult = LocalDate.ofYearDay(56, 56);

    // Act and Assert
    assertArrayEquals(
        new byte[] {'\b', Byte.MAX_VALUE, -1, -55, 18, '#', 20, '\f', 0},
        orderedDateSerialiser.serialise(
            Date.from(ofYearDayResult.atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
  }

  /**
   * Test {@link OrderedDateSerialiser#serialise(Date)} with {@code Date}.
   *
   * <ul>
   *   <li>Then return array of {@code byte} with backspace and {@link Byte#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedDateSerialiser#serialise(Date)}
   */
  @Test
  @DisplayName(
      "Test serialise(Date) with 'Date'; then return array of byte with backspace and MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] OrderedDateSerialiser.serialise(Date)"})
  void testSerialiseWithDate_thenReturnArrayOfByteWithBackspaceAndMin_value() {
    // Arrange
    OrderedDateSerialiser orderedDateSerialiser = new OrderedDateSerialiser();

    // Act and Assert
    assertArrayEquals(
        new byte[] {'\b', Byte.MIN_VALUE, 0, 0, 0, 0, 0, 0, 0},
        orderedDateSerialiser.serialise(
            Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
  }

  /**
   * Test {@link OrderedDateSerialiser#serialise(Date)} with {@code Date}.
   *
   * <ul>
   *   <li>When {@link Date#Date(long)} with {@link Long#MAX_VALUE}.
   *   <li>Then return array of {@code byte} with sixteen.
   * </ul>
   *
   * <p>Method under test: {@link OrderedDateSerialiser#serialise(Date)}
   */
  @Test
  @DisplayName(
      "Test serialise(Date) with 'Date'; when Date(long) with MAX_VALUE; then return array of byte with sixteen")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] OrderedDateSerialiser.serialise(Date)"})
  void testSerialiseWithDate_whenDateWithMax_value_thenReturnArrayOfByteWithSixteen() {
    // Arrange
    OrderedDateSerialiser orderedDateSerialiser = new OrderedDateSerialiser();

    // Act
    byte[] actualSerialiseResult = orderedDateSerialiser.serialise(new Date(Long.MAX_VALUE));

    // Assert
    assertArrayEquals(new byte[] {16}, actualSerialiseResult);
  }

  /**
   * Test {@link OrderedDateSerialiser#deserialiseEmpty()}.
   *
   * <p>Method under test: {@link OrderedDateSerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Date OrderedDateSerialiser.deserialiseEmpty()"})
  void testDeserialiseEmpty() {
    // Arrange, Act and Assert
    assertNull(new OrderedDateSerialiser().deserialiseEmpty());
  }

  /**
   * Test {@link OrderedDateSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link OrderedDateSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderedDateSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertTrue(new OrderedDateSerialiser().preservesObjectOrdering());
  }

  /**
   * Test {@link OrderedDateSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedDateSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderedDateSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    OrderedDateSerialiser orderedDateSerialiser = new OrderedDateSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(orderedDateSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link OrderedDateSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Date}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link OrderedDateSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.util.Date'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OrderedDateSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaUtilDate_thenReturnTrue() {
    // Arrange
    OrderedDateSerialiser orderedDateSerialiser = new OrderedDateSerialiser();
    Class<Date> clazz = Date.class;

    // Act and Assert
    assertTrue(orderedDateSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link OrderedDateSerialiser#equals(Object)}, and {@link
   * OrderedDateSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderedDateSerialiser#equals(Object)}
   *   <li>{@link OrderedDateSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderedDateSerialiser.equals(Object)",
    "int OrderedDateSerialiser.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OrderedDateSerialiser orderedDateSerialiser = new OrderedDateSerialiser();
    OrderedDateSerialiser orderedDateSerialiser2 = new OrderedDateSerialiser();

    // Act and Assert
    assertEquals(orderedDateSerialiser, orderedDateSerialiser2);
    assertEquals(orderedDateSerialiser.hashCode(), orderedDateSerialiser2.hashCode());
  }

  /**
   * Test {@link OrderedDateSerialiser#equals(Object)}, and {@link
   * OrderedDateSerialiser#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OrderedDateSerialiser#equals(Object)}
   *   <li>{@link OrderedDateSerialiser#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderedDateSerialiser.equals(Object)",
    "int OrderedDateSerialiser.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OrderedDateSerialiser orderedDateSerialiser = new OrderedDateSerialiser();

    // Act and Assert
    assertEquals(orderedDateSerialiser, orderedDateSerialiser);
    int expectedHashCodeResult = orderedDateSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, orderedDateSerialiser.hashCode());
  }

  /**
   * Test {@link OrderedDateSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderedDateSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderedDateSerialiser.equals(Object)",
    "int OrderedDateSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OrderedDateSerialiser(), 1);
  }

  /**
   * Test {@link OrderedDateSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderedDateSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderedDateSerialiser.equals(Object)",
    "int OrderedDateSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OrderedDateSerialiser(), null);
  }

  /**
   * Test {@link OrderedDateSerialiser#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OrderedDateSerialiser#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean OrderedDateSerialiser.equals(Object)",
    "int OrderedDateSerialiser.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OrderedDateSerialiser(), "Different type to OrderedDateSerialiser");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link OrderedDateSerialiser}
   *   <li>{@link OrderedDateSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OrderedDateSerialiser.<init>()",
    "boolean OrderedDateSerialiser.isConsistent()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue(new OrderedDateSerialiser().isConsistent());
  }
}
