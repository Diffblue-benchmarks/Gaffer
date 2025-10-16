package uk.gov.gchq.gaffer.named.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.named.view.DeleteNamedView.Builder;

class DeleteNamedViewDiffblueTest {
  /**
   * Test Builder {@link Builder#name(String)}.
   *
   * <p>Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName() {
    // Arrange
    Builder builder = new Builder();

    // Act
    Builder actualNameResult = builder.name("Name");

    // Assert
    assertSame(builder, actualNameResult);
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
    // Arrange and Act
    Builder actualBuilder = new Builder();

    // Assert
    DeleteNamedView _getOpResult = actualBuilder._getOp();
    assertNull(_getOpResult.getName());
    assertNull(_getOpResult.getOptions());
    DeleteNamedView actualDeleteNamedView = actualBuilder.build();
    assertSame(_getOpResult, actualDeleteNamedView);
  }

  /**
   * Test {@link DeleteNamedView#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link DeleteNamedView} (default constructor) Options is {@link HashMap#HashMap()}.
   *   <li>Then return Options Empty.
   * </ul>
   *
   * <p>Method under test: {@link DeleteNamedView#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given DeleteNamedView (default constructor) Options is HashMap(); then return Options Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeleteNamedView DeleteNamedView.shallowClone()"})
  void testShallowClone_givenDeleteNamedViewOptionsIsHashMap_thenReturnOptionsEmpty()
      throws CloneFailedException {
    // Arrange
    DeleteNamedView deleteNamedView = new DeleteNamedView();
    deleteNamedView.setOptions(new HashMap<>());

    // Act
    DeleteNamedView actualShallowCloneResult = deleteNamedView.shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getName());
    assertTrue(actualShallowCloneResult.getOptions().isEmpty());
  }

  /**
   * Test {@link DeleteNamedView#shallowClone()}.
   *
   * <ul>
   *   <li>Given {@link DeleteNamedView} (default constructor).
   *   <li>Then return Options is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeleteNamedView#shallowClone()}
   */
  @Test
  @DisplayName(
      "Test shallowClone(); given DeleteNamedView (default constructor); then return Options is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeleteNamedView DeleteNamedView.shallowClone()"})
  void testShallowClone_givenDeleteNamedView_thenReturnOptionsIsNull() throws CloneFailedException {
    // Arrange and Act
    DeleteNamedView actualShallowCloneResult = new DeleteNamedView().shallowClone();

    // Assert
    assertNull(actualShallowCloneResult.getName());
    assertNull(actualShallowCloneResult.getOptions());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DeleteNamedView}
   *   <li>{@link DeleteNamedView#setName(String)}
   *   <li>{@link DeleteNamedView#setOptions(Map)}
   *   <li>{@link DeleteNamedView#getName()}
   *   <li>{@link DeleteNamedView#getOptions()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeleteNamedView.<init>()",
    "String DeleteNamedView.getName()",
    "Map DeleteNamedView.getOptions()",
    "void DeleteNamedView.setName(String)",
    "void DeleteNamedView.setOptions(Map)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    DeleteNamedView actualDeleteNamedView = new DeleteNamedView();
    actualDeleteNamedView.setName("Name");
    HashMap<String, String> options = new HashMap<>();
    actualDeleteNamedView.setOptions(options);
    String actualName = actualDeleteNamedView.getName();
    Map<String, String> actualOptions = actualDeleteNamedView.getOptions();

    // Assert
    assertEquals("Name", actualName);
    assertTrue(actualOptions.isEmpty());
    assertSame(options, actualOptions);
  }
}
