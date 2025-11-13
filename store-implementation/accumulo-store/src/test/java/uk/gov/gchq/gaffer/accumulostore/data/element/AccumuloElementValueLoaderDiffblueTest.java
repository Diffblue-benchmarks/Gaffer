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

package uk.gov.gchq.gaffer.accumulostore.data.element;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.apache.accumulo.core.data.Key;
import org.apache.accumulo.core.data.Value;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityAccumuloElementConverter;
import uk.gov.gchq.gaffer.data.element.Properties;
import uk.gov.gchq.gaffer.store.schema.Schema;

class AccumuloElementValueLoaderDiffblueTest {
  /**
   * Test {@link AccumuloElementValueLoader#getProperty(String, Properties)}.
   * <p>
   * Method under test: {@link AccumuloElementValueLoader#getProperty(String, Properties)}
   */
  @Test
  @DisplayName("Test getProperty(String, Properties)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Object AccumuloElementValueLoader.getProperty(String, Properties)"})
  void testGetProperty() {
    // Arrange
    Key key = new Key();
    Value value = new Value();
    ByteEntityAccumuloElementConverter elementConverter = new ByteEntityAccumuloElementConverter(new Schema());
    AccumuloEntityValueLoader accumuloEntityValueLoader = new AccumuloEntityValueLoader("Group", key, value,
        elementConverter, new Schema());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> accumuloEntityValueLoader.getProperty("Name", new Properties()));
  }
}
