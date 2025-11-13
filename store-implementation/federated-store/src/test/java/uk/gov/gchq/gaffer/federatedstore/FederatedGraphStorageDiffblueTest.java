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

package uk.gov.gchq.gaffer.federatedstore;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.federatedstore.exception.StorageException;
import uk.gov.gchq.gaffer.graph.GraphSerialisable;
import uk.gov.gchq.gaffer.user.User;

class FederatedGraphStorageDiffblueTest {
  /**
   * Test {@link FederatedGraphStorage#put(GraphSerialisable, FederatedAccess)} with {@code graph}, {@code access}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedGraphStorage#put(GraphSerialisable, FederatedAccess)}
   */
  @Test
  @DisplayName("Test put(GraphSerialisable, FederatedAccess) with 'graph', 'access'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void FederatedGraphStorage.put(GraphSerialisable, FederatedAccess)"})
  void testPutWithGraphAccess_whenNull() throws StorageException {
    // Arrange
    FederatedGraphStorage federatedGraphStorage = new FederatedGraphStorage("Suffix Federated Store Cache Name");

    // Act and Assert
    assertThrows(StorageException.class,
        () -> federatedGraphStorage.put((GraphSerialisable) null, new FederatedAccess(new HashSet<>(), "42")));
  }

  /**
   * Test {@link FederatedGraphStorage#get(User, List, String)} with {@code user}, {@code graphIds}, {@code adminAuth}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedGraphStorage#get(User, List, String)}
   */
  @Test
  @DisplayName("Test get(User, List, String) with 'user', 'graphIds', 'adminAuth'; when 'null'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List FederatedGraphStorage.get(User, List, String)"})
  void testGetWithUserGraphIdsAdminAuth_whenNull_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        (new FederatedGraphStorage("Suffix Federated Store Cache Name")).get(null, null, "Admin Auth").isEmpty());
  }

  /**
   * Test {@link FederatedGraphStorage#get(User, List)} with {@code user}, {@code graphIds}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link FederatedGraphStorage#get(User, List)}
   */
  @Test
  @DisplayName("Test get(User, List) with 'user', 'graphIds'; when 'null'; then return List")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Collection FederatedGraphStorage.get(User, List)"})
  void testGetWithUserGraphIds_whenNull_thenReturnList() {
    // Arrange and Act
    Collection<GraphSerialisable> actualGetResult = (new FederatedGraphStorage("Suffix Federated Store Cache Name"))
        .get(null, null);

    // Assert
    assertTrue(actualGetResult instanceof List);
    assertTrue(actualGetResult.isEmpty());
  }
}
