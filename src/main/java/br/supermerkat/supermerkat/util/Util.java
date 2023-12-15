package br.supermerkat.supermerkat.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

    public static String getDateTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(new Date());
    }
}
