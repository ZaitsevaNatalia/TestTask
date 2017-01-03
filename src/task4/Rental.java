package task4;

public class Rental
{
    private int kind;
    private int days;
    private double basePrice;
    private double rental;

    public Rental(int kind, int days, double basePrice)
    {
        this.kind=kind;
        this.days=days;
        this.basePrice = basePrice;
        this.rental = amountFor();
    }

    public int getKind()
    {
        return kind;
    }

    public int getDays()
    {
        return days;
    }

    public  double getRental()
    {
        return rental;
    }

    private double amountFor()
    {
        double result;

        result=days*basePrice;

        if (kind == 1) {
            result = result*1.5;
        }

        if (kind == 2) {
            result = result*2;
        }

        if (kind == 3) {
            result=result*2.5;
        }

        if (days > 7) {
            result=result*3;
        }

        if (basePrice < 2000)
        {
            result = result*1.5;
        }

        return result;
    }
}