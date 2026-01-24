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

package uk.gov.gchq.gaffer.graph.hook.migrate;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.gchq.gaffer.data.element.function.ElementTransformer;
import uk.gov.gchq.gaffer.data.element.function.ElementTransformer.Builder;
import uk.gov.gchq.gaffer.graph.hook.migrate.MigrateElement.ElementType;
import uk.gov.gchq.koryphe.impl.function.SetValue;
import uk.gov.gchq.koryphe.tuple.function.TupleAdaptedFunction;

@ExtendWith(MockitoExtension.class)
class MigrateElementDiffblueTest {
  @Mock private ElementTransformer elementTransformer;

  @InjectMocks private MigrateElement migrateElement;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MigrateElement#MigrateElement()}
   *   <li>{@link MigrateElement#setElementType(ElementType)}
   *   <li>{@link MigrateElement#toString()}
   *   <li>{@link MigrateElement#getElementType()}
   *   <li>{@link MigrateElement#getNewGroup()}
   *   <li>{@link MigrateElement#getOldGroup()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MigrateElement.<init>()",
    "ElementType MigrateElement.getElementType()",
    "String MigrateElement.getNewGroup()",
    "String MigrateElement.getOldGroup()",
    "void MigrateElement.setElementType(ElementType)",
    "String MigrateElement.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    MigrateElement actualMigrateElement = new MigrateElement();
    actualMigrateElement.setElementType(ElementType.EDGE);
    String actualToStringResult = actualMigrateElement.toString();
    ElementType actualElementType = actualMigrateElement.getElementType();
    String actualNewGroup = actualMigrateElement.getNewGroup();

    // Assert
    assertEquals("MigrateElement[elementType=EDGE]", actualToStringResult);
    assertNull(actualNewGroup);
    assertNull(actualMigrateElement.getOldGroup());
    assertEquals(ElementType.EDGE, actualElementType);
  }

  /**
   * Test {@link MigrateElement#MigrateElement(ElementType, String, String, ElementTransformer,
   * ElementTransformer)}.
   *
   * <ul>
   *   <li>Given {@link ElementTransformer}.
   *   <li>Then return {@code New Group}.
   * </ul>
   *
   * <p>Method under test: {@link MigrateElement#MigrateElement(ElementType, String, String,
   * ElementTransformer, ElementTransformer)}
   */
  @Test
  @DisplayName(
      "Test new MigrateElement(ElementType, String, String, ElementTransformer, ElementTransformer); given ElementTransformer; then return 'New Group'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MigrateElement.<init>(ElementType, String, String, ElementTransformer, ElementTransformer)"
  })
  void testNewMigrateElement_givenElementTransformer_thenReturnNewGroup() {
    // Arrange and Act
    MigrateElement actualMigrateElement =
        new MigrateElement(
            ElementType.EDGE, "New Group", "New Group", elementTransformer, elementTransformer);

    // Assert
    assertEquals("New Group", actualMigrateElement.getNewGroup());
    assertEquals("New Group", actualMigrateElement.getOldGroup());
    assertEquals(ElementType.EDGE, actualMigrateElement.getElementType());
    assertTrue(actualMigrateElement.getToNew().isEmpty());
    assertTrue(actualMigrateElement.getToOld().isEmpty());
    ElementTransformer toNewTransform = actualMigrateElement.getToNewTransform();
    assertTrue(toNewTransform.getComponents().isEmpty());
    assertEquals(toNewTransform, actualMigrateElement.getToOldTransform());
  }

  /**
   * Test {@link MigrateElement#MigrateElement(ElementType, String, String, ElementTransformer,
   * ElementTransformer)}.
   *
   * <ul>
   *   <li>Then return ToOldTransform Components Empty.
   * </ul>
   *
   * <p>Method under test: {@link MigrateElement#MigrateElement(ElementType, String, String,
   * ElementTransformer, ElementTransformer)}
   */
  @Test
  @DisplayName(
      "Test new MigrateElement(ElementType, String, String, ElementTransformer, ElementTransformer); then return ToOldTransform Components Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MigrateElement.<init>(ElementType, String, String, ElementTransformer, ElementTransformer)"
  })
  void testNewMigrateElement_thenReturnToOldTransformComponentsEmpty() {
    // Arrange
    ElementTransformer toNewTransform = new ElementTransformer();

    // Act
    MigrateElement actualMigrateElement =
        new MigrateElement(
            ElementType.EDGE, "New Group", "New Group", toNewTransform, new ElementTransformer());

    // Assert
    assertEquals("New Group", actualMigrateElement.getOldGroup());
    assertTrue(actualMigrateElement.getToNewTransform().getComponents().isEmpty());
    assertTrue(actualMigrateElement.getToOldTransform().getComponents().isEmpty());
  }

  /**
   * Test {@link MigrateElement#MigrateElement(ElementType, String, String, ElementTransformer,
   * ElementTransformer)}.
   *
   * <ul>
   *   <li>When {@code Old Group}.
   *   <li>Then return ToNewTransform Components size is one.
   * </ul>
   *
   * <p>Method under test: {@link MigrateElement#MigrateElement(ElementType, String, String,
   * ElementTransformer, ElementTransformer)}
   */
  @Test
  @DisplayName(
      "Test new MigrateElement(ElementType, String, String, ElementTransformer, ElementTransformer); when 'Old Group'; then return ToNewTransform Components size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void MigrateElement.<init>(ElementType, String, String, ElementTransformer, ElementTransformer)"
  })
  void testNewMigrateElement_whenOldGroup_thenReturnToNewTransformComponentsSizeIsOne() {
    // Arrange
    ElementTransformer toNewTransform = new ElementTransformer();

    // Act
    MigrateElement actualMigrateElement =
        new MigrateElement(
            ElementType.EDGE, "Old Group", "New Group", toNewTransform, new ElementTransformer());

    // Assert
    List<TupleAdaptedFunction<String, ?, ?>> components =
        actualMigrateElement.getToNewTransform().getComponents();
    assertEquals(1, components.size());
    TupleAdaptedFunction<String, ?, ?> getResult = components.get(0);
    assertTrue(getResult.getFunction() instanceof SetValue);
    List<TupleAdaptedFunction<String, ?, ?>> components2 =
        actualMigrateElement.getToOldTransform().getComponents();
    assertEquals(1, components2.size());
    TupleAdaptedFunction<String, ?, ?> getResult2 = components2.get(0);
    assertTrue(getResult2.getFunction() instanceof SetValue);
    assertEquals("Old Group", actualMigrateElement.getOldGroup());
    assertEquals(1, getResult.getProjection().length);
    assertEquals(1, getResult2.getProjection().length);
    assertEquals(1, getResult.getSelection().length);
    assertEquals(1, getResult2.getSelection().length);
  }

  /**
   * Test {@link MigrateElement#setOldGroup(String)}.
   *
   * <ul>
   *   <li>Then {@link MigrateElement#MigrateElement()} OldGroup is {@code GROUP}.
   * </ul>
   *
   * <p>Method under test: {@link MigrateElement#setOldGroup(String)}
   */
  @Test
  @DisplayName("Test setOldGroup(String); then MigrateElement() OldGroup is 'GROUP'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MigrateElement.setOldGroup(String)"})
  void testSetOldGroup_thenMigrateElementOldGroupIsGroup() {
    // Arrange
    MigrateElement migrateElement = new MigrateElement();
    migrateElement.setNewGroup("GROUP");

    // Act
    migrateElement.setOldGroup("GROUP");

    // Assert
    assertEquals("GROUP", migrateElement.getOldGroup());
    assertTrue(migrateElement.getToOldTransform().getComponents().isEmpty());
  }

