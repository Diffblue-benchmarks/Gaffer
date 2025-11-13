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

package uk.gov.gchq.gaffer.spark.serialisation.kryo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.util.DefaultClassResolver;
import com.esotericsoftware.kryo.util.ListReferenceResolver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.spark.serialisation.kryo.impl.EdgeKryoSerializer;

class RegistratorDiffblueTest {
  /**
   * Test {@link Registrator#registerClasses(Kryo)}.
   * <p>
   * Method under test: {@link Registrator#registerClasses(Kryo)}
   */
  @Test
  @DisplayName("Test registerClasses(Kryo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Registrator.registerClasses(Kryo)"})
  void testRegisterClasses() {
    // Arrange
    Registrator registrator = new Registrator();
    Kryo kryo = new Kryo(new ListReferenceResolver());

    // Act
    registrator.registerClasses(kryo);

    // Assert
    assertEquals(25, kryo.getNextRegistrationId());
  }

  /**
   * Test {@link Registrator#registerClasses(Kryo)}.
   * <p>
   * Method under test: {@link Registrator#registerClasses(Kryo)}
   */
  @Test
  @DisplayName("Test registerClasses(Kryo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Registrator.registerClasses(Kryo)"})
  void testRegisterClasses2() {
    // Arrange
    Registrator registrator = new Registrator();
    DefaultClassResolver classResolver = new DefaultClassResolver();
    Kryo kryo = new Kryo(classResolver, new ListReferenceResolver());

    // Act
    registrator.registerClasses(kryo);

    // Assert
    assertEquals(25, kryo.getNextRegistrationId());
  }

  /**
   * Test {@link Registrator#registerClasses(Kryo)}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Registrator#registerClasses(Kryo)}
   */
  @Test
  @DisplayName("Test registerClasses(Kryo); given 'java.lang.Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Registrator.registerClasses(Kryo)"})
  void testRegisterClasses_givenJavaLangObject() {
    // Arrange
    Registrator registrator = new Registrator();

    Kryo kryo = new Kryo();
    Class<Object> type = Object.class;
    kryo.addDefaultSerializer(type, new EdgeKryoSerializer());

    // Act
    registrator.registerClasses(kryo);

    // Assert
    assertEquals(25, kryo.getNextRegistrationId());
  }

  /**
   * Test {@link Registrator#registerClasses(Kryo)}.
   * <ul>
   *   <li>When {@link Kryo#Kryo()}.</li>
   *   <li>Then {@link Kryo#Kryo()} NextRegistrationId is twenty-five.</li>
   * </ul>
   * <p>
   * Method under test: {@link Registrator#registerClasses(Kryo)}
   */
  @Test
  @DisplayName("Test registerClasses(Kryo); when Kryo(); then Kryo() NextRegistrationId is twenty-five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Registrator.registerClasses(Kryo)"})
  void testRegisterClasses_whenKryo_thenKryoNextRegistrationIdIsTwentyFive() {
    // Arrange
    Registrator registrator = new Registrator();
    Kryo kryo = new Kryo();

    // Act
    registrator.registerClasses(kryo);

    // Assert
    assertEquals(25, kryo.getNextRegistrationId());
  }
}
