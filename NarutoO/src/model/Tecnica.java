package model;

public class Tecnica implements Comparable<Tecnica>{
	private String nombreTecnica;
	private double factorDeInfluencia;
	private Tecnica siguiente;
	
	public Tecnica(String nombreTecnica, double factorDeInfluencia, Tecnica siguiente) {
		this.nombreTecnica = nombreTecnica;
		this.factorDeInfluencia = factorDeInfluencia;
		this.siguiente = siguiente;
	}
	
	public Tecnica(String nombreTecnica, double factorDeInfluencia) {
		this.nombreTecnica = nombreTecnica;
		this.factorDeInfluencia = factorDeInfluencia;
	}

	public String getNombreTecnica() {
		return nombreTecnica;
	}

	public void setNombreTecnica(String nombreTecnica) {
		this.nombreTecnica = nombreTecnica; 
	}

	public double getFactorDeInfluencia() {
		return factorDeInfluencia;
	}

	public void setFactorDeInfluencia(double factorDeInfluencia) {
		this.factorDeInfluencia = factorDeInfluencia;
	}

	public Tecnica getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Tecnica siguiente) {
		this.siguiente = siguiente;
	}

	@Override
	public String toString() {
		return "Tecnica [nombreTecnica=" + nombreTecnica + ", factorDeInfluencia=" + factorDeInfluencia + "]";
	}
	
	public int compararPorNombre(String nombre) {
		return nombreTecnica.compareTo(nombre);
	}

	@Override
	public int compareTo(Tecnica arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	

	
	
}
