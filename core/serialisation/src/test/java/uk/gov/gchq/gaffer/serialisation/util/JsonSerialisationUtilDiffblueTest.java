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
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.PlaceholderForType;
import com.fasterxml.jackson.databind.type.ResolvedRecursiveType;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.fasterxml.jackson.databind.type.TypeBindings;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Map;
import org.junit.jupiter.api.Test;

class JsonSerialisationUtilDiffblueTest {
  /**
   * Method under test:
   * {@link JsonSerialisationUtil#getSerialisedFieldClasses(String)}
   */
  @Test
  void testGetSerialisedFieldClasses() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JsonSerialisationUtil.getSerialisedFieldClasses("Class Name"));
    assertThrows(IllegalArgumentException.class, () -> JsonSerialisationUtil.getSerialisedFieldClasses("."));
    assertThrows(IllegalArgumentException.class, () -> JsonSerialisationUtil.getSerialisedFieldClasses("[]"));
  }

  /**
   * Method under test:
   * {@link JsonSerialisationUtil#getSerialisedFieldClasses(String)}
   */
  @Test
  void testGetSerialisedFieldClasses2() {
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
   * Method under test:
   * {@link JsonSerialisationUtil#getSerialisedFieldClasses(String)}
   */
  @Test
  void testGetSerialisedFieldClasses3() {
    // Arrange and Act
    Map<String, String> actualSerialisedFieldClasses = JsonSerialisationUtil
        .getSerialisedFieldClasses("com.fasterxml.jackson.annotation.JsonCreator");

    // Assert
    assertTrue(actualSerialisedFieldClasses.isEmpty());
  }

  /**
   * Method under test:
   * {@link JsonSerialisationUtil#getSerialisedFieldClasses(String)}
   */
  @Test
  void testGetSerialisedFieldClasses4() {
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
   * Method under test:
   * {@link JsonSerialisationUtil#getSerialisedFieldClasses(String)}
   */
  @Test
  void testGetSerialisedFieldClasses5() {
    // Arrange and Act
    Map<String, String> actualSerialisedFieldClasses = JsonSerialisationUtil
        .getSerialisedFieldClasses("java.lang.String");

    // Assert
    assertTrue(actualSerialisedFieldClasses.isEmpty());
  }

  /**
   * Method under test:
   * {@link JsonSerialisationUtil#getSerialisedFieldClasses(String)}
   */
  @Test
  void testGetSerialisedFieldClasses6() {
    // Arrange and Act
    Map<String, String> actualSerialisedFieldClasses = JsonSerialisationUtil.getSerialisedFieldClasses("java.util.Map");

    // Assert
    assertTrue(actualSerialisedFieldClasses.isEmpty());
  }

  /**
   * Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  void testGetTypeString() {
    // Arrange, Act and Assert
    assertEquals("$2", JsonSerialisationUtil.getTypeString(new PlaceholderForType(1)));
  }

  /**
   * Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  void testGetTypeString2() {
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
   * Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  void testGetTypeString3() {
    // Arrange
    GenericArrayType typeArg = mock(GenericArrayType.class);
    when(typeArg.getGenericComponentType()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JsonSerialisationUtil.getTypeString(typeArg));
    verify(typeArg).getGenericComponentType();
  }

  /**
   * Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  void testGetTypeString4() {
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
   * Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  void testGetTypeString5() {
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
   * Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  void testGetTypeString6() {
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
   * Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  void testGetTypeString7() {
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
   * Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  void testGetTypeString8() {
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
   * Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  void testGetTypeString9() {
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
   * Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  void testGetTypeString10() {
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
   * Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  void testGetTypeString11() {
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
   * Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  void testGetTypeString12() {
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
   * Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  void testGetTypeString13() {
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
   * Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  void testGetTypeString14() {
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
   * Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  void testGetTypeString15() {
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
   * Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  void testGetTypeString16() {
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
   * Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  void testGetTypeString17() {
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
   * Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  void testGetTypeString18() {
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
   * Method under test:
   * {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}
   */
  @Test
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
    Class<?> rawClass = typeArg.getRawClass();
    assertEquals(expectedRawClass, rawClass);
    assertSame(clazz, rawClass);
    assertSame(clazz, superClass.getRawClass());
  }

  /**
   * Method under test:
   * {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}
   */
  @Test
  void testGetFieldTypeString2() {
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
   * Method under test:
   * {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}
   */
  @Test
  void testGetFieldTypeString3() {
    // Arrange
    GenericArrayType typeArg = mock(GenericArrayType.class);
    when(typeArg.getGenericComponentType()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> JsonSerialisationUtil.getFieldTypeString(null, typeArg));
    verify(typeArg).getGenericComponentType();
  }

  /**
   * Method under test:
   * {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}
   */
  @Test
  void testGetFieldTypeString4() {
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
   * Method under test:
   * {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}
   */
  @Test
  void testGetFieldTypeString5() {
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
   * Method under test:
   * {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}
   */
  @Test
  void testGetFieldTypeString6() {
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
   * Method under test:
   * {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}
   */
  @Test
  void testGetFieldTypeString7() {
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
   * Method under test:
   * {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}
   */
  @Test
  void testGetFieldTypeString8() {
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
   * Method under test:
   * {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}
   */
  @Test
  void testGetFieldTypeString9() {
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
   * Method under test:
   * {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}
   */
  @Test
  void testGetFieldTypeString10() {
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
}
