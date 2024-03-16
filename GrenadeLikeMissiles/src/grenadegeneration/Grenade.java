package grenadegeneration;
import java.util.Scanner;
import java.util.Random;

//This java program was made with the Advanced Dungeons and Dragons Dungeons Masters Guide in mind
//This programs will help you understand the results of using a grenade like missle.
public class Grenade {
	//main, where all the magic happens

	public static void main(String[] Args) {
		Scanner input = new Scanner(System.in);
		
		
		for (char multiAttack = 'y'; multiAttack !='n';) {
		System.out.println("Is your grenade [acid], [holy water], [oil], [poison], or [other]?");
		//receiving user input
		
		String grenadeType = input.nextLine();
		grenadeType = grenadeType.toLowerCase();
		
		//This method will help return common grenade information
		type(grenadeType);
		
		//This is where we will diverge into how badly you missed, if you indeed missed.
		System.out.println("Did you miss your target?[y/n]");
		char confirm = Character.toLowerCase(input.next().charAt(0));
		
		
		//this while loop will continue to prompt the user for the correct input
		while (confirm != 'y' && confirm !='n') {
			System.out.println("Invalid input.\nDid you miss your target?[y/n]");
					 confirm = Character.toLowerCase(input.next().charAt(0));
		}
		
		//switch confirm will congratulate you on the hit or ask how badly you picked this fight.
		switch (confirm ) {
		
		case 'y':
			System.out.println("Was your target within short, medium or long range? [s/m/l]");
			char range = Character.toLowerCase(input.next().charAt(0));
			while (range !='s' && range != 'm' && range != 'l') {
				System.out.println("Invalid input.\nWas your target within short, medium or long range? [s/m/l]");
				range = Character.toLowerCase(input.next().charAt(0));
			}
			System.out.println("Your "+grenadeType +" projectile flys out "+ missDirection()+" degrees from the target, missing by " + missDistance(range) +" feet.");
			break;
		case 'n':
			System.out.println("Good Aim");
			break;
		}
			
			System.out.println("Did want to throw another grenade?[y/n]");
			multiAttack = Character.toLowerCase(input.next().charAt(0));
			
			
			//this while loop will continue to prompt the user for the correct input
			while (confirm != 'y' && confirm !='n') {
				System.out.println("Invalid input.\nDid you want to throw another grenade?[y/n]");
						 multiAttack = Character.toLowerCase(input.next().charAt(0));
			}
			input.nextLine();
		}
		input.close();
	}
	public static void type(String grenadeType) {
		
		switch (grenadeType) {
		case "acid": acid();
		break;
		case "holy water": holyWater();
		break;
		case "oil": oil();
		break;
		case "poison": poison();
		break;
		case "other": grenadeType="";
		break;
		default: System.out.println("no case was hit");
		
		}
		
		
		
		
	}
	public static void acid() {
		class acidQualities {
			private int aoeInFeet = 1;
			Random rand = new Random();
			private int max=8, min=2;
			private int directHit = (rand.nextInt(max-min+1) +min);
			private int splashDmg = 1;
			
			
		}
		acidQualities cool = new acidQualities();
		System.out.println("The AOE of the projectile is "+cool.aoeInFeet+" feet. Direct Hit Damage is: " +cool.directHit +" and splash damage is: "+cool.splashDmg);
	}
	
	public static void holyWater() {
		
		class hWaterQualities {
			private int aoeInFeet = 1;
			Random rand = new Random();
			private int max=7, min=2;
			private int directHit = (rand.nextInt(max-min+1) +min);
			private int splashDmg = 1;
			
			
		}
		hWaterQualities cool = new hWaterQualities();
		System.out.println("The AOE of the projectile is a "+cool.aoeInFeet+" foot diameter. Direct Hit Damage is: " +cool.directHit +" and splash damage is: "+cool.splashDmg);
	}
	
	public static void oil() {
		class oilQualities {
			private int aoeInFeet = 3;
			Random rand = new Random();
			
			private int directHitSM = (rand.nextInt(6)+1 + rand.nextInt(6)+1);
			private int directHitL = (rand.nextInt(6)+1);
			private int splashDmg = 1;
			
			
		}
		oilQualities cool = new oilQualities();
		System.out.println("The AOE of the projectile is a "+cool.aoeInFeet+" feet diameter. Direct Hit Damage is: " +cool.directHitSM +" "
				+ " against S/M and " +cool.directHitL+" against Large. Splash damage is: "+cool.splashDmg);
	}
	
	public static void poison() {
		class poisonQualities {
			private int aoeInFeet = 1;
		}
		poisonQualities cool = new poisonQualities();
		System.out.println("The AOE of the projectile is a "+cool.aoeInFeet+" foot diameter. Direct Hit/splash damage is special, refer to DM");
	}
	
	public static int missDirection() {
		int directionMiss = 42069;
		Random rand = new Random();
		
		int directionRoll = (rand.nextInt(10)+1);
		
		switch (directionRoll) {
		case 1: directionMiss = 70;
		break;
		case 2: directionMiss = 0;
		break;
		case 3: directionMiss = 180;
		break;
		case 4: directionMiss = 30;
		break;
		case 5: directionMiss = 150;
		break;
		case 6: directionMiss = 60;
		break;
		case 7: directionMiss = 120;
		break;
		case 8: directionMiss = 90;
		break;
		case 9: directionMiss = 90;
		break;
		case 10:directionMiss = 90;	
		break;
		
		}
		return directionMiss;
	}
	
	public static int missDistance(char range) {
		Random rand = new Random();
		
		int distanceOff =0;
		switch (range) {
		case 's':distanceOff = (rand.nextInt(6)+1) ;
		break;
		case 'm': distanceOff = (rand.nextInt(10)+1);
		break;
		case 'l': distanceOff = ((rand.nextInt(10)+1) + (rand.nextInt(10)+1));
		break;
		
		}
		
		return distanceOff;
	}
	
}
