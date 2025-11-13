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

package uk.gov.gchq.gaffer.proxystore;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.core.exception.GafferRuntimeException;
import uk.gov.gchq.gaffer.data.element.Element;
import uk.gov.gchq.gaffer.data.element.id.EntityId;
import uk.gov.gchq.gaffer.exception.SerialisationException;
import uk.gov.gchq.gaffer.named.operation.AddNamedOperation;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.OperationChain;
import uk.gov.gchq.gaffer.operation.OperationException;
import uk.gov.gchq.gaffer.operation.impl.add.AddElements;
import uk.gov.gchq.gaffer.operation.impl.delete.DeleteElements;
import uk.gov.gchq.gaffer.operation.impl.get.GetAdjacentIds;
import uk.gov.gchq.gaffer.operation.impl.get.GetAllElements;
import uk.gov.gchq.gaffer.operation.impl.get.GetElements;
import uk.gov.gchq.gaffer.operation.serialisation.TypeReferenceImpl;
import uk.gov.gchq.gaffer.proxystore.ProxyStore.Builder;
import uk.gov.gchq.gaffer.proxystore.response.deserialiser.ResponseDeserialiser;
import uk.gov.gchq.gaffer.proxystore.response.deserialiser.impl.DefaultResponseDeserialiser;
import uk.gov.gchq.gaffer.proxystore.response.deserialiser.impl.OperationsResponseDeserialiser;
import uk.gov.gchq.gaffer.serialisation.Serialiser;
import uk.gov.gchq.gaffer.serialisation.ToBytesSerialiser;
import uk.gov.gchq.gaffer.store.Context;
import uk.gov.gchq.gaffer.store.StoreException;
import uk.gov.gchq.gaffer.store.StoreProperties;
import uk.gov.gchq.gaffer.store.StoreTrait;
import uk.gov.gchq.gaffer.store.operation.DeleteAllData;
import uk.gov.gchq.gaffer.store.operation.GetTraits;
import uk.gov.gchq.gaffer.store.operation.handler.OperationHandler;
import uk.gov.gchq.gaffer.store.operation.handler.OutputOperationHandler;
import uk.gov.gchq.gaffer.store.schema.Schema;
import uk.gov.gchq.gaffer.user.User;

