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

package uk.gov.gchq.gaffer.operation.export.graph;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.user.User;

class AuthorisedGraphForExportDelegateDiffblueTest {
  /**
   * Method under test:
   * {@link AuthorisedGraphForExportDelegate.Builder#idAuths(Map)}
   */
  @Test
  void testBuilderIdAuths() {
    // Arrange
    AuthorisedGraphForExportDelegate.Builder builder = new AuthorisedGraphForExportDelegate.Builder();

    // Act and Assert
    assertSame(builder, builder.idAuths(new HashMap<>()));
  }

  /**
   * Method under test:
   * {@link AuthorisedGraphForExportDelegate.Builder#idAuths(Map)}
   */
  @Test
  void testBuilderIdAuths2() {
    // Arrange
    AuthorisedGraphForExportDelegate.Builder builder = new AuthorisedGraphForExportDelegate.Builder();

    HashMap<String, List<String>> idAuths = new HashMap<>();
    idAuths.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertSame(builder, builder.idAuths(idAuths));
  }

  /**
   * Method under test:
   * {@link AuthorisedGraphForExportDelegate.Builder#user(User)}
   */
  @Test
  void testBuilderUser() {
    // Arrange
    AuthorisedGraphForExportDelegate.Builder builder = new AuthorisedGraphForExportDelegate.Builder();

    // Act and Assert
    assertSame(builder, builder.user(new User()));
  }

  /**
   * Method under test: {@link AuthorisedGraphForExportDelegate.Builder#_self()}
   */
  @Test
  void testBuilder_self() {
    // Arrange
    AuthorisedGraphForExportDelegate.Builder builder = new AuthorisedGraphForExportDelegate.Builder();

    // Act and Assert
    assertSame(builder, builder._self());
  }
}
