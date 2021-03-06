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

import java.io.File;
import java.io.FileFilter;

/**
 * Filters all files in jenkins' log folder 
 *
 * @author hongkai
 */
class SystemLogFileFilter implements FileFilter {

    /** Only one instance needed. */
    static final SystemLogFileFilter INSTANCE = new SystemLogFileFilter();
    
    private final static String LOG_FOLDER_NAME = "log";

    @Override
    public boolean accept(File file) {
    	//return LOG_FOLDER_NAME.equals(file.getParentFile().getName());
        return !file.isDirectory() && new File(JenkinsUtil.getRoot().getPath(),LOG_FOLDER_NAME).getAbsolutePath().equals(file.getParent());
    }

    public static boolean accepts(File file) {
        return INSTANCE.accept(file);
    }
}
