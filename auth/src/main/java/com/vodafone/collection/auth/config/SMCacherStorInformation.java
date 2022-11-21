package com.vodafone.collection.auth.config;

public class SMCacherStorInformation<V> {

	V paramV;
	long LastAccessTime;

	public SMCacherStorInformation(V paramV) {
		this.paramV = paramV;
		this.LastAccessTime = System.currentTimeMillis();
	}

}
