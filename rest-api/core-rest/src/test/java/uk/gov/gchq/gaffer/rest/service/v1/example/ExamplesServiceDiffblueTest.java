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

package uk.gov.gchq.gaffer.rest.service.v1.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.IdentifierType;
import uk.gov.gchq.gaffer.data.element.Properties;
import uk.gov.gchq.gaffer.mapstore.operation.CountAllElementsDefaultView;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.impl.Limit;
import uk.gov.gchq.gaffer.operation.impl.get.GetAllElements;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableElement;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl.IterableObj;
import uk.gov.gchq.gaffer.store.schema.SchemaEdgeDefinition;
import uk.gov.gchq.gaffer.store.schema.SchemaElementDefinition;

@ExtendWith(MockitoExtension.class)
class ExamplesServiceDiffblueTest {
  @InjectMocks
  private ExamplesService examplesService;

  /**
   * Test {@link ExamplesService#execute()}.
   * <p>
   * Method under test: {@link ExamplesService#execute()}
   */
  @Test
  @DisplayName("Test execute()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OperationChain ExamplesService.execute()"})
  void testExecute() {
    // Arrange and Act
    OperationChain actualExecuteResult = examplesService.execute();

    // Assert
    List<Operation> operations = actualExecuteResult.getOperations();
    assertEquals(2, operations.size());
    assertTrue(operations.get(1) instanceof Limit);
    assertTrue(operations.get(0) instanceof GetAllElements);
    TypeReference outputTypeReference = actualExecuteResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableObj);
    Type outputType = actualExecuteResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertTrue(actualExecuteResult.getOptions().isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualExecuteResult.getOutputClass());
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, actualExecuteResult.getOperationsClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link ExamplesService#executeOperation()}.
   * <p>
   * Method under test: {@link ExamplesService#executeOperation()}
   */
  @Test
  @DisplayName("Test executeOperation()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Operation ExamplesService.executeOperation()"})
  void testExecuteOperation() {
    // Arrange and Act
    Operation actualExecuteOperationResult = examplesService.executeOperation();

    // Assert
    assertTrue(actualExecuteOperationResult instanceof GetAllElements);
    TypeReference<Iterable<? extends Element>> outputTypeReference = ((GetAllElements) actualExecuteOperationResult)
        .getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableElement);
    Type outputType = ((GetAllElements) actualExecuteOperationResult).getOutputType();
    assertEquals("java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>", outputType.getTypeName());
    assertNull(actualExecuteOperationResult.getOptions());
    assertNull(((GetAllElements) actualExecuteOperationResult).getDirectedType());
    assertNull(((GetAllElements) actualExecuteOperationResult).getView());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, ((GetAllElements) actualExecuteOperationResult).getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link ExamplesService#executeChunked()}.
   * <p>
   * Method under test: {@link ExamplesService#executeChunked()}
   */
  @Test
  @DisplayName("Test executeChunked()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OperationChain ExamplesService.executeChunked()"})
  void testExecuteChunked() {
    // Arrange and Act
    OperationChain actualExecuteChunkedResult = examplesService.executeChunked();

    // Assert
    List<Operation> operations = actualExecuteChunkedResult.getOperations();
    assertEquals(2, operations.size());
    assertTrue(operations.get(1) instanceof Limit);
    assertTrue(operations.get(0) instanceof GetAllElements);
    TypeReference outputTypeReference = actualExecuteChunkedResult.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableObj);
    Type outputType = actualExecuteChunkedResult.getOutputType();
    assertEquals("java.lang.Iterable<?>", outputType.getTypeName());
    assertTrue(actualExecuteChunkedResult.getOptions().isEmpty());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualExecuteChunkedResult.getOutputClass());
    Class<Operation> expectedOperationsClass = Operation.class;
    assertEquals(expectedOperationsClass, actualExecuteChunkedResult.getOperationsClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link ExamplesService#executeChunkedOperation()}.
   * <p>
   * Method under test: {@link ExamplesService#executeChunkedOperation()}
   */
  @Test
  @DisplayName("Test executeChunkedOperation()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Operation ExamplesService.executeChunkedOperation()"})
  void testExecuteChunkedOperation() {
    // Arrange and Act
    Operation actualExecuteChunkedOperationResult = examplesService.executeChunkedOperation();

    // Assert
    assertTrue(actualExecuteChunkedOperationResult instanceof GetAllElements);
    TypeReference<Iterable<? extends Element>> outputTypeReference = ((GetAllElements) actualExecuteChunkedOperationResult)
        .getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableElement);
    Type outputType = ((GetAllElements) actualExecuteChunkedOperationResult).getOutputType();
    assertEquals("java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>", outputType.getTypeName());
    assertNull(actualExecuteChunkedOperationResult.getOptions());
    assertNull(((GetAllElements) actualExecuteChunkedOperationResult).getDirectedType());
    assertNull(((GetAllElements) actualExecuteChunkedOperationResult).getView());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, ((GetAllElements) actualExecuteChunkedOperationResult).getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link ExamplesService#getAllElements()}.
   * <p>
   * Method under test: {@link ExamplesService#getAllElements()}
   */
  @Test
  @DisplayName("Test getAllElements()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"GetAllElements ExamplesService.getAllElements()"})
  void testGetAllElements() {
    // Arrange and Act
    GetAllElements actualAllElements = examplesService.getAllElements();

    // Assert
    TypeReference<Iterable<? extends Element>> outputTypeReference = actualAllElements.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableElement);
    Type outputType = actualAllElements.getOutputType();
    assertEquals("java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>", outputType.getTypeName());
    assertNull(actualAllElements.getOptions());
    assertNull(actualAllElements.getDirectedType());
    assertNull(actualAllElements.getView());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, actualAllElements.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }

  /**
   * Test {@link ExamplesService#populateProperties(Element, SchemaElementDefinition, int)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then {@link Edge#Edge(String)} with {@code Group} Properties Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExamplesService#populateProperties(Element, SchemaElementDefinition, int)}
   */
  @Test
  @DisplayName("Test populateProperties(Element, SchemaElementDefinition, int); given HashSet(); then Edge(String) with 'Group' Properties Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ExamplesService.populateProperties(Element, SchemaElementDefinition, int)"})
  void testPopulateProperties_givenHashSet_thenEdgeWithGroupPropertiesEmpty() {
    // Arrange
    Edge element = new Edge("Group");
    SchemaEdgeDefinition elementDef = mock(SchemaEdgeDefinition.class);
    when(elementDef.getProperties()).thenReturn(new HashSet<>());

    // Act
    examplesService.populateProperties(element, elementDef, 1);

    // Assert that nothing has changed
    verify(elementDef).getProperties();
    assertTrue(element.getProperties().isEmpty());
  }

  /**
   * Test {@link ExamplesService#populateProperties(Element, SchemaElementDefinition, int)}.
   * <ul>
   *   <li>Given {@code Double}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExamplesService#populateProperties(Element, SchemaElementDefinition, int)}
   */
  @Test
  @DisplayName("Test populateProperties(Element, SchemaElementDefinition, int); given 'java.lang.Double'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ExamplesService.populateProperties(Element, SchemaElementDefinition, int)"})
  void testPopulateProperties_givenJavaLangDouble() {
    // Arrange
    Element element = mock(Element.class);
    doNothing().when(element).putProperty(Mockito.<String>any(), Mockito.<Object>any());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");
    SchemaEdgeDefinition elementDef = mock(SchemaEdgeDefinition.class);
    Class<Double> forNameResult = Double.class;
    Mockito.<Class<?>>when(elementDef.getPropertyClass(Mockito.<String>any())).thenReturn(forNameResult);
    when(elementDef.getProperties()).thenReturn(stringSet);

    // Act
    examplesService.populateProperties(element, elementDef, 1);

    // Assert
    verify(element).putProperty(eq("foo"), isA(Object.class));
    verify(elementDef).getProperties();
    verify(elementDef).getPropertyClass(eq("foo"));
  }

  /**
   * Test {@link ExamplesService#populateProperties(Element, SchemaElementDefinition, int)}.
   * <ul>
   *   <li>Given {@code Float}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExamplesService#populateProperties(Element, SchemaElementDefinition, int)}
   */
  @Test
  @DisplayName("Test populateProperties(Element, SchemaElementDefinition, int); given 'java.lang.Float'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ExamplesService.populateProperties(Element, SchemaElementDefinition, int)"})
  void testPopulateProperties_givenJavaLangFloat() {
    // Arrange
    Element element = mock(Element.class);
    doNothing().when(element).putProperty(Mockito.<String>any(), Mockito.<Object>any());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");
    SchemaEdgeDefinition elementDef = mock(SchemaEdgeDefinition.class);
    Class<Float> forNameResult = Float.class;
    Mockito.<Class<?>>when(elementDef.getPropertyClass(Mockito.<String>any())).thenReturn(forNameResult);
    when(elementDef.getProperties()).thenReturn(stringSet);

    // Act
    examplesService.populateProperties(element, elementDef, 1);

    // Assert
    verify(element).putProperty(eq("foo"), isA(Object.class));
    verify(elementDef).getProperties();
    verify(elementDef).getPropertyClass(eq("foo"));
  }

  /**
   * Test {@link ExamplesService#populateProperties(Element, SchemaElementDefinition, int)}.
   * <ul>
   *   <li>Given {@code Integer}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExamplesService#populateProperties(Element, SchemaElementDefinition, int)}
   */
  @Test
  @DisplayName("Test populateProperties(Element, SchemaElementDefinition, int); given 'java.lang.Integer'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ExamplesService.populateProperties(Element, SchemaElementDefinition, int)"})
  void testPopulateProperties_givenJavaLangInteger() {
    // Arrange
    Element element = mock(Element.class);
    doNothing().when(element).putProperty(Mockito.<String>any(), Mockito.<Object>any());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");
    SchemaEdgeDefinition elementDef = mock(SchemaEdgeDefinition.class);
    Class<Integer> forNameResult = Integer.class;
    Mockito.<Class<?>>when(elementDef.getPropertyClass(Mockito.<String>any())).thenReturn(forNameResult);
    when(elementDef.getProperties()).thenReturn(stringSet);

    // Act
    examplesService.populateProperties(element, elementDef, 1);

    // Assert
    verify(element).putProperty(eq("foo"), isA(Object.class));
    verify(elementDef).getProperties();
    verify(elementDef).getPropertyClass(eq("foo"));
  }

  /**
   * Test {@link ExamplesService#populateProperties(Element, SchemaElementDefinition, int)}.
   * <ul>
   *   <li>Given {@code Long}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExamplesService#populateProperties(Element, SchemaElementDefinition, int)}
   */
  @Test
  @DisplayName("Test populateProperties(Element, SchemaElementDefinition, int); given 'java.lang.Long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ExamplesService.populateProperties(Element, SchemaElementDefinition, int)"})
  void testPopulateProperties_givenJavaLangLong() {
    // Arrange
    Element element = mock(Element.class);
    doNothing().when(element).putProperty(Mockito.<String>any(), Mockito.<Object>any());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");
    SchemaEdgeDefinition elementDef = mock(SchemaEdgeDefinition.class);
    Class<Long> forNameResult = Long.class;
    Mockito.<Class<?>>when(elementDef.getPropertyClass(Mockito.<String>any())).thenReturn(forNameResult);
    when(elementDef.getProperties()).thenReturn(stringSet);

    // Act
    examplesService.populateProperties(element, elementDef, 1);

    // Assert
    verify(element).putProperty(eq("foo"), isA(Object.class));
    verify(elementDef).getProperties();
    verify(elementDef).getPropertyClass(eq("foo"));
  }

  /**
   * Test {@link ExamplesService#populateProperties(Element, SchemaElementDefinition, int)}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExamplesService#populateProperties(Element, SchemaElementDefinition, int)}
   */
  @Test
  @DisplayName("Test populateProperties(Element, SchemaElementDefinition, int); given 'java.lang.Object'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ExamplesService.populateProperties(Element, SchemaElementDefinition, int)"})
  void testPopulateProperties_givenJavaLangObject() {
    // Arrange
    Element element = mock(Element.class);
    doNothing().when(element).putProperty(Mockito.<String>any(), Mockito.<Object>any());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");
    SchemaEdgeDefinition elementDef = mock(SchemaEdgeDefinition.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(elementDef.getPropertyClass(Mockito.<String>any())).thenReturn(forNameResult);
    when(elementDef.getProperties()).thenReturn(stringSet);

    // Act
    examplesService.populateProperties(element, elementDef, 1);

    // Assert
    verify(element).putProperty(eq("foo"), isA(Object.class));
    verify(elementDef).getProperties();
    verify(elementDef).getPropertyClass(eq("foo"));
  }

  /**
   * Test {@link ExamplesService#populateProperties(Element, SchemaElementDefinition, int)}.
   * <ul>
   *   <li>Given {@code Object}.</li>
   *   <li>Then {@link Edge#Edge(String)} with {@code Group} Properties size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExamplesService#populateProperties(Element, SchemaElementDefinition, int)}
   */
  @Test
  @DisplayName("Test populateProperties(Element, SchemaElementDefinition, int); given 'java.lang.Object'; then Edge(String) with 'Group' Properties size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ExamplesService.populateProperties(Element, SchemaElementDefinition, int)"})
  void testPopulateProperties_givenJavaLangObject_thenEdgeWithGroupPropertiesSizeIsOne() {
    // Arrange
    Edge element = new Edge("Group");

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");
    SchemaEdgeDefinition elementDef = mock(SchemaEdgeDefinition.class);
    Class<Object> forNameResult = Object.class;
    Mockito.<Class<?>>when(elementDef.getPropertyClass(Mockito.<String>any())).thenReturn(forNameResult);
    when(elementDef.getProperties()).thenReturn(stringSet);

    // Act
    examplesService.populateProperties(element, elementDef, 1);

    // Assert
    verify(elementDef).getProperties();
    verify(elementDef).getPropertyClass(eq("foo"));
    Properties properties = element.getProperties();
    assertEquals(1, properties.size());
    assertEquals("1", properties.get("foo"));
  }

  /**
   * Test {@link ExamplesService#populateProperties(Element, SchemaElementDefinition, int)}.
   * <ul>
   *   <li>Given {@code String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExamplesService#populateProperties(Element, SchemaElementDefinition, int)}
   */
  @Test
  @DisplayName("Test populateProperties(Element, SchemaElementDefinition, int); given 'java.lang.String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ExamplesService.populateProperties(Element, SchemaElementDefinition, int)"})
  void testPopulateProperties_givenJavaLangString() {
    // Arrange
    Element element = mock(Element.class);
    doNothing().when(element).putProperty(Mockito.<String>any(), Mockito.<Object>any());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");
    SchemaEdgeDefinition elementDef = mock(SchemaEdgeDefinition.class);
    Class<String> forNameResult = String.class;
    Mockito.<Class<?>>when(elementDef.getPropertyClass(Mockito.<String>any())).thenReturn(forNameResult);
    when(elementDef.getProperties()).thenReturn(stringSet);

    // Act
    examplesService.populateProperties(element, elementDef, 1);

    // Assert
    verify(element).putProperty(eq("foo"), isA(Object.class));
    verify(elementDef).getProperties();
    verify(elementDef).getPropertyClass(eq("foo"));
  }

  /**
   * Test {@link ExamplesService#populateProperties(Element, SchemaElementDefinition, int)}.
   * <ul>
   *   <li>Given {@code Date}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExamplesService#populateProperties(Element, SchemaElementDefinition, int)}
   */
  @Test
  @DisplayName("Test populateProperties(Element, SchemaElementDefinition, int); given 'java.util.Date'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ExamplesService.populateProperties(Element, SchemaElementDefinition, int)"})
  void testPopulateProperties_givenJavaUtilDate() {
    // Arrange
    Element element = mock(Element.class);
    doNothing().when(element).putProperty(Mockito.<String>any(), Mockito.<Object>any());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");
    SchemaEdgeDefinition elementDef = mock(SchemaEdgeDefinition.class);
    Class<Date> forNameResult = Date.class;
    Mockito.<Class<?>>when(elementDef.getPropertyClass(Mockito.<String>any())).thenReturn(forNameResult);
    when(elementDef.getProperties()).thenReturn(stringSet);

    // Act
    examplesService.populateProperties(element, elementDef, 1);

    // Assert
    verify(element).putProperty(eq("foo"), isA(Object.class));
    verify(elementDef).getProperties();
    verify(elementDef).getPropertyClass(eq("foo"));
  }

  /**
   * Test {@link ExamplesService#populateProperties(Element, SchemaElementDefinition, int)}.
   * <ul>
   *   <li>Given {@code Map$Entry}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExamplesService#populateProperties(Element, SchemaElementDefinition, int)}
   */
  @Test
  @DisplayName("Test populateProperties(Element, SchemaElementDefinition, int); given 'java.util.Map$Entry'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ExamplesService.populateProperties(Element, SchemaElementDefinition, int)"})
  void testPopulateProperties_givenJavaUtilMapEntry() {
    // Arrange
    Element element = mock(Element.class);
    doNothing().when(element).putProperty(Mockito.<String>any(), Mockito.<Object>any());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");
    SchemaEdgeDefinition elementDef = mock(SchemaEdgeDefinition.class);
    Class<Entry> forNameResult = Entry.class;
    Mockito.<Class<?>>when(elementDef.getPropertyClass(Mockito.<String>any())).thenReturn(forNameResult);
    when(elementDef.getProperties()).thenReturn(stringSet);

    // Act
    examplesService.populateProperties(element, elementDef, 1);

    // Assert
    verify(element).putProperty(eq("foo"), isNull());
    verify(elementDef).getProperties();
    verify(elementDef).getPropertyClass(eq("foo"));
  }

  /**
   * Test {@link ExamplesService#populateProperties(Element, SchemaElementDefinition, int)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExamplesService#populateProperties(Element, SchemaElementDefinition, int)}
   */
  @Test
  @DisplayName("Test populateProperties(Element, SchemaElementDefinition, int); given 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ExamplesService.populateProperties(Element, SchemaElementDefinition, int)"})
  void testPopulateProperties_givenNull() {
    // Arrange
    Element element = mock(Element.class);
    doNothing().when(element).putProperty(Mockito.<String>any(), Mockito.<Object>any());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");
    SchemaEdgeDefinition elementDef = mock(SchemaEdgeDefinition.class);
    Mockito.<Class<?>>when(elementDef.getPropertyClass(Mockito.<String>any())).thenReturn(null);
    when(elementDef.getProperties()).thenReturn(stringSet);

    // Act
    examplesService.populateProperties(element, elementDef, 1);

    // Assert
    verify(element).putProperty(eq("foo"), isNull());
    verify(elementDef).getProperties();
    verify(elementDef).getPropertyClass(eq("foo"));
  }

  /**
   * Test {@link ExamplesService#populateProperties(Element, SchemaElementDefinition, int)}.
   * <ul>
   *   <li>Given {@code SchemaEdgeDefinition}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExamplesService#populateProperties(Element, SchemaElementDefinition, int)}
   */
  @Test
  @DisplayName("Test populateProperties(Element, SchemaElementDefinition, int); given 'uk.gov.gchq.gaffer.store.schema.SchemaEdgeDefinition'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ExamplesService.populateProperties(Element, SchemaElementDefinition, int)"})
  void testPopulateProperties_givenUkGovGchqGafferStoreSchemaSchemaEdgeDefinition() {
    // Arrange
    Element element = mock(Element.class);
    doNothing().when(element).putProperty(Mockito.<String>any(), Mockito.<Object>any());

    HashSet<String> stringSet = new HashSet<>();
    stringSet.add("foo");
    SchemaEdgeDefinition elementDef = mock(SchemaEdgeDefinition.class);
    Class<SchemaEdgeDefinition> forNameResult = SchemaEdgeDefinition.class;
    Mockito.<Class<?>>when(elementDef.getPropertyClass(Mockito.<String>any())).thenReturn(forNameResult);
    when(elementDef.getProperties()).thenReturn(stringSet);

    // Act
    examplesService.populateProperties(element, elementDef, 1);

    // Assert
    verify(element).putProperty(eq("foo"), isA(Object.class));
    verify(elementDef).getProperties();
    verify(elementDef).getPropertyClass(eq("foo"));
  }

  /**
   * Test {@link ExamplesService#populateProperties(Element, SchemaElementDefinition, int)}.
   * <ul>
   *   <li>When {@link SchemaEdgeDefinition} (default constructor).</li>
   *   <li>Then {@link Edge#Edge(String)} with {@code Group} Properties Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExamplesService#populateProperties(Element, SchemaElementDefinition, int)}
   */
  @Test
  @DisplayName("Test populateProperties(Element, SchemaElementDefinition, int); when SchemaEdgeDefinition (default constructor); then Edge(String) with 'Group' Properties Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ExamplesService.populateProperties(Element, SchemaElementDefinition, int)"})
  void testPopulateProperties_whenSchemaEdgeDefinition_thenEdgeWithGroupPropertiesEmpty() {
    // Arrange
    Edge element = new Edge("Group");

    // Act
    examplesService.populateProperties(element, new SchemaEdgeDefinition(), 1);

    // Assert that nothing has changed
    assertTrue(element.getProperties().isEmpty());
  }

  /**
   * Test {@link ExamplesService#getExampleVertex(Class, int)}.
   * <ul>
   *   <li>Then Identifiers return {@link Set}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExamplesService#getExampleVertex(Class, int)}
   */
  @Test
  @DisplayName("Test getExampleVertex(Class, int); then Identifiers return Set")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ExamplesService.getExampleVertex(Class, int)"})
  void testGetExampleVertex_thenIdentifiersReturnSet() {
    // Arrange
    Class<SchemaEdgeDefinition> clazz = SchemaEdgeDefinition.class;

    // Act
    Object actualExampleVertex = examplesService.getExampleVertex(clazz, 1);

    // Assert
    Collection<IdentifierType> identifiers = ((SchemaEdgeDefinition) actualExampleVertex).getIdentifiers();
    assertTrue(identifiers instanceof Set);
    assertTrue(actualExampleVertex instanceof SchemaEdgeDefinition);
    assertNull(((SchemaEdgeDefinition) actualExampleVertex).getOriginalValidateFunctions());
    assertNull(((SchemaEdgeDefinition) actualExampleVertex).getDestination());
    assertNull(((SchemaEdgeDefinition) actualExampleVertex).getDirected());
    assertNull(((SchemaEdgeDefinition) actualExampleVertex).getSource());
    assertNull(((SchemaEdgeDefinition) actualExampleVertex).getDescription());
    assertNull(((SchemaEdgeDefinition) actualExampleVertex).getOriginalAggregateFunctions());
    assertNull(((SchemaEdgeDefinition) actualExampleVertex).getOriginalAggregator());
    assertNull(((SchemaEdgeDefinition) actualExampleVertex).getOriginalValidator());
    assertTrue(((SchemaEdgeDefinition) actualExampleVertex).getIdentifierTypeNames().isEmpty());
    assertTrue(identifiers.isEmpty());
    assertTrue(((SchemaEdgeDefinition) actualExampleVertex).getPropertyTypeNames().isEmpty());
    assertTrue(((SchemaEdgeDefinition) actualExampleVertex).getIdentifierMap().isEmpty());
    assertTrue(((SchemaEdgeDefinition) actualExampleVertex).getPropertyMap().isEmpty());
    assertTrue(((SchemaEdgeDefinition) actualExampleVertex).getGroupBy().isEmpty());
    assertTrue(((SchemaEdgeDefinition) actualExampleVertex).getProperties().isEmpty());
    assertTrue(((SchemaEdgeDefinition) actualExampleVertex).isAggregate());
    assertSame(actualExampleVertex, ((SchemaEdgeDefinition) actualExampleVertex).getExpandedDefinition());
  }

  /**
   * Test {@link ExamplesService#getExampleVertex(Class, int)}.
   * <ul>
   *   <li>When {@code Double}.</li>
   *   <li>Then return doubleValue is {@code 1.1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExamplesService#getExampleVertex(Class, int)}
   */
  @Test
  @DisplayName("Test getExampleVertex(Class, int); when 'java.lang.Double'; then return doubleValue is '1.1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ExamplesService.getExampleVertex(Class, int)"})
  void testGetExampleVertex_whenJavaLangDouble_thenReturnDoubleValueIs11() {
    // Arrange
    Class<Double> clazz = Double.class;

    // Act and Assert
    assertEquals(1.1d, ((Double) examplesService.getExampleVertex(clazz, 1)).doubleValue());
  }

  /**
   * Test {@link ExamplesService#getExampleVertex(Class, int)}.
   * <ul>
   *   <li>When {@code Float}.</li>
   *   <li>Then return floatValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExamplesService#getExampleVertex(Class, int)}
   */
  @Test
  @DisplayName("Test getExampleVertex(Class, int); when 'java.lang.Float'; then return floatValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ExamplesService.getExampleVertex(Class, int)"})
  void testGetExampleVertex_whenJavaLangFloat_thenReturnFloatValueIsOne() {
    // Arrange
    Class<Float> clazz = Float.class;

    // Act and Assert
    assertEquals(1.0f, ((Float) examplesService.getExampleVertex(clazz, 1)).floatValue());
  }

  /**
   * Test {@link ExamplesService#getExampleVertex(Class, int)}.
   * <ul>
   *   <li>When {@code Integer}.</li>
   *   <li>Then return intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExamplesService#getExampleVertex(Class, int)}
   */
  @Test
  @DisplayName("Test getExampleVertex(Class, int); when 'java.lang.Integer'; then return intValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ExamplesService.getExampleVertex(Class, int)"})
  void testGetExampleVertex_whenJavaLangInteger_thenReturnIntValueIsOne() {
    // Arrange
    Class<Integer> clazz = Integer.class;

    // Act and Assert
    assertEquals(1, ((Integer) examplesService.getExampleVertex(clazz, 1)).intValue());
  }

  /**
   * Test {@link ExamplesService#getExampleVertex(Class, int)}.
   * <ul>
   *   <li>When {@code Long}.</li>
   *   <li>Then return longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExamplesService#getExampleVertex(Class, int)}
   */
  @Test
  @DisplayName("Test getExampleVertex(Class, int); when 'java.lang.Long'; then return longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ExamplesService.getExampleVertex(Class, int)"})
  void testGetExampleVertex_whenJavaLangLong_thenReturnLongValueIsOne() {
    // Arrange
    Class<Long> clazz = Long.class;

    // Act and Assert
    assertEquals(1L, ((Long) examplesService.getExampleVertex(clazz, 1)).longValue());
  }

  /**
   * Test {@link ExamplesService#getExampleVertex(Class, int)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code vertex1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExamplesService#getExampleVertex(Class, int)}
   */
  @Test
  @DisplayName("Test getExampleVertex(Class, int); when 'java.lang.Object'; then return 'vertex1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ExamplesService.getExampleVertex(Class, int)"})
  void testGetExampleVertex_whenJavaLangObject_thenReturnVertex1() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals("vertex1", examplesService.getExampleVertex(clazz, 1));
  }

  /**
   * Test {@link ExamplesService#getExampleVertex(Class, int)}.
   * <ul>
   *   <li>When {@code String}.</li>
   *   <li>Then return {@code vertex1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExamplesService#getExampleVertex(Class, int)}
   */
  @Test
  @DisplayName("Test getExampleVertex(Class, int); when 'java.lang.String'; then return 'vertex1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ExamplesService.getExampleVertex(Class, int)"})
  void testGetExampleVertex_whenJavaLangString_thenReturnVertex1() {
    // Arrange
    Class<String> clazz = String.class;

    // Act and Assert
    assertEquals("vertex1", examplesService.getExampleVertex(clazz, 1));
  }

  /**
   * Test {@link ExamplesService#getExampleVertex(Class, int)}.
   * <ul>
   *   <li>When {@code Map$Entry}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExamplesService#getExampleVertex(Class, int)}
   */
  @Test
  @DisplayName("Test getExampleVertex(Class, int); when 'java.util.Map$Entry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ExamplesService.getExampleVertex(Class, int)"})
  void testGetExampleVertex_whenJavaUtilMapEntry_thenReturnNull() {
    // Arrange
    Class<Entry> clazz = Entry.class;

    // Act and Assert
    assertNull(examplesService.getExampleVertex(clazz, 1));
  }

  /**
   * Test {@link ExamplesService#getExampleVertex(Class, int)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExamplesService#getExampleVertex(Class, int)}
   */
  @Test
  @DisplayName("Test getExampleVertex(Class, int); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ExamplesService.getExampleVertex(Class, int)"})
  void testGetExampleVertex_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(examplesService.getExampleVertex(null, 1));
  }

  /**
   * Test {@link ExamplesService#getExampleValue(Class, int)}.
   * <ul>
   *   <li>Then Identifiers return {@link Set}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExamplesService#getExampleValue(Class, int)}
   */
  @Test
  @DisplayName("Test getExampleValue(Class, int); then Identifiers return Set")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ExamplesService.getExampleValue(Class, int)"})
  void testGetExampleValue_thenIdentifiersReturnSet() {
    // Arrange
    Class<SchemaEdgeDefinition> clazz = SchemaEdgeDefinition.class;

    // Act
    Object actualExampleValue = examplesService.getExampleValue(clazz, 1);

    // Assert
    Collection<IdentifierType> identifiers = ((SchemaEdgeDefinition) actualExampleValue).getIdentifiers();
    assertTrue(identifiers instanceof Set);
    assertTrue(actualExampleValue instanceof SchemaEdgeDefinition);
    assertNull(((SchemaEdgeDefinition) actualExampleValue).getOriginalValidateFunctions());
    assertNull(((SchemaEdgeDefinition) actualExampleValue).getDestination());
    assertNull(((SchemaEdgeDefinition) actualExampleValue).getDirected());
    assertNull(((SchemaEdgeDefinition) actualExampleValue).getSource());
    assertNull(((SchemaEdgeDefinition) actualExampleValue).getDescription());
    assertNull(((SchemaEdgeDefinition) actualExampleValue).getOriginalAggregateFunctions());
    assertNull(((SchemaEdgeDefinition) actualExampleValue).getOriginalAggregator());
    assertNull(((SchemaEdgeDefinition) actualExampleValue).getOriginalValidator());
    assertTrue(((SchemaEdgeDefinition) actualExampleValue).getIdentifierTypeNames().isEmpty());
    assertTrue(identifiers.isEmpty());
    assertTrue(((SchemaEdgeDefinition) actualExampleValue).getPropertyTypeNames().isEmpty());
    assertTrue(((SchemaEdgeDefinition) actualExampleValue).getIdentifierMap().isEmpty());
    assertTrue(((SchemaEdgeDefinition) actualExampleValue).getPropertyMap().isEmpty());
    assertTrue(((SchemaEdgeDefinition) actualExampleValue).getGroupBy().isEmpty());
    assertTrue(((SchemaEdgeDefinition) actualExampleValue).getProperties().isEmpty());
    assertTrue(((SchemaEdgeDefinition) actualExampleValue).isAggregate());
    assertSame(actualExampleValue, ((SchemaEdgeDefinition) actualExampleValue).getExpandedDefinition());
  }

  /**
   * Test {@link ExamplesService#getExampleValue(Class, int)}.
   * <ul>
   *   <li>When {@code Double}.</li>
   *   <li>Then return doubleValue is {@code 1.1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExamplesService#getExampleValue(Class, int)}
   */
  @Test
  @DisplayName("Test getExampleValue(Class, int); when 'java.lang.Double'; then return doubleValue is '1.1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ExamplesService.getExampleValue(Class, int)"})
  void testGetExampleValue_whenJavaLangDouble_thenReturnDoubleValueIs11() {
    // Arrange
    Class<Double> clazz = Double.class;

    // Act and Assert
    assertEquals(1.1d, ((Double) examplesService.getExampleValue(clazz, 1)).doubleValue());
  }

  /**
   * Test {@link ExamplesService#getExampleValue(Class, int)}.
   * <ul>
   *   <li>When {@code Float}.</li>
   *   <li>Then return floatValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExamplesService#getExampleValue(Class, int)}
   */
  @Test
  @DisplayName("Test getExampleValue(Class, int); when 'java.lang.Float'; then return floatValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ExamplesService.getExampleValue(Class, int)"})
  void testGetExampleValue_whenJavaLangFloat_thenReturnFloatValueIsOne() {
    // Arrange
    Class<Float> clazz = Float.class;

    // Act and Assert
    assertEquals(1.0f, ((Float) examplesService.getExampleValue(clazz, 1)).floatValue());
  }

  /**
   * Test {@link ExamplesService#getExampleValue(Class, int)}.
   * <ul>
   *   <li>When {@code Integer}.</li>
   *   <li>Then return intValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExamplesService#getExampleValue(Class, int)}
   */
  @Test
  @DisplayName("Test getExampleValue(Class, int); when 'java.lang.Integer'; then return intValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ExamplesService.getExampleValue(Class, int)"})
  void testGetExampleValue_whenJavaLangInteger_thenReturnIntValueIsOne() {
    // Arrange
    Class<Integer> clazz = Integer.class;

    // Act and Assert
    assertEquals(1, ((Integer) examplesService.getExampleValue(clazz, 1)).intValue());
  }

  /**
   * Test {@link ExamplesService#getExampleValue(Class, int)}.
   * <ul>
   *   <li>When {@code Long}.</li>
   *   <li>Then return longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExamplesService#getExampleValue(Class, int)}
   */
  @Test
  @DisplayName("Test getExampleValue(Class, int); when 'java.lang.Long'; then return longValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ExamplesService.getExampleValue(Class, int)"})
  void testGetExampleValue_whenJavaLangLong_thenReturnLongValueIsOne() {
    // Arrange
    Class<Long> clazz = Long.class;

    // Act and Assert
    assertEquals(1L, ((Long) examplesService.getExampleValue(clazz, 1)).longValue());
  }

  /**
   * Test {@link ExamplesService#getExampleValue(Class, int)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExamplesService#getExampleValue(Class, int)}
   */
  @Test
  @DisplayName("Test getExampleValue(Class, int); when 'java.lang.Object'; then return '1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ExamplesService.getExampleValue(Class, int)"})
  void testGetExampleValue_whenJavaLangObject_thenReturn1() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals("1", examplesService.getExampleValue(clazz, 1));
  }

  /**
   * Test {@link ExamplesService#getExampleValue(Class, int)}.
   * <ul>
   *   <li>When {@code String}.</li>
   *   <li>Then return {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExamplesService#getExampleValue(Class, int)}
   */
  @Test
  @DisplayName("Test getExampleValue(Class, int); when 'java.lang.String'; then return '1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ExamplesService.getExampleValue(Class, int)"})
  void testGetExampleValue_whenJavaLangString_thenReturn1() {
    // Arrange
    Class<String> clazz = String.class;

    // Act and Assert
    assertEquals("1", examplesService.getExampleValue(clazz, 1));
  }

  /**
   * Test {@link ExamplesService#getExampleValue(Class, int)}.
   * <ul>
   *   <li>When {@code Map$Entry}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExamplesService#getExampleValue(Class, int)}
   */
  @Test
  @DisplayName("Test getExampleValue(Class, int); when 'java.util.Map$Entry'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ExamplesService.getExampleValue(Class, int)"})
  void testGetExampleValue_whenJavaUtilMapEntry_thenReturnNull() {
    // Arrange
    Class<Entry> clazz = Entry.class;

    // Act and Assert
    assertNull(examplesService.getExampleValue(clazz, 1));
  }

  /**
   * Test {@link ExamplesService#getExampleValue(Class, int)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExamplesService#getExampleValue(Class, int)}
   */
  @Test
  @DisplayName("Test getExampleValue(Class, int); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object ExamplesService.getExampleValue(Class, int)"})
  void testGetExampleValue_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(examplesService.getExampleValue(null, 1));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ExamplesService}
   *   <li>{@link ExamplesService#populateOperation(Operation)}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ExamplesService.<init>()", "void ExamplesService.populateOperation(Operation)"})
  void testGettersAndSetters() {
    // Arrange and Act
    ExamplesService actualExamplesService = new ExamplesService();
    actualExamplesService.populateOperation(new CountAllElementsDefaultView());

    // Assert
    GetAllElements allElements = actualExamplesService.getAllElements();
    TypeReference<Iterable<? extends Element>> outputTypeReference = allElements.getOutputTypeReference();
    assertTrue(outputTypeReference instanceof IterableElement);
    Type outputType = allElements.getOutputType();
    assertEquals("java.lang.Iterable<? extends uk.gov.gchq.gaffer.data.element.Element>", outputType.getTypeName());
    assertNull(allElements.getOptions());
    assertNull(allElements.getDirectedType());
    assertNull(allElements.getView());
    Class<Iterable> expectedOutputClass = Iterable.class;
    assertEquals(expectedOutputClass, allElements.getOutputClass());
    assertSame(outputType, outputTypeReference.getType());
  }
}
