package com.xcontainerservices.containerhouse.dockerapi.images;

import java.util.List;

import com.github.dockerjava.api.model.Image;
import com.xcontainerservices.containerhouse.dockerapi.templates.ShowAvailableTemplates;

public class QueryForImage {
    int totalImages;

    public boolean isGivenImagePresent(String userName, String imageName) {
        ShowAvailableTemplates listOfImages = new ShowAvailableTemplates();
        List<Image> imagesList = listOfImages.getTemplateImages();
        totalImages = imagesList.size();
        if (totalImages == 0) {
            return false;
        }

        for (int i = 1; i <= totalImages; i++) {
            Image img = imagesList.get(i - 1);
            String repoAndTag = img.getRepoTags()[0];
            if (repoAndTag.split(":")[1].equals("chImage") && repoAndTag.split(":")[0].equals(userName+"/"+imageName)) {
                return true;
            }

        }

        return false;
    }
}
