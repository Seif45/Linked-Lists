package eg.edu.alexu.csd.datastructure.linkedList.cs34_cs40;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;

public class Polynomial implements IPolynomialSolver {

	private SinglyLinkedList listA = new SinglyLinkedList();
	private SinglyLinkedList listB = new SinglyLinkedList();
	private SinglyLinkedList listC = new SinglyLinkedList();
	private SinglyLinkedList listR = new SinglyLinkedList();
	
	public int [][] sort(int [][] terms){
		int temp [][]= new int[1][2];
        for (int i = 0; i < terms.length-1; i++) {
        	for (int j = 0; j < terms.length-i-1; j++) {
        		if (terms[j][1] > terms[j+1][1]) 
                {  
                    temp[0] = terms[j]; 
                    terms[j] = terms[j+1]; 
                    terms[j+1] = temp[0]; 
                } 
        	}
        }
        for(int i=0; i<terms.length-1; i++) {
        	if(terms[i][1]==terms[i+1][1]) {
        		terms[i][0]=terms[i][0]+terms[i+1][0];
        		for(int j = i+1; j<terms.length-1; j++) {
        			terms[j]=terms[j+1];
        		}
        		terms = Arrays.copyOf(terms, terms.length-1);
        		i=0;
        	}
        }
        for(int i=0; i<terms.length/2; i++) {
        	temp[0]=terms[i];
        	terms[i]=terms[terms.length-i-1];
        	terms[terms.length-i-1]=temp[0];
        }
        for(int i = 0; i<terms.length; i++) {
        	if(terms[i][0]==0) {
        		for(int j = i; j<terms.length-1; j++) {
        			terms[j]=terms[j+1];
        		}
        		terms = Arrays.copyOf(terms, terms.length-1);
        	}
        }
        if ((terms.length == 1)&&(terms[0][0] == 0)) {
        	terms[0][1] = 0;
        }
        return terms;
	}
	
	@Override
	public void setPolynomial(char poly, int[][] terms) {
		int i ;
		if (poly == 'A') {
			listA.clear();
			for (i = 0 ; i < terms.length ; i++) {
				listA.add(terms[i][0]);
				listA.add(terms[i][1]);
			}
		}
		else if (poly == 'B') {
			listB.clear();
			for (i = 0 ; i < terms.length ; i++) {
				listB.add(terms[i][0]);
				listB.add(terms[i][1]);
			}
		}
		else if (poly == 'C') {
			listC.clear();
			for (i = 0 ; i < terms.length ; i++) {
				listC.add(terms[i][0]);
				listC.add(terms[i][1]);
			}
		}
		else if (poly == 'R') {
			listR.clear();
			for (i = 0 ; i < terms.length ; i++) {
				listR.add(terms[i][0]);
				listR.add(terms[i][1]);
			}
		}
	}

	@Override
	public String print(char poly) {
		String out = new String();
		int i ;
		if (poly == 'A') {
			for (i = 0 ; i < listA.size() ; i+=2) {
				if ((int)listA.get(i) != 1) {
					out += listA.get(i);
				}
				if ((int)listA.get(i+1) != 0) {
					out += "X";
				}
				if (((int)listA.get(i+1) != 1) && ((int)listA.get(i+1) != 0)) {
					out += "^" + listA.get(i+1);
				}
				if (i < listA.size() - 2 )
					out += " + ";
			}
		}
		else if (poly == 'B') {
			for (i = 0 ; i < listB.size() ; i+=2) {
				if ((int)listB.get(i) != 1) {
					out += listB.get(i);
				}
				if ((int)listA.get(i+1) != 0) {
					out += "X";
				}
				if (((int)listB.get(i+1) != 1) && ((int)listB.get(i+1) != 0)) {
					out += "^" + listB.get(i+1);
				}
				if (i < listB.size() - 2 )
					out += " + ";
			}
		}
		else if (poly == 'C') {
			for (i = 0 ; i < listC.size() ; i+=2) {
				if ((int)listC.get(i) != 1) {
					out += listC.get(i);
				}
				if ((int)listC.get(i+1) != 0) {
					out += "X";
				}
				if (((int)listC.get(i+1) != 1) && ((int)listC.get(i+1) != 0)) {
					out += "^" + listC.get(i+1);
				}
				if (i < listC.size() - 2 )
					out += " + ";
			}
		}
		else if (poly == 'R') {
			for (i = 0 ; i < listR.size() ; i+=2) {
				if ((int)listR.get(i) != 1) {
					out += listR.get(i);
				}
				if ((int)listR.get(i+1) != 0) {
					out += "X";
				}
				if (((int)listR.get(i+1) != 1) && ((int)listR.get(i+1) != 0)) {
					out += "^" + listR.get(i+1);
				}
				if (i < listR.size() - 2 )
					out += " + ";
			}
		}
		return out;
	}

