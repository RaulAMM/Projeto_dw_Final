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
			String sql = "insert into Cartão (IdCartao, StatusCartao, Saldo, Tipo, NomeTitular, Usuario_CPF) values(?,?,?,?,?,?)";
			try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setLong(1, card.getId());
				ps.setBoolean(2, card.isStatus());
				ps.setDouble(3, card.getSaldo());
				ps.setString(4, card.getType().toString());
				ps.setString(5, card.getNomeTitular());
				ps.setString(6, card.getUserCPF().getCPF());
				ps.executeUpdate();
				return true;
			} catch (SQLException sqlException) {
				throw new RuntimeException("Erro ao inserir dados", sqlException);
			}
		}

		public List<Card> getCardByUser(User user) {
			String sql = "select * from Cartão where UsuarioCPF=?";
			List<Card> cards = new ArrayList<>();
			try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, user.getCPF());
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						Card card = new Card();
						card.setId(rs.getLong(1));
						card.setStatus(rs.getBoolean(2));
						card.setSaldo(rs.getDouble(3));
						card.setType(CardType.valueOf(rs.getString(4)));
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
			String sql = "select * from Cartão where IdCartao=?";
			Card card = null;
			try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setLong(1, id);
				try (ResultSet rs = ps.executeQuery()) {
					if (rs.next()) {
						card = new Card();
						card.setId(rs.getLong(1));
						card.setStatus(rs.getBoolean(2));
						card.setSaldo(rs.getDouble(3));
						card.setType(CardType.valueOf(rs.getString(4)));
						card.setNomeTitular(rs.getString(5));
						User user = new User();
						user.setCPF(rs.getString(6));
						card.setUserCPF(user);
					}
				}
				return card;
			} catch (SQLException sqlException) {
				throw new RuntimeException("Erro durante a consulta", sqlException);
			}
		}

		public Boolean update(Card card) {
			String sql = "update Cartão set " + "IdCartao=?," + "Status=?," + "Saldo=?,"+ "Tipo=?" + "NomeTitular=?," + "UsuarioCPF=?,"
		+ " where IdCartao=?";
			try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setLong(1, card.getId());
				ps.setBoolean(2, card.isStatus());
				ps.setDouble(3, card.getSaldo());
				ps.setString(4, card.getType().toString());
				ps.setString(5, card.getNomeTitular());
				ps.setString(6, card.getUserCPF().getCPF());
				ps.executeUpdate();
				return true;
			} catch (SQLException sqlException) {
				throw new RuntimeException("Erro ao atualizar dados", sqlException);
			}
		}

		public Boolean delete(Card card) {
			String sql = "delete from Cartão where IdCartao=?";
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
					new StringBuilder("select * from Cartão where UsuarioCPF=?");
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
			String sql = "select Tipo from Cartão where UsuarioCPF=? group by Tipo";
			List<CardByType> cards = new ArrayList<>();
			try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setString(1, user.getCPF());
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
