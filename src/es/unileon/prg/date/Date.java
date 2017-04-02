package es.unileon.prg.date;
/**
 * Clase que representa .
 * 
 * @author Sandra Calvo Casares
 * @version 1.0
 */
public class Date {
	/**
	 * un dia del año
	 * 
	 * @see String
	 */
	private int _dia;
	/**
	 * un mes del año
	 * 
	 * @see String
	 */
	private int _mes;
	/**
	 * un año
	 */
	private int _anio;

	/**
	 * Constructor de la clase. Crea una fecha con la informacion recibida
	 *
	 */
	public Date(){
		_dia=1;
		_mes=1;
		_anio=2017;
	}
	/* Constructor de la clase con mensajes de error, si sobrepasa los valores permitidos en las variables dia, mes y año */

	
	public Date(int dia, int mes, int anio) throws DateException{
		StringBuffer mensaje = new StringBuffer();

		if(dia<=0){
			mensaje.append("No se permiten numero negativos"+dia+"\n");
		}
		if(mes<=0){
			mensaje.append("No se permiten meses negativos"+mes+"\n");
		}else{
			if(mes>12){
				mensaje.append("El numero maximo de meses es 12"+mes+"\n");
			}else{
				if(dia>this.diasDelMes(mes)){
					mensaje.append("El numero de días no es valido para ese mes"+dia+"\n");
				}
			}
		}
		if(anio<0){
			mensaje.append("El año deber ser positivo "+anio+"\n");
		}
		if(mensaje.length()!=0){
			throw new DateException(mensaje.toString());
		}else{
			this._dia=dia;
			this._mes=mes;
			this._anio=anio;
		}
	}

	/**
	 * Metodo que imprime el nombre del mes
	 * 
	 * @param _mes
	 *            
	 */
	public int getMonth() {
		return _mes;
	}
	/**
	 * Metodo que recoge el nombre del mes, y lanza excepciones en caso de cumplir con los requisitos
	 * 
	 * @param _mes
	 *            
	 */
	public void setMonth(int mes) throws DateException{
		if(mes<=0){
			throw new DateException("No puede haber un mes con valor negativo");
		}else if(mes>=12){
			throw new DateException("No puede haber un mes con un valor superior a 12");
			
		}else {
			this._mes=mes;
		}
	}
	/**
	 * Metodo que imprime el nombre del dia
	 * 
	 * @param _day
	 *            
	 */
	
	public int getDay(){
		return this._dia;
	}
	/**
	 * Metodo que recoge el nombre del dia, y en caso de sobre parar los valores permitidos para esa varible, lanza excepciones
	 * 
	 * @param _dia
	 *            
	 */
	public void setDay(int dia) throws DateException{
		if(dia<=0){
			throw new DateException("No puede haber un día menor o igual que 0");
		}else if(!this.esElDia(dia)){
			throw new DateException("El numero del mes no es correcto "+this._mes+"\n");
		}else{
			this._dia=dia;
		}
	}
	/**
	 * Metodo que imprime el nombre del anio
	 * 
	 * @param _anio
	 *            
	 */
	public int getAnio(){
		return _anio;
	}
	/**
	 * Metodo que recoge el numero del año y comprueba que sea valido, sino lanza una excepcion
	 * 
	 * @param _anio
	 *            
	 */
	public void setAnio(int anio)throws DateException{
		if(anio<0){
			throw new DateException("No esta permitido introducir años negativos"+anio+"\n");
		}else{
			this._anio=anio;
		}
	}
	
}
