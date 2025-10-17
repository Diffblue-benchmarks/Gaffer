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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.accumulostore.AccumuloStore;
import uk.gov.gchq.gaffer.accumulostore.key.core.impl.byteEntity.ByteEntityKeyPackage;
import uk.gov.gchq.gaffer.accumulostore.key.exception.IteratorSettingException;
import uk.gov.gchq.gaffer.data.element.id.EntityId;
import uk.gov.gchq.gaffer.data.elementdefinition.exception.SchemaException;
import uk.gov.gchq.gaffer.data.elementdefinition.view.GlobalViewElementDefinition;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.data.elementdefinition.view.ViewElementDefinition;
import uk.gov.gchq.gaffer.operation.impl.get.GetAdjacentIds;
import uk.gov.gchq.gaffer.store.StoreException;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.gaffer.user.User;

class AccumuloAdjacentIdRetrieverDiffblueTest {
  /**
   * Test {@link AccumuloAdjacentIdRetriever#AccumuloAdjacentIdRetriever(AccumuloStore,
   * GetAdjacentIds, User)}.
   *
   * <p>Method under test: {@link
   * AccumuloAdjacentIdRetriever#AccumuloAdjacentIdRetriever(AccumuloStore, GetAdjacentIds, User)}
   */
  @Test
  @DisplayName("Test new AccumuloAdjacentIdRetriever(AccumuloStore, GetAdjacentIds, User)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccumuloAdjacentIdRetriever.<init>(AccumuloStore, GetAdjacentIds, User)"
  })
  void testNewAccumuloAdjacentIdRetriever()
      throws UnsupportedEncodingException, IteratorSettingException, SchemaException,
          StoreException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.toCompactJson()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage(new Schema()));

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put(
        "Element_Post_Aggregation_Filter", new ViewElementDefinition());

    View view = mock(View.class);
    when(view.toCompactJson()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(view.hasPostAggregationFilters()).thenReturn(true);
    when(view.hasPreAggregationFilters()).thenReturn(false);
    when(view.getEdges()).thenReturn(stringViewElementDefinitionMap);
    when(view.getEntities()).thenReturn(new HashMap<>());
    when(view.getEdgeGroups()).thenReturn(new HashSet<>());
    when(view.getEntityGroups()).thenReturn(new HashSet<>());

    GetAdjacentIds operation = mock(GetAdjacentIds.class);
    org.mockito.Mockito.<Iterable<? extends EntityId>>when(operation.getInput())
        .thenReturn(new ArrayList<>());
    when(operation.getView()).thenReturn(view);

    // Act
    new AccumuloAdjacentIdRetriever(store, operation, new User());

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
    verify(view, atLeast(1)).getEdgeGroups();
    verify(view).getEdges();
    verify(view).getEntities();
    verify(view, atLeast(1)).getEntityGroups();
    verify(view).hasPostAggregationFilters();
    verify(view, atLeast(1)).hasPreAggregationFilters();
    verify(view).toCompactJson();
    verify(operation).getInput();
    verify(operation, atLeast(1)).getView();
    verify(store, atLeast(1)).getSchema();
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schema, atLeast(1)).isAggregationEnabled();
    verify(schema).toCompactJson();
  }

  /**
   * Test {@link AccumuloAdjacentIdRetriever#AccumuloAdjacentIdRetriever(AccumuloStore,
   * GetAdjacentIds, User)}.
   *
   * <p>Method under test: {@link
   * AccumuloAdjacentIdRetriever#AccumuloAdjacentIdRetriever(AccumuloStore, GetAdjacentIds, User)}
   */
  @Test
  @DisplayName("Test new AccumuloAdjacentIdRetriever(AccumuloStore, GetAdjacentIds, User)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccumuloAdjacentIdRetriever.<init>(AccumuloStore, GetAdjacentIds, User)"
  })
  void testNewAccumuloAdjacentIdRetriever2()
      throws UnsupportedEncodingException, IteratorSettingException, SchemaException,
          StoreException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.toCompactJson()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage(new Schema()));

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put("Element_Post_Aggregation_Filter", null);

    View view = mock(View.class);
    when(view.toCompactJson()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(view.hasPostAggregationFilters()).thenReturn(true);
    when(view.hasPreAggregationFilters()).thenReturn(false);
    when(view.getEdges()).thenReturn(stringViewElementDefinitionMap);
    when(view.getEntities()).thenReturn(new HashMap<>());
    when(view.getEdgeGroups()).thenReturn(new HashSet<>());
    when(view.getEntityGroups()).thenReturn(new HashSet<>());

    GetAdjacentIds operation = mock(GetAdjacentIds.class);
    org.mockito.Mockito.<Iterable<? extends EntityId>>when(operation.getInput())
        .thenReturn(new ArrayList<>());
    when(operation.getView()).thenReturn(view);

    // Act
    new AccumuloAdjacentIdRetriever(store, operation, new User());

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
    verify(view, atLeast(1)).getEdgeGroups();
    verify(view).getEdges();
    verify(view).getEntities();
    verify(view, atLeast(1)).getEntityGroups();
    verify(view).hasPostAggregationFilters();
    verify(view, atLeast(1)).hasPreAggregationFilters();
    verify(view).toCompactJson();
    verify(operation).getInput();
    verify(operation, atLeast(1)).getView();
    verify(store, atLeast(1)).getSchema();
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schema, atLeast(1)).isAggregationEnabled();
    verify(schema).toCompactJson();
  }

  /**
   * Test {@link AccumuloAdjacentIdRetriever#AccumuloAdjacentIdRetriever(AccumuloStore,
   * GetAdjacentIds, User)}.
   *
   * <ul>
   *   <li>Given {@link Schema#Schema()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AccumuloAdjacentIdRetriever#AccumuloAdjacentIdRetriever(AccumuloStore, GetAdjacentIds, User)}
   */
  @Test
  @DisplayName(
      "Test new AccumuloAdjacentIdRetriever(AccumuloStore, GetAdjacentIds, User); given Schema()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccumuloAdjacentIdRetriever.<init>(AccumuloStore, GetAdjacentIds, User)"
  })
  void testNewAccumuloAdjacentIdRetriever_givenSchema()
      throws IteratorSettingException, StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(new Schema());
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());

    GetAdjacentIds operation = mock(GetAdjacentIds.class);
    org.mockito.Mockito.<Iterable<? extends EntityId>>when(operation.getInput())
        .thenReturn(new ArrayList<>());
    when(operation.getView()).thenReturn(new View());

    // Act
    new AccumuloAdjacentIdRetriever(store, operation, new User());

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
    verify(operation).getInput();
    verify(operation, atLeast(1)).getView();
    verify(store, atLeast(1)).getSchema();
  }

  /**
   * Test {@link AccumuloAdjacentIdRetriever#AccumuloAdjacentIdRetriever(AccumuloStore,
   * GetAdjacentIds, User)}.
   *
   * <ul>
   *   <li>Given {@link Schema#Schema()}.
   *   <li>When {@code null}.
   *   <li>Then calls {@link AccumuloStore#getKeyPackage()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AccumuloAdjacentIdRetriever#AccumuloAdjacentIdRetriever(AccumuloStore, GetAdjacentIds, User)}
   */
  @Test
  @DisplayName(
      "Test new AccumuloAdjacentIdRetriever(AccumuloStore, GetAdjacentIds, User); given Schema(); when 'null'; then calls getKeyPackage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccumuloAdjacentIdRetriever.<init>(AccumuloStore, GetAdjacentIds, User)"
  })
  void testNewAccumuloAdjacentIdRetriever_givenSchema_whenNull_thenCallsGetKeyPackage()
      throws IteratorSettingException, StoreException {
    // Arrange
    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(new Schema());
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());

    GetAdjacentIds operation = mock(GetAdjacentIds.class);
    org.mockito.Mockito.<Iterable<? extends EntityId>>when(operation.getInput())
        .thenReturn(new ArrayList<>());
    when(operation.getView()).thenReturn(new View());

    // Act
    new AccumuloAdjacentIdRetriever(store, operation, null);

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
    verify(operation).getInput();
    verify(operation, atLeast(1)).getView();
    verify(store, atLeast(1)).getSchema();
  }

  /**
   * Test {@link AccumuloAdjacentIdRetriever#AccumuloAdjacentIdRetriever(AccumuloStore,
   * GetAdjacentIds, User)}.
   *
   * <ul>
   *   <li>Given {@link View} (default constructor).
   *   <li>When {@link GetAdjacentIds} {@link GetAdjacentIds#getView()} return {@link View} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * AccumuloAdjacentIdRetriever#AccumuloAdjacentIdRetriever(AccumuloStore, GetAdjacentIds, User)}
   */
  @Test
  @DisplayName(
      "Test new AccumuloAdjacentIdRetriever(AccumuloStore, GetAdjacentIds, User); given View (default constructor); when GetAdjacentIds getView() return View (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccumuloAdjacentIdRetriever.<init>(AccumuloStore, GetAdjacentIds, User)"
  })
  void testNewAccumuloAdjacentIdRetriever_givenView_whenGetAdjacentIdsGetViewReturnView()
      throws IteratorSettingException, StoreException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage());

    GetAdjacentIds operation = mock(GetAdjacentIds.class);
    org.mockito.Mockito.<Iterable<? extends EntityId>>when(operation.getInput())
        .thenReturn(new ArrayList<>());
    when(operation.getView()).thenReturn(new View());

    // Act
    new AccumuloAdjacentIdRetriever(store, operation, new User());

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
    verify(operation).getInput();
    verify(operation, atLeast(1)).getView();
    verify(store, atLeast(1)).getSchema();
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schema, atLeast(1)).isAggregationEnabled();
  }

  /**
   * Test {@link AccumuloAdjacentIdRetriever#AccumuloAdjacentIdRetriever(AccumuloStore,
   * GetAdjacentIds, User)}.
   *
   * <ul>
   *   <li>Then calls {@link View#getEdgeGroups()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AccumuloAdjacentIdRetriever#AccumuloAdjacentIdRetriever(AccumuloStore, GetAdjacentIds, User)}
   */
  @Test
  @DisplayName(
      "Test new AccumuloAdjacentIdRetriever(AccumuloStore, GetAdjacentIds, User); then calls getEdgeGroups()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccumuloAdjacentIdRetriever.<init>(AccumuloStore, GetAdjacentIds, User)"
  })
  void testNewAccumuloAdjacentIdRetriever_thenCallsGetEdgeGroups()
      throws UnsupportedEncodingException, IteratorSettingException, SchemaException,
          StoreException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.toCompactJson()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage(new Schema()));

    View view = mock(View.class);
    when(view.toCompactJson()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(view.hasPostAggregationFilters()).thenReturn(true);
    when(view.hasPreAggregationFilters()).thenReturn(false);
    when(view.getEdges()).thenReturn(new HashMap<>());
    when(view.getEntities()).thenReturn(new HashMap<>());
    when(view.getEdgeGroups()).thenReturn(new HashSet<>());
    when(view.getEntityGroups()).thenReturn(new HashSet<>());

    GetAdjacentIds operation = mock(GetAdjacentIds.class);
    org.mockito.Mockito.<Iterable<? extends EntityId>>when(operation.getInput())
        .thenReturn(new ArrayList<>());
    when(operation.getView()).thenReturn(view);

    // Act
    new AccumuloAdjacentIdRetriever(store, operation, new User());

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
    verify(view, atLeast(1)).getEdgeGroups();
    verify(view).getEdges();
    verify(view).getEntities();
    verify(view, atLeast(1)).getEntityGroups();
    verify(view).hasPostAggregationFilters();
    verify(view, atLeast(1)).hasPreAggregationFilters();
    verify(view).toCompactJson();
    verify(operation).getInput();
    verify(operation, atLeast(1)).getView();
    verify(store, atLeast(1)).getSchema();
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schema, atLeast(1)).isAggregationEnabled();
    verify(schema).toCompactJson();
  }

  /**
   * Test {@link AccumuloAdjacentIdRetriever#AccumuloAdjacentIdRetriever(AccumuloStore,
   * GetAdjacentIds, User)}.
   *
   * <ul>
   *   <li>Then calls {@link GlobalViewElementDefinition#hasPostTransformFilters()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AccumuloAdjacentIdRetriever#AccumuloAdjacentIdRetriever(AccumuloStore, GetAdjacentIds, User)}
   */
  @Test
  @DisplayName(
      "Test new AccumuloAdjacentIdRetriever(AccumuloStore, GetAdjacentIds, User); then calls hasPostTransformFilters()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AccumuloAdjacentIdRetriever.<init>(AccumuloStore, GetAdjacentIds, User)"
  })
  void testNewAccumuloAdjacentIdRetriever_thenCallsHasPostTransformFilters()
      throws UnsupportedEncodingException, IteratorSettingException, SchemaException,
          StoreException {
    // Arrange
    Schema schema = mock(Schema.class);
    when(schema.toCompactJson()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(schema.getVisibilityProperty()).thenReturn("Visibility Property");
    when(schema.isAggregationEnabled()).thenReturn(true);

    AccumuloStore store = mock(AccumuloStore.class);
    when(store.getSchema()).thenReturn(schema);
    when(store.getKeyPackage()).thenReturn(new ByteEntityKeyPackage(new Schema()));

    GlobalViewElementDefinition globalViewElementDefinition =
        mock(GlobalViewElementDefinition.class);
    when(globalViewElementDefinition.hasPostTransformFilters()).thenReturn(true);

    HashMap<String, ViewElementDefinition> stringViewElementDefinitionMap = new HashMap<>();
    stringViewElementDefinitionMap.put(
        "Element_Post_Aggregation_Filter", globalViewElementDefinition);

    View view = mock(View.class);
    when(view.toCompactJson()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    when(view.hasPostAggregationFilters()).thenReturn(true);
    when(view.hasPreAggregationFilters()).thenReturn(false);
    when(view.getEdges()).thenReturn(stringViewElementDefinitionMap);
    when(view.getEntities()).thenReturn(new HashMap<>());
    when(view.getEdgeGroups()).thenReturn(new HashSet<>());
    when(view.getEntityGroups()).thenReturn(new HashSet<>());

    GetAdjacentIds operation = mock(GetAdjacentIds.class);
    org.mockito.Mockito.<Iterable<? extends EntityId>>when(operation.getInput())
        .thenReturn(new ArrayList<>());
    when(operation.getView()).thenReturn(view);

    // Act
    new AccumuloAdjacentIdRetriever(store, operation, new User());

    // Assert
    verify(store, atLeast(1)).getKeyPackage();
    verify(view, atLeast(1)).getEdgeGroups();
    verify(view).getEdges();
    verify(view).getEntities();
    verify(view, atLeast(1)).getEntityGroups();
    verify(view).hasPostAggregationFilters();
    verify(view, atLeast(1)).hasPreAggregationFilters();
    verify(view).toCompactJson();
    verify(globalViewElementDefinition).hasPostTransformFilters();
    verify(operation).getInput();
    verify(operation, atLeast(1)).getView();
    verify(store, atLeast(1)).getSchema();
    verify(schema, atLeast(1)).getVisibilityProperty();
    verify(schema, atLeast(1)).isAggregationEnabled();
    verify(schema).toCompactJson();
  }
}