  /**
   * Test {@link MigrateElement#setOldGroup(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link MigrateElement#MigrateElement()} ToOldTransform Components Empty.
   * </ul>
   *
   * <p>Method under test: {@link MigrateElement#setOldGroup(String)}
   */
  @Test
  @DisplayName(
      "Test setOldGroup(String); when 'null'; then MigrateElement() ToOldTransform Components Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MigrateElement.setOldGroup(String)"})
  void testSetOldGroup_whenNull_thenMigrateElementToOldTransformComponentsEmpty() {
    // Arrange
    MigrateElement migrateElement = new MigrateElement();

    // Act
    migrateElement.setOldGroup(null);

    // Assert that nothing has changed
    assertTrue(migrateElement.getToOldTransform().getComponents().isEmpty());
  }

  /**
   * Test {@link MigrateElement#setOldGroup(String)}.
   *
   * <ul>
   *   <li>When {@code Old Group}.
   *   <li>Then {@link MigrateElement#MigrateElement()} ToOldTransform Components size is one.
   * </ul>
   *
   * <p>Method under test: {@link MigrateElement#setOldGroup(String)}
   */
  @Test
  @DisplayName(
      "Test setOldGroup(String); when 'Old Group'; then MigrateElement() ToOldTransform Components size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MigrateElement.setOldGroup(String)"})
  void testSetOldGroup_whenOldGroup_thenMigrateElementToOldTransformComponentsSizeIsOne() {
    // Arrange
    MigrateElement migrateElement = new MigrateElement();

    // Act
    migrateElement.setOldGroup("Old Group");

    // Assert
    List<TupleAdaptedFunction<String, ?, ?>> components =
        migrateElement.getToOldTransform().getComponents();
    assertEquals(1, components.size());
    TupleAdaptedFunction<String, ?, ?> getResult = components.get(0);
    Function<?, ?> function = getResult.getFunction();
    assertTrue(function instanceof SetValue);
    assertEquals("Old Group", migrateElement.getOldGroup());
    assertEquals("Old Group", ((SetValue) function).getValue());
    assertArrayEquals(new String[] {"GROUP"}, getResult.getInputAdapter().getSelection());
    assertArrayEquals(new String[] {"GROUP"}, getResult.getOutputAdapter().getProjection());
    assertArrayEquals(new String[] {"GROUP"}, getResult.getProjection());
    assertArrayEquals(new String[] {"GROUP"}, getResult.getSelection());
  }

  /**
   * Test {@link MigrateElement#setNewGroup(String)}.
   *
   * <ul>
   *   <li>Then {@link MigrateElement#MigrateElement()} NewGroup is {@code GROUP}.
   * </ul>
   *
   * <p>Method under test: {@link MigrateElement#setNewGroup(String)}
   */
  @Test
  @DisplayName("Test setNewGroup(String); then MigrateElement() NewGroup is 'GROUP'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MigrateElement.setNewGroup(String)"})
  void testSetNewGroup_thenMigrateElementNewGroupIsGroup() {
    // Arrange
    MigrateElement migrateElement = new MigrateElement();
    migrateElement.setOldGroup("GROUP");

    // Act
    migrateElement.setNewGroup("GROUP");

    // Assert
    assertEquals("GROUP", migrateElement.getNewGroup());
    assertTrue(migrateElement.getToNewTransform().getComponents().isEmpty());
  }

  /**
   * Test {@link MigrateElement#setNewGroup(String)}.
   *
   * <ul>
   *   <li>When {@code New Group}.
   *   <li>Then {@link MigrateElement#MigrateElement()} ToNewTransform Components size is one.
   * </ul>
   *
   * <p>Method under test: {@link MigrateElement#setNewGroup(String)}
   */
  @Test
  @DisplayName(
      "Test setNewGroup(String); when 'New Group'; then MigrateElement() ToNewTransform Components size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MigrateElement.setNewGroup(String)"})
  void testSetNewGroup_whenNewGroup_thenMigrateElementToNewTransformComponentsSizeIsOne() {
    // Arrange
    MigrateElement migrateElement = new MigrateElement();

    // Act
    migrateElement.setNewGroup("New Group");

    // Assert
    List<TupleAdaptedFunction<String, ?, ?>> components =
        migrateElement.getToNewTransform().getComponents();
    assertEquals(1, components.size());
    TupleAdaptedFunction<String, ?, ?> getResult = components.get(0);
    Function<?, ?> function = getResult.getFunction();
    assertTrue(function instanceof SetValue);
    assertEquals("New Group", migrateElement.getNewGroup());
    assertEquals("New Group", ((SetValue) function).getValue());
    assertArrayEquals(new String[] {"GROUP"}, getResult.getInputAdapter().getSelection());
    assertArrayEquals(new String[] {"GROUP"}, getResult.getOutputAdapter().getProjection());
    assertArrayEquals(new String[] {"GROUP"}, getResult.getProjection());
    assertArrayEquals(new String[] {"GROUP"}, getResult.getSelection());
  }

  /**
   * Test {@link MigrateElement#setNewGroup(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then {@link MigrateElement#MigrateElement()} ToNewTransform Components Empty.
   * </ul>
   *
   * <p>Method under test: {@link MigrateElement#setNewGroup(String)}
   */
  @Test
  @DisplayName(
      "Test setNewGroup(String); when 'null'; then MigrateElement() ToNewTransform Components Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MigrateElement.setNewGroup(String)"})
  void testSetNewGroup_whenNull_thenMigrateElementToNewTransformComponentsEmpty() {
    // Arrange
    MigrateElement migrateElement = new MigrateElement();

    // Act
    migrateElement.setNewGroup(null);

    // Assert that nothing has changed
    assertTrue(migrateElement.getToNewTransform().getComponents().isEmpty());
  }

  /**
   * Test {@link MigrateElement#getToNewTransform()}.
   *
   * <ul>
   *   <li>Given {@link MigrateElement#MigrateElement()}.
   *   <li>Then return Components Empty.
   * </ul>
   *
   * <p>Method under test: {@link MigrateElement#getToNewTransform()}
   */
  @Test
  @DisplayName("Test getToNewTransform(); given MigrateElement(); then return Components Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementTransformer MigrateElement.getToNewTransform()"})
  void testGetToNewTransform_givenMigrateElement_thenReturnComponentsEmpty() {
    // Arrange, Act and Assert
    assertTrue(new MigrateElement().getToNewTransform().getComponents().isEmpty());
  }

  /**
   * Test {@link MigrateElement#getToNewTransform()}.
   *
   * <ul>
   *   <li>Then return Components is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link MigrateElement#getToNewTransform()}
   */
  @Test
  @DisplayName("Test getToNewTransform(); then return Components is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementTransformer MigrateElement.getToNewTransform()"})
  void testGetToNewTransform_thenReturnComponentsIsArrayList() {
    // Arrange
    ArrayList<TupleAdaptedFunction<String, ?, ?>> tupleAdaptedFunctionList = new ArrayList<>();
    tupleAdaptedFunctionList.add(new TupleAdaptedFunction<>());
    org.mockito.Mockito.<List<TupleAdaptedFunction<String, ?, ?>>>when(
            elementTransformer.getComponents())
        .thenReturn(tupleAdaptedFunctionList);

    // Act
    ElementTransformer actualToNewTransform = migrateElement.getToNewTransform();

    // Assert
    verify(elementTransformer, atLeast(1)).getComponents();
    assertEquals(tupleAdaptedFunctionList, actualToNewTransform.getComponents());
  }

  /**
   * Test {@link MigrateElement#getToNewTransform()}.
   *
   * <ul>
   *   <li>Then return Components size is one.
   * </ul>
   *
   * <p>Method under test: {@link MigrateElement#getToNewTransform()}
   */
  @Test
  @DisplayName("Test getToNewTransform(); then return Components size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementTransformer MigrateElement.getToNewTransform()"})
  void testGetToNewTransform_thenReturnComponentsSizeIsOne() {
    // Arrange
    ElementTransformer toNewTransform = new Builder().build();
    ElementTransformer toOldTransform = new Builder().build();

    MigrateElement migrateElement =
        new MigrateElement(
            ElementType.EDGE, "Old Group", "New Group", toNewTransform, toOldTransform);

    // Act and Assert
    List<TupleAdaptedFunction<String, ?, ?>> components =
        migrateElement.getToNewTransform().getComponents();
    assertEquals(1, components.size());
    TupleAdaptedFunction<String, ?, ?> getResult = components.get(0);
    Function<?, ?> function = getResult.getFunction();
    assertTrue(function instanceof SetValue);
    assertEquals("New Group", ((SetValue) function).getValue());
    assertArrayEquals(new String[] {"GROUP"}, getResult.getInputAdapter().getSelection());
    assertArrayEquals(new String[] {"GROUP"}, getResult.getOutputAdapter().getProjection());
    assertArrayEquals(new String[] {"GROUP"}, getResult.getProjection());
    assertArrayEquals(new String[] {"GROUP"}, getResult.getSelection());
  }

  /**
   * Test {@link MigrateElement#getToOldTransform()}.
   *
   * <ul>
   *   <li>Given {@link MigrateElement#MigrateElement()}.
   *   <li>Then return Components Empty.
   * </ul>
   *
   * <p>Method under test: {@link MigrateElement#getToOldTransform()}
   */
  @Test
  @DisplayName("Test getToOldTransform(); given MigrateElement(); then return Components Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementTransformer MigrateElement.getToOldTransform()"})
  void testGetToOldTransform_givenMigrateElement_thenReturnComponentsEmpty() {
    // Arrange, Act and Assert
    assertTrue(new MigrateElement().getToOldTransform().getComponents().isEmpty());
  }

  /**
   * Test {@link MigrateElement#getToOldTransform()}.
   *
   * <ul>
   *   <li>Then return Components is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link MigrateElement#getToOldTransform()}
   */
  @Test
  @DisplayName("Test getToOldTransform(); then return Components is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementTransformer MigrateElement.getToOldTransform()"})
  void testGetToOldTransform_thenReturnComponentsIsArrayList() {
    // Arrange
    ArrayList<TupleAdaptedFunction<String, ?, ?>> tupleAdaptedFunctionList = new ArrayList<>();
    tupleAdaptedFunctionList.add(new TupleAdaptedFunction<>());
    org.mockito.Mockito.<List<TupleAdaptedFunction<String, ?, ?>>>when(
            elementTransformer.getComponents())
        .thenReturn(tupleAdaptedFunctionList);

    // Act
    ElementTransformer actualToOldTransform = migrateElement.getToOldTransform();

    // Assert
    verify(elementTransformer, atLeast(1)).getComponents();
    assertEquals(tupleAdaptedFunctionList, actualToOldTransform.getComponents());
  }

  /**
   * Test {@link MigrateElement#getToOldTransform()}.
   *
   * <ul>
   *   <li>Then return Components size is one.
   * </ul>
   *
   * <p>Method under test: {@link MigrateElement#getToOldTransform()}
   */
  @Test
  @DisplayName("Test getToOldTransform(); then return Components size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementTransformer MigrateElement.getToOldTransform()"})
  void testGetToOldTransform_thenReturnComponentsSizeIsOne() {
    // Arrange
    ElementTransformer toNewTransform = new Builder().build();
    ElementTransformer toOldTransform = new Builder().build();

    MigrateElement migrateElement =
        new MigrateElement(
            ElementType.EDGE, "Old Group", "New Group", toNewTransform, toOldTransform);

    // Act and Assert
    List<TupleAdaptedFunction<String, ?, ?>> components =
        migrateElement.getToOldTransform().getComponents();
    assertEquals(1, components.size());
    TupleAdaptedFunction<String, ?, ?> getResult = components.get(0);
    Function<?, ?> function = getResult.getFunction();
    assertTrue(function instanceof SetValue);
    assertEquals("Old Group", ((SetValue) function).getValue());
    assertArrayEquals(new String[] {"GROUP"}, getResult.getInputAdapter().getSelection());
    assertArrayEquals(new String[] {"GROUP"}, getResult.getOutputAdapter().getProjection());
    assertArrayEquals(new String[] {"GROUP"}, getResult.getProjection());
    assertArrayEquals(new String[] {"GROUP"}, getResult.getSelection());
  }

  /**
   * Test {@link MigrateElement#getToNew()}.
   *
   * <p>Method under test: {@link MigrateElement#getToNew()}
   */
  @Test
  @DisplayName("Test getToNew()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MigrateElement.getToNew()"})
  void testGetToNew() {
    // Arrange
    MigrateElement migrateElement = new MigrateElement();
    migrateElement.setToNew(new ArrayList<>());

    // Act and Assert
    assertTrue(migrateElement.getToNew().isEmpty());
  }

  /**
   * Test {@link MigrateElement#setToNew(List)}.
   *
   * <p>Method under test: {@link MigrateElement#setToNew(List)}
   */
  @Test
  @DisplayName("Test setToNew(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MigrateElement.setToNew(List)"})
  void testSetToNew() {
    // Arrange
    ElementTransformer toNewTransform = new ElementTransformer();
    MigrateElement migrateElement =
        new MigrateElement(
            ElementType.EDGE, "Old Group", "New Group", toNewTransform, new ElementTransformer());

    // Act
    migrateElement.setToNew(new ArrayList<>());

    // Assert that nothing has changed
    assertEquals(1, migrateElement.getToNewTransform().getComponents().size());
    assertTrue(migrateElement.getToNew().isEmpty());
  }

  /**
   * Test {@link MigrateElement#setToNew(List)}.
   *
   * <p>Method under test: {@link MigrateElement#setToNew(List)}
   */
  @Test
  @DisplayName("Test setToNew(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MigrateElement.setToNew(List)"})
  void testSetToNew2() {
    // Arrange
    ElementTransformer toNewTransform = new ElementTransformer();
    MigrateElement migrateElement =
        new MigrateElement(
            ElementType.EDGE, "Old Group", "Old Group", toNewTransform, new ElementTransformer());

    // Act
    migrateElement.setToNew(new ArrayList<>());

    // Assert that nothing has changed
    assertTrue(migrateElement.getToNew().isEmpty());
    assertTrue(migrateElement.getToNewTransform().getComponents().isEmpty());
  }

  /**
   * Test {@link MigrateElement#setToNew(List)}.
   *
   * <ul>
   *   <li>Given {@link MigrateElement#MigrateElement()}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link MigrateElement#MigrateElement()} ToNew Empty.
   * </ul>
   *
   * <p>Method under test: {@link MigrateElement#setToNew(List)}
   */
  @Test
  @DisplayName(
      "Test setToNew(List); given MigrateElement(); when ArrayList(); then MigrateElement() ToNew Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MigrateElement.setToNew(List)"})
  void testSetToNew_givenMigrateElement_whenArrayList_thenMigrateElementToNewEmpty() {
    // Arrange
    MigrateElement migrateElement = new MigrateElement();

    // Act
    migrateElement.setToNew(new ArrayList<>());

    // Assert
    assertTrue(migrateElement.getToNew().isEmpty());
    assertTrue(migrateElement.getToNewTransform().getComponents().isEmpty());
  }

  /**
   * Test {@link MigrateElement#setToNew(List)}.
   *
   * <ul>
   *   <li>Given {@link TupleAdaptedFunction#TupleAdaptedFunction()}.
   *   <li>Then {@link MigrateElement#MigrateElement()} ToNew size is one.
   * </ul>
   *
   * <p>Method under test: {@link MigrateElement#setToNew(List)}
   */
  @Test
  @DisplayName(
      "Test setToNew(List); given TupleAdaptedFunction(); then MigrateElement() ToNew size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MigrateElement.setToNew(List)"})
  void testSetToNew_givenTupleAdaptedFunction_thenMigrateElementToNewSizeIsOne() {
    // Arrange
    MigrateElement migrateElement = new MigrateElement();

    ArrayList<TupleAdaptedFunction<String, ?, ?>> toNewFunctions = new ArrayList<>();
    TupleAdaptedFunction<String, ?, ?> tupleAdaptedFunction = new TupleAdaptedFunction<>();
    toNewFunctions.add(tupleAdaptedFunction);

    // Act
    migrateElement.setToNew(toNewFunctions);

    // Assert
    List<TupleAdaptedFunction<String, ?, ?>> toNew = migrateElement.getToNew();
    assertEquals(1, toNew.size());
    List<TupleAdaptedFunction<String, ?, ?>> components =
        migrateElement.getToNewTransform().getComponents();
    assertEquals(1, components.size());
    assertSame(tupleAdaptedFunction, toNew.get(0));
    assertSame(tupleAdaptedFunction, components.get(0));
  }

  /**
   * Test {@link MigrateElement#setToNew(List)}.
   *
   * <ul>
   *   <li>Given {@link TupleAdaptedFunction#TupleAdaptedFunction()}.
   *   <li>Then {@link MigrateElement#MigrateElement()} ToNew size is two.
   * </ul>
   *
   * <p>Method under test: {@link MigrateElement#setToNew(List)}
   */
  @Test
  @DisplayName(
      "Test setToNew(List); given TupleAdaptedFunction(); then MigrateElement() ToNew size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MigrateElement.setToNew(List)"})
  void testSetToNew_givenTupleAdaptedFunction_thenMigrateElementToNewSizeIsTwo() {
    // Arrange
    MigrateElement migrateElement = new MigrateElement();

    ArrayList<TupleAdaptedFunction<String, ?, ?>> toNewFunctions = new ArrayList<>();
    toNewFunctions.add(new TupleAdaptedFunction<>());
    TupleAdaptedFunction<String, ?, ?> tupleAdaptedFunction = new TupleAdaptedFunction<>();
    toNewFunctions.add(tupleAdaptedFunction);

    // Act
    migrateElement.setToNew(toNewFunctions);

    // Assert
    List<TupleAdaptedFunction<String, ?, ?>> toNew = migrateElement.getToNew();
    assertEquals(2, toNew.size());
    List<TupleAdaptedFunction<String, ?, ?>> components =
        migrateElement.getToNewTransform().getComponents();
    assertEquals(2, components.size());
    assertSame(tupleAdaptedFunction, toNew.get(1));
    assertSame(tupleAdaptedFunction, components.get(1));
  }

  /**
   * Test {@link MigrateElement#setToNew(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MigrateElement#setToNew(List)}
   */
  @Test
  @DisplayName("Test setToNew(List); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MigrateElement.setToNew(List)"})
  void testSetToNew_whenNull() {
    // Arrange
    ElementTransformer toNewTransform = new ElementTransformer();
    MigrateElement migrateElement =
        new MigrateElement(
            ElementType.EDGE, "Old Group", "New Group", toNewTransform, new ElementTransformer());

    // Act
    migrateElement.setToNew(null);

    // Assert that nothing has changed
    assertEquals(1, migrateElement.getToNewTransform().getComponents().size());
    assertTrue(migrateElement.getToNew().isEmpty());
  }

  /**
   * Test {@link MigrateElement#getToOld()}.
   *
   * <p>Method under test: {@link MigrateElement#getToOld()}
   */
  @Test
  @DisplayName("Test getToOld()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MigrateElement.getToOld()"})
  void testGetToOld() {
    // Arrange
    MigrateElement migrateElement = new MigrateElement();
    migrateElement.setToOld(new ArrayList<>());

    // Act and Assert
    assertTrue(migrateElement.getToOld().isEmpty());
  }

  /**
   * Test {@link MigrateElement#setToOld(List)}.
   *
   * <p>Method under test: {@link MigrateElement#setToOld(List)}
   */
  @Test
  @DisplayName("Test setToOld(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MigrateElement.setToOld(List)"})
  void testSetToOld() {
    // Arrange
    ElementTransformer toNewTransform = new ElementTransformer();

    MigrateElement migrateElement =
        new MigrateElement(
            ElementType.EDGE, "Old Group", "New Group", toNewTransform, new ElementTransformer());
    migrateElement.setOldGroup("foo");

    // Act
    migrateElement.setToOld(new ArrayList<>());

    // Assert that nothing has changed
    assertEquals(1, migrateElement.getToOldTransform().getComponents().size());
    assertTrue(migrateElement.getToOld().isEmpty());
  }

  /**
   * Test {@link MigrateElement#setToOld(List)}.
   *
   * <p>Method under test: {@link MigrateElement#setToOld(List)}
   */
  @Test
  @DisplayName("Test setToOld(List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MigrateElement.setToOld(List)"})
  void testSetToOld2() {
    // Arrange
    ElementTransformer toNewTransform = new ElementTransformer();

    MigrateElement migrateElement =
        new MigrateElement(
            ElementType.EDGE, "Old Group", "foo", toNewTransform, new ElementTransformer());
    migrateElement.setOldGroup("foo");

    // Act
    migrateElement.setToOld(new ArrayList<>());

    // Assert that nothing has changed
    assertEquals(1, migrateElement.getToOldTransform().getComponents().size());
    assertTrue(migrateElement.getToOld().isEmpty());
  }

  /**
   * Test {@link MigrateElement#setToOld(List)}.
   *
   * <ul>
   *   <li>Given {@link MigrateElement#MigrateElement()}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then {@link MigrateElement#MigrateElement()} ToOld Empty.
   * </ul>
   *
   * <p>Method under test: {@link MigrateElement#setToOld(List)}
   */
  @Test
  @DisplayName(
      "Test setToOld(List); given MigrateElement(); when ArrayList(); then MigrateElement() ToOld Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MigrateElement.setToOld(List)"})
  void testSetToOld_givenMigrateElement_whenArrayList_thenMigrateElementToOldEmpty() {
    // Arrange
    MigrateElement migrateElement = new MigrateElement();

    // Act
    migrateElement.setToOld(new ArrayList<>());

    // Assert
    assertTrue(migrateElement.getToOld().isEmpty());
  }

  /**
   * Test {@link MigrateElement#setToOld(List)}.
   *
   * <ul>
   *   <li>Given {@link TupleAdaptedFunction#TupleAdaptedFunction()}.
   *   <li>Then {@link MigrateElement#MigrateElement()} ToOld size is one.
   * </ul>
   *
   * <p>Method under test: {@link MigrateElement#setToOld(List)}
   */
  @Test
  @DisplayName(
      "Test setToOld(List); given TupleAdaptedFunction(); then MigrateElement() ToOld size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MigrateElement.setToOld(List)"})
  void testSetToOld_givenTupleAdaptedFunction_thenMigrateElementToOldSizeIsOne() {
    // Arrange
    MigrateElement migrateElement = new MigrateElement();

    ArrayList<TupleAdaptedFunction<String, ?, ?>> toOldFunctions = new ArrayList<>();
    TupleAdaptedFunction<String, ?, ?> tupleAdaptedFunction = new TupleAdaptedFunction<>();
    toOldFunctions.add(tupleAdaptedFunction);

    // Act
    migrateElement.setToOld(toOldFunctions);

    // Assert
    List<TupleAdaptedFunction<String, ?, ?>> toOld = migrateElement.getToOld();
    assertEquals(1, toOld.size());
    List<TupleAdaptedFunction<String, ?, ?>> components =
        migrateElement.getToOldTransform().getComponents();
    assertEquals(1, components.size());
    assertSame(tupleAdaptedFunction, toOld.get(0));
    assertSame(tupleAdaptedFunction, components.get(0));
  }

  /**
   * Test {@link MigrateElement#setToOld(List)}.
   *
   * <ul>
   *   <li>Given {@link TupleAdaptedFunction#TupleAdaptedFunction()}.
   *   <li>Then {@link MigrateElement#MigrateElement()} ToOld size is two.
   * </ul>
   *
   * <p>Method under test: {@link MigrateElement#setToOld(List)}
   */
  @Test
  @DisplayName(
      "Test setToOld(List); given TupleAdaptedFunction(); then MigrateElement() ToOld size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MigrateElement.setToOld(List)"})
  void testSetToOld_givenTupleAdaptedFunction_thenMigrateElementToOldSizeIsTwo() {
    // Arrange
    MigrateElement migrateElement = new MigrateElement();

    ArrayList<TupleAdaptedFunction<String, ?, ?>> toOldFunctions = new ArrayList<>();
    toOldFunctions.add(new TupleAdaptedFunction<>());
    TupleAdaptedFunction<String, ?, ?> tupleAdaptedFunction = new TupleAdaptedFunction<>();
    toOldFunctions.add(tupleAdaptedFunction);

    // Act
    migrateElement.setToOld(toOldFunctions);

    // Assert
    List<TupleAdaptedFunction<String, ?, ?>> toOld = migrateElement.getToOld();
    assertEquals(2, toOld.size());
    List<TupleAdaptedFunction<String, ?, ?>> components =
        migrateElement.getToOldTransform().getComponents();
    assertEquals(2, components.size());
    assertSame(tupleAdaptedFunction, toOld.get(1));
    assertSame(tupleAdaptedFunction, components.get(1));
  }

  /**
   * Test {@link MigrateElement#setToOld(List)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link MigrateElement#setToOld(List)}
   */
  @Test
  @DisplayName("Test setToOld(List); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MigrateElement.setToOld(List)"})
  void testSetToOld_whenNull() {
    // Arrange
    ElementTransformer toNewTransform = new ElementTransformer();

    MigrateElement migrateElement =
        new MigrateElement(
            ElementType.EDGE, "Old Group", "New Group", toNewTransform, new ElementTransformer());
    migrateElement.setOldGroup("foo");

    // Act
    migrateElement.setToOld(null);

    // Assert that nothing has changed
    assertEquals(1, migrateElement.getToOldTransform().getComponents().size());
    assertTrue(migrateElement.getToOld().isEmpty());
  }

  /**
   * Test {@link MigrateElement#equals(Object)}, and {@link MigrateElement#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MigrateElement#equals(Object)}
   *   <li>{@link MigrateElement#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MigrateElement.equals(Object)", "int MigrateElement.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MigrateElement migrateElement = new MigrateElement();

    // Act and Assert
    assertEquals(migrateElement, migrateElement);
    int expectedHashCodeResult = migrateElement.hashCode();
    assertEquals(expectedHashCodeResult, migrateElement.hashCode());
  }

  /**
   * Test {@link MigrateElement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MigrateElement#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MigrateElement.equals(Object)", "int MigrateElement.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MigrateElement migrateElement = new MigrateElement();

    // Act and Assert
    assertNotEquals(migrateElement, new MigrateElement());
  }

  /**
   * Test {@link MigrateElement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MigrateElement#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MigrateElement.equals(Object)", "int MigrateElement.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MigrateElement migrateElement = new MigrateElement();

    MigrateElement migrateElement2 = new MigrateElement();
    migrateElement2.setOldGroup("Old Group");

    // Act and Assert
    assertNotEquals(migrateElement, migrateElement2);
  }

  /**
   * Test {@link MigrateElement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MigrateElement#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MigrateElement.equals(Object)", "int MigrateElement.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MigrateElement migrateElement = new MigrateElement();

    MigrateElement migrateElement2 = new MigrateElement();
    migrateElement2.setNewGroup("New Group");

    // Act and Assert
    assertNotEquals(migrateElement, migrateElement2);
  }

  /**
   * Test {@link MigrateElement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MigrateElement#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MigrateElement.equals(Object)", "int MigrateElement.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MigrateElement migrateElement = new MigrateElement();
    ElementTransformer toNewTransform = new Builder().build();
    ElementTransformer toOldTransform = new Builder().build();

    // Act and Assert
    assertNotEquals(
        migrateElement,
        new MigrateElement(
            ElementType.EDGE, "Old Group", "New Group", toNewTransform, toOldTransform));
  }

  /**
   * Test {@link MigrateElement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MigrateElement#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MigrateElement.equals(Object)", "int MigrateElement.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MigrateElement(), null);
  }

  /**
   * Test {@link MigrateElement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link MigrateElement#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MigrateElement.equals(Object)", "int MigrateElement.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MigrateElement(), "Different type to MigrateElement");
  }
}
