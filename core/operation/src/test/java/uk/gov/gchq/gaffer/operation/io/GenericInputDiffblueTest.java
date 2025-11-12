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

package uk.gov.gchq.gaffer.operation.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.Base64Variants;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.cfg.BaseSettings;
import com.fasterxml.jackson.databind.cfg.ConfigOverrides;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;
import com.fasterxml.jackson.databind.deser.impl.FieldProperty;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotationMap;
import com.fasterxml.jackson.databind.introspect.BasicClassIntrospector;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder;
import com.fasterxml.jackson.databind.introspect.SimpleMixInResolver;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import com.fasterxml.jackson.databind.jsontype.DefaultBaseTypeLimitingValidator;
import com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.koryphe.serialisation.json.SimpleClassNameIdResolver;

class GenericInputDiffblueTest {
  /**
   * Method under test: {@link GenericInput.MultiInputWrapper#getInputAsArray()}
   */
  @Test
  void testMultiInputWrapperGetInputAsArray() {
    // Arrange, Act and Assert
    assertNull((new GenericInput.MultiInputWrapper()).getInputAsArray());
  }

  /**
   * Method under test: {@link GenericInput.MultiInputWrapper#hasMultiInput()}
   */
  @Test
  void testMultiInputWrapperHasMultiInput() {
    // Arrange, Act and Assert
    assertFalse((new GenericInput.MultiInputWrapper()).hasMultiInput());
  }

  /**
   * Method under test: {@link GenericInput.MultiInputWrapper#setInput(Object)}
   */
  @Test
  void testMultiInputWrapperSetInput() {
    // Arrange
    GenericInput.MultiInputWrapper multiInputWrapper = new GenericInput.MultiInputWrapper();

    // Act
    multiInputWrapper.setInput("Input");

    // Assert
    assertNull(multiInputWrapper.getInputAsArray());
    assertNull(multiInputWrapper.getInputAsIterable());
    assertFalse(multiInputWrapper.hasMultiInput());
  }

  /**
   * Method under test: {@link GenericInput.MultiInputWrapper#setInput(Object)}
   */
  @Test
  void testMultiInputWrapperSetInput2() {
    // Arrange
    GenericInput.MultiInputWrapper multiInputWrapper = new GenericInput.MultiInputWrapper();

    // Act
    multiInputWrapper.setInput(null);

    // Assert
    assertNull(multiInputWrapper.getInputAsArray());
    assertNull(multiInputWrapper.getInputAsIterable());
    assertFalse(multiInputWrapper.hasMultiInput());
  }

  /**
   * Method under test: {@link GenericInput.MultiInputWrapper#setInput(Object)}
   */
  @Test
  void testMultiInputWrapperSetInput3() {
    // Arrange
    GenericInput.MultiInputWrapper multiInputWrapper = new GenericInput.MultiInputWrapper();
    ArrayList<Object> objectList = new ArrayList<>();

    // Act
    multiInputWrapper.setInput(objectList);

    // Assert
    assertEquals(0, multiInputWrapper.getInputAsArray().length);
    assertTrue(multiInputWrapper.hasMultiInput());
    assertSame(objectList, multiInputWrapper.getInputAsIterable());
  }

