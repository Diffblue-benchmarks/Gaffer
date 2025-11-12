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

package uk.gov.gchq.gaffer.rest.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class ExampleDomainObjectDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ExampleDomainObject#ExampleDomainObject()}
   *   <li>{@link ExampleDomainObject#setIds(Object[])}
   *   <li>{@link ExampleDomainObject#setType(String)}
   *   <li>{@link ExampleDomainObject#getIds()}
   *   <li>{@link ExampleDomainObject#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ExampleDomainObject actualExampleDomainObject = new ExampleDomainObject();
    Object[] ids = new Object[]{"Ids"};
    actualExampleDomainObject.setIds(ids);
    actualExampleDomainObject.setType("Type");
    Object[] actualIds = actualExampleDomainObject.getIds();

    // Assert that nothing has changed
    assertEquals("Ids", actualIds[0]);
    assertEquals("Type", actualExampleDomainObject.getType());
    assertEquals(1, actualIds.length);
    assertSame(ids, actualIds);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ExampleDomainObject#ExampleDomainObject(String, Object[])}
   *   <li>{@link ExampleDomainObject#setIds(Object[])}
   *   <li>{@link ExampleDomainObject#setType(String)}
   *   <li>{@link ExampleDomainObject#getIds()}
   *   <li>{@link ExampleDomainObject#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    ExampleDomainObject actualExampleDomainObject = new ExampleDomainObject("Type", "Ids");
    Object[] ids = new Object[]{"Ids"};
    actualExampleDomainObject.setIds(ids);
    actualExampleDomainObject.setType("Type");
    Object[] actualIds = actualExampleDomainObject.getIds();

    // Assert that nothing has changed
    assertEquals("Ids", actualIds[0]);
    assertEquals("Type", actualExampleDomainObject.getType());
    assertEquals(1, actualIds.length);
    assertSame(ids, actualIds);
  }
}
