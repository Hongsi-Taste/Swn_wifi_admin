# Swn_wifi_admin

WiFi_admin application repo for turm_project.

### Releases

An APk for android is available on over android 7.0 

### Development

Record the corresponding values of the currently measured WiFi RSSI values with a list of mac addresses for each predefined floor and process the other non-measured values as zero and send them to the database server.

Data Send protocal : HTTP POST(application/json)

Sending JSON Data TYPE Example : 

{ "Rom_num": 508,  "Floor": 5,  "macs": [ -92,    -95,    0,    -89,    -86,    -63,    -70,    -54,    -63,    -69,    -63,    -77,    -71,    0,    -80,    -73,    0,    0,    0,    0,    0,    0,  ~~~~~~~~~]}

### Building

The project was created using Android Studio, so we recommend building using Android Studio.
