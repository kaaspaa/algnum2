package classes;

import java.io.IOException;
import java.util.ArrayList;

public class Test {
	
	
	public static void test() throws IOException
	{

    	MyMatrix<Double> matrix = new MyMatrix<Double>(Double.class);
        MyMatrix<BezStraty> matrix1 = new MyMatrix<BezStraty>(BezStraty.class);
        MyMatrix<Double> matrix2 = new MyMatrix<Double>(Double.class);
        MyMatrix<Float> matrix3 = new MyMatrix<Float>(Float.class);
        MyMatrix<Double> vector = new MyMatrix<Double>(Double.class);
        MyMatrix<Float> vector1 = new MyMatrix<Float>(Float.class);
        MyMatrix<BezStraty> vector2 = new MyMatrix<BezStraty>(BezStraty.class);
        
        matrix.wczytajPlik("1");
        matrix1.wczytajPlik("1");
        matrix2.wczytajPlik("1");
        matrix3.wczytajPlik("1");
        vector.wczytajPlik("Vector");
        vector1.wczytajPlik("Vector");
        vector2.wczytajPlik("Vector");
        
        
        	
        	/*System.out.println();
	        start = System.nanoTime();
	        MyMatrix<Float> resultMatrixFloatBase = matrix3.gaussBase(matrix3,vector1);
	        resultMatrixFloatBase.printMatrix();
	        elapsedTimeMillis = System.nanoTime()-start;
	        System.out.println("czas: " + elapsedTimeMillis/10000 + " nanosekund/10000");
	        
	        System.out.println();
	        start = System.nanoTime();
	        MyMatrix<Float> resultMatrixFloatPartial = matrix3.partialChoiseGauss(matrix3,vector1);
	        resultMatrixFloatPartial.printMatrix();
	        elapsedTimeMillis = System.nanoTime()-start;
	        System.out.println("czas: " + elapsedTimeMillis/10000 + " nanosekund/10000");
	        
	        
	        System.out.println();
	        start = System.nanoTime();
	        MyMatrix<Double> resultMatrixBase = matrix.gaussBase(matrix, vector);
	        resultMatrixBase.printMatrix();
	        elapsedTimeMillis = System.nanoTime()-start;
	        System.out.println("czas: " + elapsedTimeMillis/10000 + " nanosekund/10000");
	        
	        System.out.println();
	        start = System.nanoTime();
	        MyMatrix<Double> resultMatrix = matrix.partialChoiseGauss(matrix,vector);
	        resultMatrix.printMatrix();
	        elapsedTimeMillis = System.nanoTime()-start;
	        System.out.println("czas: " + elapsedTimeMillis/10000 + " nanosekund/10000");
	        
	        
	        System.out.println();
	        start = System.nanoTime();
	        MyMatrix<BezStraty> resultMatrixM = matrix1.gaussBase(matrix1,vector2);
	        resultMatrixM.printMatrix();
	        elapsedTimeMillis = System.nanoTime()-start;
	        System.out.println("czas: " + elapsedTimeMillis/10000 + " nanosekund/10000");
			
	        System.out.println();
	        start = System.nanoTime();
	        MyMatrix<BezStraty> resultMatrix2 = matrix1.partialChoiseGauss(matrix1,vector2);
	        resultMatrix2.printMatrix();
	        elapsedTimeMillis = System.nanoTime()-start;
	        System.out.println("czas: " + elapsedTimeMillis/10000 + " nanosekund/10000");
			*/
	        
        	/*
        	matrix3.wczytajPlik("1");
        	vector1.wczytajPlik("Vector");
	        System.out.println();
	        System.out.println("FLOAT >> Test bez wyboru elementu podstawowego");
	        matrix3.matrixTimeElapsedBezWyboru(matrix3, vector1);
	        
        	matrix3.wczytajPlik("1");
        	vector1.wczytajPlik("Vector");
	        System.out.println();
	        System.out.println("FLOAT >> Test z czesciowym wyborem elementu podstawowego");
	        matrix3.matrixTimeElapsedBezWyboru(matrix3, vector1);
	        
	        matrix3.wczytajPlik("1");
        	vector1.wczytajPlik("Vector");
	        System.out.println();
	        System.out.println("FLOAT >> Test z pelnym wyborem elementu podstawowego");
	        matrix3.matrixTimeElapsedPelnyWybor(matrix3, vector1);
	       
	        matrix.wczytajPlik("1");
	        vector.wczytajPlik("Vector");
	        System.out.println();
	        System.out.println("DOUBLE >> Test bez wyboru elementu podstawowego");
	        matrix.matrixTimeElapsedBezWyboru(matrix, vector);
	        
	        matrix.wczytajPlik("1");
	        vector.wczytajPlik("Vector");
	        System.out.println();
	        System.out.println("DOUBLE >> Test z czesciowym wyborem elementu podstawowego");
	        matrix.matrixTimeElapsedBezWyboru(matrix, vector);
	        
	        matrix.wczytajPlik("1");
	        vector.wczytajPlik("Vector");
	        System.out.println();
	        System.out.println("DOUBLE >> Test z pelnym wyborem elementu podstawowego");
	        matrix.matrixTimeElapsedPelnyWybor(matrix, vector);
	        
	        matrix1.wczytajPlik("1");
	        vector2.wczytajPlik("Vector");
	        System.out.println();
	        System.out.println("BezStraty >> Test bez wyboru elementu podstawowego");
	        matrix1.matrixTimeElapsedBezWyboru(matrix1, vector2);
	        
	        matrix1.wczytajPlik("1");
	        vector2.wczytajPlik("Vector");
	        System.out.println();
	        System.out.println("BezStraty >> Test z czesciowym wyborem elementu podstawowego");
	        matrix1.matrixTimeElapsedBezWyboru(matrix1, vector2);
	        
	        matrix1.wczytajPlik("1");
	        vector2.wczytajPlik("Vector");
	        System.out.println();
	        System.out.println("BezStraty >> Test z pelnym wyborem elementu podstawowego");
	        matrix1.matrixTimeElapsedPelnyWybor(matrix1, vector2);*/
	        
	      	/*
        	MyMatrix<Float> blad1 = matrix3.mnozenie(matrix3);
        	blad1.rzutujMacierz();
	       	*/
        
			/*
        	matrix1.rzutujMacierz();
        	try {
        		MyMatrix<BezStraty> matrix22 = matrix1.czesciowyWybor(matrix1, vector2);
            	matrix22.rzutujMacierz();
			} catch (Exception e) {
				System.err.println("Nie spelniony warunek, dzielenie przez 0");
			}
        	*/
			/*
        	ArrayList<Integer> que = new ArrayList<>();
        	MyMatrix<Double> resultMatrix1 = matrix.czesciowyWybor(matrix,vector);
            matrix.wczytajPlik("1");
            vector.wczytajPlik("Vector");
        	MyMatrix<Double> resultMatrix = matrix.pelnyWybor(matrix,vector,que);
        	matrix.wczytajPlik("1");
            vector.wczytajPlik("Vector");
            MyMatrix<Double> resultMatrix2 = matrix.bezWyboru(matrix,vector);
        	System.out.println("\n Bez wyboru:");
        	resultMatrix2.rzutujMacierz();
            System.out.println("Czesciowy wybor:");
        	resultMatrix1.rzutujMacierz();
        	System.out.println("\n Pelny wybor:");
        	resultMatrix.rzutujMacierz();
        	matrix.wczytajPlik("1");
        	matrix1.wczytajPlik("1");
        	matrix2.wczytajPlik("1");
        	matrix3.wczytajPlik("1");
        	vector.wczytajPlik("Vector");
        	vector1.wczytajPlik("Vector");
        	vector2.wczytajPlik("Vector");
        	MyMatrix<BezStraty> resultMatrix3 = matrix1.bezWyboru(matrix1,vector2);
        	System.out.println("Bez wyboru:");
        	resultMatrix3.rzutujMacierz();
        	matrix.wczytajPlik("1");
        	matrix1.wczytajPlik("1");
        	matrix2.wczytajPlik("1");
        	matrix3.wczytajPlik("1");
        	vector.wczytajPlik("Vector");
        	vector1.wczytajPlik("Vector");
        	vector2.wczytajPlik("Vector");
        	MyMatrix<BezStraty> resultMatrix4 = matrix1.czesciowyWybor(matrix1,vector2);
        	resultMatrix4.rzutujMacierz();
        	matrix.wczytajPlik("1");
        	matrix1.wczytajPlik("1");
        	matrix2.wczytajPlik("1");
        	matrix3.wczytajPlik("1");
        	vector.wczytajPlik("Vector");
        	vector1.wczytajPlik("Vector");
        	vector2.wczytajPlik("Vector");
        	ArrayList<Integer> que1 = new ArrayList<>();
        	MyMatrix<BezStraty> resultMatrix5 = matrix1.pelnyWybor(matrix1,vector2,que1);
        	resultMatrix5.rzutujMacierz();
        	
	        MyMatrix<Float> blad1 = matrix3.pelnyWybor(matrix3,vector1, que).odejmowanie(matrix3.bezWyboru(matrix3, vector1));
	        blad1.rzutujMacierz();
			*/
        /*
        matrix.wczytajPlik("1");
    	matrix1.wczytajPlik("1");
    	matrix2.wczytajPlik("1");
    	matrix3.wczytajPlik("1");
    	vector.wczytajPlik("Vector");
    	vector1.wczytajPlik("Vector");
    	vector2.wczytajPlik("Vector");
    	MyMatrix<Double> resultMatrix = matrix.gaussBase(matrix,vector);
    	resultMatrix.rzutujMacierz();
    	matrix.wczytajPlik("1");
    	matrix1.wczytajPlik("1");
    	matrix2.wczytajPlik("1");
    	matrix3.wczytajPlik("1");
    	vector.wczytajPlik("Vector");
    	vector1.wczytajPlik("Vector");
    	vector2.wczytajPlik("Vector");
    	ArrayList<Integer> que1 = new ArrayList<>();
    	MyMatrix<BezStraty> resultMatrix1 = matrix1.fullChoiseGauss(matrix1,vector2,que1);
    	resultMatrix1.rzutujMacierz();
        */
     /*
        matrix.wczytajPlik("1");
    	matrix1.wczytajPlik("1");
    	matrix2.wczytajPlik("1");
    	matrix3.wczytajPlik("1");
    	vector.wczytajPlik("Vector");
    	vector1.wczytajPlik("Vector");
    	vector2.wczytajPlik("Vector");
    	MyMatrix<Double> resultMatrix = matrix.czesciowyWybor(matrix,vector);
    	resultMatrix.rzutujMacierz();
    	matrix.wczytajPlik("1");
    	matrix1.wczytajPlik("1");
    	matrix2.wczytajPlik("1");
    	matrix3.wczytajPlik("1");
    	vector.wczytajPlik("Vector");
    	vector1.wczytajPlik("Vector");
    	vector2.wczytajPlik("Vector");
    	ArrayList<Integer> que1 = new ArrayList<>();
    	MyMatrix<BezStraty> resultMatrix1 = matrix1.pelnyWybor(matrix1,vector2,que1);
    	resultMatrix1.rzutujMacierz();
     */
        
        /*
        matrix3.wczytajPlik("1");
    	vector1.wczytajPlik("Vector");
        System.out.println();
        System.out.println("FLOAT >> Test bez wyboru elementu podstawowego");
        matrix3.matrixTimeElapsedBezWyboru(matrix3, vector1);
        */

        /*
        matrix.wczytajPlik("1");
        vector.wczytajPlik("Vector");
        System.out.println();
        System.out.println("DOUBLE >> Test bez wyboru elementu podstawowego");
        matrix.matrixTimeElapsedBezWyboru(matrix, vector);
        */

        /*
        matrix1.wczytajPlik("1");
        vector2.wczytajPlik("Vector");
        System.out.println();
        System.out.println("BezStraty >> Test bez wyboru elementu podstawowego");
        matrix1.matrixTimeElapsedBezWyboru(matrix1, vector2);
        */

        /*
		matrix3.wczytajPlik("1");
		vector1.wczytajPlik("Vector");
		System.out.println();
		System.out.println("FLOAT >> Test z czesciowym wyborem elementu podstawowego");
		matrix3.matrixTimeElapsedCzesciowyWybor(matrix3, vector1);
		*/

        matrix.wczytajPlik("1");
        vector.wczytajPlik("Vector");
        System.out.println();
        System.out.println("DOUBLE >> Test z czesciowym wyborem elementu podstawowego");
        matrix.matrixTimeElapsedCzesciowyWybor(matrix, vector);

/*
        matrix1.wczytajPlik("1");
        vector2.wczytajPlik("Vector");
        System.out.println();
        System.out.println("BezStraty >> Test z czesciowym wyborem elementu podstawowego");
        matrix1.matrixTimeElapsedCzesciowyWybor(matrix1, vector2);
        */

        /*
        matrix3.wczytajPlik("1");
    	vector1.wczytajPlik("Vector");
        System.out.println();
        System.out.println("FLOAT >> Test z pelnym wyborem elementu podstawowego");
        matrix3.matrixTimeElapsedPelnyWybor(matrix3, vector1);



        matrix.wczytajPlik("1");
        vector.wczytajPlik("Vector");
        System.out.println();
        System.out.println("DOUBLE >> Test z pelnym wyborem elementu podstawowego");
        matrix.matrixTimeElapsedPelnyWybor(matrix, vector);





        matrix1.wczytajPlik("1");
        vector2.wczytajPlik("Vector");
        System.out.println();
        System.out.println("BezStraty >> Test z pelnym wyborem elementu podstawowego");
        matrix1.matrixTimeElapsedPelnyWybor(matrix1, vector2);
        */

	}
	

}
