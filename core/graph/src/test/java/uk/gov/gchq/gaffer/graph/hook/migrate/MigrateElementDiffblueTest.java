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

package uk.gov.gchq.gaffer.graph.hook.migrate;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.element.Edge;
import uk.gov.gchq.gaffer.data.element.ElementValueLoader;
import uk.gov.gchq.gaffer.data.element.LazyEdge;
import uk.gov.gchq.gaffer.data.element.function.ElementTransformer;
import uk.gov.gchq.koryphe.impl.function.SetValue;
import uk.gov.gchq.koryphe.tuple.function.TupleAdaptedFunction;

class MigrateElementDiffblueTest {
  /**
   * Method under test: {@link MigrateElement#setOldGroup(String)}
   */
  @Test
  void testSetOldGroup() {
    // Arrange
    MigrateElement migrateElement = new MigrateElement();

    // Act
    migrateElement.setOldGroup("Old Group");

    // Assert
    List<TupleAdaptedFunction<String, ?, ?>> components = migrateElement.getToOldTransform().getComponents();
    assertEquals(1, components.size());
    TupleAdaptedFunction<String, ?, ?> getResult = components.get(0);
    Function<?, ?> function = getResult.getFunction();
    assertTrue(function instanceof SetValue);
    assertEquals("Old Group", migrateElement.getOldGroup());
    assertEquals("Old Group", ((SetValue) function).getValue());
    assertArrayEquals(new String[]{"GROUP"}, getResult.getInputAdapter().getSelection());
    assertArrayEquals(new String[]{"GROUP"}, getResult.getOutputAdapter().getProjection());
    assertArrayEquals(new String[]{"GROUP"}, getResult.getProjection());
    assertArrayEquals(new String[]{"GROUP"}, getResult.getSelection());
  }

