/*
 * Copyright 2026 Crown Copyright
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

package uk.gov.gchq.gaffer.store.operation;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.store.operation.DeleteAllData.Builder;

class DeleteAllDataDiffblueTest {
  /**
   * Test Builder new {@link Builder} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder actualBuilder = new Builder();

    // Assert
    DeleteAllData _getOpResult = actualBuilder._getOp();
    Map<String, String> options = _getOpResult.getOptions();
    assertTrue(options.isEmpty());
    DeleteAllData actualDeleteAllData = actualBuilder.build();
    assertSame(_getOpResult, actualDeleteAllData);
    assertSame(options, _getOpResult.options);
  }

  /**
   * Test {@link DeleteAllData#shallowClone()}.
   *
   * <p>Method under test: {@link DeleteAllData#shallowClone()}
   */
  @Test
  @DisplayName("Test shallowClone()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeleteAllData DeleteAllData.shallowClone()"})
  void testShallowClone() throws CloneFailedException {
    // Arrange and Act
    DeleteAllData actualShallowCloneResult = new DeleteAllData().shallowClone();

    // Assert
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
    assertTrue(actualShallowCloneResult.options.isEmpty());
  }

  /**
   * Test {@link DeleteAllData#getOptions()}.
   *
   * <p>Method under test: {@link DeleteAllData#getOptions()}
   */
  @Test
  @DisplayName("Test getOptions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map DeleteAllData.getOptions()"})
  void testGetOptions() {
    // Arrange, Act and Assert
    assertTrue(new DeleteAllData().getOptions().isEmpty());
  }

  /**
   * Test new {@link DeleteAllData} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link DeleteAllData}
   */
  @Test
  @DisplayName("Test new DeleteAllData (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeleteAllData.<init>()"})
  void testNewDeleteAllData() {
    // Arrange, Act and Assert
    assertTrue(new DeleteAllData().options.isEmpty());
  }
}
