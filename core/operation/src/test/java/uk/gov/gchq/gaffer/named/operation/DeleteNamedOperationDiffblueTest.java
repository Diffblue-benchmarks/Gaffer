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

package uk.gov.gchq.gaffer.named.operation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.operation.DeleteNamedOperation.Builder;

class DeleteNamedOperationDiffblueTest {
  /**
   * Test Builder {@link Builder#name(String)}.
   * <p>
   * Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.name("Name"));
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
    DeleteNamedOperation _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.getOperationName());
    assertNull(_getOpResult.getOptions());
    assertSame(_getOpResult, actualBuilder.build());
  }

  /**
   * Test {@link DeleteNamedOperation#shallowClone()}.
   * <ul>
   *   <li>Given {@link DeleteNamedOperation} (default constructor).</li>
   *   <li>Then return Options is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteNamedOperation#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); given DeleteNamedOperation (default constructor); then return Options is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeleteNamedOperation DeleteNamedOperation.shallowClone()"})
  void testShallowClone_givenDeleteNamedOperation_thenReturnOptionsIsNull() {
    // Arrange and Act
    DeleteNamedOperation actualShallowCloneResult = (new DeleteNamedOperation()).shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getOperationName());
    assertNull(actualShallowCloneResult.getOptions());
  }

  /**
   * Test {@link DeleteNamedOperation#shallowClone()}.
   * <ul>
   *   <li>Then return Options Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteNamedOperation#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone(); then return Options Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeleteNamedOperation DeleteNamedOperation.shallowClone()"})
  void testShallowClone_thenReturnOptionsEmpty() {
    // Arrange
    DeleteNamedOperation deleteNamedOperation = new DeleteNamedOperation();
    deleteNamedOperation.setOptions(new HashMap<>());

    // Act
    DeleteNamedOperation actualShallowCloneResult = deleteNamedOperation.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getOperationName());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DeleteNamedOperation}
   *   <li>{@link DeleteNamedOperation#setOperationName(String)}
   *   <li>{@link DeleteNamedOperation#setOptions(Map)}
   *   <li>{@link DeleteNamedOperation#getOperationName()}
   *   <li>{@link DeleteNamedOperation#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeleteNamedOperation.<init>()", "String DeleteNamedOperation.getOperationName()",
      "Map DeleteNamedOperation.getOptions()", "void DeleteNamedOperation.setOperationName(String)",
      "void DeleteNamedOperation.setOptions(Map)"})
  void testGettersAndSetters() {
    // Arrange and Act
    DeleteNamedOperation actualDeleteNamedOperation = new DeleteNamedOperation();
    actualDeleteNamedOperation.setOperationName("Operation Name");
    HashMap<String, String> options = new HashMap<>();
    actualDeleteNamedOperation.setOptions(options);
    String actualOperationName = actualDeleteNamedOperation.getOperationName();
    Map<String, String> actualOptions = actualDeleteNamedOperation.getOptions();

    // Assert
    assertEquals("Operation Name", actualOperationName);
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
