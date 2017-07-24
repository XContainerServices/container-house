package com.xcontainerservices.containerhouse.dockerapi.images;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.xcontainerservices.containerhouse.dockerapi.dal.StoreUsersImageDetailsBase;
import com.xcontainerservices.containerhouse.dockerapi.utils.DockerClientDecl;

public class CreateImageFromTemplate {

    public CreateImageFromTemplate(String userName,
            String templateName,
            String imageName,
            String storageDomain,
            String storageName) {
        boolean imageAlreadyPresent;
        QueryForImage queryForImage = new QueryForImage();
        imageAlreadyPresent = queryForImage.isGivenImagePresent(userName, imageName);

        // If image name already exist then change the name Ex: eclipse will be changed to eclipse1, eclipse2 ...
        if (imageAlreadyPresent) {
            String newImageName = "";
            for (int i = 1; i < 1000; i++) {
                newImageName = imageName + Integer.toString(i);
                if (!queryForImage.isGivenImagePresent(userName, newImageName)) {
                    break;
                }

            }

            imageName = newImageName;
        }

        DockerClientDecl dc = new DockerClientDecl();
        DockerClient dockerClient = dc.newDockerClient();
        CreateContainerResponse container = dockerClient.createContainerCmd(templateName + ":chTemplate").exec();
        dockerClient.startContainerCmd(container.getId()).exec();
        dockerClient.commitCmd(container.getId())
                .withRepository(userName + "/" + imageName)
                .withTag("chImage")
                .exec();

        // Saving details on database
        new StoreUsersImageDetailsBase(userName,
                imageName,
                container.getId().split(":")[0],
                storageDomain,
                storageName);

        dockerClient.removeContainerCmd(container.getId()).exec();
    }

}
