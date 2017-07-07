package com.xcontainerservices.containerhouse.dockerapi.templates;

import java.util.ArrayList;
import java.util.List;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Image;
import com.xcontainerservices.containerhouse.dockerapi.utils.DockerClientDecl;

public class RemoveTemplates extends ShowAvailableTemplates {

    public boolean removeAllTemplate() {
        List<Image> images = getTemplateImages();
        DockerClientDecl dc = new DockerClientDecl();
        DockerClient dockerClient = dc.newDockerClient();
        totalImages = images.size();
        if (totalImages == 0) {
            return false;
        }
        for (int i = 1; i <= totalImages; i++) {
            Image img = images.get(i - 1);
            String repoAndTag = img.getRepoTags()[0];
            if (repoAndTag.split(":")[1].equals("chTemplate")) {
                dockerClient.removeImageCmd(img.getId()).exec();
            }

        }

        return true;
    }

    public boolean removeTemplate(String templateName) {
        ArrayList allTemplates = new ArrayList();
        allTemplates = getAllTemplates();
        if (!allTemplates.contains(templateName)) {
            return false;
        }

        List<Image> images = getTemplateImages();
        DockerClientDecl dc = new DockerClientDecl();
        DockerClient dockerClient = dc.newDockerClient();
        totalImages = images.size();
        for (int i = 1; i <= totalImages; i++) {
            Image img = images.get(i - 1);
            String repoAndTag = img.getRepoTags()[0];
            if (repoAndTag.split(":")[1].equals("chTemplate") && repoAndTag.split(":")[0].equals(templateName)) {
                dockerClient.removeImageCmd(img.getId()).exec();
                return true;
            }

        }

        return false;
    }

}
