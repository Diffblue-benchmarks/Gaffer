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

package uk.gov.gchq.gaffer.federatedstore.util;

import static org.junit.jupiter.api.Assertions.assertSame;
import java.util.HashMap;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;

class FederatedStoreUtilDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link FederatedStoreUtil.SerialisableConfiguredMergeFunctionsMap}
   *   <li>
   * {@link FederatedStoreUtil.SerialisableConfiguredMergeFunctionsMap#setMap(HashMap)}
   *   <li>
   * {@link FederatedStoreUtil.SerialisableConfiguredMergeFunctionsMap#getMap()}
   * </ul>
   */
  @Test
  void testSerialisableConfiguredMergeFunctionsMapGettersAndSetters() {
    // Arrange and Act
    FederatedStoreUtil.SerialisableConfiguredMergeFunctionsMap actualSerialisableConfiguredMergeFunctionsMap = new FederatedStoreUtil.SerialisableConfiguredMergeFunctionsMap();
    HashMap<String, BiFunction> map = new HashMap<>();
    actualSerialisableConfiguredMergeFunctionsMap.setMap(map);

    // Assert that nothing has changed
    assertSame(map, actualSerialisableConfiguredMergeFunctionsMap.getMap());
  }
}
