//Diego Martinez
package lab7p1_diegomartinez;

import java.util.Scanner;
import java.security.SecureRandom;
import javax.swing.JOptionPane;

public class Lab7P1_DiegoMartinez {

    static Scanner read = new Scanner(System.in);
    static SecureRandom random=new SecureRandom();
    
    public static void main(String[] args) {
        int opcion;
        do{
            opcion=menu();
            switch(opcion){
                case 1:{
                    System.out.println("Opcion 1: Portrait");
                    System.out.println("Ingrese el numero de filas que desea: ");
                    int row=read.nextInt();
                    System.out.println("Ingrese el numero de columnas que desea: ");
                    int col=read.nextInt();
                    while(row==col){
                        System.out.println("La matriz no puede ser cuadrada.");
                        System.out.println("Ingrese numero de Filas: ");
                        row=read.nextInt();
                        System.out.println("Ingrese el numero de Columnas: ");
                        col=read.nextInt();
                    }//End While
                    int [][] a1=new int[row][col];
                    a1=read(row,col);
                    JOptionPane.showMessageDialog(null, "Arreglo 1: \n"+print(a1)+"\n"
                    + "La matriz rotada es: \n"+print(portrait(a1)));
                }break;
                case 2:{
                    System.out.println("Opcion 2: Numero magico");
                    System.out.println("Ingrese el numero de filas que desea: ");
                    int row=read.nextInt();
                    System.out.println("Ingrese el numero de columnas que desea: ");
                    int col=read.nextInt();
                    while(row==col){
                        System.out.println("La matriz no puede ser cuadrada.");
                        System.out.println("Ingrese numero de Filas: ");
                        row=read.nextInt();
                        System.out.println("Ingrese el numero de Columnas: ");
                        col=read.nextInt();
                    }//End While
                    int [][] a1=new int[row][col];
                    a1=read(row,col);
                    JOptionPane.showMessageDialog(null, "Arreglo 1: \n"+print(a1)+"\n"
                    + "Op. 1: "+ summagico(a1)+"\n"
                    + "Op. 2: "+ multmagico(a1)+"\n"
                    + "El numero generado es: "+ summagico(a1)+multmagico(a1));
                }break;
                case 3:{
                    System.out.println("Opcion 3: Subsecuencia");
                    System.out.println("Ingrese su primera cadena: ");
                    read.nextLine();
                    String cad1=read.nextLine();
                    cad1=cad1.toUpperCase();
                    System.out.println("Ingrese su segunda cadena: ");
                    String cad2=read.nextLine();
                    cad2=cad2.toUpperCase();
                    String cad1g="-"+cad1;
                    String cad2g="-"+cad2;
                    JOptionPane.showMessageDialog(null, "Cadena 1: "+cad1
                    + "\nCadena 2: "+ cad2
                    + "\nMatriz Generada: \n"+print(array(cad1g,cad2g))
                    + "\nEl size de la subsecuencia mas grande es igual a: "+cadl(array(cad1g,cad2g)));
                }break;
            }//End Switch
        }//End Do
        while(opcion!=4);
    }//End Main
    
    public static int menu(){
        int opcion;
        System.out.println("");
        System.out.println("Menu");
        System.out.println("Opcion 1: Portrait");
        System.out.println("Opcion 2: Numero magico");
        System.out.println("Opcion 3: Subsecuencia");
        System.out.println("Opcion 4: Salida");
        System.out.println("Ingrese la opcion que desea: ");
        opcion=read.nextInt();
        return opcion;
    }//End Menu
    
    public static int[][] read(int row,int col){
        int[][] temp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                temp[i][j]=random.nextInt(10);
            }//End For 2
        }//End For 1
        return temp;
    }//End Read
    
    public static String print (int [][] array){
        String print="";
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    print+="["+array[i][j]+"]"+" ";
                }//End For 2
                print+="\n";
            }//End For 1
            return print;
    }//End Print
    
    public static int[][] portrait (int [][] array){
        int [][] temp = new int [array[1].length][array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                    temp[j][array.length-1-i]=array[i][j];
            }//End For 2
        }//End For 1
        return temp;
    }//End Portrait
    
    public static int summagico (int [][] array){
        int sum=0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(i==0||j==0||i==array.length-1||j==array[i].length-1){
                    sum+=array[i][j];
                }//End if
            }//End for 2
        }//End For 1
        return sum;
    }//End Zero
    
    public static int multmagico (int [][] array){
        int mult=1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(i==0||j==0||i==array.length-1||j==array[i].length-1){
                }//End if
                else{
                    mult*=array[i][j];
                }//End Else
            }//End for 2
        }//End For 1
        return mult;
    }//End Zero
    
    public static int[][] array (String c1,String c2){
        int [][]temp = new int[c1.length()][c2.length()];
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                if(c1.charAt(i)=='-' || c2.charAt(j)=='-'){
                    temp[i][j]=0;
                }//End If
                else if(c1.charAt(i)==c2.charAt(j)){
                    temp[i][j]=1+temp[i-1][j-1];
                }//End else if
                else{
                    temp[i][j]=Math.max(temp[i][j-1],temp[i-1][j]);
                }//End Else
            }//End For 2
        }//End For 1
        return temp;
    }//End Array
    
    public static int cadl(int [][] array){
        int c=0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                c=array[i][j];
            }//End For 2
        }//End For 1
        return c;
    }//End Array
    
}//End Class
