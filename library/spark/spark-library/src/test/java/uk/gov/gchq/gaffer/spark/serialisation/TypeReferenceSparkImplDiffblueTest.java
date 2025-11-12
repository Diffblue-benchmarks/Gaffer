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

package uk.gov.gchq.gaffer.spark.serialisation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TypeReferenceSparkImplDiffblueTest {
  /**
   * Method under test: default or parameterless constructor of
   * {@link TypeReferenceSparkImpl.DataSetRow}
   */
  @Test
  void testDataSetRowNewDataSetRow() {
    // Arrange, Act and Assert
    assertEquals("org.apache.spark.sql.Dataset<org.apache.spark.sql.Row>",
        (new TypeReferenceSparkImpl.DataSetRow()).getType().getTypeName());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link TypeReferenceSparkImpl.IterableRowT}
   */
  @Test
  void testIterableRowTNewIterableRowT() {
    // Arrange, Act and Assert
    assertEquals("java.lang.Iterable<? extends org.apache.spark.sql.Row>",
        (new TypeReferenceSparkImpl.IterableRowT()).getType().getTypeName());
  }
}