	@Override
	public void clearPolynomial(char poly) {
		if (poly == 'A') {
			listA.clear();
		}
		else if (poly == 'B') {
			listB.clear();
		}
		else if (poly == 'C') {
			listC.clear();
		}
	}

	@Override
	public float evaluatePolynomial(char poly, float value) {
		int i,j;
		float power = 1.0f;
		float result = 0.0f ;
		if (poly == 'A') {
			for (i = 0 ; i < listA.size() ; i+=2) {
				for (j = 0 ; j < (int)listA.get(i+1) ; j++) {
					power *= value;
				}
				result += (((int)(listA.get(i))) * power);
				power = 1.0f;
			}
		}
		else if (poly == 'B') {
			for (i = 0 ; i < listB.size() ; i+=2) {
				for (j = 0 ; j < (int)listB.get(i+1) ; j++) {
					power *= value;
				}
				result += (((int)(listB.get(i))) * power);
				power = 1.0f;
			}
		}
		else if (poly == 'C') {
			for (i = 0 ; i < listC.size() ; i+=2) {
				for (j = 0 ; j < (int)listC.get(i+1) ; j++) {
					power *= value;
				}
				result += (((int)(listC.get(i))) * power);
				power = 1.0f;
			}
		}
		else if (poly == 'R') {
			for (i = 0 ; i < listR.size() ; i+=2) {
				for (j = 0 ; j < (int)listR.get(i+1) ; j++) {
					power *= value;
				}
				result += (((int)(listR.get(i))) * power);
				power = 1.0f;
			}
		}

		return result;
	}

	@Override
	public int[][] add(char poly1, char poly2) {
		if((poly1=='A' && poly2=='B') || (poly2=='A' && poly1=='B')) {
			int index=0;
			int n= (listA.size()+listB.size())/2;
			int result[][]= new int [n][2];
			for (int i= 0; i< listA.size() ; i+=2 ) {
				int n1=(int) listA.get(i);
				int n3=(int) listA.get(i+1);
				result[index][0]= n1;
				result[index][1]= n3;
				index++;
			}
			for(int j = 0; j<listB.size(); j+=2) {
				int n2=(int) listB.get(j);
				int n4=(int) listB.get(j+1);
				result[index][0]= n2;
				result[index][1]= n4;
				index++;
			}
			result=sort(result);
			setPolynomial('R',result);
			return result;
		}
		else if((poly1=='A' && poly2=='C') || (poly2=='A' && poly1=='C')) {
			int index=0;
			int n= (listA.size()+listC.size())/2;
			int result[][]= new int [n][2];
			for (int i= 0; i< listA.size() ; i+=2 ) {
				int n1=(int) listA.get(i);
				int n3=(int) listA.get(i+1);
				result[index][0]= n1;
				result[index][1]= n3;
				index++;
			}
			for(int j = 0; j<listC.size(); j+=2) {
				int n2=(int) listC.get(j);
				int n4=(int) listC.get(j+1);
				result[index][0]= n2;
				result[index][1]= n4;
				index++;
			}
			result=sort(result);
			setPolynomial('R',result);
			return result;
		}
		else if((poly1=='B' && poly2=='C') || (poly2=='B' && poly1=='C')) {
			int index=0;
			int n= (listB.size()+listC.size())/2;
			int result[][]= new int [n][2];
			for (int i= 0; i< listB.size() ; i+=2 ) {
				int n1=(int) listB.get(i);
				int n3=(int) listB.get(i+1);
				result[index][0]= n1;
				result[index][1]= n3;
				index++;
			}
			for(int j = 0; j<listC.size(); j+=2) {
				int n2=(int) listC.get(j);
				int n4=(int) listC.get(j+1);
				result[index][0]= n2;
				result[index][1]= n4;
				index++;
			}
			result=sort(result);
			setPolynomial('R',result);
			return result;
		}
		else {
			return null;
		}
	}
		
