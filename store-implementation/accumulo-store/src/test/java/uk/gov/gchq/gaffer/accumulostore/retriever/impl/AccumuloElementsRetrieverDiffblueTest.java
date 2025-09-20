package uk.gov.gchq.gaffer.accumulostore.retriever.impl;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityKeyPackage;
import uk.gov.gchq.gaffer.accumulostore.key.exception.IteratorSettingException;
import uk.gov.gchq.gaffer.data.element.id.ElementId;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.operation.impl.get.GetElements;
import uk.gov.gchq.gaffer.store.StoreException;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.gaffer.user.User;

class AccumuloElementsRetrieverDiffblueTest {
  /**
   * Test {@link AccumuloElementsRetriever#AccumuloElementsRetriever(AccumuloStore, GetElements,
   * User)}.
   *
   * <ul>
   *   <li>Given {@link Schema#Schema()}.
   *   <li>Then calls {@link AccumuloStore#getKeyPackage()}.
   * </ul>
   *
   * <p>Method under test: {@link AccumuloElementsRetriever#AccumuloElementsRetriever(AccumuloStore,
   * GetElements, User)}
   */
  @Test
  @DisplayName(
      "Test new AccumuloElementsRetriever(AccumuloStore, GetElements, User); given Schema(); then calls getKeyPackage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AccumuloElementsRetriever.<init>(AccumuloStore, GetElements, User)"})
  void testNewAccumuloElementsRetriever_givenSchema_thenCallsGetKeyPackage()
      throws IteratorSettingException, StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(new Schema());
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());

    GetElements operation = mock(GetElements.class);
    Mockito.<Iterable<? extends ElementId>>when(operation.getInput()).thenReturn(new ArrayList<>());
    when(operation.getView()).thenReturn(new View());
    doNothing().when(operation).setInput(Mockito.<Iterable<ElementId>>any());
    operation.setInput(new ArrayList<>());

    // Act
    new AccumuloElementsRetriever(store, operation, new User());

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
    verify(operation, atLeast(1)).getInput();
    verify(operation, atLeast(1)).getView();
    verify(operation).setInput(isA(Iterable.class));
    verify(store, atLeast(1)).getSchema();
  }
}
