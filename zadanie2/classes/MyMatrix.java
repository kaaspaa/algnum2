package classes;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


/**
 * 
 *
 * @param <T> - klasa macierzy
 */
public class MyMatrix<T extends Number> {
    private T[][] matrix;
    private int rows;
    private int columns;
    private Class<T> classType;
    
    @SuppressWarnings("unchecked")
	public MyMatrix(Class<T> classType) {
    	this.matrix = (T[][]) new Number[0][0];
    	this.classType = classType;
    }

    public MyMatrix(Class<T> classType, int length) {
    	this(classType, length, length);
    }
   
	@SuppressWarnings("unchecked")
	public MyMatrix(Class<T> classType, int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = (T[][]) new Number[rows][columns];
        this.classType = classType;
    }

    @SuppressWarnings("unchecked")
	public MyMatrix<T> dodawanie(MyMatrix<T> secondMatrix) 
    {

        MyMatrix<T> sumMatrix = new MyMatrix<T>(classType, this.rows, this.columns);


        if (!(secondMatrix.columns == this.columns && secondMatrix.rows == this.rows)) 
        {
            return null;
        }

        for (int i = 0; i < rows; i++) 
        {
            for (int j = 0; j < columns; j++) 
            {
                if (classType.equals(Float.class)) 
                {
                    Float sum = this.matrix[i][j].floatValue() + secondMatrix.matrix[i][j].floatValue();
                    sumMatrix.matrix[i][j] = (T) sum;

                } else 
                {
                    if (classType.equals(Double.class))
                    {
                        Double sum = this.matrix[i][j].doubleValue() + secondMatrix.matrix[i][j].doubleValue();
                        sumMatrix.matrix[i][j] = (T) sum;

                    } else
                    {
                        BezStraty sum = (BezStraty) matrix[i][j];
                        BezStraty tmp = BezStraty.add(sum,(BezStraty) secondMatrix.matrix[i][j]);
                        sumMatrix.matrix[i][j] = (T) tmp;

                    }
                }
            }
        }
        return sumMatrix;
    }
    
    @SuppressWarnings("unchecked")
	public MyMatrix<T> odejmowanie(MyMatrix<T> secondMatrix) 
    {

        MyMatrix<T> subMatrix = new MyMatrix<T>(classType, this.rows, this.columns);


        if (!(secondMatrix.columns == this.columns && secondMatrix.rows == this.rows)) 
        {
            return null;
        }

        for (int i = 0; i < rows; i++) 
        {
            for (int j = 0; j < columns; j++) 
            {
                if (classType.equals(Float.class)) 
                {

                    Float sub = this.matrix[i][j].floatValue() - secondMatrix.matrix[i][j].floatValue();
                    subMatrix.matrix[i][j] = (T) sub;

                } else {
                    if (classType.equals(Double.class)) 
                    {

                        Double sub = this.matrix[i][j].doubleValue() - secondMatrix.matrix[i][j].doubleValue();
                        subMatrix.matrix[i][j] = (T) sub;

                    } else {

                        BezStraty sub = (BezStraty) matrix[i][j];
                        BezStraty tmp = BezStraty.sub(sub,(BezStraty) secondMatrix.matrix[i][j]);
                        subMatrix.matrix[i][j] = (T) tmp;

                    }
                }
            }
        }
        return subMatrix;
    }

