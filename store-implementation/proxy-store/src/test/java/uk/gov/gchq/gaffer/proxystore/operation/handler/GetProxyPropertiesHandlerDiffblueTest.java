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

package uk.gov.gchq.gaffer.proxystore.operation.handler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import java.util.Properties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.mapstore.MapStoreProperties;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.proxystore.ProxyProperties;
import uk.gov.gchq.gaffer.proxystore.operation.GetProxyProperties;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.Store;
import uk.gov.gchq.gaffer.store.StoreProperties;

class GetProxyPropertiesHandlerDiffblueTest {
  /**
   * Test {@link GetProxyPropertiesHandler#doOperation(GetProxyProperties, Context, Store)} with
   * {@code GetProxyProperties}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link MapStoreProperties#MapStoreProperties()}.
   * </ul>
   *
   * <p>Method under test: {@link GetProxyPropertiesHandler#doOperation(GetProxyProperties, Context,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetProxyProperties, Context, Store) with 'GetProxyProperties', 'Context', 'Store'; given MapStoreProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map GetProxyPropertiesHandler.doOperation(GetProxyProperties, Context, Store)"
  })
  void testDoOperationWithGetProxyPropertiesContextStore_givenMapStoreProperties()
      throws OperationException {
    // Arrange
    GetProxyPropertiesHandler getProxyPropertiesHandler = new GetProxyPropertiesHandler();
    GetProxyProperties operation = new GetProxyProperties();
    Context context = new Context();

    Store store = mock(Store.class);
    when(store.getProperties()).thenReturn(new MapStoreProperties());

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> getProxyPropertiesHandler.doOperation(operation, context, store));
    verify(store).getProperties();
  }

  /**
   * Test {@link GetProxyPropertiesHandler#doOperation(GetProxyProperties, Context, Store)} with
   * {@code GetProxyProperties}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link ProxyProperties#ProxyProperties()}.
   * </ul>
   *
   * <p>Method under test: {@link GetProxyPropertiesHandler#doOperation(GetProxyProperties, Context,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetProxyProperties, Context, Store) with 'GetProxyProperties', 'Context', 'Store'; given ProxyProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map GetProxyPropertiesHandler.doOperation(GetProxyProperties, Context, Store)"
  })
  void testDoOperationWithGetProxyPropertiesContextStore_givenProxyProperties()
      throws OperationException {
    // Arrange
    GetProxyPropertiesHandler getProxyPropertiesHandler = new GetProxyPropertiesHandler();
    GetProxyProperties operation = new GetProxyProperties();
    Context context = new Context();

    Store store = mock(Store.class);
    when(store.getProperties()).thenReturn(new ProxyProperties());

    // Act
    Map<String, Object> actualDoOperationResult =
        getProxyPropertiesHandler.doOperation(operation, context, store);

    // Assert
    verify(store).getProperties();
    assertEquals(6, actualDoOperationResult.size());
    assertEquals("/rest", actualDoOperationResult.get("gaffer.context-root"));
    assertEquals("10000", actualDoOperationResult.get("gaffer.connect-timeout"));
    assertEquals("10000", actualDoOperationResult.get("gaffer.read-timeout"));
    assertEquals("8080", actualDoOperationResult.get("gaffer.port"));
    assertEquals(
        "http://localhost:8080/rest",
        actualDoOperationResult.get(GetProxyPropertiesHandler.URL_INFERRED));
    assertEquals("localhost", actualDoOperationResult.get("gaffer.host"));
  }

  /**
   * Test {@link GetProxyPropertiesHandler#doOperation(GetProxyProperties, Context, Store)} with
   * {@code GetProxyProperties}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link GetProxyPropertiesHandler#doOperation(GetProxyProperties, Context,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetProxyProperties, Context, Store) with 'GetProxyProperties', 'Context', 'Store'; given RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map GetProxyPropertiesHandler.doOperation(GetProxyProperties, Context, Store)"
  })
  void testDoOperationWithGetProxyPropertiesContextStore_givenRuntimeException()
      throws OperationException {
    // Arrange
    GetProxyPropertiesHandler getProxyPropertiesHandler = new GetProxyPropertiesHandler();
    GetProxyProperties operation = new GetProxyProperties();
    Context context = new Context();

    Store store = mock(Store.class);
    when(store.getProperties()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        OperationException.class,
        () -> getProxyPropertiesHandler.doOperation(operation, context, store));
    verify(store).getProperties();
  }

  /**
   * Test {@link GetProxyPropertiesHandler#doOperation(GetProxyProperties, Context, Store)} with
   * {@code GetProxyProperties}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Given {@link StoreProperties#StoreProperties()}.
   * </ul>
   *
   * <p>Method under test: {@link GetProxyPropertiesHandler#doOperation(GetProxyProperties, Context,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetProxyProperties, Context, Store) with 'GetProxyProperties', 'Context', 'Store'; given StoreProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map GetProxyPropertiesHandler.doOperation(GetProxyProperties, Context, Store)"
  })
  void testDoOperationWithGetProxyPropertiesContextStore_givenStoreProperties()
      throws OperationException {
    // Arrange
    GetProxyPropertiesHandler getProxyPropertiesHandler = new GetProxyPropertiesHandler();
    GetProxyProperties operation = new GetProxyProperties();
    Context context = new Context();

    Store store = mock(Store.class);
    when(store.getProperties()).thenReturn(new StoreProperties());

    // Act
    Map<String, Object> actualDoOperationResult =
        getProxyPropertiesHandler.doOperation(operation, context, store);

    // Assert
    verify(store).getProperties();
    assertEquals(6, actualDoOperationResult.size());
    assertEquals("/rest", actualDoOperationResult.get("gaffer.context-root"));
    assertEquals("10000", actualDoOperationResult.get("gaffer.connect-timeout"));
    assertEquals("10000", actualDoOperationResult.get("gaffer.read-timeout"));
    assertEquals("8080", actualDoOperationResult.get("gaffer.port"));
    assertEquals(
        "http://localhost:8080/rest",
        actualDoOperationResult.get(GetProxyPropertiesHandler.URL_INFERRED));
    assertEquals("localhost", actualDoOperationResult.get("gaffer.host"));
  }

  /**
   * Test {@link GetProxyPropertiesHandler#doOperation(GetProxyProperties, Context, Store)} with
   * {@code GetProxyProperties}, {@code Context}, {@code Store}.
   *
   * <ul>
   *   <li>Then calls {@link StoreProperties#getProperties()}.
   * </ul>
   *
   * <p>Method under test: {@link GetProxyPropertiesHandler#doOperation(GetProxyProperties, Context,
   * Store)}
   */
  @Test
  @DisplayName(
      "Test doOperation(GetProxyProperties, Context, Store) with 'GetProxyProperties', 'Context', 'Store'; then calls getProperties()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map GetProxyPropertiesHandler.doOperation(GetProxyProperties, Context, Store)"
  })
  void testDoOperationWithGetProxyPropertiesContextStore_thenCallsGetProperties()
      throws OperationException {
    // Arrange
    GetProxyPropertiesHandler getProxyPropertiesHandler = new GetProxyPropertiesHandler();
    GetProxyProperties operation = new GetProxyProperties();
    Context context = new Context();

    StoreProperties storeProperties = mock(StoreProperties.class);
    when(storeProperties.getProperties()).thenReturn(new Properties());

    Store store = mock(Store.class);
    when(store.getProperties()).thenReturn(storeProperties);

    // Act
    Map<String, Object> actualDoOperationResult =
        getProxyPropertiesHandler.doOperation(operation, context, store);

    // Assert
    verify(store).getProperties();
    verify(storeProperties).getProperties();
    assertEquals(6, actualDoOperationResult.size());
    assertEquals("/rest", actualDoOperationResult.get("gaffer.context-root"));
    assertEquals("10000", actualDoOperationResult.get("gaffer.connect-timeout"));
    assertEquals("10000", actualDoOperationResult.get("gaffer.read-timeout"));
    assertEquals("8080", actualDoOperationResult.get("gaffer.port"));
    assertEquals(
        "http://localhost:8080/rest",
        actualDoOperationResult.get(GetProxyPropertiesHandler.URL_INFERRED));
    assertEquals("localhost", actualDoOperationResult.get("gaffer.host"));
  }
}
