package Bus.servlets.helpers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bus.model.daos.CardDao;
import Bus.model.dto.CardByType;
import Bus.model.entities.User;
import Bus.utils.SearcherDataSource;

public class CardStatisticsByTypeHelper implements Helper{
	
	@Override
	public List<CardByType> execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		HttpSession session = req.getSession(false);
		User user = (User)session.getAttribute("user");	
		CardDao cardDao = new CardDao(SearcherDataSource.getInstance().getDataSource());
		return cardDao.getCardStatisticsByType(user); 
	}
}