	@Override
	public int[][] subtract(char poly1, char poly2) {
		if((poly1=='A' && poly2=='B')) {
			int index=0;
			int n= (listA.size()+listB.size())/2;
			int result[][]= new int [n][2];
			for (int i= 0; i< listA.size() ; i+=2 ) {
				int n1=(int) listA.get(i);
				int n3=(int) listA.get(i+1);
				result[index][0]= n1;
				result[index][1]= n3;
				index++;
			}
			for(int j = 0; j<listB.size(); j+=2) {
				int n2=(int) listB.get(j);
				int n4=(int) listB.get(j+1);
				result[index][0]= -n2;
				result[index][1]= n4;
				index++;
			}
			result=sort(result);
			setPolynomial('R',result);
			return result;
		}
		else if((poly1=='A' && poly2=='C')) {
			int index=0;
			int n= (listA.size()+listC.size())/2;
			int result[][]= new int [n][2];
			for (int i= 0; i< listA.size() ; i+=2 ) {
				int n1=(int) listA.get(i);
				int n3=(int) listA.get(i+1);
				result[index][0]= n1;
				result[index][1]= n3;
				index++;
			}
			for(int j = 0; j<listC.size(); j+=2) {
				int n2=(int) listC.get(j);
				int n4=(int) listC.get(j+1);
				result[index][0]= -n2;
				result[index][1]= n4;
				index++;
			}
			result=sort(result);
			setPolynomial('R',result);
			return result;
		}
		else if((poly1=='B' && poly2=='C')) {
			int index=0;
			int n= (listB.size()+listC.size())/2;
			int result[][]= new int [n][2];
			for (int i= 0; i< listB.size() ; i+=2 ) {
				int n1=(int) listB.get(i);
				int n3=(int) listB.get(i+1);
				result[index][0]= n1;
				result[index][1]= n3;
				index++;
			}
			for(int j = 0; j<listC.size(); j+=2) {
				int n2=(int) listC.get(j);
				int n4=(int) listC.get(j+1);
				result[index][0]= -n2;
				result[index][1]= n4;
				index++;
			}
			result=sort(result);
			setPolynomial('R',result);
			return result;
		}
		else if((poly2=='A' && poly1=='B')) {
			int index=0;
			int n= (listA.size()+listB.size())/2;
			int result[][]= new int [n][2];
			for (int i= 0; i< listA.size() ; i+=2 ) {
				int n1=(int) listA.get(i);
				int n3=(int) listA.get(i+1);
				result[index][0]= -n1;
				result[index][1]= n3;
				index++;
			}
			for(int j = 0; j<listB.size(); j+=2) {
				int n2=(int) listB.get(j);
				int n4=(int) listB.get(j+1);
				result[index][0]= n2;
				result[index][1]= n4;
				index++;
			}
			result=sort(result);
			setPolynomial('R',result);
			return result;
		}
		else if((poly2=='A' && poly1=='C')) {
			int index=0;
			int n= (listA.size()+listC.size())/2;
			int result[][]= new int [n][2];
			for (int i= 0; i< listA.size() ; i+=2 ) {
				int n1=(int) listA.get(i);
				int n3=(int) listA.get(i+1);
				result[index][0]= -n1;
				result[index][1]= n3;
				index++;
			}
			for(int j = 0; j<listC.size(); j+=2) {
				int n2=(int) listC.get(j);
				int n4=(int) listC.get(j+1);
				result[index][0]= n2;
				result[index][1]= n4;
				index++;
			}
			result=sort(result);
			setPolynomial('R',result);
			return result;
		}
		else if((poly2=='B' && poly1=='C')) {
			int index=0;
			int n= (listB.size()+listC.size())/2;
			int result[][]= new int [n][2];
			for (int i= 0; i< listB.size() ; i+=2 ) {
				int n1=(int) listB.get(i);
				int n3=(int) listB.get(i+1);
				result[index][0]= -n1;
				result[index][1]= n3;
				index++;
			}
			for(int j = 0; j<listC.size(); j+=2) {
				int n2=(int) listC.get(j);
				int n4=(int) listC.get(j+1);
				result[index][0]= n2;
				result[index][1]= n4;
				index++;
			}
			result=sort(result);
			setPolynomial('R',result);
			return result;
		}
		else {
			return null;
		}
	}
	
