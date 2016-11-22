/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica;

/**
 *
 * @author Aileen
 */
public class RomanNumeralConverter {

   private static char[] alfabeto = {'I','V','X','L','C','D','M'};
	private static int[]  valores =  { 1,  5,  10, 50, 100,500,1000};
	private static int posicion = 0;

	
	public static int convert(String entrada){
		String miNumero = entrada.trim().replace(" ", "").toUpperCase();
		int valor = 0;
		int peso = 0;
		int pesoAnterior = 0;
		if(validate(miNumero)){
			for(int i = miNumero.length()-1;i>=0;i--){
				char actual = miNumero.charAt(i);
				peso = getPeso(actual);
				if(peso > pesoAnterior){
					valor = valor+valores[posicion];
					pesoAnterior = peso;
				}
				else if(peso == pesoAnterior){
					valor = valor+valores[posicion];
				}
				else if(peso < pesoAnterior){
					if(peso%2 == 0){
						throw new IllegalArgumentException();
					}
					else{
						if(pesoAnterior - peso >2){
							throw new IllegalArgumentException();
						}
					}
					valor = valor-valores[posicion];
					pesoAnterior = peso;
				}
			}
			return valor;
		}
		else{
			return 0;
		}
	}

	private static boolean validate(String numero) {
		for(int i = 0; i< numero.length();i++){
			if(!contains(numero.charAt(i)))
				throw new IllegalArgumentException();			
		}
		if(numero.contains("VV"))
			throw new IllegalArgumentException();
		
		if(numero.contains("LL"))
			throw new IllegalArgumentException();
		
		if(numero.contains("DD"))
			throw new IllegalArgumentException();
		
		if(numero.contains("IIII"))
			throw new IllegalArgumentException();
		
		if(numero.contains("XXXX"))
			throw new IllegalArgumentException();
		
		if(numero.contains("CCCC"))
			throw new IllegalArgumentException();
		
		if(numero.contains("MMMM"))
			throw new IllegalArgumentException();
		
		return true;
	}
	
	private static boolean contains(char numero){
		for(int i = 0; i< alfabeto.length;i++){
			if(numero == alfabeto[i]){
				return true;
			}
		}
		return false;
	}
	
	private static int getPeso(char numero){
		int peso = 1;
		for(int i = 0; i< alfabeto.length;i++){
			if(numero == alfabeto[i]){
				posicion = i;
				return peso;
			}
			else{
				peso++;
			}
		}
		return 0;
	}


}
