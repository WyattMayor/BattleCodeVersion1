package Player1;
import battlecode.common.*;

import java.util.Arrays;
import java.util.Random;

public class ArchonStrat {
    // setting variables to count robots
    static int miners = 0, soldier = 0, builders = 0, turn =0, sages = 0;

    // set parameters for when certain robots should spawn.
    // to start we build miners due to the opponent not attacking right away.
    //Then when led passes 5000 it will start spawning soldiers then builders.
    // if led gets to low then spawn miners
    static void runArchon(RobotController rc) throws GameActionException {
        if(miners < 3 && turn < 500){
            buildTowardsLowRubble(rc, RobotType.MINER);
        } /*else if(soldier < 10 && turn > 550){ //early game
            buildTowardsLowRubble(rc, RobotType.SOLDIER);
        }*/ else if(builders < 2){
            buildTowardsLowRubble(rc, RobotType.BUILDER);
        } /*else if(soldier < 10 && turn >= 1000) {
            buildTowardsLowRubble(rc, RobotType.SOLDIER);
        }*/ else if(sages < 10 && rc.getTeamGoldAmount(rc.getTeam()) >= 20){
            buildTowardsLowRubble(rc, RobotType.SAGE);
        }
        turn++;
    }
        static void buildTowardsLowRubble(RobotController rc, RobotType type) throws GameActionException{

        // builds in specific directions
        Direction[] dirs = Arrays.copyOf(RobotPlayer.directions, RobotPlayer.directions.length);
            Arrays.sort(dirs, (a, b) -> getRubble(rc, a) - getRubble(rc, b));
            for (Direction d : dirs){
                if(rc.canBuildRobot(type, d)){
                    rc.buildRobot(type, d);
                    switch (type){
                        case MINER: miners++; break;
                        case SOLDIER: soldier++; break;
                        case BUILDER: builders++; break;
                        case SAGE: sages++; break;
                        default: break;
                    }
                }
            }
        }
        // sensing the archons surroundings
        static int getRubble(RobotController rc, Direction d){
            try{
                MapLocation loc = rc.getLocation().add(d);
                return  rc.senseRubble(loc);
            } catch (GameActionException e){
                e.printStackTrace();
                return 0;
            }
        }
}
