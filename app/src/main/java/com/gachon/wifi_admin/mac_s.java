package com.gachon.wifi_admin;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class mac_s {

    ArrayList<String> mac_5 = null;

    ArrayList<String> mac_4 = null;

    ArrayList<String> mac_2 = null;

    public mac_s(){
        mac_add5();
        mac_add4();
    }

    public void mac_add5(){
        mac_5 = new ArrayList<String>();

        mac_5.add("9e:21:92");
        mac_5.add("9e:21:72");
        mac_5.add("9f:2b:12");
        mac_5.add("a0:cb:22");	mac_5.add("a0:70:60");	mac_5.add("9e:d1:42");	mac_5.add("9e:d1:42");
        mac_5.add("9e:d1:22");	mac_5.add("a1:0f:32");	mac_5.add("9f:14:c0");	mac_5.add("a1:0f:12");
        mac_5.add("a1:59:d2");	mac_5.add("a1:59:b2");	mac_5.add("a0:fe:50");	mac_5.add("9e:c3:12");
        mac_5.add("9e:c3:32");	mac_5.add("a0:df:c2");	mac_5.add("a0:df:a2");	mac_5.add("9f:51:82");
        mac_5.add("a0:0b:82");	mac_5.add("9f:51:62");	mac_5.add("a0:0b:62");	mac_5.add("9f:70:72");
        mac_5.add("9f:70:52");	mac_5.add("a0:ae:d2");	mac_5.add("9e:16:22");	mac_5.add("9e:e1:32");
        mac_5.add("9e:16:02");	mac_5.add("a0:ae:b2");	mac_5.add("9d:fb:f2");	mac_5.add("9d:fc:12");
        mac_5.add("a1:09:92");	mac_5.add("a1:09:72");	mac_5.add("a1:94:f2");	mac_5.add("a1:95:12");
        mac_5.add("9d:e7:10");	mac_5.add("a1:07:b2");	mac_5.add("9d:e6:f0");	mac_5.add("9e:c0:c2");
        mac_5.add("a1:07:92");	mac_5.add("9e:c0:a2");	mac_5.add("a0:62:c0");	mac_5.add("a0:62:e0");
        mac_5.add("a1:72:02");	mac_5.add("a1:71:e2");	mac_5.add("9f:3d:12");	mac_5.add("9f:3c:f2");
        mac_5.add("9f:2a:f2");	mac_5.add("9f:ae:e2");	mac_5.add("9f:ae:c2");	mac_5.add("9f:38:12");
        mac_5.add("9f:38:32");	mac_5.add("a0:ac:02");	mac_5.add("a0:ab:e2");	mac_5.add("a0:24:a2");
        mac_5.add("a0:24:82");	mac_5.add("a0:cb:02");

    }

    public void mac_add4(){

        mac_4 = new ArrayList<String>();
        mac_4.add("a1:00:c2");
        mac_4.add("a0:34:f0");	mac_4.add("9e:72:f2");	mac_4.add("a1:00:a2");	mac_4.add("9e:fa:82");
        mac_4.add("9e:fa:62");	mac_4.add("a0:34:d0");	mac_4.add("a0:ce:82");	mac_4.add("a0:ce:62");
        mac_4.add("9f:82:42");	mac_4.add("9e:7e:42");	mac_4.add("9e:7e:62");	mac_4.add("a0:8a:12");
        mac_4.add("9d:d8:72");	mac_4.add("a0:89:f2");	mac_4.add("9d:d8:52");	mac_4.add("9e:54:62");
        mac_4.add("9f:82:22");	mac_4.add("9f:f9:82");	mac_4.add("9f:f9:62");	mac_4.add("9f:ba:b2");
        mac_4.add("a1:08:d2");	mac_4.add("a1:08:b2");	mac_4.add("9f:ba:92");	mac_4.add("9f:38:92");
        mac_4.add("9e:24:30");	mac_4.add("a1:88:f2");	mac_4.add("9d:df:02");	mac_4.add("a1:89:12");
        mac_4.add("9d:de:e2");	mac_4.add("9f:38:72");	mac_4.add("9e:84:32");	mac_4.add("9e:84:12");
        mac_4.add("a0:3d:02");	mac_4.add("a0:3c:e2");	mac_4.add("9d:f1:32");	mac_4.add("9f:c4:22");
        mac_4.add("9f:c4:42");	mac_4.add("9f:ea:b0");	mac_4.add("9d:f1:12");	mac_4.add("9f:fb:32");
        mac_4.add("9f:fb:12");	mac_4.add("9f:83:92");	mac_4.add("9f:82:72");	mac_4.add("9e:8a:92");
        mac_4.add("9e:8a:72");	mac_4.add("9f:83:72");	mac_4.add("9e:72:d2");	mac_4.add("a1:6f:92");
        mac_4.add("a1:6f:72");	mac_4.add("a0:1f:90");	mac_4.add("a0:1f:70");	mac_4.add("9f:03:e2");
        mac_4.add("9e:3f:00");	mac_4.add("9e:3e:e0");	mac_4.add("9f:03:c2");	mac_4.add("9e:05:72");
        mac_4.add("a1:22:80");	mac_4.add("9e:05:52");	mac_4.add("9e:2d:02");	mac_4.add("a1:22:60");
        mac_4.add("9e:2c:e2");	mac_4.add("a0:fe:e0");	mac_4.add("a0:fe:c0");

    }

    public void mac_add2(){
        mac_2 = new ArrayList<String>();
    }

    public int find5Mac(String mac){

        return mac_5.indexOf(mac);

    }

    public int find4Mac(String mac){

        return mac_4.indexOf(mac);

    }

    public int find2Mac(String mac){

        return mac_2.indexOf(mac);

    }

}
