package Bus.model.entities;

public enum CardType {
	Escolar("Escolar"),
	Padrao("Padrao"),
	Empresarial("Empresarial");
	
	private String type;
	
	CardType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
}
