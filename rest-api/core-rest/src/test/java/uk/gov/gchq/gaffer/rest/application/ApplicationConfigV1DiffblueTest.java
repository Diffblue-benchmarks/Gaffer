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

package uk.gov.gchq.gaffer.rest.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import javax.ws.rs.RuntimeType;
import javax.ws.rs.core.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ApplicationConfigV1DiffblueTest {
  /**
   * Test new {@link ApplicationConfigV1} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link ApplicationConfigV1}
   */
  @Test
  @DisplayName("Test new ApplicationConfigV1 (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ApplicationConfigV1.<init>()"})
  void testNewApplicationConfigV1() {
    // Arrange and Act
    ApplicationConfigV1 actualApplicationConfigV1 = new ApplicationConfigV1();

    // Assert
    assertNull(actualApplicationConfigV1.getApplicationName());
    Set<Object> instances = actualApplicationConfigV1.getInstances();
    assertEquals(1, instances.size());
    assertEquals(15, actualApplicationConfigV1.resources.size());
    assertEquals(RuntimeType.SERVER, actualApplicationConfigV1.getRuntimeType());
    assertTrue(actualApplicationConfigV1.getPropertyNames().isEmpty());
    assertTrue(actualApplicationConfigV1.getProperties().isEmpty());
    assertTrue(actualApplicationConfigV1.getResources().isEmpty());
    Set<Class<?>> expectedClasses = actualApplicationConfigV1.resources;
    assertEquals(expectedClasses, actualApplicationConfigV1.getClasses());
    Application actualApplication = actualApplicationConfigV1.getApplication();
    assertSame(actualApplicationConfigV1, actualApplication);
    assertSame(instances, actualApplicationConfigV1.getSingletons());
  }
}
