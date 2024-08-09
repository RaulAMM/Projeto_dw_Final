package Bus.servlets.helpers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import Bus.model.daos.CardDao;
import Bus.model.entities.Card;
import Bus.utils.SearcherDataSource;

public class DeleteCardHelper implements Helper{
	@Override
	public JsonObject execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Long cardId = 
				Long.parseLong(req.getParameter("IdCartao"));
		Boolean response;	
		CardDao cardDao = 
				new CardDao(SearcherDataSource.getInstance().getDataSource());
		Card card = 
				cardDao.getCardById(cardId); 
		if(card != null) {
			cardDao.delete(card);
			response = true;
		}else {
			response = false;
		}
		JsonObject json = new JsonObject();
		json.addProperty("response", response);
		return json;
	}
}
