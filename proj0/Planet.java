/**
 * Planet class.
 *
 */
public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static final double G = 6.67e-11;

    /**
     * Constructor for class Planet.
     */
    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    /**
     * copy constructor.
     */
    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    /**
     * calculate the distance between twp planets.
     */
    public double calcDistance(Planet planetX) {
        return Math.sqrt((planetX.xxPos - xxPos) * (planetX.xxPos - xxPos)
                + (planetX.yyPos - yyPos) * (planetX.yyPos - yyPos));
    }

    /**
     * Calculate the force exerted by the planet.
     */
    public double calcForceExertedBy(Planet planetX) {
        double r = calcDistance(planetX);
        double fource = G * planetX.mass * mass / Math.pow(r, 2);
        return fource;
    }

    /**
     * Calculate the force exerted by the planet on x-axis
     */
    public double calcForceExertedByX (Planet planetX) {
        double dx =planetX.xxPos - xxPos;
        double r = calcDistance(planetX);
        double f = calcForceExertedBy(planetX);
        double fx = f * dx / r;
        return fx;
    }

    /**
     * Calculate the force exerted by the planet on y-axis
     */
    public double calcForceExertedByY(Planet planetX) {
        double dy =planetX.yyPos - yyPos;
        double r = calcDistance(planetX);
        double f = calcForceExertedBy(planetX);
        double fy = f * dy / r;
        return fy;
    }

    /**
     * Calculate the net force exerted by multiple planets on x-axis
     */
    public double calcNetForceExertedByX(Planet[] planets) {
        double force = 0;
        for (Planet p : planets) {
            if (! this.equals(p)) {
                force += calcForceExertedByX(p);
            }
        }
        return force;
    }

    /**
     * Calculate the net force exerted by multuple planets on y-axis
     */
    public double calcNetForceExertedByY(Planet[] planets) {
        double force = 0;
        for (Planet p : planets) {
            if (! this.equals(p)) {
                force += calcForceExertedByY(p);
            }
        }
        return force;
    }

    /**
     * Calculate the new position coordinates and new velocities
     */
    public void update(double dt, double fx, double fy) {
        double ax = fx / mass;
        double ay = fy / mass;
        xxVel += ax * dt;
        yyVel += ay * dt;
        xxPos += xxVel * dt;
        yyPos += yyVel * dt;
    }
}
