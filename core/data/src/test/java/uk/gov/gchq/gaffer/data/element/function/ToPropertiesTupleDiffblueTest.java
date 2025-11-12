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

package uk.gov.gchq.gaffer.data.element.function;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Properties;

class ToPropertiesTupleDiffblueTest {
  /**
   * Method under test: {@link ToPropertiesTuple#apply(Properties)}
   */
  @Test
  void testApply() {
    // Arrange
    ToPropertiesTuple toPropertiesTuple = new ToPropertiesTuple();
    Properties properties = new Properties();

    // Act and Assert
    Properties properties2 = toPropertiesTuple.apply(properties).getProperties();
    assertTrue(properties2.isEmpty());
    assertSame(properties, properties2);
  }

  /**
   * Method under test: {@link ToPropertiesTuple#apply(Properties)}
   */
  @Test
  void testApply2() {
    // Arrange
    ToPropertiesTuple toPropertiesTuple = new ToPropertiesTuple();

    Properties properties = new Properties();
    properties.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    Properties properties2 = toPropertiesTuple.apply(properties).getProperties();
    assertTrue(properties2.isEmpty());
    assertSame(properties, properties2);
  }
}
