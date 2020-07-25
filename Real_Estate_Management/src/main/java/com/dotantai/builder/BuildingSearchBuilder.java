package com.dotantai.builder;

public class BuildingSearchBuilder {
	private String name;
	private String district;
	private String buildingArea;
	private String numberOfBasement;
	
	public String getBuildingArea() {
		return buildingArea;
	}
	public String getNumberOfBasement() {
		return numberOfBasement;
	}
	public String getName() {
		return name;
	}
	public String getDistrict() {
		return district;
	}
	
	private BuildingSearchBuilder(Builder builder)
	{
		this.name = builder.name;
		this.district = builder.district;
		this.buildingArea = builder.buildingArea;
		this.numberOfBasement = builder.numberOfBasement;
	}
	
	public static class Builder{
		private String name;
		private String district;
		private String buildingArea;
		private String numberOfBasement;
		
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		
		public Builder setDistrict(String district) {
			this.district = district;
			return this;
		}
			
		
		public Builder setBuildingArea(String buildingArea) {
			this.buildingArea = buildingArea;
			return this;
		}

		public Builder setNumberOfBasement(String numberOfBasement) {
			this.numberOfBasement = numberOfBasement;
			return this;
		}

		public BuildingSearchBuilder build()
		{
			return new BuildingSearchBuilder(this);
		}
		
	}


}
