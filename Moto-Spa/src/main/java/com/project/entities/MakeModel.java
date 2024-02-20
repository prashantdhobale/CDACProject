package com.project.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="make_model")
public class MakeModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	@Column(name="make_name")
	private String makeName;
	@Column(name="model_name")
	private String  modelName;
	@Column(name="vehicle_type")
	private String vehicleType;
	

	public MakeModel() {
		// TODO Auto-generated constructor stub
	}

public MakeModel(int id, String makeName, String modelName, String vehicleType) {
	super();
	this.id = id;
	this.makeName = makeName;
	this.modelName = modelName;
	this.vehicleType = vehicleType;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getMakeName() {
	return makeName;
}

public void setMakeName(String makeName) {
	this.makeName = makeName;
}

public String getModelName() {
	return modelName;
}

public void setModelName(String modelName) {
	this.modelName = modelName;
}

public String getVehicleType() {
	return vehicleType;
}

public void setVehicleType(String vehicleType) {
	this.vehicleType = vehicleType;
}

@Override
public String toString() {
	return "MakeModel [id=" + id + ", makeName=" + makeName + ", modelName=" + modelName + ", vehicleType="
			+ vehicleType + "]";
}
	
	

}
