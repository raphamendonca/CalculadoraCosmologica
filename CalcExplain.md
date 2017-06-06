Given Values by the User:
H0, OmegaM, Omega Vac and z

Default Values:
+ Ho = 69.6
+ OmegaM = 0.286
+ Omegavac = 0.714
+ z = 3.000


Initial values of variables:

|Description | Value |
|---------------:|-------------:|
| index |  i = 0|
| number of points in integrals | n=1000 |
| number of digits in angular size distance | nda = 1 |
| Hubble constant |H0 = 69.6 |
| Omega(matter) | WM = 0.286 |
| Omega(vacuum) or lambda | WV = 0.714 |
| Omega(radiation) | var WR = 0 |
|  Omega curvaturve = 1-Omega(total) | WK = 0 |
| redshift of the object | z = 3.0 |
| H0/100 | h = 0.696 |
| velocity of light in km/sec | c = 299792.458 |
| coefficent for converting 1/H into Gyr | Tyr = 977.8 |
| time from z to now in units of 1/H0 | DTT = 0.5
| value of DTT in Gyr | DTT_Gyr = 0.0 |
| age of Universe in units of 1/H0 | age = 0.5 |
| value of age in Gyr | age_Gyr = 0.0|
| age of Universe at redshift z in units of 1/H0 | zage = 0.1 |
| value of zage in Gyr | zage_Gyr = 0.0 |
| comoving radial distance in units of c/H0 | DCMR = 0.0 |
| | DCMR_Mpc = 0.0 |
| | DCMR_Gyr = 0.0 |
| angular size distance | DA = 0.0 |
| angular size distance (Mpc) | DA_Mpc = 0.0 |
| angular size distance (Gyr) | DA_Gyr = 0.0 |
| angular size distance (kpc) | kpc_DA = 0.0 |
| luminosity distance | DL = 0.0 |
| luminosity distance Mpc | DL_Mpc = 0.0 |
| DL in units of billions of light years | DL_Gyr = 0.0 |
| | V_Gpc = 0.0|
| 1/(1+z), the scale factor of the Universe | a = 1.0 |
| 1/(1+z(object)) | var az = 0.5 |

### Methods

#### calculate the actual results
 The method ***compute***
  
  Calculate h as H0 /100
  
  Includes 3 massless neutrino species, T0 = 2.72528
  WR = 4.165E-5/(h*h);	
  WK = 1-WM-WR-WV;
  
  Scale Factor
  az = 1.0/(1+1.0*z);
  
  age = 0;
  
  
  for (i = 0; i != n; i++) {
    a = az*(i+0.5)/n;
    adot = Math.sqrt(WK+(WM/a)+(WR/(a*a))+(WV*a*a));
    age = age + 1/adot;
  };
  zage = az*age/n;
// correction for annihilations of particles not present now like e+/e-
// added 13-Aug-03 based on T_vs_t.f
  var lpz = Math.log((1+1.0*z))/Math.log(10.0);
  var dzage = 0;
  
  if (lpz >  7.500) dzage = 0.002 * (lpz -  7.500);
  if (lpz >  8.000) dzage = 0.014 * (lpz -  8.000) +  0.001;
  if (lpz >  8.500) dzage = 0.040 * (lpz -  8.500) +  0.008;
  if (lpz >  9.000) dzage = 0.020 * (lpz -  9.000) +  0.028;
  if (lpz >  9.500) dzage = 0.019 * (lpz -  9.500) +  0.039;
  if (lpz > 10.000) dzage = 0.048;
  if (lpz > 10.775) dzage = 0.035 * (lpz - 10.775) +  0.048;
  if (lpz > 11.851) dzage = 0.069 * (lpz - 11.851) +  0.086;
  if (lpz > 12.258) dzage = 0.461 * (lpz - 12.258) +  0.114;
  if (lpz > 12.382) dzage = 0.024 * (lpz - 12.382) +  0.171;
  if (lpz > 13.055) dzage = 0.013 * (lpz - 13.055) +  0.188;
  if (lpz > 14.081) dzage = 0.013 * (lpz - 14.081) +  0.201;
  if (lpz > 15.107) dzage = 0.214;
  zage = zage*Math.pow(10.0,dzage);
//
  zage_Gyr = (Tyr/H0)*zage;
  DTT = 0.0;
  DCMR = 0.0;
// do integral over a=1/(1+z) from az to 1 in n steps, midpoint rule
  for (i = 0; i != n; i++) {
    a = az+(1-az)*(i+0.5)/n;
    adot = Math.sqrt(WK+(WM/a)+(WR/(a*a))+(WV*a*a));
    DTT = DTT + 1/adot;
    DCMR = DCMR + 1/(a*adot);
  };
  DTT = (1-az)*DTT/n;
  DCMR = (1-az)*DCMR/n;
  age = DTT+zage;
  age_Gyr = age*(Tyr/H0);
  DTT_Gyr = (Tyr/H0)*DTT;
  DCMR_Gyr = (Tyr/H0)*DCMR;
  DCMR_Mpc = (c/H0)*DCMR;
  DA = az*DCMT();
  DA_Mpc = (c/H0)*DA;
  kpc_DA = DA_Mpc/206.264806;
  DA_Gyr = (Tyr/H0)*DA;
  DL = DA/(az*az);
  DL_Mpc = (c/H0)*DL;
  DL_Gyr = (Tyr/H0)*DL;
  V_Gpc = 4*Math.PI*Math.pow(0.001*c/H0,3)*VCM();



#### Tangential Comoving Distance
***DCMT***
  var ratio = 1.00;
  var x;
  var y;
  x = Math.sqrt(Math.abs(WK))*DCMR;
  // document.writeln("DCMR = " + DCMR + "<BR>");
  // document.writeln("x = " + x + "<BR>");
  

  if (x > 0.1) {
    ratio =  (WK > 0) ? 0.5*(Math.exp(x)-Math.exp(-x))/x : Math.sin(x)/x;
    
    y = ratio*DCMR;
    return y;
  }
  
  y = x*x
  
// statement below fixed 13-Aug-03 to correct sign error in expansion
  if (WK < 0) {
    y = -y
  }
  ratio = 1 + y/6 + y*y/120
  
  y= ratio*DCMR
  
  return the value of Y


#### Comoving Volume Computation
***VCM***
  var ratio = 1.00;
  var x;
  var y;
  x = Math.sqrt(Math.abs(WK))*DCMR;
  
  if (x > 0.1) {
    ratio =  (WK > 0) ? (0.125*(Math.exp(2*x)-Math.exp(-2*x))-x/2)/(x*x*x/3) :
    (x/2 - Math.sin(2*x)/4)/(x*x*x/3) ;
    y = ratio*DCMR*DCMR*DCMR/3;
    return y;
  };
  
  y = x*x;
  
// statement below fixed 13-Aug-03 to correct sign error in expansion
  if (WK < 0) y = -y;
  ratio = 1 + y/5 + (2/105)*y*y;
  y= ratio*DCMR*DCMR*DCMR/3;
  return y;


------------------------------------------------

It is now 13.721 Gyr since the Big Bang.
 this value is calculated by 

The age at redshift z was 2.171 Gyr.



The light travel time was 11.549 Gyr.
The comoving radial distance, which goes into Hubble's law, is 6481.3 Mpc or 21.139 Gly.
The comoving volume within redshift z is 1140.389 Gpc3.
The angular size distance DA is 1620.3 Mpc or 5.2846 Gly.
This gives a scale of 7.855 kpc/".
The luminosity distance DL is 25924.3 Mpc or 84.554 Gly.
