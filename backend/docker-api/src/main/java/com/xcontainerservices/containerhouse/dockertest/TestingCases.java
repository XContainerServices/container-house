package com.xcontainerservices.containerhouse.dockertest;

import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.command.ExecCreateCmdResponse;
import com.github.dockerjava.api.command.InspectContainerResponse;
import com.github.dockerjava.api.command.InspectImageResponse;
import com.github.dockerjava.api.model.Frame;
import com.github.dockerjava.api.model.StreamType;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.core.command.AttachContainerResultCallback;
import com.github.dockerjava.core.command.ExecStartResultCallback;

public class TestingCases {
	

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		 String containerName = "generated_" + new SecureRandom().nextInt();
		 DockerClientConfig dockerClientconfig = DefaultDockerClientConfig.createDefaultConfigBuilder().build();
			//DockerCmdExecFactory dockerCmdExecFactory = new JerseyDockerCmdExecFactory();
			DockerClient dockerClient = DockerClientBuilder.getInstance(dockerClientconfig).build();

			//String containerName = "generated_" + new SecureRandom().nextInt();

	        CreateContainerResponse container = dockerClient.createContainerCmd("ubuntu").withCmd("/bin/bash").withTty(true)
	                .withName(containerName).exec();
	        //LOG.info("Created container {}", container.toString());
	        //assertThat(container.getId(), not(isEmptyString()));

	        dockerClient.startContainerCmd(container.getId()).exec();

	        ExecCreateCmdResponse execCreateCmdResponse = dockerClient.execCreateCmd(container.getId())
	                .withAttachStdout(true).withCmd("touch", "/execStartTest.log").withUser("root").exec();
	        dockerClient.execStartCmd(execCreateCmdResponse.getId()).exec(
	                new ExecStartResultCallback(System.out, System.err)).awaitCompletion();

	        InputStream response = dockerClient.copyArchiveFromContainerCmd(container.getId(), "/execStartTest.log").exec();
	        //Boolean bytesAvailable = response.available() > 0;
	        //assertTrue(bytesAvailable, "The file was not copied from the container.");

	        // read the stream fully. Otherwise, the underlying stream will not be closed.
	        //String responseAsString = asString(response);
	        System.out.println("response is "+response.read());
	        //assertNotNull(responseAsString);
	        //assertTrue(responseAsString.length() > 0);
	    }



	

}
