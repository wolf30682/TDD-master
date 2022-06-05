import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class CalcCreditTest {
    // например у нас сумма кредита 1_000_000 рублей, под 20% годовых, сроком на 5 лет = 60 месяцев
    // данный пример разрабатывается для проверки методологии TDD, поэтому я не стал перегружать
    // его серьёзной математикой и вычислять всё как есть в действительности, а просто взял
    // очень приблизительные формулы расчёта

    @Test
    public void testCalcOfMounthlyPayment() {
        CalcCredit calcCredit = new CalcCredit();
        int loanSum = 1_000_000;
        double interestRate = 20;
        int creditPeriod = 60;
        double actualResult = calcCredit.calcOfMounthlyPayment(loanSum, interestRate, creditPeriod);
        double expectedResult = (loanSum + loanSum * (interestRate / 100)) / creditPeriod;
        Assert.assertTrue("Неверная сумма ежемесячного платежа при проценте " + interestRate
                        + " от суммы кредита " + loanSum + ", на срок " + creditPeriod + " месяцев. "
                , expectedResult == actualResult);
    }

    @Test
    public void testcalcOfTotalSum() {
        CalcCredit calcCredit = new CalcCredit();
        int loanSum = 1_000_000;
        double interestRate = 20;
        double actualResult = calcCredit.calcOfTotalSum(loanSum, interestRate);
        double expectedResult = loanSum + (loanSum * interestRate / 100);
        Assert.assertTrue("Неверная общая сумма платежа" + loanSum
                + " для процента " + interestRate, expectedResult == actualResult);
    }

    @Test
    public void testcalcOfOverpayment() {
        CalcCredit calcCredit = new CalcCredit();
        int loanSum = 1_000_000;
        double interestRate = 20;
        double actualResult = calcCredit.calcOfOverpayment(loanSum, interestRate);
        double expectedResult = loanSum * interestRate / 100;
        Assert.assertTrue("Неверный результат для суммы " + loanSum
                + " под процент " + interestRate, expectedResult == actualResult);
    }

}