  /**
   * Method under test: {@link MigrateElement#setOldGroup(String)}
   */
  @Test
  void testSetOldGroup2() {
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
   * Method under test: {@link MigrateElement#setNewGroup(String)}
   */
  @Test
  void testSetNewGroup() {
    // Arrange
    MigrateElement migrateElement = new MigrateElement();

    // Act
    migrateElement.setNewGroup("New Group");

    // Assert
    List<TupleAdaptedFunction<String, ?, ?>> components = migrateElement.getToNewTransform().getComponents();
    assertEquals(1, components.size());
    TupleAdaptedFunction<String, ?, ?> getResult = components.get(0);
    Function<?, ?> function = getResult.getFunction();
    assertTrue(function instanceof SetValue);
    assertEquals("New Group", migrateElement.getNewGroup());
    assertEquals("New Group", ((SetValue) function).getValue());
    assertArrayEquals(new String[]{"GROUP"}, getResult.getInputAdapter().getSelection());
    assertArrayEquals(new String[]{"GROUP"}, getResult.getOutputAdapter().getProjection());
    assertArrayEquals(new String[]{"GROUP"}, getResult.getProjection());
    assertArrayEquals(new String[]{"GROUP"}, getResult.getSelection());
  }

  /**
   * Method under test: {@link MigrateElement#setNewGroup(String)}
   */
  @Test
  void testSetNewGroup2() {
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
   * Method under test: {@link MigrateElement#getToNewTransform()}
   */
  @Test
  void testGetToNewTransform() {
    // Arrange, Act and Assert
    assertTrue((new MigrateElement()).getToNewTransform().getComponents().isEmpty());
  }

  /**
   * Method under test: {@link MigrateElement#getToNewTransform()}
   */
  @Test
  void testGetToNewTransform2() {
    // Arrange
    ElementTransformer toNewTransform = new ElementTransformer();

    // Act and Assert
    List<TupleAdaptedFunction<String, ?, ?>> components = (new MigrateElement(MigrateElement.ElementType.EDGE,
        "Old Group", "New Group", toNewTransform, new ElementTransformer())).getToNewTransform().getComponents();
    assertEquals(1, components.size());
    TupleAdaptedFunction<String, ?, ?> getResult = components.get(0);
    Function<?, ?> function = getResult.getFunction();
    assertTrue(function instanceof SetValue);
    assertEquals("New Group", ((SetValue) function).getValue());
    assertArrayEquals(new String[]{"GROUP"}, getResult.getInputAdapter().getSelection());
    assertArrayEquals(new String[]{"GROUP"}, getResult.getOutputAdapter().getProjection());
    assertArrayEquals(new String[]{"GROUP"}, getResult.getProjection());
    assertArrayEquals(new String[]{"GROUP"}, getResult.getSelection());
  }

  /**
   * Method under test: {@link MigrateElement#getToNewTransform()}
   */
  @Test
  void testGetToNewTransform3() {
    // Arrange
    ArrayList<TupleAdaptedFunction<String, ?, ?>> toNewFunctions = new ArrayList<>();
    toNewFunctions.add(new TupleAdaptedFunction<>());

    MigrateElement migrateElement = new MigrateElement();
    migrateElement.setToNew(toNewFunctions);

    // Act and Assert
    assertEquals(toNewFunctions, migrateElement.getToNewTransform().getComponents());
  }

  /**
   * Method under test: {@link MigrateElement#getToNewTransform()}
   */
  @Test
  void testGetToNewTransform4() {
    // Arrange
    ArrayList<TupleAdaptedFunction<String, ?, ?>> toNewFunctions = new ArrayList<>();
    toNewFunctions
        .add(new TupleAdaptedFunction<>(new String[]{"Selection"}, mock(Function.class), new String[]{"Projection"}));

    MigrateElement migrateElement = new MigrateElement();
    migrateElement.setToNew(toNewFunctions);

    // Act and Assert
    assertEquals(toNewFunctions, migrateElement.getToNewTransform().getComponents());
  }

  /**
   * Method under test: {@link MigrateElement#getToOldTransform()}
   */
  @Test
  void testGetToOldTransform() {
    // Arrange, Act and Assert
    assertTrue((new MigrateElement()).getToOldTransform().getComponents().isEmpty());
  }

  /**
   * Method under test: {@link MigrateElement#getToOldTransform()}
   */
  @Test
  void testGetToOldTransform2() {
    // Arrange
    ElementTransformer toNewTransform = new ElementTransformer();

    // Act and Assert
    List<TupleAdaptedFunction<String, ?, ?>> components = (new MigrateElement(MigrateElement.ElementType.EDGE,
        "Old Group", "New Group", toNewTransform, new ElementTransformer())).getToOldTransform().getComponents();
    assertEquals(1, components.size());
    TupleAdaptedFunction<String, ?, ?> getResult = components.get(0);
    Function<?, ?> function = getResult.getFunction();
    assertTrue(function instanceof SetValue);
    assertEquals("Old Group", ((SetValue) function).getValue());
    assertArrayEquals(new String[]{"GROUP"}, getResult.getInputAdapter().getSelection());
    assertArrayEquals(new String[]{"GROUP"}, getResult.getOutputAdapter().getProjection());
    assertArrayEquals(new String[]{"GROUP"}, getResult.getProjection());
    assertArrayEquals(new String[]{"GROUP"}, getResult.getSelection());
  }

  /**
   * Method under test: {@link MigrateElement#getToOldTransform()}
   */
  @Test
  void testGetToOldTransform3() {
    // Arrange
    ArrayList<TupleAdaptedFunction<String, ?, ?>> toOldFunctions = new ArrayList<>();
    toOldFunctions.add(new TupleAdaptedFunction<>());

    MigrateElement migrateElement = new MigrateElement();
    migrateElement.setToOld(toOldFunctions);

    // Act and Assert
    assertEquals(toOldFunctions, migrateElement.getToOldTransform().getComponents());
  }

  /**
   * Method under test: {@link MigrateElement#getToOldTransform()}
   */
  @Test
  void testGetToOldTransform4() {
    // Arrange
    ArrayList<TupleAdaptedFunction<String, ?, ?>> toOldFunctions = new ArrayList<>();
    toOldFunctions
        .add(new TupleAdaptedFunction<>(new String[]{"Selection"}, mock(Function.class), new String[]{"Projection"}));

    MigrateElement migrateElement = new MigrateElement();
    migrateElement.setToOld(toOldFunctions);

    // Act and Assert
    assertEquals(toOldFunctions, migrateElement.getToOldTransform().getComponents());
  }

  /**
   * Method under test: {@link MigrateElement#getToNew()}
   */
  @Test
  void testGetToNew() {
    // Arrange
    MigrateElement migrateElement = new MigrateElement();
    migrateElement.setToNew(new ArrayList<>());

    // Act and Assert
    assertTrue(migrateElement.getToNew().isEmpty());
  }

  /**
   * Method under test: {@link MigrateElement#getToNew()}
   */
  @Test
  void testGetToNew2() {
    // Arrange
    ArrayList<TupleAdaptedFunction<String, ?, ?>> toNewFunctions = new ArrayList<>();
    toNewFunctions
        .add(new TupleAdaptedFunction<>(new String[]{"Selection"}, mock(Function.class), new String[]{"Projection"}));

    MigrateElement migrateElement = new MigrateElement();
    migrateElement.setToNew(toNewFunctions);

    // Act and Assert
    assertEquals(toNewFunctions, migrateElement.getToNew());
  }

  /**
   * Method under test: {@link MigrateElement#setToNew(List)}
   */
  @Test
  void testSetToNew() {
    // Arrange
    MigrateElement migrateElement = new MigrateElement();

    // Act
    migrateElement.setToNew(new ArrayList<>());

    // Assert
    assertTrue(migrateElement.getToNew().isEmpty());
    assertTrue(migrateElement.getToNewTransform().getComponents().isEmpty());
  }

  /**
   * Method under test: {@link MigrateElement#setToNew(List)}
   */
  @Test
  void testSetToNew2() {
    // Arrange
    MigrateElement migrateElement = new MigrateElement();

    ArrayList<TupleAdaptedFunction<String, ?, ?>> toNewFunctions = new ArrayList<>();
    toNewFunctions.add(new TupleAdaptedFunction<>());

    // Act
    migrateElement.setToNew(toNewFunctions);

    // Assert
    assertEquals(toNewFunctions, migrateElement.getToNew());
    assertEquals(toNewFunctions, migrateElement.getToNewTransform().getComponents());
  }

  /**
   * Method under test: {@link MigrateElement#setToNew(List)}
   */
  @Test
  void testSetToNew3() {
    // Arrange
    MigrateElement migrateElement = new MigrateElement();

    ArrayList<TupleAdaptedFunction<String, ?, ?>> toNewFunctions = new ArrayList<>();
    toNewFunctions.add(new TupleAdaptedFunction<>());
    toNewFunctions.add(new TupleAdaptedFunction<>());

    // Act
    migrateElement.setToNew(toNewFunctions);

    // Assert
    assertEquals(toNewFunctions, migrateElement.getToNew());
    assertEquals(toNewFunctions, migrateElement.getToNewTransform().getComponents());
  }

  /**
   * Method under test: {@link MigrateElement#setToNew(List)}
   */
  @Test
  void testSetToNew4() {
    // Arrange
    MigrateElement migrateElement = new MigrateElement();

    ArrayList<TupleAdaptedFunction<String, ?, ?>> toNewFunctions = new ArrayList<>();
    toNewFunctions
        .add(new TupleAdaptedFunction<>(new String[]{"Selection"}, mock(Function.class), new String[]{"Projection"}));

    // Act
    migrateElement.setToNew(toNewFunctions);

    // Assert
    assertEquals(toNewFunctions, migrateElement.getToNew());
    assertEquals(toNewFunctions, migrateElement.getToNewTransform().getComponents());
  }

  /**
   * Method under test: {@link MigrateElement#getToOld()}
   */
  @Test
  void testGetToOld() {
    // Arrange
    MigrateElement migrateElement = new MigrateElement();
    migrateElement.setToOld(new ArrayList<>());

    // Act and Assert
    assertTrue(migrateElement.getToOld().isEmpty());
  }

  /**
   * Method under test: {@link MigrateElement#getToOld()}
   */
  @Test
  void testGetToOld2() {
    // Arrange
    ArrayList<TupleAdaptedFunction<String, ?, ?>> toOldFunctions = new ArrayList<>();
    toOldFunctions
        .add(new TupleAdaptedFunction<>(new String[]{"Selection"}, mock(Function.class), new String[]{"Projection"}));

    MigrateElement migrateElement = new MigrateElement();
    migrateElement.setToOld(toOldFunctions);

    // Act and Assert
    assertEquals(toOldFunctions, migrateElement.getToOld());
  }

  /**
   * Method under test: {@link MigrateElement#setToOld(List)}
   */
  @Test
  void testSetToOld() {
    // Arrange
    MigrateElement migrateElement = new MigrateElement();

    // Act
    migrateElement.setToOld(new ArrayList<>());

    // Assert
    assertTrue(migrateElement.getToOld().isEmpty());
  }

  /**
   * Method under test: {@link MigrateElement#setToOld(List)}
   */
  @Test
  void testSetToOld2() {
    // Arrange
    MigrateElement migrateElement = new MigrateElement();

    ArrayList<TupleAdaptedFunction<String, ?, ?>> toOldFunctions = new ArrayList<>();
    toOldFunctions.add(new TupleAdaptedFunction<>());

    // Act
    migrateElement.setToOld(toOldFunctions);

    // Assert
    assertEquals(toOldFunctions, migrateElement.getToOld());
    assertEquals(toOldFunctions, migrateElement.getToOldTransform().getComponents());
  }

  /**
   * Method under test: {@link MigrateElement#setToOld(List)}
   */
  @Test
  void testSetToOld3() {
    // Arrange
    MigrateElement migrateElement = new MigrateElement();

    ArrayList<TupleAdaptedFunction<String, ?, ?>> toOldFunctions = new ArrayList<>();
    toOldFunctions.add(new TupleAdaptedFunction<>());
    toOldFunctions.add(new TupleAdaptedFunction<>());

    // Act
    migrateElement.setToOld(toOldFunctions);

    // Assert
    assertEquals(toOldFunctions, migrateElement.getToOld());
    assertEquals(toOldFunctions, migrateElement.getToOldTransform().getComponents());
  }

  /**
   * Method under test: {@link MigrateElement#setToOld(List)}
   */
  @Test
  void testSetToOld4() {
    // Arrange
    MigrateElement migrateElement = new MigrateElement();

    ArrayList<TupleAdaptedFunction<String, ?, ?>> toOldFunctions = new ArrayList<>();
    toOldFunctions
        .add(new TupleAdaptedFunction<>(new String[]{"Selection"}, mock(Function.class), new String[]{"Projection"}));

    // Act
    migrateElement.setToOld(toOldFunctions);

    // Assert
    assertEquals(toOldFunctions, migrateElement.getToOld());
    assertEquals(toOldFunctions, migrateElement.getToOldTransform().getComponents());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MigrateElement#equals(Object)}
   *   <li>{@link MigrateElement#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MigrateElement migrateElement = new MigrateElement();

    // Act and Assert
    assertEquals(migrateElement, migrateElement);
    int expectedHashCodeResult = migrateElement.hashCode();
    assertEquals(expectedHashCodeResult, migrateElement.hashCode());
  }

  /**
   * Method under test: {@link MigrateElement#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MigrateElement migrateElement = new MigrateElement();

    // Act and Assert
    assertNotEquals(migrateElement, new MigrateElement());
  }

  /**
   * Method under test: {@link MigrateElement#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MigrateElement migrateElement = new MigrateElement();

    MigrateElement migrateElement2 = new MigrateElement();
    migrateElement2.setOldGroup("Old Group");

    // Act and Assert
    assertNotEquals(migrateElement, migrateElement2);
  }

  /**
   * Method under test: {@link MigrateElement#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MigrateElement migrateElement = new MigrateElement();

    MigrateElement migrateElement2 = new MigrateElement();
    migrateElement2.setNewGroup("New Group");

    // Act and Assert
    assertNotEquals(migrateElement, migrateElement2);
  }

  /**
   * Method under test: {@link MigrateElement#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MigrateElement migrateElement = new MigrateElement();
    ElementTransformer toNewTransform = new ElementTransformer();

    // Act and Assert
    assertNotEquals(migrateElement, new MigrateElement(MigrateElement.ElementType.EDGE, "Old Group", "New Group",
        toNewTransform, new ElementTransformer()));
  }

  /**
   * Method under test: {@link MigrateElement#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MigrateElement(), null);
  }

  /**
   * Method under test: {@link MigrateElement#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MigrateElement(), "Different type to MigrateElement");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MigrateElement#MigrateElement()}
   *   <li>{@link MigrateElement#setElementType(MigrateElement.ElementType)}
   *   <li>{@link MigrateElement#getElementType()}
   *   <li>{@link MigrateElement#getNewGroup()}
   *   <li>{@link MigrateElement#getOldGroup()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    MigrateElement actualMigrateElement = new MigrateElement();
    actualMigrateElement.setElementType(MigrateElement.ElementType.EDGE);
    MigrateElement.ElementType actualElementType = actualMigrateElement.getElementType();
    actualMigrateElement.getNewGroup();
    actualMigrateElement.getOldGroup();

    // Assert that nothing has changed
    assertEquals(MigrateElement.ElementType.EDGE, actualElementType);
  }

  /**
   * Method under test:
   * {@link MigrateElement#MigrateElement(MigrateElement.ElementType, String, String, ElementTransformer, ElementTransformer)}
   */
  @Test
  void testNewMigrateElement() {
    // Arrange
    ElementTransformer toNewTransform = new ElementTransformer();

    // Act
    MigrateElement actualMigrateElement = new MigrateElement(MigrateElement.ElementType.EDGE, "Old Group", "New Group",
        toNewTransform, new ElementTransformer());

    // Assert
    List<TupleAdaptedFunction<String, ?, ?>> components = actualMigrateElement.getToNewTransform().getComponents();
    assertEquals(1, components.size());
    TupleAdaptedFunction<String, ?, ?> getResult = components.get(0);
    Function<?, ?> function = getResult.getFunction();
    assertTrue(function instanceof SetValue);
    List<TupleAdaptedFunction<String, ?, ?>> components2 = actualMigrateElement.getToOldTransform().getComponents();
    assertEquals(1, components2.size());
    TupleAdaptedFunction<String, ?, ?> getResult2 = components2.get(0);
    Function<?, ?> function2 = getResult2.getFunction();
    assertTrue(function2 instanceof SetValue);
    assertEquals("New Group", actualMigrateElement.getNewGroup());
    assertEquals("New Group", ((SetValue) function).getValue());
    assertEquals("Old Group", actualMigrateElement.getOldGroup());
    assertEquals("Old Group", ((SetValue) function2).getValue());
    assertEquals(MigrateElement.ElementType.EDGE, actualMigrateElement.getElementType());
    assertTrue(actualMigrateElement.getToNew().isEmpty());
    assertTrue(actualMigrateElement.getToOld().isEmpty());
    assertArrayEquals(new String[]{"GROUP"}, getResult.getInputAdapter().getSelection());
    assertArrayEquals(new String[]{"GROUP"}, getResult2.getInputAdapter().getSelection());
    assertArrayEquals(new String[]{"GROUP"}, getResult.getOutputAdapter().getProjection());
    assertArrayEquals(new String[]{"GROUP"}, getResult2.getOutputAdapter().getProjection());
    assertArrayEquals(new String[]{"GROUP"}, getResult.getProjection());
    assertArrayEquals(new String[]{"GROUP"}, getResult2.getProjection());
    assertArrayEquals(new String[]{"GROUP"}, getResult.getSelection());
    assertArrayEquals(new String[]{"GROUP"}, getResult2.getSelection());
  }

  /**
   * Method under test:
   * {@link MigrateElement#MigrateElement(MigrateElement.ElementType, String, String, ElementTransformer, ElementTransformer)}
   */
  @Test
  void testNewMigrateElement2() {
    // Arrange
    ElementTransformer toNewTransform = new ElementTransformer();

    // Act
    MigrateElement actualMigrateElement = new MigrateElement(MigrateElement.ElementType.EDGE, "New Group", "New Group",
        toNewTransform, new ElementTransformer());

    // Assert
    assertEquals("New Group", actualMigrateElement.getNewGroup());
    assertEquals("New Group", actualMigrateElement.getOldGroup());
    assertEquals(MigrateElement.ElementType.EDGE, actualMigrateElement.getElementType());
    assertTrue(actualMigrateElement.getToNew().isEmpty());
    assertTrue(actualMigrateElement.getToOld().isEmpty());
    assertEquals(toNewTransform, actualMigrateElement.getToNewTransform());
    assertEquals(toNewTransform, actualMigrateElement.getToOldTransform());
  }

  /**
   * Method under test:
   * {@link MigrateElement#MigrateElement(MigrateElement.ElementType, String, String, ElementTransformer, ElementTransformer)}
   */
  @Test
  void testNewMigrateElement3() {
    // Arrange
    ElementTransformer toNewTransform = new ElementTransformer();
    toNewTransform.apply(new LazyEdge(new Edge("Group"), mock(ElementValueLoader.class)));

    // Act
    MigrateElement actualMigrateElement = new MigrateElement(MigrateElement.ElementType.EDGE, "Old Group", "New Group",
        toNewTransform, new ElementTransformer());

    // Assert
    List<TupleAdaptedFunction<String, ?, ?>> components = actualMigrateElement.getToNewTransform().getComponents();
    assertEquals(1, components.size());
    TupleAdaptedFunction<String, ?, ?> getResult = components.get(0);
    Function<?, ?> function = getResult.getFunction();
    assertTrue(function instanceof SetValue);
    List<TupleAdaptedFunction<String, ?, ?>> components2 = actualMigrateElement.getToOldTransform().getComponents();
    assertEquals(1, components2.size());
    TupleAdaptedFunction<String, ?, ?> getResult2 = components2.get(0);
    Function<?, ?> function2 = getResult2.getFunction();
    assertTrue(function2 instanceof SetValue);
    assertEquals("New Group", actualMigrateElement.getNewGroup());
    assertEquals("New Group", ((SetValue) function).getValue());
    assertEquals("Old Group", actualMigrateElement.getOldGroup());
    assertEquals("Old Group", ((SetValue) function2).getValue());
    assertEquals(MigrateElement.ElementType.EDGE, actualMigrateElement.getElementType());
    assertTrue(actualMigrateElement.getToNew().isEmpty());
    assertTrue(actualMigrateElement.getToOld().isEmpty());
    assertArrayEquals(new String[]{"GROUP"}, getResult.getInputAdapter().getSelection());
    assertArrayEquals(new String[]{"GROUP"}, getResult2.getInputAdapter().getSelection());
    assertArrayEquals(new String[]{"GROUP"}, getResult.getOutputAdapter().getProjection());
    assertArrayEquals(new String[]{"GROUP"}, getResult2.getOutputAdapter().getProjection());
    assertArrayEquals(new String[]{"GROUP"}, getResult.getProjection());
    assertArrayEquals(new String[]{"GROUP"}, getResult2.getProjection());
    assertArrayEquals(new String[]{"GROUP"}, getResult.getSelection());
    assertArrayEquals(new String[]{"GROUP"}, getResult2.getSelection());
  }
}
