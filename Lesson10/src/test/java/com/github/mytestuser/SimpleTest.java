package com.github.mytestuser;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Epics;
import io.qameta.allure.Feature;
import io.qameta.allure.Features;
import io.qameta.allure.Flaky;
import io.qameta.allure.Issue;
import io.qameta.allure.Issues;
import io.qameta.allure.Link;
import io.qameta.allure.Links;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Stories;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.String.format;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(Watcher.class)
public class SimpleTest {

    @Step("Check parameters are:")
    public void checkParametersAre(int a, int b) {
    }

    @Step("Do another step {variable}")
    public void doAnotherStep(String variable) {

    }

    @Test
    public void simpleTest() {
        checkParametersAre(1, 2);
        doAnotherStep("some string variable");
        assertThat(2, is(2));
    }

    @Test
    public void throwAnExceptionTest() {
        throw new IllegalStateException("Test exception");
    }

    @Step
    public void checkThat2is2() {
        assertThat(2, is(2));
    }

    @Test
    public void simpleTestWithSteps() {
        checkThat2is2();
    }

    @Attachment
    public String makeAttach() {
        return "Simple attachment, the method returns a string";
    }

    @Attachment
    public byte[] takeScreenShot() throws AWTException, IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(
                new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize())),
                "png",
                baos);
        baos.flush();
        byte[] imageInByte = baos.toByteArray();
        baos.close();
        return imageInByte;
    }

    @Test
    public void simpleTestWithAttachments() throws Exception {
        assertThat(2, is(2));
        makeAttach();
        takeScreenShot();
    }

    @Step("Add link to Allure Report resource")
    public static void addLinkAllure() {
        String link = "http://allure.qatools.ru/";
        Allure.addAttachment("Result", "text/plain", link);
    }

    @Test
    public void simpleTestWithAddingAttachments() {
        addLinkAllure();
    }

    @Test
    @Description(value = "The test checks the equivalence of the number 1 to the number 1")
    public void equivalenceTest() {
        assertTrue(1 == 1);
    }

    @Epic(value = "Mathematics")
    @Feature(value = "Simple operations")
    @Story(value = "Addition")
    @Test
    public void sumTest() {
        assertThat(5 + 4, is(9));
    }

    @Epic(value = "Mathematics")
    @Feature(value = "Simple operations")
    @Story(value = "Subtraction")
    @Test
    public void subTest() {
        assertThat(8 - 2, is(6));
    }

    @Epics(value = {@Epic(value = "Mathematics"), @Epic(value = "Geometry")})
    @Features(value = {@Feature(value = "Trigonometry"), @Feature(value = "Simple operations")})
    @Stories(value = {@Story(value = "Sinus"), @Story(value = "Sinusoid")})
    @Test
    public void checkSinTest() {
        assertThat(Math.sin(0), is(0));
    }

    @Test
    @Flaky
    public void testFlaky() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 2);
        if (randomNum == 0) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
    }

    @Test
    @Link(name = "Link", url = "http://yandex.ru")
    public void checkSumWithLinkTest() {
        assertThat(5 + 4, is(9));
    }

    @Test
    @Links(value = {@Link(name = "Link1", url = "http://allure.qatools.ru/"),
            @Link(name = "Link2", url = "http://yandex.ru")})
    public void checkSumWithLinksTest() {
        assertThat(5 + 4, is(9));
    }

    @Test
    @Owner(value = "Ivanov Ivan Ivanovich")
    public void testOwner() {
        assertThat(5 + 4, is(9));
    }

    @Test
    @Severity(value = SeverityLevel.BLOCKER)
    public void testSeverity() {
        assertThat(5 + 4, is(9));
    }

    @Test
    public void failedTest() {
        fail("This test should be failed");
    }

    @Test
    @Issue("ITX-123")
    @TmsLink("TRITX-123")
    public void issueTmsTest1() {
        assertTrue(1 == 1);
    }

    @Test
    @Issues({@Issue("ITX-123"), @Issue("ITX-456"), @Issue("ITX-789")})
    @TmsLink("TRITX-123")
    public void issueTmsTest2() {
        assertTrue(1 == 1);
    }



    @Attachment(value = "Sample csv attachment", type = "text/csv")
    public byte[] saveCsvAttachment() throws IOException, URISyntaxException {
        return getSampleFile("sample.csv");
    }

    @Attachment(value = "Sample svg attachment", type = "image/svg+xml")
    public byte[] saveSvgAttachment() throws IOException, URISyntaxException {
        return getSampleFile("sample.svg");
    }

    @Test()
    public void csvAttachmentTest() throws Exception {
        saveCsvAttachment();
    }

    @Test()
    public void svgAttachmentTest() throws IOException, URISyntaxException {
        saveSvgAttachment();
    }

    private byte[] getSampleFile(String fileName) throws IOException, URISyntaxException {
        URL resource = getClass().getClassLoader().getResource(fileName);
        if (resource == null) {
            fail(format("Couldn't find resource '%s'", fileName));
        }
        return Files.readAllBytes(Paths.get(resource.toURI()));
    }


