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

package uk.gov.gchq.gaffer.rest.factory.spring;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AbstractUserFactory.class})
@ExtendWith(SpringExtension.class)
class AbstractUserFactoryDiffblueTest {
  @Autowired
  private AbstractUserFactory abstractUserFactory;

  /**
   * Test {@link AbstractUserFactory#createUser()}.
   * <p>
   * Method under test: {@link AbstractUserFactory#createUser()}
   */
  @Test
  @DisplayName("Test createUser()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"uk.gov.gchq.gaffer.user.User AbstractUserFactory.createUser()"})
  void testCreateUser() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> abstractUserFactory.createUser());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AbstractUserFactory}
   *   <li>{@link AbstractUserFactory#setHttpHeaders(HttpHeaders)}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractUserFactory.<init>()", "void AbstractUserFactory.setHttpHeaders(HttpHeaders)"})
  void testGettersAndSetters() {
    // Arrange and Act
    AbstractUserFactory actualAbstractUserFactory = new AbstractUserFactory();
    actualAbstractUserFactory.setHttpHeaders(new HttpHeaders());

    // Assert
    assertTrue(actualAbstractUserFactory.httpHeaders.isEmpty());
  }
}
