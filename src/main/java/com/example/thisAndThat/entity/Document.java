package com.example.thisAndThat.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class Document {
	private int id;
	private String title;
	private String content;
}
