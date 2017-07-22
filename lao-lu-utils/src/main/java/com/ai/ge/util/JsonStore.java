package com.ai.ge.util;

import java.util.List;

public class JsonStore {
	
	// 记录总条数
	private Long 				totalCount;
	
	// 结果集
	private List<?>				results;

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public List<?> getResults() {
		return results;
	}

	public void setResults(List<?> results) {
		this.results = results;
	}
}
