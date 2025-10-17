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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.factories.SerializerFactory;
import com.esotericsoftware.kryo.util.DefaultClassResolver;
import com.esotericsoftware.kryo.util.ListReferenceResolver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.spark.serialisation.kryo.impl.EdgeKryoSerializer;

class RegistratorDiffblueTest {
  /**
   * Test {@link Registrator#registerClasses(Kryo)}.
   *
   * <p>Method under test: {@link Registrator#registerClasses(Kryo)}
   */
  @Test
  @DisplayName("Test registerClasses(Kryo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Registrator#registerClasses(Kryo)}
   */
  @Test
  @DisplayName("Test registerClasses(Kryo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Registrator.registerClasses(Kryo)"})
  void testRegisterClasses2() {
    // Arrange
    Registrator registrator = new Registrator();
    DefaultClassResolver classResolver = new DefaultClassResolver();

    Kryo kryo = new Kryo(classResolver, new ListReferenceResolver());
    Class<Object> type = Object.class;
    kryo.addDefaultSerializer(type, new EdgeKryoSerializer());

    // Act
    registrator.registerClasses(kryo);

    // Assert
    assertEquals(25, kryo.getNextRegistrationId());
  }

  /**
   * Test {@link Registrator#registerClasses(Kryo)}.
   *
   * <ul>
   *   <li>Then calls {@link SerializerFactory#makeSerializer(Kryo, Class)}.
   * </ul>
   *
   * <p>Method under test: {@link Registrator#registerClasses(Kryo)}
   */
  @Test
  @DisplayName("Test registerClasses(Kryo); then calls makeSerializer(Kryo, Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Registrator.registerClasses(Kryo)"})
  void testRegisterClasses_thenCallsMakeSerializer() {
    // Arrange
    Registrator registrator = new Registrator();

    SerializerFactory serializerFactory = mock(SerializerFactory.class);
    when(serializerFactory.makeSerializer(Mockito.<Kryo>any(), Mockito.<Class<?>>any()))
        .thenReturn(new EdgeKryoSerializer());

    Kryo kryo = new Kryo();
    Class<Object> type = Object.class;

    kryo.addDefaultSerializer(type, serializerFactory);
    Class<Object> type2 = Object.class;
    kryo.addDefaultSerializer(type2, mock(SerializerFactory.class));
    Class<Object> type3 = Object.class;
    kryo.addDefaultSerializer(type3, mock(SerializerFactory.class));
    Class<Object> type4 = Object.class;
    kryo.addDefaultSerializer(type4, new EdgeKryoSerializer());

    // Act
    registrator.registerClasses(kryo);

    // Assert
    verify(serializerFactory).makeSerializer(isA(Kryo.class), isA(Class.class));
    assertEquals(25, kryo.getNextRegistrationId());
  }

  /**
   * Test {@link Registrator#registerClasses(Kryo)}.
   *
   * <ul>
   *   <li>Then {@link Kryo#Kryo()} NextRegistrationId is twenty-five.
   * </ul>
   *
   * <p>Method under test: {@link Registrator#registerClasses(Kryo)}
   */
  @Test
  @DisplayName("Test registerClasses(Kryo); then Kryo() NextRegistrationId is twenty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Registrator.registerClasses(Kryo)"})
  void testRegisterClasses_thenKryoNextRegistrationIdIsTwentyFive() {
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
}
