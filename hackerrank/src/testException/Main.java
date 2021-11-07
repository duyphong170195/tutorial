package testException;

import com.sun.tools.corba.se.idl.constExpr.Not;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Main {

    public static void main(String[] args) throws Exception{
//        Timestamp now = new Timestamp(System.currentTimeMillis());
//        Timestamp now2 = new Timestamp(now.getTime() -1);
//        System.out.println(now);
//        System.out.println(now2.before(now) == false);
//
//
////        Timestamp now = new Timestamp(System.currentTimeMillis());
//
//        LocalDate localDateNow1 = now.toLocalDateTime().toLocalDate();
//        Thread.sleep(4000);
//        LocalDate localDateNow2 = now.toLocalDateTime().toLocalDate();
//        System.out.println(localDateNow2.isAfter(localDateNow1));
//        System.out.println(localDateNow2.isBefore(localDateNow1));

        System.out.println(2*2147483648L);


        System.out.println(LocalDateTime.ofInstant(Instant.ofEpochMilli(1635740014000L), ZoneId.of("America/Los_Angeles")).toString());
        ;
        LocalDateTime localDate1 = Instant.ofEpochMilli(1635740014000L).atZone(ZoneId.of("Asia/Ho_Chi_Minh")).toLocalDateTime();
        System.out.println(localDate1);
        LocalDate localDate = Instant.ofEpochMilli(1635740014000L).atZone(ZoneId.of("Asia/Ho_Chi_Minh")).toLocalDate().plusDays(2);
        System.out.println(localDate);
        LocalDateTime nowAmerica = LocalDateTime.now(ZoneId.of("Europe/Berlin"));
        System.out.println(nowAmerica.toString());

        LocalDateTime nowTokyo = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println(nowTokyo.toString());

        LocalDateTime nowUTC = LocalDateTime.now(ZoneId.of("UTC"));
        System.out.println(nowUTC.toString());

//        System.out.println(localDateNow.toString());
//        LocalDate createdLocalDate = now.toLocalDateTime().toLocalDate().plusDays(2);
//        System.out.println(createdLocalDate.toString());

//        LocalDate date = LocalDate.now().plusDays(2);
//        System.out.println(createdLocalDate.isAfter(createdLocalDate));
//        try {
//            try {
//                int a[] = new int[1];
//                a[2] = 3;
//                throw new NotFoundException("NotFoundException");
//            } catch (Exception e) {
//                throw e;
//            }
//        } catch (NotFoundException e) {
//            System.out.println("InvalidException");
//            throw e;
//        }
    }


}
