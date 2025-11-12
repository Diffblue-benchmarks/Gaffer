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

package uk.gov.gchq.gaffer.serialisation.implementation.ordered;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import org.junit.jupiter.api.Test;

class OrderedDateSerialiserDiffblueTest {
  /**
   * Method under test: {@link OrderedDateSerialiser#serialise(Date)}
   */
  @Test
  void testSerialise() {
    // Arrange
    OrderedDateSerialiser orderedDateSerialiser = new OrderedDateSerialiser();

    // Act and Assert
    assertArrayEquals(new byte[]{'\b', Byte.MIN_VALUE, 0, 0, 0, 0, 0, 0, 0}, orderedDateSerialiser
        .serialise(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
  }

  /**
   * Method under test: {@link OrderedDateSerialiser#serialise(Date)}
   */
  @Test
  void testSerialise2() {
    // Arrange
    OrderedDateSerialiser orderedDateSerialiser = new OrderedDateSerialiser();

    // Act and Assert
    assertArrayEquals(new byte[]{'\b', Byte.MAX_VALUE, -1, -55, 18, '#', 20, '\f', 0}, orderedDateSerialiser
        .serialise(Date.from(LocalDate.ofYearDay(56, 56).atStartOfDay().atZone(ZoneOffset.UTC).toInstant())));
  }

  /**
   * Method under test: {@link OrderedDateSerialiser#serialise(java.util.Date)}
   */
  @Test
  void testSerialise3() {
    // Arrange
    OrderedDateSerialiser orderedDateSerialiser = new OrderedDateSerialiser();
    java.sql.Date object = mock(java.sql.Date.class);
    when(object.getTime()).thenReturn(10L);

    // Act
    byte[] actualSerialiseResult = orderedDateSerialiser.serialise(object);

    // Assert
    verify(object).getTime();
    assertArrayEquals(new byte[]{'\b', Byte.MIN_VALUE, 0, 0, 0, 0, 0, 0, '\n'}, actualSerialiseResult);
  }

  /**
   * Method under test: {@link OrderedDateSerialiser#serialise(java.util.Date)}
   */
  @Test
  void testSerialise4() {
    // Arrange
    OrderedDateSerialiser orderedDateSerialiser = new OrderedDateSerialiser();
    java.sql.Date object = mock(java.sql.Date.class);
    when(object.getTime()).thenReturn(Long.MAX_VALUE);

    // Act
    byte[] actualSerialiseResult = orderedDateSerialiser.serialise(object);

    // Assert
    verify(object).getTime();
    assertArrayEquals(new byte[]{16}, actualSerialiseResult);
  }

  /**
   * Method under test: {@link OrderedDateSerialiser#deserialiseEmpty()}
   */
  @Test
  void testDeserialiseEmpty() {
    // Arrange, Act and Assert
    assertNull((new OrderedDateSerialiser()).deserialiseEmpty());
  }

  /**
   * Method under test: {@link OrderedDateSerialiser#preservesObjectOrdering()}
   */
  @Test
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertTrue((new OrderedDateSerialiser()).preservesObjectOrdering());
  }

  /**
   * Method under test: {@link OrderedDateSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle() {
    // Arrange
    OrderedDateSerialiser orderedDateSerialiser = new OrderedDateSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(orderedDateSerialiser.canHandle(clazz));
  }

  /**
   * Method under test: {@link OrderedDateSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle2() {
    // Arrange
    OrderedDateSerialiser orderedDateSerialiser = new OrderedDateSerialiser();
    Class<Date> clazz = Date.class;

    // Act and Assert
    assertTrue(orderedDateSerialiser.canHandle(clazz));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OrderedDateSerialiser#equals(Object)}
   *   <li>{@link OrderedDateSerialiser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OrderedDateSerialiser orderedDateSerialiser = new OrderedDateSerialiser();
    OrderedDateSerialiser orderedDateSerialiser2 = new OrderedDateSerialiser();

    // Act and Assert
    assertEquals(orderedDateSerialiser, orderedDateSerialiser2);
    int expectedHashCodeResult = orderedDateSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, orderedDateSerialiser2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link OrderedDateSerialiser#equals(Object)}
   *   <li>{@link OrderedDateSerialiser#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OrderedDateSerialiser orderedDateSerialiser = new OrderedDateSerialiser();

    // Act and Assert
    assertEquals(orderedDateSerialiser, orderedDateSerialiser);
    int expectedHashCodeResult = orderedDateSerialiser.hashCode();
    assertEquals(expectedHashCodeResult, orderedDateSerialiser.hashCode());
  }

  /**
   * Method under test: {@link OrderedDateSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OrderedDateSerialiser(), 1);
  }

  /**
   * Method under test: {@link OrderedDateSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OrderedDateSerialiser(), null);
  }

  /**
   * Method under test: {@link OrderedDateSerialiser#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OrderedDateSerialiser(), "Different type to OrderedDateSerialiser");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link OrderedDateSerialiser}
   *   <li>{@link OrderedDateSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue((new OrderedDateSerialiser()).isConsistent());
  }
}