	@Override
	public int[][] multiply(char poly1, char poly2) {
		if((poly1=='A' && poly2=='B') || (poly2=='A' && poly1=='B')) {
			int index=0;
			int n= (listA.size()/2*listB.size()/2);
			int result[][]= new int [n][2];
			for (int i= 0; i< listA.size()-1 ; i+=2 ) {
				for(int j = 0; j<listB.size()-1 ; j+=2) {
					int n1=(int) listA.get(i);
					int n2=(int) listB.get(j);
					int n3=(int) listA.get(i+1);
					int n4=(int) listB.get(j+1);
					result[index][0]= n1*n2;
					result[index][1]= n3+n4;
					index++;
				}
			}
			result=sort(result);
			setPolynomial('R',result);
			return result;
		}
		else if((poly1=='A' && poly2=='C') || (poly2=='A' && poly1=='C')) {
			int index=0;
			int n= (listA.size()/2*listC.size()/2);
			int result[][]= new int [n][2];
			for (int i= 0; i< listA.size()-1 ; i+=2 ) {
				for(int j = 0; j<listC.size()-1 ; j+=2) {
					int n1=(int) listA.get(i);
					int n2=(int) listC.get(j);
					int n3=(int) listA.get(i+1);
					int n4=(int) listC.get(j+1);
					result[index][0]= n1*n2;
					result[index][1]= n3+n4;
					index++;
				}
			}
			result=sort(result);
			setPolynomial('R',result);
			return result;
		}
		else if((poly1=='B' && poly2=='C') || (poly2=='B' && poly1=='C')) {
			int index=0;
			int n= (listB.size()/2*listC.size()/2);
			int result[][]= new int [n][2];
			for (int i= 0; i< listB.size()-1 ; i+=2 ) {
				for(int j = 0; j<listC.size()-1 ; j+=2) {
					int n1=(int) listB.get(i);
					int n2=(int) listC.get(j);
					int n3=(int) listB.get(i+1);
					int n4=(int) listC.get(j+1);
					result[index][0]= n1*n2;
					result[index][1]= n3+n4;
					index++;
				}
			}
			result=sort(result);
			setPolynomial('R',result);
			return result;
		}
		else {
			return null;
		}
	}
	
