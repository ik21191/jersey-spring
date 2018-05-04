package com.mypack.custom;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class CustomApplication extends ResourceConfig {
	public CustomApplication() {
		packages("com.mypack.rest", "com.mypack.exception");
		register(MultiPartFeature.class);
	}
}
