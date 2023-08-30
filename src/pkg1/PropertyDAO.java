package pkg1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pkg1.dbconnection;

public class PropertyDAO {
	dbconnection dbobj=new dbconnection();
	public int addProperty(Property property) {
        int generatedPropertyId = -1;
        Connection c= dbobj.getConnection();
        try {
            PreparedStatement sql = c.prepareStatement("INSERT INTO Property (property_Id,no_Of_Rooms, area_I_nSqft, floor_No, city, state, cost, ownerName, ownerContactno) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)");

           
			

            sql.setInt(1, property.getPropertyId());
			sql.setString(2, property.getNoOfRooms());
           sql.setDouble(3, property.getAreaInSqft());
            sql.setInt(4, property.getFloorNo());
            sql.setString(5, property.getCity());
            sql.setString(6, property.getState());
            sql.setDouble(7, property.getCost());
            sql.setString(8, property.getOwnerName());
           sql.setString(9, property.getOwnerContactNo());

            generatedPropertyId= sql.executeUpdate();

			/*
			 * if (rowsAffected > 0) {
			 * 
			 * ResultSet generatedKeys = sql.getGeneratedKeys(); if (generatedKeys.next()) {
			 * generatedPropertyId = generatedKeys.getInt(1); } }
			 */

            sql.close();
           c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return generatedPropertyId;
    }
	
	 public boolean updatePropertyCost(int propertyId, double newCost) {
	        boolean updated = false;
	        Connection c= dbobj.getConnection();

	        try  {
	            String updateQuery = "UPDATE Property SET cost = ? WHERE property_Id = ?";
	            PreparedStatement preparedStatement = c.prepareStatement(updateQuery);

	            preparedStatement.setDouble(1, newCost);
	            preparedStatement.setInt(2, propertyId);

	            int rowsAffected = preparedStatement.executeUpdate();

	            if (rowsAffected > 0) {
	                updated = true;
	                System.out.println("Property cost updated successfully.");
	            } else {
	                System.out.println("Property update failed. Property not found.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return updated;
	    }
    
    public int deleteProperty(int propertyId) {
        int rowsAffected = 0;
        Connection c=dbobj.getConnection();
        try {
            String sql = "DELETE FROM Property WHERE property_Id = ?";
            
           
            PreparedStatement preparedStatement = c.prepareStatement(sql);
            
            preparedStatement.setInt(1, propertyId);
            
            rowsAffected = preparedStatement.executeUpdate();
            
            preparedStatement.close();
          c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowsAffected;
    }
    
    public List<Property> searchByCity(String city) {
        List<Property> properties = new ArrayList<>();
        Connection c=dbobj.getConnection();
        try {
            String sql = "SELECT * FROM Property WHERE city = ?";
            
           
            PreparedStatement preparedStatement = c.prepareStatement(sql);
            
            preparedStatement.setString(1, city);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                Property property = new Property(
                    resultSet.getInt("property_Id"),
                    resultSet.getString("no_Of_Rooms"),
                    resultSet.getDouble("area_I_nSqft"),
                    resultSet.getInt("floor_No"),
                    resultSet.getString("city"),
                    resultSet.getString("state"),
                    resultSet.getDouble("cost"),
                    resultSet.getString("ownerName"),
                    resultSet.getString("ownerContactno")
                );
                
                properties.add(property);
            }
            
            resultSet.close();
            preparedStatement.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return properties;
    }
    
    public List<Property> showAllProperties() {
        List<Property> properties = new ArrayList<>();
        Connection c=dbobj.getConnection();
        try {
            String sql = "SELECT * FROM Property";
            
           
            PreparedStatement preparedStatement = c.prepareStatement(sql);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                Property property = new Property(
                    resultSet.getInt("property_Id"),
                    resultSet.getString("no_Of_Rooms"),
                    resultSet.getDouble("area_I_nSqft"),
                    resultSet.getInt("floor_No"),
                    resultSet.getString("city"),
                    resultSet.getString("state"),
                    resultSet.getDouble("cost"),
                    resultSet.getString("ownerName"),
                    resultSet.getString("ownerContactno")
                );
                
                properties.add(property);
            }
            
            resultSet.close();
            preparedStatement.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return properties;
    }
    
    public List<Property> searchByCostRange(double minCost, double maxCost) {
        List<Property> properties = new ArrayList<>();
        Connection c=dbobj.getConnection();
        try {
            String sql = "SELECT * FROM Property WHERE cost BETWEEN ? AND ?";
            
           
            PreparedStatement preparedStatement = c.prepareStatement(sql);
            
            preparedStatement.setDouble(1, minCost);
            preparedStatement.setDouble(2, maxCost);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                Property property = new Property(
                    resultSet.getInt("property_Id"),
                    resultSet.getString("no_Of_Rooms"),
                    resultSet.getDouble("area_i_nSqft"),
                    resultSet.getInt("floor_No"),
                    resultSet.getString("city"),
                    resultSet.getString("state"),
                    resultSet.getDouble("cost"),
                    resultSet.getString("ownerName"),
                    resultSet.getString("ownerContactno")
                );
                
                properties.add(property);
            }
            
            resultSet.close();
            preparedStatement.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return properties;
    }
    
    public List<Property> searchByNoOfRoomsAndCity(String noOfRooms, String city) {
        List<Property> properties = new ArrayList<>();
        Connection c=dbobj.getConnection();
        try {
            String sql = "SELECT * FROM Property WHERE no_of_rooms = ? AND city = ?";
            
           
            PreparedStatement preparedStatement = c.prepareStatement(sql);
            
            preparedStatement.setString(1, noOfRooms);
            preparedStatement.setString(2, city);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                Property property = new Property(
                    resultSet.getInt("property_Id"),
                    resultSet.getString("no_Of_Rooms"),
                    resultSet.getDouble("area_i_nSqft"),
                    resultSet.getInt("floor_No"),
                    resultSet.getString("city"),
                    resultSet.getString("state"),
                    resultSet.getDouble("cost"),
                    resultSet.getString("ownerName"),
                    resultSet.getString("ownerContactno")
                );
                
                properties.add(property);
            }
            
            resultSet.close();
            preparedStatement.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return properties;
    }
}




