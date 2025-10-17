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

package uk.gov.gchq.gaffer.rest.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.user.User;

class UserFactoryDiffblueTest {
  /**
   * Test {@link UserFactory#createUserFactory()}.
   *
   * <p>Method under test: {@link UserFactory#createUserFactory()}
   */
  @Test
  @DisplayName("Test createUserFactory()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UserFactory UserFactory.createUserFactory()"})
  void testCreateUserFactory() {
    // Arrange and Act
    UserFactory actualCreateUserFactoryResult = UserFactory.createUserFactory();
    User actualCreateUserResult = actualCreateUserFactoryResult.createUser();

    // Assert
    assertTrue(actualCreateUserFactoryResult instanceof UnknownUserFactory);
    User createUserResult = actualCreateUserFactoryResult.createUser();
    assertEquals("UNKNOWN", createUserResult.getUserId());
    Context createContextResult = actualCreateUserFactoryResult.createContext();
    assertNull(createContextResult.getOriginalOpChain());
    assertEquals(1, createUserResult.getOpAuths().size());
    assertTrue(createContextResult.getExporters().isEmpty());
    assertTrue(createContextResult.getVariables().isEmpty());
    assertTrue(createUserResult.getDataAuths().isEmpty());
    assertEquals(createUserResult, actualCreateUserResult);
    assertEquals(createUserResult, createContextResult.getUser());
  }

  /**
   * Test {@link UserFactory#createContext()}.
   *
   * <p>Method under test: {@link UserFactory#createContext()}
   */
  @Test
  @DisplayName("Test createContext()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Context UserFactory.createContext()"})
  void testCreateContext() {
    // Arrange and Act
    Context actualCreateContextResult = new UnknownUserFactory().createContext();

    // Assert
    User user = actualCreateContextResult.getUser();
    assertEquals("UNKNOWN", user.getUserId());
    assertNull(actualCreateContextResult.getOriginalOpChain());
    Set<String> opAuths = user.getOpAuths();
    assertEquals(1, opAuths.size());
    assertTrue(actualCreateContextResult.getExporters().isEmpty());
    assertTrue(actualCreateContextResult.getVariables().isEmpty());
    assertTrue(opAuths.contains("user"));
    assertTrue(user.getDataAuths().isEmpty());
  }
}
