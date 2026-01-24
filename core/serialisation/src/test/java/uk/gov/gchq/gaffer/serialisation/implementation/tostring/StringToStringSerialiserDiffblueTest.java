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

package uk.gov.gchq.gaffer.serialisation.implementation.tostring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.exception.SerialisationException;

class StringToStringSerialiserDiffblueTest {
  /**
   * Test {@link StringToStringSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link StringToStringSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringToStringSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    StringToStringSerialiser stringToStringSerialiser = new StringToStringSerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(stringToStringSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link StringToStringSerialiser#canHandle(Class)}.
   *
   * <ul>
   *   <li>When {@code String}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link StringToStringSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.String'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringToStringSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangString_thenReturnTrue() {
    // Arrange
    StringToStringSerialiser stringToStringSerialiser = new StringToStringSerialiser();
    Class<String> clazz = String.class;

    // Act and Assert
    assertTrue(stringToStringSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link StringToStringSerialiser#serialise(String)} with {@code String}.
   *
   * <p>Method under test: {@link StringToStringSerialiser#serialise(String)}
   */
  @Test
  @DisplayName("Test serialise(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringToStringSerialiser.serialise(String)"})
  void testSerialiseWithString() throws SerialisationException {
    // Arrange, Act and Assert
    assertEquals("Object", new StringToStringSerialiser().serialise("Object"));
  }

  /**
   * Test {@link StringToStringSerialiser#deserialise(String)} with {@code String}.
   *
   * <p>Method under test: {@link StringToStringSerialiser#deserialise(String)}
   */
  @Test
  @DisplayName("Test deserialise(String) with 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String StringToStringSerialiser.deserialise(String)"})
  void testDeserialiseWithString() throws SerialisationException {
    // Arrange, Act and Assert
    assertEquals("foo", new StringToStringSerialiser().deserialise("foo"));
  }

  /**
   * Test {@link StringToStringSerialiser#preservesObjectOrdering()}.
   *
   * <p>Method under test: {@link StringToStringSerialiser#preservesObjectOrdering()}
   */
  @Test
  @DisplayName("Test preservesObjectOrdering()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StringToStringSerialiser.preservesObjectOrdering()"})
  void testPreservesObjectOrdering() {
    // Arrange, Act and Assert
    assertTrue(new StringToStringSerialiser().preservesObjectOrdering());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link StringToStringSerialiser}
   *   <li>{@link StringToStringSerialiser#isConsistent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StringToStringSerialiser.<init>()",
    "boolean StringToStringSerialiser.isConsistent()"
  })
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertTrue(new StringToStringSerialiser().isConsistent());
  }
}
