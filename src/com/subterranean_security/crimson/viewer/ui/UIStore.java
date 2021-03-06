package com.subterranean_security.crimson.viewer.ui;

import com.subterranean_security.crimson.viewer.ui.screen.generator.GenDialog;
import com.subterranean_security.crimson.viewer.ui.screen.netman.NetMan;
import com.subterranean_security.crimson.viewer.ui.screen.netman.auth.CreateGroup;
import com.subterranean_security.crimson.viewer.ui.screen.netman.auth.CreatePassword;
import com.subterranean_security.crimson.viewer.ui.screen.netman.listener.AddListener;
import com.subterranean_security.crimson.viewer.ui.screen.users.UserMan;

/**
 * Provides storage for UI components that should exist only once
 */
public enum UIStore {
	;

	public static GenDialog genDialog;
	public static NetMan netMan;
	public static UserMan userMan;
	public static AddListener EAddListener;

	public static CreateGroup ECreateGroup;
	public static CreatePassword ECreatePassword;

}
