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

package uk.gov.gchq.gaffer.graph.hook;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.Operation;

class AdditionalOperationsDiffblueTest {
  /**
   * Method under test: {@link AdditionalOperations#getStart()}
   */
  @Test
  void testGetStart() {
    // Arrange, Act and Assert
    assertTrue((new AdditionalOperations()).getStart().isEmpty());
  }

  /**
   * Method under test: {@link AdditionalOperations#getStart()}
   */
  @Test
  void testGetStart2() {
    // Arrange
    ArrayList<Operation> start = new ArrayList<>();
    start.add(null);

    AdditionalOperations additionalOperations = new AdditionalOperations();
    additionalOperations.setAfter(new HashMap<>());
    additionalOperations.setBefore(new HashMap<>());
    additionalOperations.setEnd(new ArrayList<>());
    additionalOperations.setStart(start);

    // Act
    List<Operation> actualStart = additionalOperations.getStart();

    // Assert
    assertEquals(1, actualStart.size());
    assertNull(actualStart.get(0));
  }

  /**
   * Method under test: {@link AdditionalOperations#getEnd()}
   */
  @Test
  void testGetEnd() {
    // Arrange, Act and Assert
    assertTrue((new AdditionalOperations()).getEnd().isEmpty());
  }

  /**
   * Method under test: {@link AdditionalOperations#getEnd()}
   */
  @Test
  void testGetEnd2() {
    // Arrange
    ArrayList<Operation> end = new ArrayList<>();
    end.add(null);

    AdditionalOperations additionalOperations = new AdditionalOperations();
    additionalOperations.setAfter(new HashMap<>());
    additionalOperations.setBefore(new HashMap<>());
    additionalOperations.setStart(new ArrayList<>());
    additionalOperations.setEnd(end);

    // Act
    List<Operation> actualEnd = additionalOperations.getEnd();

    // Assert
    assertEquals(1, actualEnd.size());
    assertNull(actualEnd.get(0));
  }

  /**
   * Method under test: {@link AdditionalOperations#getBefore()}
   */
  @Test
  void testGetBefore() {
    // Arrange, Act and Assert
    assertTrue((new AdditionalOperations()).getBefore().isEmpty());
  }

  /**
   * Method under test: {@link AdditionalOperations#getAfter()}
   */
  @Test
  void testGetAfter() {
    // Arrange, Act and Assert
    assertTrue((new AdditionalOperations()).getAfter().isEmpty());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link AdditionalOperations}
   */
  @Test
  void testNewAdditionalOperations() {
    // Arrange and Act
    AdditionalOperations actualAdditionalOperations = new AdditionalOperations();

    // Assert
    List<Operation> end = actualAdditionalOperations.getEnd();
    assertTrue(end.isEmpty());
    Map<String, List<Operation>> after = actualAdditionalOperations.getAfter();
    assertTrue(after.isEmpty());
    assertSame(after, actualAdditionalOperations.getBefore());
    assertSame(end, actualAdditionalOperations.getStart());
  }
}