class ProxyStoreDiffblueTest {
  /**
   * Test Builder {@link Builder#connectTimeout(int)}.
   * <p>
   * Method under test: {@link Builder#connectTimeout(int)}
   */
  @Test
  @DisplayName("Test Builder connectTimeout(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.connectTimeout(int)"})
  void testBuilderConnectTimeout() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.connectTimeout(10));
  }

  /**
   * Test Builder {@link Builder#contextRoot(String)}.
   * <ul>
   *   <li>When {@code Context Root}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#contextRoot(String)}
   */
  @Test
  @DisplayName("Test Builder contextRoot(String); when 'Context Root'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.contextRoot(String)"})
  void testBuilderContextRoot_whenContextRoot() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.contextRoot("Context Root"));
  }

  /**
   * Test Builder {@link Builder#contextRoot(String)}.
   * <ul>
   *   <li>When empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#contextRoot(String)}
   */
  @Test
  @DisplayName("Test Builder contextRoot(String); when empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.contextRoot(String)"})
  void testBuilderContextRoot_whenEmptyString() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.contextRoot(""));
  }

  /**
   * Test Builder {@link Builder#contextRoot(String)}.
   * <ul>
   *   <li>When {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#contextRoot(String)}
   */
  @Test
  @DisplayName("Test Builder contextRoot(String); when '/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.contextRoot(String)"})
  void testBuilderContextRoot_whenSlash() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.contextRoot("/"));
  }

  /**
   * Test Builder {@link Builder#host(String)}.
   * <p>
   * Method under test: {@link Builder#host(String)}
   */
  @Test
  @DisplayName("Test Builder host(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.host(String)"})
  void testBuilderHost() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.host(ProxyProperties.DEFAULT_GAFFER_HOST));
  }

  /**
   * Test Builder {@link Builder#port(int)}.
   * <p>
   * Method under test: {@link Builder#port(int)}
   */
  @Test
  @DisplayName("Test Builder port(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.port(int)"})
  void testBuilderPort() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.port(ProxyProperties.DEFAULT_GAFFER_PORT));
  }

  /**
   * Test Builder {@link Builder#readTimeout(int)}.
   * <p>
   * Method under test: {@link Builder#readTimeout(int)}
   */
  @Test
  @DisplayName("Test Builder readTimeout(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.readTimeout(int)"})
  void testBuilderReadTimeout() {
    // Arrange
    Builder builder = new Builder();

    // Act and Assert
    assertSame(builder, builder.readTimeout(10));
  }

  /**
   * Test new {@link ProxyStore} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link ProxyStore}
   */
  @Test
  @DisplayName("Test new ProxyStore (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ProxyStore.<init>()"})
  void testNewProxyStore() {
    // Arrange and Act
    ProxyStore actualProxyStore = new ProxyStore();

    // Assert
    assertTrue(actualProxyStore.getOperationsResponseDeserialiser() instanceof OperationsResponseDeserialiser);
    assertNull(actualProxyStore.getGraphId());
    assertNull(actualProxyStore.getJobTracker());
    assertNull(actualProxyStore.getProperties());
    assertNull(actualProxyStore.getGraphLibrary());
    assertNull(actualProxyStore.getOperationChainHandler());
    assertNull(actualProxyStore.getAddElementsHandler());
    assertNull(actualProxyStore.getDeleteAllDataHandler());
    assertNull(actualProxyStore.getDeleteElementsHandler());
    assertNull(actualProxyStore.getAdjacentIdsHandler());
    assertNull(actualProxyStore.getGetAllElementsHandler());
    assertNull(actualProxyStore.getGetElementsHandler());
    assertTrue(actualProxyStore.getOperationChainOptimisers().isEmpty());
    Class<ProxyProperties> expectedPropertiesClass = ProxyProperties.class;
    assertEquals(expectedPropertiesClass, actualProxyStore.getPropertiesClass());
    Class<ToBytesSerialiser> expectedRequiredParentSerialiserClass = ToBytesSerialiser.class;
    assertEquals(expectedRequiredParentSerialiserClass, actualProxyStore.getRequiredParentSerialiserClass());
  }

  /**
   * Test {@link ProxyStore#initialise(String, Schema, StoreProperties)}.
   * <ul>
   *   <li>Then throw {@link GafferRuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProxyStore#initialise(String, Schema, StoreProperties)}
   */
  @Test
  @DisplayName("Test initialise(String, Schema, StoreProperties); then throw GafferRuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ProxyStore.initialise(String, Schema, StoreProperties)"})
  void testInitialise_thenThrowGafferRuntimeException() throws StoreException {
    // Arrange
    ProxyStore proxyStore = new ProxyStore();
    Schema unusedSchema = new Schema();
    StoreProperties properties = mock(StoreProperties.class);
    when(properties.getReflectionPackages()).thenThrow(new GafferRuntimeException("An error occurred"));
    when(properties.getProperties()).thenReturn(new Properties());
    doNothing().when(properties).updateStorePropertiesClass(Mockito.<Class<StoreProperties>>any());

    // Act and Assert
    assertThrows(GafferRuntimeException.class, () -> proxyStore.initialise("42", unusedSchema, properties));
    verify(properties).getProperties();
    verify(properties).getReflectionPackages();
    verify(properties).updateStorePropertiesClass(isA(Class.class));
  }

  /**
   * Test {@link ProxyStore#getResponseDeserialiserFor(TypeReference)}.
   * <ul>
   *   <li>Then return deserialise {@code foo} is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProxyStore#getResponseDeserialiserFor(TypeReference)}
   */
  @Test
  @DisplayName("Test getResponseDeserialiserFor(TypeReference); then return deserialise 'foo' is 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ResponseDeserialiser ProxyStore.getResponseDeserialiserFor(TypeReference)"})
  void testGetResponseDeserialiserFor_thenReturnDeserialiseFooIsFoo()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    ProxyStore proxyStore = new ProxyStore();

    // Act
    ResponseDeserialiser<Object> actualResponseDeserialiserFor = proxyStore
        .getResponseDeserialiserFor(new TypeReferenceImpl.Object());
    Object actualDeserialiseResult = actualResponseDeserialiserFor.deserialise("foo");

    // Assert
    assertTrue(actualResponseDeserialiserFor instanceof DefaultResponseDeserialiser);
    assertEquals("Json String", actualResponseDeserialiserFor.deserialise("Json String"));
    assertEquals("foo", actualDeserialiseResult);
    byte[] expectedEncodeStringResult = "Json String".getBytes("UTF-8");
    assertArrayEquals(expectedEncodeStringResult, actualResponseDeserialiserFor.encodeString("Json String"));
  }

  /**
   * Test {@link ProxyStore#fetchTraits(Operation)}.
   * <ul>
   *   <li>Then throw {@link OperationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProxyStore#fetchTraits(Operation)}
   */
  @Test
  @DisplayName("Test fetchTraits(Operation); then throw OperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ProxyStore.fetchTraits(Operation)"})
  void testFetchTraits_thenThrowOperationException() throws OperationException {
    // Arrange
    ProxyStore proxyStore = new ProxyStore();

    AddNamedOperation operation = new AddNamedOperation();
    operation.addOption("UNKNOWN", "42");

    // Act and Assert
    assertThrows(OperationException.class, () -> proxyStore.fetchTraits(operation));
  }

  /**
   * Test {@link ProxyStore#fetchTraits(Operation)}.
   * <ul>
   *   <li>When {@link AddNamedOperation} (default constructor) OperationChain is {@code UNKNOWN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProxyStore#fetchTraits(Operation)}
   */
  @Test
  @DisplayName("Test fetchTraits(Operation); when AddNamedOperation (default constructor) OperationChain is 'UNKNOWN'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ProxyStore.fetchTraits(Operation)"})
  void testFetchTraits_whenAddNamedOperationOperationChainIsUnknown() throws OperationException {
    // Arrange
    ProxyStore proxyStore = new ProxyStore();

    AddNamedOperation operation = new AddNamedOperation();
    operation.setOperationChain("UNKNOWN");
    operation.addOption("UNKNOWN", "42");

    // Act and Assert
    assertThrows(OperationException.class, () -> proxyStore.fetchTraits(operation));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProxyStore#validateSchemas()}
   *   <li>{@link ProxyStore#getAddElementsHandler()}
   *   <li>{@link ProxyStore#getAdjacentIdsHandler()}
   *   <li>{@link ProxyStore#getDeleteAllDataHandler()}
   *   <li>{@link ProxyStore#getDeleteElementsHandler()}
   *   <li>{@link ProxyStore#getGetAllElementsHandler()}
   *   <li>{@link ProxyStore#getGetElementsHandler()}
   *   <li>{@link ProxyStore#getOperationChainHandler()}
   *   <li>{@link ProxyStore#getPropertiesClass()}
   *   <li>{@link ProxyStore#getRequiredParentSerialiserClass()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"javax.ws.rs.client.Invocation.Builder ProxyStore.createRequest(String, java.net.URL, Context)",
      "OperationHandler ProxyStore.getAddElementsHandler()",
      "OutputOperationHandler ProxyStore.getAdjacentIdsHandler()",
      "OperationHandler ProxyStore.getDeleteAllDataHandler()",
      "OutputOperationHandler ProxyStore.getDeleteElementsHandler()",
      "OutputOperationHandler ProxyStore.getGetAllElementsHandler()",
      "OutputOperationHandler ProxyStore.getGetElementsHandler()",
      "OperationHandler ProxyStore.getOperationChainHandler()", "Class ProxyStore.getPropertiesClass()",
      "Class ProxyStore.getRequiredParentSerialiserClass()", "void ProxyStore.validateSchemas()"})
  void testGettersAndSetters() {
    // Arrange
    ProxyStore proxyStore = new ProxyStore();

    // Act
    proxyStore.validateSchemas();
    OperationHandler<? extends AddElements> actualAddElementsHandler = proxyStore.getAddElementsHandler();
    OutputOperationHandler<? extends GetAdjacentIds, Iterable<? extends EntityId>> actualAdjacentIdsHandler = proxyStore
        .getAdjacentIdsHandler();
    OperationHandler<DeleteAllData> actualDeleteAllDataHandler = proxyStore.getDeleteAllDataHandler();
    OutputOperationHandler<DeleteElements, Long> actualDeleteElementsHandler = proxyStore.getDeleteElementsHandler();
    OutputOperationHandler<GetAllElements, Iterable<? extends Element>> actualGetAllElementsHandler = proxyStore
        .getGetAllElementsHandler();
    OutputOperationHandler<GetElements, Iterable<? extends Element>> actualGetElementsHandler = proxyStore
        .getGetElementsHandler();
    OperationHandler<? extends OperationChain<?>> actualOperationChainHandler = proxyStore.getOperationChainHandler();
    Class<ProxyProperties> actualPropertiesClass = proxyStore.getPropertiesClass();
    Class<? extends Serialiser> actualRequiredParentSerialiserClass = proxyStore.getRequiredParentSerialiserClass();

    // Assert
    assertNull(actualOperationChainHandler);
    assertNull(actualAddElementsHandler);
    assertNull(actualDeleteAllDataHandler);
    assertNull(actualDeleteElementsHandler);
    assertNull(actualAdjacentIdsHandler);
    assertNull(actualGetAllElementsHandler);
    assertNull(actualGetElementsHandler);
    Class<ProxyProperties> expectedPropertiesClass = ProxyProperties.class;
    assertEquals(expectedPropertiesClass, actualPropertiesClass);
    Class<ToBytesSerialiser> expectedRequiredParentSerialiserClass = ToBytesSerialiser.class;
    assertEquals(expectedRequiredParentSerialiserClass, actualRequiredParentSerialiserClass);
  }

  /**
   * Test {@link ProxyStore#getProperties()}.
   * <p>
   * Method under test: {@link ProxyStore#getProperties()}
   */
  @Test
  @DisplayName("Test getProperties()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ProxyProperties ProxyStore.getProperties()"})
  void testGetProperties() {
    // Arrange, Act and Assert
    assertNull((new ProxyStore()).getProperties());
  }

  /**
   * Test {@link ProxyStore#getGetTraitsHandler()}.
   * <p>
   * Method under test: {@link ProxyStore#getGetTraitsHandler()}
   */
  @Test
  @DisplayName("Test getGetTraitsHandler()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"OutputOperationHandler ProxyStore.getGetTraitsHandler()"})
  void testGetGetTraitsHandler() throws OperationException {
    // Arrange and Act
    OutputOperationHandler<GetTraits, Set<StoreTrait>> actualGetTraitsHandler = (new ProxyStore())
        .getGetTraitsHandler();
    GetTraits getTraits = mock(GetTraits.class);
    Context.Builder builder = mock(Context.Builder.class);
    when(builder.user(Mockito.<User>any())).thenReturn(new Context.Builder());
    User.Builder builder2 = mock(User.Builder.class);
    when(builder2.userId(Mockito.<String>any())).thenReturn(new User.Builder());
    User user = builder2.userId("42").build();
    Context buildResult = builder.user(user).build();
    SingleUseMapProxyStore singleUseMapProxyStore = mock(SingleUseMapProxyStore.class);
    when(singleUseMapProxyStore.fetchTraits(Mockito.<Operation>any())).thenReturn(new HashSet<>());
    Set<StoreTrait> actualDoOperationResult = actualGetTraitsHandler.doOperation(getTraits, buildResult,
        singleUseMapProxyStore);

    // Assert
    verify(singleUseMapProxyStore).fetchTraits(isA(Operation.class));
    verify(builder).user(isA(User.class));
    verify(builder2).userId(eq("42"));
    assertTrue(actualDoOperationResult.isEmpty());
  }
}
