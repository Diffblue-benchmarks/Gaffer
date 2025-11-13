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

package uk.gov.gchq.gaffer.jsonserialisation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.Module.SetupContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker.Std;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider.Impl;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.exception.SerialisationException;
import uk.gov.gchq.gaffer.jsonserialisation.jackson.IterableDeserializer;

class JSONSerialiserDiffblueTest {
  /**
   * Test {@link JSONSerialiser#registerModules(Collection)} with {@code Collection}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add Module.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#registerModules(Collection)}
   */
  @Test
  @DisplayName("Test registerModules(Collection) with 'Collection'; given ArrayList() add Module")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JSONSerialiser.registerModules(Collection)"})
  void testRegisterModulesWithCollection_givenArrayListAddModule() {
    // Arrange
    JSONSerialiser instance = JSONSerialiser.getInstance();

    ArrayList<Module> resultModuleList = new ArrayList<>();
    resultModuleList.add(IterableDeserializer.getModule());
    SimpleModule simpleModule = mock(SimpleModule.class);
    Mockito.<Iterable<? extends Module>>when(simpleModule.getDependencies()).thenReturn(resultModuleList);
    when(simpleModule.getTypeId()).thenReturn("Type Id");
    when(simpleModule.version()).thenReturn(Version.unknownVersion());
    when(simpleModule.getModuleName()).thenReturn("Module Name");

    ArrayList<Module> modules = new ArrayList<>();
    modules.add(simpleModule);

    // Act
    instance.registerModules(modules);

    // Assert
    verify(simpleModule).getDependencies();
    verify(simpleModule).getModuleName();
    verify(simpleModule).getTypeId();
    verify(simpleModule).version();
  }

