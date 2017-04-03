package es.unileon.prg1.date;
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
				if(dia>this.daysOfMonth(mes)){
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
	public Date(Date another){
		this._dia=another.getDay();
		this._mes=another.getMonth();
		this._anio=another.getYear();
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
		}else if(mes>12){
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
	public int getYear(){
		return _anio;
	}
	/**
	 * Metodo que recoge el numero del año y comprueba que sea valido, sino lanza una excepcion
	 * 
	 * @param _anio
	 *            
	 */
	public void setYear(int anio)throws DateException{
		if(anio<0){
			throw new DateException("No esta permitido introducir años negativos"+anio+"\n");
		}else{
			this._anio=anio;
		}
	}
	public Date tomorrow(){
		Date tomorrow = null;
		int dia, mes, anio;
		dia=this._dia;
		mes=this._mes;
		anio=this._anio;
		
		dia++;
		if(dia>this.daysOfMonth(mes)){
			dia=1;
			mes++;
			if(mes>12){
				mes=1;
				anio++;
			}
		}
		try{
			tomorrow=new Date(dia, mes, anio);
		}catch(Exception e){
			System.out.println("ERROR");	
		}
		return tomorrow;
	}
	/* Metodo que comprueba si es dia mayor que cero y si el dia introducido es apto para ese mes*/
	private boolean esElDia(int dia){
		return ((dia>0) && (dia<=this.daysOfMonth(this._mes)));
	}
	/*Metodo que retorna el dia del mes*/
	public int daysOfMonth(){
		return this.daysOfMonth(this._mes);
	}
	/* Metodo que devuelve el nombre del mes*/
	public String getMonthName(){
		String nom = null;
		switch (this._mes){
		case 1:
			nom = "January";
			break;
		case 2:
			nom = "February";
			break;
		case 3:
			nom = "March";
			break;
		case 4:
			nom = "April";
			break;
		case 5:
			nom = "May";
			break;
		case 6:
			nom = "June";
			break;
		case 7:
			nom = "July";
			break;
		case 8:
			nom = "August";
			break;
		case 9:
			nom = "September";
			break;
		case 10:
			nom = "October";
			break;
		case 11:
			nom = "November";
			break;
		case 12:
			nom = "December";
			break;
		}
		return nom;
	}
	/*Metodo que devuelve el numero de dias del mes*/
	private int daysOfMonth(int mes){
		int n=0;
		switch(mes){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				n=31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				n=30;
				break;
			case 2:
				n=28;
				break;
			default:
				n = -1;
				break;

		}
		return n;
	}
	/* Metodo que devuelve el nombre de la tempora del año*/
	public String getSeasonName(){
		String nom = null;
		switch (this._mes){
		case 1: // next
		case 2: // next
		case 3: 
			nom = "Winter";
			break;
		case 4: // next
		case 5: // next
		case 6:
			nom = "Spring";
			break;
		case 7: // next
		case 8: // next
		case 9:
			nom = "Summer";
			break;
		case 10: // next
		case 11: // next
		case 12:
			nom = "Autumn";
			break;
		}
		return nom;
	}
	/*Metodo que devuelve el nombre del dia*/
	private String nameOfDay(int day) {
		String dayName;
		switch (day) {
		case 1: 
			dayName = "Monday";
			break;
		case 2: 
			dayName = "Tuesday";
			break;
		case 3: 
			dayName = "Wednesday";
			break;
		case 4: 
			dayName = "Thursday";
			break;
		case 5: 
			dayName = "Friday";
			break;
		case 6: 
			dayName = "Saturday";
			break;
		case 7: 
			dayName = "Sunday";
			break;
		default:
			dayName = "Wrong day";
		}
		return dayName;
	}
	public int daysPast(){
		int result;
		result = 0;
		
		try{
			Date aux = new Date(1,1,this._anio);
		
			for ( int i = 1; i < this._mes; i++ ) {
				result += aux.daysOfMonth();
				aux.setMonth(i + 1);
			}
		} catch (DateException e){
			System.err.println("ERROR");
		}
		
		return result + this._dia - 1;
	}
	public boolean isSameDay(Date other){
		if(this._dia==other.getDay()){
			return true;
		}else{
			return false;
		}
	}
	public boolean isSameMonth(Date other){
		if(this._mes==other.getMonth()){
			return true;
		}else{
			return false;
		}
	}
	public boolean isSameYear (Date other){
		return this._anio==other.getYear();
	}
	public boolean isSame (Date other){
		return this.isSameDay(other) && this.isSameMonth(other) && this.isSameYear(other);
	}
	public String dayOfWeek(int firstOfJanuary){
		int dayNumber;
		
		dayNumber = ( daysPast() % 7 + firstOfJanuary ) % 7;
		
		return nameOfDay(dayNumber);
	}
	
	public String toString(){
		return this._dia + "/" + this._mes + "/" + this._anio;
	}
		public int numRandomTriesEqualDate(){
        int tries, d, m, y;
        tries = 0;
        
        try{
        	do{
        		m = (int) (Math.random()*12) + 1;
        		d = (int) (Math.random()*this.daysOfMonth(m) ) + 1;
        		y = this._anio;
        		tries++;
        	} while ( !this.isSame(new Date(d,m,y) ) );
		} catch (DateException e){
			System.err.println("ERROR" );
		}

        return tries;
    }
	public String getMonthsLeft(){
		Date aux = this;
		StringBuffer monthsLeft = new StringBuffer();
		
		try{
			for (int i = this._mes + 1; i <= 12; i++){
				aux.setMonth(i);
				monthsLeft.append(aux.getMonthName() + " ");
			}
		} catch (DateException e){
			System.err.println("ERROR " );
		}
		return monthsLeft.toString();
	}
	
	public String getDaysLeftOfMonth(){
		Date aux = tomorrow();
		StringBuffer daysLeft = new StringBuffer();
		
		try{
			for (int i = aux.getDay(); esElDia(i); i++) {
				aux.setDay(i);
				daysLeft.append(aux.toString() + " ");
			}
		} catch (DateException e){
			System.err.println("ERROR");
		}
		return daysLeft.toString();
	}
	
	public String getMonthsSameDays(){
		Date aux = this;
		StringBuffer months = new StringBuffer();

		try{
			for ( int i = 1; i <= 12; i++) {
				aux.setMonth(i);
				if ( aux.daysOfMonth() == this.daysOfMonth() ) {
					months.append(aux.getMonthName() + " ");
				}
			}
		} catch (DateException e){
			System.out.println("ERROR");
		}
		return months.toString();
	}
}
