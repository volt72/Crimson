/******************************************************************************
 *                                                                            *
 *                    Copyright 2016 Subterranean Security                    *
 *                                                                            *
 *  Licensed under the Apache License, Version 2.0 (the "License");           *
 *  you may not use this file except in compliance with the License.          *
 *  You may obtain a copy of the License at                                   *
 *                                                                            *
 *      http://www.apache.org/licenses/LICENSE-2.0                            *
 *                                                                            *
 *  Unless required by applicable law or agreed to in writing, software       *
 *  distributed under the License is distributed on an "AS IS" BASIS,         *
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  *
 *  See the License for the specific language governing permissions and       *
 *  limitations under the License.                                            *
 *                                                                            *
 *****************************************************************************/
package com.subterranean_security.crimson.sv;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;

import com.subterranean_security.crimson.core.proto.net.Keylogger.KLog;

public class ClientProfile implements Serializable {

	private static final long serialVersionUID = 1L;

	private int svid;

	private String activeWindow;
	private ImageIcon country;
	private String cpuModel;
	private String cpuTemp;
	private String cpuUsage;
	private String crimsonVersion;
	private ArrayList<String> external_ip = new ArrayList<String>();
	private String hostname;
	private ArrayList<String> internal_ip = new ArrayList<String>();
	private String javaVersion;
	private String language;
	private String messagePing;
	private String monitorCount;
	private String osArch;
	private String osFamily;
	private String ramCapacity;
	private String ramUsage;
	private String timezone;
	private ArrayList<String> username = new ArrayList<String>();
	private ArrayList<Date> username_dates = new ArrayList<Date>();
	private String userStatus;
	private String virtualization;

	private KLog klog;

	public ClientProfile(int svid) {
		this.svid = svid;
	}

	public int getSvid() {
		return svid;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getUsername() {
		return username.get(username.size() - 1);
	}

	public void setUsername(String username) {
		setUsername(new Date(), username);
	}

	public void setUsername(Date date, String username) {
		this.username.add(username);
		this.username_dates.add(date);
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public String getActiveWindow() {
		return activeWindow;
	}

	public void setActiveWindow(String activeWindow) {
		this.activeWindow = activeWindow;
	}

	public ImageIcon getCountry() {
		return country;
	}

	public void setCountry(ImageIcon country) {
		this.country = country;
	}

	public String getCpuModel() {
		return cpuModel;
	}

	public void setCpuModel(String cpuModel) {
		this.cpuModel = cpuModel;
	}

	public String getCpuTemp() {
		return cpuTemp;
	}

	public void setCpuTemp(String cpuTemp) {
		this.cpuTemp = cpuTemp;
	}

	public String getCpuUsage() {
		return cpuUsage;
	}

	public void setCpuUsage(String cpu_usage) {
		this.cpuUsage = cpu_usage;
	}

	public String getCrimsonVersion() {
		return crimsonVersion;
	}

	public void setCrimsonVersion(String crimsonVersion) {
		this.crimsonVersion = crimsonVersion;
	}

	public String getJavaVersion() {
		return javaVersion;
	}

	public void setJavaVersion(String javaVersion) {
		this.javaVersion = javaVersion;
	}

	public String getMessagePing() {
		return messagePing;
	}

	public void setMessagePing(String messagePing) {
		this.messagePing = messagePing;
	}

	public String getMonitorCount() {
		return monitorCount;
	}

	public void setMonitorCount(String monitorCount) {
		this.monitorCount = monitorCount;
	}

	public String getOsArch() {
		return osArch;
	}

	public void setOsArch(String osArch) {
		this.osArch = osArch;
	}

	public String getOsFamily() {
		return osFamily;
	}

	public void setOsFamily(String osFamily) {
		this.osFamily = osFamily;
	}

	public String getRamCapacity() {
		return ramCapacity;
	}

	public void setRamCapacity(String ramCapacity) {
		this.ramCapacity = ramCapacity;
	}

	public String getRamUsage() {
		return ramUsage;
	}

	public void setRamUsage(String ramUsage) {
		this.ramUsage = ramUsage;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getVirtualization() {
		return virtualization;
	}

	public void setVirtualization(String virtualization) {
		this.virtualization = virtualization;
	}

}