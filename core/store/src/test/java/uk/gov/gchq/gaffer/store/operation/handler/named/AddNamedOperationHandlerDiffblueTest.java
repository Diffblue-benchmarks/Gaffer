package uk.gov.gchq.gaffer.store.operation.handler.named;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.store.operation.handler.named.cache.NamedOperationCache;

class AddNamedOperationHandlerDiffblueTest {
  /**
   * Test {@link AddNamedOperationHandler#AddNamedOperationHandler(String, Boolean)}.
   *
   * <p>Method under test: {@link AddNamedOperationHandler#AddNamedOperationHandler(String,
   * Boolean)}
   */
  @Test
  @DisplayName("Test new AddNamedOperationHandler(String, Boolean)")
  @Tag("MaintainedByDiffblue")
  void testNewAddNamedOperationHandler() {
    // Arrange and Act
    AddNamedOperationHandler actualAddNamedOperationHandler =
        new AddNamedOperationHandler("Suffix Named Operation Cache Name", true);

    // Assert
    assertEquals(
        "suffix named operation cache name", actualAddNamedOperationHandler.getSuffixCacheName());
    assertTrue(actualAddNamedOperationHandler.isNestedNamedOperationsAllowed());
  }

  /**
   * Test {@link AddNamedOperationHandler#AddNamedOperationHandler(String, Boolean)}.
   *
   * <ul>
   *   <li>Then return not NestedNamedOperationsAllowed.
   * </ul>
   *
   * <p>Method under test: {@link AddNamedOperationHandler#AddNamedOperationHandler(String,
   * Boolean)}
   */
  @Test
  @DisplayName(
      "Test new AddNamedOperationHandler(String, Boolean); then return not NestedNamedOperationsAllowed")
  @Tag("MaintainedByDiffblue")
  void testNewAddNamedOperationHandler_thenReturnNotNestedNamedOperationsAllowed() {
    // Arrange and Act
    AddNamedOperationHandler actualAddNamedOperationHandler =
        new AddNamedOperationHandler("Suffix Named Operation Cache Name", false);

    // Assert
    assertEquals(
        "suffix named operation cache name", actualAddNamedOperationHandler.getSuffixCacheName());
    assertFalse(actualAddNamedOperationHandler.isNestedNamedOperationsAllowed());
  }

  /**
   * Test {@link AddNamedOperationHandler#AddNamedOperationHandler(NamedOperationCache, Boolean)}.
   *
   * <ul>
   *   <li>Then return not NestedNamedOperationsAllowed.
   * </ul>
   *
   * <p>Method under test: {@link
   * AddNamedOperationHandler#AddNamedOperationHandler(NamedOperationCache, Boolean)}
   */
  @Test
  @DisplayName(
      "Test new AddNamedOperationHandler(NamedOperationCache, Boolean); then return not NestedNamedOperationsAllowed")
  @Tag("MaintainedByDiffblue")
  void testNewAddNamedOperationHandler_thenReturnNotNestedNamedOperationsAllowed2() {
    // Arrange and Act
    AddNamedOperationHandler actualAddNamedOperationHandler =
        new AddNamedOperationHandler(
            new NamedOperationCache("Suffix Named Operation Cache Name"), false);

    // Assert
    assertEquals(
        "suffix named operation cache name", actualAddNamedOperationHandler.getSuffixCacheName());
    assertFalse(actualAddNamedOperationHandler.isNestedNamedOperationsAllowed());
  }

  /**
   * Test {@link AddNamedOperationHandler#AddNamedOperationHandler(String, Boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return SuffixCacheName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AddNamedOperationHandler#AddNamedOperationHandler(String,
   * Boolean)}
   */
  @Test
  @DisplayName(
      "Test new AddNamedOperationHandler(String, Boolean); when 'null'; then return SuffixCacheName is 'null'")
  @Tag("MaintainedByDiffblue")
  void testNewAddNamedOperationHandler_whenNull_thenReturnSuffixCacheNameIsNull() {
    // Arrange and Act
    AddNamedOperationHandler actualAddNamedOperationHandler =
        new AddNamedOperationHandler((String) null, true);

    // Assert
    assertNull(actualAddNamedOperationHandler.getSuffixCacheName());
    assertTrue(actualAddNamedOperationHandler.isNestedNamedOperationsAllowed());
  }

  /**
   * Test {@link AddNamedOperationHandler#AddNamedOperationHandler(NamedOperationCache, Boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return NestedNamedOperationsAllowed.
   * </ul>
   *
   * <p>Method under test: {@link
   * AddNamedOperationHandler#AddNamedOperationHandler(NamedOperationCache, Boolean)}
   */
  @Test
  @DisplayName(
      "Test new AddNamedOperationHandler(NamedOperationCache, Boolean); when 'true'; then return NestedNamedOperationsAllowed")
  @Tag("MaintainedByDiffblue")
  void testNewAddNamedOperationHandler_whenTrue_thenReturnNestedNamedOperationsAllowed() {
    // Arrange and Act
    AddNamedOperationHandler actualAddNamedOperationHandler =
        new AddNamedOperationHandler(
            new NamedOperationCache("Suffix Named Operation Cache Name"), true);

    // Assert
    assertEquals(
        "suffix named operation cache name", actualAddNamedOperationHandler.getSuffixCacheName());
    assertTrue(actualAddNamedOperationHandler.isNestedNamedOperationsAllowed());
  }

  /**
   * Test {@link AddNamedOperationHandler#isNestedNamedOperationsAllowed()}.
   *
   * <p>Method under test: {@link AddNamedOperationHandler#isNestedNamedOperationsAllowed()}
   */
  @Test
  @DisplayName("Test isNestedNamedOperationsAllowed()")
  @Tag("MaintainedByDiffblue")
  void testIsNestedNamedOperationsAllowed() {
    // Arrange, Act and Assert
    assertTrue(
        new AddNamedOperationHandler("Suffix Named Operation Cache Name", true)
            .isNestedNamedOperationsAllowed());
  }

  /**
   * Test {@link AddNamedOperationHandler#getSuffixCacheName()}.
   *
   * <ul>
   *   <li>Then return {@code suffix named operation cache name}.
   * </ul>
   *
   * <p>Method under test: {@link AddNamedOperationHandler#getSuffixCacheName()}
   */
  @Test
  @DisplayName("Test getSuffixCacheName(); then return 'suffix named operation cache name'")
  @Tag("MaintainedByDiffblue")
  void testGetSuffixCacheName_thenReturnSuffixNamedOperationCacheName() {
    // Arrange, Act and Assert
    assertEquals(
        "suffix named operation cache name",
        new AddNamedOperationHandler("Suffix Named Operation Cache Name", true)
            .getSuffixCacheName());
  }
}
