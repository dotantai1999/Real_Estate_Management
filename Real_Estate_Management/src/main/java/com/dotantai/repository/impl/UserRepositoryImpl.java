/*
 * package com.dotantai.repository.impl;
 * 
 * import java.sql.Connection; import java.sql.PreparedStatement; import
 * java.sql.ResultSet; import java.sql.SQLException; import java.util.ArrayList;
 * import java.util.List;
 * 
 * import com.dotantai.dto.UserDTO; import
 * com.dotantai.repository.IUserRepository;
 * 
 * public class UserRepositoryImpl implements IUserRepository{ public
 * List<UserDTO> findALL() { List<UserDTO> results = new ArrayList<>();
 * Connection connection = null; PreparedStatement statement = null; ResultSet
 * resultSet = null;
 * 
 * String sql = "select * from user";
 * 
 * 
 * try { connection = EntityManagerFactory.getConnection(); statement =
 * connection.prepareStatement(sql); resultSet = statement.executeQuery();
 * 
 * while(resultSet.next()) { UserDTO userDTO = new UserDTO();
 * userDTO.setUsername(resultSet.getString("username"));
 * userDTO.setPassword(resultSet.getString("password"));
 * userDTO.setFullname(resultSet.getString("fullname"));
 * userDTO.setStatus(resultSet.getInt("status"));
 * 
 * results.add(userDTO);
 * 
 * return results; }
 * 
 * } catch (SQLException e) { return null; } finally { try { if(connection !=
 * null) { connection.close(); }
 * 
 * if(statement != null) {
 * 
 * statement.close(); }
 * 
 * if(resultSet != null) { resultSet.close(); }
 * 
 * } catch (SQLException e) {
 * 
 * }
 * 
 * 
 * }
 * 
 * return results; }
 * 
 * }
 */