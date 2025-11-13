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

package uk.gov.gchq.gaffer.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.AddNamedOperation;
import uk.gov.gchq.gaffer.named.operation.AddNamedOperation.Builder;
import uk.gov.gchq.gaffer.operation.Operation.BaseBuilder;
import uk.gov.gchq.koryphe.ValidationResult;

class OperationDiffblueTest {
  /**
   * Test {@link Operation#addOption(String, String)}.
   * <ul>
   *   <li>Given {@link AddNamedOperation} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Operation#addOption(String, String)}
   */
  @Test
  @DisplayName("Test addOption(String, String); given AddNamedOperation (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Operation.addOption(String, String)"})
  void testAddOption_givenAddNamedOperation() {
    // Arrange
    AddNamedOperation addNamedOperation = new AddNamedOperation();

    // Act
    addNamedOperation.addOption("Name", "42");

    // Assert
    Map<String, String> options = addNamedOperation.getOptions();
    assertEquals(1, options.size());
    assertEquals("42", options.get("Name"));
  }

  /**
   * Test {@link Operation#addOption(String, String)}.
   * <ul>
   *   <li>Given {@link AddNamedOperation} (default constructor) addOption {@code Name} and {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Operation#addOption(String, String)}
   */
  @Test
  @DisplayName("Test addOption(String, String); given AddNamedOperation (default constructor) addOption 'Name' and '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Operation.addOption(String, String)"})
  void testAddOption_givenAddNamedOperationAddOptionNameAnd42() {
    // Arrange
    AddNamedOperation addNamedOperation = new AddNamedOperation();
    addNamedOperation.addOption("Name", "42");

    // Act
    addNamedOperation.addOption("Name", "42");

    // Assert that nothing has changed
    Map<String, String> options = addNamedOperation.getOptions();
    assertEquals(1, options.size());
    assertEquals("42", options.get("Name"));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#option(String, String)}.
   * <p>
   * Method under test: {@link BaseBuilder#option(String, String)}
   */
  @Test
  @DisplayName("Test BaseBuilder option(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.option(String, String)"})
  void testBaseBuilderOption() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.option("Name", "42"));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#options(Map)}.
   * <p>
   * Method under test: {@link BaseBuilder#options(Map)}
   */
  @Test
  @DisplayName("Test BaseBuilder options(Map)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder.options(Map)"})
  void testBaseBuilderOptions() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.options(new HashMap<>()));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#_self()}.
   * <p>
   * Method under test: {@link BaseBuilder#_self()}
   */
  @Test
  @DisplayName("Test BaseBuilder _self()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseBuilder BaseBuilder._self()"})
  void testBaseBuilder_self() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder._self());
  }

  /**
   * Test {@link Operation#getOption(String, String)} with {@code name}, {@code defaultValue}.
   * <ul>
   *   <li>Given {@link AddNamedOperation} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Operation#getOption(String, String)}
   */
  @Test
  @DisplayName("Test getOption(String, String) with 'name', 'defaultValue'; given AddNamedOperation (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Operation.getOption(String, String)"})
  void testGetOptionWithNameDefaultValue_givenAddNamedOperation() {
    // Arrange, Act and Assert
    assertEquals("42", (new AddNamedOperation()).getOption("Name", "42"));
  }

  /**
   * Test {@link Operation#getOption(String, String)} with {@code name}, {@code defaultValue}.
   * <ul>
   *   <li>Given {@link AddNamedOperation} (default constructor) Options is {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Operation#getOption(String, String)}
   */
  @Test
  @DisplayName("Test getOption(String, String) with 'name', 'defaultValue'; given AddNamedOperation (default constructor) Options is HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Operation.getOption(String, String)"})
  void testGetOptionWithNameDefaultValue_givenAddNamedOperationOptionsIsHashMap() {
    // Arrange
    AddNamedOperation addNamedOperation = new AddNamedOperation();
    addNamedOperation.setOptions(new HashMap<>());

    // Act and Assert
    assertEquals("42", addNamedOperation.getOption("Name", "42"));
  }

  /**
   * Test {@link Operation#getOption(String)} with {@code name}.
   * <ul>
   *   <li>Given {@link AddNamedOperation} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Operation#getOption(String)}
   */
  @Test
  @DisplayName("Test getOption(String) with 'name'; given AddNamedOperation (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Operation.getOption(String)"})
  void testGetOptionWithName_givenAddNamedOperation() {
    // Arrange, Act and Assert
    assertNull((new AddNamedOperation()).getOption("Name"));
  }

  /**
   * Test {@link Operation#getOption(String)} with {@code name}.
   * <ul>
   *   <li>Given {@link AddNamedOperation} (default constructor) Options is {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Operation#getOption(String)}
   */
  @Test
  @DisplayName("Test getOption(String) with 'name'; given AddNamedOperation (default constructor) Options is HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Operation.getOption(String)"})
  void testGetOptionWithName_givenAddNamedOperationOptionsIsHashMap() {
    // Arrange
    AddNamedOperation addNamedOperation = new AddNamedOperation();
    addNamedOperation.setOptions(new HashMap<>());

    // Act and Assert
    assertNull(addNamedOperation.getOption("Name"));
  }

  /**
   * Test {@link Operation#containsOption(String)}.
   * <ul>
   *   <li>Given {@link AddNamedOperation} (default constructor) addOption {@code Name} and {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Operation#containsOption(String)}
   */
  @Test
  @DisplayName("Test containsOption(String); given AddNamedOperation (default constructor) addOption 'Name' and '42'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Operation.containsOption(String)"})
  void testContainsOption_givenAddNamedOperationAddOptionNameAnd42_thenReturnTrue() {
    // Arrange
    AddNamedOperation addNamedOperation = new AddNamedOperation();
    addNamedOperation.addOption("Name", "42");

    // Act and Assert
    assertTrue(addNamedOperation.containsOption("Name"));
  }

  /**
   * Test {@link Operation#containsOption(String)}.
   * <ul>
   *   <li>Given {@link AddNamedOperation} (default constructor) Options is {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Operation#containsOption(String)}
   */
  @Test
  @DisplayName("Test containsOption(String); given AddNamedOperation (default constructor) Options is HashMap(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Operation.containsOption(String)"})
  void testContainsOption_givenAddNamedOperationOptionsIsHashMap_thenReturnFalse() {
    // Arrange
    AddNamedOperation addNamedOperation = new AddNamedOperation();
    addNamedOperation.setOptions(new HashMap<>());

    // Act and Assert
    assertFalse(addNamedOperation.containsOption("Name"));
  }

  /**
   * Test {@link Operation#containsOption(String)}.
   * <ul>
   *   <li>Given {@link AddNamedOperation} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Operation#containsOption(String)}
   */
  @Test
  @DisplayName("Test containsOption(String); given AddNamedOperation (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Operation.containsOption(String)"})
  void testContainsOption_givenAddNamedOperation_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new AddNamedOperation()).containsOption("Name"));
  }

  /**
   * Test {@link Operation#_getNullOrOptions()}.
   * <ul>
   *   <li>Given {@link AddNamedOperation} (default constructor) Options is {@link HashMap#HashMap()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Operation#_getNullOrOptions()}
   */
  @Test
  @DisplayName("Test _getNullOrOptions(); given AddNamedOperation (default constructor) Options is HashMap(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map Operation._getNullOrOptions()"})
  void test_getNullOrOptions_givenAddNamedOperationOptionsIsHashMap_thenReturnNull() {
    // Arrange
    AddNamedOperation addNamedOperation = new AddNamedOperation();
    addNamedOperation.setOptions(new HashMap<>());

    // Act and Assert
    assertNull(addNamedOperation._getNullOrOptions());
  }

  /**
   * Test {@link Operation#_getNullOrOptions()}.
   * <ul>
   *   <li>Given {@link AddNamedOperation} (default constructor).</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Operation#_getNullOrOptions()}
   */
  @Test
  @DisplayName("Test _getNullOrOptions(); given AddNamedOperation (default constructor); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map Operation._getNullOrOptions()"})
  void test_getNullOrOptions_givenAddNamedOperation_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new AddNamedOperation())._getNullOrOptions());
  }

  /**
   * Test {@link Operation#_getNullOrOptions()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Operation#_getNullOrOptions()}
   */
  @Test
  @DisplayName("Test _getNullOrOptions(); then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map Operation._getNullOrOptions()"})
  void test_getNullOrOptions_thenReturnSizeIsOne() {
    // Arrange
    AddNamedOperation addNamedOperation = new AddNamedOperation();
    addNamedOperation.addOption("Name", "42");

    // Act
    Map<String, String> actual_getNullOrOptionsResult = addNamedOperation._getNullOrOptions();

    // Assert
    assertEquals(1, actual_getNullOrOptionsResult.size());
    assertEquals("42", actual_getNullOrOptionsResult.get("Name"));
  }

  /**
   * Test {@link Operation#validate()}.
   * <p>
   * Method under test: {@link Operation#validate()}
   */
  @Test
  @DisplayName("Test validate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult Operation.validate()"})
  void testValidate() {
    // Arrange and Act
    ValidationResult actualValidateResult = (new AddNamedOperation()).validate();

    // Assert
    assertEquals("Validation errors: \noperations is required for: AddNamedOperation",
        actualValidateResult.getErrorString());
    Set<String> errors = actualValidateResult.getErrors();
    assertEquals(1, errors.size());
    assertFalse(actualValidateResult.isValid());
    assertTrue(errors.contains("operations is required for: AddNamedOperation"));
  }

  /**
   * Test {@link Operation#validate()}.
   * <ul>
   *   <li>Then return ErrorString is {@code Validation errors:}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Operation#validate()}
   */
  @Test
  @DisplayName("Test validate(); then return ErrorString is 'Validation errors:'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ValidationResult Operation.validate()"})
  void testValidate_thenReturnErrorStringIsValidationErrors() {
    // Arrange
    AddNamedOperation addNamedOperation = new AddNamedOperation();
    addNamedOperation.setOperationChain("%s is required for: %s");

    // Act
    ValidationResult actualValidateResult = addNamedOperation.validate();

    // Assert
    assertEquals("Validation errors: \n", actualValidateResult.getErrorString());
    assertTrue(actualValidateResult.getErrors().isEmpty());
    assertTrue(actualValidateResult.isValid());
  }
}
