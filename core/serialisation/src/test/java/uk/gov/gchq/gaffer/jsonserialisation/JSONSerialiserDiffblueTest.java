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
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.io.ContentReference;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;
import com.fasterxml.jackson.core.util.JsonParserDelegate;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.cfg.ContextAttributes;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig;
import com.fasterxml.jackson.databind.deser.BeanDeserializerFactory;
import com.fasterxml.jackson.databind.deser.DefaultDeserializationContext;
import com.fasterxml.jackson.databind.deser.DeserializerFactory;
import com.fasterxml.jackson.databind.deser.Deserializers;
import com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy;
import com.fasterxml.jackson.databind.introspect.BasicClassIntrospector;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.introspect.DefaultAccessorNamingStrategy;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.SubtypeResolver;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.module.SimpleDeserializers;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.module.SimpleSerializers;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.fasterxml.jackson.databind.ser.impl.FailingSerializer;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.databind.ser.std.NullSerializer;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ArrayIterator;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.databind.util.TokenBuffer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Set;
import java.util.TimeZone;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.exception.SerialisationException;
import uk.gov.gchq.gaffer.jsonserialisation.jackson.IterableDeserializer;
import uk.gov.gchq.koryphe.serialisation.json.DelegatingAnnotationIntrospector;

class JSONSerialiserDiffblueTest {
  /**
   * Method under test: {@link JSONSerialiser#registerModules(Collection)}
   */
  @Test
  void testRegisterModules() {
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
   * Method under test: {@link JSONSerialiser#registerModules(Collection)}
   */
  @Test
  void testRegisterModules2() {
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
   * Method under test: {@link JSONSerialiser#registerModules(Collection)}
   */
  @Test
  void testRegisterModules3() {
    // Arrange
    JSONSerialiser instance = JSONSerialiser.getInstance();
    SimpleModule simpleModule = mock(SimpleModule.class);
    Mockito.<Iterable<? extends Module>>when(simpleModule.getDependencies()).thenReturn(new ArrayList<>());
    when(simpleModule.getTypeId()).thenReturn(null);
    doNothing().when(simpleModule).setupModule(Mockito.<Module.SetupContext>any());
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
    verify(simpleModule).setupModule(isA(Module.SetupContext.class));
    verify(simpleModule).version();
  }

  /**
   * Method under test: {@link JSONSerialiser#registerModules(Module[])}
   */
  @Test
  void testRegisterModules4() {
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
   * Method under test: {@link JSONSerialiser#registerModules(Module[])}
   */
  @Test
  void testRegisterModules5() {
    // Arrange
    JSONSerialiser jsonSerialiser = new JSONSerialiser();
    SimpleModule simpleModule = mock(SimpleModule.class);
    Mockito.<Iterable<? extends Module>>when(simpleModule.getDependencies()).thenReturn(new ArrayList<>());
    when(simpleModule.getTypeId()).thenReturn("Type Id");
    doNothing().when(simpleModule).setupModule(Mockito.<Module.SetupContext>any());
    when(simpleModule.version()).thenReturn(Version.unknownVersion());
    when(simpleModule.getModuleName()).thenReturn("Module Name");

    // Act
    jsonSerialiser.registerModules(simpleModule);

    // Assert
    verify(simpleModule).getDependencies();
    verify(simpleModule).getModuleName();
    verify(simpleModule).getTypeId();
    verify(simpleModule).setupModule(isA(Module.SetupContext.class));
    verify(simpleModule).version();
  }

  /**
   * Method under test: {@link JSONSerialiser#registerModules(Module[])}
   */
  @Test
  void testRegisterModules6() {
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
   * Method under test: {@link JSONSerialiser#update(String, String, Boolean)}
   */
  @Test
  void testUpdate() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> JSONSerialiser.update("Json Serialiser Class", "Json Serialiser Modules", true));
    assertThrows(IllegalArgumentException.class, () -> JSONSerialiser.update("Json Serialiser Class", null, true));
    assertThrows(IllegalArgumentException.class, () -> JSONSerialiser.update(",", "Json Serialiser Modules", true));
    assertThrows(IllegalArgumentException.class, () -> JSONSerialiser.update("Json Serialiser Class", ",", true));
    assertThrows(IllegalArgumentException.class, () -> JSONSerialiser
        .update(System.getProperty(JSONSerialiser.JSON_SERIALISER_CLASS_KEY), "Json Serialiser Modules", true));
  }

  /**
   * Method under test: {@link JSONSerialiser#createDefaultMapper()}
   */
  @Test
  void testCreateDefaultMapper() throws MissingResourceException {
    // Arrange and Act
    ObjectMapper actualCreateDefaultMapperResult = JSONSerialiser.createDefaultMapper();

    // Assert
    SerializationConfig serializationConfig = actualCreateDefaultMapperResult.getSerializationConfig();
    assertTrue(serializationConfig.getDefaultPrettyPrinter() instanceof DefaultPrettyPrinter);
    JsonFactory factory = actualCreateDefaultMapperResult.getFactory();
    assertTrue(factory instanceof MappingJsonFactory);
    DeserializationConfig deserializationConfig = actualCreateDefaultMapperResult.getDeserializationConfig();
    ContextAttributes attributes = deserializationConfig.getAttributes();
    assertTrue(attributes instanceof ContextAttributes.Impl);
    DeserializationContext deserializationContext = actualCreateDefaultMapperResult.getDeserializationContext();
    DeserializerFactory factory2 = deserializationContext.getFactory();
    assertTrue(factory2 instanceof BeanDeserializerFactory);
    assertTrue(deserializationContext instanceof DefaultDeserializationContext.Impl);
    ClassIntrospector classIntrospector = deserializationConfig.getClassIntrospector();
    assertTrue(classIntrospector instanceof BasicClassIntrospector);
    AccessorNamingStrategy.Provider accessorNaming = deserializationConfig.getAccessorNaming();
    assertTrue(accessorNaming instanceof DefaultAccessorNamingStrategy.Provider);
    VisibilityChecker<?> visibilityChecker = actualCreateDefaultMapperResult.getVisibilityChecker();
    assertTrue(visibilityChecker instanceof VisibilityChecker.Std);
    PolymorphicTypeValidator polymorphicTypeValidator = actualCreateDefaultMapperResult.getPolymorphicTypeValidator();
    assertTrue(polymorphicTypeValidator instanceof LaissezFaireSubTypeValidator);
    SubtypeResolver subtypeResolver = actualCreateDefaultMapperResult.getSubtypeResolver();
    assertTrue(subtypeResolver instanceof StdSubtypeResolver);
    DeserializerFactoryConfig factoryConfig = ((BeanDeserializerFactory) factory2).getFactoryConfig();
    Iterable<Deserializers> deserializersResult = factoryConfig.deserializers();
    assertTrue(((ArrayIterator<Deserializers>) deserializersResult).next() instanceof SimpleDeserializers);
    assertTrue(((ArrayIterator<Deserializers>) deserializersResult).next() instanceof SimpleDeserializers);
    SerializerFactory serializerFactory = actualCreateDefaultMapperResult.getSerializerFactory();
    SerializerFactoryConfig factoryConfig2 = ((BeanSerializerFactory) serializerFactory).getFactoryConfig();
    Iterable<Serializers> serializersResult = factoryConfig2.serializers();
    assertTrue(((ArrayIterator<Serializers>) serializersResult).next() instanceof SimpleSerializers);
    assertTrue(((ArrayIterator<Serializers>) serializersResult).next() instanceof SimpleSerializers);
    assertTrue(serializerFactory instanceof BeanSerializerFactory);
    SerializerProvider serializerProvider = actualCreateDefaultMapperResult.getSerializerProvider();
    assertTrue(serializerProvider instanceof DefaultSerializerProvider.Impl);
    SerializerProvider serializerProviderInstance = actualCreateDefaultMapperResult.getSerializerProviderInstance();
    assertTrue(serializerProviderInstance instanceof DefaultSerializerProvider.Impl);
    JsonSerializer<Object> defaultNullKeySerializer = serializerProvider.getDefaultNullKeySerializer();
    assertTrue(defaultNullKeySerializer instanceof FailingSerializer);
    FilterProvider filterProvider = serializationConfig.getFilterProvider();
    assertTrue(filterProvider instanceof SimpleFilterProvider);
    JsonSerializer<Object> defaultNullValueSerializer = serializerProvider.getDefaultNullValueSerializer();
    assertTrue(defaultNullValueSerializer instanceof NullSerializer);
    assertTrue(deserializersResult instanceof ArrayIterator);
    assertTrue(serializersResult instanceof ArrayIterator);
    DateFormat dateFormat = actualCreateDefaultMapperResult.getDateFormat();
    assertTrue(dateFormat instanceof StdDateFormat);
    AnnotationIntrospector annotationIntrospector = deserializationConfig.getAnnotationIntrospector();
    assertTrue(annotationIntrospector instanceof DelegatingAnnotationIntrospector);
    assertEquals(" ", factory.getRootValueSeparator());
    Locale locale = deserializationConfig.getLocale();
    assertEquals("", locale.getCountry());
    assertEquals("", locale.getDisplayCountry());
    assertEquals("", locale.getDisplayScript());
    assertEquals("", locale.getDisplayVariant());
    assertEquals("", locale.getISO3Country());
    assertEquals("", locale.getScript());
    assertEquals("", locale.getVariant());
    TimeZone timeZone = deserializationConfig.getTimeZone();
    assertEquals("Coordinated Universal Time", timeZone.getDisplayName());
    assertEquals("English", locale.getDisplayLanguage());
    assertEquals("English", locale.getDisplayName());
    assertEquals("JSON", factory.getFormatName());
    Base64Variant base64Variant = deserializationConfig.getBase64Variant();
    assertEquals("MIME-NO-LINEFEEDS", base64Variant.getName());
    assertEquals("MIME-NO-LINEFEEDS", base64Variant.toString());
    assertEquals("UTC", timeZone.getID());
    assertEquals("[one of: 'yyyy-MM-dd'T'HH:mm:ss.SSSX', 'EEE, dd MMM yyyy HH:mm:ss zzz' (lenient)]",
        ((StdDateFormat) dateFormat).toPattern());
    Version versionResult = factory.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    Version versionResult2 = actualCreateDefaultMapperResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult2.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-core/2.13.5", versionResult.toFullString());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.13.5", versionResult2.toFullString());
    assertEquals("en", locale.getLanguage());
    assertEquals("eng", locale.getISO3Language());
    assertEquals("jackson-core", versionResult.getArtifactId());
    assertEquals("jackson-databind", versionResult2.getArtifactId());
    assertEquals('=', base64Variant.getPaddingChar());
    assertNull(serializerProvider.getGenerator());
    assertNull(serializerProviderInstance.getGenerator());
    assertNull(deserializationContext.getParser());
    assertNull(factory.getCharacterEscapes());
    assertNull(factory.getInputDecorator());
    assertNull(factory.getOutputDecorator());
    assertNull(deserializationContext.getConfig());
    assertNull(actualCreateDefaultMapperResult.getInjectableValues());
    assertNull(deserializationContext.getContextualType());
    assertNull(defaultNullKeySerializer.getDelegatee());
    assertNull(defaultNullValueSerializer.getDelegatee());
    assertNull(deserializationConfig.getFullRootName());
    assertNull(serializationConfig.getFullRootName());
    assertNull(actualCreateDefaultMapperResult.getPropertyNamingStrategy());
    assertNull(deserializationConfig.getPropertyNamingStrategy());
    assertNull(serializationConfig.getPropertyNamingStrategy());
    assertNull(serializerProvider.getConfig());
    assertNull(deserializationConfig.getHandlerInstantiator());
    assertNull(serializationConfig.getHandlerInstantiator());
    assertNull(((SimpleFilterProvider) filterProvider).getDefaultFilter());
    assertNull(deserializationConfig.getProblemHandlers());
    assertNull(deserializationConfig.getDefaultMergeable());
    assertNull(serializationConfig.getDefaultMergeable());
    assertNull(factory.getFormatReadFeatureType());
    assertNull(factory.getFormatWriteFeatureType());
    JsonInclude.Value defaultPropertyInclusion = deserializationConfig.getDefaultPropertyInclusion();
    assertNull(defaultPropertyInclusion.getContentFilter());
    assertNull(defaultPropertyInclusion.getValueFilter());
    assertNull(deserializationContext.getActiveView());
    assertNull(serializerProvider.getActiveView());
    assertNull(serializerProviderInstance.getActiveView());
    assertNull(deserializationConfig.getActiveView());
    assertNull(serializationConfig.getActiveView());
    TypeFactory typeFactory = actualCreateDefaultMapperResult.getTypeFactory();
    assertNull(typeFactory.getClassLoader());
    assertNull(deserializationConfig.getRootName());
    assertNull(serializationConfig.getRootName());
    assertNull(dateFormat.getNumberFormat());
    assertNull(dateFormat.getCalendar());
    assertNull(dateFormat.getTimeZone());
    assertEquals(0, factory.getFormatGeneratorFeatures());
    assertEquals(0, factory.getFormatParserFeatures());
    assertEquals(0, deserializationContext.getDeserializationFeatures());
    assertEquals(0, timeZone.getDSTSavings());
    assertEquals(13, versionResult.getMinorVersion());
    assertEquals(13, versionResult2.getMinorVersion());
    assertEquals(16385, factory.getParserFeatures());
    assertEquals(169911424, deserializationConfig.getDeserializationFeatures());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult2.getMajorVersion());
    assertEquals(21771192, serializationConfig.getSerializationFeatures());
    assertEquals(3, actualCreateDefaultMapperResult.getRegisteredModuleIds().size());
    assertEquals(31, factory.getGeneratorFeatures());
    assertEquals(5, versionResult.getPatchLevel());
    assertEquals(5, versionResult2.getPatchLevel());
    assertEquals(JsonInclude.Include.NON_NULL, defaultPropertyInclusion.getContentInclusion());
    assertEquals(JsonInclude.Include.NON_NULL, defaultPropertyInclusion.getValueInclusion());
    assertEquals(JsonInclude.Include.NON_NULL, serializationConfig.getSerializationInclusion());
    JsonSetter.Value defaultSetterInfo = deserializationConfig.getDefaultSetterInfo();
    assertEquals(Nulls.DEFAULT, defaultSetterInfo.getContentNulls());
    assertEquals(Nulls.DEFAULT, defaultSetterInfo.getValueNulls());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult2.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult2.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(versionResult2.isUnknownVersion());
    assertFalse(defaultNullKeySerializer.isUnwrappingSerializer());
    assertFalse(defaultNullValueSerializer.isUnwrappingSerializer());
    assertFalse(factoryConfig.hasAbstractTypeResolvers());
    assertFalse(factoryConfig.hasDeserializerModifiers());
    assertFalse(deserializationConfig.hasExplicitTimeZone());
    assertFalse(serializationConfig.hasExplicitTimeZone());
    assertFalse(factoryConfig2.hasSerializerModifiers());
    assertFalse(((ArrayIterator<Serializers>) serializersResult).hasNext());
    assertFalse(locale.hasExtensions());
    assertTrue(factoryConfig.hasDeserializers());
    assertTrue(factoryConfig.hasKeyDeserializers());
    assertTrue(factoryConfig.hasValueInstantiators());
    assertTrue(deserializationConfig.isAnnotationProcessingEnabled());
    assertTrue(serializationConfig.isAnnotationProcessingEnabled());
    assertTrue(factoryConfig2.hasKeySerializers());
    assertTrue(factoryConfig2.hasSerializers());
    assertTrue(((ArrayIterator<Deserializers>) deserializersResult).hasNext());
    assertTrue(((StdDateFormat) dateFormat).isColonIncludedInTimeZone());
    assertTrue(dateFormat.isLenient());
    Set<Character> extensionKeys = locale.getExtensionKeys();
    assertTrue(extensionKeys.isEmpty());
    assertEquals(Integer.MAX_VALUE, base64Variant.getMaxLineLength());
    assertEquals('=', base64Variant.getPaddingByte());
    assertSame(serializationConfig, serializerProviderInstance.getConfig());
    assertSame(typeFactory, serializerProviderInstance.getTypeFactory());
    assertSame(typeFactory, deserializationConfig.getTypeFactory());
    assertSame(typeFactory, serializationConfig.getTypeFactory());
    assertSame(versionResult2, annotationIntrospector.version());
    assertSame(base64Variant, serializationConfig.getBase64Variant());
    assertSame(locale, serializerProviderInstance.getLocale());
    assertSame(locale, serializationConfig.getLocale());
    assertSame(timeZone, serializerProviderInstance.getTimeZone());
    assertSame(timeZone, serializationConfig.getTimeZone());
    assertSame(defaultPropertyInclusion, serializationConfig.getDefaultPropertyInclusion());
    assertSame(defaultSetterInfo, serializationConfig.getDefaultSetterInfo());
    assertSame(extensionKeys, locale.getUnicodeLocaleAttributes());
    assertSame(extensionKeys, locale.getUnicodeLocaleKeys());
    assertSame(actualCreateDefaultMapperResult, factory.getCodec());
    assertSame(factory, actualCreateDefaultMapperResult.getJsonFactory());
    assertSame(attributes, serializationConfig.getAttributes());
    assertSame(classIntrospector, serializationConfig.getClassIntrospector());
    assertSame(accessorNaming, serializationConfig.getAccessorNaming());
    assertSame(visibilityChecker, deserializationConfig.getDefaultVisibilityChecker());
    assertSame(visibilityChecker, serializationConfig.getDefaultVisibilityChecker());
    assertSame(polymorphicTypeValidator, deserializationConfig.getPolymorphicTypeValidator());
    assertSame(polymorphicTypeValidator, serializationConfig.getPolymorphicTypeValidator());
    assertSame(subtypeResolver, deserializationConfig.getSubtypeResolver());
    assertSame(subtypeResolver, serializationConfig.getSubtypeResolver());
    assertSame(defaultNullKeySerializer, serializerProviderInstance.getDefaultNullKeySerializer());
    assertSame(filterProvider, serializerProviderInstance.getFilterProvider());
    assertSame(defaultNullValueSerializer, serializerProviderInstance.getDefaultNullValueSerializer());
    assertSame(dateFormat, deserializationConfig.getDateFormat());
    assertSame(dateFormat, serializationConfig.getDateFormat());
    assertSame(annotationIntrospector, serializerProviderInstance.getAnnotationIntrospector());
    assertSame(annotationIntrospector, serializationConfig.getAnnotationIntrospector());
  }

  /**
   * Method under test: {@link JSONSerialiser#getFilterProvider(String[])}
   */
  @Test
  void testGetFilterProvider() {
    // Arrange and Act
    FilterProvider actualFilterProvider = JSONSerialiser.getFilterProvider("Fields To Exclude");

    // Assert
    assertTrue(actualFilterProvider instanceof SimpleFilterProvider);
    assertNull(((SimpleFilterProvider) actualFilterProvider).getDefaultFilter());
  }

  /**
   * Method under test: {@link JSONSerialiser#getFilterProvider(String[])}
   */
  @Test
  void testGetFilterProvider2() {
    // Arrange and Act
    FilterProvider actualFilterProvider = JSONSerialiser.getFilterProvider(null);

    // Assert
    assertTrue(actualFilterProvider instanceof SimpleFilterProvider);
    assertNull(((SimpleFilterProvider) actualFilterProvider).getDefaultFilter());
  }

  /**
   * Method under test: {@link JSONSerialiser#getFilterProvider(String[])}
   */
  @Test
  void testGetFilterProvider3() {
    // Arrange and Act
    FilterProvider actualFilterProvider = JSONSerialiser.getFilterProvider();

    // Assert
    assertTrue(actualFilterProvider instanceof SimpleFilterProvider);
    assertNull(((SimpleFilterProvider) actualFilterProvider).getDefaultFilter());
  }

  /**
   * Method under test: {@link JSONSerialiser#canHandle(Class)}
   */
  @Test
  void testCanHandle() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertTrue(JSONSerialiser.canHandle(clazz));
  }

  /**
   * Method under test:
   * {@link JSONSerialiser#serialise(Object, JsonGenerator, boolean, String[])}
   */
  @Test
  void testSerialise() throws SerialisationException {
    // Arrange
    BufferRecycler br = new BufferRecycler();
    IOContext ctxt = new IOContext(br, ContentReference.unknown(), true);

    ObjectMapper codec = JSONSerialiser.createDefaultMapper();
    ByteArrayOutputStream out = new ByteArrayOutputStream(1);
    UTF8JsonGenerator d = new UTF8JsonGenerator(ctxt, 1, codec, out);

    JsonGeneratorDelegate jsonGenerator = new JsonGeneratorDelegate(d, true);

    // Act
    JSONSerialiser.serialise("Object", jsonGenerator, true, "Fields To Exclude");

    // Assert
    JsonStreamContext outputContext = jsonGenerator.getOutputContext();
    assertTrue(outputContext instanceof JsonWriteContext);
    JsonGenerator delegateResult = jsonGenerator.delegate();
    assertTrue(delegateResult instanceof UTF8JsonGenerator);
    PrettyPrinter prettyPrinter = jsonGenerator.getPrettyPrinter();
    assertTrue(prettyPrinter instanceof DefaultPrettyPrinter);
    assertEquals(1, outputContext.getEntryCount());
    assertTrue(outputContext.hasCurrentIndex());
    assertSame(d, delegateResult);
    assertSame(out, jsonGenerator.getOutputTarget());
    assertSame(prettyPrinter, delegateResult.getPrettyPrinter());
  }

  /**
   * Method under test:
   * {@link JSONSerialiser#serialise(Object, JsonGenerator, boolean, String[])}
   */
  @Test
  void testSerialise2() throws SerialisationException {
    // Arrange
    TokenBuffer d = new TokenBuffer(new JsonParserDelegate(new TreeTraversingParser(MissingNode.getInstance())));
    JsonGeneratorDelegate jsonGenerator = new JsonGeneratorDelegate(d, true);

    // Act
    JSONSerialiser.serialise("Object", jsonGenerator, true, "Fields To Exclude");

    // Assert
    JsonStreamContext outputContext = jsonGenerator.getOutputContext();
    assertTrue(outputContext instanceof JsonWriteContext);
    JsonGenerator delegateResult = jsonGenerator.delegate();
    assertTrue(delegateResult instanceof TokenBuffer);
    assertEquals(1, outputContext.getEntryCount());
    assertFalse(((TokenBuffer) delegateResult).isEmpty());
    assertTrue(outputContext.hasCurrentIndex());
    assertSame(d, delegateResult);
  }

  /**
   * Method under test:
   * {@link JSONSerialiser#serialise(Object, JsonGenerator, boolean, String[])}
   */
  @Test
  void testSerialise3() throws IOException {
    // Arrange
    JsonGenerator d = mock(JsonGenerator.class);
    doNothing().when(d).flush();
    doNothing().when(d).writeNull();

    // Act
    JSONSerialiser.serialise(null, new JsonGeneratorDelegate(new JsonGeneratorDelegate(d), true), false, null);

    // Assert
    verify(d).flush();
    verify(d).writeNull();
  }

  /**
   * Method under test:
   * {@link JSONSerialiser#serialise(Object, JsonGenerator, boolean, String[])}
   */
  @Test
  void testSerialise4() throws SerialisationException {
    // Arrange
    new SerialisationException("An error occurred");
    new SerialisationException("An error occurred");
    BufferRecycler br = new BufferRecycler();
    IOContext ctxt = new IOContext(br, ContentReference.unknown(), true);

    ObjectMapper codec = JSONSerialiser.createDefaultMapper();
    ByteArrayOutputStream out = new ByteArrayOutputStream(1);
    UTF8JsonGenerator d = new UTF8JsonGenerator(ctxt, 1, codec, out);

    JsonGeneratorDelegate jsonGenerator = new JsonGeneratorDelegate(d, true);

    // Act
    JSONSerialiser.serialise(JSONSerialiser.FILTER_FIELDS_BY_NAME, jsonGenerator, false, null);

    // Assert
    JsonStreamContext outputContext = jsonGenerator.getOutputContext();
    assertTrue(outputContext instanceof JsonWriteContext);
    JsonGenerator delegateResult = jsonGenerator.delegate();
    assertTrue(delegateResult instanceof UTF8JsonGenerator);
    assertNull(delegateResult.getPrettyPrinter());
    assertNull(jsonGenerator.getPrettyPrinter());
    assertEquals(1, outputContext.getEntryCount());
    assertTrue(outputContext.hasCurrentIndex());
    assertSame(d, delegateResult);
    assertSame(out, jsonGenerator.getOutputTarget());
  }

  /**
   * Method under test:
   * {@link JSONSerialiser#serialise(Object, JsonGenerator, boolean, String[])}
   */
  @Test
  void testSerialise5() throws SerialisationException {
    // Arrange
    new SerialisationException("An error occurred");
    new SerialisationException("An error occurred");
    BufferRecycler br = new BufferRecycler();
    IOContext ctxt = new IOContext(br, ContentReference.unknown(), true);

    ObjectMapper codec = JSONSerialiser.createDefaultMapper();
    ByteArrayOutputStream out = new ByteArrayOutputStream(1);
    JsonGeneratorDelegate jsonGenerator = new JsonGeneratorDelegate(new UTF8JsonGenerator(ctxt, -1, codec, out), true);

    // Act
    JSONSerialiser.serialise(JSONSerialiser.FILTER_FIELDS_BY_NAME, jsonGenerator, false, null);

    // Assert
    JsonStreamContext outputContext = jsonGenerator.getOutputContext();
    assertTrue(outputContext instanceof JsonWriteContext);
    assertEquals(1, outputContext.getEntryCount());
    assertTrue(outputContext.hasCurrentIndex());
    assertSame(out, jsonGenerator.getOutputTarget());
  }

  /**
   * Method under test:
   * {@link JSONSerialiser#deserialise(InputStream, TypeReference)}
   */
  @Test
  void testDeserialise() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    ByteArrayInputStream stream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    TypeReference<Object> type = mock(TypeReference.class);
    when(type.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(SerialisationException.class, () -> JSONSerialiser.deserialise(stream, type));
    verify(type).getType();
  }

  /**
   * Method under test:
   * {@link JSONSerialiser#deserialise(InputStream, TypeReference)}
   */
  @Test
  void testDeserialise2() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    ByteArrayInputStream stream = new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8"));
    TypeReference<Object> type = mock(TypeReference.class);
    when(type.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(SerialisationException.class, () -> JSONSerialiser.deserialise(stream, type));
    verify(type).getType();
  }

  /**
   * Method under test:
   * {@link JSONSerialiser#deserialise(InputStream, TypeReference)}
   */
  @Test
  void testDeserialise3() throws SerialisationException {
    // Arrange
    ByteArrayInputStream stream = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    TypeReference<Object> type = mock(TypeReference.class);
    when(type.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(SerialisationException.class, () -> JSONSerialiser.deserialise(stream, type));
    verify(type).getType();
  }

  /**
   * Method under test:
   * {@link JSONSerialiser#deserialise(InputStream, TypeReference)}
   */
  @Test
  void testDeserialise4() throws SerialisationException {
    // Arrange
    ByteArrayInputStream stream = new ByteArrayInputStream(new byte[]{'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'});
    TypeReference<Object> type = mock(TypeReference.class);
    when(type.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(SerialisationException.class, () -> JSONSerialiser.deserialise(stream, type));
    verify(type).getType();
  }

  /**
   * Method under test:
   * {@link JSONSerialiser#deserialise(InputStream, TypeReference)}
   */
  @Test
  void testDeserialise5() throws SerialisationException {
    // Arrange
    ByteArrayInputStream stream = new ByteArrayInputStream(new byte[]{});
    TypeReference<Object> type = mock(TypeReference.class);
    when(type.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(SerialisationException.class, () -> JSONSerialiser.deserialise(stream, type));
    verify(type).getType();
  }

  /**
   * Method under test: {@link JSONSerialiser#deserialise(InputStream, Class)}
   */
  @Test
  void testDeserialise6() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    ByteArrayInputStream stream = new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8"));
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(SerialisationException.class, () -> JSONSerialiser.deserialise(stream, clazz));
  }

  /**
   * Method under test: {@link JSONSerialiser#deserialise(InputStream, Class)}
   */
  @Test
  void testDeserialise7() throws SerialisationException {
    // Arrange
    ByteArrayInputStream stream = new ByteArrayInputStream(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'});
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(SerialisationException.class, () -> JSONSerialiser.deserialise(stream, clazz));
  }

  /**
   * Method under test: {@link JSONSerialiser#deserialise(InputStream, Class)}
   */
  @Test
  void testDeserialise8() throws SerialisationException {
    // Arrange
    ByteArrayInputStream stream = new ByteArrayInputStream(new byte[]{'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'});
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(SerialisationException.class, () -> JSONSerialiser.deserialise(stream, clazz));
  }

  /**
   * Method under test: {@link JSONSerialiser#deserialise(InputStream, Class)}
   */
  @Test
  void testDeserialise9() throws SerialisationException {
    // Arrange
    ByteArrayInputStream stream = new ByteArrayInputStream(new byte[]{});
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(SerialisationException.class, () -> JSONSerialiser.deserialise(stream, clazz));
  }

  /**
   * Method under test: {@link JSONSerialiser#deserialise(String, Class)}
   */
  @Test
  void testDeserialise10() throws SerialisationException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(SerialisationException.class, () -> JSONSerialiser.deserialise("Json", clazz));
  }

  /**
   * Method under test: {@link JSONSerialiser#deserialise(String, Class)}
   */
  @Test
  void testDeserialise11() throws SerialisationException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(SerialisationException.class, () -> JSONSerialiser.deserialise("", clazz));
  }

  /**
   * Method under test: {@link JSONSerialiser#deserialise(String, Class)}
   */
  @Test
  void testDeserialise12() throws SerialisationException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(SerialisationException.class, () -> JSONSerialiser.deserialise(",", clazz));
  }

  /**
   * Method under test: {@link JSONSerialiser#deserialise(String, Class)}
   */
  @Test
  void testDeserialise13() throws SerialisationException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(SerialisationException.class,
        () -> JSONSerialiser.deserialise(JSONSerialiser.JSON_SERIALISER_CLASS_KEY, clazz));
  }

  /**
   * Method under test: {@link JSONSerialiser#deserialise(byte[], TypeReference)}
   */
  @Test
  void testDeserialise14() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    TypeReference<Object> type = mock(TypeReference.class);
    when(type.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(SerialisationException.class, () -> JSONSerialiser.deserialise(bytes, type));
    verify(type).getType();
  }

  /**
   * Method under test: {@link JSONSerialiser#deserialise(byte[], TypeReference)}
   */
  @Test
  void testDeserialise15() throws SerialisationException {
    // Arrange
    TypeReference<Object> type = mock(TypeReference.class);
    when(type.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(SerialisationException.class,
        () -> JSONSerialiser.deserialise(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, type));
    verify(type).getType();
  }

  /**
   * Method under test: {@link JSONSerialiser#deserialise(byte[], TypeReference)}
   */
  @Test
  void testDeserialise16() throws SerialisationException {
    // Arrange
    TypeReference<Object> type = mock(TypeReference.class);
    when(type.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(SerialisationException.class,
        () -> JSONSerialiser.deserialise(new byte[]{'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'}, type));
    verify(type).getType();
  }

  /**
   * Method under test: {@link JSONSerialiser#deserialise(byte[], TypeReference)}
   */
  @Test
  void testDeserialise17() throws SerialisationException {
    // Arrange
    TypeReference<Object> type = mock(TypeReference.class);
    when(type.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(SerialisationException.class, () -> JSONSerialiser.deserialise(new byte[]{}, type));
    verify(type).getType();
  }

  /**
   * Method under test: {@link JSONSerialiser#deserialise(byte[], TypeReference)}
   */
  @Test
  void testDeserialise18() throws SerialisationException {
    // Arrange
    TypeReference<Object> type = mock(TypeReference.class);
    when(type.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(SerialisationException.class,
        () -> JSONSerialiser.deserialise(new byte[]{0, 0, 'A', 'X', 'A', 'X', 'A', 'X'}, type));
    verify(type).getType();
  }

  /**
   * Method under test: {@link JSONSerialiser#deserialise(byte[], TypeReference)}
   */
  @Test
  void testDeserialise19() throws SerialisationException {
    // Arrange
    TypeReference<Object> type = mock(TypeReference.class);
    when(type.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(SerialisationException.class,
        () -> JSONSerialiser.deserialise(new byte[]{0, Byte.MAX_VALUE, 'A', 'X', 'A', 'X', 'A', 'X'}, type));
    verify(type).getType();
  }

  /**
   * Method under test: {@link JSONSerialiser#deserialise(byte[], TypeReference)}
   */
  @Test
  void testDeserialise20() throws SerialisationException {
    // Arrange
    TypeReference<Object> type = mock(TypeReference.class);
    when(type.getType()).thenReturn(new PlaceholderForType(1));

    // Act and Assert
    assertThrows(SerialisationException.class,
        () -> JSONSerialiser.deserialise(new byte[]{0, 0, 0, 'X', 'A', 'X', 'A', 'X'}, type));
    verify(type).getType();
  }

  /**
   * Method under test: {@link JSONSerialiser#deserialise(byte[], TypeReference)}
   */
  @Test
  void testDeserialise21() throws SerialisationException {
    // Arrange, Act and Assert
    assertThrows(SerialisationException.class, () -> JSONSerialiser
        .<Object>deserialise(new byte[]{0, 0, 'A', 0, 'A', 'X', 'A', 'X'}, mock(TypeReference.class)));
  }

  /**
   * Method under test: {@link JSONSerialiser#deserialise(byte[], Class)}
   */
  @Test
  void testDeserialise22() throws UnsupportedEncodingException, SerialisationException {
    // Arrange
    byte[] bytes = "AXAXAXAX".getBytes("UTF-8");
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(SerialisationException.class, () -> JSONSerialiser.deserialise(bytes, clazz));
  }

  /**
   * Method under test: {@link JSONSerialiser#deserialise(byte[], Class)}
   */
  @Test
  void testDeserialise23() throws SerialisationException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(SerialisationException.class,
        () -> JSONSerialiser.deserialise(new byte[]{0, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, clazz));
  }

  /**
   * Method under test: {@link JSONSerialiser#deserialise(byte[], Class)}
   */
  @Test
  void testDeserialise24() throws SerialisationException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(SerialisationException.class,
        () -> JSONSerialiser.deserialise(new byte[]{'A', 0, 'A', 'X', 'A', 'X', 'A', 'X'}, clazz));
  }

  /**
   * Method under test: {@link JSONSerialiser#deserialise(byte[], Class)}
   */
  @Test
  void testDeserialise25() throws SerialisationException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(SerialisationException.class, () -> JSONSerialiser.deserialise(new byte[]{}, clazz));
  }

  /**
   * Method under test: {@link JSONSerialiser#deserialise(byte[], Class)}
   */
  @Test
  void testDeserialise26() throws SerialisationException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(SerialisationException.class,
        () -> JSONSerialiser.deserialise(new byte[]{0, 0, 'A', 'X', 'A', 'X', 'A', 'X'}, clazz));
  }

  /**
   * Method under test: {@link JSONSerialiser#deserialise(byte[], Class)}
   */
  @Test
  void testDeserialise27() throws SerialisationException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(SerialisationException.class,
        () -> JSONSerialiser.deserialise(new byte[]{0, Byte.MAX_VALUE, 'A', 'X', 'A', 'X', 'A', 'X'}, clazz));
  }

  /**
   * Method under test: {@link JSONSerialiser#deserialise(byte[], Class)}
   */
  @Test
  void testDeserialise28() throws SerialisationException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(SerialisationException.class,
        () -> JSONSerialiser.deserialise(new byte[]{0, 0, 0, 'X', 'A', 'X', 'A', 'X'}, clazz));
  }

  /**
   * Method under test: {@link JSONSerialiser#deserialise(byte[], Class)}
   */
  @Test
  void testDeserialise29() throws SerialisationException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertThrows(SerialisationException.class,
        () -> JSONSerialiser.deserialise(new byte[]{0, 0, 'A', 0, 'A', 'X', 'A', 'X'}, clazz));
  }

  /**
   * Method under test: {@link JSONSerialiser#getJsonNodeFromString(String)}
   */
  @Test
  void testGetJsonNodeFromString() throws SerialisationException {
    // Arrange, Act and Assert
    assertThrows(SerialisationException.class,
        () -> JSONSerialiser.getJsonNodeFromString("Not all who wander are lost"));
    assertThrows(SerialisationException.class, () -> JSONSerialiser.getJsonNodeFromString("Content"));
    assertThrows(SerialisationException.class, () -> JSONSerialiser.getJsonNodeFromString(","));
    assertThrows(SerialisationException.class,
        () -> JSONSerialiser.getJsonNodeFromString("42Not all who wander are lost"));
    assertThrows(SerialisationException.class, () -> JSONSerialiser.getJsonNodeFromString("42,"));
  }

  /**
   * Method under test: {@link JSONSerialiser#getJsonNodeFromString(String)}
   */
  @Test
  void testGetJsonNodeFromString2() throws IOException {
    // Arrange and Act
    JsonNode actualJsonNodeFromString = JSONSerialiser.getJsonNodeFromString("");

    // Assert
    assertTrue(actualJsonNodeFromString instanceof MissingNode);
    JsonParser traverseResult = actualJsonNodeFromString.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("", actualJsonNodeFromString.toPrettyString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.13.5", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, actualJsonNodeFromString.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(13, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(5, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.MISSING, actualJsonNodeFromString.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(actualJsonNodeFromString.isArray());
    assertFalse(actualJsonNodeFromString.isBigDecimal());
    assertFalse(actualJsonNodeFromString.isBigInteger());
    assertFalse(actualJsonNodeFromString.isBinary());
    assertFalse(actualJsonNodeFromString.isBoolean());
    assertFalse(actualJsonNodeFromString.isContainerNode());
    assertFalse(actualJsonNodeFromString.isDouble());
    assertFalse(actualJsonNodeFromString.isFloat());
    assertFalse(actualJsonNodeFromString.isFloatingPointNumber());
    assertFalse(actualJsonNodeFromString.isInt());
    assertFalse(actualJsonNodeFromString.isIntegralNumber());
    assertFalse(actualJsonNodeFromString.isLong());
    assertFalse(actualJsonNodeFromString.isNull());
    assertFalse(actualJsonNodeFromString.isNumber());
    assertFalse(actualJsonNodeFromString.isObject());
    assertFalse(actualJsonNodeFromString.isPojo());
    assertFalse(actualJsonNodeFromString.isShort());
    assertFalse(actualJsonNodeFromString.isTextual());
    assertFalse(actualJsonNodeFromString.isValueNode());
    assertFalse(actualJsonNodeFromString.iterator().hasNext());
    assertTrue(actualJsonNodeFromString.isEmpty());
    assertTrue(actualJsonNodeFromString.isMissingNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link JSONSerialiser#getJsonNodeFromString(String)}
   */
  @Test
  void testGetJsonNodeFromString3() throws IOException {
    // Arrange and Act
    JsonNode actualJsonNodeFromString = JSONSerialiser.getJsonNodeFromString("42");

    // Assert
    assertTrue(actualJsonNodeFromString instanceof IntNode);
    JsonParser traverseResult = actualJsonNodeFromString.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("42", actualJsonNodeFromString.toPrettyString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.13.5", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, actualJsonNodeFromString.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(13, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(5, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NUMBER, actualJsonNodeFromString.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(actualJsonNodeFromString.isArray());
    assertFalse(actualJsonNodeFromString.isBigDecimal());
    assertFalse(actualJsonNodeFromString.isBigInteger());
    assertFalse(actualJsonNodeFromString.isBinary());
    assertFalse(actualJsonNodeFromString.isBoolean());
    assertFalse(actualJsonNodeFromString.isContainerNode());
    assertFalse(actualJsonNodeFromString.isDouble());
    assertFalse(actualJsonNodeFromString.isFloat());
    assertFalse(actualJsonNodeFromString.isFloatingPointNumber());
    assertFalse(actualJsonNodeFromString.isLong());
    assertFalse(actualJsonNodeFromString.isMissingNode());
    assertFalse(actualJsonNodeFromString.isNull());
    assertFalse(actualJsonNodeFromString.isObject());
    assertFalse(actualJsonNodeFromString.isPojo());
    assertFalse(actualJsonNodeFromString.isShort());
    assertFalse(actualJsonNodeFromString.isTextual());
    assertFalse(((IntNode) actualJsonNodeFromString).isNaN());
    assertFalse(actualJsonNodeFromString.iterator().hasNext());
    assertTrue(actualJsonNodeFromString.isEmpty());
    assertTrue(actualJsonNodeFromString.isInt());
    assertTrue(actualJsonNodeFromString.isIntegralNumber());
    assertTrue(actualJsonNodeFromString.isNumber());
    assertTrue(actualJsonNodeFromString.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link JSONSerialiser#getJsonNodeFromString(String)}
   */
  @Test
  void testGetJsonNodeFromString4() throws IOException {
    // Arrange and Act
    JsonNode actualJsonNodeFromString = JSONSerialiser.getJsonNodeFromString("4242");

    // Assert
    assertTrue(actualJsonNodeFromString instanceof IntNode);
    JsonParser traverseResult = actualJsonNodeFromString.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    assertEquals("4242", actualJsonNodeFromString.toPrettyString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.13.5", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, actualJsonNodeFromString.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble());
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(13, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(5, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NUMBER, actualJsonNodeFromString.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(actualJsonNodeFromString.isArray());
    assertFalse(actualJsonNodeFromString.isBigDecimal());
    assertFalse(actualJsonNodeFromString.isBigInteger());
    assertFalse(actualJsonNodeFromString.isBinary());
    assertFalse(actualJsonNodeFromString.isBoolean());
    assertFalse(actualJsonNodeFromString.isContainerNode());
    assertFalse(actualJsonNodeFromString.isDouble());
    assertFalse(actualJsonNodeFromString.isFloat());
    assertFalse(actualJsonNodeFromString.isFloatingPointNumber());
    assertFalse(actualJsonNodeFromString.isLong());
    assertFalse(actualJsonNodeFromString.isMissingNode());
    assertFalse(actualJsonNodeFromString.isNull());
    assertFalse(actualJsonNodeFromString.isObject());
    assertFalse(actualJsonNodeFromString.isPojo());
    assertFalse(actualJsonNodeFromString.isShort());
    assertFalse(actualJsonNodeFromString.isTextual());
    assertFalse(((IntNode) actualJsonNodeFromString).isNaN());
    assertFalse(actualJsonNodeFromString.iterator().hasNext());
    assertTrue(actualJsonNodeFromString.isEmpty());
    assertTrue(actualJsonNodeFromString.isInt());
    assertTrue(actualJsonNodeFromString.isIntegralNumber());
    assertTrue(actualJsonNodeFromString.isNumber());
    assertTrue(actualJsonNodeFromString.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Method under test: {@link JSONSerialiser#getMapper()}
   */
  @Test
  void testGetMapper() throws MissingResourceException {
    // Arrange and Act
    ObjectMapper actualMapper = JSONSerialiser.getMapper();

    // Assert
    SerializationConfig serializationConfig = actualMapper.getSerializationConfig();
    assertTrue(serializationConfig.getDefaultPrettyPrinter() instanceof DefaultPrettyPrinter);
    JsonFactory factory = actualMapper.getFactory();
    assertTrue(factory instanceof MappingJsonFactory);
    DeserializationConfig deserializationConfig = actualMapper.getDeserializationConfig();
    ContextAttributes attributes = deserializationConfig.getAttributes();
    assertTrue(attributes instanceof ContextAttributes.Impl);
    DeserializationContext deserializationContext = actualMapper.getDeserializationContext();
    DeserializerFactory factory2 = deserializationContext.getFactory();
    assertTrue(factory2 instanceof BeanDeserializerFactory);
    assertTrue(deserializationContext instanceof DefaultDeserializationContext.Impl);
    ClassIntrospector classIntrospector = deserializationConfig.getClassIntrospector();
    assertTrue(classIntrospector instanceof BasicClassIntrospector);
    AccessorNamingStrategy.Provider accessorNaming = deserializationConfig.getAccessorNaming();
    assertTrue(accessorNaming instanceof DefaultAccessorNamingStrategy.Provider);
    VisibilityChecker<?> visibilityChecker = actualMapper.getVisibilityChecker();
    assertTrue(visibilityChecker instanceof VisibilityChecker.Std);
    PolymorphicTypeValidator polymorphicTypeValidator = actualMapper.getPolymorphicTypeValidator();
    assertTrue(polymorphicTypeValidator instanceof LaissezFaireSubTypeValidator);
    SubtypeResolver subtypeResolver = actualMapper.getSubtypeResolver();
    assertTrue(subtypeResolver instanceof StdSubtypeResolver);
    DeserializerFactoryConfig factoryConfig = ((BeanDeserializerFactory) factory2).getFactoryConfig();
    Iterable<Deserializers> deserializersResult = factoryConfig.deserializers();
    assertTrue(((ArrayIterator<Deserializers>) deserializersResult).next() instanceof SimpleDeserializers);
    assertTrue(((ArrayIterator<Deserializers>) deserializersResult).next() instanceof SimpleDeserializers);
    SerializerFactory serializerFactory = actualMapper.getSerializerFactory();
    SerializerFactoryConfig factoryConfig2 = ((BeanSerializerFactory) serializerFactory).getFactoryConfig();
    Iterable<Serializers> serializersResult = factoryConfig2.serializers();
    assertTrue(((ArrayIterator<Serializers>) serializersResult).next() instanceof SimpleSerializers);
    assertTrue(((ArrayIterator<Serializers>) serializersResult).next() instanceof SimpleSerializers);
    assertTrue(serializerFactory instanceof BeanSerializerFactory);
    SerializerProvider serializerProvider = actualMapper.getSerializerProvider();
    assertTrue(serializerProvider instanceof DefaultSerializerProvider.Impl);
    SerializerProvider serializerProviderInstance = actualMapper.getSerializerProviderInstance();
    assertTrue(serializerProviderInstance instanceof DefaultSerializerProvider.Impl);
    JsonSerializer<Object> defaultNullKeySerializer = serializerProvider.getDefaultNullKeySerializer();
    assertTrue(defaultNullKeySerializer instanceof FailingSerializer);
    FilterProvider filterProvider = serializationConfig.getFilterProvider();
    assertTrue(filterProvider instanceof SimpleFilterProvider);
    JsonSerializer<Object> defaultNullValueSerializer = serializerProvider.getDefaultNullValueSerializer();
    assertTrue(defaultNullValueSerializer instanceof NullSerializer);
    assertTrue(deserializersResult instanceof ArrayIterator);
    assertTrue(serializersResult instanceof ArrayIterator);
    DateFormat dateFormat = actualMapper.getDateFormat();
    assertTrue(dateFormat instanceof StdDateFormat);
    AnnotationIntrospector annotationIntrospector = deserializationConfig.getAnnotationIntrospector();
    assertTrue(annotationIntrospector instanceof DelegatingAnnotationIntrospector);
    assertEquals(" ", factory.getRootValueSeparator());
    Locale locale = deserializationConfig.getLocale();
    assertEquals("", locale.getCountry());
    assertEquals("", locale.getDisplayCountry());
    assertEquals("", locale.getDisplayScript());
    assertEquals("", locale.getDisplayVariant());
    assertEquals("", locale.getISO3Country());
    assertEquals("", locale.getScript());
    assertEquals("", locale.getVariant());
    TimeZone timeZone = deserializationConfig.getTimeZone();
    assertEquals("Coordinated Universal Time", timeZone.getDisplayName());
    assertEquals("English", locale.getDisplayLanguage());
    assertEquals("English", locale.getDisplayName());
    assertEquals("JSON", factory.getFormatName());
    Base64Variant base64Variant = deserializationConfig.getBase64Variant();
    assertEquals("MIME-NO-LINEFEEDS", base64Variant.getName());
    assertEquals("MIME-NO-LINEFEEDS", base64Variant.toString());
    assertEquals("UTC", timeZone.getID());
    assertEquals("[one of: 'yyyy-MM-dd'T'HH:mm:ss.SSSX', 'EEE, dd MMM yyyy HH:mm:ss zzz' (lenient)]",
        ((StdDateFormat) dateFormat).toPattern());
    Version versionResult = factory.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    Version versionResult2 = actualMapper.version();
    assertEquals("com.fasterxml.jackson.core", versionResult2.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-core/2.13.5", versionResult.toFullString());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.13.5", versionResult2.toFullString());
    assertEquals("en", locale.getLanguage());
    assertEquals("eng", locale.getISO3Language());
    assertEquals("jackson-core", versionResult.getArtifactId());
    assertEquals("jackson-databind", versionResult2.getArtifactId());
    assertEquals('=', base64Variant.getPaddingChar());
    assertNull(serializerProvider.getGenerator());
    assertNull(serializerProviderInstance.getGenerator());
    assertNull(deserializationContext.getParser());
    assertNull(factory.getCharacterEscapes());
    assertNull(factory.getInputDecorator());
    assertNull(factory.getOutputDecorator());
    assertNull(deserializationContext.getConfig());
    assertNull(actualMapper.getInjectableValues());
    assertNull(deserializationContext.getContextualType());
    assertNull(defaultNullKeySerializer.getDelegatee());
    assertNull(defaultNullValueSerializer.getDelegatee());
    assertNull(deserializationConfig.getFullRootName());
    assertNull(serializationConfig.getFullRootName());
    assertNull(actualMapper.getPropertyNamingStrategy());
    assertNull(deserializationConfig.getPropertyNamingStrategy());
    assertNull(serializationConfig.getPropertyNamingStrategy());
    assertNull(serializerProvider.getConfig());
    assertNull(deserializationConfig.getHandlerInstantiator());
    assertNull(serializationConfig.getHandlerInstantiator());
    assertNull(((SimpleFilterProvider) filterProvider).getDefaultFilter());
    assertNull(deserializationConfig.getProblemHandlers());
    assertNull(deserializationConfig.getDefaultMergeable());
    assertNull(serializationConfig.getDefaultMergeable());
    assertNull(factory.getFormatReadFeatureType());
    assertNull(factory.getFormatWriteFeatureType());
    JsonInclude.Value defaultPropertyInclusion = deserializationConfig.getDefaultPropertyInclusion();
    assertNull(defaultPropertyInclusion.getContentFilter());
    assertNull(defaultPropertyInclusion.getValueFilter());
    assertNull(deserializationContext.getActiveView());
    assertNull(serializerProvider.getActiveView());
    assertNull(serializerProviderInstance.getActiveView());
    assertNull(deserializationConfig.getActiveView());
    assertNull(serializationConfig.getActiveView());
    TypeFactory typeFactory = actualMapper.getTypeFactory();
    assertNull(typeFactory.getClassLoader());
    assertNull(deserializationConfig.getRootName());
    assertNull(serializationConfig.getRootName());
    assertNull(dateFormat.getNumberFormat());
    assertNull(dateFormat.getCalendar());
    assertNull(dateFormat.getTimeZone());
    assertEquals(0, factory.getFormatGeneratorFeatures());
    assertEquals(0, factory.getFormatParserFeatures());
    assertEquals(0, deserializationContext.getDeserializationFeatures());
    assertEquals(0, timeZone.getDSTSavings());
    assertEquals(13, versionResult.getMinorVersion());
    assertEquals(13, versionResult2.getMinorVersion());
    assertEquals(16385, factory.getParserFeatures());
    assertEquals(169911424, deserializationConfig.getDeserializationFeatures());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult2.getMajorVersion());
    assertEquals(21771192, serializationConfig.getSerializationFeatures());
    assertEquals(3, actualMapper.getRegisteredModuleIds().size());
    assertEquals(31, factory.getGeneratorFeatures());
    assertEquals(5, versionResult.getPatchLevel());
    assertEquals(5, versionResult2.getPatchLevel());
    assertEquals(JsonInclude.Include.NON_NULL, defaultPropertyInclusion.getContentInclusion());
    assertEquals(JsonInclude.Include.NON_NULL, defaultPropertyInclusion.getValueInclusion());
    assertEquals(JsonInclude.Include.NON_NULL, serializationConfig.getSerializationInclusion());
    JsonSetter.Value defaultSetterInfo = deserializationConfig.getDefaultSetterInfo();
    assertEquals(Nulls.DEFAULT, defaultSetterInfo.getContentNulls());
    assertEquals(Nulls.DEFAULT, defaultSetterInfo.getValueNulls());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult2.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult2.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(versionResult2.isUnknownVersion());
    assertFalse(defaultNullKeySerializer.isUnwrappingSerializer());
    assertFalse(defaultNullValueSerializer.isUnwrappingSerializer());
    assertFalse(factoryConfig.hasAbstractTypeResolvers());
    assertFalse(factoryConfig.hasDeserializerModifiers());
    assertFalse(deserializationConfig.hasExplicitTimeZone());
    assertFalse(serializationConfig.hasExplicitTimeZone());
    assertFalse(factoryConfig2.hasSerializerModifiers());
    assertFalse(((ArrayIterator<Serializers>) serializersResult).hasNext());
    assertFalse(locale.hasExtensions());
    assertTrue(factoryConfig.hasDeserializers());
    assertTrue(factoryConfig.hasKeyDeserializers());
    assertTrue(factoryConfig.hasValueInstantiators());
    assertTrue(deserializationConfig.isAnnotationProcessingEnabled());
    assertTrue(serializationConfig.isAnnotationProcessingEnabled());
    assertTrue(factoryConfig2.hasKeySerializers());
    assertTrue(factoryConfig2.hasSerializers());
    assertTrue(((ArrayIterator<Deserializers>) deserializersResult).hasNext());
    assertTrue(((StdDateFormat) dateFormat).isColonIncludedInTimeZone());
    assertTrue(dateFormat.isLenient());
    Set<Character> extensionKeys = locale.getExtensionKeys();
    assertTrue(extensionKeys.isEmpty());
    assertEquals(Integer.MAX_VALUE, base64Variant.getMaxLineLength());
    assertEquals('=', base64Variant.getPaddingByte());
    assertSame(serializationConfig, serializerProviderInstance.getConfig());
    assertSame(typeFactory, serializerProviderInstance.getTypeFactory());
    assertSame(typeFactory, deserializationConfig.getTypeFactory());
    assertSame(typeFactory, serializationConfig.getTypeFactory());
    assertSame(versionResult2, annotationIntrospector.version());
    assertSame(base64Variant, serializationConfig.getBase64Variant());
    assertSame(locale, serializerProviderInstance.getLocale());
    assertSame(locale, serializationConfig.getLocale());
    assertSame(timeZone, serializerProviderInstance.getTimeZone());
    assertSame(timeZone, serializationConfig.getTimeZone());
    assertSame(defaultPropertyInclusion, serializationConfig.getDefaultPropertyInclusion());
    assertSame(defaultSetterInfo, serializationConfig.getDefaultSetterInfo());
    assertSame(extensionKeys, locale.getUnicodeLocaleAttributes());
    assertSame(extensionKeys, locale.getUnicodeLocaleKeys());
    assertSame(actualMapper, factory.getCodec());
    assertSame(factory, actualMapper.getJsonFactory());
    assertSame(attributes, serializationConfig.getAttributes());
    assertSame(classIntrospector, serializationConfig.getClassIntrospector());
    assertSame(accessorNaming, serializationConfig.getAccessorNaming());
    assertSame(visibilityChecker, deserializationConfig.getDefaultVisibilityChecker());
    assertSame(visibilityChecker, serializationConfig.getDefaultVisibilityChecker());
    assertSame(polymorphicTypeValidator, deserializationConfig.getPolymorphicTypeValidator());
    assertSame(polymorphicTypeValidator, serializationConfig.getPolymorphicTypeValidator());
    assertSame(subtypeResolver, deserializationConfig.getSubtypeResolver());
    assertSame(subtypeResolver, serializationConfig.getSubtypeResolver());
    assertSame(defaultNullKeySerializer, serializerProviderInstance.getDefaultNullKeySerializer());
    assertSame(filterProvider, serializerProviderInstance.getFilterProvider());
    assertSame(defaultNullValueSerializer, serializerProviderInstance.getDefaultNullValueSerializer());
    assertSame(dateFormat, deserializationConfig.getDateFormat());
    assertSame(dateFormat, serializationConfig.getDateFormat());
    assertSame(annotationIntrospector, serializerProviderInstance.getAnnotationIntrospector());
    assertSame(annotationIntrospector, serializationConfig.getAnnotationIntrospector());
  }
}
