/**
 * @(#)meeting.java, 11月 09, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package greed_question;

import java.util.Arrays;

/**
 * @author guochenghui
 */
public class Meeting {


    public int greed(Program[] meeting, int start){
        Arrays.sort(meeting, (a, b)-> a.start - b.start);
        int res = 0;
        for (int i = 0; i < meeting.length; i++) {
            if(start < meeting[i].start){
                res++;
                start = meeting[i].end;
            }
        }
        return res;
    }

}

class Program {
    public int start;
    public int end;
}