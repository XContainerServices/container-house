package com.xcontainerservices.containerhouse.dockerapi.dal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "ContainerDetails" )
public class ContainerDbParametersBase {
	@Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private int uid;
	private String username;
	private String containerName;
	private String frontendName;
	private String continerId;
	private String storgeDomainName;
	private String storageName;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContainerName() {
		return containerName;
	}
	public void setContainerName(String containerName) {
		this.containerName = containerName;
	}
	public String getFrontendName() {
		return frontendName;
	}
	public void setFrontendName(String frontendName) {
		this.frontendName = frontendName;
	}
	public String getContinerId() {
		return continerId;
	}
	public void setContinerId(String continerId) {
		this.continerId = continerId;
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
