package linkedlist;

import support.CycleInfo;
import support.LLNode;

public class LinkedListCycleAnalyzer<T> {
    public static <T> CycleInfo detectCycleInfo(LLNode<T> head) {

       LLNode <T> t = head;
       LLNode<T> h = head.getLink();
        boolean noLoop = false;

        while(t != h && !noLoop) {
          try {
              t = t.getLink();
              h = h.getLink().getLink();
          }catch(NullPointerException e) {
              noLoop = true;
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

        int index = -1;

        do {
            if (index != -1) {
                head = head.getLink();
            }

            t = head;

            for (int j = 0; j < i; j++) {
                t = t.getLink();
            }
            index++;
        } while(head != t);

        return new CycleInfo(index, i);
    }
}
