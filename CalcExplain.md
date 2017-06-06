Given Values by the User:
H0, OmegaM, Omega Vac and z

Default Values:
+ Ho = 69.6
+ OmegaM = 0.286
+ Omegavac = 0.714
+ z = 3.000

### Big Bang time
It is now 13.721 Gyr since the Big Bang.
 this value is calculated by age_Gyr

**age_Gyr = age * (Tyr/H0)**

+ age = DTT + zage 
 
 where age is the integral from 0 to 1000 
   age = 0; 
     para (i = 0; i != n; i++) {
       a = az*(i+0.5)/n;
       age = age + 1/suareRoot(WK+(WM/a)+(WR/(a*a))+(WV*a*a));
     };  
+ zage = az*age/n * 10.0 ^ dzage
+ age = DTT +  az*age/n * 10.0 ^ dzage
   
**age_Gyr = DTT +  az*age/n * 10.0 ^ dzage  * (Tyr/H0)**
+ DTT value increase by the integral over a=1/(1+z) from az to 1 in n steps, midpoint rule
+ DTT = (1-az)*DTT/n 
+ az = 1.0/(1+1.0*z)
+ Tyr = 977.8 

**age_Gyr = (1 - (1.0/(1+1.0*z)) )*DTT/n  +  (1.0/(1+1.0*z))*age/n * 10.0 ^ dzage  * (977.8 /H0)**
   
 
### Redsfhit
The age at redshift z is given by the value of zage_Gyr, starting from equation:

**zage_Gyr = (Tyr/H0)*zage**
  
  where age is the integral from 0 to 1000 
   age = 0; 
     para (i = 0; i != n; i++) {
       a = az*(i+0.5)/n;
       adot = Math.sqrt(WK+(WM/a)+(WR/(a*a))+(WV*a*a));
       age = age + 1/suareRoot(WK+(WM/a)+(WR/(a*a))+(WV*a*a));
     };
     
+ zage = az*age/n * 10.0 ^ dzage
+ Tyr = 977.8

**zage_Gyr = (977.8/H0)*az*age/n * 10.0 ^ dzage**

+ az = 1.0/(1+1.0*z)

**zage_Gyr = (977.8/H0)*(1.0/(1+1.0*z))*age/n * 10.0 ^ dzage**

### Lookback Time
 The light travel time was 11.549 Gyr.
 DTT_Gyr

 **DTT_Gyr = (Tyr/H0)*DTT**
 
 + Tyr = 977.8
 + H0 = given by the user

**DTT_Gyr = (Tyr/H0)*DTT**

+ DTTx value increase by the integral over a=1/(1+z) from az to 1 in n steps, midpoint rule
+ DTT = (1-az)*DTTx/n 
+ az = 1.0/(1+1.0*z)

**DTT_Gyr = (Tyr/H0)*(1-(1.0/(1+1.0*z)))*DTT/n**

###  Comoving Radial Distance
The comoving radial distance, which goes into Hubbles law, is 6481.3 Mpc or 21.139 Gly.
DCMR_Mpc

**DCMR_Mpc = (c/H0)*DCMR**

+ c = 299792.458
+ H0 = given by user
+ z = given by user
+ DCMR = (1-az)*DCMRX/n
+ DCMRX = integral over a=1/(1+z) from az to 1 in n steps
+ az = 1.0/(1+1.0*z)
+ n = 1000
+ c = 299792.458

**DCMR_Mpc = (299792.458/H0)*(1-1.0/(1+1.0*z))*DCMRX/1000**


### Comoving Volume Redshift
The comoving volume within redshift z is 1140.389 Gpc3.
V_Gpc

### Angular Size Distance
The angular size distance DA is 1620.3 Mpc or 5.2846 Gly.
DA_Gyr

### Scale
This gives a scale of 7.855 kpc/s.  kpc_DA

**kpc_DA = DA_Mpc/206.264806**

+ DA_Mpc = (c/H0)*DA
+ c = 299792.458
+ H0 = given by user
+ z = given by user
+ DA = az*DCMT()
+ az = 1.0/(1+1.0*z)

** kpc_DA = ( 299792.458 / H0) * ( 1.0/(1+1.0*z) * DCMT() ) / 206.264806**

+ DCMT() = Tangential Comoving Distance

** kpc_DA = ( 299792.458 / H0) * ( 1.0/(1+1.0*z) * DCMT() ) / 206.264806**

  
### The luminosity distance DL is 25924.3 Mpc or 84.554 Gly.
The luminosity dstance is given by the value of DL in units of Mpc. 
Starting from the equation:

