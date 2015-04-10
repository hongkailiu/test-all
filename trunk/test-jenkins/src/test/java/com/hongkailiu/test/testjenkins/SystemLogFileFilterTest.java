/*
 * The MIT License
 *
 * Copyright 2013 Mirko Friedenhagen.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.hongkailiu.test.testjenkins;

import com.hongkailiu.test.testjenkins.util.JenkinsUtil;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 *
 * @author hongkai
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(JenkinsUtil.class)
public class SystemLogFileFilterTest {

	@Rule
	public TemporaryFolder folder= new TemporaryFolder();
	
	private File logFolder = null;
	private File someFolder = null;
	private File file1 = null;
	private File file2 = null;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {


	}
	
	@Before
	public void setUp() throws Exception {
		mockStatic(JenkinsUtil.class);
		when(JenkinsUtil.getRoot()).thenReturn(folder.getRoot());

		if (logFolder==null) {
			logFolder = new File(JenkinsUtil.getRoot(), "log");
		}
		if (!logFolder.exists() || !logFolder.isDirectory()) {
			logFolder.mkdirs();
		}
		
		if (someFolder==null) {
			someFolder = new File(JenkinsUtil.getRoot(), "some");
		}
		if (!someFolder.exists() || !someFolder.isDirectory()) {
			someFolder.mkdirs();
		}
		
		file1 = new File(logFolder, "test1.xml");
		file2 = new File(someFolder, "test2.xml");

	}

    /**
     * Test of accepts method, of class NonJobsDirectoryFileFilter.
     */
    @Test
    public void testAccepts() throws IOException {
        assertTrue(SystemLogFileFilter.accepts(file1));
        assertFalse(SystemLogFileFilter.accepts(file2));
        assertFalse(SystemLogFileFilter.accepts(logFolder));
        assertFalse(SystemLogFileFilter.accepts(someFolder));
    }
}
