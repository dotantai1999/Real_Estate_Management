package com.dotantai.paging;

public class PageableImpl implements Pageable {

	private Integer page;
	private Integer limit;
	
	public PageableImpl(Integer page, Integer limit)
	{
		this.page = page;
		this.limit = limit;
	}
	
	@Override
	public Integer getPage() {
		return this.page;
	}

	@Override
	public Integer getOffset() {
		if (this.page != null && this.limit != null) {
			return (this.page - 1)*this.limit;			
		}
		return null;
	}

	@Override
	public Integer getLimit() {
		return this.limit;
	}
	

}
