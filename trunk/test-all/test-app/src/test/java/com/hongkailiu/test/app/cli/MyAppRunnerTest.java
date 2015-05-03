package com.hongkailiu.test.app.cli;

import com.hongkailiu.test.app.util.SystemUtil;
import org.junit.*;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Created by hongkailiu on 2015-05-02.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(SystemUtil.class)
public class MyAppRunnerTest {

    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();
    private MyAppRunner unitUnderTest;

    @Before public void setUp() throws Exception {
        unitUnderTest = new MyAppRunner();
        PowerMockito.mockStatic(SystemUtil.class);

    }

    @After public void tearDown() throws Exception {

    }

    @Test(expected = IllegalArgumentException.class) public void testRunAppWithInvalidInput1() throws Exception {
        PowerMockito.when(SystemUtil.getSystemProperty("app.home")).thenReturn(testFolder.getRoot().getAbsolutePath());
        String[] args = null;
        unitUnderTest.runApp(args);
        //Assert.assertTrue(StringUtils.isEmpty(AppEnv.module));
        Assert.fail("IllegalArgumentException should occur");
    }

    @Test(expected = IllegalArgumentException.class) public void testRunAppWithInvalidInput2() throws Exception {
        PowerMockito.when(SystemUtil.getSystemProperty("app.home")).thenReturn(testFolder.getRoot().getAbsolutePath());
        String[] args = new String[]{"", ""};
        unitUnderTest.runApp(args);
        //Assert.assertTrue(StringUtils.isEmpty(AppEnv.module));
        Assert.fail("IllegalArgumentException should occur");
    }

    @Test(expected = IllegalArgumentException.class) public void testRunAppWithInvalidInput3() throws Exception {
        PowerMockito.when(SystemUtil.getSystemProperty("app.home")).thenReturn(null);
        String[] args = new String[]{"-module", "mn"};
        unitUnderTest.runApp(args);
        //Assert.assertTrue(StringUtils.isEmpty(AppEnv.module));
        Assert.fail("IllegalArgumentException should occur");
    }

    @Test(expected = IllegalArgumentException.class) public void testRunAppWithInvalidInput4() throws Exception {
        PowerMockito.when(SystemUtil.getSystemProperty("app.home")).thenReturn(testFolder.getRoot().getAbsolutePath());
        String[] args = new String[]{"-module", "mn"};
        unitUnderTest.runApp(args);
        Assert.assertEquals("mn", AppEnv.getModule());
    }

    @Test public void testRunApp() throws Exception {
        PowerMockito.when(SystemUtil.getSystemProperty("app.home")).thenReturn(testFolder.getRoot().getAbsolutePath());
        String[] args = new String[]{"-module", MyAppRunner.MODULE_WORD_COUNT};
        unitUnderTest.runApp(args);
        Assert.assertEquals(MyAppRunner.MODULE_WORD_COUNT, AppEnv.getModule());
    }
}
