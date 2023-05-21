package homework5;

import java.util.Scanner;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random sayi = new Random();


        try {
            System.out.println("Lütfen ödeme tutarınızı giriniz : ");
            String odemeTutari = input.nextLine();
            if (!isInvalidAmountException(odemeTutari)) {
                throw new InvalidAmountException("Geçersiz ödeme tutarı.Negatif bir değer , virgüllü bir değer girilemez.Rakamlardan oluşmalıdır.");
            }

            System.out.println("Lütfen kart numaranızı giriniz : ");
            String kartNumarasi = input.nextLine();
            if (!isInvalidCardNumber(kartNumarasi)) {
                throw new InvalidCardNumberException("Geçersiz kart numarası.16 haneli, rakamlardan oluşan bir kart numarası giriniz.");

            }

            System.out.println("Lütfen kartınızın son kullanım ayını giriniz : ");
            String ay = input.nextLine();
            System.out.println("Lütfen kartınızın son kullanım yılını giriniz : ");
            String yil = input.nextLine();
            if (!isInvalidExpirationDate(ay, yil)) {
                throw new InvalidExpirationDateException("Kartınızın son kullanım ayı 12 den büyük ve son kullanım yılı 2023 den küçük olamaz. Ay ve yıl harf içeremez.");
            }

            System.out.println("Lütfen kartınızın güvenlik kodunu giriniz : ");
            String kod = input.nextLine();
            if (!isInvalidSecurityCode(kod)) {
                throw new InvalidSecurityCodeException("Kartınızın güvenlik kodu 3 haneli olmalı ve harf içermemelidir.");
            }
            System.out.println("Girilen bilgiler doğru.");

        pay();
        }catch(InvalidAmountException e) {
        	System.out.print(e.getMessage());
        }catch(InvalidCardNumberException e) {
        	System.out.print(e.getMessage());
        }catch(InvalidExpirationDateException e) {
        	System.out.print(e.getMessage());
        }catch(InvalidSecurityCodeException e) {
        	System.out.print(e.getMessage());
                
           
        } catch (SystemNotWorkingException e) {
        	
            System.out.println(e.getMessage());
            System.out.println("Tekrar deneyin.");
            try {
            	pay();
            }catch (SystemNotWorkingException b) {
                System.out.println(b.getMessage());
            }

            
            
        }


    }


    private static boolean isInvalidAmountException(String tutar) {
        for (char a : tutar.toCharArray()) {
            if (!Character.isDigit(a)) {
                return false;
            }
        }

        if (tutar.contains(".")) {
            return false;
        }
        int odemeTutari = Integer.parseInt(tutar);

        if (odemeTutari < 0) {
            return false;

        }
        return true;

    }

    private static boolean isInvalidCardNumber(String kartNumarasi) {
        if (kartNumarasi.length() != 16) {
            return false;
        }

        for (char a : kartNumarasi.toCharArray()) {
            if (!Character.isDigit(a)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isInvalidExpirationDate(String ay, String yil) {

        for (char a : ay.toCharArray()) {
            if (!Character.isDigit(a)) {
                return false;
            }

        }

        int yeniAy = Integer.parseInt(ay);

        if (yeniAy > 12) {
            return false;
        }


        for (char a : yil.toCharArray()) {
            if (!Character.isDigit(a)) {
                return false;
            }
        }

        int yeniYil = Integer.parseInt(yil);

        if (yeniYil < 2023) {
            return false;
        }

        return true;
    }

    private static boolean isInvalidSecurityCode(String güvenlikNumarasi) {

        for (char a : güvenlikNumarasi.toCharArray()) {
            if (!Character.isDigit(a)) {
                return false;
            }

        }

        if (güvenlikNumarasi.length() != 3) {
            return false;
        }


        return true;
    }

    public static void pay() throws SystemNotWorkingException {


        Random random = new Random();
        int randomSayi = random.nextInt(101);
        System.out.println("random sayı : " + randomSayi);


        if (randomSayi > 75) {
            throw new SystemNotWorkingException("Sayı 75 den büyük.Sistem tekrar çalışacak.");

        } else {

            System.out.println("ödeme başarılı.");
        }
    }
}
