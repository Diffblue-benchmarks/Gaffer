package uk.gov.gchq.gaffer.data.elementdefinition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.data.elementdefinition.ElementDefinitions.BaseBuilder;
import uk.gov.gchq.gaffer.data.elementdefinition.exception.SchemaException;
import uk.gov.gchq.gaffer.data.elementdefinition.view.NamedView;
import uk.gov.gchq.gaffer.data.elementdefinition.view.NamedView.Builder;
import uk.gov.gchq.gaffer.data.elementdefinition.view.View;
import uk.gov.gchq.gaffer.data.elementdefinition.view.ViewElementDefinition;

class ElementDefinitionsDiffblueTest {
  /**
   * Test BaseBuilder {@link BaseBuilder#addEdges(Map)}.
   *
   * <ul>
   *   <li>Given {@link Builder#Builder()}.
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#addEdges(Map)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder addEdges(Map); given Builder(); when HashMap(); then return Builder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.addEdges(Map)"})
  void testBaseBuilderAddEdges_givenBuilder_whenHashMap_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualAddEdgesResult = builder.addEdges(new HashMap<>());

    // Assert
    assertSame(builder, actualAddEdgesResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#addEdges(Map)}.
   *
   * <ul>
   *   <li>Given {@link Builder#Builder()}.
   *   <li>When {@code null}.
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#addEdges(Map)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder addEdges(Map); given Builder(); when 'null'; then return Builder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.addEdges(Map)"})
  void testBaseBuilderAddEdges_givenBuilder_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualAddEdgesResult = builder.addEdges(null);

    // Assert
    assertSame(builder, actualAddEdgesResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#addEntities(Map)}.
   *
   * <ul>
   *   <li>Given {@link Builder#Builder()}.
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#addEntities(Map)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder addEntities(Map); given Builder(); when HashMap(); then return Builder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.addEntities(Map)"})
  void testBaseBuilderAddEntities_givenBuilder_whenHashMap_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualAddEntitiesResult = builder.addEntities(new HashMap<>());

    // Assert
    assertSame(builder, actualAddEntitiesResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#addEntities(Map)}.
   *
   * <ul>
   *   <li>Given {@link Builder#Builder()}.
   *   <li>When {@code null}.
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#addEntities(Map)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder addEntities(Map); given Builder(); when 'null'; then return Builder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.addEntities(Map)"})
  void testBaseBuilderAddEntities_givenBuilder_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualAddEntitiesResult = builder.addEntities(null);

    // Assert
    assertSame(builder, actualAddEntitiesResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#edges(Map)}.
   *
   * <ul>
   *   <li>Given {@link Builder#Builder()}.
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#edges(Map)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder edges(Map); given Builder(); when HashMap(); then return Builder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.edges(Map)"})
  void testBaseBuilderEdges_givenBuilder_whenHashMap_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualEdgesResult = builder.edges(new HashMap<>());

    // Assert
    assertSame(builder, actualEdgesResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#edges(Map)}.
   *
   * <ul>
   *   <li>Given {@link Builder#Builder()}.
   *   <li>When {@code null}.
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#edges(Map)}
   */
  @Test
  @DisplayName("Test BaseBuilder edges(Map); given Builder(); when 'null'; then return Builder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.edges(Map)"})
  void testBaseBuilderEdges_givenBuilder_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualEdgesResult = builder.edges((Map<String, ViewElementDefinition>) null);

    // Assert
    assertSame(builder, actualEdgesResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#entities(Map)}.
   *
   * <ul>
   *   <li>Given {@link Builder#Builder()}.
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#entities(Map)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder entities(Map); given Builder(); when HashMap(); then return Builder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.entities(Map)"})
  void testBaseBuilderEntities_givenBuilder_whenHashMap_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualEntitiesResult = builder.entities(new HashMap<>());

    // Assert
    assertSame(builder, actualEntitiesResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#entities(Map)}.
   *
   * <ul>
   *   <li>Given {@link Builder#Builder()}.
   *   <li>When {@code null}.
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#entities(Map)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder entities(Map); given Builder(); when 'null'; then return Builder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.entities(Map)"})
  void testBaseBuilderEntities_givenBuilder_whenNull_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualEntitiesResult = builder.entities((Map<String, ViewElementDefinition>) null);

    // Assert
    assertSame(builder, actualEntitiesResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#json(Class, Path[])} with {@code clazz}, {@code filePaths}.
   *
   * <ul>
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#json(Class, Path[])}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder json(Class, Path[]) with 'clazz', 'filePaths'; then return Builder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.json(Class, Path[])"})
  void testBaseBuilderJsonWithClazzFilePaths_thenReturnBuilder() throws SchemaException {
    // Arrange
    Builder builder = new Builder();
    Class<View> clazz = View.class;
    Paths.get(System.getProperty("java.io.tmpdir"), "test.txt");

    // Act
    Builder actualJsonResult = builder.json(clazz, new Path[] {});

    // Assert
    assertSame(builder, actualJsonResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#json(Class, Path[])} with {@code clazz}, {@code filePaths}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is empty string.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#json(Class, Path[])}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder json(Class, Path[]) with 'clazz', 'filePaths'; when Property is 'java.io.tmpdir' is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.json(Class, Path[])"})
  void testBaseBuilderJsonWithClazzFilePaths_whenPropertyIsJavaIoTmpdirIsEmptyString()
      throws SchemaException {
    // Arrange
    Builder builder = new Builder();
    Class<View> clazz = View.class;

    // Act and Assert
    assertThrows(
        SchemaException.class,
        () -> builder.json(clazz, Paths.get(System.getProperty("java.io.tmpdir"), "")));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#json(Class, Path[])} with {@code clazz}, {@code filePaths}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#json(Class, Path[])}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder json(Class, Path[]) with 'clazz', 'filePaths'; when Property is 'java.io.tmpdir' is 'test.txt'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.json(Class, Path[])"})
  void testBaseBuilderJsonWithClazzFilePaths_whenPropertyIsJavaIoTmpdirIsTestTxt()
      throws SchemaException {
    // Arrange
    Builder builder = new Builder();
    Class<View> clazz = View.class;

    // Act and Assert
    assertThrows(
        SchemaException.class,
        () -> builder.json(clazz, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt")));
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#json(Class, InputStream[])} with {@code clazz}, {@code
   * inputStreams}.
   *
   * <ul>
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#json(Class, InputStream[])}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder json(Class, InputStream[]) with 'clazz', 'inputStreams'; then return Builder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.json(Class, InputStream[])"})
  void testBaseBuilderJsonWithClazzInputStreams_thenReturnBuilder() throws SchemaException {
    // Arrange
    Builder builder = new Builder();
    Class<View> clazz = View.class;

    // Act
    Builder actualJsonResult = builder.json(clazz, new InputStream[] {});

    // Assert
    assertSame(builder, actualJsonResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#json(Class, byte[][])} with {@code clazz}, {@code
   * jsonBytes}.
   *
   * <ul>
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#json(Class, byte[][])}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder json(Class, byte[][]) with 'clazz', 'jsonBytes'; then return Builder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.json(Class, byte[][])"})
  void testBaseBuilderJsonWithClazzJsonBytes_thenReturnBuilder() throws SchemaException {
    // Arrange
    Builder builder = new Builder();
    Class<View> clazz = View.class;

    // Act
    Builder actualJsonResult = builder.json(clazz, new byte[][] {});

    // Assert
    assertSame(builder, actualJsonResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#json(Class, Object[])} with {@code clazz}, {@code
   * jsonItems}.
   *
   * <p>Method under test: {@link BaseBuilder#json(Class, Object[])}
   */
  @Test
  @DisplayName("Test BaseBuilder json(Class, Object[]) with 'clazz', 'jsonItems'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.json(Class, Object[])"})
  void testBaseBuilderJsonWithClazzJsonItems() throws SchemaException {
    // Arrange
    Builder builder = new Builder();
    Class<View> clazz = View.class;

    // Act
    Builder actualJsonResult = builder.json(clazz, new Object[] {});

    // Assert
    assertSame(builder, actualJsonResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#removeEdges(Predicate)}.
   *
   * <ul>
   *   <li>Given {@link Builder#Builder()}.
   *   <li>When {@link Predicate}.
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#removeEdges(Predicate)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder removeEdges(Predicate); given Builder(); when Predicate; then return Builder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.removeEdges(Predicate)"})
  void testBaseBuilderRemoveEdges_givenBuilder_whenPredicate_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualRemoveEdgesResult = builder.removeEdges(mock(Predicate.class));

    // Assert
    assertSame(builder, actualRemoveEdgesResult);
  }

  /**
   * Test BaseBuilder {@link BaseBuilder#removeEntities(Predicate)}.
   *
   * <ul>
   *   <li>Given {@link Builder#Builder()}.
   *   <li>When {@link Predicate}.
   *   <li>Then return {@link Builder#Builder()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseBuilder#removeEntities(Predicate)}
   */
  @Test
  @DisplayName(
      "Test BaseBuilder removeEntities(Predicate); given Builder(); when Predicate; then return Builder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BaseBuilder BaseBuilder.removeEntities(Predicate)"})
  void testBaseBuilderRemoveEntities_givenBuilder_whenPredicate_thenReturnBuilder() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualRemoveEntitiesResult = builder.removeEntities(mock(Predicate.class));

    // Assert
    assertSame(builder, actualRemoveEntitiesResult);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ElementDefinitions}
   *   <li>{@link ElementDefinitions#setEdges(Map)}
   *   <li>{@link ElementDefinitions#setEntities(Map)}
   *   <li>{@link ElementDefinitions#toString()}
   *   <li>{@link ElementDefinitions#getEdges()}
   *   <li>{@link ElementDefinitions#getEntities()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ElementDefinitions.<init>()",
    "Map ElementDefinitions.getEdges()",
    "Map ElementDefinitions.getEntities()",
    "void ElementDefinitions.setEdges(Map)",
    "void ElementDefinitions.setEntities(Map)",
    "String ElementDefinitions.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ElementDefinitions<ElementDefinition, ElementDefinition> actualElementDefinitions =
        new ElementDefinitions<>();
    HashMap<String, ElementDefinition> edges = new HashMap<>();
    actualElementDefinitions.setEdges(edges);
    HashMap<String, ElementDefinition> entities = new HashMap<>();
    actualElementDefinitions.setEntities(entities);
    String actualToStringResult = actualElementDefinitions.toString();
    Map<String, ElementDefinition> actualEdges = actualElementDefinitions.getEdges();
    Map<String, ElementDefinition> actualEntities = actualElementDefinitions.getEntities();

    // Assert
    assertEquals("ElementDefinitions[edges={},entities={}]", actualToStringResult);
    assertTrue(actualEdges.isEmpty());
    assertTrue(actualEntities.isEmpty());
    assertSame(edges, actualEdges);
    assertSame(entities, actualEntities);
  }

  /**
   * Test {@link ElementDefinitions#getElement(String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ElementDefinitions#getElement(String)}
   */
  @Test
  @DisplayName("Test getElement(String); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementDefinition ElementDefinitions.getElement(String)"})
  void testGetElement_thenReturnNull() {
    // Arrange
    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions =
        new ElementDefinitions<>();

    // Act and Assert
    assertNull(elementDefinitions.getElement("Group"));
  }

  /**
   * Test {@link ElementDefinitions#getEdge(String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ElementDefinitions#getEdge(String)}
   */
  @Test
  @DisplayName("Test getEdge(String); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementDefinition ElementDefinitions.getEdge(String)"})
  void testGetEdge_thenReturnNull() {
    // Arrange
    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions =
        new ElementDefinitions<>();

    // Act and Assert
    assertNull(elementDefinitions.getEdge("Group"));
  }

  /**
   * Test {@link ElementDefinitions#getEntity(String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ElementDefinitions#getEntity(String)}
   */
  @Test
  @DisplayName("Test getEntity(String); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ElementDefinition ElementDefinitions.getEntity(String)"})
  void testGetEntity_thenReturnNull() {
    // Arrange
    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions =
        new ElementDefinitions<>();

    // Act and Assert
    assertNull(elementDefinitions.getEntity("Group"));
  }

  /**
   * Test {@link ElementDefinitions#isEntity(String)}.
   *
   * <p>Method under test: {@link ElementDefinitions#isEntity(String)}
   */
  @Test
  @DisplayName("Test isEntity(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ElementDefinitions.isEntity(String)"})
  void testIsEntity() {
    // Arrange
    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions =
        new ElementDefinitions<>();

    // Act and Assert
    assertFalse(elementDefinitions.isEntity("Group"));
  }

  /**
   * Test {@link ElementDefinitions#isEdge(String)}.
   *
   * <p>Method under test: {@link ElementDefinitions#isEdge(String)}
   */
  @Test
  @DisplayName("Test isEdge(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ElementDefinitions.isEdge(String)"})
  void testIsEdge() {
    // Arrange
    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions =
        new ElementDefinitions<>();

    // Act and Assert
    assertFalse(elementDefinitions.isEdge("Group"));
  }

  /**
   * Test {@link ElementDefinitions#getEdgeGroups()}.
   *
   * <ul>
   *   <li>Given {@link ElementDefinitions#ElementDefinitions()}.
   * </ul>
   *
   * <p>Method under test: {@link ElementDefinitions#getEdgeGroups()}
   */
  @Test
  @DisplayName("Test getEdgeGroups(); given ElementDefinitions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set ElementDefinitions.getEdgeGroups()"})
  void testGetEdgeGroups_givenElementDefinitions() {
    // Arrange
    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions =
        new ElementDefinitions<>();

    // Act and Assert
    assertTrue(elementDefinitions.getEdgeGroups().isEmpty());
  }

  /**
   * Test {@link ElementDefinitions#getEdgeGroups()}.
   *
   * <ul>
   *   <li>Given {@link ElementDefinitions#ElementDefinitions()} Edges is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ElementDefinitions#getEdgeGroups()}
   */
  @Test
  @DisplayName("Test getEdgeGroups(); given ElementDefinitions() Edges is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set ElementDefinitions.getEdgeGroups()"})
  void testGetEdgeGroups_givenElementDefinitionsEdgesIsNull() {
    // Arrange
    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions =
        new ElementDefinitions<>();
    elementDefinitions.setEdges(null);

    // Act and Assert
    assertTrue(elementDefinitions.getEdgeGroups().isEmpty());
  }

  /**
   * Test {@link ElementDefinitions#getEntityGroups()}.
   *
   * <ul>
   *   <li>Given {@link ElementDefinitions#ElementDefinitions()}.
   * </ul>
   *
   * <p>Method under test: {@link ElementDefinitions#getEntityGroups()}
   */
  @Test
  @DisplayName("Test getEntityGroups(); given ElementDefinitions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set ElementDefinitions.getEntityGroups()"})
  void testGetEntityGroups_givenElementDefinitions() {
    // Arrange
    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions =
        new ElementDefinitions<>();

    // Act and Assert
    assertTrue(elementDefinitions.getEntityGroups().isEmpty());
  }

  /**
   * Test {@link ElementDefinitions#getEntityGroups()}.
   *
   * <ul>
   *   <li>Given {@link ElementDefinitions#ElementDefinitions()} Entities is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ElementDefinitions#getEntityGroups()}
   */
  @Test
  @DisplayName("Test getEntityGroups(); given ElementDefinitions() Entities is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set ElementDefinitions.getEntityGroups()"})
  void testGetEntityGroups_givenElementDefinitionsEntitiesIsNull() {
    // Arrange
    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions =
        new ElementDefinitions<>();
    elementDefinitions.setEntities(null);

    // Act and Assert
    assertTrue(elementDefinitions.getEntityGroups().isEmpty());
  }

  /**
   * Test {@link ElementDefinitions#getGroups()}.
   *
   * <ul>
   *   <li>Given {@link ElementDefinitions#ElementDefinitions()}.
   * </ul>
   *
   * <p>Method under test: {@link ElementDefinitions#getGroups()}
   */
  @Test
  @DisplayName("Test getGroups(); given ElementDefinitions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set ElementDefinitions.getGroups()"})
  void testGetGroups_givenElementDefinitions() {
    // Arrange
    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions =
        new ElementDefinitions<>();

    // Act and Assert
    assertTrue(elementDefinitions.getGroups().isEmpty());
  }

  /**
   * Test {@link ElementDefinitions#getGroups()}.
   *
   * <ul>
   *   <li>Given {@link ElementDefinitions#ElementDefinitions()} Entities is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ElementDefinitions#getGroups()}
   */
  @Test
  @DisplayName("Test getGroups(); given ElementDefinitions() Entities is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Set ElementDefinitions.getGroups()"})
  void testGetGroups_givenElementDefinitionsEntitiesIsNull() {
    // Arrange
    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions =
        new ElementDefinitions<>();
    elementDefinitions.setEntities(null);
    elementDefinitions.setEdges(null);

    // Act and Assert
    assertTrue(elementDefinitions.getGroups().isEmpty());
  }

  /**
   * Test {@link ElementDefinitions#hasEntities()}.
   *
   * <ul>
   *   <li>Given {@link ElementDefinitions#ElementDefinitions()} Entities is {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ElementDefinitions#hasEntities()}
   */
  @Test
  @DisplayName(
      "Test hasEntities(); given ElementDefinitions() Entities is 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ElementDefinitions.hasEntities()"})
  void testHasEntities_givenElementDefinitionsEntitiesIsNull_thenReturnFalse() {
    // Arrange
    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions =
        new ElementDefinitions<>();
    elementDefinitions.setEntities(null);

    // Act and Assert
    assertFalse(elementDefinitions.hasEntities());
  }

  /**
   * Test {@link ElementDefinitions#hasEntities()}.
   *
   * <ul>
   *   <li>Given {@link ElementDefinitions#ElementDefinitions()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ElementDefinitions#hasEntities()}
   */
  @Test
  @DisplayName("Test hasEntities(); given ElementDefinitions(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ElementDefinitions.hasEntities()"})
  void testHasEntities_givenElementDefinitions_thenReturnFalse() {
    // Arrange
    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions =
        new ElementDefinitions<>();

    // Act and Assert
    assertFalse(elementDefinitions.hasEntities());
  }

  /**
   * Test {@link ElementDefinitions#hasEntities()}.
   *
   * <ul>
   *   <li>Given {@link TreeMap#TreeMap()} {@code foo} is {@link ElementDefinition}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ElementDefinitions#hasEntities()}
   */
  @Test
  @DisplayName("Test hasEntities(); given TreeMap() 'foo' is ElementDefinition; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ElementDefinitions.hasEntities()"})
  void testHasEntities_givenTreeMapFooIsElementDefinition_thenReturnTrue() {
    // Arrange
    TreeMap<String, ElementDefinition> entities = new TreeMap<>();
    entities.put("foo", mock(ElementDefinition.class));

    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions =
        new ElementDefinitions<>();
    elementDefinitions.setEntities(entities);

    // Act and Assert
    assertTrue(elementDefinitions.hasEntities());
  }

  /**
   * Test {@link ElementDefinitions#hasEdges()}.
   *
   * <ul>
   *   <li>Given {@link ElementDefinitions#ElementDefinitions()} Edges is {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ElementDefinitions#hasEdges()}
   */
  @Test
  @DisplayName("Test hasEdges(); given ElementDefinitions() Edges is 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ElementDefinitions.hasEdges()"})
  void testHasEdges_givenElementDefinitionsEdgesIsNull_thenReturnFalse() {
    // Arrange
    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions =
        new ElementDefinitions<>();
    elementDefinitions.setEdges(null);

    // Act and Assert
    assertFalse(elementDefinitions.hasEdges());
  }

  /**
   * Test {@link ElementDefinitions#hasEdges()}.
   *
   * <ul>
   *   <li>Given {@link ElementDefinitions#ElementDefinitions()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ElementDefinitions#hasEdges()}
   */
  @Test
  @DisplayName("Test hasEdges(); given ElementDefinitions(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ElementDefinitions.hasEdges()"})
  void testHasEdges_givenElementDefinitions_thenReturnFalse() {
    // Arrange
    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions =
        new ElementDefinitions<>();

    // Act and Assert
    assertFalse(elementDefinitions.hasEdges());
  }

  /**
   * Test {@link ElementDefinitions#hasEdges()}.
   *
   * <ul>
   *   <li>Given {@link TreeMap#TreeMap()} {@code foo} is {@link ElementDefinition}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ElementDefinitions#hasEdges()}
   */
  @Test
  @DisplayName("Test hasEdges(); given TreeMap() 'foo' is ElementDefinition; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ElementDefinitions.hasEdges()"})
  void testHasEdges_givenTreeMapFooIsElementDefinition_thenReturnTrue() {
    // Arrange
    TreeMap<String, ElementDefinition> edges = new TreeMap<>();
    edges.put("foo", mock(ElementDefinition.class));

    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions =
        new ElementDefinitions<>();
    elementDefinitions.setEdges(edges);

    // Act and Assert
    assertTrue(elementDefinitions.hasEdges());
  }

  /**
   * Test {@link ElementDefinitions#hasGroups()}.
   *
   * <ul>
   *   <li>Given {@link ElementDefinitions#ElementDefinitions()} Edges is {@link HashMap#HashMap()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ElementDefinitions#hasGroups()}
   */
  @Test
  @DisplayName(
      "Test hasGroups(); given ElementDefinitions() Edges is HashMap(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ElementDefinitions.hasGroups()"})
  void testHasGroups_givenElementDefinitionsEdgesIsHashMap_thenReturnTrue() {
    // Arrange
    HashMap<String, ElementDefinition> edges = new HashMap<>();
    edges.put("foo", mock(ElementDefinition.class));

    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions =
        new ElementDefinitions<>();
    elementDefinitions.setEdges(edges);

    // Act and Assert
    assertTrue(elementDefinitions.hasGroups());
  }

  /**
   * Test {@link ElementDefinitions#hasGroups()}.
   *
   * <ul>
   *   <li>Given {@link ElementDefinitions#ElementDefinitions()} Entities is {@link
   *       HashMap#HashMap()}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ElementDefinitions#hasGroups()}
   */
  @Test
  @DisplayName(
      "Test hasGroups(); given ElementDefinitions() Entities is HashMap(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ElementDefinitions.hasGroups()"})
  void testHasGroups_givenElementDefinitionsEntitiesIsHashMap_thenReturnTrue() {
    // Arrange
    HashMap<String, ElementDefinition> entities = new HashMap<>();
    entities.put("foo", mock(ElementDefinition.class));

    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions =
        new ElementDefinitions<>();
    elementDefinitions.setEntities(entities);

    // Act and Assert
    assertTrue(elementDefinitions.hasGroups());
  }

  /**
   * Test {@link ElementDefinitions#hasGroups()}.
   *
   * <ul>
   *   <li>Given {@link ElementDefinitions#ElementDefinitions()} Entities is {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ElementDefinitions#hasGroups()}
   */
  @Test
  @DisplayName(
      "Test hasGroups(); given ElementDefinitions() Entities is 'null'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ElementDefinitions.hasGroups()"})
  void testHasGroups_givenElementDefinitionsEntitiesIsNull_thenReturnFalse() {
    // Arrange
    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions =
        new ElementDefinitions<>();
    elementDefinitions.setEntities(null);
    elementDefinitions.setEdges(null);

    // Act and Assert
    assertFalse(elementDefinitions.hasGroups());
  }

  /**
   * Test {@link ElementDefinitions#hasGroups()}.
   *
   * <ul>
   *   <li>Given {@link ElementDefinitions#ElementDefinitions()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ElementDefinitions#hasGroups()}
   */
  @Test
  @DisplayName("Test hasGroups(); given ElementDefinitions(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ElementDefinitions.hasGroups()"})
  void testHasGroups_givenElementDefinitions_thenReturnFalse() {
    // Arrange
    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions =
        new ElementDefinitions<>();

    // Act and Assert
    assertFalse(elementDefinitions.hasGroups());
  }

  /**
   * Test {@link ElementDefinitions#equals(Object)}, and {@link ElementDefinitions#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ElementDefinitions#equals(Object)}
   *   <li>{@link ElementDefinitions#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ElementDefinitions.equals(Object)",
    "int ElementDefinitions.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions =
        new ElementDefinitions<>();
    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions2 =
        new ElementDefinitions<>();

    // Act and Assert
    assertEquals(elementDefinitions, elementDefinitions2);
    assertEquals(elementDefinitions.hashCode(), elementDefinitions2.hashCode());
  }

  /**
   * Test {@link ElementDefinitions#equals(Object)}, and {@link ElementDefinitions#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ElementDefinitions#equals(Object)}
   *   <li>{@link ElementDefinitions#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ElementDefinitions.equals(Object)",
    "int ElementDefinitions.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions =
        new ElementDefinitions<>();

    // Act and Assert
    assertEquals(elementDefinitions, elementDefinitions);
    int expectedHashCodeResult = elementDefinitions.hashCode();
    assertEquals(expectedHashCodeResult, elementDefinitions.hashCode());
  }

  /**
   * Test {@link ElementDefinitions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ElementDefinitions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ElementDefinitions.equals(Object)",
    "int ElementDefinitions.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions =
        new ElementDefinitions<>();

    // Act and Assert
    assertNotEquals(elementDefinitions, null);
  }

  /**
   * Test {@link ElementDefinitions#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ElementDefinitions#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ElementDefinitions.equals(Object)",
    "int ElementDefinitions.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ElementDefinitions<ElementDefinition, ElementDefinition> elementDefinitions =
        new ElementDefinitions<>();

    // Act and Assert
    assertNotEquals(elementDefinitions, "Different type to ElementDefinitions");
  }
}
