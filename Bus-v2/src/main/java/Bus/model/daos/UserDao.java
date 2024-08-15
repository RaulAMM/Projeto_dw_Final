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

		String sql = "select CPF, RG, Nome, Email from Usuario where Email=? and Senha=?";
		Optional<User> optional = Optional.empty();
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, email);
			ps.setString(2, passwordEncripted);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					User user = new User();
					user.setCPF(rs.getString(1));
					user.setRG(rs.getString(2));
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
		String sql = "select CPF, RG, Nome, Email from Usuario where email=?";
		Optional<User> optional = Optional.empty();
		try(Connection conn = dataSource.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, email);
			try(ResultSet rs = ps.executeQuery()) {
				if(rs.next()) {
					User user = new User();
					user.setCPF(rs.getString(1));
					user.setRG(rs.getString(2));
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
		String sql = "insert into Usuario (CPF, RG, Nome, Email, DataNascimento, Senha) values (?,?,?,?,?,?)";
		try(Connection conn = dataSource.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, user.getCPF());
			ps.setString(2, user.getRG());
			ps.setString(3, user.getName());
			ps.setString(4, user.getEmail());
			ps.setDate(5, Date.valueOf(user.getDateOfBirth()));
			ps.setString(6, user.getPassword());
			ps.executeUpdate();
		}catch (SQLException e) {
			throw new RuntimeException("Erro durante a consulta", e);
		}
		return true;
	}

}
