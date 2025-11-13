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

package uk.gov.gchq.gaffer.operation.impl.export.set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.impl.export.set.GetSetExport.Builder;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableObj;

class GetSetExportDiffblueTest {
  /**
   * Test Builder {@link Builder#end(Integer)}.
   * <p>
   * Method under test: {@link Builder#end(Integer)}
   */
  @Test
  @DisplayName("Test Builder end(Integer)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.end(Integer)"})
  void testBuilderEnd() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.end(3));
  }

  /**
   * Test Builder new {@link Builder} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder actualBuilder = new Builder();

    // Assert
    GetSetExport _getOpResult = actualBuilder._getOp();
    TypeReference<Iterable<?>> outputTypeReference = _getOpResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableObj);
    assertEquals("ALL", _getOpResult.getKeyOrDefault());
    Type outputType = _getOpResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertNull(_getOpResult.getEnd());
    assertNull(_getOpResult.getJobId());
    assertNull(_getOpResult.getKey());
    assertNull(_getOpResult.getOptions());
    assertEquals(0, _getOpResult.getStart());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, _getOpResult.getOutputClass());
    assertSame(_getOpResult, actualBuilder.build());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test Builder {@link Builder#start(int)}.
   * <p>
   * Method under test: {@link Builder#start(int)}
   */
  @Test
  @DisplayName("Test Builder start(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.start(int)"})
  void testBuilderStart() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.start(1));
  }

  /**
   * Test {@link GetSetExport#getOutputTypeReference()}.
   * <p>
   * Method under test: {@link GetSetExport#getOutputTypeReference()}
   */
  @Test
  @DisplayName("Test getOutputTypeReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TypeReference GetSetExport.getOutputTypeReference()"})
  void testGetOutputTypeReference() {
    // Arrange and Act
    TypeReference<Iterable<?>> actualOutputTypeReference = (new GetSetExport()).getOutputTypeReference();

    // Assert
    assertTrue(actualOutputTypeReference instanceof IterableObj);
    assertEquals("java.lang.Iterable<?>", actualOutputTypeReference.getType().getTypeName());
  }

  /**
   * Test {@link GetSetExport#shallowClone()}.
   * <ul>
   *   <li>Given {@link GetSetExport} (default constructor) Options is {@link HashMap#HashMap()}.</li>
   *   <li>Then return Options Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetSetExport#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given GetSetExport (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GetSetExport GetSetExport.shallowClone()"})
  void testShallowClone_givenGetSetExportOptionsIsHashMap_thenReturnOptionsEmpty() {
    // Arrange
    GetSetExport getSetExport = new GetSetExport();
    getSetExport.setOptions(new HashMap<>());

    // Act
    GetSetExport actualShallowCloneResult = getSetExport.shallowClone();

    // Assert
    TypeReference<Iterable<?>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableObj);
    assertEquals("ALL", actualShallowCloneResult.getKeyOrDefault());
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getEnd());
    assertNull(actualShallowCloneResult.getJobId());
    assertNull(actualShallowCloneResult.getKey());
    assertEquals(0, actualShallowCloneResult.getStart());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link GetSetExport#shallowClone()}.
   * <ul>
   *   <li>Given {@link GetSetExport} (default constructor).</li>
   *   <li>Then return Options is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetSetExport#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given GetSetExport (default constructor); then return Options is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GetSetExport GetSetExport.shallowClone()"})
  void testShallowClone_givenGetSetExport_thenReturnOptionsIsNull() {
    // Arrange and Act
    GetSetExport actualShallowCloneResult = (new GetSetExport()).shallowClone();

    // Assert
    TypeReference<Iterable<?>> outputTypeReference = actualShallowCloneResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableObj);
    assertEquals("ALL", actualShallowCloneResult.getKeyOrDefault());
    Type outputType = actualShallowCloneResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertNull(actualShallowCloneResult.getEnd());
    assertNull(actualShallowCloneResult.getJobId());
    assertNull(actualShallowCloneResult.getKey());
    assertNull(actualShallowCloneResult.getOptions());
    assertEquals(0, actualShallowCloneResult.getStart());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualShallowCloneResult.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GetSetExport}
   *   <li>{@link GetSetExport#setEnd(Integer)}
   *   <li>{@link GetSetExport#setJobId(String)}
   *   <li>{@link GetSetExport#setKey(String)}
   *   <li>{@link GetSetExport#setOptions(Map)}
   *   <li>{@link GetSetExport#setStart(int)}
   *   <li>{@link GetSetExport#getEnd()}
   *   <li>{@link GetSetExport#getJobId()}
   *   <li>{@link GetSetExport#getKey()}
   *   <li>{@link GetSetExport#getOptions()}
   *   <li>{@link GetSetExport#getStart()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GetSetExport.<init>()", "Integer GetSetExport.getEnd()", "String GetSetExport.getJobId()",
      "String GetSetExport.getKey()", "Map GetSetExport.getOptions()", "int GetSetExport.getStart()",
      "void GetSetExport.setEnd(Integer)", "void GetSetExport.setJobId(String)", "void GetSetExport.setKey(String)",
      "void GetSetExport.setOptions(Map)", "void GetSetExport.setStart(int)"})
  void testGettersAndSetters() {
    // Arrange and Act
    GetSetExport actualGetSetExport = new GetSetExport();
    actualGetSetExport.setEnd(3);
    actualGetSetExport.setJobId("42");
    actualGetSetExport.setKey("Key");
    HashMap<String, String> options = new HashMap<>();
    actualGetSetExport.setOptions(options);
    actualGetSetExport.setStart(1);
    Integer actualEnd = actualGetSetExport.getEnd();
    String actualJobId = actualGetSetExport.getJobId();
    String actualKey = actualGetSetExport.getKey();
    Map<String, String> actualOptions = actualGetSetExport.getOptions();

    // Assert
    assertEquals("42", actualJobId);
    assertEquals("Key", actualKey);
    assertEquals(1, actualGetSetExport.getStart());
    assertEquals(3, actualEnd.intValue());
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
