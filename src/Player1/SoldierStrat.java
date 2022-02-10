package Player1;

import battlecode.common.*;
import java.util.Random;

strictfp class SoldierStrat {
    static void runSoldier(RobotController rc) throws GameActionException {
        // Try to attack someone
        int radius = rc.getType().actionRadiusSquared;
        Team opponent = rc.getTeam().opponent();
        RobotInfo[] enemies = rc.senseNearbyRobots(radius, opponent);
        if (enemies.length > 0) {
            MapLocation toAttack = enemies[0].location;
            if (rc.canAttack(toAttack)) {
                rc.attack(toAttack);
            }
        }
        /*
         sense if archon, then get location, and all soldiers move to enemy archon
                // use getLocation(),create dir of enemy ARCHON then rc.move(dir)
                if (robotType.ARCHON){

                    if (rc.canAttack(toAttack)) {
                        rc.attack(toAttack);
                    }
                }
         Also try to move randomly.
        */

        Direction dir = RobotPlayer.directions[RobotPlayer.rng.nextInt(RobotPlayer.directions.length)];
        /*for (int x : rc.senseNearbyRobots(radius,opponent)){
            if x == RobotType ARCHON;
            Direction toMove = me.directionTo(targetLocation);
                if (rc.canMove(toMove)) {
                    rc.move(toMove);
            }
            else if (rc.canMove(Direction.NORTH)) {
                rc.move(Direction.NORTH);
                System.out.println("I moved!");}
            else if (rc.canMove(Direction.EAST)) {
                rc.move(Direction.EAST);
                System.out.println("I moved!");}
            else if (rc.canMove(Direction.SOUTH)) {
                rc.move(Direction.SOUTH);
                System.out.println("I moved!");}
            else if (rc.canMove(Direction.WEST)) {
                rc.move(Direction.WEST);
                System.out.println("I moved!");} */
        if (rc.canMove(Direction.EAST)) {
            rc.move(Direction.EAST);
        }
    }
}