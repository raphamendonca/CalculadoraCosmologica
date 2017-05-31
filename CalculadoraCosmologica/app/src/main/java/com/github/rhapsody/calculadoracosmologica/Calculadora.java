package com.github.rhapsody.calculadoracosmologica;

/**
 * Created by raphamendonca on 30/05/17.
 */

public class Calculadora {


    // Author Raphael Mendon�a
    //
    // based on the project of by Ned Wright
    // 25 Jul 1999
    // Copyright Edward L. Wright, all rights reserved.
    // define global public double iables and functions

    public int i = 0; // index
    public int n = 1000; // number of points in integrals
    public int nda = 1; // number of digits in angular size distance
    public double H0 = 69.6; // Hubble constant
    public double WM = 0.286; // Omega(matter)
    public double WV = 0.714; // Omega(vacuum) or lambda
    public double WR = 0; // Omega(radiation)
    public double WK = 0; // Omega curvaturve = 1-Omega(total)
    public double z = 3.0; // redshift of the object
    public double h = 0.696; // H0/100
    public double c = 299792.458; // velocity of light in km/sec
    public double Tyr = 977.8; // coefficent for converting 1/H into Gyr
    public double DTT = 0.5; // time from z to now in units of 1/H0
    public double DTT_Gyr = 0.0; // value of DTT in Gyr
    public double age = 0.5; // age of Universe in units of 1/H0
    public double age_Gyr = 0.0; // value of age in Gyr
    public double zage = 0.1; // age of Universe at redshift z in units of 1/H0
    public double zage_Gyr = 0.0; // value of zage in Gyr
    public double DCMR = 0.0; // comoving radial distance in units of c/H0
    public double DCMR_Mpc = 0.0;
    public double DCMR_Gyr = 0.0;
    public double DA = 0.0; // angular size distance
    public double DA_Mpc = 0.0;
    public double DA_Gyr = 0.0;
    public double kpc_DA = 0.0;
    public double DL = 0.0; // luminosity distance
    public double DL_Mpc = 0.0;
    public double DL_Gyr = 0.0; // DL in units of billions of light years
    public double V_Gpc = 0.0;
    public double a = 1.0; // 1/(1+z), the scale factor of the Universe
    public double az = 0.5; // 1/(1+z(object))

    public String tunit = " Gyr";

    // entry point for the input form to pass values back to this script
    public void setValues(double tH0, double tWM, double tWV, double tz) {
        H0 = tH0;
        h = H0 / 100;
        WM = tWM;
        WV = tWV;
        z = tz;
        WR = 4.165E-5 / (h * h); // includes 3 massless neutrino species, T0 =
        // 2.72528
        WK = 1 - WM - WR - WV;
        compute();
        // parent.CCout.location="./CCout.html";
    }

    public String stround(double x, int m) {
        // rounds to m digits and makes a string
        //System.out.println(" X= " + x + " M= " + m);
        int tenn = 1;
        int i = 0;
        for (i = 0; i != m; i++) {
            tenn = tenn * 10;
        }

        long y = Math.round(Math.abs(x) * tenn);
        String str = " " + Math.round(Math.abs(x) * tenn);

        while (m > str.length() - 2) {
            str = " 0" + str.substring(1, str.length());
        }

        str = str.substring(0, str.length() - m) + "." + str.substring(str.length() - m, str.length());
        if (x < 0) {
            str = " -" + str.substring(1, str.length());
        }

        return str;
    }

    // tangential comoving distance
    public double DCMT() {
        double ratio = 1.00;
        double x;
        double y;
        x = Math.sqrt(Math.abs(WK)) * DCMR;
        // document.writeln("DCMR = " + DCMR + "<BR>");
        // document.writeln("x = " + x + "<BR>");
        if (x > 0.1) {
            ratio = (WK > 0) ? 0.5 * (Math.exp(x) - Math.exp(-x)) / x : Math.sin(x) / x;
            // document.writeln("ratio = " + ratio + "<BR>");
            y = ratio * DCMR;
            return y;
        }
        ;
        y = x * x;
        // statement below fixed 13-Aug-03 to correct sign error in expansion
        if (WK < 0) {
            y = -y;
        }
        ratio = 1 + y / 6 + y * y / 120;
        // document.writeln("ratio = " + ratio + "<BR>");
        y = ratio * DCMR;
        return y;
    }

