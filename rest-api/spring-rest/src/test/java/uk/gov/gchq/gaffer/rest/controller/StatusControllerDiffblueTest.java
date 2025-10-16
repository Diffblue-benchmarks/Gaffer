package uk.gov.gchq.gaffer.rest.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import uk.gov.gchq.gaffer.core.exception.GafferRuntimeException;
import uk.gov.gchq.gaffer.rest.factory.GraphFactory;
import uk.gov.gchq.gaffer.rest.mapper.GafferExceptionMapper;

@ContextConfiguration(classes = {StatusController.class, GafferExceptionMapper.class})
@ExtendWith(SpringExtension.class)
class StatusControllerDiffblueTest {
  @Autowired private GafferExceptionMapper gafferExceptionMapper;

  @MockBean private GraphFactory graphFactory;

  @Autowired private StatusController statusController;

  /**
   * Test {@link StatusController#getStatus()}.
   *
   * <p>Method under test: {@link StatusController#getStatus()}
   */
  @Test
  @DisplayName("Test getStatus()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"uk.gov.gchq.gaffer.rest.SystemStatus StatusController.getStatus()"})
  void testGetStatus() throws Exception {
    // Arrange
    when(graphFactory.getGraph()).thenThrow(new GafferRuntimeException("An error occurred"));

    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/rest/graph/status");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(statusController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isInternalServerError())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string(
                    "{\"statusCode\":500,\"status\":\"Internal Server Error\",\"simpleMessage\":\"Unable to create graph.\",\"detailMessage"
                        + "\":null}"));
  }
}
