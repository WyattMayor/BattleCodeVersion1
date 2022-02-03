package Player1;

import battlecode.common.*;

public class LabStrat {
    static int turns = 0;
    public static void runLaboratory(RobotController rc) throws GameActionException {
        if (rc.getTeamLeadAmount(rc.getTeam()) > 200 && rc.canTransmute() && rc.getTeamGoldAmount(rc.getTeam()) < 100){
            rc.transmute();
            turns++;
        } else if(turns >= 1000){
            rc.transmute();
        }
    }
}
