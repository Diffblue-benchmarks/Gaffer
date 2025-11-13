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

package uk.gov.gchq.gaffer.accumulostore.retriever.impl;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityKeyPackage;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.classic.ClassicKeyPackage;
import uk.gov.gchq.gaffer.accumulostore.key.exception.IteratorSettingException;
import uk.gov.gchq.gaffer.data.element.id.DirectedType;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.operation.impl.get.GetAllElements;
import uk.gov.gchq.gaffer.store.StoreException;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.gaffer.user.User;

class AccumuloAllElementsRetrieverDiffblueTest {
  /**
   * Test {@link AccumuloAllElementsRetriever#AccumuloAllElementsRetriever(AccumuloStore, GetAllElements, User)}.
   * <ul>
   *   <li>Given {@link ClassicKeyPackage#ClassicKeyPackage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloAllElementsRetriever#AccumuloAllElementsRetriever(AccumuloStore, GetAllElements, User)}
   */
  @Test
  @DisplayName("Test new AccumuloAllElementsRetriever(AccumuloStore, GetAllElements, User); given ClassicKeyPackage()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloAllElementsRetriever.<init>(AccumuloStore, GetAllElements, User)"})
  void testNewAccumuloAllElementsRetriever_givenClassicKeyPackage() throws IteratorSettingException, StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(new Schema());
    when(store.getKeyPackage()).thenReturn(new ClassicKeyPackage());
    GetAllElements operation = mock(GetAllElements.class);
    when(operation.getDirectedType()).thenReturn(DirectedType.EITHER);
    when(operation.getView()).thenReturn(new View());

    // Act
    new AccumuloAllElementsRetriever(store, operation, new User());

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
    verify(operation).getDirectedType();
    verify(operation, atLeast(1)).getView();
    verify(store, atLeast(1)).getSchema();
  }

  /**
   * Test {@link AccumuloAllElementsRetriever#AccumuloAllElementsRetriever(AccumuloStore, GetAllElements, User)}.
   * <ul>
   *   <li>Given {@link View} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link AccumuloAllElementsRetriever#AccumuloAllElementsRetriever(AccumuloStore, GetAllElements, User)}
   */
  @Test
  @DisplayName("Test new AccumuloAllElementsRetriever(AccumuloStore, GetAllElements, User); given View (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AccumuloAllElementsRetriever.<init>(AccumuloStore, GetAllElements, User)"})
  void testNewAccumuloAllElementsRetriever_givenView() throws IteratorSettingException, StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(new Schema());
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());
    GetAllElements operation = mock(GetAllElements.class);
    when(operation.getDirectedType()).thenReturn(DirectedType.EITHER);
    when(operation.getView()).thenReturn(new View());

    // Act
    new AccumuloAllElementsRetriever(store, operation, new User());

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
    verify(operation).getDirectedType();
    verify(operation, atLeast(1)).getView();
    verify(store, atLeast(1)).getSchema();
  }
}
