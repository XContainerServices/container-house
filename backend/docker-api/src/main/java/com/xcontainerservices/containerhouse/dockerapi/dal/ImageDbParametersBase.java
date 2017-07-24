package com.xcontainerservices.containerhouse.dockerapi.dal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ImageDetails")
public class ImageDbParametersBase {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int uid;
    private String username;
    private String imageName;
    private String imageId;
    private String storgeDomainName;
    private String storageName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getStorgeDomainName() {
        return storgeDomainName;
    }

    public void setStorgeDomainName(String storgeDomainName) {
        this.storgeDomainName = storgeDomainName;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

}