    // comoving volume computation
    public double VCM() {
        double ratio = 1.00;
        double x;
        double y;
        x = Math.sqrt(Math.abs(WK)) * DCMR;

        if (x > 0.1) {
            ratio = (WK > 0) ? (0.125 * (Math.exp(2 * x) - Math.exp(-2 * x)) - x / 2) / (x * x * x / 3)
                    : (x / 2 - Math.sin(2 * x) / 4) / (x * x * x / 3);
            y = ratio * DCMR * DCMR * DCMR / 3;
            return y;
        }
        ;
        y = x * x;
        // statement below fixed 13-Aug-03 to correct sign error in expansion
        if (WK < 0) {
            y = -y;
        }
        ratio = 1 + y / 5 + (2 / 105) * y * y;
        y = ratio * DCMR * DCMR * DCMR / 3;
        return y;
    }

    // calculate the actual results
    public void compute() {
        double h = H0 / 100;
        double WR = 4.165*Math.pow(10, -5) / (h * h); // includes 3 massless neutrino species,
        //double WR = 4.165E-5 / (h * h); // includes 3 massless neutrino species,
        // T0 = 2.72528
        double WK = 1 - WM - WR - WV;
        double az = 1.0 / (1 + 1.0 * z);
        double age = 0;

        for (i = 0; i != n; i++) {
            a = az * (i + 0.5) / n;
            double adot = Math.sqrt(WK + (WM / a) + (WR / (a * a)) + (WV * a * a));
            age = age + 1 / adot;
        }
        ;

        double zage = az * age / n;
        // correction for annihilations of particles not present now like e+/e-
        // added 13-Aug-03 based on T_vs_t.f
        double lpz = Math.log((1 + 1.0 * z)) / Math.log(10.0);
        double dzage = 0;

        if (lpz > 7.500)
            dzage = 0.002 * (lpz - 7.500);
        if (lpz > 8.000)
            dzage = 0.014 * (lpz - 8.000) + 0.001;
        if (lpz > 8.500)
            dzage = 0.040 * (lpz - 8.500) + 0.008;
        if (lpz > 9.000)
            dzage = 0.020 * (lpz - 9.000) + 0.028;
        if (lpz > 9.500)
            dzage = 0.019 * (lpz - 9.500) + 0.039;
        if (lpz > 10.000)
            dzage = 0.048;
        if (lpz > 10.775)
            dzage = 0.035 * (lpz - 10.775) + 0.048;
        if (lpz > 11.851)
            dzage = 0.069 * (lpz - 11.851) + 0.086;
        if (lpz > 12.258)
            dzage = 0.461 * (lpz - 12.258) + 0.114;
        if (lpz > 12.382)
            dzage = 0.024 * (lpz - 12.382) + 0.171;
        if (lpz > 13.055)
            dzage = 0.013 * (lpz - 13.055) + 0.188;
        if (lpz > 14.081)
            dzage = 0.013 * (lpz - 14.081) + 0.201;
        if (lpz > 15.107)
            dzage = 0.214;
        zage = zage * Math.pow(10.0, dzage);

        zage_Gyr = (Tyr / H0) * zage;
        DTT = 0.0;
        DCMR = 0.0;

        // do integral over a=1/(1+z) from az to 1 in n steps, midpoint rule
        for (i = 0; i != n; i++) {
            a = az + (1 - az) * (i + 0.5) / n;
            double adot = Math.sqrt(WK + (WM / a) + (WR / (a * a)) + (WV * a * a));
            DTT = DTT + 1 / adot;
            DCMR = DCMR + 1 / (a * adot);
        }

        DTT = (1 - az) * DTT / n;
        DCMR = (1 - az) * DCMR / n;
        age = DTT + zage;
        age_Gyr = age * (Tyr / H0);
        DTT_Gyr = (Tyr / H0) * DTT;
        DCMR_Gyr = (Tyr / H0) * DCMR;
        DCMR_Mpc = (c / H0) * DCMR;
        DA = az * DCMT();
        DA_Mpc = (c / H0) * DA;
        kpc_DA = DA_Mpc / 206.264806;
        DA_Gyr = (Tyr / H0) * DA;
        DL = DA / (az * az);
        DL_Mpc = (c / H0) * DL;
        DL_Gyr = (Tyr / H0) * DL;
        V_Gpc = 4 * Math.PI * Math.pow(0.001 * c / H0, 3) * VCM();

    }

