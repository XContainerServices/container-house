package com.xcontainerservices.containerhouse.dockerapi.dal;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.xcontainerservices.containerhouse.utils.HibernateUtil;

public class StoreContainerDetailsBase {

    private String username;
    private String containerName;
    private String frontendName;
    private String continerId;
    private String storgeDomainName;
    private String storageName;

    public StoreContainerDetailsBase(String username,
            String containerName,
            String frontendName,
            String continerId,
            String storgeDomainName,
            String storageName) {
        this.username = username;
        this.containerName = containerName;
        this.frontendName = frontendName;
        this.continerId = continerId;
        this.storgeDomainName = storgeDomainName;
        this.storageName = storageName;
        setInDb();

    }

    private void setInDb() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        ContainerDbParametersBase container = new ContainerDbParametersBase();
        setParameters(container);
        session.save(container);
        tx.commit();
        session.close();

    }

    private void setParameters(ContainerDbParametersBase container) {
        container.setUsername(username);
        container.setContainerName(containerName);
        container.setFrontendName(frontendName);
        container.setContinerId(continerId);
        container.setStorgeDomainName(storgeDomainName);
        container.setStorageName(storageName);

    }

}
