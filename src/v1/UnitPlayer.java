package v1;

import aic2021.user.*;

import java.lang.Runtime;

//import java.io.FileWriter;
//import java.io.IOException;

public class UnitPlayer {

	public void run(UnitController uc) throws Exception {
		// Code to be executed only at the beginning of the unit's lifespan
		UnitType type = uc.getType();
		//Process p = Runtime.getRuntime().exec("echo 'yourmom'");

		while (true) {
			if (type == UnitType.BASE) {
//				FileWriter observations = new FileWriter("base_obs.txt");

				int i = 1;
				UnitInfo info = uc.getInfo();
				Location loc = uc.getLocation();
				UnitInfo[] units = uc.senseUnits();
				ResourceInfo[] resources = uc.senseResources();
				Location[] detectable = uc.getVisibleLocations();
				for (int j = 0; j < detectable.length; j ++) {
					uc.println(detectable[j]);
				}

				Location[] mountains = uc.senseMountains();
				Location[] traps = uc.senseTraps();
				Location[] water = uc.senseWater(type.getVisionRange());
				FireInfo[] fires = uc.senseFires();
				boolean	canAttack = uc.canAttack();
				boolean	canDeposit = uc.canDeposit();
				boolean canDraw = uc.canDraw(10);
				boolean canGather = uc.canGatherResources();
				boolean canSmoke = uc.canMakeSmokeSignal();
				//boolean canMove = uc.canMove();
				int[] smokeSignals = uc.readSmokeSignals();
				int[] rCarried = uc.getResourcesCarried();
				int food = uc.getResource(Resource.FOOD);
				int wood = uc.getResource(Resource.WOOD);
				int stone = uc.getResource(Resource.STONE);
				int round = uc.getRound();
				int teamTechLevel = uc.getTechLevel(uc.getTeam());
				int oppTechLevel = uc.getTechLevel(uc.getOpponent());
				int unitCount = uc.getTotalUnits();


//				observations.write("Unit Info: \n" + info.toString() + "\n");
			}
			else if (type == UnitType.WORKER) {

			}
			else if (type == UnitType.EXPLORER) {

			}
			else if (type == UnitType.TRAPPER) {

			}
			else if (type == UnitType.AXEMAN) {

			}
			else if (type == UnitType.SPEARMAN) {

			}
			else if (type == UnitType.WOLF) {

			}
			else if (type == UnitType.SETTLEMENT) {

			}
			else if (type == UnitType.BARRACKS) {

			}
			else if (type == UnitType.FARM) {

			}
			else if (type == UnitType.QUARRY) {

			}
			else { // Then it's a sawmill

			}

			// Code to be executed every round
			uc.yield(); // End of turn
		}
	}
}
