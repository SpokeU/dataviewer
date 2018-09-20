package com.madlad.dataviewer.query;

import java.util.List;
import java.util.stream.Collectors;

import org.bson.Document;

public class MongoDocumentResult extends QueryResult<List<Document>> {

	public MongoDocumentResult(List<Document> result) {
		super(result);
		type = Type.JSON;
	}

	@Override
	public String asString() {
		return result.stream().map(item -> item.toJson()).collect(Collectors.toList()).toString();
	}

}
