package uk.gov.gchq.gaffer.store.operation.add;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.store.operation.add.AddSchemaToLibrary.Builder;
import uk.gov.gchq.gaffer.store.schema.Schema;

class AddSchemaToLibraryDiffblueTest {
  /**
   * Test Builder {@link Builder#id(String)}.
   *
   * <p>Method under test: {@link Builder#id(String)}
   */
  @Test
  @DisplayName("Test Builder id(String)")
  @Tag("MaintainedByDiffblue")
  void testBuilderId() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualIdResult = builder.id("42");

    // Assert
    assertSame(builder, actualIdResult);
  }

  /**
   * Test Builder new {@link Builder} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Builder}
   */
  @Test
  @DisplayName("Test Builder new Builder (default constructor)")
  @Tag("MaintainedByDiffblue")
  void testBuilderNewBuilder() {
    // Arrange and Act
    Builder actualBuilder = new Builder();

    // Assert
    AddSchemaToLibrary _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.getId());
    assertNull(_getOpResult.getParentSchemaIds());
    assertNull(_getOpResult.getOptions());
    assertNull(_getOpResult.getSchema());
    AddSchemaToLibrary actualAddSchemaToLibrary = actualBuilder.build();
    assertSame(_getOpResult, actualAddSchemaToLibrary);
  }

  /**
   * Test Builder {@link Builder#parentSchemaIds(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#parentSchemaIds(List)}
   */
  @Test
  @DisplayName(
      "Test Builder parentSchemaIds(List) with 'List'; given '42'; when ArrayList() add '42'")
  @Tag("MaintainedByDiffblue")
  void testBuilderParentSchemaIdsWithList_given42_whenArrayListAdd42() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<String> parentSchemaIds = new ArrayList<>();
    parentSchemaIds.add("42");
    parentSchemaIds.add("foo");

    // Act
    Builder actualParentSchemaIdsResult = builder.parentSchemaIds(parentSchemaIds);

    // Assert
    assertSame(builder, actualParentSchemaIdsResult);
  }

  /**
   * Test Builder {@link Builder#parentSchemaIds(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#parentSchemaIds(List)}
   */
  @Test
  @DisplayName(
      "Test Builder parentSchemaIds(List) with 'List'; given 'foo'; when ArrayList() add 'foo'")
  @Tag("MaintainedByDiffblue")
  void testBuilderParentSchemaIdsWithList_givenFoo_whenArrayListAddFoo() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<String> parentSchemaIds = new ArrayList<>();
    parentSchemaIds.add("foo");

    // Act
    Builder actualParentSchemaIdsResult = builder.parentSchemaIds(parentSchemaIds);

    // Assert
    assertSame(builder, actualParentSchemaIdsResult);
  }

  /**
   * Test Builder {@link Builder#parentSchemaIds(List)} with {@code List}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#parentSchemaIds(List)}
   */
  @Test
  @DisplayName("Test Builder parentSchemaIds(List) with 'List'; when ArrayList()")
  @Tag("MaintainedByDiffblue")
  void testBuilderParentSchemaIdsWithList_whenArrayList() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualParentSchemaIdsResult = builder.parentSchemaIds(new ArrayList<>());

    // Assert
    assertSame(builder, actualParentSchemaIdsResult);
  }

  /**
   * Test Builder {@link Builder#parentSchemaIds(String[])} with {@code String[]}.
   *
   * <p>Method under test: {@link Builder#parentSchemaIds(String[])}
   */
  @Test
  @DisplayName("Test Builder parentSchemaIds(String[]) with 'String[]'")
  @Tag("MaintainedByDiffblue")
  void testBuilderParentSchemaIdsWithString() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualParentSchemaIdsResult = builder.parentSchemaIds("Parent Schema Ids");

    // Assert
    assertSame(builder, actualParentSchemaIdsResult);
  }

  /**
   * Test Builder {@link Builder#schema(Schema)}.
   *
   * <p>Method under test: {@link Builder#schema(Schema)}
   */
  @Test
  @DisplayName("Test Builder schema(Schema)")
  @Tag("MaintainedByDiffblue")
  void testBuilderSchema() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualSchemaResult = builder.schema(new Schema());

    // Assert
    assertSame(builder, actualSchemaResult);
  }

  /**
   * Test {@link AddSchemaToLibrary#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link AddSchemaToLibrary} (default constructor) Options is {@link
   *       HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link AddSchemaToLibrary#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given AddSchemaToLibrary (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_givenAddSchemaToLibraryOptionsIsHashMap_thenReturnOptionsEmpty()
      throws CloneFailedException {
    // Arrange
    AddSchemaToLibrary addSchemaToLibrary = new AddSchemaToLibrary();
    addSchemaToLibrary.setOptions(new HashMap<>());

    // Act
    AddSchemaToLibrary actualShallowCloneResult = addSchemaToLibrary.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getId());
    assertNull(actualShallowCloneResult.getParentSchemaIds());
    assertNull(actualShallowCloneResult.getSchema());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
  }

  /**
   * Test {@link AddSchemaToLibrary#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link AddSchemaToLibrary} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AddSchemaToLibrary#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given AddSchemaToLibrary (default constructor); then return Options is 'null'")
  @Tag("MaintainedByDiffblue")
  void testShallowClone_givenAddSchemaToLibrary_thenReturnOptionsIsNull()
      throws CloneFailedException {
    // Arrange and Act
    AddSchemaToLibrary actualShallowCloneResult = new AddSchemaToLibrary().shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getId());
    assertNull(actualShallowCloneResult.getParentSchemaIds());
    assertNull(actualShallowCloneResult.getOptions());
    assertNull(actualShallowCloneResult.getSchema());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link AddSchemaToLibrary}
   *   <li>{@link AddSchemaToLibrary#setId(String)}
   *   <li>{@link AddSchemaToLibrary#setOptions(Map)}
   *   <li>{@link AddSchemaToLibrary#setParentSchemaIds(List)}
   *   <li>{@link AddSchemaToLibrary#setSchema(Schema)}
   *   <li>{@link AddSchemaToLibrary#getId()}
   *   <li>{@link AddSchemaToLibrary#getOptions()}
   *   <li>{@link AddSchemaToLibrary#getParentSchemaIds()}
   *   <li>{@link AddSchemaToLibrary#getSchema()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  void testGettersAndSetters() {
    // Arrange and Act
    AddSchemaToLibrary actualAddSchemaToLibrary = new AddSchemaToLibrary();
    actualAddSchemaToLibrary.setId("42");
    HashMap<String, String> options = new HashMap<>();
    actualAddSchemaToLibrary.setOptions(options);
    ArrayList<String> parentSchemaIds = new ArrayList<>();
    actualAddSchemaToLibrary.setParentSchemaIds(parentSchemaIds);
    Schema schema = new Schema();
    actualAddSchemaToLibrary.setSchema(schema);
    String actualId = actualAddSchemaToLibrary.getId();
    Map<String, String> actualOptions = actualAddSchemaToLibrary.getOptions();
    List<String> actualParentSchemaIds = actualAddSchemaToLibrary.getParentSchemaIds();
    Schema actualSchema = actualAddSchemaToLibrary.getSchema();

    // Assert
    assertEquals("42", actualId);
    assertTrue(actualParentSchemaIds.isEmpty());
    assertTrue(actualOptions.isEmpty());
    assertSame(parentSchemaIds, actualParentSchemaIds);
    assertSame(options, actualOptions);
    assertSame(schema, actualSchema);
  }
}
