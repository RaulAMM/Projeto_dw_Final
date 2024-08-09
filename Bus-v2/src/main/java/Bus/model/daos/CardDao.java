package Bus.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import Bus.model.daos.filters.CardFilter;
import Bus.model.dto.CardByType;
import Bus.model.entities.User;
import Bus.model.daos.filters.CardFilter;
import Bus.model.entities.CardType;
import Bus.model.entities.Card;


public class CardDao {
		private DataSource dataSource;

		public CardDao(DataSource dataSource) {
			this.dataSource = dataSource;
		}

		public Boolean save(Card card) {
			String sql = "insert into Cartão (Tipo, IdCartao, Status, Saldo, NomeTitular, UsuarioCPF) values(?,?,?,?,?,?)";
			try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, card.getType().toString());
				ps.setLong(2, card.getId());
				ps.setBoolean(3, card.isStatus());
				ps.setDouble(4, card.getSaldo());
				ps.setString(5, card.getNomeTitular());
				ps.setLong(6, card.getUserCPF().getCPF());
				ps.executeUpdate();
				return true;
			} catch (SQLException sqlException) {
				throw new RuntimeException("Erro ao inserir dados", sqlException);
			}
		}

		public List<Card> getCardByUser(User user) {
			String sql = "select * from Cartão where CPF=?";
			List<Card> cards = new ArrayList<>();
			try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setLong(1, user.getCPF());
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						Card card = new Card();
						card.setId(rs.getLong(1));
						card.setType(CardType.valueOf(rs.getString(2)));
						card.setStatus(rs.getBoolean(3));
						card.setSaldo(rs.getDouble(4));
						card.setNomeTitular(rs.getString(5));
						card.setUserCPF(user);
						cards.add(card);
					}
				}
				return cards;
			} catch (SQLException sqlException) {
				throw new RuntimeException("Erro durante a consulta", sqlException);
			}
		}

		public Card getCardById(Long id) {
			String sql = "select * from Cartão where id=?";
			Card card = null;
			try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setLong(1, id);
				try (ResultSet rs = ps.executeQuery()) {
					if (rs.next()) {
						card = new Card();
						card.setId(rs.getLong(1));
						card.setType(CardType.valueOf(rs.getString(2)));
						card.setStatus(rs.getBoolean(3));
						card.setSaldo(rs.getDouble(4));
						card.setNomeTitular(rs.getString(5));
						User user = new User();
						user.setCPF(rs.getLong(6));
						card.setUserCPF(user);
					}
				}
				return card;
			} catch (SQLException sqlException) {
				throw new RuntimeException("Erro durante a consulta", sqlException);
			}
		}

		public Boolean update(Card card) {
			String sql = "update Cartão set " + "IdCartao=?," + "Status=?," + "Saldo=?," + "NomeTitular=?," + "UsuarioCPF=?,"
					+ "user_id=?" + " where id=?";
			try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setLong(1, card.getId());
				ps.setString(2, card.getType().toString());
				ps.setBoolean(3, card.isStatus());
				ps.setDouble(4, card.getSaldo());
				ps.setString(5, card.getNomeTitular());
				ps.setLong(6, card.getUserCPF().getCPF());
				ps.executeUpdate();
				return true;
			} catch (SQLException sqlException) {
				throw new RuntimeException("Erro ao atualizar dados", sqlException);
			}
		}

		public Boolean delete(Card card) {
			String sql = "delete from Cartão where id=?";
			try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setLong(1, card.getId());
				ps.executeUpdate();
				return true;
			} catch (SQLException sqlException) {
				throw new RuntimeException("Erro ao remover dados", sqlException);
			}
		}

		public List<Card> getCardByFilter(CardFilter filter) throws SQLException {
			StringBuilder sql = 
					new StringBuilder("select * from Cartão where user_id=?");
			List<Object> params = new ArrayList<>();
			params.add(filter.getUser().getCPF());

			if (filter.getType() != null) {
				sql.append(" and type=?");
				params.add(filter.getType().getType().toString());
			}

			return getCardList(sql.toString(), params, filter.getUser());
		}
		
		private List<Card> getCardList(String sql, List<Object> params,
				User user) throws SQLException {
			List<Card> card = new ArrayList<>();
			try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
				for (int i = 0; i < params.size(); i++) {
					ps.setObject(i + 1, params.get(i));
				}
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						Card cards = new Card();
						cards.setId(rs.getLong(1));
						cards.setType(CardType.valueOf(rs.getString(2)));
						cards.setUserCPF(user);
						card.add(cards);
					}
				}
			}
			return card;
		}
		
		public List<CardByType> getCardStatisticsByType(User user) {
			String sql = "select type from card where user_id=? group by type";
			List<CardByType> cards = new ArrayList<>();
			try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setLong(1, user.getCPF());
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						CardByType card = new CardByType();
						card.setType(CardType.valueOf(rs.getString(1)).getType());
						card.setCount(rs.getInt(2));
						cards.add(card);
					}
				}
				return cards;
			} catch (SQLException sqlException) {
				throw new RuntimeException("Erro durante a consulta", sqlException);
			}
		}
}
