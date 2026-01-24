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

package uk.gov.gchq.gaffer.rest.factory.spring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import uk.gov.gchq.gaffer.user.User;

@ContextConfiguration(classes = {UnknownUserFactory.class})
@ExtendWith(SpringExtension.class)
class UnknownUserFactoryDiffblueTest {
  @Autowired private UnknownUserFactory unknownUserFactory;

  /**
   * Test {@link UnknownUserFactory#createUser()}.
   *
   * <p>Method under test: {@link UnknownUserFactory#createUser()}
   */
  @Test
  @DisplayName("Test createUser()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"User UnknownUserFactory.createUser()"})
  void testCreateUser() {
    // Arrange and Act
    User actualCreateUserResult = unknownUserFactory.createUser();

    // Assert
    assertEquals("UNKNOWN", actualCreateUserResult.getUserId());
    Set<String> opAuths = actualCreateUserResult.getOpAuths();
    assertEquals(1, opAuths.size());
    assertTrue(opAuths.contains("user"));
    assertTrue(actualCreateUserResult.getDataAuths().isEmpty());
  }

  /**
   * Test new {@link UnknownUserFactory} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link UnknownUserFactory}
   */
  @Test
  @DisplayName("Test new UnknownUserFactory (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void UnknownUserFactory.<init>()"})
  void testNewUnknownUserFactory() {
    // Arrange, Act and Assert
    assertNull(new UnknownUserFactory().httpHeaders);
  }
}
