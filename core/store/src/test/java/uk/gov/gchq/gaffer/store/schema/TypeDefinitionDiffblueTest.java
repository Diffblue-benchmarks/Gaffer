package uk.gov.gchq.gaffer.store.schema;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.access.predicate.user.DefaultUserPredicate;
import uk.gov.gchq.gaffer.data.elementdefinition.exception.SchemaException;
import uk.gov.gchq.gaffer.serialisation.AvroSerialiser;
import uk.gov.gchq.gaffer.serialisation.Serialiser;
import uk.gov.gchq.gaffer.store.schema.TypeDefinition.Builder;
import uk.gov.gchq.koryphe.binaryoperator.AdaptedBinaryOperator;

class TypeDefinitionDiffblueTest {
  /**
   * Test Builder {@link Builder#aggregateFunction(BinaryOperator)}.
   *
   * <p>Method under test: {@link Builder#aggregateFunction(BinaryOperator)}
   */
  @Test
  @DisplayName("Test Builder aggregateFunction(BinaryOperator)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.aggregateFunction(BinaryOperator)"})
  void testBuilderAggregateFunction() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualAggregateFunctionResult = builder.aggregateFunction(mock(BinaryOperator.class));

    // Assert
    assertSame(builder, actualAggregateFunctionResult);
  }

  /**
   * Test Builder {@link Builder#clazz(Class)}.
   *
   * <p>Method under test: {@link Builder#clazz(Class)}
   */
  @Test
  @DisplayName("Test Builder clazz(Class)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.clazz(Class)"})
  void testBuilderClazz() {
    // Arrange
    Builder builder = new Builder();
    Class<Object> clazz = Object.class;

    // Act
    Builder actualClazzResult = builder.clazz(clazz);

    // Assert
    assertSame(builder, actualClazzResult);
  }

  /**
   * Test Builder {@link Builder#description(String)}.
   *
   * <p>Method under test: {@link Builder#description(String)}
   */
  @Test
  @DisplayName("Test Builder description(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.description(String)"})
  void testBuilderDescription() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualDescriptionResult =
        builder.description("The characteristics of someone or something");

    // Assert
    assertSame(builder, actualDescriptionResult);
  }

  /**
   * Test Builder new {@link Builder} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange, Act and Assert
    TypeDefinition typeDefinition = new Builder().build();
    assertNull(typeDefinition.getClazz());
    assertNull(typeDefinition.getClassString());
    assertNull(typeDefinition.getDescription());
    assertNull(typeDefinition.getFullClassString());
    assertNull(typeDefinition.getValidateFunctions());
    assertNull(typeDefinition.getAggregateFunction());
    assertNull(typeDefinition.getSerialiser());
  }

  /**
   * Test Builder {@link Builder#serialiser(Serialiser)}.
   *
   * <ul>
   *   <li>When {@link AvroSerialiser} (default constructor).
   *   <li>Then return {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#serialiser(Serialiser)}
   */
  @Test
  @DisplayName(
      "Test Builder serialiser(Serialiser); when AvroSerialiser (default constructor); then return Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.serialiser(Serialiser)"})
  void testBuilderSerialiser_whenAvroSerialiser_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualSerialiserResult = builder.serialiser(new AvroSerialiser());

    // Assert
    assertSame(builder, actualSerialiserResult);
  }

  /**
   * Test Builder {@link Builder#validateFunctions(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@link Predicate}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link Predicate}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#validateFunctions(List)}
   */
  @Test
  @DisplayName(
      "Test Builder validateFunctions(List) with 'List'; given Predicate; when ArrayList() add Predicate")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.validateFunctions(List)"})
  void testBuilderValidateFunctionsWithList_givenPredicate_whenArrayListAddPredicate() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Predicate> validateFunctions = new ArrayList<>();
    validateFunctions.add(mock(Predicate.class));

    // Act
    Builder actualValidateFunctionsResult = builder.validateFunctions(validateFunctions);

    // Assert
    assertSame(builder, actualValidateFunctionsResult);
  }

  /**
   * Test Builder {@link Builder#validateFunctions(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@link Predicate}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link Predicate}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#validateFunctions(List)}
   */
  @Test
  @DisplayName(
      "Test Builder validateFunctions(List) with 'List'; given Predicate; when ArrayList() add Predicate")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.validateFunctions(List)"})
  void testBuilderValidateFunctionsWithList_givenPredicate_whenArrayListAddPredicate2() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Predicate> validateFunctions = new ArrayList<>();
    validateFunctions.add(mock(Predicate.class));
    validateFunctions.add(mock(Predicate.class));

    // Act
    Builder actualValidateFunctionsResult = builder.validateFunctions(validateFunctions);

    // Assert
    assertSame(builder, actualValidateFunctionsResult);
  }

  /**
   * Test Builder {@link Builder#validateFunctions(List)} with {@code List}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#validateFunctions(List)}
   */
  @Test
  @DisplayName("Test Builder validateFunctions(List) with 'List'; when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.validateFunctions(List)"})
  void testBuilderValidateFunctionsWithList_whenArrayList() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualValidateFunctionsResult = builder.validateFunctions(new ArrayList<>());

    // Assert
    assertSame(builder, actualValidateFunctionsResult);
  }

  /**
   * Test Builder {@link Builder#validateFunctions(Predicate[])} with {@code Predicate[]}.
   *
   * <ul>
   *   <li>When {@link Predicate}.
   *   <li>Then return {@link Builder} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#validateFunctions(Predicate[])}
   */
  @Test
  @DisplayName(
      "Test Builder validateFunctions(Predicate[]) with 'Predicate[]'; when Predicate; then return Builder (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.validateFunctions(Predicate[])"})
  void testBuilderValidateFunctionsWithPredicate_whenPredicate_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualValidateFunctionsResult = builder.validateFunctions(mock(Predicate.class));

    // Assert
    assertSame(builder, actualValidateFunctionsResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TypeDefinition#TypeDefinition()}
   *   <li>{@link TypeDefinition#setAggregateFunction(BinaryOperator)}
   *   <li>{@link TypeDefinition#setClazz(Class)}
   *   <li>{@link TypeDefinition#setDescription(String)}
   *   <li>{@link TypeDefinition#setValidateFunctions(List)}
   *   <li>{@link TypeDefinition#toString()}
   *   <li>{@link TypeDefinition#getAggregateFunction()}
   *   <li>{@link TypeDefinition#getClazz()}
   *   <li>{@link TypeDefinition#getDescription()}
   *   <li>{@link TypeDefinition#getSerialiser()}
   *   <li>{@link TypeDefinition#getValidateFunctions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TypeDefinition.<init>()",
    "void TypeDefinition.<init>(Class)",
    "BinaryOperator TypeDefinition.getAggregateFunction()",
    "Class TypeDefinition.getClazz()",
    "String TypeDefinition.getDescription()",
    "Serialiser TypeDefinition.getSerialiser()",
    "List TypeDefinition.getValidateFunctions()",
    "void TypeDefinition.setAggregateFunction(BinaryOperator)",
    "void TypeDefinition.setClazz(Class)",
    "void TypeDefinition.setDescription(String)",
    "void TypeDefinition.setSerialiser(Serialiser)",
    "void TypeDefinition.setValidateFunctions(List)",
    "String TypeDefinition.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TypeDefinition actualTypeDefinition = new TypeDefinition();
    BinaryOperator<Object> binaryOperator = mock(BinaryOperator.class);
    actualTypeDefinition.setAggregateFunction(binaryOperator);
    Class<Object> clazz = Object.class;
    actualTypeDefinition.setClazz(clazz);
    actualTypeDefinition.setDescription("The characteristics of someone or something");
    ArrayList<Predicate> validateFunctions = new ArrayList<>();
    actualTypeDefinition.setValidateFunctions(validateFunctions);
    actualTypeDefinition.toString();
    BinaryOperator actualAggregateFunction = actualTypeDefinition.getAggregateFunction();
    Class<?> actualClazz = actualTypeDefinition.getClazz();
    String actualDescription = actualTypeDefinition.getDescription();
    Serialiser actualSerialiser = actualTypeDefinition.getSerialiser();
    List<Predicate> actualValidateFunctions = actualTypeDefinition.getValidateFunctions();

    // Assert
    assertEquals("The characteristics of someone or something", actualDescription);
    assertNull(actualSerialiser);
    assertTrue(actualValidateFunctions.isEmpty());
    Class<Object> expectedClazz = Object.class;
    assertEquals(expectedClazz, actualClazz);
    assertSame(validateFunctions, actualValidateFunctions);
    assertSame(clazz, actualClazz);
    assertSame(binaryOperator, actualAggregateFunction);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Object}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TypeDefinition#TypeDefinition(Class)}
   *   <li>{@link TypeDefinition#setAggregateFunction(BinaryOperator)}
   *   <li>{@link TypeDefinition#setClazz(Class)}
   *   <li>{@link TypeDefinition#setDescription(String)}
   *   <li>{@link TypeDefinition#setValidateFunctions(List)}
   *   <li>{@link TypeDefinition#toString()}
   *   <li>{@link TypeDefinition#getAggregateFunction()}
   *   <li>{@link TypeDefinition#getClazz()}
   *   <li>{@link TypeDefinition#getDescription()}
   *   <li>{@link TypeDefinition#getSerialiser()}
   *   <li>{@link TypeDefinition#getValidateFunctions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'java.lang.Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TypeDefinition.<init>()",
    "void TypeDefinition.<init>(Class)",
    "BinaryOperator TypeDefinition.getAggregateFunction()",
    "Class TypeDefinition.getClazz()",
    "String TypeDefinition.getDescription()",
    "Serialiser TypeDefinition.getSerialiser()",
    "List TypeDefinition.getValidateFunctions()",
    "void TypeDefinition.setAggregateFunction(BinaryOperator)",
    "void TypeDefinition.setClazz(Class)",
    "void TypeDefinition.setDescription(String)",
    "void TypeDefinition.setSerialiser(Serialiser)",
    "void TypeDefinition.setValidateFunctions(List)",
    "String TypeDefinition.toString()"
  })
  void testGettersAndSetters_whenJavaLangObject() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act
    TypeDefinition actualTypeDefinition = new TypeDefinition(clazz);
    BinaryOperator<Object> binaryOperator = mock(BinaryOperator.class);
    actualTypeDefinition.setAggregateFunction(binaryOperator);
    Class<Object> clazz2 = Object.class;
    actualTypeDefinition.setClazz(clazz2);
    actualTypeDefinition.setDescription("The characteristics of someone or something");
    ArrayList<Predicate> validateFunctions = new ArrayList<>();
    actualTypeDefinition.setValidateFunctions(validateFunctions);
    actualTypeDefinition.toString();
    BinaryOperator actualAggregateFunction = actualTypeDefinition.getAggregateFunction();
    Class<?> actualClazz = actualTypeDefinition.getClazz();
    String actualDescription = actualTypeDefinition.getDescription();
    Serialiser actualSerialiser = actualTypeDefinition.getSerialiser();
    List<Predicate> actualValidateFunctions = actualTypeDefinition.getValidateFunctions();

    // Assert
    assertEquals("The characteristics of someone or something", actualDescription);
    assertNull(actualSerialiser);
    assertTrue(actualValidateFunctions.isEmpty());
    Class<Object> expectedClazz = Object.class;
    assertEquals(expectedClazz, actualClazz);
    assertSame(validateFunctions, actualValidateFunctions);
    assertSame(clazz2, actualClazz);
    assertSame(binaryOperator, actualAggregateFunction);
  }

  /**
   * Test {@link TypeDefinition#getClassString()}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>Then return {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link TypeDefinition#getClassString()}
   */
  @Test
  @DisplayName("Test getClassString(); given 'java.lang.Object'; then return 'java.lang.Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TypeDefinition.getClassString()"})
  void testGetClassString_givenJavaLangObject_thenReturnJavaLangObject() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals("java.lang.Object", new TypeDefinition(clazz).getClassString());
  }

  /**
   * Test {@link TypeDefinition#getClassString()}.
   *
   * <ul>
   *   <li>Given {@link TypeDefinition#TypeDefinition()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TypeDefinition#getClassString()}
   */
  @Test
  @DisplayName("Test getClassString(); given TypeDefinition(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TypeDefinition.getClassString()"})
  void testGetClassString_givenTypeDefinition_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new TypeDefinition().getClassString());
  }

  /**
   * Test {@link TypeDefinition#setClassString(String)}.
   *
   * <p>Method under test: {@link TypeDefinition#setClassString(String)}
   */
  @Test
  @DisplayName("Test setClassString(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TypeDefinition.setClassString(String)"})
  void testSetClassString() throws ClassNotFoundException {
    // Arrange
    TypeDefinition typeDefinition = new TypeDefinition();

    // Act
    typeDefinition.setClassString("uk.gov.gchq.gaffer.store.schema.TypeDefinition");

    // Assert
    assertEquals("uk.gov.gchq.gaffer.store.schema.TypeDefinition", typeDefinition.getClassString());
    assertEquals(
        "uk.gov.gchq.gaffer.store.schema.TypeDefinition", typeDefinition.getFullClassString());
    Class<TypeDefinition> expectedClazz = TypeDefinition.class;
    assertEquals(expectedClazz, typeDefinition.getClazz());
  }

  /**
   * Test {@link TypeDefinition#setClassString(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link TypeDefinition#TypeDefinition()} Clazz is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TypeDefinition#setClassString(String)}
   */
  @Test
  @DisplayName("Test setClassString(String); when 'null'; then TypeDefinition() Clazz is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TypeDefinition.setClassString(String)"})
  void testSetClassString_whenNull_thenTypeDefinitionClazzIsNull() throws ClassNotFoundException {
    // Arrange
    TypeDefinition typeDefinition = new TypeDefinition();

    // Act
    typeDefinition.setClassString(null);

    // Assert that nothing has changed
    assertNull(typeDefinition.getClazz());
    assertNull(typeDefinition.getClassString());
    assertNull(typeDefinition.getFullClassString());
  }

  /**
   * Test {@link TypeDefinition#getFullClassString()}.
   *
   * <ul>
   *   <li>Given {@code Object}.
   *   <li>Then return {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link TypeDefinition#getFullClassString()}
   */
  @Test
  @DisplayName(
      "Test getFullClassString(); given 'java.lang.Object'; then return 'java.lang.Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TypeDefinition.getFullClassString()"})
  void testGetFullClassString_givenJavaLangObject_thenReturnJavaLangObject() {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertEquals("java.lang.Object", new TypeDefinition(clazz).getFullClassString());
  }

  /**
   * Test {@link TypeDefinition#getFullClassString()}.
   *
   * <ul>
   *   <li>Given {@link TypeDefinition#TypeDefinition()}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TypeDefinition#getFullClassString()}
   */
  @Test
  @DisplayName("Test getFullClassString(); given TypeDefinition(); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TypeDefinition.getFullClassString()"})
  void testGetFullClassString_givenTypeDefinition_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new TypeDefinition().getFullClassString());
  }

  /**
   * Test {@link TypeDefinition#merge(TypeDefinition)}.
   *
   * <p>Method under test: {@link TypeDefinition#merge(TypeDefinition)}
   */
  @Test
  @DisplayName("Test merge(TypeDefinition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TypeDefinition.merge(TypeDefinition)"})
  void testMerge() {
    // Arrange
    TypeDefinition typeDefinition = new TypeDefinition();
    typeDefinition.setValidateFunctions(new ArrayList<>());

    ArrayList<Predicate> validateFunctions = new ArrayList<>();
    DefaultUserPredicate defaultUserPredicate = new DefaultUserPredicate("42", new ArrayList<>());
    validateFunctions.add(defaultUserPredicate);

    TypeDefinition type = new TypeDefinition();
    type.setValidateFunctions(validateFunctions);

    // Act
    typeDefinition.merge(type);

    // Assert
    assertEquals(typeDefinition, type);
  }

  /**
   * Test {@link TypeDefinition#merge(TypeDefinition)}.
   *
   * <p>Method under test: {@link TypeDefinition#merge(TypeDefinition)}
   */
  @Test
  @DisplayName("Test merge(TypeDefinition)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TypeDefinition.merge(TypeDefinition)"})
  void testMerge2() {
    // Arrange
    Builder builder = new Builder();
    AdaptedBinaryOperator<Object, Object> adaptedBinaryOperator =
        new AdaptedBinaryOperator<>(
            mock(BinaryOperator.class), mock(Function.class), mock(Function.class));
    TypeDefinition typeDefinition = builder.aggregateFunction(adaptedBinaryOperator).build();

    Builder builder2 = new Builder();

    // Act and Assert
    assertThrows(
        SchemaException.class,
        () ->
            typeDefinition.merge(
                builder2.aggregateFunction(new AdaptedBinaryOperator<>()).build()));
  }

  /**
   * Test {@link TypeDefinition#merge(TypeDefinition)}.
   *
   * <ul>
   *   <li>Given {@link AdaptedBinaryOperator#AdaptedBinaryOperator()} BinaryOperator is {@link
   *       BinaryOperator}.
   * </ul>
   *
   * <p>Method under test: {@link TypeDefinition#merge(TypeDefinition)}
   */
  @Test
  @DisplayName(
      "Test merge(TypeDefinition); given AdaptedBinaryOperator() BinaryOperator is BinaryOperator")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TypeDefinition.merge(TypeDefinition)"})
  void testMerge_givenAdaptedBinaryOperatorBinaryOperatorIsBinaryOperator() {
    // Arrange
    AdaptedBinaryOperator<Object, Object> adaptedBinaryOperator = new AdaptedBinaryOperator<>();
    adaptedBinaryOperator.setBinaryOperator(mock(BinaryOperator.class));
    TypeDefinition typeDefinition = new Builder().aggregateFunction(adaptedBinaryOperator).build();

    Builder builder = new Builder();

    // Act and Assert
    assertThrows(
        SchemaException.class,
        () ->
            typeDefinition.merge(builder.aggregateFunction(new AdaptedBinaryOperator<>()).build()));
  }

  /**
   * Test {@link TypeDefinition#merge(TypeDefinition)}.
   *
   * <ul>
   *   <li>Given {@link AdaptedBinaryOperator#AdaptedBinaryOperator()} BinaryOperator is {@link
   *       BinaryOperator}.
   * </ul>
   *
   * <p>Method under test: {@link TypeDefinition#merge(TypeDefinition)}
   */
  @Test
  @DisplayName(
      "Test merge(TypeDefinition); given AdaptedBinaryOperator() BinaryOperator is BinaryOperator")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TypeDefinition.merge(TypeDefinition)"})
  void testMerge_givenAdaptedBinaryOperatorBinaryOperatorIsBinaryOperator2() {
    // Arrange
    AdaptedBinaryOperator<Object, Object> adaptedBinaryOperator = new AdaptedBinaryOperator<>();
    adaptedBinaryOperator.setBinaryOperator(mock(BinaryOperator.class));
    TypeDefinition typeDefinition = new Builder().aggregateFunction(adaptedBinaryOperator).build();

    AdaptedBinaryOperator<Object, Object> adaptedBinaryOperator2 = new AdaptedBinaryOperator<>();
    adaptedBinaryOperator2.setBinaryOperator(mock(BinaryOperator.class));

    // Act and Assert
    assertThrows(
        SchemaException.class,
        () ->
            typeDefinition.merge(new Builder().aggregateFunction(adaptedBinaryOperator2).build()));
  }

  /**
   * Test {@link TypeDefinition#merge(TypeDefinition)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Predicate}.
   * </ul>
   *
   * <p>Method under test: {@link TypeDefinition#merge(TypeDefinition)}
   */
  @Test
  @DisplayName("Test merge(TypeDefinition); given ArrayList() add Predicate")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TypeDefinition.merge(TypeDefinition)"})
  void testMerge_givenArrayListAddPredicate() {
    // Arrange
    TypeDefinition typeDefinition = new TypeDefinition();
    typeDefinition.setValidateFunctions(new ArrayList<>());

    ArrayList<Predicate> validateFunctions = new ArrayList<>();
    validateFunctions.add(mock(Predicate.class));

    TypeDefinition type = new TypeDefinition();
    type.setValidateFunctions(validateFunctions);

    // Act
    typeDefinition.merge(type);

    // Assert
    assertEquals(typeDefinition, type);
  }

  /**
   * Test {@link TypeDefinition#merge(TypeDefinition)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link TypeDefinition#TypeDefinition()} ValidateFunctions is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link TypeDefinition#merge(TypeDefinition)}
   */
  @Test
  @DisplayName(
      "Test merge(TypeDefinition); given ArrayList(); when TypeDefinition() ValidateFunctions is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TypeDefinition.merge(TypeDefinition)"})
  void testMerge_givenArrayList_whenTypeDefinitionValidateFunctionsIsArrayList() {
    // Arrange
    TypeDefinition typeDefinition = new TypeDefinition();

    TypeDefinition type = new TypeDefinition();
    type.setValidateFunctions(new ArrayList<>());

    // Act
    typeDefinition.merge(type);

    // Assert
    assertEquals(typeDefinition, type);
  }

  /**
   * Test {@link TypeDefinition#merge(TypeDefinition)}.
   *
   * <ul>
   *   <li>Given {@link BinaryOperator}.
   * </ul>
   *
   * <p>Method under test: {@link TypeDefinition#merge(TypeDefinition)}
   */
  @Test
  @DisplayName("Test merge(TypeDefinition); given BinaryOperator")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TypeDefinition.merge(TypeDefinition)"})
  void testMerge_givenBinaryOperator() {
    // Arrange
    Builder builder = new Builder();
    TypeDefinition typeDefinition =
        builder.aggregateFunction(new AdaptedBinaryOperator<>()).build();

    AdaptedBinaryOperator<Object, Object> adaptedBinaryOperator = new AdaptedBinaryOperator<>();
    adaptedBinaryOperator.setBinaryOperator(mock(BinaryOperator.class));

    // Act and Assert
    assertThrows(
        SchemaException.class,
        () -> typeDefinition.merge(new Builder().aggregateFunction(adaptedBinaryOperator).build()));
  }

  /**
   * Test {@link TypeDefinition#merge(TypeDefinition)}.
   *
   * <ul>
   *   <li>Given {@link Builder} (default constructor) aggregateFunction {@link BinaryOperator}
   *       build.
   * </ul>
   *
   * <p>Method under test: {@link TypeDefinition#merge(TypeDefinition)}
   */
  @Test
  @DisplayName(
      "Test merge(TypeDefinition); given Builder (default constructor) aggregateFunction BinaryOperator build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TypeDefinition.merge(TypeDefinition)"})
  void testMerge_givenBuilderAggregateFunctionBinaryOperatorBuild() {
    // Arrange
    TypeDefinition typeDefinition =
        new Builder().aggregateFunction(mock(BinaryOperator.class)).build();

    // Act and Assert
    assertThrows(
        SchemaException.class,
        () ->
            typeDefinition.merge(
                new Builder().aggregateFunction(mock(BinaryOperator.class)).build()));
  }

  /**
   * Test {@link TypeDefinition#merge(TypeDefinition)}.
   *
   * <ul>
   *   <li>Given {@link TypeDefinition#TypeDefinition()} Description is {@code The characteristics
   *       of someone or something}.
   * </ul>
   *
   * <p>Method under test: {@link TypeDefinition#merge(TypeDefinition)}
   */
  @Test
  @DisplayName(
      "Test merge(TypeDefinition); given TypeDefinition() Description is 'The characteristics of someone or something'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TypeDefinition.merge(TypeDefinition)"})
  void testMerge_givenTypeDefinitionDescriptionIsTheCharacteristicsOfSomeoneOrSomething() {
    // Arrange
    TypeDefinition typeDefinition = new TypeDefinition();
    typeDefinition.setDescription("The characteristics of someone or something");

    TypeDefinition type = new TypeDefinition();
    type.setDescription("The characteristics of someone or something");

    // Act
    typeDefinition.merge(type);

    // Assert that nothing has changed
    assertEquals(typeDefinition, type);
  }

  /**
   * Test {@link TypeDefinition#merge(TypeDefinition)}.
   *
   * <ul>
   *   <li>Given {@link TypeDefinition#TypeDefinition()}.
   *   <li>When {@link TypeDefinition#TypeDefinition()}.
   *   <li>Then {@link TypeDefinition#TypeDefinition()}.
   * </ul>
   *
   * <p>Method under test: {@link TypeDefinition#merge(TypeDefinition)}
   */
  @Test
  @DisplayName(
      "Test merge(TypeDefinition); given TypeDefinition(); when TypeDefinition(); then TypeDefinition()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TypeDefinition.merge(TypeDefinition)"})
  void testMerge_givenTypeDefinition_whenTypeDefinition_thenTypeDefinition() {
    // Arrange
    TypeDefinition typeDefinition = new TypeDefinition();
    TypeDefinition type = new TypeDefinition();

    // Act
    typeDefinition.merge(type);

    // Assert that nothing has changed
    assertEquals(typeDefinition, type);
  }

  /**
   * Test {@link TypeDefinition#merge(TypeDefinition)}.
   *
   * <ul>
   *   <li>Given {@code TypeDefinition}.
   *   <li>When {@code Object}.
   * </ul>
   *
   * <p>Method under test: {@link TypeDefinition#merge(TypeDefinition)}
   */
  @Test
  @DisplayName(
      "Test merge(TypeDefinition); given 'uk.gov.gchq.gaffer.store.schema.TypeDefinition'; when 'java.lang.Object'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TypeDefinition.merge(TypeDefinition)"})
  void testMerge_givenUkGovGchqGafferStoreSchemaTypeDefinition_whenJavaLangObject() {
    // Arrange
    Class<TypeDefinition> clazz = TypeDefinition.class;
    TypeDefinition typeDefinition = new TypeDefinition(clazz);
    Class<Object> clazz2 = Object.class;

    // Act and Assert
    assertThrows(SchemaException.class, () -> typeDefinition.merge(new TypeDefinition(clazz2)));
  }

  /**
   * Test {@link TypeDefinition#merge(TypeDefinition)}.
   *
   * <ul>
   *   <li>Then {@link Builder} (default constructor) aggregateFunction {@link
   *       AdaptedBinaryOperator#AdaptedBinaryOperator()} build.
   * </ul>
   *
   * <p>Method under test: {@link TypeDefinition#merge(TypeDefinition)}
   */
  @Test
  @DisplayName(
      "Test merge(TypeDefinition); then Builder (default constructor) aggregateFunction AdaptedBinaryOperator() build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TypeDefinition.merge(TypeDefinition)"})
  void testMerge_thenBuilderAggregateFunctionAdaptedBinaryOperatorBuild() {
    // Arrange
    Builder builder = new Builder();
    TypeDefinition typeDefinition =
        builder.aggregateFunction(new AdaptedBinaryOperator<>()).build();

    Builder builder2 = new Builder();
    TypeDefinition type = builder2.aggregateFunction(new AdaptedBinaryOperator<>()).build();

    // Act
    typeDefinition.merge(type);

    // Assert that nothing has changed
    assertEquals(typeDefinition, type);
  }

  /**
   * Test {@link TypeDefinition#merge(TypeDefinition)}.
   *
   * <ul>
   *   <li>When {@link Builder} (default constructor) aggregateFunction {@link BinaryOperator}
   *       build.
   * </ul>
   *
   * <p>Method under test: {@link TypeDefinition#merge(TypeDefinition)}
   */
  @Test
  @DisplayName(
      "Test merge(TypeDefinition); when Builder (default constructor) aggregateFunction BinaryOperator build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TypeDefinition.merge(TypeDefinition)"})
  void testMerge_whenBuilderAggregateFunctionBinaryOperatorBuild() {
    // Arrange
    Builder builder = new Builder();
    TypeDefinition typeDefinition =
        builder.aggregateFunction(new AdaptedBinaryOperator<>()).build();

    // Act and Assert
    assertThrows(
        SchemaException.class,
        () ->
            typeDefinition.merge(
                new Builder().aggregateFunction(mock(BinaryOperator.class)).build()));
  }

  /**
   * Test {@link TypeDefinition#merge(TypeDefinition)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then {@link TypeDefinition#TypeDefinition(Class)} with clazz is {@link Object}.
   * </ul>
   *
   * <p>Method under test: {@link TypeDefinition#merge(TypeDefinition)}
   */
  @Test
  @DisplayName(
      "Test merge(TypeDefinition); when 'java.lang.Object'; then TypeDefinition(Class) with clazz is Object")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TypeDefinition.merge(TypeDefinition)"})
  void testMerge_whenJavaLangObject_thenTypeDefinitionWithClazzIsObject() {
    // Arrange
    Class<Object> clazz = Object.class;
    TypeDefinition typeDefinition = new TypeDefinition(clazz);
    Class<Object> clazz2 = Object.class;
    TypeDefinition type = new TypeDefinition(clazz2);

    // Act
    typeDefinition.merge(type);

    // Assert that nothing has changed
    assertEquals(typeDefinition, type);
  }

  /**
   * Test {@link TypeDefinition#equals(Object)}, and {@link TypeDefinition#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TypeDefinition#equals(Object)}
   *   <li>{@link TypeDefinition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TypeDefinition.equals(Object)", "int TypeDefinition.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TypeDefinition typeDefinition =
        new Builder().aggregateFunction(mock(BinaryOperator.class)).build();

    // Act and Assert
    assertEquals(typeDefinition, typeDefinition);
    int expectedHashCodeResult = typeDefinition.hashCode();
    assertEquals(expectedHashCodeResult, typeDefinition.hashCode());
  }

  /**
   * Test {@link TypeDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TypeDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TypeDefinition.equals(Object)", "int TypeDefinition.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TypeDefinition typeDefinition =
        new Builder().aggregateFunction(mock(BinaryOperator.class)).build();

    // Act and Assert
    assertNotEquals(
        typeDefinition, new Builder().aggregateFunction(mock(BinaryOperator.class)).build());
  }

  /**
   * Test {@link TypeDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TypeDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TypeDefinition.equals(Object)", "int TypeDefinition.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Builder().aggregateFunction(mock(BinaryOperator.class)).build(), null);
  }

  /**
   * Test {@link TypeDefinition#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TypeDefinition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TypeDefinition.equals(Object)", "int TypeDefinition.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new Builder().aggregateFunction(mock(BinaryOperator.class)).build(),
        "Different type to TypeDefinition");
  }
}
