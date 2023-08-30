package Model;

public class Fraction {
    private int nom;
    private int denom;
    public Fraction(int nom, int denom) {
        this.nom = nom;
        this.denom = denom;
    }

    public Fraction addFractions(Fraction otherFrac) {
        Fraction resultFrac = new Fraction (
                this.nom * otherFrac.getDenom() + otherFrac.getNom() * this.denom,
                this.denom * otherFrac.getDenom()
        );
        System.out.println (resultFrac.getNom());
        return shorten(resultFrac);
    }

    public Fraction multFractions(Fraction otherFrac) {
        Fraction resultFrac = new Fraction (
                this.nom * otherFrac.getNom(),
                this.denom * otherFrac.getDenom()
        );
        System.out.println (resultFrac.getNom());
        return shorten(resultFrac);
    }

    public Fraction shorten(Fraction frac) {
        if (frac.getNom() == 0) {
            return new Fraction (0, 1);
        }
        return new Fraction (
                frac.getNom() / findGCD(Math.max(frac.getNom(), frac.getDenom()), Math.min(frac.getNom(), frac.getDenom())),
                frac.getDenom() / findGCD(Math.max(frac.getNom(), frac.getDenom()), Math.min(frac.getNom(), frac.getDenom())));
    }

    public int findGCD(int a, int b) {
        int r = a % b;
        if (r != 0) {
            return findGCD(b, r);
        }
        return b;
    }

    public int getNom() {
        return nom;
    }
    public int getDenom() {
        return denom;
    }

}
