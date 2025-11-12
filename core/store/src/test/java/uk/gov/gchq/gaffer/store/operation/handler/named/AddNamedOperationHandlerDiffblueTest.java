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

package uk.gov.gchq.gaffer.store.operation.handler.named;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.store.operation.handler.named.cache.NamedOperationCache;

class AddNamedOperationHandlerDiffblueTest {
  /**
   * Method under test:
   * {@link AddNamedOperationHandler#isNestedNamedOperationsAllowed()}
   */
  @Test
  void testIsNestedNamedOperationsAllowed() {
    // Arrange, Act and Assert
    assertTrue(
        (new AddNamedOperationHandler("Suffix Named Operation Cache Name", true)).isNestedNamedOperationsAllowed());
  }

  /**
   * Method under test: {@link AddNamedOperationHandler#getSuffixCacheName()}
   */
  @Test
  void testGetSuffixCacheName() {
    // Arrange, Act and Assert
    assertEquals("suffix named operation cache name",
        (new AddNamedOperationHandler("Suffix Named Operation Cache Name", true)).getSuffixCacheName());
  }

  /**
   * Method under test:
   * {@link AddNamedOperationHandler#AddNamedOperationHandler(String, Boolean)}
   */
  @Test
  void testNewAddNamedOperationHandler() {
    // Arrange and Act
    AddNamedOperationHandler actualAddNamedOperationHandler = new AddNamedOperationHandler(
        "Suffix Named Operation Cache Name", true);

    // Assert
    assertEquals("suffix named operation cache name", actualAddNamedOperationHandler.getSuffixCacheName());
    assertTrue(actualAddNamedOperationHandler.isNestedNamedOperationsAllowed());
  }

  /**
   * Method under test:
   * {@link AddNamedOperationHandler#AddNamedOperationHandler(String, Boolean)}
   */
  @Test
  void testNewAddNamedOperationHandler2() {
    // Arrange and Act
    AddNamedOperationHandler actualAddNamedOperationHandler = new AddNamedOperationHandler((String) null, true);

    // Assert
    assertNull(actualAddNamedOperationHandler.getSuffixCacheName());
    assertTrue(actualAddNamedOperationHandler.isNestedNamedOperationsAllowed());
  }

  /**
   * Method under test:
   * {@link AddNamedOperationHandler#AddNamedOperationHandler(String, Boolean)}
   */
  @Test
  void testNewAddNamedOperationHandler3() {
    // Arrange and Act
    AddNamedOperationHandler actualAddNamedOperationHandler = new AddNamedOperationHandler(
        "Suffix Named Operation Cache Name", false);

    // Assert
    assertEquals("suffix named operation cache name", actualAddNamedOperationHandler.getSuffixCacheName());
    assertFalse(actualAddNamedOperationHandler.isNestedNamedOperationsAllowed());
  }

  /**
   * Method under test:
   * {@link AddNamedOperationHandler#AddNamedOperationHandler(NamedOperationCache, Boolean)}
   */
  @Test
  void testNewAddNamedOperationHandler4() {
    // Arrange and Act
    AddNamedOperationHandler actualAddNamedOperationHandler = new AddNamedOperationHandler(
        new NamedOperationCache("Suffix Named Operation Cache Name"), true);

    // Assert
    assertEquals("suffix named operation cache name", actualAddNamedOperationHandler.getSuffixCacheName());
    assertTrue(actualAddNamedOperationHandler.isNestedNamedOperationsAllowed());
  }

  /**
   * Method under test:
   * {@link AddNamedOperationHandler#AddNamedOperationHandler(NamedOperationCache, Boolean)}
   */
  @Test
  void testNewAddNamedOperationHandler5() {
    // Arrange and Act
    AddNamedOperationHandler actualAddNamedOperationHandler = new AddNamedOperationHandler(
        new NamedOperationCache("Suffix Named Operation Cache Name"), false);

    // Assert
    assertEquals("suffix named operation cache name", actualAddNamedOperationHandler.getSuffixCacheName());
    assertFalse(actualAddNamedOperationHandler.isNestedNamedOperationsAllowed());
  }
}
