package classes;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

@SuppressWarnings("serial")
public class BezStraty extends Number 
{
    BigInteger licznik;
    BigInteger mianownik;
    String numberString;
    MathContext mathcontext = new MathContext(40, RoundingMode.HALF_DOWN);

    public BezStraty(String numberString)
    {
        this.numberString=numberString;
        convertion();
    }
    public BezStraty(BigInteger licznik, BigInteger mianownik, String numberString)
    {
        this.licznik=licznik;
        this.mianownik = mianownik;
        this.numberString = numberString;
    }
    public static BezStraty flip(BezStraty first)
    {
        BezStraty toReturn = first.newInstance();
        BigInteger tmp = toReturn.getNumerator();
        toReturn.setNumerator(toReturn.getDenominator());
        toReturn.setDenominator(tmp);
        return toReturn;
    }

    public static BezStraty negate(BezStraty first)
    {
        BezStraty toReturn1 = new BezStraty(first.getNumerator(),first.getDenominator(),first.getNumberString());
        if(toReturn1.licznik.doubleValue() < 0 && toReturn1.mianownik.doubleValue()<0||toReturn1.licznik.doubleValue() > 0 && toReturn1.mianownik.doubleValue()>0 )
        {
            toReturn1.setDenominator(toReturn1.getDenominator().negate());
        }else
        {
            if(toReturn1.licznik.doubleValue()<0){
                toReturn1.setNumerator(toReturn1.getNumerator().negate());
            }else
            {
                toReturn1.setDenominator(toReturn1.getDenominator().negate());
            }
        }
        return toReturn1;
    }

    public void convertion()
    {

        BigDecimal bigDecimalValue = new BigDecimal(numberString);
        int digits = numberString.length() - 1 - numberString.indexOf('.');
        int i=0;
        mianownik = new BigInteger(String.valueOf(1));
        while(i<digits)
        {
            bigDecimalValue= bigDecimalValue.multiply(BigDecimal.valueOf(10));
            mianownik = mianownik.multiply(BigInteger.valueOf(10));
            i++;
        }
        String trimDecimal = String.valueOf(bigDecimalValue);
        trimDecimal = trimDecimal.substring(0,trimDecimal.indexOf('.'));
        licznik = new BigInteger(trimDecimal);

        fractureBigInteger();
    }

    public void absConvert()
    {
        licznik = licznik.abs();
        mianownik = mianownik.abs();
    }

    public void add(BezStraty second)
    {
        this.licznik = this.licznik.multiply(second.mianownik).add(this.mianownik.multiply(second.licznik));
        this.mianownik = this.mianownik.multiply(second.mianownik);
    }
    public void substract(BezStraty second)
    {
        second = BezStraty.negate(second);
        this.licznik = this.licznik.multiply(second.mianownik).add(this.mianownik.multiply(second.licznik));
        this.mianownik = this.mianownik.multiply(second.mianownik);
    }

    public static BezStraty add(BezStraty first, BezStraty second)
    {
        BezStraty toReturn1 = new BezStraty(first.getNumerator(),first.getDenominator(),first.getNumberString());
        BezStraty toReturn2 = new BezStraty(second.getNumerator(),second.getDenominator(),second.getNumberString());

        toReturn1.licznik = toReturn1.licznik.multiply(toReturn2.mianownik).add(toReturn1.mianownik.multiply(toReturn2.licznik));
        toReturn1.mianownik = toReturn1.mianownik.multiply(toReturn2.mianownik);
        return toReturn1;
    }
    
    public static BezStraty sub(BezStraty first, BezStraty second)
    {
        BezStraty toReturn1 = new BezStraty(first.getNumerator(),first.getDenominator(),first.getNumberString());
        BezStraty toReturn2 = new BezStraty(second.getNumerator(),second.getDenominator(),second.getNumberString());

        toReturn1.licznik = toReturn1.licznik.multiply(toReturn2.mianownik).add(toReturn1.mianownik.multiply(toReturn2.licznik));
        toReturn1.mianownik = toReturn1.mianownik.multiply(toReturn2.mianownik);
        return toReturn1;
    }


    public void multiply(BezStraty second)
    {
        this.licznik = this.licznik.multiply(second.licznik);
        this.mianownik = this.mianownik.multiply(second.mianownik);
        fractureBigInteger();
    }
    public static BezStraty multiply(BezStraty first, BezStraty second)
    {
        BezStraty toReturn1 = new BezStraty(first.getNumerator(),first.getDenominator(),first.getNumberString());
        BezStraty toReturn2 = new BezStraty(second.getNumerator(),second.getDenominator(),second.getNumberString());

        toReturn1.licznik = toReturn1.licznik.multiply(toReturn2.licznik);
        toReturn1.mianownik = toReturn1.mianownik.multiply(toReturn2.mianownik);
        toReturn1.fractureBigInteger();
        return toReturn1;
    }

    public String printAsDecimal()
    {
        BigDecimal result = new BigDecimal(this.licznik.toString());
        result = result.divide(new BigDecimal(String.valueOf(mianownik)),mathcontext);
        //System.out.print(result);
        return result.toString();
    }

    public BezStraty newInstance()
    {
        return new BezStraty(this.licznik,this.mianownik,this.numberString);
    }

    public Double returnDoubleFormat()
    {
        BigDecimal result = new BigDecimal(this.licznik.toString());
        result = result.divide(new BigDecimal(String.valueOf(mianownik)),mathcontext);
        return result.doubleValue();
    }

    public void fractureBigInteger()
    {
        BigInteger commonFactor = commonFactor(licznik.abs(),mianownik.abs());
        this.licznik = licznik.divide(commonFactor);
        this.mianownik = mianownik.divide(commonFactor);

    }

    public BigInteger  commonFactor(BigInteger numerator, BigInteger denominator)
    {
        if(denominator.equals(BigInteger.valueOf(0)))
        {
            return numerator;
        }
        return  commonFactor(denominator,numerator.mod(denominator));
    }

    public BigInteger getNumerator() {
        return licznik;
    }

    public BigInteger getDenominator() {
        return mianownik;
    }

    public String getNumberString() {
        return numberString;
    }

    public void setNumerator(BigInteger numerator) {
        this.licznik = numerator;
    }

    public void setDenominator(BigInteger denominator) {
        this.mianownik = denominator;
    }

    public void setNumberString(String numberString) {
        this.numberString = numberString;
    }
    
    @Override
    public String toString() {
        return  this.printAsDecimal();
    }

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }


}