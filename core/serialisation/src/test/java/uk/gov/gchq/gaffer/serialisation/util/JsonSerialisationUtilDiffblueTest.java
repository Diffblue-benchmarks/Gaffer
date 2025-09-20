package uk.gov.gchq.gaffer.serialisation.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
   *   <li>When {@code com.fasterxml.jackson.annotation.JsonCreator}.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getSerialisedFieldClasses(String)}
   */
  @Test
  @DisplayName(
      "Test getSerialisedFieldClasses(String); when 'com.fasterxml.jackson.annotation.JsonCreator'")
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
  void testGetSerialisedFieldClasses_whenDot_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> JsonSerialisationUtil.getSerialisedFieldClasses("."));
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
  void testGetSerialisedFieldClasses_whenLeftSquareBracketRightSquareBracket() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> JsonSerialisationUtil.getSerialisedFieldClasses("[]"));
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
   *   <li>Given {@link CollectionLikeType} {@link CollectionLikeType#getTypeName()} return {@code
   *       null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  @DisplayName(
      "Test getTypeString(Type); given CollectionLikeType getTypeName() return 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testGetTypeString_givenCollectionLikeTypeGetTypeNameReturnNull_thenReturnNull() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getTypeName()).thenReturn(null);

    GenericArrayType typeArg = mock(GenericArrayType.class);
    when(typeArg.getGenericComponentType()).thenReturn(collectionLikeType);

    // Act
    String actualTypeString = JsonSerialisationUtil.getTypeString(typeArg);

    // Assert
    verify(typeArg).getGenericComponentType();
    verify(collectionLikeType).getTypeName();
    assertNull(actualTypeString);
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
   *   <li>Given {@link PlaceholderForType#PlaceholderForType(int)} with ordinal is one.
   *   <li>Then return {@code $2[]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  @DisplayName(
      "Test getTypeString(Type); given PlaceholderForType(int) with ordinal is one; then return '$2[]'")
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
   *   <li>Then return {@code TypeName[]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getTypeString(Type)}
   */
  @Test
  @DisplayName("Test getTypeString(Type); then return 'TypeName[]'")
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
  void testGetTypeString_whenPlaceholderForTypeWithOrdinalIsOne_thenReturn2() {
    // Arrange, Act and Assert
    assertEquals("$2", JsonSerialisationUtil.getTypeString(new PlaceholderForType(1)));
  }

  /**
   * Test {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}.
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}
   */
  @Test
  @DisplayName("Test getFieldTypeString(Class, Type)")
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
   *
   * <ul>
   *   <li>Then return {@code .[]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}
   */
  @Test
  @DisplayName("Test getFieldTypeString(Class, Type); then return '.[]'")
  @Tag("MaintainedByDiffblue")
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
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}
   */
  @Test
  @DisplayName("Test getFieldTypeString(Class, Type); then return 'null'")
  @Tag("MaintainedByDiffblue")
  void testGetFieldTypeString_thenReturnNull() {
    // Arrange
    CollectionLikeType collectionLikeType = mock(CollectionLikeType.class);
    when(collectionLikeType.getTypeName()).thenReturn(null);

    GenericArrayType typeArg = mock(GenericArrayType.class);
    when(typeArg.getGenericComponentType()).thenReturn(collectionLikeType);

    // Act
    String actualFieldTypeString = JsonSerialisationUtil.getFieldTypeString(null, typeArg);

    // Assert
    verify(typeArg).getGenericComponentType();
    verify(collectionLikeType).getTypeName();
    assertNull(actualFieldTypeString);
  }

  /**
   * Test {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}.
   *
   * <ul>
   *   <li>Then return {@code [recursivetype;Object[]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}
   */
  @Test
  @DisplayName(
      "Test getFieldTypeString(Class, Type); then return '[recursivetype;java.lang.Object[]'")
  @Tag("MaintainedByDiffblue")
  void testGetFieldTypeString_thenReturnRecursivetypeJavaLangObject() {
    // Arrange
    Class<Object> erasedType = Object.class;

    ResolvedRecursiveType resolvedRecursiveType =
        new ResolvedRecursiveType(erasedType, TypeBindings.emptyBindings());
    resolvedRecursiveType.setReference(new PlaceholderForType(1));

    GenericArrayType typeArg = mock(GenericArrayType.class);
    when(typeArg.getGenericComponentType()).thenReturn(resolvedRecursiveType);

    // Act
    String actualFieldTypeString = JsonSerialisationUtil.getFieldTypeString(null, typeArg);

    // Assert
    verify(typeArg).getGenericComponentType();
    assertEquals("[recursivetype;java.lang.Object[]", actualFieldTypeString);
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
  @Tag("MaintainedByDiffblue")
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
   *   <li>Then return {@code TypeName[]}.
   * </ul>
   *
   * <p>Method under test: {@link JsonSerialisationUtil#getFieldTypeString(Class, Type)}
   */
  @Test
  @DisplayName("Test getFieldTypeString(Class, Type); then return 'TypeName[]'")
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
  void testGetFieldTypeString_thenThrowIllegalArgumentException() {
    // Arrange
    GenericArrayType typeArg = mock(GenericArrayType.class);
    when(typeArg.getGenericComponentType()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> JsonSerialisationUtil.getFieldTypeString(null, typeArg));
    verify(typeArg).getGenericComponentType();
  }
}
