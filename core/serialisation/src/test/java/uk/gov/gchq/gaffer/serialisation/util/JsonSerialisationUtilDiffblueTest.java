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

package uk.gov.gchq.gaffer.serialisation.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import com.fasterxml.jackson.databind.type.ResolvedRecursiveType;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.fasterxml.jackson.databind.type.TypeBindings;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JsonSerialisationUtilDiffblueTest {
  /**
   * Test {@link JsonSerialisationUtil#getSerialisedFieldClasses(String)}.
   *
   * <ul>
   *   <li>When {@code Class Name}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getSerialisedFieldClasses(String)}
   */
  @Test
  @DisplayName(
      "Test getSerialisedFieldClasses(String); when 'Class Name'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonSerialisationUtil.getSerialisedFieldClasses(String)"})
  void testGetSerialisedFieldClasses_whenClassName_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> JsonSerialisationUtil.getSerialisedFieldClasses("Class Name"));
  }

  /**
   * Test {@link JsonSerialisationUtil#getSerialisedFieldClasses(String)}.
   *
   * <ul>
   *   <li>When {@code class[]}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getSerialisedFieldClasses(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFieldClasses(String); when 'class[]'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonSerialisationUtil.getSerialisedFieldClasses(String)"})
  void testGetSerialisedFieldClasses_whenClass_thenReturnEmpty() {
    // Arrange and Act
    Map<String, String> actualSerialisedFieldClasses =
        JsonSerialisationUtil.getSerialisedFieldClasses("class[]");

    // Assert
    assertTrue(actualSerialisedFieldClasses.isEmpty());
  }

  /**
   * Test {@link JsonSerialisationUtil#getSerialisedFieldClasses(String)}.
   *
   * <ul>
   *   <li>When {@code class}.
   *   <li>Then return size is forty-one.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getSerialisedFieldClasses(String)}
   */
  @Test
  @DisplayName(
      "Test getSerialisedFieldClasses(String); when 'class'; then return size is forty-one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonSerialisationUtil.getSerialisedFieldClasses(String)"})
  void testGetSerialisedFieldClasses_whenClass_thenReturnSizeIsFortyOne() {
    // Arrange and Act
    Map<String, String> actualSerialisedFieldClasses =
        JsonSerialisationUtil.getSerialisedFieldClasses("class");

    // Assert
    assertEquals(41, actualSerialisedFieldClasses.size());
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("annotations"));
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("classLoader"));
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("classes"));
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("declaredMethods"));
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("enclosingConstructor"));
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("genericInterfaces"));
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("interface"));
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("methods"));
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("modifiers"));
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("primitive"));
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("typeName"));
  }

  /**
   * Test {@link JsonSerialisationUtil#getSerialisedFieldClasses(String)}.
   *
   * <ul>
   *   <li>When {@code JsonCreator}.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getSerialisedFieldClasses(String)}
   */
  @Test
  @DisplayName(
      "Test getSerialisedFieldClasses(String); when 'com.fasterxml.jackson.annotation.JsonCreator'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonSerialisationUtil.getSerialisedFieldClasses(String)"})
  void testGetSerialisedFieldClasses_whenComFasterxmlJacksonAnnotationJsonCreator() {
    // Arrange and Act
    Map<String, String> actualSerialisedFieldClasses =
        JsonSerialisationUtil.getSerialisedFieldClasses(
            "com.fasterxml.jackson.annotation.JsonCreator");

    // Assert
    assertTrue(actualSerialisedFieldClasses.isEmpty());
  }

  /**
   * Test {@link JsonSerialisationUtil#getSerialisedFieldClasses(String)}.
   *
   * <ul>
   *   <li>When {@code .}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getSerialisedFieldClasses(String)}
   */
  @Test
  @DisplayName(
      "Test getSerialisedFieldClasses(String); when '.'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonSerialisationUtil.getSerialisedFieldClasses(String)"})
  void testGetSerialisedFieldClasses_whenDot_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> JsonSerialisationUtil.getSerialisedFieldClasses("."));
  }

  /**
   * Test {@link JsonSerialisationUtil#getSerialisedFieldClasses(String)}.
   *
   * <ul>
   *   <li>When {@code Class}.
   *   <li>Then return size is forty-one.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getSerialisedFieldClasses(String)}
   */
  @Test
  @DisplayName(
      "Test getSerialisedFieldClasses(String); when 'java.lang.Class'; then return size is forty-one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonSerialisationUtil.getSerialisedFieldClasses(String)"})
  void testGetSerialisedFieldClasses_whenJavaLangClass_thenReturnSizeIsFortyOne() {
    // Arrange and Act
    Map<String, String> actualSerialisedFieldClasses =
        JsonSerialisationUtil.getSerialisedFieldClasses("java.lang.Class");

    // Assert
    assertEquals(41, actualSerialisedFieldClasses.size());
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("annotations"));
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("classLoader"));
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("classes"));
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("declaredMethods"));
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("enclosingConstructor"));
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("genericInterfaces"));
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("interface"));
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("methods"));
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("modifiers"));
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("primitive"));
    assertEquals("java.lang.Object", actualSerialisedFieldClasses.get("typeName"));
  }

  /**
   * Test {@link JsonSerialisationUtil#getSerialisedFieldClasses(String)}.
   *
   * <ul>
   *   <li>When {@code String}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getSerialisedFieldClasses(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFieldClasses(String); when 'java.lang.String'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonSerialisationUtil.getSerialisedFieldClasses(String)"})
  void testGetSerialisedFieldClasses_whenJavaLangString_thenReturnEmpty() {
    // Arrange and Act
    Map<String, String> actualSerialisedFieldClasses =
        JsonSerialisationUtil.getSerialisedFieldClasses("java.lang.String");

    // Assert
    assertTrue(actualSerialisedFieldClasses.isEmpty());
  }

  /**
   * Test {@link JsonSerialisationUtil#getSerialisedFieldClasses(String)}.
   *
   * <ul>
   *   <li>When {@code Map}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getSerialisedFieldClasses(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFieldClasses(String); when 'java.util.Map'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonSerialisationUtil.getSerialisedFieldClasses(String)"})
  void testGetSerialisedFieldClasses_whenJavaUtilMap_thenReturnEmpty() {
    // Arrange and Act
    Map<String, String> actualSerialisedFieldClasses =
        JsonSerialisationUtil.getSerialisedFieldClasses("java.util.Map");

    // Assert
    assertTrue(actualSerialisedFieldClasses.isEmpty());
  }

  /**
   * Test {@link JsonSerialisationUtil#getSerialisedFieldClasses(String)}.
   *
   * <ul>
   *   <li>When {@code []}.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getSerialisedFieldClasses(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFieldClasses(String); when '[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map JsonSerialisationUtil.getSerialisedFieldClasses(String)"})
  void testGetSerialisedFieldClasses_whenLeftSquareBracketRightSquareBracket() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> JsonSerialisationUtil.getSerialisedFieldClasses("[]"));
  }

  /**
   * Test {@link JsonSerialisationUtil#getTypeString(Type)}.
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  @DisplayName("Test getTypeString(Type)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonSerialisationUtil.getTypeString(Type)"})
  void testGetTypeString() {
    // Arrange
    GenericArrayType typeArg = mock(GenericArrayType.class);
    Class<JsonCreator> cls = JsonCreator.class;
    when(typeArg.getGenericComponentType()).thenReturn(SimpleType.construct(cls));

    // Act
    String actualTypeString = JsonSerialisationUtil.getTypeString(typeArg);

    // Assert
    verify(typeArg).getGenericComponentType();
    assertEquals(
        "[simpletype,classcom.fasterxml.jackson.annotation.JsonCreator][]", actualTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getTypeString(Type)}.
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  @DisplayName("Test getTypeString(Type)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonSerialisationUtil.getTypeString(Type)"})
  void testGetTypeString2() {
    // Arrange
    GenericArrayType typeArg = mock(GenericArrayType.class);
    Class<JsonProperty> cls = JsonProperty.class;
    when(typeArg.getGenericComponentType()).thenReturn(SimpleType.construct(cls));

    // Act
    String actualTypeString = JsonSerialisationUtil.getTypeString(typeArg);

    // Assert
    verify(typeArg).getGenericComponentType();
    assertEquals(
        "[simpletype,classcom.fasterxml.jackson.annotation.JsonProperty][]", actualTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getTypeString(Type)}.
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  @DisplayName("Test getTypeString(Type)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonSerialisationUtil.getTypeString(Type)"})
  void testGetTypeString3() {
    // Arrange
    GenericArrayType typeArg = mock(GenericArrayType.class);
    Class<JsonSetter> cls = JsonSetter.class;
    when(typeArg.getGenericComponentType()).thenReturn(SimpleType.construct(cls));

    // Act
    String actualTypeString = JsonSerialisationUtil.getTypeString(typeArg);

    // Assert
    verify(typeArg).getGenericComponentType();
    assertEquals(
        "[simpletype,classcom.fasterxml.jackson.annotation.JsonSetter][]", actualTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getTypeString(Type)}.
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  @DisplayName("Test getTypeString(Type)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonSerialisationUtil.getTypeString(Type)"})
  void testGetTypeString4() {
    // Arrange
    GenericArrayType typeArg = mock(GenericArrayType.class);
    Class<JsonPOJOBuilder> cls = JsonPOJOBuilder.class;
    when(typeArg.getGenericComponentType()).thenReturn(SimpleType.construct(cls));

    // Act
    String actualTypeString = JsonSerialisationUtil.getTypeString(typeArg);

    // Assert
    verify(typeArg).getGenericComponentType();
    assertEquals(
        "[simpletype,classcom.fasterxml.jackson.databind.annotation.JsonPOJOBuilder][]",
        actualTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getTypeString(Type)}.
   *
   * <ul>
   *   <li>Given {@link CollectionLikeType} {@link CollectionLikeType#getTypeName()} return {@code ?
   *       extends}.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  @DisplayName(
      "Test getTypeString(Type); given CollectionLikeType getTypeName() return '? extends'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonSerialisationUtil.getTypeString(Type)"})
  void testGetTypeString_givenCollectionLikeTypeGetTypeNameReturnExtends() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getTypeName()).thenReturn("? extends ");

    GenericArrayType typeArg = mock(GenericArrayType.class);
    when(typeArg.getGenericComponentType()).thenReturn(collectionLikeType);

    // Act
    String actualTypeString = JsonSerialisationUtil.getTypeString(typeArg);

    // Assert
    verify(typeArg).getGenericComponentType();
    verify(collectionLikeType).getTypeName();
    assertEquals("[]", actualTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getTypeString(Type)}.
   *
   * <ul>
   *   <li>Given {@link CollectionLikeType} {@link CollectionLikeType#getTypeName()} return {@code
   *       \? extends}.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  @DisplayName(
      "Test getTypeString(Type); given CollectionLikeType getTypeName() return '\\? extends'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonSerialisationUtil.getTypeString(Type)"})
  void testGetTypeString_givenCollectionLikeTypeGetTypeNameReturnExtends2() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getTypeName()).thenReturn("\\? extends ");

    GenericArrayType typeArg = mock(GenericArrayType.class);
    when(typeArg.getGenericComponentType()).thenReturn(collectionLikeType);

    // Act
    String actualTypeString = JsonSerialisationUtil.getTypeString(typeArg);

    // Assert
    verify(typeArg).getGenericComponentType();
    verify(collectionLikeType).getTypeName();
    assertEquals("\\[]", actualTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getTypeString(Type)}.
   *
   * <ul>
   *   <li>Given {@link CollectionLikeType} {@link CollectionLikeType#getTypeName()} return space.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  @DisplayName("Test getTypeString(Type); given CollectionLikeType getTypeName() return space")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonSerialisationUtil.getTypeString(Type)"})
  void testGetTypeString_givenCollectionLikeTypeGetTypeNameReturnSpace() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getTypeName()).thenReturn(" ");

    GenericArrayType typeArg = mock(GenericArrayType.class);
    when(typeArg.getGenericComponentType()).thenReturn(collectionLikeType);

    // Act
    String actualTypeString = JsonSerialisationUtil.getTypeString(typeArg);

    // Assert
    verify(typeArg).getGenericComponentType();
    verify(collectionLikeType).getTypeName();
    assertEquals("[]", actualTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getTypeString(Type)}.
   *
   * <ul>
   *   <li>Given {@link CollectionLikeType} {@link CollectionLikeType#getTypeName()} return {@code ?
   *       super}.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  @DisplayName("Test getTypeString(Type); given CollectionLikeType getTypeName() return '? super'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonSerialisationUtil.getTypeString(Type)"})
  void testGetTypeString_givenCollectionLikeTypeGetTypeNameReturnSuper() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getTypeName()).thenReturn("? super ");

    GenericArrayType typeArg = mock(GenericArrayType.class);
    when(typeArg.getGenericComponentType()).thenReturn(collectionLikeType);

    // Act
    String actualTypeString = JsonSerialisationUtil.getTypeString(typeArg);

    // Assert
    verify(typeArg).getGenericComponentType();
    verify(collectionLikeType).getTypeName();
    assertEquals("[]", actualTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getTypeString(Type)}.
   *
   * <ul>
   *   <li>Given {@link CollectionLikeType} {@link CollectionLikeType#getTypeName()} return {@code
   *       \? super}.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  @DisplayName(
      "Test getTypeString(Type); given CollectionLikeType getTypeName() return '\\? super'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonSerialisationUtil.getTypeString(Type)"})
  void testGetTypeString_givenCollectionLikeTypeGetTypeNameReturnSuper2() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getTypeName()).thenReturn("\\? super ");

    GenericArrayType typeArg = mock(GenericArrayType.class);
    when(typeArg.getGenericComponentType()).thenReturn(collectionLikeType);

    // Act
    String actualTypeString = JsonSerialisationUtil.getTypeString(typeArg);

    // Assert
    verify(typeArg).getGenericComponentType();
    verify(collectionLikeType).getTypeName();
    assertEquals("\\[]", actualTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getTypeString(Type)}.
   *
   * <ul>
   *   <li>Given construct {@link Object}.
   *   <li>Then return {@code [simpletype,classObject][]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  @DisplayName(
      "Test getTypeString(Type); given construct Object; then return '[simpletype,classjava.lang.Object][]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonSerialisationUtil.getTypeString(Type)"})
  void testGetTypeString_givenConstructObject_thenReturnSimpletypeClassjavaLangObject() {
    // Arrange
    GenericArrayType typeArg = mock(GenericArrayType.class);
    Class<Object> cls = Object.class;
    when(typeArg.getGenericComponentType()).thenReturn(SimpleType.construct(cls));

    // Act
    String actualTypeString = JsonSerialisationUtil.getTypeString(typeArg);

    // Assert
    verify(typeArg).getGenericComponentType();
    assertEquals("[simpletype,classjava.lang.Object][]", actualTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getTypeString(Type)}.
   *
   * <ul>
   *   <li>Given {@code Class}.
   *   <li>Then return {@code [simpletype,classClass][]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  @DisplayName(
      "Test getTypeString(Type); given 'java.lang.Class'; then return '[simpletype,classjava.lang.Class][]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonSerialisationUtil.getTypeString(Type)"})
  void testGetTypeString_givenJavaLangClass_thenReturnSimpletypeClassjavaLangClass() {
    // Arrange
    GenericArrayType typeArg = mock(GenericArrayType.class);
    Class<Class> cls = Class.class;
    when(typeArg.getGenericComponentType()).thenReturn(SimpleType.construct(cls));

    // Act
    String actualTypeString = JsonSerialisationUtil.getTypeString(typeArg);

    // Assert
    verify(typeArg).getGenericComponentType();
    assertEquals("[simpletype,classjava.lang.Class][]", actualTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getTypeString(Type)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then return {@code [simpletype,classString][]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  @DisplayName(
      "Test getTypeString(Type); given 'java.lang.String'; then return '[simpletype,classjava.lang.String][]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonSerialisationUtil.getTypeString(Type)"})
  void testGetTypeString_givenJavaLangString_thenReturnSimpletypeClassjavaLangString() {
    // Arrange
    GenericArrayType typeArg = mock(GenericArrayType.class);
    Class<String> cls = String.class;
    when(typeArg.getGenericComponentType()).thenReturn(SimpleType.construct(cls));

    // Act
    String actualTypeString = JsonSerialisationUtil.getTypeString(typeArg);

    // Assert
    verify(typeArg).getGenericComponentType();
    assertEquals("[simpletype,classjava.lang.String][]", actualTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getTypeString(Type)}.
   *
   * <ul>
   *   <li>Given {@link PlaceholderForType#PlaceholderForType(int)} with ordinal is one.
   *   <li>Then return {@code $2[]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  @DisplayName(
      "Test getTypeString(Type); given PlaceholderForType(int) with ordinal is one; then return '$2[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonSerialisationUtil.getTypeString(Type)"})
  void testGetTypeString_givenPlaceholderForTypeWithOrdinalIsOne_thenReturn2() {
    // Arrange
    GenericArrayType typeArg = mock(GenericArrayType.class);
    when(typeArg.getGenericComponentType()).thenReturn(new PlaceholderForType(1));

    // Act
    String actualTypeString = JsonSerialisationUtil.getTypeString(typeArg);

    // Assert
    verify(typeArg).getGenericComponentType();
    assertEquals("$2[]", actualTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getTypeString(Type)}.
   *
   * <ul>
   *   <li>Then return {@code .[]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  @DisplayName("Test getTypeString(Type); then return '.[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonSerialisationUtil.getTypeString(Type)"})
  void testGetTypeString_thenReturnDotLeftSquareBracketRightSquareBracket() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getTypeName()).thenReturn(".");

    GenericArrayType typeArg = mock(GenericArrayType.class);
    when(typeArg.getGenericComponentType()).thenReturn(collectionLikeType);

    // Act
    String actualTypeString = JsonSerialisationUtil.getTypeString(typeArg);

    // Assert
    verify(typeArg).getGenericComponentType();
    verify(collectionLikeType).getTypeName();
    assertEquals(".[]", actualTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getTypeString(Type)}.
   *
   * <ul>
   *   <li>Then return {@code [recursivetype;Object[]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  @DisplayName("Test getTypeString(Type); then return '[recursivetype;java.lang.Object[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonSerialisationUtil.getTypeString(Type)"})
  void testGetTypeString_thenReturnRecursivetypeJavaLangObject() {
    // Arrange
    Class<Object> erasedType = Object.class;

    ResolvedRecursiveType resolvedRecursiveType =
        new ResolvedRecursiveType(erasedType, TypeBindings.emptyBindings());
    resolvedRecursiveType.setReference(new PlaceholderForType(1));

    GenericArrayType typeArg = mock(GenericArrayType.class);
    when(typeArg.getGenericComponentType()).thenReturn(resolvedRecursiveType);

    // Act
    String actualTypeString = JsonSerialisationUtil.getTypeString(typeArg);

    // Assert
    verify(typeArg).getGenericComponentType();
    assertEquals("[recursivetype;java.lang.Object[]", actualTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getTypeString(Type)}.
   *
   * <ul>
   *   <li>Then return {@code [recursivetype;UNRESOLVED[]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  @DisplayName("Test getTypeString(Type); then return '[recursivetype;UNRESOLVED[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonSerialisationUtil.getTypeString(Type)"})
  void testGetTypeString_thenReturnRecursivetypeUnresolved() {
    // Arrange
    GenericArrayType typeArg = mock(GenericArrayType.class);
    Class<Object> erasedType = Object.class;
    when(typeArg.getGenericComponentType())
        .thenReturn(new ResolvedRecursiveType(erasedType, TypeBindings.emptyBindings()));

    // Act
    String actualTypeString = JsonSerialisationUtil.getTypeString(typeArg);

    // Assert
    verify(typeArg).getGenericComponentType();
    assertEquals("[recursivetype;UNRESOLVED[]", actualTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getTypeString(Type)}.
   *
   * <ul>
   *   <li>Then return {@code [simpletype,classGenericArrayType][]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  @DisplayName(
      "Test getTypeString(Type); then return '[simpletype,classjava.lang.reflect.GenericArrayType][]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonSerialisationUtil.getTypeString(Type)"})
  void testGetTypeString_thenReturnSimpletypeClassjavaLangReflectGenericArrayType() {
    // Arrange
    GenericArrayType typeArg = mock(GenericArrayType.class);
    Class<GenericArrayType> cls = GenericArrayType.class;
    when(typeArg.getGenericComponentType()).thenReturn(SimpleType.construct(cls));

    // Act
    String actualTypeString = JsonSerialisationUtil.getTypeString(typeArg);

    // Assert
    verify(typeArg).getGenericComponentType();
    assertEquals("[simpletype,classjava.lang.reflect.GenericArrayType][]", actualTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getTypeString(Type)}.
   *
   * <ul>
   *   <li>Then return {@code [simpletype,classType][]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  @DisplayName("Test getTypeString(Type); then return '[simpletype,classjava.lang.reflect.Type][]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonSerialisationUtil.getTypeString(Type)"})
  void testGetTypeString_thenReturnSimpletypeClassjavaLangReflectType() {
    // Arrange
    GenericArrayType typeArg = mock(GenericArrayType.class);
    Class<Type> cls = Type.class;
    when(typeArg.getGenericComponentType()).thenReturn(SimpleType.construct(cls));

    // Act
    String actualTypeString = JsonSerialisationUtil.getTypeString(typeArg);

    // Assert
    verify(typeArg).getGenericComponentType();
    assertEquals("[simpletype,classjava.lang.reflect.Type][]", actualTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getTypeString(Type)}.
   *
   * <ul>
   *   <li>Then return {@code TypeName[]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  @DisplayName("Test getTypeString(Type); then return 'TypeName[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonSerialisationUtil.getTypeString(Type)"})
  void testGetTypeString_thenReturnTypeName() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getTypeName()).thenReturn("Type Name");

    GenericArrayType typeArg = mock(GenericArrayType.class);
    when(typeArg.getGenericComponentType()).thenReturn(collectionLikeType);

    // Act
    String actualTypeString = JsonSerialisationUtil.getTypeString(typeArg);

    // Assert
    verify(typeArg).getGenericComponentType();
    verify(collectionLikeType).getTypeName();
    assertEquals("TypeName[]", actualTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getTypeString(Type)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  @DisplayName("Test getTypeString(Type); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonSerialisationUtil.getTypeString(Type)"})
  void testGetTypeString_thenThrowIllegalArgumentException() {
    // Arrange
    GenericArrayType typeArg = mock(GenericArrayType.class);
    when(typeArg.getGenericComponentType()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> JsonSerialisationUtil.getTypeString(typeArg));
    verify(typeArg).getGenericComponentType();
  }

  /**
   * Test {@link JsonSerialisationUtil#getTypeString(Type)}.
   *
   * <ul>
   *   <li>When {@link PlaceholderForType#PlaceholderForType(int)} with ordinal is one.
   *   <li>Then return {@code $2}.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  @DisplayName(
      "Test getTypeString(Type); when PlaceholderForType(int) with ordinal is one; then return '$2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonSerialisationUtil.getTypeString(Type)"})
  void testGetTypeString_whenPlaceholderForTypeWithOrdinalIsOne_thenReturn2() {
    // Arrange, Act and Assert
    assertEquals("$2", JsonSerialisationUtil.getTypeString(new PlaceholderForType(1)));
  }

  /**
   * Test {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}.
   *
   * <ul>
   *   <li>Given {@link CollectionLikeType} {@link CollectionLikeType#getTypeName()} return {@code ?
   *       extends}.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}
   */
  @Test
  @DisplayName(
      "Test getFieldTypeString(Class, Type); given CollectionLikeType getTypeName() return '? extends'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonSerialisationUtil.getFieldTypeString(Class, Type)"})
  void testGetFieldTypeString_givenCollectionLikeTypeGetTypeNameReturnExtends() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getTypeName()).thenReturn("? extends ");

    GenericArrayType typeArg = mock(GenericArrayType.class);
    when(typeArg.getGenericComponentType()).thenReturn(collectionLikeType);

    // Act
    String actualFieldTypeString = JsonSerialisationUtil.getFieldTypeString(null, typeArg);

    // Assert
    verify(typeArg).getGenericComponentType();
    verify(collectionLikeType).getTypeName();
    assertEquals("[]", actualFieldTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}.
   *
   * <ul>
   *   <li>Given {@link CollectionLikeType} {@link CollectionLikeType#getTypeName()} return {@code
   *       \? extends}.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}
   */
  @Test
  @DisplayName(
      "Test getFieldTypeString(Class, Type); given CollectionLikeType getTypeName() return '\\? extends'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonSerialisationUtil.getFieldTypeString(Class, Type)"})
  void testGetFieldTypeString_givenCollectionLikeTypeGetTypeNameReturnExtends2() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getTypeName()).thenReturn("\\? extends ");

    GenericArrayType typeArg = mock(GenericArrayType.class);
    when(typeArg.getGenericComponentType()).thenReturn(collectionLikeType);

    // Act
    String actualFieldTypeString = JsonSerialisationUtil.getFieldTypeString(null, typeArg);

    // Assert
    verify(typeArg).getGenericComponentType();
    verify(collectionLikeType).getTypeName();
    assertEquals("\\[]", actualFieldTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}.
   *
   * <ul>
   *   <li>Given {@link CollectionLikeType} {@link CollectionLikeType#getTypeName()} return space.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}
   */
  @Test
  @DisplayName(
      "Test getFieldTypeString(Class, Type); given CollectionLikeType getTypeName() return space")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonSerialisationUtil.getFieldTypeString(Class, Type)"})
  void testGetFieldTypeString_givenCollectionLikeTypeGetTypeNameReturnSpace() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getTypeName()).thenReturn(" ");

    GenericArrayType typeArg = mock(GenericArrayType.class);
    when(typeArg.getGenericComponentType()).thenReturn(collectionLikeType);

    // Act
    String actualFieldTypeString = JsonSerialisationUtil.getFieldTypeString(null, typeArg);

    // Assert
    verify(typeArg).getGenericComponentType();
    verify(collectionLikeType).getTypeName();
    assertEquals("[]", actualFieldTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}.
   *
   * <ul>
   *   <li>Given {@link CollectionLikeType} {@link CollectionLikeType#getTypeName()} return {@code ?
   *       super}.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}
   */
  @Test
  @DisplayName(
      "Test getFieldTypeString(Class, Type); given CollectionLikeType getTypeName() return '? super'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonSerialisationUtil.getFieldTypeString(Class, Type)"})
  void testGetFieldTypeString_givenCollectionLikeTypeGetTypeNameReturnSuper() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getTypeName()).thenReturn("? super ");

    GenericArrayType typeArg = mock(GenericArrayType.class);
    when(typeArg.getGenericComponentType()).thenReturn(collectionLikeType);

    // Act
    String actualFieldTypeString = JsonSerialisationUtil.getFieldTypeString(null, typeArg);

    // Assert
    verify(typeArg).getGenericComponentType();
    verify(collectionLikeType).getTypeName();
    assertEquals("[]", actualFieldTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}.
   *
   * <ul>
   *   <li>Given {@link CollectionLikeType} {@link CollectionLikeType#getTypeName()} return {@code
   *       \? super}.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}
   */
  @Test
  @DisplayName(
      "Test getFieldTypeString(Class, Type); given CollectionLikeType getTypeName() return '\\? super'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonSerialisationUtil.getFieldTypeString(Class, Type)"})
  void testGetFieldTypeString_givenCollectionLikeTypeGetTypeNameReturnSuper2() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getTypeName()).thenReturn("\\? super ");

    GenericArrayType typeArg = mock(GenericArrayType.class);
    when(typeArg.getGenericComponentType()).thenReturn(collectionLikeType);

    // Act
    String actualFieldTypeString = JsonSerialisationUtil.getFieldTypeString(null, typeArg);

    // Assert
    verify(typeArg).getGenericComponentType();
    verify(collectionLikeType).getTypeName();
    assertEquals("\\[]", actualFieldTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}.
   *
   * <ul>
   *   <li>Given {@link PlaceholderForType#PlaceholderForType(int)} with ordinal is one.
   *   <li>Then return {@code $2[]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}
   */
  @Test
  @DisplayName(
      "Test getFieldTypeString(Class, Type); given PlaceholderForType(int) with ordinal is one; then return '$2[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonSerialisationUtil.getFieldTypeString(Class, Type)"})
  void testGetFieldTypeString_givenPlaceholderForTypeWithOrdinalIsOne_thenReturn2() {
    // Arrange
    Class<Object> clazz = Object.class;

    GenericArrayType typeArg = mock(GenericArrayType.class);
    when(typeArg.getGenericComponentType()).thenReturn(new PlaceholderForType(1));

    // Act
    String actualFieldTypeString = JsonSerialisationUtil.getFieldTypeString(clazz, typeArg);

    // Assert
    verify(typeArg).getGenericComponentType();
    assertEquals("$2[]", actualFieldTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}.
   *
   * <ul>
   *   <li>Then return {@code .[]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}
   */
  @Test
  @DisplayName("Test getFieldTypeString(Class, Type); then return '.[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonSerialisationUtil.getFieldTypeString(Class, Type)"})
  void testGetFieldTypeString_thenReturnDotLeftSquareBracketRightSquareBracket() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getTypeName()).thenReturn(".");

    GenericArrayType typeArg = mock(GenericArrayType.class);
    when(typeArg.getGenericComponentType()).thenReturn(collectionLikeType);

    // Act
    String actualFieldTypeString = JsonSerialisationUtil.getFieldTypeString(null, typeArg);

    // Assert
    verify(typeArg).getGenericComponentType();
    verify(collectionLikeType).getTypeName();
    assertEquals(".[]", actualFieldTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}.
   *
   * <ul>
   *   <li>Then return {@code [recursivetype;UNRESOLVED[]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}
   */
  @Test
  @DisplayName("Test getFieldTypeString(Class, Type); then return '[recursivetype;UNRESOLVED[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonSerialisationUtil.getFieldTypeString(Class, Type)"})
  void testGetFieldTypeString_thenReturnRecursivetypeUnresolved() {
    // Arrange
    GenericArrayType typeArg = mock(GenericArrayType.class);
    Class<Object> erasedType = Object.class;
    when(typeArg.getGenericComponentType())
        .thenReturn(new ResolvedRecursiveType(erasedType, TypeBindings.emptyBindings()));

    // Act
    String actualFieldTypeString = JsonSerialisationUtil.getFieldTypeString(null, typeArg);

    // Assert
    verify(typeArg).getGenericComponentType();
    assertEquals("[recursivetype;UNRESOLVED[]", actualFieldTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}.
   *
   * <ul>
   *   <li>Then return {@code [simpletype,classObject][]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}
   */
  @Test
  @DisplayName(
      "Test getFieldTypeString(Class, Type); then return '[simpletype,classjava.lang.Object][]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonSerialisationUtil.getFieldTypeString(Class, Type)"})
  void testGetFieldTypeString_thenReturnSimpletypeClassjavaLangObject() {
    // Arrange
    GenericArrayType typeArg = mock(GenericArrayType.class);
    Class<Object> cls = Object.class;
    when(typeArg.getGenericComponentType()).thenReturn(SimpleType.construct(cls));

    // Act
    String actualFieldTypeString = JsonSerialisationUtil.getFieldTypeString(null, typeArg);

    // Assert
    verify(typeArg).getGenericComponentType();
    assertEquals("[simpletype,classjava.lang.Object][]", actualFieldTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}.
   *
   * <ul>
   *   <li>Then return {@code TypeName[]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}
   */
  @Test
  @DisplayName("Test getFieldTypeString(Class, Type); then return 'TypeName[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonSerialisationUtil.getFieldTypeString(Class, Type)"})
  void testGetFieldTypeString_thenReturnTypeName() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getTypeName()).thenReturn("Type Name");

    GenericArrayType typeArg = mock(GenericArrayType.class);
    when(typeArg.getGenericComponentType()).thenReturn(collectionLikeType);

    // Act
    String actualFieldTypeString = JsonSerialisationUtil.getFieldTypeString(null, typeArg);

    // Assert
    verify(typeArg).getGenericComponentType();
    verify(collectionLikeType).getTypeName();
    assertEquals("TypeName[]", actualFieldTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}
   */
  @Test
  @DisplayName("Test getFieldTypeString(Class, Type); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonSerialisationUtil.getFieldTypeString(Class, Type)"})
  void testGetFieldTypeString_thenThrowIllegalArgumentException() {
    // Arrange
    Class<Object> clazz = Object.class;

    GenericArrayType typeArg = mock(GenericArrayType.class);
    when(typeArg.getGenericComponentType()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> JsonSerialisationUtil.getFieldTypeString(clazz, typeArg));
    verify(typeArg).getGenericComponentType();
  }

  /**
   * Test {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}.
   *
   * <ul>
   *   <li>When {@link PlaceholderForType#PlaceholderForType(int)} with ordinal is one.
   *   <li>Then return {@code $2}.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}
   */
  @Test
  @DisplayName(
      "Test getFieldTypeString(Class, Type); when PlaceholderForType(int) with ordinal is one; then return '$2'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonSerialisationUtil.getFieldTypeString(Class, Type)"})
  void testGetFieldTypeString_whenPlaceholderForTypeWithOrdinalIsOne_thenReturn2() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act
    String actualFieldTypeString =
        JsonSerialisationUtil.getFieldTypeString(clazz, new PlaceholderForType(1));

    // Assert
    assertEquals("$2", actualFieldTypeString);
  }
}
