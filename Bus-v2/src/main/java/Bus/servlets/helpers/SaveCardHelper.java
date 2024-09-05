package Bus.servlets.helpers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bus.model.daos.CardDao;
import Bus.model.entities.Card;
import Bus.model.entities.CardType;
import Bus.model.entities.User;
import Bus.utils.SearcherDataSource;

public class SaveCardHelper implements Helper{
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		Double saldo = 0.0;
		
		String id =req.getParameter("IdCartao");
		CardType type = CardType.valueOf(req.getParameter("type"));
		saldo = Double.parseDouble(req.getParameter("Saldo"));
		String nomeTitular = req.getParameter("NomeTitular");

		HttpSession session = req.getSession(false);
		User user = (User)session.getAttribute("user");
		CardDao cardDao = new CardDao(SearcherDataSource.getInstance().getDataSource());
		Card card = new Card();
		card.setType(type);
		card.setSaldo(saldo);
		card.setNomeTitular(nomeTitular);
		card.setUserCPF(user.getCPF());
		System.out.println(card.isStatus());
		if(!card.isStatus()) {
			if(cardDao.save(card)) {
				card.setStatus(true);
				req.setAttribute("result", "registered");
			}
		}else {
			card.setId(id);
			System.out.println(card.isStatus());
			if(cardDao.update(card)) {
				req.setAttribute("result", "registered");
			}
		}
		return "/Card-register.jsp";
	}

	
	

}
