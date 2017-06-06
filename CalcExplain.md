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

It is now 13.721 Gyr since the Big Bang.
 this value is calculated by age_Gyr
 given : 
  + Tyr = 977.8 
  + dzage é dado pelo item 
  + |Valor de lpz| Valor de ***dzage***|
  |------------------;|----------------;|
 | lpz >  7.500| 0.002 * (lpz -  7.500)|
 | lpz >  8.000| 0.014 * (lpz -  8.000) +  0.001|
 | lpz >  8.500|  0.040 * (lpz -  8.500) +  0.008|
 | lpz >  9.000|  0.020 * (lpz -  9.000) +  0.028|
 | lpz >  9.500|  0.019 * (lpz -  9.500) +  0.039|
 | lpz > 10.000|  0.048|
 | lpz > 10.775|  0.035 * (lpz - 10.775) +  0.048|
 | lpz > 11.851|  0.069 * (lpz - 11.851) +  0.086|
 | lpz > 12.258|  0.461 * (lpz - 12.258) +  0.114|
 | lpz > 12.382|  0.024 * (lpz - 12.382) +  0.171|
 | lpz > 13.055|  0.013 * (lpz - 13.055) +  0.188|
 | lpz > 14.081|  0.013 * (lpz - 14.081) +  0.201|
 | lpz > 15.107|  0.214|
  + zage = zage * 10.0 ^ dzage ;
  + age = DTT + zage;
 
 age_Gyr = age * (Tyr/H0)
 

The age at redshift z was 2.171 Gyr.
zage_Gyr

The light travel time was 11.549 Gyr.
DTT_Gyr

The comoving radial distance, which goes into Hubbles law, is 6481.3 Mpc or 21.139 Gly.
DCMR_Mpc

The comoving volume within redshift z is 1140.389 Gpc3.
V_Gpc

The angular size distance DA is 1620.3 Mpc or 5.2846 Gly.
DA_Gyr

This gives a scale of 7.855 kpc/s.
kpc_DA

The luminosity distance DL is 25924.3 Mpc or 84.554 Gly.
DL_Mpc
