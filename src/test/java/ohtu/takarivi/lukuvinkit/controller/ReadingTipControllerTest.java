package ohtu.takarivi.lukuvinkit;

import ohtu.takarivi.lukuvinkit.domain.CustomUser;
import ohtu.takarivi.lukuvinkit.domain.ReadingTip;
import org.junit.Test;
import org.springframework.security.core.userdetails.UserDetails;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ReadingTipControllerTest extends SpringBootTestControllerBase {

    @Test
    public void deleteReadingTipRedirectIfAuthorized() throws Exception {
        UserDetails user = userDetailsService.loadUserByUsername("user1");
        CustomUser cu = customUserRepository.findByUsername("user1");
        ReadingTip tip = readingTipRepository.findByCustomUserId(cu.getId()).get(0);
        mvc.perform(post("/readingTips/delete/{id}", tip.getId()).with(csrf()).with(user(user)))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    public void deleteReadingTipForbiddenIfNotAuthorized() throws Exception {
        UserDetails user = userDetailsService.loadUserByUsername("user2");
        CustomUser cu = customUserRepository.findByUsername("user1");
        ReadingTip tip = readingTipRepository.findByCustomUserId(cu.getId()).get(0);
        mvc.perform(post("/readingTips/delete/{id}", tip.getId()).with(csrf()).with(user(user)))
                .andExpect(status().isForbidden());
    }

}
