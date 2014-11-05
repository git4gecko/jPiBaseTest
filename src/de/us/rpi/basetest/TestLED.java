package de.us.rpi.basetest;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

/**
 * Simple Test
 * Using GPIO Port 0
 * 
 * @author us
 *
 */
public class TestLED {
	private GpioController gpio = null;
	
	public TestLED() throws Exception {
		init();
	}
			
	public void process() throws Exception {
		System.out.println("Init. and turn led on");
		GpioPinDigitalOutput ledPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "LED1", PinState.HIGH);
	    Thread.sleep(5000);
        
	    System.out.println("Turn led off");
        ledPin.low();
        Thread.sleep(2000);

        System.out.println("Turn led on");
        ledPin.toggle();
        Thread.sleep(5000);

        System.out.println("Turn led off");
        ledPin.toggle();
        
        System.out.println("Shutdown");
        gpio.shutdown();
	}
	
	private void init() throws Exception {
		gpio = GpioFactory.getInstance();
	}

	public static void main(String[] args) {
		TestLED test;
		try {
			test = new TestLED();
			test.process();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