	public static void main(String[] args) {
		boolean Aset = false, Bset = false , Cset = false , Rset = false;
		Polynomial solver = new Polynomial();
		Scanner scan = new Scanner(System.in).useDelimiter("\r\n");
		while (true) {
			System.out.println("Please choose an action :");
			System.out.println("--------------------------");
			System.out.println("1- Set a polynomial variable");
			System.out.println("2- Print the value of a polynomial variable");
			System.out.println("3- Add two polynomials");
			System.out.println("4- Subtract two polynomials");
			System.out.println("5- Multiply two polynomials");
			System.out.println("6- Evaluate a polynomial at some point");
			System.out.println("7- Clear a polynomial variable");
			System.out.println("8- Exit");
			System.out.println("===========================================================================================================");
			String line;
			char poly;
			int choice;
			int l = 0 ,i ,counter = 0, j = 0 ;
			line = scan.next();
			while((!line.equals("1"))&&(!line.equals("2"))&&(!line.equals("3"))&&(!line.equals("4"))&&(!line.equals("5"))&&(!line.equals("6"))&&(!line.equals("7"))&&(!line.equals("8"))) {
					System.out.println("Please insert a valid number from 1-8");
					line = scan.next();
			}
			choice = Character.getNumericValue(line.charAt(0));
			if (choice == 1) {
				System.out.println("Insert the variable name: A, B or C");
				line = scan.next();
				while ((!line.equals("A"))&&(!line.equals("B"))&&(!line.equals("C"))) {
					System.out.println("Please enter a valid name from A, B or C");
					line = scan.next();
				}
				poly = line.charAt(0);
				System.out.println("Insert the polynomial terms in the form:");
				System.out.println("(coeff1, exponent1), (coeff2, exponent2), ..");
				line = scan.next();
				for (i = 0 ; i < line.length() ; i++) {
					if (line.charAt(i)=='(') {
						counter++;
					}
				}
				int digitsCounter = 0 ;
				int pow = 1;
				int k = 0,n = 0;
				int terms[][] = new int[counter][2];
				for (i = 0 ; i < line.length() ; i++) {
					if (Character.isDigit(line.charAt(i))) {
						for (k = i ; k < line.length() ; k++) {
							if (Character.isDigit(line.charAt(k))) {
								digitsCounter++;
							}
							else {
								break;
							}
						}
						for (n = digitsCounter-1 ; n >= 0 ; n--) {
							terms[l][j] += (Character.getNumericValue(line.charAt(i+n))*pow);
							pow*=10;
						}
						pow = 1;
						digitsCounter = 0;
						if (line.charAt(i-1) == '-') {
							terms[l][j] = -terms[l][j];
						}
						if (j==0) {
							j = 1;
						}
						else if (j==1) {
							j = 0;
							l++;
						}
						i = k;
					}
				}
				int [][] sorted = solver.sort(terms);
				solver.setPolynomial(poly, sorted);
				System.out.println("Polynomial " + poly + " is set");
				System.out.println();
				if (poly == 'A') {
					Aset = true;
				}
				else if (poly == 'B') {
					Bset = true;
				}
				else if (poly == 'C') {
					Cset = true;
				}
				System.out.println("===========================================================================================================");
				System.out.println();
			}
			else if (choice == 2) {
				System.out.println("Insert the variable name: A, B, C or R");
				line = scan.next();
				while (true) {
					if ((!line.equals("A"))&&(!line.equals("B"))&&(!line.equals("C"))&&(!line.equals("R"))) {
						System.out.println("Please enter a valid name from A, B, C or R");
						line = scan.next();
					}
					else if ((line.equals("A") && !Aset) || (line.equals("B") && !Bset) || (line.equals("C") && !Cset) || (line.equals("R") && !Rset)) {
						System.out.println("Polynomial " + line + " is not set yet");
						System.out.println("Insert the variable name: A, B, C or R");
						line = scan.next();
					}
					else {
						break;
					}
				}
				poly = line.charAt(0);
				System.out.print("Value in " + poly + ": ");
				System.out.println(solver.print(poly));
				System.out.println("===========================================================================================================");
				System.out.println();
			}
			else if (choice == 3) {
				System.out.println("Insert first operand variable name: A, B or C");
				line = scan.next();
				while (true) {
					if ((!line.equals("A"))&&(!line.equals("B"))&&(!line.equals("C"))) {
						System.out.println("Please enter a valid name from A, B or C");
						line = scan.next();
					}
					else if ((line.equals("A") && !Aset) || (line.equals("B") && !Bset) || (line.equals("C") && !Cset)) {
						System.out.println("Polynomial " + line + " is not set yet");
						System.out.println("Insert the variable name: A, B or C");
						line = scan.next();
					}
					else {
						break;
					}
				}
				char poly1 = line.charAt(0);
				System.out.println("Insert second operand variable name: A, B or C");
				line = scan.next();
				while (true) {
					if ((!line.equals("A"))&&(!line.equals("B"))&&(!line.equals("C"))) {
						System.out.println("Please enter a valid name from A, B or C");
						line = scan.next();
					}
					else if ((line.equals("A") && !Aset) || (line.equals("B") && !Bset) || (line.equals("C") && !Cset)) {
						System.out.println("Polynomial " + line + " is not set yet");
						System.out.println("Insert the variable name: A, B or C");
						line = scan.next();
					}
					else {
						break;
					}
				}
				char poly2 = line.charAt(0);
				int[][] add = solver.add(poly1, poly2);
				System.out.print("Result set in R: ");
				for (i = 0 ; i < add.length ; i++) {
					if (i == add.length -1) {
						System.out.print("(" + add[i][0] + ", " + add[i][1] + ")");
					}
					else {
						System.out.print("(" + add[i][0] + ", " + add[i][1] + "), ");
					}
				}
				System.out.println();
				System.out.println("===========================================================================================================");
				System.out.println();
				Rset = true;
			}
			else if (choice == 4) {
				System.out.println("Insert first operand variable name: A, B or C");
				line = scan.next();
				while (true) {
					if ((!line.equals("A"))&&(!line.equals("B"))&&(!line.equals("C"))) {
						System.out.println("Please enter a valid name from A, B or C");
						line = scan.next();
					}
					else if ((line.equals("A") && !Aset) || (line.equals("B") && !Bset) || (line.equals("C") && !Cset)) {
						System.out.println("Polynomial " + line + " is not set yet");
						System.out.println("Insert the variable name: A, B or C");
						line = scan.next();
					}
					else {
						break;
					}
				}
				char poly1 = line.charAt(0);
				System.out.println("Insert second operand variable name: A, B or C");
				line = scan.next();
				while (true) {
					if ((!line.equals("A"))&&(!line.equals("B"))&&(!line.equals("C"))) {
						System.out.println("Please enter a valid name from A, B or C");
						line = scan.next();
					}
					else if ((line.equals("A") && !Aset) || (line.equals("B") && !Bset) || (line.equals("C") && !Cset)) {
						System.out.println("Polynomial " + line + " is not set yet");
						System.out.println("Insert the variable name: A, B or C");
						line = scan.next();
					}
					else {
						break;
					}
				}
				char poly2 = line.charAt(0);
				int[][] subtract = solver.subtract(poly1, poly2);
				System.out.print("Result set in R: ");
				for (i = 0 ; i < subtract.length ; i++) {
					if (i == subtract.length -1) {
						System.out.print("(" + subtract[i][0] + ", " + subtract[i][1] + ")");
					}
					else {
						System.out.print("(" + subtract[i][0] + ", " + subtract[i][1] + "), ");
					}
				}
				System.out.println();
				System.out.println("===========================================================================================================");
				System.out.println();
				Rset = true;
			}
			else if (choice == 5) {
				System.out.println("Insert first operand variable name: A, B or C");
				line = scan.next();
				while (true) {
					if ((!line.equals("A"))&&(!line.equals("B"))&&(!line.equals("C"))) {
						System.out.println("Please enter a valid name from A, B or C");
						line = scan.next();
					}
					else if ((line.equals("A") && !Aset) || (line.equals("B") && !Bset) || (line.equals("C") && !Cset)) {
						System.out.println("Polynomial " + line + " is not set yet");
						System.out.println("Insert the variable name: A, B or C");
						line = scan.next();
					}
					else {
						break;
					}
				}
				char poly1 = line.charAt(0);
				System.out.println("Insert second operand variable name: A, B or C");
				line = scan.next();
				while (true) {
					if ((!line.equals("A"))&&(!line.equals("B"))&&(!line.equals("C"))) {
						System.out.println("Please enter a valid name from A, B or C");
						line = scan.next();
					}
					else if ((line.equals("A") && !Aset) || (line.equals("B") && !Bset) || (line.equals("C") && !Cset)) {
						System.out.println("Polynomial " + line + " is not set yet");
						System.out.println("Insert the variable name: A, B or C");
						line = scan.next();
					}
					else {
						break;
					}
				}
				char poly2 = line.charAt(0);
				int[][] multiply = solver.multiply(poly1, poly2);
				System.out.print("Result set in R: ");
				for (i = 0 ; i < multiply.length ; i++) {
					if (i == multiply.length -1) {
						System.out.print("(" + multiply[i][0] + ", " + multiply[i][1] + ")");
					}
					else {
						System.out.print("(" + multiply[i][0] + ", " + multiply[i][1] + "), ");
					}
				}
				System.out.println();
				System.out.println("===========================================================================================================");
				System.out.println();
				Rset = true;
			}
			else if (choice == 6) {
				System.out.println("Insert the variable name: A, B, C or R");
				line = scan.next();
				while (true) {
					if ((!line.equals("A"))&&(!line.equals("B"))&&(!line.equals("C"))&&(!line.equals("R"))) {
						System.out.println("Please enter a valid name from A, B, C or R");
						line = scan.next();
					}
					else if ((line.equals("A") && !Aset) || (line.equals("B") && !Bset) || (line.equals("C") && !Cset) || (line.equals("R") && !Rset)) {
						System.out.println("Polynomial " + line + " is not set yet");
						System.out.println("Insert the variable name: A, B, C or R");
						line = scan.next();
					}
					else {
						break;
					}
				}
				poly = line.charAt(0);
				System.out.println("Insert the point");
				float value = scan.nextFloat();
				System.out.print("The value of " + poly + " at the point " + value + " = ");
				System.out.println(solver.evaluatePolynomial(poly, value));
				System.out.println("===========================================================================================================");
				System.out.println();
			}
			else if (choice == 7) {
				System.out.println("Insert the variable name: A, B or C");
				line = scan.next();
				while (true) {
					if ((!line.equals("A"))&&(!line.equals("B"))&&(!line.equals("C"))) {
						System.out.println("Please enter a valid name from A, B or C");
						line = scan.next();
					}
					else if ((line.equals("A") && !Aset) || (line.equals("B") && !Bset) || (line.equals("C") && !Cset)) {
						System.out.println("Polynomial " + line + " is not set yet");
						System.out.println("Insert the variable name: A, B or C");
						line = scan.next();
					}
					else {
						break;
					}
				}
				poly = line.charAt(0);
				if (poly == 'A') {
					Aset = false;
				}
				else if (poly == 'B') {
					Bset = false;
				}
				else if (poly == 'C') {
					Cset = false;
				}
				solver.clearPolynomial(poly);
				System.out.println("The variable "+ poly + "is clear");
				System.out.println("===========================================================================================================");
				System.out.println();
			}
			else if (choice == 8) {
				System.out.println("Thank you");
				System.out.println("===========================================================================================================");
				break;
			}
		}
		scan.close();
	}
	
