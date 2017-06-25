package com.xcontainerservices.containerhouse.dockertest;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.model.Info;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;
public class DockerTest {

	public static void main(String[] args) {
		DockerClientConfig dockerClientconfig = DefaultDockerClientConfig.createDefaultConfigBuilder().build();
		//DockerCmdExecFactory dockerCmdExecFactory = new JerseyDockerCmdExecFactory();
		DockerClient dockerClient = DockerClientBuilder.getInstance(dockerClientconfig).build();
		Info info = dockerClient.infoCmd().exec();
		System.out.println(info);
		
		//create container
		CreateContainerResponse container = dockerClient.createContainerCmd("ubuntu")
				.withCmd("ps", "-aux", "|", "grep", "l")
				.exec();
		
		System.out.println(container.getId());
		System.out.println("Hello from container");
		dockerClient.startContainerCmd(container.getId()).exec();
		//dockerClient.close();
	}

}