    @SuppressWarnings("unchecked")
	public MyMatrix<T> mnozenie(MyMatrix<T> secondMatrix) 
    {
        if (!(this.columns == secondMatrix.rows)) 
        {
            return null;
        }
        MyMatrix<T> resultMatrix = new MyMatrix<T>(classType, this.rows, secondMatrix.columns);
        resultMatrix.wypelnianieZerami();

        for (int i = 0; i < rows; i++) 
        {
            for (int j = 0; j < columns; j++) 
            {
                for (int k = 0; k < secondMatrix.columns; k++) 
                {

                    if (classType.equals(Float.class)) 
                    {
                        Float result = resultMatrix.matrix[i][k].floatValue() +
                                this.matrix[i][j].floatValue() * secondMatrix.matrix[j][k].floatValue();
                        resultMatrix.matrix[i][k] = (T) result;
                    } else 
                    {
                        if (classType.equals(Double.class)) 
                        {
                            Double result = resultMatrix.matrix[i][k].doubleValue() +
                                    this.matrix[i][j].doubleValue() * secondMatrix.matrix[j][k].doubleValue();
                            resultMatrix.matrix[i][k] = (T) result;
                        } else {
                            if (classType.equals(BezStraty.class))
                            {
                                BezStraty tmp = (BezStraty) this.matrix[i][j];
                                BezStraty tmp2 = (BezStraty) secondMatrix.matrix[j][k];

                                BezStraty tmpMultiply = tmp.newInstance();
                                tmpMultiply.multiply(tmp2);
                                BezStraty tmp3 = (BezStraty) resultMatrix.matrix[i][k];
                                tmp3.add(tmpMultiply);
                                resultMatrix.matrix[i][k] = (T) tmp3;
                            }
                        }
                    }
                }
            }
        }
        return resultMatrix;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public MyMatrix<T> bezWyboru(MyMatrix<T> matrix, MyMatrix<T> vector) throws ArithmeticException 
    {

        int rows = vector.rows;
        MyMatrix<T> realvector = new MyMatrix(classType, vector.rows,1);

        for (int p = 0; p < rows; p++) 
        {
            for (int i = p + 1; i < rows; i++) 
            {
                tworzTrojkatMacierzy(matrix, vector, rows, p, i);
            }
        }

        MyMatrix<T> resultVector = new MyMatrix(classType, vector.rows, 1);
        ///matrix.printMatrix();
        liczUkladyRownanOdTylu(matrix, vector, rows, resultVector);
        return resultVector;
    }
    
    public void matrixTimeElapsedBezWyboru(MyMatrix<T> matrix, MyMatrix<T> vector) 
    {
    	long start = System.nanoTime();
    	bezWyboru(matrix, vector);
    	long elapsedTimeMillis = System.nanoTime() -start;
        System.out.println("czas: " + elapsedTimeMillis + " nanosekund");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public MyMatrix<T> czesciowyWybor(MyMatrix<T> matrix, MyMatrix<T> vector) 
    {

        int n = vector.rows;
        for (int p = 0; p < n; p++) 
        {

            int max = p;
            przemiescNajwiekszyWiersz(matrix, vector, n, p, max);
            for (int i = p + 1; i < n; i++) {
                tworzTrojkatMacierzy(matrix, vector, n, p, i);
            }
        }

        MyMatrix<T> resultVector = new MyMatrix(classType, vector.rows, 1);
        
        liczUkladyRownanOdTylu(matrix, vector, n, resultVector);
        return resultVector;
    }
    
    public void matrixTimeElapsedCzesciowyWybor(MyMatrix<T> matrix, MyMatrix<T> vector) 
    {
    	long start = System.nanoTime();
    	czesciowyWybor(matrix, vector);
    	long elapsedTimeMillis = System.nanoTime() -start;
        System.out.println("czas: " + elapsedTimeMillis + " nanosekund");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public MyMatrix<T> pelnyWybor(MyMatrix<T> matrix, MyMatrix<T> vector, ArrayList<Integer> queue) 
    {

        for (int i = 0; i < matrix.rows; i++) 
        {
            queue.add(i);
        }
        int n = vector.rows;
        for (int p = 0; p < n; p++) 
        {

            znajdzUstawNajwiekszaWartoscMacierzy(matrix, vector, p, queue);
            for (int i = p + 1; i < n; i++) 
            {
                tworzTrojkatMacierzy(matrix, vector, n, p, i);
            }
        }

        MyMatrix<T> resultVector = new MyMatrix(classType, vector.rows, 1);
        liczUkladyRownanOdTylu(matrix, vector, n, resultVector);

        this.zamienWynikiWedlugListy(resultVector,queue);
        return resultVector;
    }
    
    public void matrixTimeElapsedPelnyWybor(MyMatrix<T> matrix, MyMatrix<T> vector) 
    {
    	ArrayList<Integer> que = new ArrayList<>();
    	long start = System.nanoTime();
    	pelnyWybor(matrix, vector, que);
    	long elapsedTimeMillis = System.nanoTime() -start;
        System.out.println("czas: " + elapsedTimeMillis + " nanosekund");
    }

    private void przemiescNajwiekszyWiersz(MyMatrix<T> matrix, MyMatrix<T> vector, int n, int p, int max) 
    {
        for (int i = p + 1; i < n; i++) 
        {
            if (classType.equals(Float.class)) 
            {
                if (Math.abs(matrix.matrix[i][p].floatValue()) > Math.abs(matrix.matrix[max][p].floatValue())) 
                {
                    max = i;
                }
            } else 
            {
                if (classType.equals(Double.class)) 
                {
                    if (Math.abs(matrix.matrix[i][p].doubleValue()) > Math.abs(matrix.matrix[max][p].doubleValue())) 
                    {
                        max = i;
                    }

                } else 
                {
                    if (classType.equals(BezStraty.class))
                    {
                        if (Math.abs(((BezStraty) matrix.matrix[i][p]).returnDoubleFormat()) > Math.abs(((BezStraty) matrix.matrix[max][p]).returnDoubleFormat()))
                        {
                            max = i;
                        }

                    }
                }
            }
        }

        zamienWiersze(matrix, p, max);
        zamienWiersze(vector, p, max);
    }

    @SuppressWarnings("unchecked")
	private void tworzTrojkatMacierzy(MyMatrix<T> matrix, MyMatrix<T> vector, int n, int p, int i) 
    {
        if (classType.equals(Float.class)) 
        {
            float alpha = matrix.matrix[i][p].floatValue() / matrix.matrix[p][p].floatValue();
            vector.matrix[i][0] = (T) (Float) (vector.matrix[i][0].floatValue() - alpha * vector.matrix[p][0].floatValue());
            for (int j = p; j < n; j++) 
            {
                matrix.matrix[i][j] = (T) (Float) (matrix.matrix[i][j].floatValue() - alpha * matrix.matrix[p][j].floatValue());
            }
        } else 
        {
            if (classType.equals(Double.class)) 
            {
                double alpha = matrix.matrix[i][p].doubleValue() / matrix.matrix[p][p].doubleValue();
                vector.matrix[i][0] = (T) (Double) (vector.matrix[i][0].doubleValue() - alpha * vector.matrix[p][0].doubleValue());
                for (int j = p; j < n; j++) 
                {
                    matrix.matrix[i][j] = (T) (Double) (matrix.matrix[i][j].doubleValue() - alpha * matrix.matrix[p][j].doubleValue());
                }
            } else 
            {
                if (classType.equals(BezStraty.class))
                {
                    BezStraty alpha = BezStraty.multiply((BezStraty) matrix.matrix[i][p], BezStraty.flip((BezStraty) matrix.matrix[p][p]));
                    BezStraty tmp1 = BezStraty.multiply(alpha, (BezStraty) vector.matrix[p][0]);
                    tmp1 = BezStraty.negate(tmp1);
                    vector.matrix[i][0] = (T) BezStraty.add((BezStraty) vector.matrix[i][0], tmp1);
                    for (int j = p; j < n; j++) 
                    {
                        BezStraty tmp2 = BezStraty.multiply(alpha, (BezStraty) matrix.matrix[p][j]);
                        tmp2 = BezStraty.negate(tmp2);
                        matrix.matrix[i][j] = (T) BezStraty.add((BezStraty) matrix.matrix[i][j], tmp2);
                    }
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
	private void liczUkladyRownanOdTylu(MyMatrix<T> matrix, MyMatrix<T> vector, int n, MyMatrix<T> resultVector) 
    {
        if (classType.equals(Float.class)) 
        {
            for (int i = n - 1; i >= 0; i--) 
            {
                float sum = 0f;
                for (int j = i + 1; j < n; j++) 
                {
                    sum += matrix.matrix[i][j].floatValue() * resultVector.matrix[j][0].floatValue();
                }
                resultVector.matrix[i][0] = (T) (Float) ((vector.matrix[i][0].floatValue() - sum) / matrix.matrix[i][i].floatValue());

            }
        } else {
            if (classType.equals(Double.class)) 
            {
                for (int i = n - 1; i >= 0; i--) 
                {
                    double sum = 0.0;
                    for (int j = i + 1; j < n; j++) 
                    {
                        sum += matrix.matrix[i][j].doubleValue() * resultVector.matrix[j][0].doubleValue();
                    }
                    resultVector.matrix[i][0] = (T) (Double) ((vector.matrix[i][0].doubleValue() - sum) / matrix.matrix[i][i].doubleValue());

                }
            } else {
                if (classType.equals(BezStraty.class))
                {
                    for (int i = n - 1; i >= 0; i--) 
                    {
                        BezStraty sum = new BezStraty("0.0");
                        for (int j = i + 1; j < n; j++) 
                        {
                            BezStraty tmp1 = (BezStraty) matrix.matrix[i][j];
                            BezStraty tmp2 = (BezStraty) resultVector.matrix[j][0];
                            tmp1.multiply(tmp2);
                            sum.add(tmp1);
                        }
                        BezStraty tmp3 = (BezStraty) vector.matrix[i][0];
                        sum = BezStraty.negate(sum);
                        tmp3.add(sum);
                        BezStraty tmp4 = (BezStraty) matrix.matrix[i][i];
                        tmp4 = BezStraty.flip(tmp4);
                        tmp3.multiply(tmp4);
                        resultVector.matrix[i][0] = (T) tmp3;
                    }
                }
            }
        }
    }

    public void znajdzUstawNajwiekszaWartoscMacierzy(MyMatrix<T> matrix, MyMatrix<T> vector, int p, ArrayList<Integer> queue) 
    {

        Float maxValue = matrix.matrix[p][p].floatValue();
        int rowIndex = p;
        int columnIndex = p;
        for (int ii = p; ii < matrix.rows; ii++) 
        {
            for (int jj = p; jj < matrix.columns; jj++) 
            {

                if (Math.abs(matrix.matrix[ii][jj].floatValue()) > maxValue) 
                {
                    maxValue = Math.abs(matrix.matrix[ii][jj].floatValue());
                    rowIndex = ii;
                    columnIndex = jj;
                }
            }
        }

        zamienWiersze(matrix, p, rowIndex);
        zamienWiersze(vector, p, rowIndex);
        zamienKolumny(matrix, p, columnIndex, queue);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public MyMatrix<T> zamienWynikiWedlugListy(MyMatrix<T> vectorMatrix, ArrayList<Integer> queue) 
    {

        MyMatrix<T> tmp = new MyMatrix(classType, vectorMatrix.rows, 1);
        for (int ii = 0; ii < vectorMatrix.rows; ii++) 
        {
            for (int jj = 0; jj < vectorMatrix.columns; jj++) 
            {
                tmp.matrix[ii][jj] = vectorMatrix.matrix[ii][jj];
            }
        }
        for (int i = 0; i < vectorMatrix.rows; i++) 
        {
            vectorMatrix.matrix[queue.get(i)][0] = tmp.matrix[i][0];
        }
                
        return vectorMatrix;
    }

    public MyMatrix<T> zamienWiersze(MyMatrix<T> finalMatrix, int row1, int row2) 
    {
        if (row1 == row2) 
        {
            return finalMatrix;
        }
        for (int i = 0; i < finalMatrix.columns; i++) 
        {
            T tmp = finalMatrix.matrix[row1][i];
            finalMatrix.matrix[row1][i] = finalMatrix.matrix[row2][i];
            finalMatrix.matrix[row2][i] = tmp;
        }
        return finalMatrix;
    }

    public MyMatrix<T> zamienKolumny(MyMatrix<T> finalMatrix, int column1, int column2, ArrayList<Integer> queue) 
    {
        if (column1 == column2) 
        {
            return finalMatrix;
        }
        int tmp = queue.get(column1);
        queue.set(column1, queue.get(column2));
        queue.set(column2, tmp);

        for (int i = 0; i < finalMatrix.rows; i++) 
        {
            T tmp2 = finalMatrix.matrix[i][column1];
            finalMatrix.matrix[i][column1] = finalMatrix.matrix[i][column2];
            finalMatrix.matrix[i][column2] = tmp2;
        }
        return finalMatrix;
    }

    public void rzutujMacierz() 
    {
        System.out.println("Typ: " + classType.getName() + "\n" + "Macierz:");
        for (int i = 0; i < rows; i++) 
        {
            for (int j = 0; j < columns; j++) 
            {
                System.out.printf("%26.26s  ", matrix[i][j]);
            }
            System.out.println("");
        }
    }

    @SuppressWarnings("unchecked")
	public void wypelnianieZerami() 
    {
        for (int i = 0; i < rows; i++) 
        {
            for (int j = 0; j < columns; j++) 
            {
                if (classType.equals(Float.class)) 
                {
                    Float zero = 0f;
                    matrix[i][j] = (T) zero;
                } else 
                {
                    if (classType.equals(Double.class)) 
                    {
                        Double zero = new Double(0);
                        matrix[i][j] = (T) zero;
                    } else {
                        matrix[i][j] = (T) new BezStraty("0.0");
                    }
                }
            }
        }
    }

    public void wczytajPlik(String suffix) throws IOException 
    {
        FileInputStream fstream = new FileInputStream("macierz" + suffix + ".txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        wczytajDanePliku(br);
        br.close();
        fstream.close();
    }

    @SuppressWarnings("unchecked")
	private void wczytajDanePliku(BufferedReader br) throws IOException 
    {
        String strLine;
        rows = Integer.valueOf(br.readLine());
        columns = Integer.parseInt(br.readLine());
        
        matrix = (T[][]) new Number[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) 
            {

                strLine = br.readLine();
                if (classType.equals(Float.class)) 
                {
                    matrix[i][j] = (T) Float.valueOf(strLine);
                } else 
                {
                    if (classType.equals(Double.class)) 
                    {
                        matrix[i][j] = (T) Double.valueOf(strLine);
                    } else {
                        matrix[i][j] = (T) new BezStraty(strLine);
                    }
                }
            }
        }
    }
 
}