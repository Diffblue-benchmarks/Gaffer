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
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.store.Context;

class Log4jLoggerDiffblueTest {
  /**
   * Method under test:
   * {@link Log4jLogger#postExecute(Object, OperationChain, Context)}
   */
  @Test
  void testPostExecute() {
    // Arrange
    Log4jLogger log4jLogger = new Log4jLogger();
    OperationChain<?> operationChain = new OperationChain<>();

    // Act and Assert
    assertEquals("Result", log4jLogger.postExecute("Result", operationChain, new Context()));
  }

  /**
   * Method under test:
   * {@link Log4jLogger#onFailure(Object, OperationChain, Context, Exception)}
   */
  @Test
  void testOnFailure() {
    // Arrange
    Log4jLogger log4jLogger = new Log4jLogger();
    OperationChain<?> opChain = new OperationChain<>();
    Context context = new Context();

    // Act and Assert
    assertEquals("Result", log4jLogger.onFailure("Result", opChain, context, new Exception("foo")));
  }

  /**
   * Method under test:
   * {@link Log4jLogger#onFailure(Object, OperationChain, Context, Exception)}
   */
  @Test
  void testOnFailure2() {
    // Arrange
    Log4jLogger log4jLogger = new Log4jLogger();
    OperationChain<?> opChain = new OperationChain<>();

    Context context = new Context();
    context.setOriginalOpChain(new OperationChain<>());

    // Act and Assert
    assertEquals("Result", log4jLogger.onFailure("Result", opChain, context, new Exception("foo")));
  }
}
