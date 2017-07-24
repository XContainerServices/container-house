package com.xcontainerservices.containerhouse.dockertest;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.model.Info;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;
import com.xcontainerservices.containerhouse.dockerapi.images.CreateImageFromTemplate;

public class DockerTest {

    public static void main(String[] args) {
        new CreateImageFromTemplate("bablu", "nano", "pyqt", "dfs", "dsfsd");
        
    }

}
