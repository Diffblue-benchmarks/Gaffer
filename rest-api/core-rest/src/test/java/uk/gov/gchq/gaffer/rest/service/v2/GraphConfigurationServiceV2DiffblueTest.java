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

package uk.gov.gchq.gaffer.rest.service.v2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;
import org.glassfish.jersey.message.internal.OutboundJaxrsResponse;
import org.glassfish.jersey.message.internal.OutboundMessageContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GraphConfigurationServiceV2DiffblueTest {
  /**
   * Test new {@link GraphConfigurationServiceV2} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * GraphConfigurationServiceV2}
   */
  @Test
  @DisplayName("Test new GraphConfigurationServiceV2 (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void GraphConfigurationServiceV2.<init>()"})
  void testNewGraphConfigurationServiceV2() {
    // Arrange and Act
    GraphConfigurationServiceV2 actualGraphConfigurationServiceV2 =
        new GraphConfigurationServiceV2();

    // Assert
    assertTrue(
        actualGraphConfigurationServiceV2.getAggregationFunctions()
            instanceof OutboundJaxrsResponse);
    assertTrue(
        actualGraphConfigurationServiceV2.getElementGenerators() instanceof OutboundJaxrsResponse);
    assertTrue(
        actualGraphConfigurationServiceV2.getFilterFunction() instanceof OutboundJaxrsResponse);
    assertTrue(
        actualGraphConfigurationServiceV2.getObjectGenerators() instanceof OutboundJaxrsResponse);
    assertTrue(
        actualGraphConfigurationServiceV2.getTransformFunctions() instanceof OutboundJaxrsResponse);
  }

  /**
   * Test {@link GraphConfigurationServiceV2#getFilterFunction()}.
   *
   * <p>Method under test: {@link GraphConfigurationServiceV2#getFilterFunction()}
   */
  @Test
  @DisplayName("Test getFilterFunction()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response GraphConfigurationServiceV2.getFilterFunction()"})
  void testGetFilterFunction() {
    // Arrange and Act
    Response actualFilterFunction = new GraphConfigurationServiceV2().getFilterFunction();

    // Assert
    Object entity = actualFilterFunction.getEntity();
    assertTrue(entity instanceof Set);
    StatusType statusInfo = actualFilterFunction.getStatusInfo();
    assertTrue(statusInfo instanceof Status);
    assertTrue(actualFilterFunction instanceof OutboundJaxrsResponse);
    assertNull(actualFilterFunction.getLocation());
    assertNull(actualFilterFunction.getDate());
    assertNull(actualFilterFunction.getLastModified());
    assertNull(actualFilterFunction.getLanguage());
    assertNull(actualFilterFunction.getEntityTag());
    assertNull(actualFilterFunction.getMediaType());
    assertEquals(-1, actualFilterFunction.getLength());
    MultivaluedMap<String, Object> headers = actualFilterFunction.getHeaders();
    assertEquals(1, headers.size());
    MultivaluedMap<String, String> stringHeaders = actualFilterFunction.getStringHeaders();
    assertEquals(1, stringHeaders.size());
    assertEquals(200, actualFilterFunction.getStatus());
    assertEquals(50, ((Set<Object>) entity).size());
    assertEquals(Status.OK, statusInfo);
    assertTrue(headers.containsKey("X-Gaffer-Media-Type"));
    assertTrue(stringHeaders.containsKey("X-Gaffer-Media-Type"));
    assertTrue(actualFilterFunction.getCookies().isEmpty());
    Set<String> allowedMethods = actualFilterFunction.getAllowedMethods();
    assertTrue(allowedMethods.isEmpty());
    assertSame(allowedMethods, actualFilterFunction.getLinks());
    assertSame(headers, actualFilterFunction.getMetadata());
  }

  /**
   * Test {@link GraphConfigurationServiceV2#getFilterFunction(String)} with {@code String}.
   *
   * <ul>
   *   <li>Then Entity return {@link Set}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationServiceV2#getFilterFunction(String)}
   */
  @Test
  @DisplayName("Test getFilterFunction(String) with 'String'; then Entity return Set")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response GraphConfigurationServiceV2.getFilterFunction(String)"})
  void testGetFilterFunctionWithString_thenEntityReturnSet() {
    // Arrange and Act
    Response actualFilterFunction =
        new GraphConfigurationServiceV2()
            .getFilterFunction("com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition");

    // Assert
    Object entity = actualFilterFunction.getEntity();
    assertTrue(entity instanceof Set);
    assertTrue(actualFilterFunction instanceof OutboundJaxrsResponse);
    assertEquals(1, actualFilterFunction.getStringHeaders().size());
    assertEquals(21, ((Set<Object>) entity).size());
    Class<HashSet> expectedEntityClass = HashSet.class;
    OutboundMessageContext context = ((OutboundJaxrsResponse) actualFilterFunction).getContext();
    assertEquals(expectedEntityClass, context.getEntityClass());
    assertSame(entity, context.getEntity());
  }

  /**
   * Test {@link GraphConfigurationServiceV2#getFilterFunction(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code .}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationServiceV2#getFilterFunction(String)}
   */
  @Test
  @DisplayName(
      "Test getFilterFunction(String) with 'String'; when '.'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response GraphConfigurationServiceV2.getFilterFunction(String)"})
  void testGetFilterFunctionWithString_whenDot_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new GraphConfigurationServiceV2().getFilterFunction("."));
  }

  /**
   * Test {@link GraphConfigurationServiceV2#getFilterFunction(String)} with {@code String}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@link OutboundJaxrsResponse}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationServiceV2#getFilterFunction(String)}
   */
  @Test
  @DisplayName(
      "Test getFilterFunction(String) with 'String'; when empty string; then return OutboundJaxrsResponse")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response GraphConfigurationServiceV2.getFilterFunction(String)"})
  void testGetFilterFunctionWithString_whenEmptyString_thenReturnOutboundJaxrsResponse() {
    // Arrange and Act
    Response actualFilterFunction = new GraphConfigurationServiceV2().getFilterFunction("");

    // Assert
    assertTrue(actualFilterFunction instanceof OutboundJaxrsResponse);
    assertEquals(1, actualFilterFunction.getStringHeaders().size());
  }

  /**
   * Test {@link GraphConfigurationServiceV2#getFilterFunction(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code Input Class}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationServiceV2#getFilterFunction(String)}
   */
  @Test
  @DisplayName(
      "Test getFilterFunction(String) with 'String'; when 'Input Class'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response GraphConfigurationServiceV2.getFilterFunction(String)"})
  void testGetFilterFunctionWithString_whenInputClass_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new GraphConfigurationServiceV2().getFilterFunction("Input Class"));
  }

  /**
   * Test {@link GraphConfigurationServiceV2#getFilterFunction(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code []}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationServiceV2#getFilterFunction(String)}
   */
  @Test
  @DisplayName("Test getFilterFunction(String) with 'String'; when '[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response GraphConfigurationServiceV2.getFilterFunction(String)"})
  void testGetFilterFunctionWithString_whenLeftSquareBracketRightSquareBracket() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new GraphConfigurationServiceV2().getFilterFunction("[]"));
  }

  /**
   * Test {@link GraphConfigurationServiceV2#getFilterFunction(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link OutboundJaxrsResponse}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationServiceV2#getFilterFunction(String)}
   */
  @Test
  @DisplayName(
      "Test getFilterFunction(String) with 'String'; when 'null'; then return OutboundJaxrsResponse")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response GraphConfigurationServiceV2.getFilterFunction(String)"})
  void testGetFilterFunctionWithString_whenNull_thenReturnOutboundJaxrsResponse() {
    // Arrange and Act
    Response actualFilterFunction = new GraphConfigurationServiceV2().getFilterFunction(null);

    // Assert
    assertTrue(actualFilterFunction instanceof OutboundJaxrsResponse);
    assertEquals(1, actualFilterFunction.getStringHeaders().size());
  }

  /**
   * Test {@link GraphConfigurationServiceV2#getSerialisedFields(String)}.
   *
   * <ul>
   *   <li>Then Entity return {@link Set}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationServiceV2#getSerialisedFields(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFields(String); then Entity return Set")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response GraphConfigurationServiceV2.getSerialisedFields(String)"})
  void testGetSerialisedFields_thenEntityReturnSet() {
    // Arrange and Act
    Response actualSerialisedFields =
        new GraphConfigurationServiceV2()
            .getSerialisedFields(
                "com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition");

    // Assert
    Object entity = actualSerialisedFields.getEntity();
    assertTrue(entity instanceof Set);
    assertTrue(actualSerialisedFields instanceof OutboundJaxrsResponse);
    assertEquals(1, actualSerialisedFields.getStringHeaders().size());
    assertEquals(20, ((Set<Object>) entity).size());
    assertSame(entity, ((OutboundJaxrsResponse) actualSerialisedFields).getContext().getEntity());
  }

  /**
   * Test {@link GraphConfigurationServiceV2#getSerialisedFields(String)}.
   *
   * <ul>
   *   <li>When {@code Class Name}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationServiceV2#getSerialisedFields(String)}
   */
  @Test
  @DisplayName(
      "Test getSerialisedFields(String); when 'Class Name'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response GraphConfigurationServiceV2.getSerialisedFields(String)"})
  void testGetSerialisedFields_whenClassName_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new GraphConfigurationServiceV2().getSerialisedFields("Class Name"));
  }

  /**
   * Test {@link GraphConfigurationServiceV2#getSerialisedFields(String)}.
   *
   * <ul>
   *   <li>When {@code .}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationServiceV2#getSerialisedFields(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFields(String); when '.'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response GraphConfigurationServiceV2.getSerialisedFields(String)"})
  void testGetSerialisedFields_whenDot_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new GraphConfigurationServiceV2().getSerialisedFields("."));
  }

  /**
   * Test {@link GraphConfigurationServiceV2#getSerialisedFields(String)}.
   *
   * <ul>
   *   <li>When {@code java.util.function.Predicate}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationServiceV2#getSerialisedFields(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFields(String); when 'java.util.function.Predicate'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response GraphConfigurationServiceV2.getSerialisedFields(String)"})
  void testGetSerialisedFields_whenJavaUtilFunctionPredicate() {
    // Arrange and Act
    Response actualSerialisedFields =
        new GraphConfigurationServiceV2().getSerialisedFields("java.util.function.Predicate");

    // Assert
    assertTrue(actualSerialisedFields instanceof OutboundJaxrsResponse);
    assertEquals(1, actualSerialisedFields.getStringHeaders().size());
    Object expectedEntity = actualSerialisedFields.getEntity();
    assertSame(
        expectedEntity, ((OutboundJaxrsResponse) actualSerialisedFields).getContext().getEntity());
  }

  /**
   * Test {@link GraphConfigurationServiceV2#getSerialisedFields(String)}.
   *
   * <ul>
   *   <li>When {@code []}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationServiceV2#getSerialisedFields(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFields(String); when '[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response GraphConfigurationServiceV2.getSerialisedFields(String)"})
  void testGetSerialisedFields_whenLeftSquareBracketRightSquareBracket() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new GraphConfigurationServiceV2().getSerialisedFields("[]"));
  }

  /**
   * Test {@link GraphConfigurationServiceV2#getSerialisedFields(String)}.
   *
   * <ul>
   *   <li>When {@code uk.gov.gchq.koryphe.signature.Signature$UnknownGenericType}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationServiceV2#getSerialisedFields(String)}
   */
  @Test
  @DisplayName(
      "Test getSerialisedFields(String); when 'uk.gov.gchq.koryphe.signature.Signature$UnknownGenericType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response GraphConfigurationServiceV2.getSerialisedFields(String)"})
  void testGetSerialisedFields_whenUkGovGchqKorypheSignatureSignatureUnknownGenericType() {
    // Arrange and Act
    Response actualSerialisedFields =
        new GraphConfigurationServiceV2()
            .getSerialisedFields("uk.gov.gchq.koryphe.signature.Signature$UnknownGenericType");

    // Assert
    assertTrue(actualSerialisedFields instanceof OutboundJaxrsResponse);
    assertEquals(1, actualSerialisedFields.getStringHeaders().size());
    Object expectedEntity = actualSerialisedFields.getEntity();
    assertSame(
        expectedEntity, ((OutboundJaxrsResponse) actualSerialisedFields).getContext().getEntity());
  }

  /**
   * Test {@link GraphConfigurationServiceV2#getSerialisedFieldClasses(String)}.
   *
   * <p>Method under test: {@link GraphConfigurationServiceV2#getSerialisedFieldClasses(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFieldClasses(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response GraphConfigurationServiceV2.getSerialisedFieldClasses(String)"})
  void testGetSerialisedFieldClasses() {
    // Arrange and Act
    Response actualSerialisedFieldClasses =
        new GraphConfigurationServiceV2()
            .getSerialisedFieldClasses(
                "uk.gov.gchq.koryphe.signature.Signature$UnknownGenericType");

    // Assert
    assertTrue(actualSerialisedFieldClasses instanceof OutboundJaxrsResponse);
    assertEquals(1, actualSerialisedFieldClasses.getStringHeaders().size());
    Object expectedEntity = actualSerialisedFieldClasses.getEntity();
    assertSame(
        expectedEntity,
        ((OutboundJaxrsResponse) actualSerialisedFieldClasses).getContext().getEntity());
  }

  /**
   * Test {@link GraphConfigurationServiceV2#getSerialisedFieldClasses(String)}.
   *
   * <ul>
   *   <li>Then return Entity size is twenty.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationServiceV2#getSerialisedFieldClasses(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFieldClasses(String); then return Entity size is twenty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response GraphConfigurationServiceV2.getSerialisedFieldClasses(String)"})
  void testGetSerialisedFieldClasses_thenReturnEntitySizeIsTwenty() {
    // Arrange and Act
    Response actualSerialisedFieldClasses =
        new GraphConfigurationServiceV2()
            .getSerialisedFieldClasses(
                "com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition");

    // Assert
    Object entity = actualSerialisedFieldClasses.getEntity();
    assertTrue(entity instanceof Map);
    assertTrue(actualSerialisedFieldClasses instanceof OutboundJaxrsResponse);
    assertEquals(20, ((Map<Object, Object>) entity).size());
    assertTrue(((Map<Object, Object>) entity).containsKey("accessor"));
    assertTrue(((Map<Object, Object>) entity).containsKey("fullName"));
    assertTrue(((Map<Object, Object>) entity).containsKey("getter"));
    assertTrue(((Map<Object, Object>) entity).containsKey("metadata"));
    assertTrue(((Map<Object, Object>) entity).containsKey("nonConstructorMutator"));
    assertTrue(((Map<Object, Object>) entity).containsKey("rawPrimaryType"));
  }

  /**
   * Test {@link GraphConfigurationServiceV2#getSerialisedFieldClasses(String)}.
   *
   * <ul>
   *   <li>When {@code class}.
   *   <li>Then return Entity size is forty-one.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationServiceV2#getSerialisedFieldClasses(String)}
   */
  @Test
  @DisplayName(
      "Test getSerialisedFieldClasses(String); when 'class'; then return Entity size is forty-one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response GraphConfigurationServiceV2.getSerialisedFieldClasses(String)"})
  void testGetSerialisedFieldClasses_whenClass_thenReturnEntitySizeIsFortyOne() {
    // Arrange and Act
    Response actualSerialisedFieldClasses =
        new GraphConfigurationServiceV2().getSerialisedFieldClasses("class");

    // Assert
    Object entity = actualSerialisedFieldClasses.getEntity();
    assertTrue(entity instanceof Map);
    assertTrue(actualSerialisedFieldClasses instanceof OutboundJaxrsResponse);
    assertEquals(41, ((Map<Object, Object>) entity).size());
    assertTrue(((Map<Object, Object>) entity).containsKey("classLoader"));
    assertTrue(((Map<Object, Object>) entity).containsKey("classes"));
    assertTrue(((Map<Object, Object>) entity).containsKey("enclosingConstructor"));
    assertTrue(((Map<Object, Object>) entity).containsKey("methods"));
    assertTrue(((Map<Object, Object>) entity).containsKey("primitive"));
    assertTrue(((Map<Object, Object>) entity).containsKey("typeName"));
  }

  /**
   * Test {@link GraphConfigurationServiceV2#getSerialisedFieldClasses(String)}.
   *
   * <ul>
   *   <li>When {@code java.util.function.Predicate}.
   * </ul>
   *
   * <p>Method under test: {@link GraphConfigurationServiceV2#getSerialisedFieldClasses(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFieldClasses(String); when 'java.util.function.Predicate'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response GraphConfigurationServiceV2.getSerialisedFieldClasses(String)"})
  void testGetSerialisedFieldClasses_whenJavaUtilFunctionPredicate() {
    // Arrange and Act
    Response actualSerialisedFieldClasses =
        new GraphConfigurationServiceV2().getSerialisedFieldClasses("java.util.function.Predicate");

    // Assert
    assertTrue(actualSerialisedFieldClasses instanceof OutboundJaxrsResponse);
    assertEquals(1, actualSerialisedFieldClasses.getStringHeaders().size());
    Object expectedEntity = actualSerialisedFieldClasses.getEntity();
    assertSame(
        expectedEntity,
        ((OutboundJaxrsResponse) actualSerialisedFieldClasses).getContext().getEntity());
  }

  /**
   * Test {@link GraphConfigurationServiceV2#getTransformFunctions()}.
   *
   * <p>Method under test: {@link GraphConfigurationServiceV2#getTransformFunctions()}
   */
  @Test
  @DisplayName("Test getTransformFunctions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response GraphConfigurationServiceV2.getTransformFunctions()"})
  void testGetTransformFunctions() {
    // Arrange and Act
    Response actualTransformFunctions = new GraphConfigurationServiceV2().getTransformFunctions();

    // Assert
    Object entity = actualTransformFunctions.getEntity();
    assertTrue(entity instanceof Set);
    StatusType statusInfo = actualTransformFunctions.getStatusInfo();
    assertTrue(statusInfo instanceof Status);
    assertTrue(actualTransformFunctions instanceof OutboundJaxrsResponse);
    assertNull(actualTransformFunctions.getLocation());
    assertNull(actualTransformFunctions.getDate());
    assertNull(actualTransformFunctions.getLastModified());
    assertNull(actualTransformFunctions.getLanguage());
    assertNull(actualTransformFunctions.getEntityTag());
    assertNull(actualTransformFunctions.getMediaType());
    assertEquals(-1, actualTransformFunctions.getLength());
    MultivaluedMap<String, Object> headers = actualTransformFunctions.getHeaders();
    assertEquals(1, headers.size());
    MultivaluedMap<String, String> stringHeaders = actualTransformFunctions.getStringHeaders();
    assertEquals(1, stringHeaders.size());
    assertEquals(128, ((Set<Object>) entity).size());
    assertEquals(200, actualTransformFunctions.getStatus());
    assertEquals(Status.OK, statusInfo);
    assertTrue(headers.containsKey("X-Gaffer-Media-Type"));
    assertTrue(stringHeaders.containsKey("X-Gaffer-Media-Type"));
    assertTrue(actualTransformFunctions.getCookies().isEmpty());
    Set<String> allowedMethods = actualTransformFunctions.getAllowedMethods();
    assertTrue(allowedMethods.isEmpty());
    assertSame(allowedMethods, actualTransformFunctions.getLinks());
    assertSame(headers, actualTransformFunctions.getMetadata());
  }

  /**
   * Test {@link GraphConfigurationServiceV2#getAggregationFunctions()}.
   *
   * <p>Method under test: {@link GraphConfigurationServiceV2#getAggregationFunctions()}
   */
  @Test
  @DisplayName("Test getAggregationFunctions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response GraphConfigurationServiceV2.getAggregationFunctions()"})
  void testGetAggregationFunctions() {
    // Arrange and Act
    Response actualAggregationFunctions =
        new GraphConfigurationServiceV2().getAggregationFunctions();

    // Assert
    Object entity = actualAggregationFunctions.getEntity();
    assertTrue(entity instanceof Set);
    StatusType statusInfo = actualAggregationFunctions.getStatusInfo();
    assertTrue(statusInfo instanceof Status);
    assertTrue(actualAggregationFunctions instanceof OutboundJaxrsResponse);
    assertNull(actualAggregationFunctions.getLocation());
    assertNull(actualAggregationFunctions.getDate());
    assertNull(actualAggregationFunctions.getLastModified());
    assertNull(actualAggregationFunctions.getLanguage());
    assertNull(actualAggregationFunctions.getEntityTag());
    assertNull(actualAggregationFunctions.getMediaType());
    assertEquals(-1, actualAggregationFunctions.getLength());
    MultivaluedMap<String, Object> headers = actualAggregationFunctions.getHeaders();
    assertEquals(1, headers.size());
    MultivaluedMap<String, String> stringHeaders = actualAggregationFunctions.getStringHeaders();
    assertEquals(1, stringHeaders.size());
    assertEquals(200, actualAggregationFunctions.getStatus());
    assertEquals(41, ((Set<Object>) entity).size());
    assertEquals(Status.OK, statusInfo);
    assertTrue(headers.containsKey("X-Gaffer-Media-Type"));
    assertTrue(stringHeaders.containsKey("X-Gaffer-Media-Type"));
    assertTrue(actualAggregationFunctions.getCookies().isEmpty());
    Set<String> allowedMethods = actualAggregationFunctions.getAllowedMethods();
    assertTrue(allowedMethods.isEmpty());
    assertSame(allowedMethods, actualAggregationFunctions.getLinks());
    assertSame(headers, actualAggregationFunctions.getMetadata());
  }

  /**
   * Test {@link GraphConfigurationServiceV2#getElementGenerators()}.
   *
   * <p>Method under test: {@link GraphConfigurationServiceV2#getElementGenerators()}
   */
  @Test
  @DisplayName("Test getElementGenerators()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response GraphConfigurationServiceV2.getElementGenerators()"})
  void testGetElementGenerators() {
    // Arrange and Act
    Response actualElementGenerators = new GraphConfigurationServiceV2().getElementGenerators();

    // Assert
    Object entity = actualElementGenerators.getEntity();
    assertTrue(entity instanceof Set);
    StatusType statusInfo = actualElementGenerators.getStatusInfo();
    assertTrue(statusInfo instanceof Status);
    assertTrue(actualElementGenerators instanceof OutboundJaxrsResponse);
    assertNull(actualElementGenerators.getLocation());
    assertNull(actualElementGenerators.getDate());
    assertNull(actualElementGenerators.getLastModified());
    assertNull(actualElementGenerators.getLanguage());
    assertNull(actualElementGenerators.getEntityTag());
    assertNull(actualElementGenerators.getMediaType());
    assertEquals(-1, actualElementGenerators.getLength());
    MultivaluedMap<String, Object> headers = actualElementGenerators.getHeaders();
    assertEquals(1, headers.size());
    MultivaluedMap<String, String> stringHeaders = actualElementGenerators.getStringHeaders();
    assertEquals(1, stringHeaders.size());
    assertEquals(200, actualElementGenerators.getStatus());
    assertEquals(6, ((Set<Class>) entity).size());
    assertEquals(Status.OK, statusInfo);
    assertTrue(headers.containsKey("X-Gaffer-Media-Type"));
    assertTrue(stringHeaders.containsKey("X-Gaffer-Media-Type"));
    assertTrue(actualElementGenerators.getCookies().isEmpty());
    Set<String> allowedMethods = actualElementGenerators.getAllowedMethods();
    assertTrue(allowedMethods.isEmpty());
    assertSame(allowedMethods, actualElementGenerators.getLinks());
    assertSame(headers, actualElementGenerators.getMetadata());
  }

  /**
   * Test {@link GraphConfigurationServiceV2#getObjectGenerators()}.
   *
   * <p>Method under test: {@link GraphConfigurationServiceV2#getObjectGenerators()}
   */
  @Test
  @DisplayName("Test getObjectGenerators()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Response GraphConfigurationServiceV2.getObjectGenerators()"})
  void testGetObjectGenerators() {
    // Arrange and Act
    Response actualObjectGenerators = new GraphConfigurationServiceV2().getObjectGenerators();

    // Assert
    Object entity = actualObjectGenerators.getEntity();
    assertTrue(entity instanceof Set);
    StatusType statusInfo = actualObjectGenerators.getStatusInfo();
    assertTrue(statusInfo instanceof Status);
    assertTrue(actualObjectGenerators instanceof OutboundJaxrsResponse);
    assertNull(actualObjectGenerators.getLocation());
    assertNull(actualObjectGenerators.getDate());
    assertNull(actualObjectGenerators.getLastModified());
    assertNull(actualObjectGenerators.getLanguage());
    assertNull(actualObjectGenerators.getEntityTag());
    assertNull(actualObjectGenerators.getMediaType());
    assertEquals(-1, actualObjectGenerators.getLength());
    MultivaluedMap<String, Object> headers = actualObjectGenerators.getHeaders();
    assertEquals(1, headers.size());
    MultivaluedMap<String, String> stringHeaders = actualObjectGenerators.getStringHeaders();
    assertEquals(1, stringHeaders.size());
    assertEquals(200, actualObjectGenerators.getStatus());
    assertEquals(7, ((Set<Class>) entity).size());
    assertEquals(Status.OK, statusInfo);
    assertTrue(headers.containsKey("X-Gaffer-Media-Type"));
    assertTrue(stringHeaders.containsKey("X-Gaffer-Media-Type"));
    assertTrue(actualObjectGenerators.getCookies().isEmpty());
    Set<String> allowedMethods = actualObjectGenerators.getAllowedMethods();
    assertTrue(allowedMethods.isEmpty());
    assertSame(allowedMethods, actualObjectGenerators.getLinks());
    assertSame(headers, actualObjectGenerators.getMetadata());
  }
}
