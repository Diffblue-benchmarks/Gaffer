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

package uk.gov.gchq.gaffer.store.operation.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class GetWalksHandlerDiffblueTest {
  /**
   * Test {@link GetWalksHandler#getPrune()}.
   * <ul>
   *   <li>Given {@link GetWalksHandler} (default constructor) Prune is {@code false}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetWalksHandler#getPrune()}
   */
  @Test
  @DisplayName("Test getPrune(); given GetWalksHandler (default constructor) Prune is 'false'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Boolean GetWalksHandler.getPrune()"})
  void testGetPrune_givenGetWalksHandlerPruneIsFalse_thenReturnFalse() {
    // Arrange
    GetWalksHandler getWalksHandler = new GetWalksHandler();
    getWalksHandler.setPrune(false);

    // Act and Assert
    assertFalse(getWalksHandler.getPrune());
  }

  /**
   * Test {@link GetWalksHandler#getPrune()}.
   * <ul>
   *   <li>Given {@link GetWalksHandler} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GetWalksHandler#getPrune()}
   */
  @Test
  @DisplayName("Test getPrune(); given GetWalksHandler (default constructor); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Boolean GetWalksHandler.getPrune()"})
  void testGetPrune_givenGetWalksHandler_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new GetWalksHandler()).getPrune());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link GetWalksHandler}
   *   <li>{@link GetWalksHandler#setMaxHops(Integer)}
   *   <li>{@link GetWalksHandler#getMaxHops()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void GetWalksHandler.<init>()", "Integer GetWalksHandler.getMaxHops()",
      "void GetWalksHandler.setMaxHops(Integer)"})
  void testGettersAndSetters() {
    // Arrange and Act
    GetWalksHandler actualGetWalksHandler = new GetWalksHandler();
    actualGetWalksHandler.setMaxHops(3);

    // Assert
    assertEquals(3, actualGetWalksHandler.getMaxHops().intValue());
  }
}
