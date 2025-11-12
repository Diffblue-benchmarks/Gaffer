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

package uk.gov.gchq.gaffer.operation.serialisation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.Test;

class TypeReferenceImplDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link TypeReferenceImpl.Array}
   */
  @Test
  void testArrayNewArray() {
    // Arrange and Act
    TypeReferenceImpl.Array<Object> actualArray = new TypeReferenceImpl.Array<>();

    // Assert
    assertEquals("T[]", actualArray.getType().getTypeName());
  }

  /**
   * Method under test: {@link TypeReferenceImpl#createExplicitT()}
   */
  @Test
  void testCreateExplicitT() {
    // Arrange and Act
    TypeReference<Object> actualCreateExplicitTResult = TypeReferenceImpl.createExplicitT();

    // Assert
    assertTrue(actualCreateExplicitTResult instanceof TypeReferenceImpl.Object);
  }

  /**
   * Method under test: {@link TypeReferenceImpl#createIterableT()}
   */
  @Test
  void testCreateIterableT() {
    // Arrange and Act
    TypeReference<Iterable<?>> actualCreateIterableTResult = TypeReferenceImpl.createIterableT();

    // Assert
    assertTrue(actualCreateIterableTResult instanceof TypeReferenceImpl.IterableObj);
    assertEquals("java.lang.Iterable<?>", actualCreateIterableTResult.getType().getTypeName());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link TypeReferenceImpl.IterableMap}
   */
  @Test
  void testIterableMapNewIterableMap() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Iterable<? extends java.util.Map<java.lang.String, java.lang.Object>>",
        (new TypeReferenceImpl.IterableMap()).getType().getTypeName());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link TypeReferenceImpl.IterableObj}
   */
  @Test
  void testIterableObjNewIterableObj() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Iterable<?>", (new TypeReferenceImpl.IterableObj()).getType().getTypeName());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link TypeReferenceImpl.IterableObject}
   */
  @Test
  void testIterableObjectNewIterableObject() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Iterable<?>", (new TypeReferenceImpl.IterableObject()).getType().getTypeName());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link TypeReferenceImpl.IterableString}
   */
  @Test
  void testIterableStringNewIterableString() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Iterable<? extends java.lang.String>",
        (new TypeReferenceImpl.IterableString()).getType().getTypeName());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link TypeReferenceImpl.JobDetailIterable}
   */
  @Test
  void testJobDetailIterableNewJobDetailIterable() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Iterable<uk.gov.gchq.gaffer.jobtracker.JobDetail>",
        (new TypeReferenceImpl.JobDetailIterable()).getType().getTypeName());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link TypeReferenceImpl.List}
   */
  @Test
  void testListNewList() {
    // Arrange and Act
    TypeReferenceImpl.List<Object> actualList = new TypeReferenceImpl.List<>();

    // Assert
    assertEquals("java.util.List<T>", actualList.getType().getTypeName());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link TypeReferenceImpl.ListString}
   */
  @Test
  void testListStringNewListString() {
    // Arrange, Act and Assert
    assertEquals("java.util.List<java.lang.String>", (new TypeReferenceImpl.ListString()).getType().getTypeName());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link TypeReferenceImpl.MapExporter}
   */
  @Test
  void testMapExporterNewMapExporter() {
    // Arrange, Act and Assert
    assertEquals("java.util.LinkedHashMap<java.lang.String, uk.gov.gchq.gaffer.operation.export.Exporter>",
        (new TypeReferenceImpl.MapExporter()).getType().getTypeName());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link TypeReferenceImpl.MapStringObject}
   */
  @Test
  void testMapStringObjectNewMapStringObject() {
    // Arrange, Act and Assert
    assertEquals("java.util.Map<java.lang.String, java.lang.Object>",
        (new TypeReferenceImpl.MapStringObject()).getType().getTypeName());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link TypeReferenceImpl.MapStringSet}
   */
  @Test
  void testMapStringSetNewMapStringSet() {
    // Arrange, Act and Assert
    assertEquals("java.util.Map<java.lang.String, java.util.Set<java.lang.Object>>",
        (new TypeReferenceImpl.MapStringSet()).getType().getTypeName());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link TypeReferenceImpl.MapStringString}
   */
  @Test
  void testMapStringStringNewMapStringString() {
    // Arrange, Act and Assert
    assertEquals("java.util.Map<java.lang.String, java.lang.String>",
        (new TypeReferenceImpl.MapStringString()).getType().getTypeName());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link TypeReferenceImpl.Operations}
   */
  @Test
  void testOperationsNewOperations() {
    // Arrange, Act and Assert
    assertEquals("uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl$Set<java.lang.Class<uk.gov.gchq.gaffer"
        + ".operation.Operation>>", (new TypeReferenceImpl.Operations()).getType().getTypeName());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link TypeReferenceImpl.Set}
   */
  @Test
  void testSetNewSet() {
    // Arrange and Act
    TypeReferenceImpl.Set<Object> actualSet = new TypeReferenceImpl.Set<>();

    // Assert
    assertEquals("java.util.Set<T>", actualSet.getType().getTypeName());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link TypeReferenceImpl.Stream}
   */
  @Test
  void testStreamNewStream() {
    // Arrange and Act
    TypeReferenceImpl.Stream<Object> actualStream = new TypeReferenceImpl.Stream<>();

    // Assert
    assertEquals("java.util.stream.Stream<T>", actualStream.getType().getTypeName());
  }
}
