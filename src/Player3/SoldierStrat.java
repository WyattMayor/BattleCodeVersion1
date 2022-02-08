package Player3;

import battlecode.common.*;

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
        Direction dir = RobotPlayer.directions[RobotPlayer.rng.nextInt(RobotPlayer.directions.length)];
        int e = 0, n = 0;
        if (rc.canMove(Direction.EAST) && e < 1) {
            rc.move(Direction.EAST);
        } else if (rc.canMove(Direction.NORTH) && n < 1) {
            e++;
            rc.move(Direction.NORTH);
        } else if (rc.canMove(Direction.SOUTHWEST)) {
            n++;
            rc.move(Direction.SOUTHWEST);
        }
    }
}

