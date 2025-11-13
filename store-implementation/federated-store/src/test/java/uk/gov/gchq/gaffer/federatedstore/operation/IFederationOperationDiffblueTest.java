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

package uk.gov.gchq.gaffer.federatedstore.operation;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.federatedstore.operation.AddGraph.Builder;
import uk.gov.gchq.gaffer.federatedstore.operation.IFederationOperation.BaseBuilder;

class IFederationOperationDiffblueTest {
  /**
   * Test BaseBuilder {@link BaseBuilder#setUserRequestingAdminUsage(boolean)}.
   * <p>
   * Method under test: {@link BaseBuilder#setUserRequestingAdminUsage(boolean)}
   */
  @Test
  @DisplayName("Test BaseBuilder setUserRequestingAdminUsage(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "uk.gov.gchq.gaffer.operation.Operation.BaseBuilder BaseBuilder.setUserRequestingAdminUsage(boolean)"})
  void testBaseBuilderSetUserRequestingAdminUsage() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.setUserRequestingAdminUsage(true));
  }
}
