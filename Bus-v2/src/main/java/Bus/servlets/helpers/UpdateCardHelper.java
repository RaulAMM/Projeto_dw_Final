package Bus.servlets.helpers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bus.model.daos.CardDao;
import Bus.model.entities.Card;
import Bus.utils.SearcherDataSource;

public class UpdateCardHelper implements Helper{
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String cardId = req.getParameter("card-id");
			
		CardDao cardDao = new CardDao(SearcherDataSource.getInstance().getDataSource());
		Card card = cardDao.getCardById(cardId); 
		if(card != null) {
			req.setAttribute("Cartão", card);	
		}
		return "/card.jsp";
	}
}
