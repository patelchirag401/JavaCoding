package com.test;

public class InterfaceTest {
    interface Gift  { void present(); }
    interface Guest { void present(); }

    interface Presentable extends Gift, Guest { }
    
     class test implements Gift, Guest { 
    	
    	//abstract void method1();
    	 
    	 public void present() {
    		 
    	 }
    	
    }

    public static void main(String[] args) {
        Presentable johnny = new Presentable() {
            @Override public void present() {
                System.out.println("Heeeereee's Johnny!!!");
            }
        };
        johnny.present();                     // "Heeeereee's Johnny!!!"

        ((Gift) johnny).present();            // "Heeeereee's Johnny!!!"
        ((Guest) johnny).present();           // "Heeeereee's Johnny!!!"

        Gift johnnyAsGift = (Gift) johnny;
        johnnyAsGift.present();               // "Heeeereee's Johnny!!!"

        Guest johnnyAsGuest = (Guest) johnny;
        johnnyAsGuest.present();              // "Heeeereee's Johnny!!!"
    }
}