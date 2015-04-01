package com.hongkailiu.test.testjenkins.extension;

import hudson.ExtensionList;
import hudson.ExtensionPoint;
import jenkins.model.Jenkins;

public class Animal implements ExtensionPoint {
	/**
	 * All registered {@link Animal}s.
	 */
	public static ExtensionList<Animal> all() {
		Jenkins jenkins = Jenkins.getInstance();
        assert jenkins != null;
        return jenkins.getExtensionList(Animal.class);
	}
}