// -------------------------------------------------------------------------

    @Step("Проверка разности чисел {number1} и {number2}")
    public static void checkDifferenceStep(int number1, int number2, int difference) {
        assertTrue(number1 - number2 == difference, "Результат положительный");
    }

    @Test
    public void checkDifferenceTest() {
        checkDifferenceStep(10, 5, 5);
        checkDifferenceStep(5, 4, 1);
    }

    @Attachment
    public static byte[] getBytes(String resourceName) throws IOException {
        return Files.readAllBytes(Paths.get("src/main/resources", resourceName));
    }

    @Step("Проверка эквивалентности строки {text1} строке {text2}")
    public static void checkTextEqualsStep(String text1, String text2) throws IOException {
        assertTrue(text1.equals(text2), "Текст одинаков.");
        getBytes("cat.jpeg");
        getBytes("cat.txt");
    }

    @Test
    public void checkTextEqualsTest() throws IOException {
        String text1 = "Big cat";
        String text2 = "Big cat";
        checkTextEqualsStep(text1, text2);
    }

    @Attachment(value = "Вложение", type = "txt", fileExtension = ".txt")
    public static byte[] getFileTxt(String resourceName) throws IOException {
        return Files.readAllBytes(Paths.get("src/main/resources", resourceName));
    }

    @Test
    public void getFileTxtTest() throws IOException {
        getFileTxt("testFile.txt");
    }

    @Step("addAttachment тест")
    public static void addVkLink() {
        String linkVk = "http://vk.com";
        Allure.addAttachment("Result", "text/plain", linkVk);
    }

    @Test
    public void addVkLinkTest() {
        addVkLink();
    }

    @Test
    @Description(value = "Проверка равенства двух строк")
    public void equalsTextWithDescriptionTest() {
        String text1 = "text1";
        String text2 = "text1";
        assertTrue(text1.equals(text2));
    }

    @Epic(value = "Mathematics")
    @Feature(value = "Simple operations")
    @Story(value = "Addition")
    @Test
    public void sumTest1() {
        assertThat(5 + 4, is(10));
    }

    @Epic(value = "Mathematics")
    @Feature(value = "Simple operations")
    @Story(value = "Addition")
    @Test
    public void sumTest2() {
        assertThat(5 + 4, is(9));
    }

    @Epic(value = "Mathematics")
    @Feature(value = "Simple operations")
    @Story(value = "Addition")
    @Test
    public void sumTest3() {
        assertThat(5 + 4, is(15));
    }

    @Epic(value = "Mathematics")
    @Feature(value = "Simple operations")
    @Story(value = "Subtraction")
    @Test
    public void subTest1() {
        assertThat(8 - 2, is(6));
    }

    @Epic(value = "Mathematics")
    @Feature(value = "Simple operations")
    @Story(value = "Subtraction")
    @Test
    public void subTest2() {
        assertThat(8 - 2, is(5));
    }

    @Epic(value = "Mathematics")
    @Feature(value = "Simple operations")
    @Story(value = "Subtraction")
    @Test
    public void subTest3() {
        assertThat(8 - 2, is(6));
    }

    @Epic(value = "Mathematics")
    @Feature(value = "Simple operations")
    @Story(value = "Subtraction")
    @Test
    public void subTest4() {
        assertThat(8 - 2, is(4));
    }

    @Epic(value = "Mathematics")
    @Feature(value = "Simple operations")
    @Stories(value = {@Story(value = "Subtraction"), @Story(value = "Addition")})
    @Test
    public void checkSubAndAdditionTest() {
        assertThat(20+10-30, is(0));
    }

    @Test
    @Flaky
    public void FlakyTest2() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 6);
        if (randomNum >= 3) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
    }

    @Test
    @Owner(value = "Shabalin Sergei Aleksnadrovich")
    public void OwnerTest() {
        assertThat(2*2, is(4));
    }

    @Test
    @Link(name = "Link VK", url = "http://vk.com")
    public void checkSumWithLinkTest2() {
        assertThat(5 + 4, is(9));
    }

    @Test
    @Links(value = {@Link(name = "Link VK", url = "http://vk.com"),
            @Link(name = "Link facebook", url = "http://facebook.com")})
    public void checkSumWithLinksTest2() {
        assertThat(5 + 4, is(9));
    }

    @Test
    @Severity(value = SeverityLevel.BLOCKER)
    public void testSeverity1() {
        assertThat(5 + 4, is(9));
    }
    @Test
    @Severity(value = SeverityLevel.CRITICAL)
    public void testSeverity2() {
        assertThat(5 + 4, is(9));
    }
    @Test
    @Severity(value = SeverityLevel.MINOR)
    public void testSeverity3() {
        assertThat(5 + 4, is(9));
    }
    @Test
    @Severity(value = SeverityLevel.NORMAL)
    public void testSeverity4() {
        assertThat(5 + 4, is(9));
    }
    @Test
    @Severity(value = SeverityLevel.TRIVIAL)
    public void testSeverity5() {
        assertThat(5 + 4, is(9));
    }

    @Test
    public void failedTest2() {
        fail("This test failed to");
    }

    @Test
    @Issue("ISSUE-ANNOTATION")
    @TmsLink("TmsLink")
    public void issueTmsTest3() {
        assertTrue(1 == 1);
    }

    @Test
    @Issues({@Issue("Issue-1"), @Issue("Issue-2"), @Issue("Issue-3")})
    @TmsLink("TRITX-1")
    public void issueTmsTest4() {
        assertTrue(1 == 1);
    }

    @Test
    public void csvAttachmentTest2() throws IOException, URISyntaxException {
        saveCsvAttachmentFromSample2();
    }

    @Test
    public void svgAttachmentTest2() throws Exception {
        saveSvgAttachment2();
    }

    @Attachment(value = "Sample csv attachment", type = "text/csv")
    public byte[] saveCsvAttachmentFromSample2() throws IOException, URISyntaxException {
        return getSampleFile2("sample2.csv");
    }

    @Attachment(value = "Sample svg attachment", type = "image/svg+xml")
    public byte[] saveSvgAttachment2() throws URISyntaxException, IOException {
        return getSampleFile2("sample.svg");
    }

    private byte[] getSampleFile2(String fileName) throws IOException, URISyntaxException {
        URL resource = getClass().getClassLoader().getResource(fileName);
        if (resource == null) {
            fail(format("Couldn't find resource '%s'", fileName));
        }
        return Files.readAllBytes(Paths.get(resource.toURI()));
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] getScreenShot() throws AWTException, IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(
                new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize())),
                "png",
                baos);
        baos.flush();
        byte[] imageInByte = baos.toByteArray();
        baos.close();
        return imageInByte;
    }

    @Test
    public void getScreenShotTest() throws IOException, AWTException {
        getScreenShot();
        assertTrue(1 == 1);
    }

    @Epic(value = "Broken")
    @Test
    public void BrokenTest() {
        throw new IllegalStateException("Test exception");
    }

}