**DL_Mpc = (c/H0)*DL**

+ H0 = given by user
+ z = given by user
+ c = 299792.458
+ DA = az*DCMT();
+ az = 1.0/(1+1.0*z)
+ DL = DA/(az*az)

**-> DL_Mpc = ( 299792.458 / H0 ) * ( 1.0/(1+1.0*z) ) * DCMT() / ( 1.0/(1+1.0*z) )^2 **

----------------------------------------------------------------------------------------------

#### Initial values of variables:

|Description | Value |
|---------------:|-------------:|
| index |  i = 0 |
| number of points in integrals | n=1000 |
| number of digits in angular size distance | nda = 1 |
| Hubble constant |H0 = 69.6 |
| Omega(matter) | WM = 0.286 |
| Omega(vacuum) or lambda | WV = 0.714 |
| Omega(radiation) | WR = 0 |
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



|Valor de LPZ| Valor de dzage |
|---------------:|-------------:|
| lpz >  7.500| 0.002 * (lpz -  7.500) |
| lpz >  8.000| 0.014 * (lpz -  8.000) +  0.001 |
| lpz >  8.500|  0.040 * (lpz -  8.500) +  0.008 |
| lpz >  9.000|  0.020 * (lpz -  9.000) +  0.028 |
| lpz >  9.500|  0.019 * (lpz -  9.500) +  0.039 |
| lpz > 10.000|  0.048 |
| lpz > 10.775|  0.035 * (lpz - 10.775) +  0.048 |
| lpz > 11.851|  0.069 * (lpz - 11.851) +  0.086 |
| lpz > 12.258|  0.461 * (lpz - 12.258) +  0.114 |
| lpz > 12.382|  0.024 * (lpz - 12.382) +  0.171 |
| lpz > 13.055|  0.013 * (lpz - 13.055) +  0.188 |
| lpz > 14.081|  0.013 * (lpz - 14.081) +  0.201 |
| lpz > 15.107|  0.214 |



### Methods


#### Tangential Comoving Distance
**DCMT**
DCMT(){
  ratio = 1.00;
  x = sqrt( |WK|  )*DCMR;
  
  if (x > 0.1) {
    ratio =  (WK > 0) ? 0.5*(Math.exp(x)-Math.exp(-x))/x : Math.sin(x)/x;
    y = ratio*DCMR;
    return y;
  }
  y = x*x
  
  statement below fixed 13-Aug-03 to correct sign error in expansion
  if (WK < 0) {
    y = -y
  }
  ratio = 1 + y/6 + y*y/120
  y= ratio*DCMR
  return the value of Y
}


#### Comoving Volume Computation
**VCM**
VCM(){
  ratio = 1.00;
  x = sqrt( |WK| )*DCMR;
  
  if (x > 0.1) {
    ratio =  (WK > 0) ? (0.125*(Math.exp(2*x)-Math.exp(-2*x))-x/2)/(x*x*x/3) :
    (x/2 - sen(2*x)/4)/(x*x*x/3) ;
    y = ratio*DCMR*DCMR*DCMR/3;
    return y;
  };
  
  y = x*x
  
 statement below fixed 13-Aug-03 to correct sign error in expansion
  if (WK < 0) y = -y;
  ratio = 1 + y/5 + (2/105)*y*y;
  y= ratio*DCMR*DCMR*DCMR/3;
  return y;
  
  
#### calculate the actual results
 The method **compute**
  
  Calculate h as H0 /100
  
  Includes 3 massless neutrino species, T0 = 2.72528
  WR = 4.165E-5/(h*h);	
  WK = 1-WM-WR-WV;
  
  Scale Factor
  az = 1.0/(1+1.0*z);
  
  age = 0; 
  para (i = 0; i != n; i++) {
    a = az*(i+0.5)/n;
    adot = Math.sqrt(WK+(WM/a)+(WR/(a*a))+(WV*a*a));
    age = age + 1/suareRoot(WK+(WM/a)+(WR/(a*a))+(WV*a*a));
  };
  zage = az*age/n
  
 correction for annihilations of particles not present now like e+/e-
 added 13-Aug-03 based on T_vs_t.f
 
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

  zage_Gyr = (Tyr/H0)*zage;
  DTT = 0.0;
  DCMR = 0.0;
  
** do integral over a=1/(1+z) from az to 1 in n steps, midpoint rule**
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

