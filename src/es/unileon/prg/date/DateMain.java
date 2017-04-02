package es.unileon.prg.date;

public class MainDate{

	public static void main(String [] args)throws DateException{
		Date fecha = new Date();
		System.out.println(fecha);
		int dia = 5;
		int mes = 6;
 		int anio = 1994;
		Date fecha2 = new Date(dia,mes,anio);
		fecha2.setDay(5);
		fecha2.setMonth(6);
		fecha2.setAnio(1994);
		System.out.println("La fecha de tu cumpleaños es: "+fecha2);
		Date fecha3 = new Date(6,7,2017);
		System.out.println("La fecha 3 es:"+fecha3);
	}
}
