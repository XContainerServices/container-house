package com.xcontainerservices.containerhouse.dockertest;

import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.command.ExecCreateCmdResponse;
import com.github.dockerjava.api.command.InspectContainerResponse;
import com.github.dockerjava.api.command.InspectImageResponse;
import com.github.dockerjava.api.model.Frame;
import com.github.dockerjava.api.model.Image;
import com.github.dockerjava.api.model.Info;
import com.github.dockerjava.api.model.StreamType;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.core.command.AttachContainerResultCallback;
import com.github.dockerjava.core.command.ExecStartResultCallback;
import com.xcontainerservices.containerhouse.dockerapi.templates.RemoveTemplates;
import com.xcontainerservices.containerhouse.dockerapi.templates.ShowAvailableTemplates;

public class TestingCases {
	

	public static void main(String[] args) throws InterruptedException, IOException {
		/*ShowAvailableTemplates temp = new ShowAvailableTemplates();
		ArrayList arr = new ArrayList();
		arr = temp.getAllTemplates();
		System.out.println(arr);*/
		RemoveTemplates rt = new RemoveTemplates();
		boolean torf = rt.removeTemplate("codeblocks2");
		System.out.println(torf);

	    }



	

}
