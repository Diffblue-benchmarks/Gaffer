package uk.gov.gchq.gaffer.data.element.function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import uk.gov.gchq.gaffer.data.element.Properties;
import uk.gov.gchq.gaffer.data.element.function.PropertiesFilter.Builder;
import uk.gov.gchq.koryphe.ValidationResult;
import uk.gov.gchq.koryphe.tuple.predicate.TupleAdaptedPredicate;

class PropertiesFilterDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PropertiesFilter Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(new Builder().build().getComponents().isEmpty());
  }

  /**
   * Test Builder {@link Builder#Builder()}.
   *
   * <p>Method under test: {@link Builder#Builder()}
   */
  @Test
  @DisplayName("Test Builder new Builder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Builder.<init>()"})
  void testBuilderNewBuilder() {
    // Arrange, Act and Assert
    assertTrue(new Builder().build().getComponents().isEmpty());
  }

  /**
   * Test {@link PropertiesFilter#test(Properties)} with {@code properties}.
   *
   * <p>Method under test: {@link PropertiesFilter#test(Properties)}
   */
  @Test
  @DisplayName("Test test(Properties) with 'properties'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PropertiesFilter.test(Properties)"})
  void testTestWithProperties() {
    // Arrange
    PropertiesFilter propertiesFilter = new PropertiesFilter();

    // Act and Assert
    assertTrue(propertiesFilter.test(new Properties()));
  }

  /**
   * Test {@link PropertiesFilter#testWithValidationResult(Properties)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       TupleAdaptedPredicate#TupleAdaptedPredicate()}.
   * </ul>
   *
   * <p>Method under test: {@link PropertiesFilter#testWithValidationResult(Properties)}
   */
  @Test
  @DisplayName(
      "Test testWithValidationResult(Properties); given ArrayList() add TupleAdaptedPredicate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult PropertiesFilter.testWithValidationResult(Properties)"})
  void testTestWithValidationResult_givenArrayListAddTupleAdaptedPredicate() {
    // Arrange
    ArrayList<TupleAdaptedPredicate<String, ?>> components = new ArrayList<>();
    components.add(new TupleAdaptedPredicate<>());

    PropertiesFilter propertiesFilter = new PropertiesFilter();
    propertiesFilter.setComponents(components);

    // Act
    ValidationResult actualTestWithValidationResultResult =
        propertiesFilter.testWithValidationResult(new Properties());

    // Assert
    assertEquals("Validation errors: \n", actualTestWithValidationResultResult.getErrorString());
    assertTrue(actualTestWithValidationResultResult.getErrors().isEmpty());
    assertTrue(actualTestWithValidationResultResult.isValid());
  }

  /**
   * Test {@link PropertiesFilter#testWithValidationResult(Properties)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       TupleAdaptedPredicate#TupleAdaptedPredicate()}.
   * </ul>
   *
   * <p>Method under test: {@link PropertiesFilter#testWithValidationResult(Properties)}
   */
  @Test
  @DisplayName(
      "Test testWithValidationResult(Properties); given ArrayList() add TupleAdaptedPredicate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult PropertiesFilter.testWithValidationResult(Properties)"})
  void testTestWithValidationResult_givenArrayListAddTupleAdaptedPredicate2() {
    // Arrange
    ArrayList<TupleAdaptedPredicate<String, ?>> components = new ArrayList<>();
    components.add(new TupleAdaptedPredicate<>());
    components.add(new TupleAdaptedPredicate<>());

    PropertiesFilter propertiesFilter = new PropertiesFilter();
    propertiesFilter.setComponents(components);

    // Act
    ValidationResult actualTestWithValidationResultResult =
        propertiesFilter.testWithValidationResult(new Properties());

    // Assert
    assertEquals("Validation errors: \n", actualTestWithValidationResultResult.getErrorString());
    assertTrue(actualTestWithValidationResultResult.getErrors().isEmpty());
    assertTrue(actualTestWithValidationResultResult.isValid());
  }

  /**
   * Test {@link PropertiesFilter#testWithValidationResult(Properties)}.
   *
   * <ul>
   *   <li>Given {@link Predicate} {@link Predicate#test(Object)} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PropertiesFilter#testWithValidationResult(Properties)}
   */
  @Test
  @DisplayName(
      "Test testWithValidationResult(Properties); given Predicate test(Object) return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult PropertiesFilter.testWithValidationResult(Properties)"})
  void testTestWithValidationResult_givenPredicateTestReturnTrue() {
    // Arrange
    Predicate<Object> predicate = mock(Predicate.class);
    when(predicate.test(Mockito.<Object>any())).thenReturn(true);
    String[] selection = new String[] {"Selection"};

    TupleAdaptedPredicate<String, ?> tupleAdaptedPredicate =
        new TupleAdaptedPredicate<>(predicate, selection);

    ArrayList<TupleAdaptedPredicate<String, ?>> components = new ArrayList<>();
    components.add(tupleAdaptedPredicate);

    PropertiesFilter propertiesFilter = new PropertiesFilter();
    propertiesFilter.setComponents(components);

    // Act
    ValidationResult actualTestWithValidationResultResult =
        propertiesFilter.testWithValidationResult(new Properties());

    // Assert
    verify(predicate).test(isNull());
    assertEquals("Validation errors: \n", actualTestWithValidationResultResult.getErrorString());
    assertTrue(actualTestWithValidationResultResult.getErrors().isEmpty());
    assertTrue(actualTestWithValidationResultResult.isValid());
  }

  /**
   * Test {@link PropertiesFilter#testWithValidationResult(Properties)}.
   *
   * <ul>
   *   <li>Given {@link PropertiesFilter} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link PropertiesFilter#testWithValidationResult(Properties)}
   */
  @Test
  @DisplayName(
      "Test testWithValidationResult(Properties); given PropertiesFilter (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ValidationResult PropertiesFilter.testWithValidationResult(Properties)"})
  void testTestWithValidationResult_givenPropertiesFilter() {
    // Arrange
    PropertiesFilter propertiesFilter = new PropertiesFilter();

    // Act
    ValidationResult actualTestWithValidationResultResult =
        propertiesFilter.testWithValidationResult(new Properties());

    // Assert
    assertEquals("Validation errors: \n", actualTestWithValidationResultResult.getErrorString());
    assertTrue(actualTestWithValidationResultResult.getErrors().isEmpty());
    assertTrue(actualTestWithValidationResultResult.isValid());
  }

  /**
   * Test {@link PropertiesFilter#getComponents()}.
   *
   * <p>Method under test: {@link PropertiesFilter#getComponents()}
   */
  @Test
  @DisplayName("Test getComponents()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List PropertiesFilter.getComponents()"})
  void testGetComponents() {
    // Arrange, Act and Assert
    assertTrue(new PropertiesFilter().getComponents().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PropertiesFilter#lock()}
   *   <li>{@link PropertiesFilter#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PropertiesFilter.lock()", "String PropertiesFilter.toString()"})
  void testGettersAndSetters() {
    // Arrange
    PropertiesFilter propertiesFilter = new Builder().build();

    // Act
    propertiesFilter.lock();

    // Assert
    assertEquals(
        "PropertiesFilter[propertiesTuple=PropertiesTuple[]]", propertiesFilter.toString());
  }

  /**
   * Test {@link PropertiesFilter#equals(Object)}, and {@link PropertiesFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PropertiesFilter#equals(Object)}
   *   <li>{@link PropertiesFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PropertiesFilter.equals(Object)", "int PropertiesFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PropertiesFilter propertiesFilter = new Builder().build();
    PropertiesFilter propertiesFilter2 = new Builder().build();

    // Act and Assert
    assertEquals(propertiesFilter, propertiesFilter2);
    assertEquals(propertiesFilter.hashCode(), propertiesFilter2.hashCode());
  }

  /**
   * Test {@link PropertiesFilter#equals(Object)}, and {@link PropertiesFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PropertiesFilter#equals(Object)}
   *   <li>{@link PropertiesFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PropertiesFilter.equals(Object)", "int PropertiesFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PropertiesFilter propertiesFilter = new Builder().build();

    // Act and Assert
    assertEquals(propertiesFilter, propertiesFilter);
    int expectedHashCodeResult = propertiesFilter.hashCode();
    assertEquals(expectedHashCodeResult, propertiesFilter.hashCode());
  }

  /**
   * Test {@link PropertiesFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PropertiesFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PropertiesFilter.equals(Object)", "int PropertiesFilter.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Builder().build(), null);
  }

  /**
   * Test {@link PropertiesFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PropertiesFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PropertiesFilter.equals(Object)", "int PropertiesFilter.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Builder().build(), "Different type to PropertiesFilter");
  }

  /**
   * Test new {@link PropertiesFilter} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link PropertiesFilter}
   */
  @Test
  @DisplayName("Test new PropertiesFilter (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PropertiesFilter.<init>()"})
  void testNewPropertiesFilter() {
    // Arrange, Act and Assert
    assertTrue(new PropertiesFilter().getComponents().isEmpty());
  }
}
