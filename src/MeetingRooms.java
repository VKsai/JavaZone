import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MeetingRooms {

    public static boolean canAttendMeetings(int[][] intervals) {
        int start = 0, end = 1;
        boolean canAttend = false;

        for (int i = 0; i < intervals.length; i++) {

        }

        return canAttend;
    }

    public static void main(String[] args) {
        //Input: [[0,30],[5,10],[15,20]]
        //Output: false

        //Input: [[7,10],[2,4]]
        //Output: true

        int[][] meetingIntervals = {{0, 30}, {25, 50}, {15, 20}};

        System.out.println(canAttendMeetings(meetingIntervals));
    }
}
