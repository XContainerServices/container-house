package com.xcontainerservices.containerhouse.dockerapi.dal;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.xcontainerservices.containerhouse.utils.HibernateUtil;

public class StoreUsersImageDetailsBase {

    private String username;
    private String imageName;
    private String imageId;
    private String storgeDomainName;
    private String storageName;

    public StoreUsersImageDetailsBase(String username,
            String imageName,
            String imageId,
            String storgeDomainName,
            String storageName) {
        this.username = username;
        this.imageName = imageName;
        this.imageId = imageId;
        this.storgeDomainName = storgeDomainName;
        this.storageName = storageName;
        setInDb();

    }

    private void setInDb() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        ImageDbParametersBase container = new ImageDbParametersBase();
        setParameters(container);
        session.save(container);
        tx.commit();
        session.close();

    }

    private void setParameters(ImageDbParametersBase container) {
        container.setUsername(username);
        container.setImageName(imageName);
        container.setImageId(imageId);
        container.setStorgeDomainName(storgeDomainName);
        container.setStorageName(storageName);

    }

}
