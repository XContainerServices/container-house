package com.xcontainerservices.containerhouse.dockerapi.templates;

import java.util.ArrayList;
import java.util.List;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Image;
import com.xcontainerservices.containerhouse.dockerapi.utils.DockerClientDecl;

public class ShowAvailableTemplates {
    protected int totalImages;
    protected ArrayList<String> availableTemplatesList = new ArrayList<String>();

    public ArrayList<String> getAllTemplates() {

        List<Image> images = getTemplateImages();
        totalImages = images.size();
        for (int i = 1; i <= totalImages; i++) {
            Image img = images.get(i-1);
            String repoAndTag = img.getRepoTags()[0];
            /**if docker image tag is set to chTemplate then 
              it is for container-house use.**/
            if ( repoAndTag.split(":")[1].equals("chTemplate") ) {
                availableTemplatesList.add(repoAndTag.split(":")[0]);
            }

        }

        return availableTemplatesList;
    }

    public List<Image> getTemplateImages() {
    	DockerClientDecl dc = new DockerClientDecl();
        DockerClient dockerClient = dc.newDockerClient();
        List<Image> images = dockerClient.listImagesCmd().withShowAll(true).exec();
        return images;
    }

}
