package Bus.model.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import javax.sql.DataSource;

import Bus.model.entities.User;
import Bus.utils.PasswordEncode;

public class UserDao {
	private DataSource dataSource;

	public UserDao(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	public Optional<User> getUserByEmailAndPassword(String email, String password) {
		String passwordEncripted = PasswordEncode.encode(password);

		String sql = "select CPF,name,email from user where Email=? and Senha=?";
		Optional<User> optional = Optional.empty();
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, email);
			ps.setString(2, passwordEncripted);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					User user = new User();
					user.setCPF(rs.getLong(1));
					user.setRG(rs.getLong(2));
					user.setName(rs.getString(3));
					user.setEmail(rs.getString(4));
					optional = Optional.of(user);
				}
			}
			return optional;
		} catch (SQLException sqlException) {
			throw new RuntimeException("Erro durante a consulta", sqlException);
		}
	}
	
	public Optional<User> getUserByEmail(String email){
		String sql = "select CPF,name,email from user where email=?";
		Optional<User> optional = Optional.empty();
		try(Connection conn = dataSource.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, email);
			try(ResultSet rs = ps.executeQuery()) {
				if(rs.next()) {
					User user = new User();
					user.setCPF(rs.getLong(1));
					user.setRG(rs.getLong(2));
					user.setName(rs.getString(3));
					user.setEmail(rs.getString(4));
					optional = Optional.of(user);
				}
			}
		}catch (SQLException e) {
			throw new RuntimeException("Erro durante a consulta", e);
		}
		return optional;
	}
	
	public Boolean save(User user){
		Optional<User> optional = getUserByEmail(user.getEmail());
		if(optional.isPresent()) {
			return false;
		}
		String sql = "insert into user (name, email, password, "
				+ "date_of_birth, gender, active) values (?,?,?,?,?,?)";
		try(Connection conn = dataSource.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setDate(4, Date.valueOf(user.getDateOfBirth()));
			ps.setBoolean(4, true);
			ps.executeUpdate();
		}catch (SQLException e) {
			throw new RuntimeException("Erro durante a consulta", e);
		}
		return true;
	}

}
