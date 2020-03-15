package WebAutomation;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.core.Is.is;

class BaeldungPageTest {

    private SeleniumConfig config;
    BaeldungHomePage homePage ;
    BaeldungAbout about;


    @BeforeEach
    public void setUp() {
        config = new SeleniumConfig();
        homePage = new BaeldungHomePage(config);
        about= new BaeldungAbout(config);
    }

    @Test
    public void givenHomePage_whenNavigate_thenShouldBeInStartHere() {
        homePage.navigate();
        StartHerePage startHerePage = homePage.clickOnStartHere();

        assertThat(startHerePage.getPageTitle(), is("Start Here"));
    }

    @Test
    public void givenAboutPage_whenNavigate_thenTitleMatch() {
        about.navigateTo();

        assertThat(about.getPageTitle(), is("About Baeldung"));
    }
}