  /**
   * Test {@link JSONSerialiser#registerModules(Collection)} with {@code Collection}.
   * <ul>
   *   <li>Then calls {@link Module#getDependencies()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#registerModules(Collection)}
   */
  @Test
  @DisplayName("Test registerModules(Collection) with 'Collection'; then calls getDependencies()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JSONSerialiser.registerModules(Collection)"})
  void testRegisterModulesWithCollection_thenCallsGetDependencies() {
    // Arrange
    JSONSerialiser instance = JSONSerialiser.getInstance();
    SimpleModule simpleModule = mock(SimpleModule.class);
    Mockito.<Iterable<? extends Module>>when(simpleModule.getDependencies()).thenReturn(new ArrayList<>());
    when(simpleModule.getTypeId()).thenReturn("Type Id");
    when(simpleModule.version()).thenReturn(Version.unknownVersion());
    when(simpleModule.getModuleName()).thenReturn("Module Name");

    ArrayList<Module> modules = new ArrayList<>();
    modules.add(simpleModule);

    // Act
    instance.registerModules(modules);

    // Assert
    verify(simpleModule).getDependencies();
    verify(simpleModule).getModuleName();
    verify(simpleModule).getTypeId();
    verify(simpleModule).version();
  }

  /**
   * Test {@link JSONSerialiser#registerModules(Collection)} with {@code Collection}.
   * <ul>
   *   <li>Then calls {@link SimpleModule#setupModule(SetupContext)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#registerModules(Collection)}
   */
  @Test
  @DisplayName("Test registerModules(Collection) with 'Collection'; then calls setupModule(SetupContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JSONSerialiser.registerModules(Collection)"})
  void testRegisterModulesWithCollection_thenCallsSetupModule() {
    // Arrange
    JSONSerialiser instance = JSONSerialiser.getInstance();
    SimpleModule simpleModule = mock(SimpleModule.class);
    Mockito.<Iterable<? extends Module>>when(simpleModule.getDependencies()).thenReturn(new ArrayList<>());
    when(simpleModule.getTypeId()).thenReturn(null);
    doNothing().when(simpleModule).setupModule(Mockito.<SetupContext>any());
    when(simpleModule.version()).thenReturn(Version.unknownVersion());
    when(simpleModule.getModuleName()).thenReturn("Module Name");

    ArrayList<Module> modules = new ArrayList<>();
    modules.add(simpleModule);

    // Act
    instance.registerModules(modules);

    // Assert
    verify(simpleModule).getDependencies();
    verify(simpleModule).getModuleName();
    verify(simpleModule).getTypeId();
    verify(simpleModule).setupModule(isA(SetupContext.class));
    verify(simpleModule).version();
  }

  /**
   * Test {@link JSONSerialiser#registerModules(Module[])} with {@code Module[]}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add Module.</li>
   *   <li>Then calls {@link Module#getDependencies()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#registerModules(Module[])}
   */
  @Test
  @DisplayName("Test registerModules(Module[]) with 'Module[]'; given ArrayList() add Module; then calls getDependencies()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JSONSerialiser.registerModules(Module[])"})
  void testRegisterModulesWithModule_givenArrayListAddModule_thenCallsGetDependencies() {
    // Arrange
    JSONSerialiser instance = JSONSerialiser.getInstance();

    ArrayList<Module> resultModuleList = new ArrayList<>();
    resultModuleList.add(IterableDeserializer.getModule());
    SimpleModule simpleModule = mock(SimpleModule.class);
    Mockito.<Iterable<? extends Module>>when(simpleModule.getDependencies()).thenReturn(resultModuleList);
    when(simpleModule.getTypeId()).thenReturn("Type Id");
    when(simpleModule.version()).thenReturn(Version.unknownVersion());
    when(simpleModule.getModuleName()).thenReturn("Module Name");

    // Act
    instance.registerModules(simpleModule);

    // Assert
    verify(simpleModule).getDependencies();
    verify(simpleModule).getModuleName();
    verify(simpleModule).getTypeId();
    verify(simpleModule).version();
  }

  /**
   * Test {@link JSONSerialiser#registerModules(Module[])} with {@code Module[]}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link Module#getDependencies()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#registerModules(Module[])}
   */
  @Test
  @DisplayName("Test registerModules(Module[]) with 'Module[]'; given ArrayList(); then calls getDependencies()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JSONSerialiser.registerModules(Module[])"})
  void testRegisterModulesWithModule_givenArrayList_thenCallsGetDependencies() {
    // Arrange
    JSONSerialiser instance = JSONSerialiser.getInstance();
    SimpleModule simpleModule = mock(SimpleModule.class);
    Mockito.<Iterable<? extends Module>>when(simpleModule.getDependencies()).thenReturn(new ArrayList<>());
    when(simpleModule.getTypeId()).thenReturn("Type Id");
    when(simpleModule.version()).thenReturn(Version.unknownVersion());
    when(simpleModule.getModuleName()).thenReturn("Module Name");

    // Act
    instance.registerModules(simpleModule);

    // Assert
    verify(simpleModule).getDependencies();
    verify(simpleModule).getModuleName();
    verify(simpleModule).getTypeId();
    verify(simpleModule).version();
  }

  /**
   * Test {@link JSONSerialiser#registerModules(Module[])} with {@code Module[]}.
   * <ul>
   *   <li>Given {@link JSONSerialiser#JSONSerialiser()}.</li>
   *   <li>Then calls {@link SimpleModule#setupModule(SetupContext)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#registerModules(Module[])}
   */
  @Test
  @DisplayName("Test registerModules(Module[]) with 'Module[]'; given JSONSerialiser(); then calls setupModule(SetupContext)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JSONSerialiser.registerModules(Module[])"})
  void testRegisterModulesWithModule_givenJSONSerialiser_thenCallsSetupModule() {
    // Arrange
    JSONSerialiser jsonSerialiser = new JSONSerialiser();
    SimpleModule simpleModule = mock(SimpleModule.class);
    Mockito.<Iterable<? extends Module>>when(simpleModule.getDependencies()).thenReturn(new ArrayList<>());
    when(simpleModule.getTypeId()).thenReturn("Type Id");
    doNothing().when(simpleModule).setupModule(Mockito.<SetupContext>any());
    when(simpleModule.version()).thenReturn(Version.unknownVersion());
    when(simpleModule.getModuleName()).thenReturn("Module Name");

    // Act
    jsonSerialiser.registerModules(simpleModule);

    // Assert
    verify(simpleModule).getDependencies();
    verify(simpleModule).getModuleName();
    verify(simpleModule).getTypeId();
    verify(simpleModule).setupModule(isA(SetupContext.class));
    verify(simpleModule).version();
  }

  /**
   * Test {@link JSONSerialiser#update(String, String, Boolean)} with {@code String}, {@code String}, {@code Boolean}.
   * <ul>
   *   <li>When {@code ,}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#update(String, String, Boolean)}
   */
  @Test
  @DisplayName("Test update(String, String, Boolean) with 'String', 'String', 'Boolean'; when ','")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JSONSerialiser.update(String, String, Boolean)"})
  void testUpdateWithStringStringBoolean_whenComma() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JSONSerialiser.update(",", "Json Serialiser Modules", true));
  }

  /**
   * Test {@link JSONSerialiser#update(String, String, Boolean)} with {@code String}, {@code String}, {@code Boolean}.
   * <ul>
   *   <li>When {@code ,}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#update(String, String, Boolean)}
   */
  @Test
  @DisplayName("Test update(String, String, Boolean) with 'String', 'String', 'Boolean'; when ','")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JSONSerialiser.update(String, String, Boolean)"})
  void testUpdateWithStringStringBoolean_whenComma2() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JSONSerialiser.update("Json Serialiser Class", ",", true));
  }

  /**
   * Test {@link JSONSerialiser#update(String, String, Boolean)} with {@code String}, {@code String}, {@code Boolean}.
   * <ul>
   *   <li>When {@code Json Serialiser Class}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#update(String, String, Boolean)}
   */
  @Test
  @DisplayName("Test update(String, String, Boolean) with 'String', 'String', 'Boolean'; when 'Json Serialiser Class'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JSONSerialiser.update(String, String, Boolean)"})
  void testUpdateWithStringStringBoolean_whenJsonSerialiserClass() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JSONSerialiser.update("Json Serialiser Class", "Json Serialiser Modules", true));
  }

  /**
   * Test {@link JSONSerialiser#update(String, String, Boolean)} with {@code String}, {@code String}, {@code Boolean}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#update(String, String, Boolean)}
   */
  @Test
  @DisplayName("Test update(String, String, Boolean) with 'String', 'String', 'Boolean'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JSONSerialiser.update(String, String, Boolean)"})
  void testUpdateWithStringStringBoolean_whenNull() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JSONSerialiser.update("Json Serialiser Class", null, true));
  }

  /**
   * Test {@link JSONSerialiser#update(String, String, Boolean)} with {@code String}, {@code String}, {@code Boolean}.
   * <ul>
   *   <li>When Property is {@link JSONSerialiser#JSON_SERIALISER_CLASS_KEY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#update(String, String, Boolean)}
   */
  @Test
  @DisplayName("Test update(String, String, Boolean) with 'String', 'String', 'Boolean'; when Property is JSON_SERIALISER_CLASS_KEY")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void JSONSerialiser.update(String, String, Boolean)"})
  void testUpdateWithStringStringBoolean_whenPropertyIsJson_serialiser_class_key() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JSONSerialiser
        .update(System.getProperty(JSONSerialiser.JSON_SERIALISER_CLASS_KEY), "Json Serialiser Modules", true));
  }

  /**
   * Test {@link JSONSerialiser#createDefaultMapper()}.
   * <p>
   * Method under test: {@link JSONSerialiser#createDefaultMapper()}
   */
  @Test
  @DisplayName("Test createDefaultMapper()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ObjectMapper JSONSerialiser.createDefaultMapper()"})
  void testCreateDefaultMapper() {
    // Arrange and Act
    ObjectMapper actualCreateDefaultMapperResult = JSONSerialiser.createDefaultMapper();

    // Assert
    JsonFactory factory = actualCreateDefaultMapperResult.getFactory();
    assertTrue(factory instanceof MappingJsonFactory);
    assertTrue(
        actualCreateDefaultMapperResult.getDeserializationContext() instanceof DefaultDeserializationContext.Impl);
    assertTrue(actualCreateDefaultMapperResult.getVisibilityChecker() instanceof Std);
    assertTrue(actualCreateDefaultMapperResult.getPolymorphicTypeValidator() instanceof LaissezFaireSubTypeValidator);
    assertTrue(actualCreateDefaultMapperResult.getSubtypeResolver() instanceof StdSubtypeResolver);
    assertTrue(actualCreateDefaultMapperResult.getSerializerFactory() instanceof BeanSerializerFactory);
    assertTrue(actualCreateDefaultMapperResult.getSerializerProvider() instanceof Impl);
    assertTrue(actualCreateDefaultMapperResult.getSerializerProviderInstance() instanceof Impl);
    assertTrue(actualCreateDefaultMapperResult.getDateFormat() instanceof StdDateFormat);
    assertNull(actualCreateDefaultMapperResult.getInjectableValues());
    assertNull(actualCreateDefaultMapperResult.getPropertyNamingStrategy());
    assertEquals(3, actualCreateDefaultMapperResult.getRegisteredModuleIds().size());
    assertSame(factory, actualCreateDefaultMapperResult.getJsonFactory());
  }

  /**
   * Test {@link JSONSerialiser#getFilterProvider(String[])}.
   * <p>
   * Method under test: {@link JSONSerialiser#getFilterProvider(String[])}
   */
  @Test
  @DisplayName("Test getFilterProvider(String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FilterProvider JSONSerialiser.getFilterProvider(String[])"})
  void testGetFilterProvider() {
    // Arrange and Act
    FilterProvider actualFilterProvider = JSONSerialiser.getFilterProvider();

    // Assert
    assertTrue(actualFilterProvider instanceof SimpleFilterProvider);
    assertNull(((SimpleFilterProvider) actualFilterProvider).getDefaultFilter());
  }

  /**
   * Test {@link JSONSerialiser#getFilterProvider(String[])}.
   * <ul>
   *   <li>When {@code Fields To Exclude}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#getFilterProvider(String[])}
   */
  @Test
  @DisplayName("Test getFilterProvider(String[]); when 'Fields To Exclude'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FilterProvider JSONSerialiser.getFilterProvider(String[])"})
  void testGetFilterProvider_whenFieldsToExclude() {
    // Arrange and Act
    FilterProvider actualFilterProvider = JSONSerialiser.getFilterProvider("Fields To Exclude");

    // Assert
    assertTrue(actualFilterProvider instanceof SimpleFilterProvider);
    assertNull(((SimpleFilterProvider) actualFilterProvider).getDefaultFilter());
  }

  /**
   * Test {@link JSONSerialiser#getFilterProvider(String[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#getFilterProvider(String[])}
   */
  @Test
  @DisplayName("Test getFilterProvider(String[]); when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"FilterProvider JSONSerialiser.getFilterProvider(String[])"})
  void testGetFilterProvider_whenNull() {
    // Arrange and Act
    FilterProvider actualFilterProvider = JSONSerialiser.getFilterProvider(null);

    // Assert
    assertTrue(actualFilterProvider instanceof SimpleFilterProvider);
    assertNull(((SimpleFilterProvider) actualFilterProvider).getDefaultFilter());
  }

  /**
   * Test {@link JSONSerialiser#canHandle(Class)}.
   * <ul>
   *   <li>When {@code Object}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#canHandle(Class)}
   */
  @Test
  @DisplayName("Test canHandle(Class); when 'java.lang.Object'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean JSONSerialiser.canHandle(Class)"})
  void testCanHandle_whenJavaLangObject_thenReturnTrue() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertTrue(JSONSerialiser.canHandle(clazz));
  }

  /**
   * Test {@link JSONSerialiser#deserialise(byte[], Class)} with {@code bytes}, {@code clazz}.
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#deserialise(byte[], Class)}
   */
  @Test
  @DisplayName("Test deserialise(byte[], Class) with 'bytes', 'clazz'; when array of byte with 'A' and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JSONSerialiser.deserialise(byte[], Class)"})
  void testDeserialiseWithBytesClazz_whenArrayOfByteWithAAndZero() throws SerialisationException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(SerialisationException.class,
        () -> JSONSerialiser.deserialise(new byte[]{'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'}, clazz));
  }

  /**
   * Test {@link JSONSerialiser#deserialise(byte[], Class)} with {@code bytes}, {@code clazz}.
   * <ul>
   *   <li>When array of {@code byte} with zero and {@link Byte#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#deserialise(byte[], Class)}
   */
  @Test
  @DisplayName("Test deserialise(byte[], Class) with 'bytes', 'clazz'; when array of byte with zero and MAX_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JSONSerialiser.deserialise(byte[], Class)"})
  void testDeserialiseWithBytesClazz_whenArrayOfByteWithZeroAndMax_value() throws SerialisationException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(SerialisationException.class,
        () -> JSONSerialiser.deserialise(new byte[]{0, Byte.MAX_VALUE, 'A', 'X', 'A', 'X', 'A', 'X'}, clazz));
  }

  /**
   * Test {@link JSONSerialiser#deserialise(byte[], Class)} with {@code bytes}, {@code clazz}.
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#deserialise(byte[], Class)}
   */
  @Test
  @DisplayName("Test deserialise(byte[], Class) with 'bytes', 'clazz'; when array of byte with zero and 'X'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JSONSerialiser.deserialise(byte[], Class)"})
  void testDeserialiseWithBytesClazz_whenArrayOfByteWithZeroAndX() throws SerialisationException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(SerialisationException.class,
        () -> JSONSerialiser.deserialise(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, clazz));
  }

  /**
   * Test {@link JSONSerialiser#deserialise(byte[], Class)} with {@code bytes}, {@code clazz}.
   * <ul>
   *   <li>When array of {@code byte} with zero and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#deserialise(byte[], Class)}
   */
  @Test
  @DisplayName("Test deserialise(byte[], Class) with 'bytes', 'clazz'; when array of byte with zero and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JSONSerialiser.deserialise(byte[], Class)"})
  void testDeserialiseWithBytesClazz_whenArrayOfByteWithZeroAndZero() throws SerialisationException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(SerialisationException.class,
        () -> JSONSerialiser.deserialise(new byte[]{0, 0, 'A', 'X', 'A', 'X', 'A', 'X'}, clazz));
  }

  /**
   * Test {@link JSONSerialiser#deserialise(byte[], Class)} with {@code bytes}, {@code clazz}.
   * <ul>
   *   <li>When array of {@code byte} with zero and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#deserialise(byte[], Class)}
   */
  @Test
  @DisplayName("Test deserialise(byte[], Class) with 'bytes', 'clazz'; when array of byte with zero and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JSONSerialiser.deserialise(byte[], Class)"})
  void testDeserialiseWithBytesClazz_whenArrayOfByteWithZeroAndZero2() throws SerialisationException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(SerialisationException.class,
        () -> JSONSerialiser.deserialise(new byte[]{0, 0, 0, 'X', 'A', 'X', 'A', 'X'}, clazz));
  }

  /**
   * Test {@link JSONSerialiser#deserialise(byte[], Class)} with {@code bytes}, {@code clazz}.
   * <ul>
   *   <li>When array of {@code byte} with zero and zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#deserialise(byte[], Class)}
   */
  @Test
  @DisplayName("Test deserialise(byte[], Class) with 'bytes', 'clazz'; when array of byte with zero and zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JSONSerialiser.deserialise(byte[], Class)"})
  void testDeserialiseWithBytesClazz_whenArrayOfByteWithZeroAndZero3() throws SerialisationException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(SerialisationException.class,
        () -> JSONSerialiser.deserialise(new byte[]{0, 0, 'A', 0, 'A', 'X', 'A', 'X'}, clazz));
  }

  /**
   * Test {@link JSONSerialiser#deserialise(byte[], Class)} with {@code bytes}, {@code clazz}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#deserialise(byte[], Class)}
   */
  @Test
  @DisplayName("Test deserialise(byte[], Class) with 'bytes', 'clazz'; when 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JSONSerialiser.deserialise(byte[], Class)"})
  void testDeserialiseWithBytesClazz_whenAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(SerialisationException.class, () -> JSONSerialiser.deserialise(bytes, clazz));
  }

  /**
   * Test {@link JSONSerialiser#deserialise(byte[], Class)} with {@code bytes}, {@code clazz}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#deserialise(byte[], Class)}
   */
  @Test
  @DisplayName("Test deserialise(byte[], Class) with 'bytes', 'clazz'; when empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JSONSerialiser.deserialise(byte[], Class)"})
  void testDeserialiseWithBytesClazz_whenEmptyArrayOfByte() throws SerialisationException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(SerialisationException.class, () -> JSONSerialiser.deserialise(new byte[]{}, clazz));
  }

  /**
   * Test {@link JSONSerialiser#deserialise(byte[], TypeReference)} with {@code bytes}, {@code type}.
   * <ul>
   *   <li>When array of {@code byte} with {@code A} and zero.</li>
   *   <li>Then calls {@link TypeReference#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#deserialise(byte[], TypeReference)}
   */
  @Test
  @DisplayName("Test deserialise(byte[], TypeReference) with 'bytes', 'type'; when array of byte with 'A' and zero; then calls getType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JSONSerialiser.deserialise(byte[], TypeReference)"})
  void testDeserialiseWithBytesType_whenArrayOfByteWithAAndZero_thenCallsGetType() throws SerialisationException {
    // Arrange
    TypeReference<Object> type = mock(TypeReference.class);
    when(type.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(SerialisationException.class,
        () -> JSONSerialiser.deserialise(new byte[]{'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'}, type));
    verify(type).getType();
  }

  /**
   * Test {@link JSONSerialiser#deserialise(byte[], TypeReference)} with {@code bytes}, {@code type}.
   * <ul>
   *   <li>When array of {@code byte} with zero and {@link Byte#MAX_VALUE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#deserialise(byte[], TypeReference)}
   */
  @Test
  @DisplayName("Test deserialise(byte[], TypeReference) with 'bytes', 'type'; when array of byte with zero and MAX_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JSONSerialiser.deserialise(byte[], TypeReference)"})
  void testDeserialiseWithBytesType_whenArrayOfByteWithZeroAndMax_value() throws SerialisationException {
    // Arrange
    TypeReference<Object> type = mock(TypeReference.class);
    when(type.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(SerialisationException.class,
        () -> JSONSerialiser.deserialise(new byte[]{0, Byte.MAX_VALUE, 'A', 'X', 'A', 'X', 'A', 'X'}, type));
    verify(type).getType();
  }

  /**
   * Test {@link JSONSerialiser#deserialise(byte[], TypeReference)} with {@code bytes}, {@code type}.
   * <ul>
   *   <li>When array of {@code byte} with zero and {@code X}.</li>
   *   <li>Then calls {@link TypeReference#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#deserialise(byte[], TypeReference)}
   */
  @Test
  @DisplayName("Test deserialise(byte[], TypeReference) with 'bytes', 'type'; when array of byte with zero and 'X'; then calls getType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JSONSerialiser.deserialise(byte[], TypeReference)"})
  void testDeserialiseWithBytesType_whenArrayOfByteWithZeroAndX_thenCallsGetType() throws SerialisationException {
    // Arrange
    TypeReference<Object> type = mock(TypeReference.class);
    when(type.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(SerialisationException.class,
        () -> JSONSerialiser.deserialise(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, type));
    verify(type).getType();
  }

  /**
   * Test {@link JSONSerialiser#deserialise(byte[], TypeReference)} with {@code bytes}, {@code type}.
   * <ul>
   *   <li>When array of {@code byte} with zero and zero.</li>
   *   <li>Then calls {@link TypeReference#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#deserialise(byte[], TypeReference)}
   */
  @Test
  @DisplayName("Test deserialise(byte[], TypeReference) with 'bytes', 'type'; when array of byte with zero and zero; then calls getType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JSONSerialiser.deserialise(byte[], TypeReference)"})
  void testDeserialiseWithBytesType_whenArrayOfByteWithZeroAndZero_thenCallsGetType() throws SerialisationException {
    // Arrange
    TypeReference<Object> type = mock(TypeReference.class);
    when(type.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(SerialisationException.class,
        () -> JSONSerialiser.deserialise(new byte[]{0, 0, 'A', 'X', 'A', 'X', 'A', 'X'}, type));
    verify(type).getType();
  }

  /**
   * Test {@link JSONSerialiser#deserialise(byte[], TypeReference)} with {@code bytes}, {@code type}.
   * <ul>
   *   <li>When array of {@code byte} with zero and zero.</li>
   *   <li>Then calls {@link TypeReference#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#deserialise(byte[], TypeReference)}
   */
  @Test
  @DisplayName("Test deserialise(byte[], TypeReference) with 'bytes', 'type'; when array of byte with zero and zero; then calls getType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JSONSerialiser.deserialise(byte[], TypeReference)"})
  void testDeserialiseWithBytesType_whenArrayOfByteWithZeroAndZero_thenCallsGetType2() throws SerialisationException {
    // Arrange
    TypeReference<Object> type = mock(TypeReference.class);
    when(type.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(SerialisationException.class,
        () -> JSONSerialiser.deserialise(new byte[]{0, 0, 0, 'X', 'A', 'X', 'A', 'X'}, type));
    verify(type).getType();
  }

  /**
   * Test {@link JSONSerialiser#deserialise(byte[], TypeReference)} with {@code bytes}, {@code type}.
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then calls {@link TypeReference#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#deserialise(byte[], TypeReference)}
   */
  @Test
  @DisplayName("Test deserialise(byte[], TypeReference) with 'bytes', 'type'; when 'AXAXAXAX' Bytes is 'UTF-8'; then calls getType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JSONSerialiser.deserialise(byte[], TypeReference)"})
  void testDeserialiseWithBytesType_whenAxaxaxaxBytesIsUtf8_thenCallsGetType()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    TypeReference<Object> type = mock(TypeReference.class);
    when(type.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(SerialisationException.class, () -> JSONSerialiser.deserialise(bytes, type));
    verify(type).getType();
  }

  /**
   * Test {@link JSONSerialiser#deserialise(byte[], TypeReference)} with {@code bytes}, {@code type}.
   * <ul>
   *   <li>When empty array of {@code byte}.</li>
   *   <li>Then calls {@link TypeReference#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#deserialise(byte[], TypeReference)}
   */
  @Test
  @DisplayName("Test deserialise(byte[], TypeReference) with 'bytes', 'type'; when empty array of byte; then calls getType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JSONSerialiser.deserialise(byte[], TypeReference)"})
  void testDeserialiseWithBytesType_whenEmptyArrayOfByte_thenCallsGetType() throws SerialisationException {
    // Arrange
    TypeReference<Object> type = mock(TypeReference.class);
    when(type.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(SerialisationException.class, () -> JSONSerialiser.deserialise(new byte[]{}, type));
    verify(type).getType();
  }

  /**
   * Test {@link JSONSerialiser#deserialise(byte[], TypeReference)} with {@code bytes}, {@code type}.
   * <ul>
   *   <li>When {@link TypeReference}.</li>
   *   <li>Then throw {@link SerialisationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#deserialise(byte[], TypeReference)}
   */
  @Test
  @DisplayName("Test deserialise(byte[], TypeReference) with 'bytes', 'type'; when TypeReference; then throw SerialisationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JSONSerialiser.deserialise(byte[], TypeReference)"})
  void testDeserialiseWithBytesType_whenTypeReference_thenThrowSerialisationException() throws SerialisationException {
    // Arrange, Act and Assert
    assertThrows(SerialisationException.class, () -> JSONSerialiser
        .<Object>deserialise(new byte[]{0, 0, 'A', 0, 'A', 'X', 'A', 'X'}, mock(TypeReference.class)));
  }

  /**
   * Test {@link JSONSerialiser#deserialise(String, Class)} with {@code json}, {@code clazz}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return intValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#deserialise(String, Class)}
   */
  @Test
  @DisplayName("Test deserialise(String, Class) with 'json', 'clazz'; when '42'; then return intValue is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JSONSerialiser.deserialise(String, Class)"})
  void testDeserialiseWithJsonClazz_when42_thenReturnIntValueIsFortyTwo() throws SerialisationException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals(42, ((Integer) JSONSerialiser.deserialise("42", clazz)).intValue());
  }

  /**
   * Test {@link JSONSerialiser#deserialise(String, Class)} with {@code json}, {@code clazz}.
   * <ul>
   *   <li>When {@code ,}.</li>
   *   <li>Then throw {@link SerialisationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#deserialise(String, Class)}
   */
  @Test
  @DisplayName("Test deserialise(String, Class) with 'json', 'clazz'; when ','; then throw SerialisationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JSONSerialiser.deserialise(String, Class)"})
  void testDeserialiseWithJsonClazz_whenComma_thenThrowSerialisationException() throws SerialisationException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(SerialisationException.class, () -> JSONSerialiser.deserialise(",", clazz));
  }

  /**
   * Test {@link JSONSerialiser#deserialise(String, Class)} with {@code json}, {@code clazz}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then throw {@link SerialisationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#deserialise(String, Class)}
   */
  @Test
  @DisplayName("Test deserialise(String, Class) with 'json', 'clazz'; when empty string; then throw SerialisationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JSONSerialiser.deserialise(String, Class)"})
  void testDeserialiseWithJsonClazz_whenEmptyString_thenThrowSerialisationException() throws SerialisationException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(SerialisationException.class, () -> JSONSerialiser.deserialise("", clazz));
  }

  /**
   * Test {@link JSONSerialiser#deserialise(String, Class)} with {@code json}, {@code clazz}.
   * <ul>
   *   <li>When {@link JSONSerialiser#JSON_SERIALISER_CLASS_KEY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#deserialise(String, Class)}
   */
  @Test
  @DisplayName("Test deserialise(String, Class) with 'json', 'clazz'; when JSON_SERIALISER_CLASS_KEY")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JSONSerialiser.deserialise(String, Class)"})
  void testDeserialiseWithJsonClazz_whenJson_serialiser_class_key() throws SerialisationException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(SerialisationException.class,
        () -> JSONSerialiser.deserialise(JSONSerialiser.JSON_SERIALISER_CLASS_KEY, clazz));
  }

  /**
   * Test {@link JSONSerialiser#deserialise(String, Class)} with {@code json}, {@code clazz}.
   * <ul>
   *   <li>When {@code Json}.</li>
   *   <li>Then throw {@link SerialisationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#deserialise(String, Class)}
   */
  @Test
  @DisplayName("Test deserialise(String, Class) with 'json', 'clazz'; when 'Json'; then throw SerialisationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JSONSerialiser.deserialise(String, Class)"})
  void testDeserialiseWithJsonClazz_whenJson_thenThrowSerialisationException() throws SerialisationException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(SerialisationException.class, () -> JSONSerialiser.deserialise("Json", clazz));
  }

  /**
   * Test {@link JSONSerialiser#deserialise(InputStream, Class)} with {@code stream}, {@code clazz}.
   * <p>
   * Method under test: {@link JSONSerialiser#deserialise(InputStream, Class)}
   */
  @Test
  @DisplayName("Test deserialise(InputStream, Class) with 'stream', 'clazz'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JSONSerialiser.deserialise(InputStream, Class)"})
  void testDeserialiseWithStreamClazz() throws SerialisationException {
    // Arrange
    ByteArrayInputStream stream = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(SerialisationException.class, () -> JSONSerialiser.deserialise(stream, clazz));
  }

  /**
   * Test {@link JSONSerialiser#deserialise(InputStream, Class)} with {@code stream}, {@code clazz}.
   * <p>
   * Method under test: {@link JSONSerialiser#deserialise(InputStream, Class)}
   */
  @Test
  @DisplayName("Test deserialise(InputStream, Class) with 'stream', 'clazz'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JSONSerialiser.deserialise(InputStream, Class)"})
  void testDeserialiseWithStreamClazz2() throws SerialisationException {
    // Arrange
    ByteArrayInputStream stream = new ByteArrayInputStream(new byte[]{'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'});
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(SerialisationException.class, () -> JSONSerialiser.deserialise(stream, clazz));
  }

  /**
   * Test {@link JSONSerialiser#deserialise(InputStream, Class)} with {@code stream}, {@code clazz}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#deserialise(InputStream, Class)}
   */
  @Test
  @DisplayName("Test deserialise(InputStream, Class) with 'stream', 'clazz'; when ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JSONSerialiser.deserialise(InputStream, Class)"})
  void testDeserialiseWithStreamClazz_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    ByteArrayInputStream stream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(SerialisationException.class, () -> JSONSerialiser.deserialise(stream, clazz));
  }

  /**
   * Test {@link JSONSerialiser#deserialise(InputStream, Class)} with {@code stream}, {@code clazz}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#deserialise(InputStream, Class)}
   */
  @Test
  @DisplayName("Test deserialise(InputStream, Class) with 'stream', 'clazz'; when ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JSONSerialiser.deserialise(InputStream, Class)"})
  void testDeserialiseWithStreamClazz_whenByteArrayInputStreamWithEmptyArrayOfByte() throws SerialisationException {
    // Arrange
    ByteArrayInputStream stream = new ByteArrayInputStream(new byte[]{});
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(SerialisationException.class, () -> JSONSerialiser.deserialise(stream, clazz));
  }

  /**
   * Test {@link JSONSerialiser#deserialise(InputStream, TypeReference)} with {@code stream}, {@code type}.
   * <p>
   * Method under test: {@link JSONSerialiser#deserialise(InputStream, TypeReference)}
   */
  @Test
  @DisplayName("Test deserialise(InputStream, TypeReference) with 'stream', 'type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JSONSerialiser.deserialise(InputStream, TypeReference)"})
  void testDeserialiseWithStreamType() throws SerialisationException {
    // Arrange
    ByteArrayInputStream stream = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    TypeReference<Object> type = mock(TypeReference.class);
    when(type.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(SerialisationException.class, () -> JSONSerialiser.deserialise(stream, type));
    verify(type).getType();
  }

  /**
   * Test {@link JSONSerialiser#deserialise(InputStream, TypeReference)} with {@code stream}, {@code type}.
   * <p>
   * Method under test: {@link JSONSerialiser#deserialise(InputStream, TypeReference)}
   */
  @Test
  @DisplayName("Test deserialise(InputStream, TypeReference) with 'stream', 'type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JSONSerialiser.deserialise(InputStream, TypeReference)"})
  void testDeserialiseWithStreamType2() throws SerialisationException {
    // Arrange
    ByteArrayInputStream stream = new ByteArrayInputStream(new byte[]{'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'});
    TypeReference<Object> type = mock(TypeReference.class);
    when(type.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(SerialisationException.class, () -> JSONSerialiser.deserialise(stream, type));
    verify(type).getType();
  }

  /**
   * Test {@link JSONSerialiser#deserialise(InputStream, TypeReference)} with {@code stream}, {@code type}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#deserialise(InputStream, TypeReference)}
   */
  @Test
  @DisplayName("Test deserialise(InputStream, TypeReference) with 'stream', 'type'; when ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JSONSerialiser.deserialise(InputStream, TypeReference)"})
  void testDeserialiseWithStreamType_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    ByteArrayInputStream stream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    TypeReference<Object> type = mock(TypeReference.class);
    when(type.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(SerialisationException.class, () -> JSONSerialiser.deserialise(stream, type));
    verify(type).getType();
  }

  /**
   * Test {@link JSONSerialiser#deserialise(InputStream, TypeReference)} with {@code stream}, {@code type}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#deserialise(InputStream, TypeReference)}
   */
  @Test
  @DisplayName("Test deserialise(InputStream, TypeReference) with 'stream', 'type'; when ByteArrayInputStream(byte[]) with empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JSONSerialiser.deserialise(InputStream, TypeReference)"})
  void testDeserialiseWithStreamType_whenByteArrayInputStreamWithEmptyArrayOfByte() throws SerialisationException {
    // Arrange
    ByteArrayInputStream stream = new ByteArrayInputStream(new byte[]{});
    TypeReference<Object> type = mock(TypeReference.class);
    when(type.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(SerialisationException.class, () -> JSONSerialiser.deserialise(stream, type));
    verify(type).getType();
  }

  /**
   * Test {@link JSONSerialiser#deserialise(InputStream, TypeReference)} with {@code stream}, {@code type}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with {@code XXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#deserialise(InputStream, TypeReference)}
   */
  @Test
  @DisplayName("Test deserialise(InputStream, TypeReference) with 'stream', 'type'; when ByteArrayInputStream(byte[]) with 'XXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object JSONSerialiser.deserialise(InputStream, TypeReference)"})
  void testDeserialiseWithStreamType_whenByteArrayInputStreamWithXxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    ByteArrayInputStream stream = new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8"));
    TypeReference<Object> type = mock(TypeReference.class);
    when(type.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(SerialisationException.class, () -> JSONSerialiser.deserialise(stream, type));
    verify(type).getType();
  }

  /**
   * Test {@link JSONSerialiser#getJsonNodeFromString(String)}.
   * <ul>
   *   <li>When {@code 42Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#getJsonNodeFromString(String)}
   */
  @Test
  @DisplayName("Test getJsonNodeFromString(String); when '42Not all who wander are lost'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JSONSerialiser.getJsonNodeFromString(String)"})
  void testGetJsonNodeFromString_when42NotAllWhoWanderAreLost() throws SerialisationException {
    // Arrange, Act and Assert
    assertThrows(SerialisationException.class,
        () -> JSONSerialiser.getJsonNodeFromString("42Not all who wander are lost"));
  }

  /**
   * Test {@link JSONSerialiser#getJsonNodeFromString(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return toPrettyString is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#getJsonNodeFromString(String)}
   */
  @Test
  @DisplayName("Test getJsonNodeFromString(String); when '42'; then return toPrettyString is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JSONSerialiser.getJsonNodeFromString(String)"})
  void testGetJsonNodeFromString_when42_thenReturnToPrettyStringIs42() throws SerialisationException {
    // Arrange and Act
    JsonNode actualJsonNodeFromString = JSONSerialiser.getJsonNodeFromString("42");

    // Assert
    assertTrue(actualJsonNodeFromString instanceof IntNode);
    assertTrue(actualJsonNodeFromString.traverse() instanceof TreeTraversingParser);
    assertEquals("42", actualJsonNodeFromString.toPrettyString());
    assertEquals(JsonNodeType.NUMBER, actualJsonNodeFromString.getNodeType());
    assertFalse(actualJsonNodeFromString.isMissingNode());
    assertFalse(((IntNode) actualJsonNodeFromString).isNaN());
    assertTrue(actualJsonNodeFromString.isInt());
    assertTrue(actualJsonNodeFromString.isIntegralNumber());
    assertTrue(actualJsonNodeFromString.isNumber());
    assertTrue(actualJsonNodeFromString.isValueNode());
  }

  /**
   * Test {@link JSONSerialiser#getJsonNodeFromString(String)}.
   * <ul>
   *   <li>When {@code 42,}.</li>
   *   <li>Then throw {@link SerialisationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#getJsonNodeFromString(String)}
   */
  @Test
  @DisplayName("Test getJsonNodeFromString(String); when '42,'; then throw SerialisationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JSONSerialiser.getJsonNodeFromString(String)"})
  void testGetJsonNodeFromString_when42_thenThrowSerialisationException() throws SerialisationException {
    // Arrange, Act and Assert
    assertThrows(SerialisationException.class, () -> JSONSerialiser.getJsonNodeFromString("42,"));
  }

  /**
   * Test {@link JSONSerialiser#getJsonNodeFromString(String)}.
   * <ul>
   *   <li>When {@code 4242}.</li>
   *   <li>Then return toPrettyString is {@code 4242}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#getJsonNodeFromString(String)}
   */
  @Test
  @DisplayName("Test getJsonNodeFromString(String); when '4242'; then return toPrettyString is '4242'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JSONSerialiser.getJsonNodeFromString(String)"})
  void testGetJsonNodeFromString_when4242_thenReturnToPrettyStringIs4242() throws SerialisationException {
    // Arrange and Act
    JsonNode actualJsonNodeFromString = JSONSerialiser.getJsonNodeFromString("4242");

    // Assert
    assertTrue(actualJsonNodeFromString instanceof IntNode);
    assertTrue(actualJsonNodeFromString.traverse() instanceof TreeTraversingParser);
    assertEquals("4242", actualJsonNodeFromString.toPrettyString());
    assertEquals(JsonNodeType.NUMBER, actualJsonNodeFromString.getNodeType());
    assertFalse(actualJsonNodeFromString.isMissingNode());
    assertFalse(((IntNode) actualJsonNodeFromString).isNaN());
    assertTrue(actualJsonNodeFromString.isInt());
    assertTrue(actualJsonNodeFromString.isIntegralNumber());
    assertTrue(actualJsonNodeFromString.isNumber());
    assertTrue(actualJsonNodeFromString.isValueNode());
  }

  /**
   * Test {@link JSONSerialiser#getJsonNodeFromString(String)}.
   * <ul>
   *   <li>When {@code ,}.</li>
   *   <li>Then throw {@link SerialisationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#getJsonNodeFromString(String)}
   */
  @Test
  @DisplayName("Test getJsonNodeFromString(String); when ','; then throw SerialisationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JSONSerialiser.getJsonNodeFromString(String)"})
  void testGetJsonNodeFromString_whenComma_thenThrowSerialisationException() throws SerialisationException {
    // Arrange, Act and Assert
    assertThrows(SerialisationException.class, () -> JSONSerialiser.getJsonNodeFromString(","));
  }

  /**
   * Test {@link JSONSerialiser#getJsonNodeFromString(String)}.
   * <ul>
   *   <li>When {@code Content}.</li>
   *   <li>Then throw {@link SerialisationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#getJsonNodeFromString(String)}
   */
  @Test
  @DisplayName("Test getJsonNodeFromString(String); when 'Content'; then throw SerialisationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JSONSerialiser.getJsonNodeFromString(String)"})
  void testGetJsonNodeFromString_whenContent_thenThrowSerialisationException() throws SerialisationException {
    // Arrange, Act and Assert
    assertThrows(SerialisationException.class, () -> JSONSerialiser.getJsonNodeFromString("Content"));
  }

  /**
   * Test {@link JSONSerialiser#getJsonNodeFromString(String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@link MissingNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#getJsonNodeFromString(String)}
   */
  @Test
  @DisplayName("Test getJsonNodeFromString(String); when empty string; then return MissingNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JSONSerialiser.getJsonNodeFromString(String)"})
  void testGetJsonNodeFromString_whenEmptyString_thenReturnMissingNode() throws SerialisationException {
    // Arrange and Act
    JsonNode actualJsonNodeFromString = JSONSerialiser.getJsonNodeFromString("");

    // Assert
    assertTrue(actualJsonNodeFromString instanceof MissingNode);
    assertTrue(actualJsonNodeFromString.traverse() instanceof TreeTraversingParser);
    assertEquals("", actualJsonNodeFromString.toPrettyString());
    assertEquals(JsonNodeType.MISSING, actualJsonNodeFromString.getNodeType());
    assertFalse(actualJsonNodeFromString.isInt());
    assertFalse(actualJsonNodeFromString.isIntegralNumber());
    assertFalse(actualJsonNodeFromString.isNumber());
    assertFalse(actualJsonNodeFromString.isValueNode());
    assertTrue(actualJsonNodeFromString.isMissingNode());
  }

  /**
   * Test {@link JSONSerialiser#getJsonNodeFromString(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JSONSerialiser#getJsonNodeFromString(String)}
   */
  @Test
  @DisplayName("Test getJsonNodeFromString(String); when 'Not all who wander are lost'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonNode JSONSerialiser.getJsonNodeFromString(String)"})
  void testGetJsonNodeFromString_whenNotAllWhoWanderAreLost() throws SerialisationException {
    // Arrange, Act and Assert
    assertThrows(SerialisationException.class,
        () -> JSONSerialiser.getJsonNodeFromString("Not all who wander are lost"));
  }
}
