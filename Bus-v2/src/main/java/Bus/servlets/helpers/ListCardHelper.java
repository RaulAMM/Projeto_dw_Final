package Bus.servlets.helpers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bus.model.daos.CardDao;
import Bus.model.entities.Card;
import Bus.model.entities.User;
import Bus.utils.SearcherDataSource;

public class ListCardHelper implements Helper{
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession(false);
		User user = (User)session.getAttribute("user");
		CardDao cardDao = new CardDao(SearcherDataSource.getInstance().getDataSource());
		List<Card> userCards = cardDao.getCardByUser(user);
		req.setAttribute("userCard", userCards);
		return "/home.jsp";
	}
}
