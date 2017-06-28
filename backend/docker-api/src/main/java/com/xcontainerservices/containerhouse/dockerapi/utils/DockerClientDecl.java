package com.xcontainerservices.containerhouse.dockerapi.utils;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;

public class DockerClientDecl {

    public DockerClient newDockerClient() {
        DockerClientConfig dockerClientconfig = DefaultDockerClientConfig.createDefaultConfigBuilder().build();
        DockerClient dockerClient = DockerClientBuilder.getInstance(dockerClientconfig).build();
        return dockerClient;

    }
}
