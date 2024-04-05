package parcial1_2017_18;

public class Covariance {

    private int n;
    private double sumx;
    private double sumy;
    private double mult;


    public Covariance() {
        this.n = 0;
        this.sumx = 0;
        this.sumy = 0;
        this.mult = 0;
    }

    public void addPair(double x, double y){
        this.sumx += x;
        this.sumy += y;
        this.n += 1;
        this.mult += x*y;
    }

    public double meanX(){ // según el enunciado no nos hace falta comprobar si se ha hecho alguna observación, es decir si se divide por 0
        return sumx / this.n;
    }

    public double meanY(){
        return sumy / this.n;
    }

    public double covarianceXY(){
        return mult/n - meanX() * meanY();
    }

    public static Covariance union(Covariance cov1, Covariance cov2){
        Covariance res = new Covariance();
        res.sumx = cov1.sumx + cov2.sumx;
        res.sumy = cov1.sumy + cov2.sumy;
        res.mult = cov1.mult + cov2.mult;
        res.n = cov1.n + cov2.n;

        return res;
    }
}
