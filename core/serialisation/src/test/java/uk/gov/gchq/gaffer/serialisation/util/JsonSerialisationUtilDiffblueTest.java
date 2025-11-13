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

package uk.gov.gchq.gaffer.serialisation.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JavaType;
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
   * <ul>
   *   <li>When {@code Class Name}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonSerialisationUtil#getSerialisedFieldClasses(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFieldClasses(String); when 'Class Name'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonSerialisationUtil.getSerialisedFieldClasses(String)"})
  void testGetSerialisedFieldClasses_whenClassName_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JsonSerialisationUtil.getSerialisedFieldClasses("Class Name"));
  }

  /**
   * Test {@link JsonSerialisationUtil#getSerialisedFieldClasses(String)}.
   * <ul>
   *   <li>When {@code class}.</li>
   *   <li>Then return size is forty-one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonSerialisationUtil#getSerialisedFieldClasses(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFieldClasses(String); when 'class'; then return size is forty-one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonSerialisationUtil.getSerialisedFieldClasses(String)"})
  void testGetSerialisedFieldClasses_whenClass_thenReturnSizeIsFortyOne() {
    // Arrange and Act
    Map<String, String> actualSerialisedFieldClasses = JsonSerialisationUtil.getSerialisedFieldClasses("class");

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
   * <ul>
   *   <li>When {@code com.fasterxml.jackson.annotation.JsonCreator}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonSerialisationUtil#getSerialisedFieldClasses(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFieldClasses(String); when 'com.fasterxml.jackson.annotation.JsonCreator'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonSerialisationUtil.getSerialisedFieldClasses(String)"})
  void testGetSerialisedFieldClasses_whenComFasterxmlJacksonAnnotationJsonCreator() {
    // Arrange and Act
    Map<String, String> actualSerialisedFieldClasses = JsonSerialisationUtil
        .getSerialisedFieldClasses("com.fasterxml.jackson.annotation.JsonCreator");

    // Assert
    assertTrue(actualSerialisedFieldClasses.isEmpty());
  }

  /**
   * Test {@link JsonSerialisationUtil#getSerialisedFieldClasses(String)}.
   * <ul>
   *   <li>When {@code .}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonSerialisationUtil#getSerialisedFieldClasses(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFieldClasses(String); when '.'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonSerialisationUtil.getSerialisedFieldClasses(String)"})
  void testGetSerialisedFieldClasses_whenDot_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JsonSerialisationUtil.getSerialisedFieldClasses("."));
  }

  /**
   * Test {@link JsonSerialisationUtil#getSerialisedFieldClasses(String)}.
   * <ul>
   *   <li>When {@code Class}.</li>
   *   <li>Then return size is forty-one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonSerialisationUtil#getSerialisedFieldClasses(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFieldClasses(String); when 'java.lang.Class'; then return size is forty-one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonSerialisationUtil.getSerialisedFieldClasses(String)"})
  void testGetSerialisedFieldClasses_whenJavaLangClass_thenReturnSizeIsFortyOne() {
    // Arrange and Act
    Map<String, String> actualSerialisedFieldClasses = JsonSerialisationUtil
        .getSerialisedFieldClasses("java.lang.Class");

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
   * <ul>
   *   <li>When {@code String}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonSerialisationUtil#getSerialisedFieldClasses(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFieldClasses(String); when 'java.lang.String'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonSerialisationUtil.getSerialisedFieldClasses(String)"})
  void testGetSerialisedFieldClasses_whenJavaLangString_thenReturnEmpty() {
    // Arrange and Act
    Map<String, String> actualSerialisedFieldClasses = JsonSerialisationUtil
        .getSerialisedFieldClasses("java.lang.String");

    // Assert
    assertTrue(actualSerialisedFieldClasses.isEmpty());
  }

  /**
   * Test {@link JsonSerialisationUtil#getSerialisedFieldClasses(String)}.
   * <ul>
   *   <li>When {@code Map}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonSerialisationUtil#getSerialisedFieldClasses(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFieldClasses(String); when 'java.util.Map'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonSerialisationUtil.getSerialisedFieldClasses(String)"})
  void testGetSerialisedFieldClasses_whenJavaUtilMap_thenReturnEmpty() {
    // Arrange and Act
    Map<String, String> actualSerialisedFieldClasses = JsonSerialisationUtil.getSerialisedFieldClasses("java.util.Map");

    // Assert
    assertTrue(actualSerialisedFieldClasses.isEmpty());
  }

  /**
   * Test {@link JsonSerialisationUtil#getSerialisedFieldClasses(String)}.
   * <ul>
   *   <li>When {@code []}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonSerialisationUtil#getSerialisedFieldClasses(String)}
   */
  @Test
  @DisplayName("Test getSerialisedFieldClasses(String); when '[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map JsonSerialisationUtil.getSerialisedFieldClasses(String)"})
  void testGetSerialisedFieldClasses_whenLeftSquareBracketRightSquareBracket() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JsonSerialisationUtil.getSerialisedFieldClasses("[]"));
  }

  /**
   * Test {@link JsonSerialisationUtil#getTypeString(Type)}.
   * <ul>
   *   <li>Given {@link CollectionLikeType} {@link Type#getTypeName()} return {@code ? extends}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  @DisplayName("Test getTypeString(Type); given CollectionLikeType getTypeName() return '? extends'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link CollectionLikeType} {@link Type#getTypeName()} return {@code \? extends}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  @DisplayName("Test getTypeString(Type); given CollectionLikeType getTypeName() return '\\? extends'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link CollectionLikeType} {@link Type#getTypeName()} return space.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  @DisplayName("Test getTypeString(Type); given CollectionLikeType getTypeName() return space")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link CollectionLikeType} {@link Type#getTypeName()} return {@code ? super}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  @DisplayName("Test getTypeString(Type); given CollectionLikeType getTypeName() return '? super'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link CollectionLikeType} {@link Type#getTypeName()} return {@code \? super}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  @DisplayName("Test getTypeString(Type); given CollectionLikeType getTypeName() return '\\? super'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@code ? extends}.</li>
   *   <li>When {@link CollectionLikeType} {@link Type#getTypeName()} return {@code ? extends}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  @DisplayName("Test getTypeString(Type); given '? extends'; when CollectionLikeType getTypeName() return '? extends'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JsonSerialisationUtil.getTypeString(Type)"})
  void testGetTypeString_givenExtends_whenCollectionLikeTypeGetTypeNameReturnExtends() {
    // Arrange
    CollectionLikeType typeArg = mock(CollectionLikeType.class);
    when(typeArg.getTypeName()).thenReturn("? extends ");

    // Act
    String actualTypeString = JsonSerialisationUtil.getTypeString(typeArg);

    // Assert
    verify(typeArg).getTypeName();
    assertEquals("", actualTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getTypeString(Type)}.
   * <ul>
   *   <li>Given {@code \? extends}.</li>
   *   <li>When {@link CollectionLikeType} {@link Type#getTypeName()} return {@code \? extends}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  @DisplayName("Test getTypeString(Type); given '\\? extends'; when CollectionLikeType getTypeName() return '\\? extends'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JsonSerialisationUtil.getTypeString(Type)"})
  void testGetTypeString_givenExtends_whenCollectionLikeTypeGetTypeNameReturnExtends2() {
    // Arrange
    CollectionLikeType typeArg = mock(CollectionLikeType.class);
    when(typeArg.getTypeName()).thenReturn("\\? extends ");

    // Act
    String actualTypeString = JsonSerialisationUtil.getTypeString(typeArg);

    // Assert
    verify(typeArg).getTypeName();
    assertEquals("\\", actualTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getTypeString(Type)}.
   * <ul>
   *   <li>Given {@link PlaceholderForType#PlaceholderForType(int)} with ordinal is one.</li>
   *   <li>Then return {@code $2[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  @DisplayName("Test getTypeString(Type); given PlaceholderForType(int) with ordinal is one; then return '$2[]'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given space.</li>
   *   <li>When {@link CollectionLikeType} {@link Type#getTypeName()} return space.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  @DisplayName("Test getTypeString(Type); given space; when CollectionLikeType getTypeName() return space")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JsonSerialisationUtil.getTypeString(Type)"})
  void testGetTypeString_givenSpace_whenCollectionLikeTypeGetTypeNameReturnSpace() {
    // Arrange
    CollectionLikeType typeArg = mock(CollectionLikeType.class);
    when(typeArg.getTypeName()).thenReturn(" ");

    // Act
    String actualTypeString = JsonSerialisationUtil.getTypeString(typeArg);

    // Assert
    verify(typeArg).getTypeName();
    assertEquals("", actualTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getTypeString(Type)}.
   * <ul>
   *   <li>Given {@code ? super}.</li>
   *   <li>When {@link CollectionLikeType} {@link Type#getTypeName()} return {@code ? super}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  @DisplayName("Test getTypeString(Type); given '? super'; when CollectionLikeType getTypeName() return '? super'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JsonSerialisationUtil.getTypeString(Type)"})
  void testGetTypeString_givenSuper_whenCollectionLikeTypeGetTypeNameReturnSuper() {
    // Arrange
    CollectionLikeType typeArg = mock(CollectionLikeType.class);
    when(typeArg.getTypeName()).thenReturn("? super ");

    // Act
    String actualTypeString = JsonSerialisationUtil.getTypeString(typeArg);

    // Assert
    verify(typeArg).getTypeName();
    assertEquals("", actualTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getTypeString(Type)}.
   * <ul>
   *   <li>Given {@code \? super}.</li>
   *   <li>When {@link CollectionLikeType} {@link Type#getTypeName()} return {@code \? super}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  @DisplayName("Test getTypeString(Type); given '\\? super'; when CollectionLikeType getTypeName() return '\\? super'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JsonSerialisationUtil.getTypeString(Type)"})
  void testGetTypeString_givenSuper_whenCollectionLikeTypeGetTypeNameReturnSuper2() {
    // Arrange
    CollectionLikeType typeArg = mock(CollectionLikeType.class);
    when(typeArg.getTypeName()).thenReturn("\\? super ");

    // Act
    String actualTypeString = JsonSerialisationUtil.getTypeString(typeArg);

    // Assert
    verify(typeArg).getTypeName();
    assertEquals("\\", actualTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getTypeString(Type)}.
   * <ul>
   *   <li>Given {@code Type Name}.</li>
   *   <li>Then return {@code TypeName}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  @DisplayName("Test getTypeString(Type); given 'Type Name'; then return 'TypeName'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JsonSerialisationUtil.getTypeString(Type)"})
  void testGetTypeString_givenTypeName_thenReturnTypeName() {
    // Arrange
    CollectionLikeType typeArg = mock(CollectionLikeType.class);
    when(typeArg.getTypeName()).thenReturn("Type Name");

    // Act
    String actualTypeString = JsonSerialisationUtil.getTypeString(typeArg);

    // Assert
    verify(typeArg).getTypeName();
    assertEquals("TypeName", actualTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getTypeString(Type)}.
   * <ul>
   *   <li>Then return {@code .[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  @DisplayName("Test getTypeString(Type); then return '.[]'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then return {@code [recursivetype;Object[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  @DisplayName("Test getTypeString(Type); then return '[recursivetype;java.lang.Object[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JsonSerialisationUtil.getTypeString(Type)"})
  void testGetTypeString_thenReturnRecursivetypeJavaLangObject() {
    // Arrange
    Class<Object> erasedType = Object.class;

    ResolvedRecursiveType resolvedRecursiveType = new ResolvedRecursiveType(erasedType, TypeBindings.emptyBindings());
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
   * <ul>
   *   <li>Then return {@code [recursivetype;UNRESOLVED[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  @DisplayName("Test getTypeString(Type); then return '[recursivetype;UNRESOLVED[]'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then return {@code TypeName[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  @DisplayName("Test getTypeString(Type); then return 'TypeName[]'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  @DisplayName("Test getTypeString(Type); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JsonSerialisationUtil.getTypeString(Type)"})
  void testGetTypeString_thenThrowIllegalArgumentException() {
    // Arrange
    GenericArrayType typeArg = mock(GenericArrayType.class);
    when(typeArg.getGenericComponentType()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JsonSerialisationUtil.getTypeString(typeArg));
    verify(typeArg).getGenericComponentType();
  }

  /**
   * Test {@link JsonSerialisationUtil#getTypeString(Type)}.
   * <ul>
   *   <li>When {@link PlaceholderForType#PlaceholderForType(int)} with ordinal is one.</li>
   *   <li>Then return {@code $2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  @DisplayName("Test getTypeString(Type); when PlaceholderForType(int) with ordinal is one; then return '$2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JsonSerialisationUtil.getTypeString(Type)"})
  void testGetTypeString_whenPlaceholderForTypeWithOrdinalIsOne_thenReturn2() {
    // Arrange, Act and Assert
    assertEquals("$2", JsonSerialisationUtil.getTypeString(new PlaceholderForType(1)));
  }

  /**
   * Test {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}.
   * <p>
   * Method under test: {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}
   */
  @Test
  @DisplayName("Test getFieldTypeString(Class, Type)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JsonSerialisationUtil.getFieldTypeString(Class, Type)"})
  void testGetFieldTypeString() {
    // Arrange
    Class<Object> clazz = Object.class;
    PlaceholderForType typeArg = new PlaceholderForType(1);

    // Act
    String actualFieldTypeString = JsonSerialisationUtil.getFieldTypeString(clazz, typeArg);

    // Assert
    JavaType superClass = typeArg.getSuperClass();
    assertTrue(superClass instanceof SimpleType);
    assertEquals("$2", actualFieldTypeString);
    Class<Object> expectedRawClass = Object.class;
    assertEquals(expectedRawClass, typeArg.getRawClass());
    assertSame(clazz, superClass.getRawClass());
  }

  /**
   * Test {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}.
   * <ul>
   *   <li>Given {@link CollectionLikeType} {@link Type#getTypeName()} return {@code ? extends}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}
   */
  @Test
  @DisplayName("Test getFieldTypeString(Class, Type); given CollectionLikeType getTypeName() return '? extends'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JsonSerialisationUtil.getFieldTypeString(Class, Type)"})
  void testGetFieldTypeString_givenCollectionLikeTypeGetTypeNameReturnExtends() {
    // Arrange
    Class<Object> clazz = Object.class;
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getTypeName()).thenReturn("? extends ");
    GenericArrayType typeArg = mock(GenericArrayType.class);
    when(typeArg.getGenericComponentType()).thenReturn(collectionLikeType);

    // Act
    String actualFieldTypeString = JsonSerialisationUtil.getFieldTypeString(clazz, typeArg);

    // Assert
    verify(typeArg).getGenericComponentType();
    verify(collectionLikeType).getTypeName();
    assertEquals("[]", actualFieldTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}.
   * <ul>
   *   <li>Given {@link CollectionLikeType} {@link Type#getTypeName()} return {@code \? extends}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}
   */
  @Test
  @DisplayName("Test getFieldTypeString(Class, Type); given CollectionLikeType getTypeName() return '\\? extends'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JsonSerialisationUtil.getFieldTypeString(Class, Type)"})
  void testGetFieldTypeString_givenCollectionLikeTypeGetTypeNameReturnExtends2() {
    // Arrange
    Class<Object> clazz = Object.class;
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getTypeName()).thenReturn("\\? extends ");
    GenericArrayType typeArg = mock(GenericArrayType.class);
    when(typeArg.getGenericComponentType()).thenReturn(collectionLikeType);

    // Act
    String actualFieldTypeString = JsonSerialisationUtil.getFieldTypeString(clazz, typeArg);

    // Assert
    verify(typeArg).getGenericComponentType();
    verify(collectionLikeType).getTypeName();
    assertEquals("\\[]", actualFieldTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}.
   * <ul>
   *   <li>Given {@link CollectionLikeType} {@link Type#getTypeName()} return space.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}
   */
  @Test
  @DisplayName("Test getFieldTypeString(Class, Type); given CollectionLikeType getTypeName() return space")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JsonSerialisationUtil.getFieldTypeString(Class, Type)"})
  void testGetFieldTypeString_givenCollectionLikeTypeGetTypeNameReturnSpace() {
    // Arrange
    Class<Object> clazz = Object.class;
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getTypeName()).thenReturn(" ");
    GenericArrayType typeArg = mock(GenericArrayType.class);
    when(typeArg.getGenericComponentType()).thenReturn(collectionLikeType);

    // Act
    String actualFieldTypeString = JsonSerialisationUtil.getFieldTypeString(clazz, typeArg);

    // Assert
    verify(typeArg).getGenericComponentType();
    verify(collectionLikeType).getTypeName();
    assertEquals("[]", actualFieldTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}.
   * <ul>
   *   <li>Given {@link CollectionLikeType} {@link Type#getTypeName()} return {@code ? super}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}
   */
  @Test
  @DisplayName("Test getFieldTypeString(Class, Type); given CollectionLikeType getTypeName() return '? super'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JsonSerialisationUtil.getFieldTypeString(Class, Type)"})
  void testGetFieldTypeString_givenCollectionLikeTypeGetTypeNameReturnSuper() {
    // Arrange
    Class<Object> clazz = Object.class;
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getTypeName()).thenReturn("? super ");
    GenericArrayType typeArg = mock(GenericArrayType.class);
    when(typeArg.getGenericComponentType()).thenReturn(collectionLikeType);

    // Act
    String actualFieldTypeString = JsonSerialisationUtil.getFieldTypeString(clazz, typeArg);

    // Assert
    verify(typeArg).getGenericComponentType();
    verify(collectionLikeType).getTypeName();
    assertEquals("[]", actualFieldTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}.
   * <ul>
   *   <li>Given {@link CollectionLikeType} {@link Type#getTypeName()} return {@code \? super}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}
   */
  @Test
  @DisplayName("Test getFieldTypeString(Class, Type); given CollectionLikeType getTypeName() return '\\? super'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JsonSerialisationUtil.getFieldTypeString(Class, Type)"})
  void testGetFieldTypeString_givenCollectionLikeTypeGetTypeNameReturnSuper2() {
    // Arrange
    Class<Object> clazz = Object.class;
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getTypeName()).thenReturn("\\? super ");
    GenericArrayType typeArg = mock(GenericArrayType.class);
    when(typeArg.getGenericComponentType()).thenReturn(collectionLikeType);

    // Act
    String actualFieldTypeString = JsonSerialisationUtil.getFieldTypeString(clazz, typeArg);

    // Assert
    verify(typeArg).getGenericComponentType();
    verify(collectionLikeType).getTypeName();
    assertEquals("\\[]", actualFieldTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}.
   * <ul>
   *   <li>Given {@link PlaceholderForType#PlaceholderForType(int)} with ordinal is one.</li>
   *   <li>Then return {@code $2[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}
   */
  @Test
  @DisplayName("Test getFieldTypeString(Class, Type); given PlaceholderForType(int) with ordinal is one; then return '$2[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JsonSerialisationUtil.getFieldTypeString(Class, Type)"})
  void testGetFieldTypeString_givenPlaceholderForTypeWithOrdinalIsOne_thenReturn2() {
    // Arrange
    GenericArrayType typeArg = mock(GenericArrayType.class);
    when(typeArg.getGenericComponentType()).thenReturn(new PlaceholderForType(1));

    // Act
    String actualFieldTypeString = JsonSerialisationUtil.getFieldTypeString(null, typeArg);

    // Assert
    verify(typeArg).getGenericComponentType();
    assertEquals("$2[]", actualFieldTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}.
   * <ul>
   *   <li>Then return {@code .[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}
   */
  @Test
  @DisplayName("Test getFieldTypeString(Class, Type); then return '.[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JsonSerialisationUtil.getFieldTypeString(Class, Type)"})
  void testGetFieldTypeString_thenReturnDotLeftSquareBracketRightSquareBracket() {
    // Arrange
    Class<Object> clazz = Object.class;
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getTypeName()).thenReturn(".");
    GenericArrayType typeArg = mock(GenericArrayType.class);
    when(typeArg.getGenericComponentType()).thenReturn(collectionLikeType);

    // Act
    String actualFieldTypeString = JsonSerialisationUtil.getFieldTypeString(clazz, typeArg);

    // Assert
    verify(typeArg).getGenericComponentType();
    verify(collectionLikeType).getTypeName();
    assertEquals(".[]", actualFieldTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}.
   * <ul>
   *   <li>Then return {@code TypeName[]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}
   */
  @Test
  @DisplayName("Test getFieldTypeString(Class, Type); then return 'TypeName[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JsonSerialisationUtil.getFieldTypeString(Class, Type)"})
  void testGetFieldTypeString_thenReturnTypeName() {
    // Arrange
    Class<Object> clazz = Object.class;
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getTypeName()).thenReturn("Type Name");
    GenericArrayType typeArg = mock(GenericArrayType.class);
    when(typeArg.getGenericComponentType()).thenReturn(collectionLikeType);

    // Act
    String actualFieldTypeString = JsonSerialisationUtil.getFieldTypeString(clazz, typeArg);

    // Assert
    verify(typeArg).getGenericComponentType();
    verify(collectionLikeType).getTypeName();
    assertEquals("TypeName[]", actualFieldTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}
   */
  @Test
  @DisplayName("Test getFieldTypeString(Class, Type); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String JsonSerialisationUtil.getFieldTypeString(Class, Type)"})
  void testGetFieldTypeString_thenThrowIllegalArgumentException() {
    // Arrange
    GenericArrayType typeArg = mock(GenericArrayType.class);
    when(typeArg.getGenericComponentType()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JsonSerialisationUtil.getFieldTypeString(null, typeArg));
    verify(typeArg).getGenericComponentType();
  }
}
