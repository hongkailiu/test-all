package com.hongkailiu.test.testjenkins.util;

import hudson.model.FreeStyleProject;

import java.io.IOException;
import java.util.List;

import jenkins.model.Jenkins;

public class JenkinsUtil {

	public static FreeStyleProject createFreeStyleProject(String name)
			throws IOException {
		FreeStyleProject proj = Jenkins.getInstance().createProject(
				FreeStyleProject.class, name);
		return proj;
	}

	public static void buildFreeStyleProject(FreeStyleProject freeStyleProject) {
		// try 1: does not work
		// StaplerRequest req = Stapler.getCurrentRequest();
		// StaplerResponse rsp = Stapler.getCurrentResponse();
		// TimeDuration delay = TimeDuration.fromString("0");
		// freeStyleProject.doBuild(req, rsp, delay);

		// try 2: does not work
		// FreeStyleBuild freeStyleBuild = new FreeStyleBuild(freeStyleProject);
		// freeStyleBuild.run();

		Jenkins.getInstance().getQueue().schedule(freeStyleProject);
	}
	
	public static boolean isFreeStyleProjectExsted(FreeStyleProject freeStyleProject) {
		// by name
		List<FreeStyleProject>  list = Jenkins.getInstance().getItems(FreeStyleProject.class);
		if (list!=null){
			for (FreeStyleProject project : list) {
				if (freeStyleProject.getDisplayName()!=null && freeStyleProject.getDisplayName().equals(project.getDisplayName())){
					return true;
				}
			}
		}
		return false;
	}
	
	public static void deleteProject(FreeStyleProject freeStyleProject) throws IOException, InterruptedException {
		if (freeStyleProject!=null){
			freeStyleProject.delete();
		}
	}

}