	/*
	 * public void display() { // prepare the HTML to output the results var
	 * answer = '<P>For <A HREF="./glossary.html#H0">H<SUB>o</SUB></A> = ' + H0
	 * + ', <A HREF="./glossary.html#Omega">Omega<SUB>M</SUB></A> = ' +
	 * stround(WM,3) + ', <A HREF="./glossary.html#CC">Omega<SUB>vac</SUB></A> =
	 * ' + stround(WV,3) + ', <A HREF="./glossary.html#redshift">z</A> = ' +
	 * stround(z,3) + "\n<UL>"; var tunit = ' Gyr'; if (zage_Gyr < 0.1) { tunit
	 * = ' Myr'; zage_Gyr = 1000*zage_Gyr; if (zage_Gyr < 0.1) { tunit = ' kyr';
	 * zage_Gyr = 1000*zage_Gyr; if (zage_Gyr < 0.1) { tunit = ' yr'; zage_Gyr =
	 * 1000*zage_Gyr; if (zage_Gyr < 0.1) { tunit = ' sec'; zage_Gyr =
	 * 365.25*86400*zage_Gyr; }; }; }; }; answer += "<LI>It is now " +
	 * stround(age_Gyr,3) + " Gyr since the Big Bang.\n"; answer +=
	 * "<LI>The age at redshift z was "+stround(zage_Gyr,3)+tunit+".\n"; answer
	 * += '<LI>The <A HREF="./cosmo_02.htm#DT">light travel time</A> was '+
	 * stround(DTT_Gyr,3)+" Gyr.\n"; answer += '<LI>The <A
	 * HREF="./cosmo_02.htm#DH">comoving radial distance,</A>' +
	 * " which goes into Hubble's law, is " +
	 * stround(DCMR_Mpc,1)+" Mpc or "+stround(DCMR_Gyr,3)+" Gly.\n"; answer +=
	 * "<LI>The comoving volume within redshift z is "+stround(V_Gpc,3)+
	 * " Gpc<SUP>3</SUP>.\n"; nda = 1; if (DA_Mpc < 100) {nda = 3;}; answer +=
	 * '<LI>The <A HREF="./cosmo_02.htm#DA">' +
	 * "angular size distance D<SUB>A</SUB></A> is "+
	 * stround(DA_Mpc,nda)+" Mpc or "+stround(DA_Gyr,nda+3)+" Gly.\n"; answer +=
	 * '<LI>This gives a scale of '+stround(kpc_DA,3)+' kpc/".\n'; answer +=
	 * '<LI>The <A HREF="./cosmo_02.htm#DL">'+
	 * "luminosity distance D<SUB>L</SUB></A> is "+stround(DL_Mpc,1)+
	 * " Mpc or "+stround(DL_Gyr,3)+" Gly.\n</UL>\n"; return answer; }
	 */
    // compute the results for the default inputs
    // compute();

    // prepare the HTML for the frameset
	/*
	 * var f = '<FRAMESET COLS="25%,*">\n'; f += '<FRAME NAME="CCform"
	 * SRC="./CCform.html">\n'; f += '<FRAME NAME="CCout"
	 * SRC="./CCout.html">\n'; f += '</FRAMESET>';
	 */
    // and write it to the current page
    // document.write(f);

    public void doOpen(double tH0, double tWM, double tz) {
        setValues(tH0, tWM, 0.0, tz);
    }

    public void doFlat(double tH0, double tWM, double tz) {
        setValues(tH0, tWM, 1.0 - tWM - 0.4165 / (tH0 * tH0), tz);
    }

    public void doGeneral(double tH0, double tWM, double tWV, double tz) {
        setValues(tH0, tWM, tWV, tz);
    }



}
