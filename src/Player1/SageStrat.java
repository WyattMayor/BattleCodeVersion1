package Player1;

import battlecode.common.*;

public class SageStrat {
    static void runSage(RobotController rc) throws GameActionException {
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
        Direction dir = RobotPlayer.directions[RobotPlayer.rng.nextInt(RobotPlayer.directions.length)];
        if (rc.canMove(dir)) {
            rc.move(dir);
            System.out.println("I moved!");
        }
    }
}
