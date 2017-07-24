package com.xcontainerservices.containerhouse.dockertest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.BuildImageCmd;
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
import com.github.dockerjava.core.command.BuildImageResultCallback;
import com.github.dockerjava.core.command.ExecStartResultCallback;
import com.github.dockerjava.core.command.WaitContainerResultCallback;
import com.xcontainerservices.containerhouse.dockerapi.templates.RemoveTemplates;
import com.xcontainerservices.containerhouse.dockerapi.templates.ShowAvailableTemplates;

public class TestingCases {
    
   /* private static File fileFromBuildTestResource(String resource) {
        return new File(Thread.currentThread().getContextClassLoader();
                .getResource(resource).getName());
    }*/
    public static void main(String[] args) {
        DockerClientConfig dockerClientconfig = DefaultDockerClientConfig.createDefaultConfigBuilder().build();
        // DockerCmdExecFactory dockerCmdExecFactory = new JerseyDockerCmdExecFactory();
        DockerClient dockerClient = DockerClientBuilder.getInstance(dockerClientconfig).build();
        File baseDir = new File("/home/hackintosh/Dockerfile/standard/");
        String imageId = dockerClient.buildImageCmd().withNoCache(true)
                .withTag("codeimage2:chTemplate")
                .withDockerfile(new File("/home/hackintosh/Dockerfile/standard/df"))
                .withBaseDirectory(new File("/home/hackintosh/Dockerfile/standard/"))
                .exec(new BuildImageResultCallback())
                .awaitImageId();

        InspectImageResponse inspectImageResponse = dockerClient.inspectImageCmd(imageId).exec();
        System.out.println(inspectImageResponse);
    }
	   

	

}
