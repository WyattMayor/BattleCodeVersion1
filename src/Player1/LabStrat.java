package Player1;

import battlecode.common.*;

public class LabStrat {
    public static void runLaboratory(RobotController rc) throws GameActionException {
        if (rc.getTeamLeadAmount(rc.getTeam()) > 200 && rc.canTransmute() && rc.getTeamGoldAmount(rc.getTeam()) < 100){
            rc.transmute();
        }
    }
}
