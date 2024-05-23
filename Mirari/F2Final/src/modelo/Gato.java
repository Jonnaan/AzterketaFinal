package modelo;

public class Gato extends Mascota {
	private String color;
	private char pelo;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public char getPelo() {
		return pelo;
	}
	public void setPelo(char pelo) throws Exception {
		if(pelo != 'C' &&pelo != 'L' && pelo != 'M' )
			throw new Exception("Largura incorrecta");
		else
			
		this.pelo = pelo;
	}
	
	public void setId(int id)
	{
		this.id = id; 
	}
	
	@Override
	public String toString() {
		return "G," + id + "," + nombre + "," + edad+ "," + color + "," + pelo
				+ "," + dni ;
	}
	
	public Gato(int id, String nombre, int edad, String dni,String color, char pelo) throws Exception {
		super(id, nombre, edad, dni);
		setPelo(pelo);
		this.color = color;
		// TODO Auto-generated constructor stub
	}
	public Gato() {
		System.out.println("dfaf");
	}

}
