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

package uk.gov.gchq.gaffer.rest.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.rest.factory.DefaultGraphFactory;

class GraphConfigurationControllerDiffblueTest {
  /**
   * Test {@link GraphConfigurationController#getSerialisedFields(String)}.
   * <ul>
   *   <li>When {@code java.util.Set}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphConfigurationController#getSerialisedFields(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFields(String); when 'java.util.Set'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set GraphConfigurationController.getSerialisedFields(String)"})
  void testGetSerialisedFields_whenJavaUtilSet_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertTrue(
        (new GraphConfigurationController(new DefaultGraphFactory())).getSerialisedFields("java.util.Set").isEmpty());
  }

  /**
   * Test {@link GraphConfigurationController#getSerialisedFieldClasses(String)}.
   * <ul>
   *   <li>Then return size is eleven.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphConfigurationController#getSerialisedFieldClasses(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFieldClasses(String); then return size is eleven")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map GraphConfigurationController.getSerialisedFieldClasses(String)"})
  void testGetSerialisedFieldClasses_thenReturnSizeIsEleven() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange and Act
    Map<String, String> actualSerialisedFieldClasses = (new GraphConfigurationController(new DefaultGraphFactory()))
        .getSerialisedFieldClasses("uk.gov.gchq.gaffer.rest.controller.GraphConfigurationController");

    // Assert
    assertEquals(11, actualSerialisedFieldClasses.size());
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("aggregationFunctions"));
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("description"));
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("elementGenerators"));
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("filterFunctions"));
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("graphCreatedTime"));
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("graphId"));
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("objectGenerators"));
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("schema"));
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("storeTraits"));
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("storeType"));
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("transformFunctions"));
  }

  /**
   * Test {@link GraphConfigurationController#getSerialisedFieldClasses(String)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphConfigurationController#getSerialisedFieldClasses(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFieldClasses(String); then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map GraphConfigurationController.getSerialisedFieldClasses(String)"})
  void testGetSerialisedFieldClasses_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange and Act
    Map<String, String> actualSerialisedFieldClasses = (new GraphConfigurationController(new DefaultGraphFactory()))
        .getSerialisedFieldClasses("uk.gov.gchq.gaffer.operation.io.Output");

    // Assert
    assertEquals(1, actualSerialisedFieldClasses.size());
    assertEquals("java.util.Map<java.lang.String,java.lang.String>", actualSerialisedFieldClasses.get("options"));
  }

  /**
   * Test {@link GraphConfigurationController#getSerialisedFieldClasses(String)}.
   * <ul>
   *   <li>When {@code class}.</li>
   *   <li>Then return size is forty-one.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphConfigurationController#getSerialisedFieldClasses(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFieldClasses(String); when 'class'; then return size is forty-one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map GraphConfigurationController.getSerialisedFieldClasses(String)"})
  void testGetSerialisedFieldClasses_whenClass_thenReturnSizeIsFortyOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange and Act
    Map<String, String> actualSerialisedFieldClasses = (new GraphConfigurationController(new DefaultGraphFactory()))
        .getSerialisedFieldClasses("class");

    // Assert
    assertEquals(41, actualSerialisedFieldClasses.size());
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("annotations"));
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("classLoader"));
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("classes"));
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("declaredMethods"));
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("enclosingConstructor"));
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("genericInterfaces"));
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("interface"));
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("methods"));
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("modifiers"));
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("primitive"));
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("typeName"));
  }

  /**
   * Test {@link GraphConfigurationController#getSerialisedFieldClasses(String)}.
   * <ul>
   *   <li>When {@code java.util.function.Predicate}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphConfigurationController#getSerialisedFieldClasses(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFieldClasses(String); when 'java.util.function.Predicate'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map GraphConfigurationController.getSerialisedFieldClasses(String)"})
  void testGetSerialisedFieldClasses_whenJavaUtilFunctionPredicate_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertTrue((new GraphConfigurationController(new DefaultGraphFactory()))
        .getSerialisedFieldClasses("java.util.function.Predicate")
        .isEmpty());
  }

  /**
   * Test {@link GraphConfigurationController#getSerialisedFieldClasses(String)}.
   * <ul>
   *   <li>When {@code java.util.Set}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link GraphConfigurationController#getSerialisedFieldClasses(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFieldClasses(String); when 'java.util.Set'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map GraphConfigurationController.getSerialisedFieldClasses(String)"})
  void testGetSerialisedFieldClasses_whenJavaUtilSet_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertTrue((new GraphConfigurationController(new DefaultGraphFactory())).getSerialisedFieldClasses("java.util.Set")
        .isEmpty());
  }
}
