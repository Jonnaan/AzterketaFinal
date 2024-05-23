package modelo;

public class Perro extends Mascota {
	
	
	

	
	private String raza;
	private boolean pulgas;
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public boolean isPulgas() {
		return pulgas;
	}
	public void setPulgas(boolean pulgas) {
		this.pulgas = pulgas;
	}
	public void setId(int id)
	{
		this.id = id; 
	}
	@Override
	public String toString() {
		String texto = "P," + id + "," + nombre + "," + edad+ "," + raza + ",";
		if(pulgas)
			texto+= "S";
		else
			texto+= "N";
		texto += "," + dni ;
		
		return texto;
	}
	public Perro(int id, String nombre, int edad, String dni,String raza, boolean pulgas) throws Exception {
		super(id,nombre,edad,dni);
		this.raza = raza;
		this.pulgas = pulgas;
	}
	public Perro() {
		//su TODO Auto-generated constructor stub
		
	}
	
}
