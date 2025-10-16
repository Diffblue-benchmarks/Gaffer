package uk.gov.gchq.gaffer.rest.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import uk.gov.gchq.gaffer.rest.mapper.GafferExceptionMapper;

@ContextConfiguration(classes = {VersionController.class, GafferExceptionMapper.class})
@ExtendWith(SpringExtension.class)
class VersionControllerDiffblueTest {
  @Autowired private GafferExceptionMapper gafferExceptionMapper;

  @Autowired private VersionController versionController;

  /**
   * Test {@link VersionController#getGafferVersion()}.
   *
   * <p>Method under test: {@link VersionController#getGafferVersion()}
   */
  @Test
  @DisplayName("Test getGafferVersion()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String VersionController.getGafferVersion()"})
  void testGetGafferVersion() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/rest/graph/version");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(versionController)
        .setControllerAdvice(gafferExceptionMapper)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(content().string("2.3.3-SNAPSHOT"));
  }
}
