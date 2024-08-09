package Bus.servlets.helpers;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bus.model.daos.CardDao;
import Bus.model.daos.filters.CardFilter;
import Bus.model.entities.Card;
import Bus.model.entities.CardType;
import Bus.model.entities.User;
import Bus.utils.SearcherDataSource;

public class SearchCardHelper implements Helper{
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String type = req.getParameter("type");
		CardType cardType = null;
		if(!type.isEmpty()) {
			cardType = CardType.valueOf(type);
		}
		
		HttpSession session = req.getSession(false);
		User user = (User)session.getAttribute("user");
		
		CardFilter filter = new CardFilter();
		filter.setUser(user);
		filter.setType(cardType);
		CardDao cardDao = new CardDao(SearcherDataSource.getInstance().getDataSource());
		List<Card> userCards = null;
		try {
			userCards = cardDao.getCardByFilter(filter);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("userCards", userCards);
		return "/home.jsp";
	}
}
