package com.xcontainerservices.containerhouse.dockerapi.templates;

import java.io.File;
import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.command.BuildImageResultCallback;
import com.github.dockerjava.core.util.CompressArchiveUtil;
import com.xcontainerservices.containerhouse.dockerapi.utils.DockerClientDecl;

public class CreateTemplate {
    File dockerFilePath;

    public boolean createTemplateFromDockerFile(String dockerFilePath, String templateName) {
        this.dockerFilePath = new File(dockerFilePath);

        DockerClientDecl dc = new DockerClientDecl();
        DockerClient dockerClient = dc.newDockerClient();
        try {
            dockerClient.buildImageCmd()
                    .withNoCache(true)
                    .withTag(templateName + ":chTemplate")
                    .withDockerfile(this.dockerFilePath)
                    .exec(new BuildImageResultCallback())
                    .awaitImageId();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean buildTemplateFromTar(String tarFilePath, String templateName) {
        // This method is Under TODO List
        return false;
    }
}
