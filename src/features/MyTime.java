/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package features;

import entities.Users;
import java.util.Date;
import entities.*;
import java.text.SimpleDateFormat;
import models.*;
/**
 *
 * @author HongSon
 */
public class MyTime {
    public static String getTimePeriodFromNow(Date date){
        Date now = new Date();
        long milliseconds = (date.getTime() - now.getTime());
        int seconds = (int)Math.abs((milliseconds / 1000)) % 60 ;
        int minutes = (int)Math.abs((milliseconds / (1000*60)) % 60);
        int hours   = (int)Math.abs((milliseconds / (1000*60*60)) % 24);
        int days   = (int)Math.abs((milliseconds / (1000*60*60)) / 24);
        //System.out.println(hours + "h " + minutes + "' " + seconds + " s trước");
        if(days<1){
            if(hours<1){
                if(minutes<1){
                    return seconds + " s trước";
                }else{
                    return minutes + "' " + seconds + " s trước";
                }
            }else{
                return hours + "h " + minutes + "' " + seconds + " s trước";
            }
        }else{
            return "" + date.getDate() + "/" + date.getMonth() + "/" + (1900+date.getYear()) + " "
                    + date.getHours() + "h" + date.getMinutes() + "'" ;
        }
    }
}