	@Test
	public void test1() {
		Polynomial test = new Polynomial();
		test.setPolynomial('A',new int[][] {{1,1},{1,0}});
		test.setPolynomial('B',new int[][] {{1,1},{-1,0}});
		assertArrayEquals(new int [][] {{1,2},{-1,0}}, test.multiply('A', 'B'));
		assertArrayEquals(new int [][] {{2,1}}, test.add('A', 'B'));
		assertArrayEquals(new int [][] {{2,0}}, test.subtract('A', 'B'));
	}

	@Test
	public void test2() {
		Polynomial test = new Polynomial();
		test.setPolynomial('A',new int[][] {{3,1},{2,0}});
		test.setPolynomial('B',new int[][] {{4,2},{-7,1},{5,0}});
		assertArrayEquals(new int [][] {{12,3},{-13,2},{1,1},{10,0}}, test.multiply('A', 'B'));
		assertArrayEquals(new int [][] {{4,2},{-4,1},{7,0}}, test.add('A', 'B'));
		assertArrayEquals(new int [][] {{-4,2},{10,1},{-3,0}}, test.subtract('A', 'B'));
	}
	
	@Test
	public void test3() {
		Polynomial test = new Polynomial();
		test.setPolynomial('A',new int[][] {{-7,1},{5,0},{4,2}});
		test.setPolynomial('B',new int[][] {{-5,0},{7,1},{-4,2}});
		assertArrayEquals(new int [][] {{-16,4},{56,3},{-89,2},{70,1},{-25,0}}, test.multiply('A', 'B'));
		assertArrayEquals(new int[][] {{0,0}}, test.add('A', 'B'));
	}
}
