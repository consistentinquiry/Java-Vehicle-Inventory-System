package models;
/** 
   * Creates vehicle type objects.
   * Can create a vehicle object with or without an ID.
   * @author John Sharkey
   * @version 1.0
   * **/
public class Vehicle
{ 
  private int vehicle_id;
  private String make; 
  private String model; 
  private int year; 
  private int price; 
  private String license_number; 
  private String colour; 
  private  int number_doors; 
  private String transmission; 
  private int mileage; 
  private String fuel_type; 
  private int engine_size; 
  private String body_style; 
  private String condition; 
  private String notes; 
  

  
public Vehicle( String make, String model, int price, int year, String license_number, String colour, int number_doors,
		String transmission, int  mileage, String fuel_type, int  engine_size, String body_style, String condition,
		 String notes)

{
	  /**
	   * Constructor for vehicle object without an ID
	   * **/
	  this.make = make;
	  this.model = model;
	  this.year = year;
	  this.price = price;
	  this.license_number = license_number;
	  this.colour = colour;
	  this.number_doors = number_doors;
	  this.transmission = transmission;
	  this.mileage = mileage;
	  this.fuel_type = fuel_type;
	  this.engine_size = engine_size;
	  this.body_style = body_style;
	  this.condition = condition;
	  this.notes = notes;
}


public Vehicle(int vehicle_id, String make, String model, int price, int year, String license_number, String colour, int number_doors,
		String transmission, int  mileage, String fuel_type, int  engine_size, String body_style, String condition,
		 String notes)

{
	  /**
	   * Constructor for vehicle object with an ID
	   * **/
	  this.vehicle_id = vehicle_id;
	  this.make = make;
	  this.model = model;
	  this.year = year;
	  this.price = price;
	  this.license_number = license_number;
	  this.colour = colour;
	  this.number_doors = number_doors;
	  this.transmission = transmission;
	  this.mileage = mileage;
	  this.fuel_type = fuel_type;
	  this.engine_size = engine_size;
	  this.body_style = body_style;
	  this.condition = condition;
	  this.notes = notes;
}

 
public Vehicle()
{
	/**
	 * Empty vehicle constructor
	 * **/
	
}

//Get and set methods 

public int getVehicle_id()
{
	return vehicle_id;
}

public void setVehicle_id(int id)
{
	vehicle_id = id;
}

public String getMake()
{
	return make;
}

public void setMake(String Make)
{
	make = Make;
}

public String getModel()
{
	return model;
}

public void setModel(String Model)
{
	model = Model;}

public int getYear()
{
	return year;
}

public void setYear(int Year)
{
	year = Year;
}

public int getPrice()
{
	return price;
}

public void setPrice(int Price)
{
	price = Price;
}

public String getLicense_number()
{
	return license_number;
}

public void setLicense_number(String License_Number)
{
	license_number = License_Number;
}

public String getColour()
{
	return colour;
}

public void setColour(String Colour)
{
	colour = Colour;
}

public int getNumber_doors()
{
	return number_doors;
}

public void setNumber_doors(int Number_doors)
{
	number_doors = Number_doors;
}

public String getTransmission()
{
	return transmission;
}

public void setTransmission(String Transmission)
{
	transmission = Transmission;
}

public int getMileage()
{
	return mileage;
}

public void setMileage(int Mileage)
{
	mileage = Mileage;
}

public String getFuel_type()
{
	return fuel_type;
}

public void setFuel_type(String Fuel_type)
{
	fuel_type = Fuel_type;
}

public int getEngine_size()
{
	return engine_size;
}

public void setEngine_size(int Engine_size)
{
	engine_size = Engine_size;
}

public String getBody_style()
{
	return body_style;
}

public void setBody_style(String Body_style)
{
	body_style = Body_style;
}

public String getCondition()
{
	return condition;
}

public void setCondition(String Condition)
{
	condition = Condition;
}

public String getNotes()
{
	return notes;
}

public void setNotes(String Notes)
{
	notes = Notes;
}


public String toString()
{
	/**
	 * Returns a string representation of vehicle object
	 * **/
	String string = 	  
	  this.vehicle_id +
	  this.make +
	  this.model +
	  this.year +
	  this.price +
	  this.license_number + 
	  this.colour +
	  this.number_doors +
	  this.transmission +
	  this.mileage +
	  this.fuel_type +
	  this.engine_size +
	  this.body_style +
	  this.condition +
	  this.notes;
	return string;
}

}