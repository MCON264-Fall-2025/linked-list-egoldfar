package linkedlist;

import support.CycleInfo;
import support.LLNode;

public class LinkedListCycleAnalyzer<T> {
    public static <T> CycleInfo detectCycleInfo(LLNode<T> head) {

       LLNode <T> t = head;
       LLNode<T> h = head;
        LLNode <T> meetingPoint;
        boolean noLoop = true;

        while (h != null && h.getLink() != null && noLoop) {
            t = t.getLink();
            h = h.getLink().getLink();
            if (t == h) {
                noLoop = false;
            }
        }


        if(noLoop) {
            return new CycleInfo(-1, 0);
        }

        int i = 0;
        do{
            t = t.getLink();
            i++;
        }while (t != h);

        int index = 0;
        meetingPoint = h;

        while (head != meetingPoint) {
            head = head.getLink();
            meetingPoint = meetingPoint.getLink();
            index++;
        }

        return new CycleInfo(index, i);
    }
}
