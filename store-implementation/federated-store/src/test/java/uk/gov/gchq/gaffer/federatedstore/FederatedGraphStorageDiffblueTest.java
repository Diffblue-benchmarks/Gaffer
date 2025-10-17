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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.federatedstore.exception.StorageException;
import uk.gov.gchq.gaffer.graph.GraphSerialisable;
import uk.gov.gchq.gaffer.user.User;

class FederatedGraphStorageDiffblueTest {
  /**
   * Test {@link FederatedGraphStorage#put(GraphSerialisable, FederatedAccess)} with {@code graph},
   * {@code access}.
   *
   * <p>Method under test: {@link FederatedGraphStorage#put(GraphSerialisable, FederatedAccess)}
   */
  @Test
  @DisplayName("Test put(GraphSerialisable, FederatedAccess) with 'graph', 'access'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedGraphStorage.put(GraphSerialisable, FederatedAccess)"})
  void testPutWithGraphAccess() throws StorageException {
    // Arrange
    FederatedGraphStorage federatedGraphStorage =
        new FederatedGraphStorage("Suffix Federated Store Cache Name");
    federatedGraphStorage.setGraphLibrary(null);

    // Act and Assert
    assertThrows(
        StorageException.class, () -> federatedGraphStorage.put((GraphSerialisable) null, null));
  }

  /**
   * Test {@link FederatedGraphStorage#put(Collection, FederatedAccess)} with {@code graphs}, {@code
   * access}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedGraphStorage#put(Collection, FederatedAccess)}
   */
  @Test
  @DisplayName(
      "Test put(Collection, FederatedAccess) with 'graphs', 'access'; given 'null'; when LinkedHashSet() add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedGraphStorage.put(Collection, FederatedAccess)"})
  void testPutWithGraphsAccess_givenNull_whenLinkedHashSetAddNull() throws StorageException {
    // Arrange
    FederatedGraphStorage federatedGraphStorage =
        new FederatedGraphStorage("Suffix Federated Store Cache Name");
    federatedGraphStorage.setGraphLibrary(null);

    LinkedHashSet<GraphSerialisable> graphs = new LinkedHashSet<>();
    graphs.add(null);

    // Act and Assert
    assertThrows(StorageException.class, () -> federatedGraphStorage.put(graphs, null));
  }

  /**
   * Test {@link FederatedGraphStorage#get(User, List, String)} with {@code user}, {@code graphIds},
   * {@code adminAuth}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link FederatedGraphStorage#get(User, List, String)}
   */
  @Test
  @DisplayName(
      "Test get(User, List, String) with 'user', 'graphIds', 'adminAuth'; when 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List FederatedGraphStorage.get(User, List, String)"})
  void testGetWithUserGraphIdsAdminAuth_whenNull_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue(
        new FederatedGraphStorage("Suffix Federated Store Cache Name")
            .get(null, null, "Admin Auth")
            .isEmpty());
  }

  /**
   * Test {@link FederatedGraphStorage#get(User, List)} with {@code user}, {@code graphIds}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedGraphStorage#get(User, List)}
   */
  @Test
  @DisplayName("Test get(User, List) with 'user', 'graphIds'; when 'null'; then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection FederatedGraphStorage.get(User, List)"})
  void testGetWithUserGraphIds_whenNull_thenReturnList() {
    // Arrange and Act
    Collection<GraphSerialisable> actualGetResult =
        new FederatedGraphStorage("Suffix Federated Store Cache Name").get(null, null);

    // Assert
    assertTrue(actualGetResult instanceof List);
    assertTrue(actualGetResult.isEmpty());
  }
}
