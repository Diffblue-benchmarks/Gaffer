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

package uk.gov.gchq.gaffer.store.serialiser;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Entity;
import uk.gov.gchq.gaffer.exception.SerialisationException;
import uk.gov.gchq.gaffer.store.schema.Schema;

class EntitySerialiserDiffblueTest {
  /**
   * Test {@link EntitySerialiser#EntitySerialiser()}.
   * <p>
   * Method under test: {@link EntitySerialiser#EntitySerialiser()}
   */
  @Test
  @DisplayName("Test new EntitySerialiser()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntitySerialiser.<init>()"})
  void testNewEntitySerialiser() {
    // Arrange and Act
    EntitySerialiser actualEntitySerialiser = new EntitySerialiser();

    // Assert
    assertNull(actualEntitySerialiser.vertexSerialiser);
    assertNull(actualEntitySerialiser.schema);
    assertFalse(actualEntitySerialiser.isConsistent());
  }

  /**
   * Test {@link EntitySerialiser#EntitySerialiser(Schema)}.
   * <ul>
   *   <li>When {@link Schema#Schema()}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitySerialiser#EntitySerialiser(Schema)}
   */
  @Test
  @DisplayName("Test new EntitySerialiser(Schema); when Schema(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntitySerialiser.<init>(Schema)"})
  void testNewEntitySerialiser_whenSchema_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new EntitySerialiser(new Schema()));
  }

  /**
   * Test {@link EntitySerialiser#updateSchema(Schema)}.
   * <ul>
   *   <li>When {@link Schema#Schema()}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitySerialiser#updateSchema(Schema)}
   */
  @Test
  @DisplayName("Test updateSchema(Schema); when Schema(); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntitySerialiser.updateSchema(Schema)"})
  void testUpdateSchema_whenSchema_thenThrowIllegalArgumentException() {
    // Arrange
    EntitySerialiser entitySerialiser = new EntitySerialiser();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> entitySerialiser.updateSchema(new Schema()));
  }

  /**
   * Test {@link EntitySerialiser#canHandle(Class)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitySerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitySerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    EntitySerialiser entitySerialiser = new EntitySerialiser();
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(entitySerialiser.canHandle(clazz));
  }

  /**
   * Test {@link EntitySerialiser#canHandle(Class)}.
   * <ul>
   *   <li>When {@code Entity}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitySerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'uk.gov.gchq.gaffer.data.element.Entity'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitySerialiser.canHandle(Class)"})
  void testCanHandle_whenUkGovGchqGafferDataElementEntity_thenReturnTrue() {
    // Arrange
    EntitySerialiser entitySerialiser = new EntitySerialiser();
    Class<Entity> clazz = Entity.class;

    // Act and Assert
    assertTrue(entitySerialiser.canHandle(clazz));
  }

  /**
   * Test {@link EntitySerialiser#deserialiseEmpty()}.
   * <p>
   * Method under test: {@link EntitySerialiser#deserialiseEmpty()}
   */
  @Test
  @DisplayName("Test deserialiseEmpty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Entity EntitySerialiser.deserialiseEmpty()"})
  void testDeserialiseEmpty() throws SerialisationException {
    // Arrange, Act and Assert
    assertNull((new EntitySerialiser()).deserialiseEmpty());
  }

  /**
   * Test {@link EntitySerialiser#isConsistent()}.
   * <p>
   * Method under test: {@link EntitySerialiser#isConsistent()}
   */
  @Test
  @DisplayName("Test isConsistent()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntitySerialiser.isConsistent()"})
  void testIsConsistent() {
    // Arrange, Act and Assert
    assertFalse((new EntitySerialiser()).isConsistent());
  }
}
