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
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.Array;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableEdge;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableElement;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableEntityId;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableEntitySeed;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableIterableEdge;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableListEdge;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableMap;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableObj;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableObject;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableString;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableWalk;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.JobDetailIterable;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.List;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.ListString;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.MapExporter;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.MapStringObject;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.MapStringSet;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.MapStringString;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.Operations;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.Set;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.Stream;

class TypeReferenceImplDiffblueTest {
  /**
   * Test Array new {@link Array} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Array}
   */
  @Test
  @DisplayName("Test Array new Array (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Array.<init>()"})
  void testArrayNewArray() {
    // Arrange and Act
    Array<Object> actualArray = new Array<>();

    // Assert
    assertEquals("T[]", actualArray.getType().getTypeName());
  }

  /**
   * Test {@link TypeReferenceImpl#createExplicitT()}.
   * <p>
   * Method under test: {@link TypeReferenceImpl#createExplicitT()}
   */
  @Test
  @DisplayName("Test createExplicitT()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeReference TypeReferenceImpl.createExplicitT()"})
  void testCreateExplicitT() {
    // Arrange and Act
    TypeReference<Object> actualCreateExplicitTResult = TypeReferenceImpl.createExplicitT();

    // Assert
    assertTrue(actualCreateExplicitTResult instanceof TypeReferenceImpl.Object);
  }

  /**
   * Test {@link TypeReferenceImpl#createIterableT()}.
   * <p>
   * Method under test: {@link TypeReferenceImpl#createIterableT()}
   */
  @Test
  @DisplayName("Test createIterableT()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeReference TypeReferenceImpl.createIterableT()"})
  void testCreateIterableT() {
    // Arrange and Act
    TypeReference<Iterable<?>> actualCreateIterableTResult = TypeReferenceImpl.createIterableT();

    // Assert
    assertTrue(actualCreateIterableTResult instanceof IterableObj);
    assertEquals("java.lang.Iterable<?>", actualCreateIterableTResult.getType().getTypeName());
  }

  /**
   * Test IterableEdge new {@link IterableEdge} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link IterableEdge}
   */
  @Test
  @DisplayName("Test IterableEdge new IterableEdge (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IterableEdge.<init>()"})
  void testIterableEdgeNewIterableEdge() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Iterable<uk.gov.gchq.gaffer.data.element.Edge>",
        (new IterableEdge()).getType().getTypeName());
  }

  /**
   * Test IterableElement new {@link IterableElement} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link IterableElement}
   */
  @Test
  @DisplayName("Test IterableElement new IterableElement (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IterableElement.<init>()"})
  void testIterableElementNewIterableElement() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>",
        (new IterableElement()).getType().getTypeName());
  }

  /**
   * Test IterableEntityId new {@link IterableEntityId} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link IterableEntityId}
   */
  @Test
  @DisplayName("Test IterableEntityId new IterableEntityId (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IterableEntityId.<init>()"})
  void testIterableEntityIdNewIterableEntityId() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.id.EntityId>",
        (new IterableEntityId()).getType().getTypeName());
  }

  /**
   * Test IterableEntitySeed new {@link IterableEntitySeed} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link IterableEntitySeed}
   */
  @Test
  @DisplayName("Test IterableEntitySeed new IterableEntitySeed (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IterableEntitySeed.<init>()"})
  void testIterableEntitySeedNewIterableEntitySeed() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Iterable<? extends uk.gov.gchq.gaffer.operation.data.EntitySeed>",
        (new IterableEntitySeed()).getType().getTypeName());
  }

  /**
   * Test IterableIterableEdge new {@link IterableIterableEdge} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link IterableIterableEdge}
   */
  @Test
  @DisplayName("Test IterableIterableEdge new IterableIterableEdge (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IterableIterableEdge.<init>()"})
  void testIterableIterableEdgeNewIterableIterableEdge() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Iterable<java.lang.Iterable<uk.gov.gchq.gaffer.data.element.Edge>>",
        (new IterableIterableEdge()).getType().getTypeName());
  }

  /**
   * Test IterableListEdge new {@link IterableListEdge} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link IterableListEdge}
   */
  @Test
  @DisplayName("Test IterableListEdge new IterableListEdge (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IterableListEdge.<init>()"})
  void testIterableListEdgeNewIterableListEdge() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Iterable<java.util.List<uk.gov.gchq.gaffer.data.element.Edge>>",
        (new IterableListEdge()).getType().getTypeName());
  }

  /**
   * Test IterableMap new {@link IterableMap} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link IterableMap}
   */
  @Test
  @DisplayName("Test IterableMap new IterableMap (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IterableMap.<init>()"})
  void testIterableMapNewIterableMap() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Iterable<? extends java.util.Map<java.lang.String, java.lang.Object>>",
        (new IterableMap()).getType().getTypeName());
  }

  /**
   * Test IterableObj new {@link IterableObj} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link IterableObj}
   */
  @Test
  @DisplayName("Test IterableObj new IterableObj (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IterableObj.<init>()"})
  void testIterableObjNewIterableObj() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Iterable<?>", (new IterableObj()).getType().getTypeName());
  }

  /**
   * Test IterableObject new {@link IterableObject} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link IterableObject}
   */
  @Test
  @DisplayName("Test IterableObject new IterableObject (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IterableObject.<init>()"})
  void testIterableObjectNewIterableObject() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Iterable<?>", (new IterableObject()).getType().getTypeName());
  }

  /**
   * Test IterableString new {@link IterableString} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link IterableString}
   */
  @Test
  @DisplayName("Test IterableString new IterableString (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IterableString.<init>()"})
  void testIterableStringNewIterableString() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Iterable<? extends java.lang.String>", (new IterableString()).getType().getTypeName());
  }

  /**
   * Test IterableWalk new {@link IterableWalk} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link IterableWalk}
   */
  @Test
  @DisplayName("Test IterableWalk new IterableWalk (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void IterableWalk.<init>()"})
  void testIterableWalkNewIterableWalk() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Iterable<uk.gov.gchq.gaffer.data.graph.Walk>",
        (new IterableWalk()).getType().getTypeName());
  }

  /**
   * Test JobDetailIterable new {@link JobDetailIterable} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link JobDetailIterable}
   */
  @Test
  @DisplayName("Test JobDetailIterable new JobDetailIterable (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JobDetailIterable.<init>()"})
  void testJobDetailIterableNewJobDetailIterable() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Iterable<uk.gov.gchq.gaffer.jobtracker.JobDetail>",
        (new JobDetailIterable()).getType().getTypeName());
  }

  /**
   * Test List new {@link List} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link List}
   */
  @Test
  @DisplayName("Test List new List (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void List.<init>()"})
  void testListNewList() {
    // Arrange and Act
    List<Object> actualList = new List<>();

    // Assert
    assertEquals("java.util.List<T>", actualList.getType().getTypeName());
  }

  /**
   * Test ListString new {@link ListString} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link ListString}
   */
  @Test
  @DisplayName("Test ListString new ListString (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ListString.<init>()"})
  void testListStringNewListString() {
    // Arrange, Act and Assert
    assertEquals("java.util.List<java.lang.String>", (new ListString()).getType().getTypeName());
  }

  /**
   * Test MapExporter new {@link MapExporter} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link MapExporter}
   */
  @Test
  @DisplayName("Test MapExporter new MapExporter (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MapExporter.<init>()"})
  void testMapExporterNewMapExporter() {
    // Arrange, Act and Assert
    assertEquals("java.util.LinkedHashMap<java.lang.String, uk.gov.gchq.gaffer.operation.export.Exporter>",
        (new MapExporter()).getType().getTypeName());
  }

  /**
   * Test MapStringObject new {@link MapStringObject} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link MapStringObject}
   */
  @Test
  @DisplayName("Test MapStringObject new MapStringObject (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MapStringObject.<init>()"})
  void testMapStringObjectNewMapStringObject() {
    // Arrange, Act and Assert
    assertEquals("java.util.Map<java.lang.String, java.lang.Object>", (new MapStringObject()).getType().getTypeName());
  }

  /**
   * Test MapStringSet new {@link MapStringSet} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link MapStringSet}
   */
  @Test
  @DisplayName("Test MapStringSet new MapStringSet (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MapStringSet.<init>()"})
  void testMapStringSetNewMapStringSet() {
    // Arrange, Act and Assert
    assertEquals("java.util.Map<java.lang.String, java.util.Set<java.lang.Object>>",
        (new MapStringSet()).getType().getTypeName());
  }

  /**
   * Test MapStringString new {@link MapStringString} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link MapStringString}
   */
  @Test
  @DisplayName("Test MapStringString new MapStringString (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MapStringString.<init>()"})
  void testMapStringStringNewMapStringString() {
    // Arrange, Act and Assert
    assertEquals("java.util.Map<java.lang.String, java.lang.String>", (new MapStringString()).getType().getTypeName());
  }

  /**
   * Test Operations new {@link Operations} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Operations}
   */
  @Test
  @DisplayName("Test Operations new Operations (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Operations.<init>()"})
  void testOperationsNewOperations() {
    // Arrange, Act and Assert
    assertEquals("uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl$Set<java.lang.Class<uk.gov.gchq.gaffer"
        + ".operation.Operation>>", (new Operations()).getType().getTypeName());
  }

  /**
   * Test Set new {@link Set} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Set}
   */
  @Test
  @DisplayName("Test Set new Set (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Set.<init>()"})
  void testSetNewSet() {
    // Arrange and Act
    Set<Object> actualSet = new Set<>();

    // Assert
    assertEquals("java.util.Set<T>", actualSet.getType().getTypeName());
  }

  /**
   * Test Stream new {@link Stream} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Stream}
   */
  @Test
  @DisplayName("Test Stream new Stream (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Stream.<init>()"})
  void testStreamNewStream() {
    // Arrange and Act
    Stream<Object> actualStream = new Stream<>();

    // Assert
    assertEquals("java.util.stream.Stream<T>", actualStream.getType().getTypeName());
  }
}