  /**
   * Method under test: {@link GenericInput.MultiInputWrapper#setInput(Object)}
   */
  @Test
  void testMultiInputWrapperSetInput4() {
    // Arrange
    GenericInput.MultiInputWrapper multiInputWrapper = new GenericInput.MultiInputWrapper();

    ArrayList<SettableBeanProperty> props = new ArrayList<>();
    BasicClassIntrospector ci = new BasicClassIntrospector();
    JacksonAnnotationIntrospector ai = new JacksonAnnotationIntrospector();
    PropertyNamingStrategy pns = new PropertyNamingStrategy();
    TypeFactory tf = TypeFactory.defaultInstance();
    StdTypeResolverBuilder typer = new StdTypeResolverBuilder();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
    HandlerInstantiator hi = mock(HandlerInstantiator.class);
    Locale locale = Locale.getDefault();
    TimeZone tz = TimeZone.getTimeZone("America/Los_Angeles");
    Base64Variant defaultBase64 = Base64Variants.getDefaultVariant();
    BaseSettings base = new BaseSettings(ci, ai, pns, tf, typer, dateFormat, hi, locale, tz, defaultBase64,
        new DefaultBaseTypeLimitingValidator());

    StdSubtypeResolver str = new StdSubtypeResolver();
    SimpleMixInResolver mixins = new SimpleMixInResolver(mock(ClassIntrospector.MixInResolver.class));
    RootNameLookup rootNames = new RootNameLookup();
    DeserializationConfig config = new DeserializationConfig(base, str, mixins, rootNames, new ConfigOverrides());

    JacksonAnnotationIntrospector ai2 = new JacksonAnnotationIntrospector();
    POJOPropertyBuilder propDef = new POJOPropertyBuilder(config, ai2, true, PropertyName.construct("Simple Name"));

    PlaceholderForType type = new PlaceholderForType(1);
    AsArrayTypeDeserializer src = new AsArrayTypeDeserializer(null, new SimpleClassNameIdResolver(),
        "Type Property Name", true, null);

    AsArrayTypeDeserializer typeDeser = new AsArrayTypeDeserializer(src, new BeanProperty.Bogus());

    AnnotationMap contextAnnotations = new AnnotationMap();
    TypeResolutionContext contextClass = mock(TypeResolutionContext.class);
    FieldProperty fieldProperty = new FieldProperty(propDef, type, typeDeser, contextAnnotations,
        new AnnotatedField(contextClass, null, new AnnotationMap()));

    props.add(fieldProperty);
    BeanPropertyMap beanPropertyMap = new BeanPropertyMap(true, props, new HashMap<>());

    // Act
    multiInputWrapper.setInput(beanPropertyMap);

    // Assert
    Object[] inputAsArray = multiInputWrapper.getInputAsArray();
    assertEquals(1, inputAsArray.length);
    assertTrue(multiInputWrapper.hasMultiInput());
    assertSame(beanPropertyMap, multiInputWrapper.getInputAsIterable());
    assertSame(fieldProperty, inputAsArray[0]);
  }

  /**
   * Method under test:
   * {@link GenericInput.MultiInputWrapper#setInputFromArray(Object[])}
   */
  @Test
  void testMultiInputWrapperSetInputFromArray() {
    // Arrange
    GenericInput.MultiInputWrapper multiInputWrapper = new GenericInput.MultiInputWrapper();
    Object[] input = new Object[]{"Input"};

    // Act
    multiInputWrapper.setInputFromArray(input);

    // Assert
    Iterable<?> inputAsIterable = multiInputWrapper.getInputAsIterable();
    assertTrue(inputAsIterable instanceof List);
    assertEquals(1, ((List<?>) inputAsIterable).size());
    assertEquals("Input", ((List<?>) inputAsIterable).get(0));
    assertTrue(multiInputWrapper.hasMultiInput());
    assertSame(input, multiInputWrapper.getInputAsArray());
  }

  /**
   * Method under test:
   * {@link GenericInput.MultiInputWrapper#setInputFromIterable(Iterable)}
   */
  @Test
  void testMultiInputWrapperSetInputFromIterable() {
    // Arrange
    GenericInput.MultiInputWrapper multiInputWrapper = new GenericInput.MultiInputWrapper();
    ArrayList<Object> input = new ArrayList<>();

    // Act
    multiInputWrapper.setInputFromIterable(input);

    // Assert
    assertEquals(0, multiInputWrapper.getInputAsArray().length);
    assertTrue(multiInputWrapper.hasMultiInput());
    assertSame(input, multiInputWrapper.getInputAsIterable());
  }
}
