package com.nxquang.docpanel.model;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Droplet {

	int id;
	String name;
	int memory;
	int vcpus;
	int disk;
	Region region;
	Image image;
	Object kernel;
	String size_slug;
	boolean locked;
	Date created_at;
	String status;
	Object networks;
	List<Object> backup_ids;
	List<Object> snapshot_ids;
	String[] features;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMemory() {
		return memory;
	}
	public void setMemory(int memory) {
		this.memory = memory;
	}
	public int getVcpus() {
		return vcpus;
	}
	public void setVcpus(int vcpus) {
		this.vcpus = vcpus;
	}
	public int getDisk() {
		return disk;
	}
	public void setDisk(int disk) {
		this.disk = disk;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public Object getKernel() {
		return kernel;
	}
	public void setKernel(Object kernel) {
		this.kernel = kernel;
	}
	public String getSize_slug() {
		return size_slug;
	}
	public void setSize_slug(String size_slug) {
		this.size_slug = size_slug;
	}
	public boolean isLocked() {
		return locked;
	}
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Object getNetworks() {
		return networks;
	}
	public void setNetworks(Object networks) {
		this.networks = networks;
	}
	public List<Object> getBackup_ids() {
		return backup_ids;
	}
	public void setBackup_ids(List<Object> backup_ids) {
		this.backup_ids = backup_ids;
	}
	public List<Object> getSnapshot_ids() {
		return snapshot_ids;
	}
	public void setSnapshot_ids(List<Object> snapshot_ids) {
		this.snapshot_ids = snapshot_ids;
	}
	public String[] getFeatures() {
		return features;
	}
	public void setFeatures(String[] features) {
		this.features = features;
	}	
	 
}
