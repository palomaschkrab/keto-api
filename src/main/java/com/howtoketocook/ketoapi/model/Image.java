package com.howtoketocook.ketoapi.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Image {
	private long id;
	private String url;
}
