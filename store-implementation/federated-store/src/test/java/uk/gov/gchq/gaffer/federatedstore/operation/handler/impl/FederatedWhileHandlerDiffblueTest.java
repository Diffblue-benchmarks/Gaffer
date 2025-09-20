package uk.gov.gchq.gaffer.federatedstore.operation.handler.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import uk.gov.gchq.gaffer.federatedstore.operation.AddGraph;
import uk.gov.gchq.gaffer.operation.Operation;
import uk.gov.gchq.gaffer.operation.impl.While;

class FederatedWhileHandlerDiffblueTest {
  /**
   * Test {@link FederatedWhileHandler#getOperationFromWhile(While)}.
   *
   * <ul>
   *   <li>Given {@link AddGraph} (default constructor).
   *   <li>Then return {@link AddGraph}.
   * </ul>
   *
   * <p>Method under test: {@link FederatedWhileHandler#getOperationFromWhile(While)}
   */
  @Test
  @DisplayName(
      "Test getOperationFromWhile(While); given AddGraph (default constructor); then return AddGraph")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Operation FederatedWhileHandler.getOperationFromWhile(While)"})
  void testGetOperationFromWhile_givenAddGraph_thenReturnAddGraph() {
    // Arrange
    FederatedWhileHandler federatedWhileHandler = new FederatedWhileHandler();

    While aWhile = new While();
    aWhile.setOperation(new AddGraph());

    // Act
    Operation actualOperationFromWhile = federatedWhileHandler.getOperationFromWhile(aWhile);

    // Assert
    assertTrue(actualOperationFromWhile instanceof AddGraph);
    assertNull(((AddGraph) actualOperationFromWhile).getGraphId());
    assertNull(((AddGraph) actualOperationFromWhile).getParentPropertiesId());
    assertNull(((AddGraph) actualOperationFromWhile).getParentSchemaIds());
    assertNull(actualOperationFromWhile.getOptions());
    assertNull(((AddGraph) actualOperationFromWhile).getProperties());
    assertNull(((AddGraph) actualOperationFromWhile).getGraphAuths());
    assertNull(((AddGraph) actualOperationFromWhile).getReadAccessPredicate());
    assertNull(((AddGraph) actualOperationFromWhile).getWriteAccessPredicate());
    assertNull(((AddGraph) actualOperationFromWhile).getStoreProperties());
    assertNull(((AddGraph) actualOperationFromWhile).getSchema());
    assertFalse(((AddGraph) actualOperationFromWhile).getIsPublic());
    assertFalse(((AddGraph) actualOperationFromWhile).isUserRequestingAdminUsage());
  }

  /**
   * Test new {@link FederatedWhileHandler} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link FederatedWhileHandler}
   */
  @Test
  @DisplayName("Test new FederatedWhileHandler (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FederatedWhileHandler.<init>()"})
  void testNewFederatedWhileHandler() {
    // Arrange, Act and Assert
    assertEquals(1000, new FederatedWhileHandler().getMaxRepeats());
  }
}
